package io.netty.resolver.dns;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoop;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.handler.codec.dns.DefaultDnsQuestion;
import io.netty.handler.codec.dns.DefaultDnsRecordDecoder;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsRawRecord;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsRecordType;
import io.netty.handler.codec.dns.DnsResponse;
import io.netty.handler.codec.dns.DnsResponseCode;
import io.netty.handler.codec.dns.DnsSection;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.a;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.ThrowableUtil;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class DnsResolveContext<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    final DnsRecord[] additionals;
    private int allowedQueries;
    private boolean completeEarly;
    private final int dnsClass;
    private final DnsRecordType[] expectedTypes;
    private List<T> finalResult;
    private final String hostname;
    private final int maxAllowedQueries;
    private final DnsServerAddressStream nameServerAddrs;
    private final Promise<?> originalPromise;
    final DnsNameResolver parent;
    private final Set<Future<AddressedEnvelope<DnsResponse, InetSocketAddress>>> queriesInProgress = Collections.newSetFromMap(new IdentityHashMap());
    private boolean triedCNAME;
    private static final RuntimeException NXDOMAIN_QUERY_FAILED_EXCEPTION = (RuntimeException) ThrowableUtil.unknownStackTrace(DnsResolveContextException.newStatic("No answer found and NXDOMAIN response code returned"), DnsResolveContext.class, "onResponse(..)");
    private static final RuntimeException CNAME_NOT_FOUND_QUERY_FAILED_EXCEPTION = (RuntimeException) ThrowableUtil.unknownStackTrace(DnsResolveContextException.newStatic("No matching CNAME record found"), DnsResolveContext.class, "onResponseCNAME(..)");
    private static final RuntimeException NO_MATCHING_RECORD_QUERY_FAILED_EXCEPTION = (RuntimeException) ThrowableUtil.unknownStackTrace(DnsResolveContextException.newStatic("No matching record type found"), DnsResolveContext.class, "onResponseAorAAAA(..)");
    private static final RuntimeException UNRECOGNIZED_TYPE_QUERY_FAILED_EXCEPTION = (RuntimeException) ThrowableUtil.unknownStackTrace(new RuntimeException("Response type was unrecognized"), DnsResolveContext.class, "onResponse(..)");
    private static final RuntimeException NAME_SERVERS_EXHAUSTED_EXCEPTION = (RuntimeException) ThrowableUtil.unknownStackTrace(DnsResolveContextException.newStatic("No name servers returned an answer"), DnsResolveContext.class, "tryToFinishResolve(..)");

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class AuthoritativeNameServerList {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private AuthoritativeNameServer head;
        private int nameServerCount;
        private final String questionName;

        AuthoritativeNameServerList(String str) {
            this.questionName = str.toLowerCase(Locale.US);
        }

        private static void cache(AuthoritativeNameServer authoritativeNameServer, AuthoritativeDnsServerCache authoritativeDnsServerCache, EventLoop eventLoop) {
            if (!authoritativeNameServer.isRootServer()) {
                authoritativeDnsServerCache.cache(authoritativeNameServer.domainName, authoritativeNameServer.address, authoritativeNameServer.ttl, eventLoop);
            }
        }

        private static void cacheUnresolved(AuthoritativeNameServer authoritativeNameServer, AuthoritativeDnsServerCache authoritativeDnsServerCache, EventLoop eventLoop) {
            authoritativeNameServer.address = InetSocketAddress.createUnresolved(authoritativeNameServer.nsName, 53);
            cache(authoritativeNameServer, authoritativeDnsServerCache, eventLoop);
        }

        void add(DnsRecord dnsRecord) {
            String decodeDomainName;
            if (dnsRecord.type() == DnsRecordType.NS && (dnsRecord instanceof DnsRawRecord) && this.questionName.length() >= dnsRecord.name().length()) {
                String lowerCase = dnsRecord.name().toLowerCase(Locale.US);
                int length = lowerCase.length() - 1;
                int length2 = this.questionName.length() - 1;
                int i = 0;
                while (length >= 0) {
                    char charAt = lowerCase.charAt(length);
                    if (this.questionName.charAt(length2) == charAt) {
                        if (charAt == '.') {
                            i++;
                        }
                        length--;
                        length2--;
                    } else {
                        return;
                    }
                }
                AuthoritativeNameServer authoritativeNameServer = this.head;
                if ((authoritativeNameServer == null || authoritativeNameServer.dots <= i) && (decodeDomainName = DnsResolveContext.decodeDomainName(((ByteBufHolder) dnsRecord).content())) != null) {
                    AuthoritativeNameServer authoritativeNameServer2 = this.head;
                    if (authoritativeNameServer2 == null || authoritativeNameServer2.dots < i) {
                        this.nameServerCount = 1;
                        this.head = new AuthoritativeNameServer(i, dnsRecord.timeToLive(), lowerCase, decodeDomainName);
                    } else if (this.head.dots == i) {
                        AuthoritativeNameServer authoritativeNameServer3 = this.head;
                        while (true) {
                            AuthoritativeNameServer authoritativeNameServer4 = authoritativeNameServer3.next;
                            if (authoritativeNameServer4 != null) {
                                authoritativeNameServer3 = authoritativeNameServer4;
                            } else {
                                authoritativeNameServer3.next = new AuthoritativeNameServer(i, dnsRecord.timeToLive(), lowerCase, decodeDomainName);
                                this.nameServerCount++;
                                return;
                            }
                        }
                    }
                }
            }
        }

        List<InetSocketAddress> addressList() {
            ArrayList arrayList = new ArrayList(this.nameServerCount);
            for (AuthoritativeNameServer authoritativeNameServer = this.head; authoritativeNameServer != null; authoritativeNameServer = authoritativeNameServer.next) {
                if (authoritativeNameServer.address != null) {
                    arrayList.add(authoritativeNameServer.address);
                }
            }
            return arrayList;
        }

        void handleWithAdditional(DnsNameResolver dnsNameResolver, DnsRecord dnsRecord, AuthoritativeDnsServerCache authoritativeDnsServerCache) {
            AuthoritativeNameServer authoritativeNameServer = this.head;
            String name = dnsRecord.name();
            InetAddress decodeAddress = DnsAddressDecoder.decodeAddress(dnsRecord, name, dnsNameResolver.isDecodeIdn());
            if (decodeAddress != null) {
                while (authoritativeNameServer != null) {
                    if (authoritativeNameServer.nsName.equalsIgnoreCase(name)) {
                        if (authoritativeNameServer.address != null) {
                            while (true) {
                                AuthoritativeNameServer authoritativeNameServer2 = authoritativeNameServer.next;
                                if (authoritativeNameServer2 == null || !authoritativeNameServer2.isCopy) {
                                    break;
                                }
                                authoritativeNameServer = authoritativeNameServer2;
                            }
                            AuthoritativeNameServer authoritativeNameServer3 = new AuthoritativeNameServer(authoritativeNameServer);
                            authoritativeNameServer3.next = authoritativeNameServer.next;
                            authoritativeNameServer.next = authoritativeNameServer3;
                            this.nameServerCount++;
                            authoritativeNameServer = authoritativeNameServer3;
                        }
                        authoritativeNameServer.update(dnsNameResolver.newRedirectServerAddress(decodeAddress), dnsRecord.timeToLive());
                        cache(authoritativeNameServer, authoritativeDnsServerCache, dnsNameResolver.executor());
                        return;
                    }
                    authoritativeNameServer = authoritativeNameServer.next;
                }
            }
        }

        void handleWithoutAdditionals(DnsNameResolver dnsNameResolver, DnsCache dnsCache, AuthoritativeDnsServerCache authoritativeDnsServerCache) {
            InetAddress address;
            AuthoritativeNameServer authoritativeNameServer = this.head;
            while (authoritativeNameServer != null) {
                if (authoritativeNameServer.address == null) {
                    cacheUnresolved(authoritativeNameServer, authoritativeDnsServerCache, dnsNameResolver.executor());
                    List<? extends DnsCacheEntry> list = dnsCache.get(authoritativeNameServer.nsName, null);
                    if (!(list == null || list.isEmpty() || (address = ((DnsCacheEntry) list.get(0)).address()) == null)) {
                        authoritativeNameServer.update(dnsNameResolver.newRedirectServerAddress(address));
                        int i = 1;
                        while (i < list.size()) {
                            InetAddress address2 = ((DnsCacheEntry) list.get(i)).address();
                            AuthoritativeNameServer authoritativeNameServer2 = new AuthoritativeNameServer(authoritativeNameServer);
                            authoritativeNameServer2.next = authoritativeNameServer.next;
                            authoritativeNameServer.next = authoritativeNameServer2;
                            authoritativeNameServer2.update(dnsNameResolver.newRedirectServerAddress(address2));
                            this.nameServerCount++;
                            i++;
                            authoritativeNameServer = authoritativeNameServer2;
                        }
                    }
                }
                authoritativeNameServer = authoritativeNameServer.next;
            }
        }

        boolean isEmpty() {
            return this.nameServerCount == 0;
        }
    }

    /* loaded from: classes3.dex */
    private final class CombinedDnsServerAddressStream implements DnsServerAddressStream {
        private final DnsServerAddressStream originalStream;
        private final InetSocketAddress replaced;
        private Iterator<InetAddress> resolved;
        private final List<InetAddress> resolvedAddresses;

        CombinedDnsServerAddressStream(InetSocketAddress inetSocketAddress, List<InetAddress> list, DnsServerAddressStream dnsServerAddressStream) {
            this.replaced = inetSocketAddress;
            this.resolvedAddresses = list;
            this.originalStream = dnsServerAddressStream;
            this.resolved = list.iterator();
        }

        private InetSocketAddress nextResolved0() {
            return DnsResolveContext.this.parent.newRedirectServerAddress(this.resolved.next());
        }

        @Override // io.netty.resolver.dns.DnsServerAddressStream
        public DnsServerAddressStream duplicate() {
            return new CombinedDnsServerAddressStream(this.replaced, this.resolvedAddresses, this.originalStream.duplicate());
        }

        @Override // io.netty.resolver.dns.DnsServerAddressStream
        public InetSocketAddress next() {
            if (this.resolved.hasNext()) {
                return nextResolved0();
            }
            InetSocketAddress next = this.originalStream.next();
            if (!next.equals(this.replaced)) {
                return next;
            }
            this.resolved = this.resolvedAddresses.iterator();
            return nextResolved0();
        }

        @Override // io.netty.resolver.dns.DnsServerAddressStream
        public int size() {
            return (this.originalStream.size() + this.resolvedAddresses.size()) - 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class DnsAddressStreamList extends AbstractList<InetSocketAddress> {
        private List<InetSocketAddress> addresses;
        private final DnsServerAddressStream duplicate;

        DnsAddressStreamList(DnsServerAddressStream dnsServerAddressStream) {
            this.duplicate = dnsServerAddressStream.duplicate();
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<InetSocketAddress> iterator() {
            return new Iterator<InetSocketAddress>() { // from class: io.netty.resolver.dns.DnsResolveContext.DnsAddressStreamList.1
                private int i;
                private final DnsServerAddressStream stream;

                {
                    this.stream = DnsAddressStreamList.this.duplicate.duplicate();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.i < this.stream.size();
                }

                @Override // java.util.Iterator
                public void remove() {
                    throw new UnsupportedOperationException();
                }

                @Override // java.util.Iterator
                public InetSocketAddress next() {
                    if (hasNext()) {
                        this.i++;
                        return this.stream.next();
                    }
                    throw new NoSuchElementException();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.duplicate.size();
        }

        @Override // java.util.AbstractList, java.util.List
        public InetSocketAddress get(int i) {
            if (this.addresses == null) {
                DnsServerAddressStream duplicate = this.duplicate.duplicate();
                this.addresses = new ArrayList(size());
                for (int i2 = 0; i2 < duplicate.size(); i2++) {
                    this.addresses.add(duplicate.next());
                }
            }
            return this.addresses.get(i);
        }
    }

    /* loaded from: classes3.dex */
    static final class DnsResolveContextException extends RuntimeException {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private DnsResolveContextException(String str) {
            super(str);
        }

        static DnsResolveContextException newStatic(String str) {
            if (PlatformDependent.javaVersion() >= 7) {
                return new DnsResolveContextException(str, true);
            }
            return new DnsResolveContextException(str);
        }

        @SuppressJava6Requirement(reason = "uses Java 7+ Exception.<init>(String, Throwable, boolean, boolean) but is guarded by version checks")
        private DnsResolveContextException(String str, boolean z) {
            super(str, null, false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class RedirectAuthoritativeDnsServerCache implements AuthoritativeDnsServerCache {
        private final AuthoritativeDnsServerCache wrapped;

        RedirectAuthoritativeDnsServerCache(AuthoritativeDnsServerCache authoritativeDnsServerCache) {
            this.wrapped = authoritativeDnsServerCache;
        }

        @Override // io.netty.resolver.dns.AuthoritativeDnsServerCache
        public void cache(String str, InetSocketAddress inetSocketAddress, long j, EventLoop eventLoop) {
            this.wrapped.cache(str, inetSocketAddress, j, eventLoop);
        }

        @Override // io.netty.resolver.dns.AuthoritativeDnsServerCache
        public void clear() {
            this.wrapped.clear();
        }

        @Override // io.netty.resolver.dns.AuthoritativeDnsServerCache
        public DnsServerAddressStream get(String str) {
            return null;
        }

        @Override // io.netty.resolver.dns.AuthoritativeDnsServerCache
        public boolean clear(String str) {
            return this.wrapped.clear(str);
        }
    }

    /* loaded from: classes3.dex */
    private static final class SearchDomainUnknownHostException extends UnknownHostException {
        private static final long serialVersionUID = -8573510133644997085L;

        SearchDomainUnknownHostException(Throwable th, String str) {
            super("Search domain query failed. Original hostname: '" + str + "' " + th.getMessage());
            setStackTrace(th.getStackTrace());
            initCause(th.getCause());
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DnsResolveContext(DnsNameResolver dnsNameResolver, Promise<?> promise, String str, int i, DnsRecordType[] dnsRecordTypeArr, DnsRecord[] dnsRecordArr, DnsServerAddressStream dnsServerAddressStream) {
        this.parent = dnsNameResolver;
        this.originalPromise = promise;
        this.hostname = str;
        this.dnsClass = i;
        this.expectedTypes = dnsRecordTypeArr;
        this.additionals = dnsRecordArr;
        this.nameServerAddrs = (DnsServerAddressStream) ObjectUtil.checkNotNull(dnsServerAddressStream, "nameServerAddrs");
        int maxQueriesPerResolve = dnsNameResolver.maxQueriesPerResolve();
        this.maxAllowedQueries = maxQueriesPerResolve;
        this.allowedQueries = maxQueriesPerResolve;
    }

    private static Map<String, String> buildAliasMap(DnsResponse dnsResponse, DnsCnameCache dnsCnameCache, EventLoop eventLoop) {
        String decodeDomainName;
        int count = dnsResponse.count(DnsSection.ANSWER);
        HashMap hashMap = null;
        for (int i = 0; i < count; i++) {
            DnsRecord recordAt = dnsResponse.recordAt(DnsSection.ANSWER, i);
            if (recordAt.type() == DnsRecordType.CNAME && (recordAt instanceof DnsRawRecord) && (decodeDomainName = decodeDomainName(((ByteBufHolder) recordAt).content())) != null) {
                if (hashMap == null) {
                    hashMap = new HashMap(Math.min(8, count));
                }
                String name = recordAt.name();
                Locale locale = Locale.US;
                String lowerCase = name.toLowerCase(locale);
                String lowerCase2 = decodeDomainName.toLowerCase(locale);
                String hostnameWithDot = hostnameWithDot(lowerCase);
                String hostnameWithDot2 = hostnameWithDot(lowerCase2);
                if (!hostnameWithDot.equalsIgnoreCase(hostnameWithDot2)) {
                    dnsCnameCache.cache(hostnameWithDot, hostnameWithDot2, recordAt.timeToLive(), eventLoop);
                    hashMap.put(lowerCase, lowerCase2);
                }
            }
        }
        return hashMap != null ? hashMap : Collections.emptyMap();
    }

    private static void checkCnameLoop(String str, String str2, String str3) throws UnknownHostException {
        if (str2.equals(str3)) {
            throw new UnknownHostException("CNAME loop detected for '" + str + '\'');
        }
    }

    static String cnameResolveFromCache(DnsCnameCache dnsCnameCache, String str) throws UnknownHostException {
        String str2 = dnsCnameCache.get(hostnameWithDot(str));
        if (str2 == null) {
            return str;
        }
        String str3 = dnsCnameCache.get(hostnameWithDot(str2));
        if (str3 == null) {
            return str2;
        }
        checkCnameLoop(str, str2, str3);
        return cnameResolveFromCacheLoop(dnsCnameCache, str, str2, str3);
    }

    private static String cnameResolveFromCacheLoop(DnsCnameCache dnsCnameCache, String str, String str2, String str3) throws UnknownHostException {
        boolean z = false;
        while (true) {
            String str4 = dnsCnameCache.get(hostnameWithDot(str3));
            if (str4 == null) {
                return str3;
            }
            checkCnameLoop(str, str2, str4);
            if (z) {
                str2 = dnsCnameCache.get(str2);
            }
            z = !z;
            str3 = str4;
        }
    }

    static String decodeDomainName(ByteBuf byteBuf) {
        byteBuf.markReaderIndex();
        try {
            return DefaultDnsRecordDecoder.decodeName(byteBuf);
        } catch (CorruptedFrameException unused) {
            return null;
        } finally {
            byteBuf.resetReaderIndex();
        }
    }

    private static AuthoritativeNameServerList extractAuthoritativeNameServers(String str, DnsResponse dnsResponse) {
        int count = dnsResponse.count(DnsSection.AUTHORITY);
        if (count == 0) {
            return null;
        }
        AuthoritativeNameServerList authoritativeNameServerList = new AuthoritativeNameServerList(str);
        for (int i = 0; i < count; i++) {
            authoritativeNameServerList.add(dnsResponse.recordAt(DnsSection.AUTHORITY, i));
        }
        if (authoritativeNameServerList.isEmpty()) {
            return null;
        }
        return authoritativeNameServerList;
    }

    private void finishResolve(Promise<List<T>> promise, Throwable th) {
        if (!this.completeEarly && !this.queriesInProgress.isEmpty()) {
            Iterator<Future<AddressedEnvelope<DnsResponse, InetSocketAddress>>> it = this.queriesInProgress.iterator();
            while (it.hasNext()) {
                it.remove();
                it.next().cancel(false);
            }
        }
        if (this.finalResult == null) {
            int i = this.maxAllowedQueries - this.allowedQueries;
            StringBuilder sb = new StringBuilder(64);
            sb.append("failed to resolve '");
            sb.append(this.hostname);
            sb.append('\'');
            if (i > 1) {
                if (i < this.maxAllowedQueries) {
                    sb.append(" after ");
                    sb.append(i);
                    sb.append(" queries ");
                } else {
                    sb.append(". Exceeded max queries per resolve ");
                    sb.append(this.maxAllowedQueries);
                    sb.append(' ');
                }
            }
            UnknownHostException unknownHostException = new UnknownHostException(sb.toString());
            if (th == null) {
                cache(this.hostname, this.additionals, unknownHostException);
            } else {
                unknownHostException.initCause(th);
            }
            promise.tryFailure(unknownHostException);
        } else if (!promise.isDone()) {
            DnsNameResolver.trySuccess(promise, filterResults(this.finalResult));
        }
    }

    private void followCname(DnsQuestion dnsQuestion, String str, DnsQueryLifecycleObserver dnsQueryLifecycleObserver, Promise<List<T>> promise) {
        try {
            String cnameResolveFromCache = cnameResolveFromCache(cnameCache(), str);
            DnsServerAddressStream nameServers = getNameServers(cnameResolveFromCache);
            DefaultDnsQuestion defaultDnsQuestion = new DefaultDnsQuestion(cnameResolveFromCache, dnsQuestion.type(), this.dnsClass);
            query(nameServers, 0, defaultDnsQuestion, dnsQueryLifecycleObserver.queryCNAMEd(defaultDnsQuestion), true, promise, null);
        } catch (Throwable th) {
            dnsQueryLifecycleObserver.queryFailed(th);
            PlatformDependent.throwException(th);
        }
    }

    private DnsServerAddressStream getNameServers(String str) {
        DnsServerAddressStream nameServersFromCache = getNameServersFromCache(str);
        return nameServersFromCache == null ? this.parent.newNameServerAddressStream(str) : nameServersFromCache;
    }

    private DnsServerAddressStream getNameServersFromCache(String str) {
        DnsServerAddressStream dnsServerAddressStream;
        int length = str.length();
        if (length == 0) {
            return null;
        }
        if (str.charAt(length - 1) != '.') {
            str = str + ".";
        }
        int indexOf = str.indexOf(46);
        if (indexOf == str.length() - 1) {
            return null;
        }
        do {
            str = str.substring(indexOf + 1);
            indexOf = str.indexOf(46);
            if (indexOf <= 0 || indexOf == str.length() - 1) {
                return null;
            }
            dnsServerAddressStream = authoritativeDnsServerCache().get(str);
        } while (dnsServerAddressStream == null);
        return dnsServerAddressStream;
    }

    private boolean handleRedirect(DnsQuestion dnsQuestion, AddressedEnvelope<DnsResponse, InetSocketAddress> addressedEnvelope, DnsQueryLifecycleObserver dnsQueryLifecycleObserver, Promise<List<T>> promise) {
        AuthoritativeNameServerList extractAuthoritativeNameServers;
        DnsResponse content = addressedEnvelope.content();
        if (content.count(DnsSection.ANSWER) == 0 && (extractAuthoritativeNameServers = extractAuthoritativeNameServers(dnsQuestion.name(), content)) != null) {
            int count = content.count(DnsSection.ADDITIONAL);
            AuthoritativeDnsServerCache authoritativeDnsServerCache = authoritativeDnsServerCache();
            for (int i = 0; i < count; i++) {
                DnsRecord recordAt = content.recordAt(DnsSection.ADDITIONAL, i);
                if ((recordAt.type() != DnsRecordType.A || this.parent.supportsARecords()) && (recordAt.type() != DnsRecordType.AAAA || this.parent.supportsAAAARecords())) {
                    extractAuthoritativeNameServers.handleWithAdditional(this.parent, recordAt, authoritativeDnsServerCache);
                }
            }
            extractAuthoritativeNameServers.handleWithoutAdditionals(this.parent, resolveCache(), authoritativeDnsServerCache);
            DnsServerAddressStream newRedirectDnsServerStream = this.parent.newRedirectDnsServerStream(dnsQuestion.name(), extractAuthoritativeNameServers.addressList());
            if (newRedirectDnsServerStream != null) {
                query(newRedirectDnsServerStream, 0, dnsQuestion, dnsQueryLifecycleObserver.queryRedirected(new DnsAddressStreamList(newRedirectDnsServerStream)), true, promise, null);
                return true;
            }
        }
        return false;
    }

    private boolean hasNDots() {
        int i = 0;
        for (int length = this.hostname.length() - 1; length >= 0; length--) {
            if (this.hostname.charAt(length) == '.' && (i = i + 1) >= this.parent.ndots()) {
                return true;
            }
        }
        return false;
    }

    private static String hostnameWithDot(String str) {
        if (StringUtil.endsWith(str, '.')) {
            return str;
        }
        return str + '.';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void internalResolve(String str, Promise<List<T>> promise) {
        try {
            String cnameResolveFromCache = cnameResolveFromCache(cnameCache(), str);
            try {
                DnsServerAddressStream nameServers = getNameServers(cnameResolveFromCache);
                int length = this.expectedTypes.length - 1;
                for (int i = 0; i < length; i++) {
                    if (!query(cnameResolveFromCache, this.expectedTypes[i], nameServers.duplicate(), false, promise)) {
                        return;
                    }
                }
                query(cnameResolveFromCache, this.expectedTypes[length], nameServers, false, promise);
            } finally {
                this.parent.flushQueries();
            }
        } catch (Throwable th) {
            promise.tryFailure(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DnsQueryLifecycleObserver newDnsQueryLifecycleObserver(DnsQuestion dnsQuestion) {
        return this.parent.dnsQueryLifecycleObserverFactory().newDnsQueryLifecycleObserver(dnsQuestion);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void onExpectedResponse(io.netty.handler.codec.dns.DnsQuestion r16, io.netty.channel.AddressedEnvelope<io.netty.handler.codec.dns.DnsResponse, java.net.InetSocketAddress> r17, io.netty.resolver.dns.DnsQueryLifecycleObserver r18, io.netty.util.concurrent.Promise<java.util.List<T>> r19) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.resolver.dns.DnsResolveContext.onExpectedResponse(io.netty.handler.codec.dns.DnsQuestion, io.netty.channel.AddressedEnvelope, io.netty.resolver.dns.DnsQueryLifecycleObserver, io.netty.util.concurrent.Promise):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResponse(DnsServerAddressStream dnsServerAddressStream, int i, DnsQuestion dnsQuestion, AddressedEnvelope<DnsResponse, InetSocketAddress> addressedEnvelope, DnsQueryLifecycleObserver dnsQueryLifecycleObserver, Promise<List<T>> promise) {
        try {
            DnsResponse content = addressedEnvelope.content();
            DnsResponseCode code = content.code();
            if (code != DnsResponseCode.NOERROR) {
                if (code != DnsResponseCode.NXDOMAIN) {
                    query(dnsServerAddressStream, i + 1, dnsQuestion, dnsQueryLifecycleObserver.queryNoAnswer(code), true, promise, null);
                } else {
                    dnsQueryLifecycleObserver.queryFailed(NXDOMAIN_QUERY_FAILED_EXCEPTION);
                    if (!content.isAuthoritativeAnswer()) {
                        query(dnsServerAddressStream, i + 1, dnsQuestion, newDnsQueryLifecycleObserver(dnsQuestion), true, promise, null);
                    }
                }
            } else if (!handleRedirect(dnsQuestion, addressedEnvelope, dnsQueryLifecycleObserver, promise)) {
                DnsRecordType type = dnsQuestion.type();
                if (type == DnsRecordType.CNAME) {
                    onResponseCNAME(dnsQuestion, buildAliasMap(addressedEnvelope.content(), cnameCache(), this.parent.executor()), dnsQueryLifecycleObserver, promise);
                    return;
                }
                for (DnsRecordType dnsRecordType : this.expectedTypes) {
                    if (type == dnsRecordType) {
                        onExpectedResponse(dnsQuestion, addressedEnvelope, dnsQueryLifecycleObserver, promise);
                        return;
                    }
                }
                dnsQueryLifecycleObserver.queryFailed(UNRECOGNIZED_TYPE_QUERY_FAILED_EXCEPTION);
            }
        } finally {
            ReferenceCountUtil.safeRelease(addressedEnvelope);
        }
    }

    private void onResponseCNAME(DnsQuestion dnsQuestion, Map<String, String> map, DnsQueryLifecycleObserver dnsQueryLifecycleObserver, Promise<List<T>> promise) {
        String remove;
        String lowerCase = dnsQuestion.name().toLowerCase(Locale.US);
        boolean z = false;
        while (!map.isEmpty() && (remove = map.remove(lowerCase)) != null) {
            z = true;
            lowerCase = remove;
        }
        if (z) {
            followCname(dnsQuestion, lowerCase, dnsQueryLifecycleObserver, promise);
        } else {
            dnsQueryLifecycleObserver.queryFailed(CNAME_NOT_FOUND_QUERY_FAILED_EXCEPTION);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void query(final DnsServerAddressStream dnsServerAddressStream, final int i, final DnsQuestion dnsQuestion, final DnsQueryLifecycleObserver dnsQueryLifecycleObserver, boolean z, final Promise<List<T>> promise, Throwable th) {
        if (!this.completeEarly && i < dnsServerAddressStream.size() && this.allowedQueries != 0 && !this.originalPromise.isCancelled() && !promise.isCancelled()) {
            this.allowedQueries--;
            InetSocketAddress next = dnsServerAddressStream.next();
            if (next.isUnresolved()) {
                queryUnresolvedNameServer(next, dnsServerAddressStream, i, dnsQuestion, dnsQueryLifecycleObserver, promise, th);
                return;
            }
            ChannelPromise newPromise = this.parent.ch.newPromise();
            Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query0 = this.parent.query0(next, dnsQuestion, this.additionals, z, newPromise, this.parent.ch.eventLoop().newPromise());
            this.queriesInProgress.add(query0);
            dnsQueryLifecycleObserver.queryWritten(next, newPromise);
            query0.addListener(new a<AddressedEnvelope<DnsResponse, InetSocketAddress>>() { // from class: io.netty.resolver.dns.DnsResolveContext.2
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> future) {
                    DnsResolveContext.this.queriesInProgress.remove(future);
                    if (promise.isDone() || future.isCancelled()) {
                        dnsQueryLifecycleObserver.queryCancelled(DnsResolveContext.this.allowedQueries);
                        AddressedEnvelope<DnsResponse, InetSocketAddress> now = future.getNow();
                        if (now != null) {
                            now.release();
                            return;
                        }
                        return;
                    }
                    Throwable cause = future.cause();
                    try {
                        if (cause == null) {
                            DnsResolveContext.this.onResponse(dnsServerAddressStream, i, dnsQuestion, future.getNow(), dnsQueryLifecycleObserver, promise);
                        } else {
                            dnsQueryLifecycleObserver.queryFailed(cause);
                            DnsResolveContext dnsResolveContext = DnsResolveContext.this;
                            DnsQuestion dnsQuestion2 = dnsQuestion;
                            dnsResolveContext.query(dnsServerAddressStream, i + 1, dnsQuestion2, dnsResolveContext.newDnsQueryLifecycleObserver(dnsQuestion2), true, promise, cause);
                        }
                    } finally {
                        DnsResolveContext.this.tryToFinishResolve(dnsServerAddressStream, i, dnsQuestion, NoopDnsQueryLifecycleObserver.INSTANCE, promise, cause);
                    }
                }
            });
            return;
        }
        tryToFinishResolve(dnsServerAddressStream, i, dnsQuestion, dnsQueryLifecycleObserver, promise, th);
    }

    private void queryUnresolvedNameServer(final InetSocketAddress inetSocketAddress, final DnsServerAddressStream dnsServerAddressStream, final int i, final DnsQuestion dnsQuestion, final DnsQueryLifecycleObserver dnsQueryLifecycleObserver, final Promise<List<T>> promise, final Throwable th) {
        String hostString = PlatformDependent.javaVersion() >= 7 ? inetSocketAddress.getHostString() : inetSocketAddress.getHostName();
        final Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> newSucceededFuture = this.parent.executor().newSucceededFuture(null);
        this.queriesInProgress.add(newSucceededFuture);
        Promise<List<T>> newPromise = this.parent.executor().newPromise();
        newPromise.addListener((GenericFutureListener<? extends Future<? super List<T>>>) new a<List<InetAddress>>() { // from class: io.netty.resolver.dns.DnsResolveContext.3
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<List<InetAddress>> future) {
                DnsResolveContext.this.queriesInProgress.remove(newSucceededFuture);
                if (future.isSuccess()) {
                    DnsResolveContext.this.query(new CombinedDnsServerAddressStream(inetSocketAddress, future.getNow(), dnsServerAddressStream), i, dnsQuestion, dnsQueryLifecycleObserver, true, promise, th);
                    return;
                }
                DnsResolveContext.this.query(dnsServerAddressStream, i + 1, dnsQuestion, dnsQueryLifecycleObserver, true, promise, th);
            }
        });
        DnsCache resolveCache = resolveCache();
        if (!DnsNameResolver.doResolveAllCached(hostString, this.additionals, newPromise, resolveCache, this.parent.resolvedInternetProtocolFamiliesUnsafe())) {
            DnsNameResolver dnsNameResolver = this.parent;
            new DnsAddressResolveContext(dnsNameResolver, this.originalPromise, hostString, this.additionals, dnsNameResolver.newNameServerAddressStream(hostString), resolveCache, redirectAuthoritativeDnsServerCache(authoritativeDnsServerCache()), false).resolve(newPromise);
        }
    }

    private static AuthoritativeDnsServerCache redirectAuthoritativeDnsServerCache(AuthoritativeDnsServerCache authoritativeDnsServerCache) {
        return authoritativeDnsServerCache instanceof RedirectAuthoritativeDnsServerCache ? authoritativeDnsServerCache : new RedirectAuthoritativeDnsServerCache(authoritativeDnsServerCache);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryToFinishResolve(DnsServerAddressStream dnsServerAddressStream, int i, DnsQuestion dnsQuestion, DnsQueryLifecycleObserver dnsQueryLifecycleObserver, Promise<List<T>> promise, Throwable th) {
        if (this.completeEarly || this.queriesInProgress.isEmpty()) {
            if (this.finalResult != null) {
                dnsQueryLifecycleObserver.queryCancelled(this.allowedQueries);
            } else if (i >= dnsServerAddressStream.size()) {
                dnsQueryLifecycleObserver.queryFailed(NAME_SERVERS_EXHAUSTED_EXCEPTION);
                if (th == null && !this.triedCNAME) {
                    this.triedCNAME = true;
                    String str = this.hostname;
                    query(str, DnsRecordType.CNAME, getNameServers(str), true, promise);
                    return;
                }
            } else if (dnsQueryLifecycleObserver == NoopDnsQueryLifecycleObserver.INSTANCE) {
                query(dnsServerAddressStream, 1 + i, dnsQuestion, newDnsQueryLifecycleObserver(dnsQuestion), true, promise, th);
                return;
            } else {
                query(dnsServerAddressStream, 1 + i, dnsQuestion, dnsQueryLifecycleObserver, true, promise, th);
                return;
            }
            finishResolve(promise, th);
            return;
        }
        dnsQueryLifecycleObserver.queryCancelled(this.allowedQueries);
    }

    AuthoritativeDnsServerCache authoritativeDnsServerCache() {
        return this.parent.authoritativeDnsServerCache();
    }

    abstract void cache(String str, DnsRecord[] dnsRecordArr, DnsRecord dnsRecord, T t);

    abstract void cache(String str, DnsRecord[] dnsRecordArr, UnknownHostException unknownHostException);

    DnsCnameCache cnameCache() {
        return this.parent.cnameCache();
    }

    abstract T convertRecord(DnsRecord dnsRecord, String str, DnsRecord[] dnsRecordArr, EventLoop eventLoop);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doSearchDomainQuery(String str, Promise<List<T>> promise) {
        newResolverContext(this.parent, this.originalPromise, str, this.dnsClass, this.expectedTypes, this.additionals, this.nameServerAddrs).internalResolve(str, promise);
    }

    abstract List<T> filterResults(List<T> list);

    abstract boolean isCompleteEarly(T t);

    abstract boolean isDuplicateAllowed();

    abstract DnsResolveContext<T> newResolverContext(DnsNameResolver dnsNameResolver, Promise<?> promise, String str, int i, DnsRecordType[] dnsRecordTypeArr, DnsRecord[] dnsRecordArr, DnsServerAddressStream dnsServerAddressStream);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resolve(Promise<List<T>> promise) {
        String str;
        String[] searchDomains = this.parent.searchDomains();
        if (searchDomains.length == 0 || this.parent.ndots() == 0 || StringUtil.endsWith(this.hostname, '.')) {
            internalResolve(this.hostname, promise);
            return;
        }
        boolean hasNDots = hasNDots();
        if (hasNDots) {
            str = this.hostname;
        } else {
            str = this.hostname + '.' + searchDomains[0];
        }
        int i = !hasNDots ? 1 : 0;
        Promise<List<T>> newPromise = this.parent.executor().newPromise();
        newPromise.addListener((GenericFutureListener<? extends Future<? super List<T>>>) new a<List<T>>(i, promise, searchDomains, hasNDots) { // from class: io.netty.resolver.dns.DnsResolveContext.1
            private int searchDomainIdx;
            final /* synthetic */ int val$initialSearchDomainIdx;
            final /* synthetic */ Promise val$promise;
            final /* synthetic */ String[] val$searchDomains;
            final /* synthetic */ boolean val$startWithoutSearchDomain;

            {
                this.val$initialSearchDomainIdx = i;
                this.val$promise = promise;
                this.val$searchDomains = searchDomains;
                this.val$startWithoutSearchDomain = hasNDots;
                this.searchDomainIdx = i;
            }

            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<List<T>> future) {
                Throwable cause = future.cause();
                if (cause == null) {
                    this.val$promise.trySuccess(future.getNow());
                } else if (DnsNameResolver.isTransportOrTimeoutError(cause)) {
                    this.val$promise.tryFailure(new SearchDomainUnknownHostException(cause, DnsResolveContext.this.hostname));
                } else if (this.searchDomainIdx < this.val$searchDomains.length) {
                    Promise<List<T>> newPromise2 = DnsResolveContext.this.parent.executor().newPromise();
                    newPromise2.addListener((GenericFutureListener<? extends Future<? super List<T>>>) this);
                    DnsResolveContext dnsResolveContext = DnsResolveContext.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append(DnsResolveContext.this.hostname);
                    sb.append('.');
                    String[] strArr = this.val$searchDomains;
                    int i2 = this.searchDomainIdx;
                    this.searchDomainIdx = i2 + 1;
                    sb.append(strArr[i2]);
                    dnsResolveContext.doSearchDomainQuery(sb.toString(), newPromise2);
                } else if (!this.val$startWithoutSearchDomain) {
                    DnsResolveContext dnsResolveContext2 = DnsResolveContext.this;
                    dnsResolveContext2.internalResolve(dnsResolveContext2.hostname, this.val$promise);
                } else {
                    this.val$promise.tryFailure(new SearchDomainUnknownHostException(cause, DnsResolveContext.this.hostname));
                }
            }
        });
        doSearchDomainQuery(str, newPromise);
    }

    DnsCache resolveCache() {
        return this.parent.resolveCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class AuthoritativeNameServer {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private InetSocketAddress address;
        private final String domainName;
        private final int dots;
        final boolean isCopy = false;
        AuthoritativeNameServer next;
        final String nsName;
        private long ttl;

        AuthoritativeNameServer(int i, long j, String str, String str2) {
            this.dots = i;
            this.ttl = j;
            this.nsName = str2;
            this.domainName = str;
        }

        boolean isRootServer() {
            return this.dots == 1;
        }

        void update(InetSocketAddress inetSocketAddress, long j) {
            this.address = inetSocketAddress;
            this.ttl = Math.min(this.ttl, j);
        }

        void update(InetSocketAddress inetSocketAddress) {
            update(inetSocketAddress, Long.MAX_VALUE);
        }

        AuthoritativeNameServer(AuthoritativeNameServer authoritativeNameServer) {
            this.dots = authoritativeNameServer.dots;
            this.ttl = authoritativeNameServer.ttl;
            this.nsName = authoritativeNameServer.nsName;
            this.domainName = authoritativeNameServer.domainName;
        }
    }

    private boolean query(String str, DnsRecordType dnsRecordType, DnsServerAddressStream dnsServerAddressStream, boolean z, Promise<List<T>> promise) {
        try {
            DefaultDnsQuestion defaultDnsQuestion = new DefaultDnsQuestion(str, dnsRecordType, this.dnsClass);
            query(dnsServerAddressStream, 0, defaultDnsQuestion, newDnsQueryLifecycleObserver(defaultDnsQuestion), z, promise, null);
            return true;
        } catch (Throwable th) {
            promise.tryFailure(new IllegalArgumentException("Unable to create DNS Question for: [" + str + ", " + dnsRecordType + ']', th));
            return false;
        }
    }
}

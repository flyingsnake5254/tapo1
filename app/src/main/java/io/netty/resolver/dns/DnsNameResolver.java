package io.netty.resolver.dns;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFactory;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoop;
import io.netty.channel.FixedRecvByteBufAllocator;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.handler.codec.dns.DatagramDnsQueryEncoder;
import io.netty.handler.codec.dns.DatagramDnsResponse;
import io.netty.handler.codec.dns.DatagramDnsResponseDecoder;
import io.netty.handler.codec.dns.DefaultDnsRawRecord;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsRawRecord;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsRecordType;
import io.netty.handler.codec.dns.DnsResponse;
import io.netty.handler.codec.dns.TcpDnsQueryEncoder;
import io.netty.handler.codec.dns.TcpDnsResponseDecoder;
import io.netty.resolver.HostsFileEntriesResolver;
import io.netty.resolver.InetNameResolver;
import io.netty.resolver.ResolvedAddressTypes;
import io.netty.util.NetUtil;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.a;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.IDN;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class DnsNameResolver extends InetNameResolver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final DatagramDnsResponseDecoder DATAGRAM_DECODER;
    private static final DatagramDnsQueryEncoder DATAGRAM_ENCODER;
    private static final UnixResolverOptions DEFAULT_OPTIONS;
    static final ResolvedAddressTypes DEFAULT_RESOLVE_ADDRESS_TYPES;
    static final String[] DEFAULT_SEARCH_DOMAINS;
    private static final InternetProtocolFamily[] IPV4_ONLY_RESOLVED_PROTOCOL_FAMILIES;
    private static final DnsRecordType[] IPV4_ONLY_RESOLVED_RECORD_TYPES;
    private static final InternetProtocolFamily[] IPV4_PREFERRED_RESOLVED_PROTOCOL_FAMILIES;
    private static final DnsRecordType[] IPV4_PREFERRED_RESOLVED_RECORD_TYPES;
    private static final InternetProtocolFamily[] IPV6_ONLY_RESOLVED_PROTOCOL_FAMILIES;
    private static final DnsRecordType[] IPV6_ONLY_RESOLVED_RECORD_TYPES;
    private static final InternetProtocolFamily[] IPV6_PREFERRED_RESOLVED_PROTOCOL_FAMILIES;
    private static final DnsRecordType[] IPV6_PREFERRED_RESOLVED_RECORD_TYPES;
    private static final String LOCALHOST = "localhost";
    private static final InetAddress LOCALHOST_ADDRESS;
    private static final TcpDnsQueryEncoder TCP_ENCODER;
    private final AuthoritativeDnsServerCache authoritativeDnsServerCache;
    final Channel ch;
    final Future<Channel> channelFuture;
    private final DnsCnameCache cnameCache;
    private final boolean completeOncePreferredResolved;
    private final boolean decodeIdn;
    private final DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory;
    private final DnsServerAddressStreamProvider dnsServerAddressStreamProvider;
    private final HostsFileEntriesResolver hostsFileEntriesResolver;
    private final int maxPayloadSize;
    private final int maxQueriesPerResolve;
    private final FastThreadLocal<DnsServerAddressStream> nameServerAddrStream;
    private final Comparator<InetSocketAddress> nameServerComparator;
    private final int ndots;
    private final boolean optResourceEnabled;
    private final InternetProtocolFamily preferredAddressType;
    final DnsQueryContextManager queryContextManager;
    private final long queryTimeoutMillis;
    private final boolean recursionDesired;
    private final DnsCache resolveCache;
    private final DnsRecordType[] resolveRecordTypes;
    private final ResolvedAddressTypes resolvedAddressTypes;
    private final InternetProtocolFamily[] resolvedInternetProtocolFamilies;
    private final String[] searchDomains;
    private final ChannelFactory<? extends SocketChannel> socketChannelFactory;
    private final boolean supportsAAAARecords;
    private final boolean supportsARecords;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(DnsNameResolver.class);
    private static final DnsRecord[] EMPTY_ADDITIONALS = new DnsRecord[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.resolver.dns.DnsNameResolver$7  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$resolver$ResolvedAddressTypes;

        static {
            int[] iArr = new int[ResolvedAddressTypes.values().length];
            $SwitchMap$io$netty$resolver$ResolvedAddressTypes = iArr;
            try {
                iArr[ResolvedAddressTypes.IPV4_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$resolver$ResolvedAddressTypes[ResolvedAddressTypes.IPV4_PREFERRED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$resolver$ResolvedAddressTypes[ResolvedAddressTypes.IPV6_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$resolver$ResolvedAddressTypes[ResolvedAddressTypes.IPV6_PREFERRED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes3.dex */
    private static final class AddressedEnvelopeAdapter implements AddressedEnvelope<DnsResponse, InetSocketAddress> {
        private final InetSocketAddress recipient;
        private final DnsResponse response;
        private final InetSocketAddress sender;

        AddressedEnvelopeAdapter(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, DnsResponse dnsResponse) {
            this.sender = inetSocketAddress;
            this.recipient = inetSocketAddress2;
            this.response = dnsResponse;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AddressedEnvelope)) {
                return false;
            }
            AddressedEnvelope addressedEnvelope = (AddressedEnvelope) obj;
            if (sender() == null) {
                if (addressedEnvelope.sender() != null) {
                    return false;
                }
            } else if (!sender().equals(addressedEnvelope.sender())) {
                return false;
            }
            if (recipient() == null) {
                if (addressedEnvelope.recipient() != null) {
                    return false;
                }
            } else if (!recipient().equals(addressedEnvelope.recipient())) {
                return false;
            }
            return this.response.equals(obj);
        }

        public int hashCode() {
            int hashCode = this.response.hashCode();
            if (sender() != null) {
                hashCode = (hashCode * 31) + sender().hashCode();
            }
            return recipient() != null ? (hashCode * 31) + recipient().hashCode() : hashCode;
        }

        @Override // io.netty.util.ReferenceCounted
        public int refCnt() {
            return this.response.refCnt();
        }

        @Override // io.netty.util.ReferenceCounted
        public boolean release() {
            return this.response.release();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.channel.AddressedEnvelope
        public DnsResponse content() {
            return this.response;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.channel.AddressedEnvelope
        public InetSocketAddress recipient() {
            return this.recipient;
        }

        @Override // io.netty.util.ReferenceCounted
        public boolean release(int i) {
            return this.response.release(i);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.channel.AddressedEnvelope
        public InetSocketAddress sender() {
            return this.sender;
        }

        @Override // io.netty.channel.AddressedEnvelope, io.netty.util.ReferenceCounted
        public AddressedEnvelope<DnsResponse, InetSocketAddress> retain() {
            this.response.retain();
            return this;
        }

        @Override // io.netty.channel.AddressedEnvelope, io.netty.util.ReferenceCounted
        public AddressedEnvelope<DnsResponse, InetSocketAddress> touch() {
            this.response.touch();
            return this;
        }

        @Override // io.netty.channel.AddressedEnvelope, io.netty.util.ReferenceCounted
        public AddressedEnvelope<DnsResponse, InetSocketAddress> retain(int i) {
            this.response.retain(i);
            return this;
        }

        @Override // io.netty.channel.AddressedEnvelope, io.netty.util.ReferenceCounted
        public AddressedEnvelope<DnsResponse, InetSocketAddress> touch(Object obj) {
            this.response.touch(obj);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class DnsResponseHandler extends ChannelInboundHandlerAdapter {
        private final Promise<Channel> channelActivePromise;

        DnsResponseHandler(Promise<Channel> promise) {
            this.channelActivePromise = promise;
        }

        @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
        public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
            super.channelActive(channelHandlerContext);
            this.channelActivePromise.setSuccess(channelHandlerContext.channel());
        }

        @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
        public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
            final DatagramDnsResponse datagramDnsResponse = (DatagramDnsResponse) obj;
            final int id = datagramDnsResponse.id();
            if (DnsNameResolver.logger.isDebugEnabled()) {
                DnsNameResolver.logger.debug("{} RECEIVED: UDP [{}: {}], {}", DnsNameResolver.this.ch, Integer.valueOf(id), datagramDnsResponse.sender(), datagramDnsResponse);
            }
            final DnsQueryContext dnsQueryContext = DnsNameResolver.this.queryContextManager.get(datagramDnsResponse.sender(), id);
            if (dnsQueryContext == null) {
                DnsNameResolver.logger.debug("Received a DNS response with an unknown ID: UDP [{}: {}]", DnsNameResolver.this.ch, Integer.valueOf(id));
                datagramDnsResponse.release();
            } else if (!datagramDnsResponse.isTruncated() || DnsNameResolver.this.socketChannelFactory == null) {
                dnsQueryContext.finish(datagramDnsResponse);
            } else {
                Bootstrap bootstrap = new Bootstrap();
                bootstrap.option(ChannelOption.SO_REUSEADDR, Boolean.TRUE).group(DnsNameResolver.this.executor()).channelFactory(DnsNameResolver.this.socketChannelFactory).handler(DnsNameResolver.TCP_ENCODER);
                bootstrap.connect(datagramDnsResponse.sender()).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.resolver.dns.DnsNameResolver.DnsResponseHandler.1
                    public void operationComplete(ChannelFuture channelFuture) {
                        if (!channelFuture.isSuccess()) {
                            if (DnsNameResolver.logger.isDebugEnabled()) {
                                DnsNameResolver.logger.debug("Unable to fallback to TCP [{}]", Integer.valueOf(id), channelFuture.cause());
                            }
                            dnsQueryContext.finish(datagramDnsResponse);
                            return;
                        }
                        final Channel channel = channelFuture.channel();
                        Promise newPromise = channel.eventLoop().newPromise();
                        final TcpDnsQueryContext tcpDnsQueryContext = new TcpDnsQueryContext(DnsNameResolver.this, channel, (InetSocketAddress) channel.remoteAddress(), dnsQueryContext.question(), DnsNameResolver.EMPTY_ADDITIONALS, newPromise);
                        channel.pipeline().addLast(new TcpDnsResponseDecoder());
                        channel.pipeline().addLast(new ChannelInboundHandlerAdapter() { // from class: io.netty.resolver.dns.DnsNameResolver.DnsResponseHandler.1.1
                            @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
                            public void channelRead(ChannelHandlerContext channelHandlerContext2, Object obj2) {
                                Channel channel2 = channelHandlerContext2.channel();
                                DnsResponse dnsResponse = (DnsResponse) obj2;
                                int id2 = dnsResponse.id();
                                if (DnsNameResolver.logger.isDebugEnabled()) {
                                    DnsNameResolver.logger.debug("{} RECEIVED: TCP [{}: {}], {}", channel2, Integer.valueOf(id2), channel2.remoteAddress(), dnsResponse);
                                }
                                AnonymousClass1 r2 = AnonymousClass1.this;
                                DnsQueryContext dnsQueryContext2 = DnsNameResolver.this.queryContextManager.get(datagramDnsResponse.sender(), id2);
                                TcpDnsQueryContext tcpDnsQueryContext2 = tcpDnsQueryContext;
                                if (dnsQueryContext2 == tcpDnsQueryContext2) {
                                    tcpDnsQueryContext2.finish(new AddressedEnvelopeAdapter((InetSocketAddress) channelHandlerContext2.channel().remoteAddress(), (InetSocketAddress) channelHandlerContext2.channel().localAddress(), dnsResponse));
                                    return;
                                }
                                dnsResponse.release();
                                tcpDnsQueryContext.tryFailure("Received TCP DNS response with unexpected ID", null, false);
                                DnsNameResolver.logger.debug("Received a DNS response with an unexpected ID: TCP [{}: {}]", channel2, Integer.valueOf(id2));
                            }

                            @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
                            public void exceptionCaught(ChannelHandlerContext channelHandlerContext2, Throwable th) {
                                if (tcpDnsQueryContext.tryFailure("TCP fallback error", th, false) && DnsNameResolver.logger.isDebugEnabled()) {
                                    DnsNameResolver.logger.debug("{} Error during processing response: TCP [{}: {}]", channelHandlerContext2.channel(), Integer.valueOf(id), channelHandlerContext2.channel().remoteAddress(), th);
                                }
                            }
                        });
                        newPromise.addListener((GenericFutureListener) new a<AddressedEnvelope<DnsResponse, InetSocketAddress>>() { // from class: io.netty.resolver.dns.DnsNameResolver.DnsResponseHandler.1.2
                            @Override // io.netty.util.concurrent.GenericFutureListener
                            public void operationComplete(Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> future) {
                                channel.close();
                                if (future.isSuccess()) {
                                    dnsQueryContext.finish(future.getNow());
                                    datagramDnsResponse.release();
                                    return;
                                }
                                AnonymousClass1 r2 = AnonymousClass1.this;
                                dnsQueryContext.finish(datagramDnsResponse);
                            }
                        });
                        tcpDnsQueryContext.query(true, channelFuture.channel().newPromise());
                    }
                });
            }
        }

        @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
        public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
            if (th instanceof CorruptedFrameException) {
                DnsNameResolver.logger.debug("Unable to decode DNS response: UDP [{}]", channelHandlerContext.channel(), th);
            } else {
                DnsNameResolver.logger.warn("Unexpected exception: UDP [{}]", channelHandlerContext.channel(), th);
            }
        }
    }

    static {
        String[] strArr;
        UnixResolverOptions unixResolverOptions;
        List<String> list;
        DnsRecordType dnsRecordType = DnsRecordType.A;
        IPV4_ONLY_RESOLVED_RECORD_TYPES = new DnsRecordType[]{dnsRecordType};
        InternetProtocolFamily internetProtocolFamily = InternetProtocolFamily.IPv4;
        IPV4_ONLY_RESOLVED_PROTOCOL_FAMILIES = new InternetProtocolFamily[]{internetProtocolFamily};
        DnsRecordType dnsRecordType2 = DnsRecordType.AAAA;
        IPV4_PREFERRED_RESOLVED_RECORD_TYPES = new DnsRecordType[]{dnsRecordType, dnsRecordType2};
        InternetProtocolFamily internetProtocolFamily2 = InternetProtocolFamily.IPv6;
        IPV4_PREFERRED_RESOLVED_PROTOCOL_FAMILIES = new InternetProtocolFamily[]{internetProtocolFamily, internetProtocolFamily2};
        IPV6_ONLY_RESOLVED_RECORD_TYPES = new DnsRecordType[]{dnsRecordType2};
        IPV6_ONLY_RESOLVED_PROTOCOL_FAMILIES = new InternetProtocolFamily[]{internetProtocolFamily2};
        IPV6_PREFERRED_RESOLVED_RECORD_TYPES = new DnsRecordType[]{dnsRecordType2, dnsRecordType};
        IPV6_PREFERRED_RESOLVED_PROTOCOL_FAMILIES = new InternetProtocolFamily[]{internetProtocolFamily2, internetProtocolFamily};
        if (NetUtil.isIpV4StackPreferred() || !anyInterfaceSupportsIpV6()) {
            DEFAULT_RESOLVE_ADDRESS_TYPES = ResolvedAddressTypes.IPV4_ONLY;
            LOCALHOST_ADDRESS = NetUtil.LOCALHOST4;
        } else if (NetUtil.isIpV6AddressesPreferred()) {
            DEFAULT_RESOLVE_ADDRESS_TYPES = ResolvedAddressTypes.IPV6_PREFERRED;
            LOCALHOST_ADDRESS = NetUtil.LOCALHOST6;
        } else {
            DEFAULT_RESOLVE_ADDRESS_TYPES = ResolvedAddressTypes.IPV4_PREFERRED;
            LOCALHOST_ADDRESS = NetUtil.LOCALHOST4;
        }
        try {
            if (PlatformDependent.isWindows()) {
                list = getSearchDomainsHack();
            } else {
                list = UnixResolverDnsServerAddressStreamProvider.parseEtcResolverSearchDomains();
            }
            strArr = (String[]) list.toArray(new String[0]);
        } catch (Exception unused) {
            strArr = EmptyArrays.EMPTY_STRINGS;
        }
        DEFAULT_SEARCH_DOMAINS = strArr;
        try {
            unixResolverOptions = UnixResolverDnsServerAddressStreamProvider.parseEtcResolverOptions();
        } catch (Exception unused2) {
            unixResolverOptions = UnixResolverOptions.newBuilder().build();
        }
        DEFAULT_OPTIONS = unixResolverOptions;
        DATAGRAM_DECODER = new DatagramDnsResponseDecoder() { // from class: io.netty.resolver.dns.DnsNameResolver.1
            @Override // io.netty.handler.codec.dns.DatagramDnsResponseDecoder
            protected DnsResponse decodeResponse(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) throws Exception {
                DnsResponse decodeResponse = super.decodeResponse(channelHandlerContext, datagramPacket);
                if (datagramPacket.content().isReadable()) {
                    decodeResponse.setTruncated(true);
                    if (DnsNameResolver.logger.isDebugEnabled()) {
                        DnsNameResolver.logger.debug("{} RECEIVED: UDP truncated packet received, consider adjusting maxPayloadSize for the {}.", channelHandlerContext.channel(), StringUtil.simpleClassName((Class<?>) DnsNameResolver.class));
                    }
                }
                return decodeResponse;
            }
        };
        DATAGRAM_ENCODER = new DatagramDnsQueryEncoder();
        TCP_ENCODER = new TcpDnsQueryEncoder();
    }

    @Deprecated
    public DnsNameResolver(EventLoop eventLoop, ChannelFactory<? extends DatagramChannel> channelFactory, DnsCache dnsCache, DnsCache dnsCache2, DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory, long j, ResolvedAddressTypes resolvedAddressTypes, boolean z, int i, boolean z2, int i2, boolean z3, HostsFileEntriesResolver hostsFileEntriesResolver, DnsServerAddressStreamProvider dnsServerAddressStreamProvider, String[] strArr, int i3, boolean z4) {
        this(eventLoop, channelFactory, dnsCache, new AuthoritativeDnsServerCacheAdapter(dnsCache2), dnsQueryLifecycleObserverFactory, j, resolvedAddressTypes, z, i, z2, i2, z3, hostsFileEntriesResolver, dnsServerAddressStreamProvider, strArr, i3, z4);
    }

    private static boolean anyInterfaceSupportsIpV6() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if ((nextElement instanceof Inet6Address) && !nextElement.isAnyLocalAddress() && !nextElement.isLoopbackAddress() && !nextElement.isLinkLocalAddress()) {
                        return true;
                    }
                }
            }
            return false;
        } catch (SocketException e2) {
            logger.debug("Unable to detect if any interface supports IPv6, assuming IPv4-only", (Throwable) e2);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Promise<AddressedEnvelope<DnsResponse, InetSocketAddress>> cast(Promise<?> promise) {
        return promise;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean doResolveAllCached(String str, DnsRecord[] dnsRecordArr, Promise<List<InetAddress>> promise, DnsCache dnsCache, InternetProtocolFamily[] internetProtocolFamilyArr) {
        List<? extends DnsCacheEntry> list = dnsCache.get(str, dnsRecordArr);
        if (list == null || list.isEmpty()) {
            return false;
        }
        Throwable cause = ((DnsCacheEntry) list.get(0)).cause();
        if (cause == null) {
            ArrayList arrayList = null;
            int size = list.size();
            for (InternetProtocolFamily internetProtocolFamily : internetProtocolFamilyArr) {
                for (int i = 0; i < size; i++) {
                    DnsCacheEntry dnsCacheEntry = (DnsCacheEntry) list.get(i);
                    if (internetProtocolFamily.addressType().isInstance(dnsCacheEntry.address())) {
                        if (arrayList == null) {
                            arrayList = new ArrayList(size);
                        }
                        arrayList.add(dnsCacheEntry.address());
                    }
                }
            }
            if (arrayList == null) {
                return false;
            }
            trySuccess(promise, arrayList);
            return true;
        }
        tryFailure(promise, cause);
        return true;
    }

    private void doResolveAllUncached(final String str, final DnsRecord[] dnsRecordArr, final Promise<?> promise, final Promise<List<InetAddress>> promise2, final DnsCache dnsCache, final boolean z) {
        EventLoop executor = executor();
        if (executor.inEventLoop()) {
            doResolveAllUncached0(str, dnsRecordArr, promise, promise2, dnsCache, z);
        } else {
            executor.execute(new Runnable() { // from class: io.netty.resolver.dns.DnsNameResolver.6
                @Override // java.lang.Runnable
                public void run() {
                    DnsNameResolver.this.doResolveAllUncached0(str, dnsRecordArr, promise, promise2, dnsCache, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doResolveAllUncached0(String str, DnsRecord[] dnsRecordArr, Promise<?> promise, Promise<List<InetAddress>> promise2, DnsCache dnsCache, boolean z) {
        new DnsAddressResolveContext(this, promise, str, dnsRecordArr, this.dnsServerAddressStreamProvider.nameServerAddressStream(str), dnsCache, this.authoritativeDnsServerCache, z).resolve(promise2);
    }

    private boolean doResolveCached(String str, DnsRecord[] dnsRecordArr, Promise<InetAddress> promise, DnsCache dnsCache) {
        InternetProtocolFamily[] internetProtocolFamilyArr;
        List<? extends DnsCacheEntry> list = dnsCache.get(str, dnsRecordArr);
        if (list == null || list.isEmpty()) {
            return false;
        }
        Throwable cause = ((DnsCacheEntry) list.get(0)).cause();
        if (cause == null) {
            int size = list.size();
            for (InternetProtocolFamily internetProtocolFamily : this.resolvedInternetProtocolFamilies) {
                for (int i = 0; i < size; i++) {
                    DnsCacheEntry dnsCacheEntry = (DnsCacheEntry) list.get(i);
                    if (internetProtocolFamily.addressType().isInstance(dnsCacheEntry.address())) {
                        trySuccess(promise, dnsCacheEntry.address());
                        return true;
                    }
                }
            }
            return false;
        }
        tryFailure(promise, cause);
        return true;
    }

    private void doResolveUncached(String str, DnsRecord[] dnsRecordArr, final Promise<InetAddress> promise, DnsCache dnsCache, boolean z) {
        Promise<List<InetAddress>> newPromise = executor().newPromise();
        doResolveAllUncached(str, dnsRecordArr, promise, newPromise, dnsCache, true);
        newPromise.addListener((GenericFutureListener<? extends Future<? super List<InetAddress>>>) new a<List<InetAddress>>() { // from class: io.netty.resolver.dns.DnsNameResolver.5
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<List<InetAddress>> future) {
                if (future.isSuccess()) {
                    DnsNameResolver.trySuccess(promise, future.getNow().get(0));
                } else {
                    DnsNameResolver.tryFailure(promise, future.cause());
                }
            }
        });
    }

    private static List<String> getSearchDomainsHack() throws Exception {
        if (PlatformDependent.javaVersion() >= 9) {
            return Collections.emptyList();
        }
        Class<?> cls = Class.forName("sun.net.dns.ResolverConfiguration");
        return (List) cls.getMethod("searchlist", new Class[0]).invoke(cls.getMethod("open", new Class[0]).invoke(null, new Object[0]), new Object[0]);
    }

    private static String hostname(String str) {
        String ascii = IDN.toASCII(str);
        if (!StringUtil.endsWith(str, '.') || StringUtil.endsWith(ascii, '.')) {
            return ascii;
        }
        return ascii + ".";
    }

    public static boolean isTimeoutError(Throwable th) {
        return th != null && (th.getCause() instanceof DnsNameResolverTimeoutException);
    }

    public static boolean isTransportOrTimeoutError(Throwable th) {
        return th != null && (th.getCause() instanceof DnsNameResolverException);
    }

    private InetAddress loopbackAddress() {
        return preferredAddressType().localhost();
    }

    private InetSocketAddress nextNameServerAddress() {
        return this.nameServerAddrStream.get().next();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InternetProtocolFamily preferredAddressType(ResolvedAddressTypes resolvedAddressTypes) {
        int i = AnonymousClass7.$SwitchMap$io$netty$resolver$ResolvedAddressTypes[resolvedAddressTypes.ordinal()];
        if (i == 1 || i == 2) {
            return InternetProtocolFamily.IPv4;
        }
        if (i == 3 || i == 4) {
            return InternetProtocolFamily.IPv6;
        }
        throw new IllegalArgumentException("Unknown ResolvedAddressTypes " + resolvedAddressTypes);
    }

    private InetAddress resolveHostsFileEntry(String str) {
        HostsFileEntriesResolver hostsFileEntriesResolver = this.hostsFileEntriesResolver;
        if (hostsFileEntriesResolver == null) {
            return null;
        }
        InetAddress address = hostsFileEntriesResolver.address(str, this.resolvedAddressTypes);
        return (address != null || !PlatformDependent.isWindows() || !LOCALHOST.equalsIgnoreCase(str)) ? address : LOCALHOST_ADDRESS;
    }

    private static DnsRecord[] toArray(Iterable<DnsRecord> iterable, boolean z) {
        ObjectUtil.checkNotNull(iterable, "additionals");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            for (DnsRecord dnsRecord : iterable) {
                validateAdditional(dnsRecord, z);
            }
            return (DnsRecord[]) collection.toArray(new DnsRecord[collection.size()]);
        }
        Iterator<DnsRecord> it = iterable.iterator();
        if (!it.hasNext()) {
            return EMPTY_ADDITIONALS;
        }
        ArrayList arrayList = new ArrayList();
        do {
            DnsRecord next = it.next();
            validateAdditional(next, z);
            arrayList.add(next);
        } while (it.hasNext());
        return (DnsRecord[]) arrayList.toArray(new DnsRecord[arrayList.size()]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tryFailure(Promise<?> promise, Throwable th) {
        if (!promise.tryFailure(th)) {
            logger.trace("Failed to notify failure to a promise: {}", promise, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void trySuccess(Promise<T> promise, T t) {
        if (!promise.trySuccess(t)) {
            logger.trace("Failed to notify success ({}) to a promise: {}", t, promise);
        }
    }

    private static void validateAdditional(DnsRecord dnsRecord, boolean z) {
        ObjectUtil.checkNotNull(dnsRecord, "record");
        if (z && (dnsRecord instanceof DnsRawRecord)) {
            throw new IllegalArgumentException("DnsRawRecord implementations not allowed: " + dnsRecord);
        }
    }

    public AuthoritativeDnsServerCache authoritativeDnsServerCache() {
        return this.authoritativeDnsServerCache;
    }

    @Override // io.netty.resolver.SimpleNameResolver, io.netty.resolver.NameResolver, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.ch.isOpen()) {
            this.ch.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DnsCnameCache cnameCache() {
        return this.cnameCache;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory() {
        return this.dnsQueryLifecycleObserverFactory;
    }

    @Override // io.netty.resolver.SimpleNameResolver
    protected void doResolve(String str, Promise<InetAddress> promise) throws Exception {
        doResolve(str, EMPTY_ADDITIONALS, promise, this.resolveCache);
    }

    @Override // io.netty.resolver.SimpleNameResolver
    protected void doResolveAll(String str, Promise<List<InetAddress>> promise) throws Exception {
        doResolveAll(str, EMPTY_ADDITIONALS, promise, this.resolveCache);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void flushQueries() {
        this.ch.flush();
    }

    public HostsFileEntriesResolver hostsFileEntriesResolver() {
        return this.hostsFileEntriesResolver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isDecodeIdn() {
        return this.decodeIdn;
    }

    public boolean isOptResourceEnabled() {
        return this.optResourceEnabled;
    }

    public boolean isRecursionDesired() {
        return this.recursionDesired;
    }

    public int maxPayloadSize() {
        return this.maxPayloadSize;
    }

    public int maxQueriesPerResolve() {
        return this.maxQueriesPerResolve;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int ndots() {
        return this.ndots;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final DnsServerAddressStream newNameServerAddressStream(String str) {
        return this.dnsServerAddressStreamProvider.nameServerAddressStream(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DnsServerAddressStream newRedirectDnsServerStream(String str, List<InetSocketAddress> list) {
        DnsServerAddressStream dnsServerAddressStream = authoritativeDnsServerCache().get(str);
        if (dnsServerAddressStream != null && dnsServerAddressStream.size() != 0) {
            return dnsServerAddressStream;
        }
        Collections.sort(list, this.nameServerComparator);
        return new SequentialDnsServerAddressStream(list, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InetSocketAddress newRedirectServerAddress(InetAddress inetAddress) {
        return new InetSocketAddress(inetAddress, 53);
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(DnsQuestion dnsQuestion) {
        return query(nextNameServerAddress(), dnsQuestion);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query0(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, DnsRecord[] dnsRecordArr, boolean z, ChannelPromise channelPromise, Promise<AddressedEnvelope<? extends DnsResponse, InetSocketAddress>> promise) {
        Promise<AddressedEnvelope<DnsResponse, InetSocketAddress>> cast = cast((Promise) ObjectUtil.checkNotNull(promise, "promise"));
        try {
            new DatagramDnsQueryContext(this, inetSocketAddress, dnsQuestion, dnsRecordArr, cast).query(z, channelPromise);
            return cast;
        } catch (Exception e2) {
            return cast.setFailure(e2);
        }
    }

    public long queryTimeoutMillis() {
        return this.queryTimeoutMillis;
    }

    public final Future<InetAddress> resolve(String str, Iterable<DnsRecord> iterable) {
        return resolve(str, iterable, executor().newPromise());
    }

    public final Future<List<InetAddress>> resolveAll(String str, Iterable<DnsRecord> iterable) {
        return resolveAll(str, iterable, executor().newPromise());
    }

    public DnsCache resolveCache() {
        return this.resolveCache;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final DnsRecordType[] resolveRecordTypes() {
        return this.resolveRecordTypes;
    }

    public ResolvedAddressTypes resolvedAddressTypes() {
        return this.resolvedAddressTypes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InternetProtocolFamily[] resolvedInternetProtocolFamiliesUnsafe() {
        return this.resolvedInternetProtocolFamilies;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String[] searchDomains() {
        return this.searchDomains;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean supportsAAAARecords() {
        return this.supportsAAAARecords;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean supportsARecords() {
        return this.supportsARecords;
    }

    @Deprecated
    public DnsNameResolver(EventLoop eventLoop, ChannelFactory<? extends DatagramChannel> channelFactory, DnsCache dnsCache, AuthoritativeDnsServerCache authoritativeDnsServerCache, DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory, long j, ResolvedAddressTypes resolvedAddressTypes, boolean z, int i, boolean z2, int i2, boolean z3, HostsFileEntriesResolver hostsFileEntriesResolver, DnsServerAddressStreamProvider dnsServerAddressStreamProvider, String[] strArr, int i3, boolean z4) {
        this(eventLoop, channelFactory, null, dnsCache, NoopDnsCnameCache.INSTANCE, authoritativeDnsServerCache, dnsQueryLifecycleObserverFactory, j, resolvedAddressTypes, z, i, z2, i2, z3, hostsFileEntriesResolver, dnsServerAddressStreamProvider, strArr, i3, z4, false);
    }

    protected void doResolve(String str, DnsRecord[] dnsRecordArr, Promise<InetAddress> promise, DnsCache dnsCache) throws Exception {
        if (str == null || str.isEmpty()) {
            promise.setSuccess(loopbackAddress());
            return;
        }
        byte[] createByteArrayFromIpAddressString = NetUtil.createByteArrayFromIpAddressString(str);
        if (createByteArrayFromIpAddressString != null) {
            promise.setSuccess(InetAddress.getByAddress(createByteArrayFromIpAddressString));
            return;
        }
        String hostname = hostname(str);
        InetAddress resolveHostsFileEntry = resolveHostsFileEntry(hostname);
        if (resolveHostsFileEntry != null) {
            promise.setSuccess(resolveHostsFileEntry);
        } else if (!doResolveCached(hostname, dnsRecordArr, promise, dnsCache)) {
            doResolveUncached(hostname, dnsRecordArr, promise, dnsCache, true);
        }
    }

    protected void doResolveAll(String str, DnsRecord[] dnsRecordArr, Promise<List<InetAddress>> promise, DnsCache dnsCache) throws Exception {
        if (str == null || str.isEmpty()) {
            promise.setSuccess(Collections.singletonList(loopbackAddress()));
            return;
        }
        byte[] createByteArrayFromIpAddressString = NetUtil.createByteArrayFromIpAddressString(str);
        if (createByteArrayFromIpAddressString != null) {
            promise.setSuccess(Collections.singletonList(InetAddress.getByAddress(createByteArrayFromIpAddressString)));
            return;
        }
        String hostname = hostname(str);
        InetAddress resolveHostsFileEntry = resolveHostsFileEntry(hostname);
        if (resolveHostsFileEntry != null) {
            promise.setSuccess(Collections.singletonList(resolveHostsFileEntry));
        } else if (!doResolveAllCached(hostname, dnsRecordArr, promise, dnsCache, this.resolvedInternetProtocolFamilies)) {
            doResolveAllUncached(hostname, dnsRecordArr, promise, promise, dnsCache, this.completeOncePreferredResolved);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.resolver.SimpleNameResolver
    public EventLoop executor() {
        return (EventLoop) super.executor();
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(DnsQuestion dnsQuestion, Iterable<DnsRecord> iterable) {
        return query(nextNameServerAddress(), dnsQuestion, iterable);
    }

    public final Future<InetAddress> resolve(String str, Iterable<DnsRecord> iterable, Promise<InetAddress> promise) {
        ObjectUtil.checkNotNull(promise, "promise");
        try {
            doResolve(str, toArray(iterable, true), promise, this.resolveCache);
            return promise;
        } catch (Exception e2) {
            return promise.setFailure(e2);
        }
    }

    public final Future<List<InetAddress>> resolveAll(String str, Iterable<DnsRecord> iterable, Promise<List<InetAddress>> promise) {
        ObjectUtil.checkNotNull(promise, "promise");
        try {
            doResolveAll(str, toArray(iterable, true), promise, this.resolveCache);
            return promise;
        } catch (Exception e2) {
            return promise.setFailure(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DnsNameResolver(EventLoop eventLoop, ChannelFactory<? extends DatagramChannel> channelFactory, ChannelFactory<? extends SocketChannel> channelFactory2, final DnsCache dnsCache, final DnsCnameCache dnsCnameCache, final AuthoritativeDnsServerCache authoritativeDnsServerCache, DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory, long j, ResolvedAddressTypes resolvedAddressTypes, boolean z, int i, boolean z2, int i2, boolean z3, HostsFileEntriesResolver hostsFileEntriesResolver, DnsServerAddressStreamProvider dnsServerAddressStreamProvider, String[] strArr, int i3, boolean z4, boolean z5) {
        super(eventLoop);
        DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory2;
        this.queryContextManager = new DnsQueryContextManager();
        this.nameServerAddrStream = new FastThreadLocal<DnsServerAddressStream>() { // from class: io.netty.resolver.dns.DnsNameResolver.2
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.concurrent.FastThreadLocal
            public DnsServerAddressStream initialValue() {
                return DnsNameResolver.this.dnsServerAddressStreamProvider.nameServerAddressStream("");
            }
        };
        this.queryTimeoutMillis = j > 0 ? j : TimeUnit.SECONDS.toMillis(DEFAULT_OPTIONS.timeout());
        ResolvedAddressTypes resolvedAddressTypes2 = resolvedAddressTypes != null ? resolvedAddressTypes : DEFAULT_RESOLVE_ADDRESS_TYPES;
        this.resolvedAddressTypes = resolvedAddressTypes2;
        this.recursionDesired = z;
        this.maxQueriesPerResolve = i > 0 ? i : DEFAULT_OPTIONS.attempts();
        this.maxPayloadSize = ObjectUtil.checkPositive(i2, "maxPayloadSize");
        this.optResourceEnabled = z3;
        this.hostsFileEntriesResolver = (HostsFileEntriesResolver) ObjectUtil.checkNotNull(hostsFileEntriesResolver, "hostsFileEntriesResolver");
        this.dnsServerAddressStreamProvider = (DnsServerAddressStreamProvider) ObjectUtil.checkNotNull(dnsServerAddressStreamProvider, "dnsServerAddressStreamProvider");
        this.resolveCache = (DnsCache) ObjectUtil.checkNotNull(dnsCache, "resolveCache");
        this.cnameCache = (DnsCnameCache) ObjectUtil.checkNotNull(dnsCnameCache, "cnameCache");
        if (z2) {
            dnsQueryLifecycleObserverFactory2 = dnsQueryLifecycleObserverFactory instanceof NoopDnsQueryLifecycleObserverFactory ? new TraceDnsQueryLifeCycleObserverFactory() : new BiDnsQueryLifecycleObserverFactory(new TraceDnsQueryLifeCycleObserverFactory(), dnsQueryLifecycleObserverFactory);
        } else {
            dnsQueryLifecycleObserverFactory2 = (DnsQueryLifecycleObserverFactory) ObjectUtil.checkNotNull(dnsQueryLifecycleObserverFactory, "dnsQueryLifecycleObserverFactory");
        }
        this.dnsQueryLifecycleObserverFactory = dnsQueryLifecycleObserverFactory2;
        this.searchDomains = strArr != null ? (String[]) strArr.clone() : DEFAULT_SEARCH_DOMAINS;
        this.ndots = i3 >= 0 ? i3 : DEFAULT_OPTIONS.ndots();
        this.decodeIdn = z4;
        this.completeOncePreferredResolved = z5;
        this.socketChannelFactory = channelFactory2;
        int i4 = AnonymousClass7.$SwitchMap$io$netty$resolver$ResolvedAddressTypes[resolvedAddressTypes2.ordinal()];
        if (i4 == 1) {
            this.supportsAAAARecords = false;
            this.supportsARecords = true;
            this.resolveRecordTypes = IPV4_ONLY_RESOLVED_RECORD_TYPES;
            this.resolvedInternetProtocolFamilies = IPV4_ONLY_RESOLVED_PROTOCOL_FAMILIES;
        } else if (i4 == 2) {
            this.supportsAAAARecords = true;
            this.supportsARecords = true;
            this.resolveRecordTypes = IPV4_PREFERRED_RESOLVED_RECORD_TYPES;
            this.resolvedInternetProtocolFamilies = IPV4_PREFERRED_RESOLVED_PROTOCOL_FAMILIES;
        } else if (i4 == 3) {
            this.supportsAAAARecords = true;
            this.supportsARecords = false;
            this.resolveRecordTypes = IPV6_ONLY_RESOLVED_RECORD_TYPES;
            this.resolvedInternetProtocolFamilies = IPV6_ONLY_RESOLVED_PROTOCOL_FAMILIES;
        } else if (i4 == 4) {
            this.supportsAAAARecords = true;
            this.supportsARecords = true;
            this.resolveRecordTypes = IPV6_PREFERRED_RESOLVED_RECORD_TYPES;
            this.resolvedInternetProtocolFamilies = IPV6_PREFERRED_RESOLVED_PROTOCOL_FAMILIES;
        } else {
            throw new IllegalArgumentException("Unknown ResolvedAddressTypes " + resolvedAddressTypes);
        }
        InternetProtocolFamily preferredAddressType = preferredAddressType(resolvedAddressTypes2);
        this.preferredAddressType = preferredAddressType;
        this.authoritativeDnsServerCache = (AuthoritativeDnsServerCache) ObjectUtil.checkNotNull(authoritativeDnsServerCache, "authoritativeDnsServerCache");
        this.nameServerComparator = new NameServerComparator(preferredAddressType.addressType());
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(executor());
        bootstrap.channelFactory((ChannelFactory) channelFactory);
        bootstrap.option(ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION, Boolean.TRUE);
        final DnsResponseHandler dnsResponseHandler = new DnsResponseHandler(executor().newPromise());
        bootstrap.handler(new ChannelInitializer<DatagramChannel>() { // from class: io.netty.resolver.dns.DnsNameResolver.3
            /* JADX INFO: Access modifiers changed from: protected */
            public void initChannel(DatagramChannel datagramChannel) {
                datagramChannel.pipeline().addLast(DnsNameResolver.DATAGRAM_ENCODER, DnsNameResolver.DATAGRAM_DECODER, dnsResponseHandler);
            }
        });
        this.channelFuture = dnsResponseHandler.channelActivePromise;
        ChannelFuture register = bootstrap.register();
        Throwable cause = register.cause();
        if (cause == null) {
            Channel channel = register.channel();
            this.ch = channel;
            channel.config().setRecvByteBufAllocator(new FixedRecvByteBufAllocator(i2));
            channel.closeFuture().addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.resolver.dns.DnsNameResolver.4
                public void operationComplete(ChannelFuture channelFuture) {
                    dnsCache.clear();
                    dnsCnameCache.clear();
                    authoritativeDnsServerCache.clear();
                }
            });
        } else if (cause instanceof RuntimeException) {
            throw ((RuntimeException) cause);
        } else if (cause instanceof Error) {
            throw ((Error) cause);
        } else {
            throw new IllegalStateException("Unable to create / register Channel", cause);
        }
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(DnsQuestion dnsQuestion, Promise<AddressedEnvelope<? extends DnsResponse, InetSocketAddress>> promise) {
        return query(nextNameServerAddress(), dnsQuestion, Collections.emptyList(), promise);
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion) {
        return query0(inetSocketAddress, dnsQuestion, EMPTY_ADDITIONALS, true, this.ch.newPromise(), this.ch.eventLoop().newPromise());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final InternetProtocolFamily preferredAddressType() {
        return this.preferredAddressType;
    }

    public final Future<List<DnsRecord>> resolveAll(DnsQuestion dnsQuestion) {
        return resolveAll(dnsQuestion, EMPTY_ADDITIONALS, executor().newPromise());
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, Iterable<DnsRecord> iterable) {
        return query0(inetSocketAddress, dnsQuestion, toArray(iterable, false), true, this.ch.newPromise(), this.ch.eventLoop().newPromise());
    }

    public final Future<List<DnsRecord>> resolveAll(DnsQuestion dnsQuestion, Iterable<DnsRecord> iterable) {
        return resolveAll(dnsQuestion, iterable, executor().newPromise());
    }

    public final Future<List<DnsRecord>> resolveAll(DnsQuestion dnsQuestion, Iterable<DnsRecord> iterable, Promise<List<DnsRecord>> promise) {
        return resolveAll(dnsQuestion, toArray(iterable, true), promise);
    }

    private Future<List<DnsRecord>> resolveAll(DnsQuestion dnsQuestion, DnsRecord[] dnsRecordArr, Promise<List<DnsRecord>> promise) {
        InetAddress resolveHostsFileEntry;
        ObjectUtil.checkNotNull(dnsQuestion, "question");
        ObjectUtil.checkNotNull(promise, "promise");
        DnsRecordType type = dnsQuestion.type();
        String name = dnsQuestion.name();
        DnsRecordType dnsRecordType = DnsRecordType.A;
        if ((type == dnsRecordType || type == DnsRecordType.AAAA) && (resolveHostsFileEntry = resolveHostsFileEntry(name)) != null) {
            ByteBuf byteBuf = null;
            if (resolveHostsFileEntry instanceof Inet4Address) {
                if (type == dnsRecordType) {
                    byteBuf = Unpooled.wrappedBuffer(resolveHostsFileEntry.getAddress());
                }
            } else if ((resolveHostsFileEntry instanceof Inet6Address) && type == DnsRecordType.AAAA) {
                byteBuf = Unpooled.wrappedBuffer(resolveHostsFileEntry.getAddress());
            }
            if (byteBuf != null) {
                trySuccess(promise, Collections.singletonList(new DefaultDnsRawRecord(name, type, 86400L, byteBuf)));
                return promise;
            }
        }
        new DnsRecordResolveContext(this, promise, dnsQuestion, dnsRecordArr, this.dnsServerAddressStreamProvider.nameServerAddressStream(name)).resolve(promise);
        return promise;
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, Promise<AddressedEnvelope<? extends DnsResponse, InetSocketAddress>> promise) {
        return query0(inetSocketAddress, dnsQuestion, EMPTY_ADDITIONALS, true, this.ch.newPromise(), promise);
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, Iterable<DnsRecord> iterable, Promise<AddressedEnvelope<? extends DnsResponse, InetSocketAddress>> promise) {
        return query0(inetSocketAddress, dnsQuestion, toArray(iterable, false), true, this.ch.newPromise(), promise);
    }
}

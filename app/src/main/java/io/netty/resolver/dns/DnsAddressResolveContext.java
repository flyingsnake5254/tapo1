package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsRecordType;
import io.netty.util.concurrent.Promise;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class DnsAddressResolveContext extends DnsResolveContext<InetAddress> {
    private final AuthoritativeDnsServerCache authoritativeDnsServerCache;
    private final boolean completeEarlyIfPossible;
    private final DnsCache resolveCache;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DnsAddressResolveContext(DnsNameResolver dnsNameResolver, Promise<?> promise, String str, DnsRecord[] dnsRecordArr, DnsServerAddressStream dnsServerAddressStream, DnsCache dnsCache, AuthoritativeDnsServerCache authoritativeDnsServerCache, boolean z) {
        super(dnsNameResolver, promise, str, 1, dnsNameResolver.resolveRecordTypes(), dnsRecordArr, dnsServerAddressStream);
        this.resolveCache = dnsCache;
        this.authoritativeDnsServerCache = authoritativeDnsServerCache;
        this.completeEarlyIfPossible = z;
    }

    @Override // io.netty.resolver.dns.DnsResolveContext
    AuthoritativeDnsServerCache authoritativeDnsServerCache() {
        return this.authoritativeDnsServerCache;
    }

    @Override // io.netty.resolver.dns.DnsResolveContext
    void doSearchDomainQuery(String str, Promise<List<InetAddress>> promise) {
        if (!DnsNameResolver.doResolveAllCached(str, this.additionals, promise, this.resolveCache, this.parent.resolvedInternetProtocolFamiliesUnsafe())) {
            super.doSearchDomainQuery(str, promise);
        }
    }

    @Override // io.netty.resolver.dns.DnsResolveContext
    List<InetAddress> filterResults(List<InetAddress> list) {
        Collections.sort(list, PreferredAddressTypeComparator.comparator(this.parent.preferredAddressType()));
        return list;
    }

    @Override // io.netty.resolver.dns.DnsResolveContext
    boolean isDuplicateAllowed() {
        return false;
    }

    @Override // io.netty.resolver.dns.DnsResolveContext
    DnsResolveContext<InetAddress> newResolverContext(DnsNameResolver dnsNameResolver, Promise<?> promise, String str, int i, DnsRecordType[] dnsRecordTypeArr, DnsRecord[] dnsRecordArr, DnsServerAddressStream dnsServerAddressStream) {
        return new DnsAddressResolveContext(dnsNameResolver, promise, str, dnsRecordArr, dnsServerAddressStream, this.resolveCache, this.authoritativeDnsServerCache, this.completeEarlyIfPossible);
    }

    @Override // io.netty.resolver.dns.DnsResolveContext
    DnsCache resolveCache() {
        return this.resolveCache;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cache(String str, DnsRecord[] dnsRecordArr, DnsRecord dnsRecord, InetAddress inetAddress) {
        this.resolveCache.cache(str, dnsRecordArr, inetAddress, dnsRecord.timeToLive(), this.parent.ch.eventLoop());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.netty.resolver.dns.DnsResolveContext
    public InetAddress convertRecord(DnsRecord dnsRecord, String str, DnsRecord[] dnsRecordArr, EventLoop eventLoop) {
        return DnsAddressDecoder.decodeAddress(dnsRecord, str, this.parent.isDecodeIdn());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isCompleteEarly(InetAddress inetAddress) {
        return this.completeEarlyIfPossible && this.parent.preferredAddressType().addressType() == inetAddress.getClass();
    }

    @Override // io.netty.resolver.dns.DnsResolveContext
    void cache(String str, DnsRecord[] dnsRecordArr, UnknownHostException unknownHostException) {
        this.resolveCache.cache(str, dnsRecordArr, unknownHostException, this.parent.ch.eventLoop());
    }
}

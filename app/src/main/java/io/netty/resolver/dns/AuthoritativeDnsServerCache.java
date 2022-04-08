package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import java.net.InetSocketAddress;

/* loaded from: classes3.dex */
public interface AuthoritativeDnsServerCache {
    void cache(String str, InetSocketAddress inetSocketAddress, long j, EventLoop eventLoop);

    void clear();

    boolean clear(String str);

    DnsServerAddressStream get(String str);
}

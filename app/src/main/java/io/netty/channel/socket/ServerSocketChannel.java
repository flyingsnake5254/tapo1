package io.netty.channel.socket;

import io.netty.channel.a;
import java.net.InetSocketAddress;

/* loaded from: classes3.dex */
public interface ServerSocketChannel extends a {
    @Override // io.netty.channel.Channel
    ServerSocketChannelConfig config();

    @Override // io.netty.channel.Channel
    InetSocketAddress localAddress();

    @Override // io.netty.channel.Channel
    InetSocketAddress remoteAddress();
}

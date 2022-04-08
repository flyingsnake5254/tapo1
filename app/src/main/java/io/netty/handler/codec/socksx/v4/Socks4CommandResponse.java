package io.netty.handler.codec.socksx.v4;

import io.netty.handler.codec.socksx.SocksMessage;

/* loaded from: classes3.dex */
public interface Socks4CommandResponse extends SocksMessage {
    String dstAddr();

    int dstPort();

    Socks4CommandStatus status();
}

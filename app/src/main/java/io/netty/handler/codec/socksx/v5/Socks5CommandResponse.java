package io.netty.handler.codec.socksx.v5;

/* loaded from: classes3.dex */
public interface Socks5CommandResponse extends a {
    String bndAddr();

    Socks5AddressType bndAddrType();

    int bndPort();

    Socks5CommandStatus status();
}
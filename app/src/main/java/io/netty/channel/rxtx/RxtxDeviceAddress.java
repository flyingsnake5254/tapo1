package io.netty.channel.rxtx;

import java.net.SocketAddress;

@Deprecated
/* loaded from: classes3.dex */
public class RxtxDeviceAddress extends SocketAddress {
    private static final long serialVersionUID = -2907820090993709523L;
    private final String value;

    public RxtxDeviceAddress(String str) {
        this.value = str;
    }

    public String value() {
        return this.value;
    }
}

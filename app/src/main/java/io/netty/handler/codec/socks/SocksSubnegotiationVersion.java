package io.netty.handler.codec.socks;

/* loaded from: classes3.dex */
public enum SocksSubnegotiationVersion {
    AUTH_PASSWORD((byte) 1),
    UNKNOWN((byte) -1);
    

    /* renamed from: b  reason: collision with root package name */
    private final byte f15617b;

    SocksSubnegotiationVersion(byte b2) {
        this.f15617b = b2;
    }

    @Deprecated
    public static SocksSubnegotiationVersion fromByte(byte b2) {
        return valueOf(b2);
    }

    public byte byteValue() {
        return this.f15617b;
    }

    public static SocksSubnegotiationVersion valueOf(byte b2) {
        SocksSubnegotiationVersion[] values;
        for (SocksSubnegotiationVersion socksSubnegotiationVersion : values()) {
            if (socksSubnegotiationVersion.f15617b == b2) {
                return socksSubnegotiationVersion;
            }
        }
        return UNKNOWN;
    }
}

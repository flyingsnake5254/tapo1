package io.netty.handler.codec.socks;

/* loaded from: classes3.dex */
public enum SocksProtocolVersion {
    SOCKS4a((byte) 4),
    SOCKS5((byte) 5),
    UNKNOWN((byte) -1);
    

    /* renamed from: b  reason: collision with root package name */
    private final byte f15616b;

    SocksProtocolVersion(byte b2) {
        this.f15616b = b2;
    }

    @Deprecated
    public static SocksProtocolVersion fromByte(byte b2) {
        return valueOf(b2);
    }

    public byte byteValue() {
        return this.f15616b;
    }

    public static SocksProtocolVersion valueOf(byte b2) {
        SocksProtocolVersion[] values;
        for (SocksProtocolVersion socksProtocolVersion : values()) {
            if (socksProtocolVersion.f15616b == b2) {
                return socksProtocolVersion;
            }
        }
        return UNKNOWN;
    }
}

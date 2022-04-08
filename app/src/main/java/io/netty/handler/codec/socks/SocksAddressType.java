package io.netty.handler.codec.socks;

/* loaded from: classes3.dex */
public enum SocksAddressType {
    IPv4((byte) 1),
    DOMAIN((byte) 3),
    IPv6((byte) 4),
    UNKNOWN((byte) -1);
    

    /* renamed from: b  reason: collision with root package name */
    private final byte f15611b;

    SocksAddressType(byte b2) {
        this.f15611b = b2;
    }

    @Deprecated
    public static SocksAddressType fromByte(byte b2) {
        return valueOf(b2);
    }

    public byte byteValue() {
        return this.f15611b;
    }

    public static SocksAddressType valueOf(byte b2) {
        SocksAddressType[] values;
        for (SocksAddressType socksAddressType : values()) {
            if (socksAddressType.f15611b == b2) {
                return socksAddressType;
            }
        }
        return UNKNOWN;
    }
}

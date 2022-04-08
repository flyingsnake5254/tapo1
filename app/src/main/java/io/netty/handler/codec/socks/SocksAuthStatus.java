package io.netty.handler.codec.socks;

/* loaded from: classes3.dex */
public enum SocksAuthStatus {
    SUCCESS((byte) 0),
    FAILURE((byte) -1);
    

    /* renamed from: b  reason: collision with root package name */
    private final byte f15613b;

    SocksAuthStatus(byte b2) {
        this.f15613b = b2;
    }

    @Deprecated
    public static SocksAuthStatus fromByte(byte b2) {
        return valueOf(b2);
    }

    public byte byteValue() {
        return this.f15613b;
    }

    public static SocksAuthStatus valueOf(byte b2) {
        SocksAuthStatus[] values;
        for (SocksAuthStatus socksAuthStatus : values()) {
            if (socksAuthStatus.f15613b == b2) {
                return socksAuthStatus;
            }
        }
        return FAILURE;
    }
}

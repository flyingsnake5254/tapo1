package io.netty.handler.codec.socks;

/* loaded from: classes3.dex */
public enum SocksAuthScheme {
    NO_AUTH((byte) 0),
    AUTH_GSSAPI((byte) 1),
    AUTH_PASSWORD((byte) 2),
    UNKNOWN((byte) -1);
    

    /* renamed from: b  reason: collision with root package name */
    private final byte f15612b;

    SocksAuthScheme(byte b2) {
        this.f15612b = b2;
    }

    @Deprecated
    public static SocksAuthScheme fromByte(byte b2) {
        return valueOf(b2);
    }

    public byte byteValue() {
        return this.f15612b;
    }

    public static SocksAuthScheme valueOf(byte b2) {
        SocksAuthScheme[] values;
        for (SocksAuthScheme socksAuthScheme : values()) {
            if (socksAuthScheme.f15612b == b2) {
                return socksAuthScheme;
            }
        }
        return UNKNOWN;
    }
}

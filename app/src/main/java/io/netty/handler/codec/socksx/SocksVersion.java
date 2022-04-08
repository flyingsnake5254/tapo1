package io.netty.handler.codec.socksx;

/* loaded from: classes3.dex */
public enum SocksVersion {
    SOCKS4a((byte) 4),
    SOCKS5((byte) 5),
    UNKNOWN((byte) -1);
    

    /* renamed from: b  reason: collision with root package name */
    private final byte f15618b;

    SocksVersion(byte b2) {
        this.f15618b = b2;
    }

    public byte byteValue() {
        return this.f15618b;
    }

    public static SocksVersion valueOf(byte b2) {
        SocksVersion socksVersion = SOCKS4a;
        if (b2 == socksVersion.byteValue()) {
            return socksVersion;
        }
        SocksVersion socksVersion2 = SOCKS5;
        return b2 == socksVersion2.byteValue() ? socksVersion2 : UNKNOWN;
    }
}

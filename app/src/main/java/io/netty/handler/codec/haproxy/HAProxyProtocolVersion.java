package io.netty.handler.codec.haproxy;

import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;

/* loaded from: classes3.dex */
public enum HAProxyProtocolVersion {
    V1(BinaryMemcacheOpcodes.STAT),
    V2((byte) 32);
    
    private static final byte VERSION_MASK = -16;
    private final byte byteValue;

    HAProxyProtocolVersion(byte b2) {
        this.byteValue = b2;
    }

    public byte byteValue() {
        return this.byteValue;
    }

    public static HAProxyProtocolVersion valueOf(byte b2) {
        int i = b2 & VERSION_MASK;
        byte b3 = (byte) i;
        if (b3 == 16) {
            return V1;
        }
        if (b3 == 32) {
            return V2;
        }
        throw new IllegalArgumentException("unknown version: " + i);
    }
}

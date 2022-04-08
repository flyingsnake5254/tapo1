package io.netty.handler.codec.haproxy;

import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;

/* JADX WARN: Init of enum TCP4 can be incorrect */
/* JADX WARN: Init of enum TCP6 can be incorrect */
/* JADX WARN: Init of enum UDP4 can be incorrect */
/* JADX WARN: Init of enum UDP6 can be incorrect */
/* JADX WARN: Init of enum UNIX_DGRAM can be incorrect */
/* JADX WARN: Init of enum UNIX_STREAM can be incorrect */
/* loaded from: classes3.dex */
public enum HAProxyProxiedProtocol {
    UNKNOWN((byte) 0, AddressFamily.AF_UNSPEC, TransportProtocol.UNSPEC),
    TCP4(BinaryMemcacheOpcodes.SETQ, r1, r2),
    TCP6(BinaryMemcacheOpcodes.SASL_AUTH, r4, r2),
    UDP4(BinaryMemcacheOpcodes.ADDQ, r1, r13),
    UDP6((byte) 34, r4, r13),
    UNIX_STREAM((byte) 49, r14, r2),
    UNIX_DGRAM((byte) 50, r14, r13);
    
    private final AddressFamily addressFamily;
    private final byte byteValue;
    private final TransportProtocol transportProtocol;

    /* loaded from: classes3.dex */
    public enum AddressFamily {
        AF_UNSPEC((byte) 0),
        AF_IPv4(BinaryMemcacheOpcodes.STAT),
        AF_IPv6((byte) 32),
        AF_UNIX((byte) 48);
        
        private static final byte FAMILY_MASK = -16;
        private final byte byteValue;

        AddressFamily(byte b2) {
            this.byteValue = b2;
        }

        public byte byteValue() {
            return this.byteValue;
        }

        public static AddressFamily valueOf(byte b2) {
            int i = b2 & FAMILY_MASK;
            byte b3 = (byte) i;
            if (b3 == 0) {
                return AF_UNSPEC;
            }
            if (b3 == 16) {
                return AF_IPv4;
            }
            if (b3 == 32) {
                return AF_IPv6;
            }
            if (b3 == 48) {
                return AF_UNIX;
            }
            throw new IllegalArgumentException("unknown address family: " + i);
        }
    }

    /* loaded from: classes3.dex */
    public enum TransportProtocol {
        UNSPEC((byte) 0),
        STREAM((byte) 1),
        DGRAM((byte) 2);
        
        private static final byte TRANSPORT_MASK = 15;
        private final byte transportByte;

        TransportProtocol(byte b2) {
            this.transportByte = b2;
        }

        public byte byteValue() {
            return this.transportByte;
        }

        public static TransportProtocol valueOf(byte b2) {
            int i = b2 & 15;
            byte b3 = (byte) i;
            if (b3 == 0) {
                return UNSPEC;
            }
            if (b3 == 1) {
                return STREAM;
            }
            if (b3 == 2) {
                return DGRAM;
            }
            throw new IllegalArgumentException("unknown transport protocol: " + i);
        }
    }

    static {
        AddressFamily addressFamily = AddressFamily.AF_IPv4;
        TransportProtocol transportProtocol = TransportProtocol.STREAM;
        AddressFamily addressFamily2 = AddressFamily.AF_IPv6;
        TransportProtocol transportProtocol2 = TransportProtocol.DGRAM;
        AddressFamily addressFamily3 = AddressFamily.AF_UNIX;
    }

    HAProxyProxiedProtocol(byte b2, AddressFamily addressFamily, TransportProtocol transportProtocol) {
        this.byteValue = b2;
        this.addressFamily = addressFamily;
        this.transportProtocol = transportProtocol;
    }

    public AddressFamily addressFamily() {
        return this.addressFamily;
    }

    public byte byteValue() {
        return this.byteValue;
    }

    public TransportProtocol transportProtocol() {
        return this.transportProtocol;
    }

    public static HAProxyProxiedProtocol valueOf(byte b2) {
        if (b2 == 0) {
            return UNKNOWN;
        }
        if (b2 == 17) {
            return TCP4;
        }
        if (b2 == 18) {
            return UDP4;
        }
        if (b2 == 33) {
            return TCP6;
        }
        if (b2 == 34) {
            return UDP6;
        }
        if (b2 == 49) {
            return UNIX_STREAM;
        }
        if (b2 == 50) {
            return UNIX_DGRAM;
        }
        throw new IllegalArgumentException("unknown transport protocol + address family: " + (b2 & 255));
    }
}

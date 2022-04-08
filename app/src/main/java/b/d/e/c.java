package b.d.e;

import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import io.netty.handler.codec.memcache.binary.DefaultBinaryMemcacheRequest;

/* compiled from: G711Utils.java */
/* loaded from: classes3.dex */
public class c {
    private static final short[] a = {255, 511, 1023, 2047, 4095, 8191, 16383, Short.MAX_VALUE};

    /* renamed from: b  reason: collision with root package name */
    private static final short[] f388b = {63, 127, 255, 511, 1023, 2047, 4095, 8191};

    public static byte[] a(byte[] bArr, int i) {
        byte[] bArr2 = new byte[i << 1];
        for (int i2 = 0; i2 < i; i2++) {
            short c2 = c(bArr[i2]);
            int i3 = i2 * 2;
            bArr2[i3] = (byte) c2;
            bArr2[i3 + 1] = (byte) (c2 >> 8);
        }
        return bArr2;
    }

    public static byte[] b(byte[] bArr, int i) {
        int i2 = i / 2;
        byte[] bArr2 = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * 2;
            bArr2[i3] = d((short) (((bArr[i4 + 1] & 255) << 8) | (bArr[i4] & 255)));
        }
        return bArr2;
    }

    private static short c(byte b2) {
        byte b3 = (byte) (b2 ^ 85);
        short s = (short) ((b3 & BinaryMemcacheOpcodes.PREPEND) << 4);
        short s2 = (short) ((b3 & 112) >> 4);
        short s3 = (short) (s2 != 0 ? s2 != 1 ? ((short) (s + 264)) << (s2 - 1) : s + 264 : s + 8);
        return (b3 & DefaultBinaryMemcacheRequest.REQUEST_MAGIC_BYTE) != 0 ? s3 : (short) (-s3);
    }

    private static byte d(short s) {
        char c2;
        int i;
        if (s >= 0) {
            c2 = 213;
        } else {
            c2 = 'U';
            s = (short) ((-s) - 1);
            if (s < 0) {
                s = Short.MAX_VALUE;
            }
        }
        short e2 = e(s, a, (short) 8);
        if (e2 >= 8) {
            i = c2 ^ 127;
        } else {
            i = ((char) (((e2 < 2 ? s >> 4 : s >> (e2 + 3)) & 15) | ((char) (e2 << 4)))) ^ c2;
        }
        return (byte) i;
    }

    private static short e(short s, short[] sArr, short s2) {
        for (short s3 = 0; s3 < s2; s3 = (short) (s3 + 1)) {
            if (s <= sArr[s3]) {
                return s3;
            }
        }
        return s2;
    }

    public static byte[] f(short[] sArr) {
        int length = sArr.length;
        byte[] bArr = new byte[length << 1];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i2] = (byte) sArr[i];
            bArr[i2 + 1] = (byte) (sArr[i] >> 8);
        }
        return bArr;
    }
}

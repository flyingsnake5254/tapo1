package b.d.w.e;

import java.nio.ByteOrder;

/* compiled from: ByteOrderUtils.java */
/* loaded from: classes3.dex */
public class a {
    public static int a(byte[] bArr) {
        return (bArr[3] & 255) | ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8);
    }

    public static short b(byte[] bArr) {
        return (short) ((bArr[1] & 255) | ((bArr[0] & 255) << 8));
    }

    public static byte[] c(int i) {
        if (ByteOrder.LITTLE_ENDIAN == ByteOrder.nativeOrder()) {
            return i(i);
        }
        return k(i);
    }

    public static byte[] d(short s) {
        if (ByteOrder.LITTLE_ENDIAN == ByteOrder.nativeOrder()) {
            return j(s);
        }
        return l(s);
    }

    public static int e(byte[] bArr) {
        return ((bArr[3] & 255) << 24) | (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16);
    }

    public static short f(byte[] bArr) {
        return (short) (((bArr[1] & 255) << 8) | (bArr[0] & 255));
    }

    public static int g(byte[] bArr) {
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            return e(bArr);
        }
        return a(bArr);
    }

    public static short h(byte[] bArr) {
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            return f(bArr);
        }
        return b(bArr);
    }

    public static byte[] i(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static byte[] j(short s) {
        return new byte[]{(byte) ((s >> 8) & 255), (byte) (s & 255)};
    }

    public static byte[] k(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)};
    }

    public static byte[] l(short s) {
        return new byte[]{(byte) (s & 255), (byte) ((s >> 8) & 255)};
    }
}

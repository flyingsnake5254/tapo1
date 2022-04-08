package b.d.c0.m;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: TLVByteUtils.java */
/* loaded from: classes3.dex */
public class b {
    public static String a(int i) {
        return ((i >> 24) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 8) & 255) + "." + (i & 255);
    }

    public static char b(byte[] bArr) {
        return ByteBuffer.wrap(bArr, 0, 2).order(ByteOrder.BIG_ENDIAN).getChar();
    }

    public static double c(byte[] bArr) {
        return ByteBuffer.wrap(bArr, 0, 8).order(ByteOrder.BIG_ENDIAN).getDouble();
    }

    public static float d(byte[] bArr) {
        return ByteBuffer.wrap(bArr, 0, 4).order(ByteOrder.BIG_ENDIAN).getFloat();
    }

    public static int e(byte[] bArr) {
        return ByteBuffer.wrap(bArr, 0, 4).order(ByteOrder.BIG_ENDIAN).getInt();
    }

    public static long f(byte[] bArr) {
        return ByteBuffer.wrap(bArr, 0, 8).order(ByteOrder.BIG_ENDIAN).getLong();
    }

    public static short g(byte[] bArr) {
        return ByteBuffer.wrap(bArr, 0, 2).order(ByteOrder.BIG_ENDIAN).getShort();
    }
}

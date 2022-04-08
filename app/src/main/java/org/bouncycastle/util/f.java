package org.bouncycastle.util;

import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;

/* loaded from: classes4.dex */
public abstract class f {
    public static int a(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return (bArr[i3 + 1] & 255) | (bArr[i] << BinaryMemcacheOpcodes.FLUSHQ) | ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8);
    }

    public static long b(byte[] bArr, int i) {
        int a = a(bArr, i);
        return (a(bArr, i + 4) & 4294967295L) | ((a & 4294967295L) << 32);
    }

    public static void c(byte[] bArr, int i, long[] jArr) {
        for (int i2 = 0; i2 < jArr.length; i2++) {
            jArr[i2] = b(bArr, i);
            i += 8;
        }
    }

    public static void d(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >>> 24);
        int i3 = i2 + 1;
        bArr[i3] = (byte) (i >>> 16);
        int i4 = i3 + 1;
        bArr[i4] = (byte) (i >>> 8);
        bArr[i4 + 1] = (byte) i;
    }

    public static void e(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        int i3 = i2 + 1;
        bArr[i3] = (byte) (i >>> 8);
        int i4 = i3 + 1;
        bArr[i4] = (byte) (i >>> 16);
        bArr[i4 + 1] = (byte) (i >>> 24);
    }

    public static void f(int[] iArr, byte[] bArr, int i) {
        for (int i2 : iArr) {
            e(i2, bArr, i);
            i += 4;
        }
    }

    public static int g(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return (bArr[i3 + 1] << BinaryMemcacheOpcodes.FLUSHQ) | (bArr[i] & 255) | ((bArr[i2] & 255) << 8) | ((bArr[i3] & 255) << 16);
    }

    public static void h(byte[] bArr, int i, int[] iArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            iArr[i2 + i4] = g(bArr, i);
            i += 4;
        }
    }

    public static int[] i(byte[] bArr, int i, int i2) {
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = g(bArr, i);
            i += 4;
        }
        return iArr;
    }

    public static long j(byte[] bArr, int i) {
        return ((g(bArr, i + 4) & 4294967295L) << 32) | (g(bArr, i) & 4294967295L);
    }

    public static short k(byte[] bArr, int i) {
        return (short) (((bArr[i + 1] & 255) << 8) | (bArr[i] & 255));
    }

    public static void l(long j, byte[] bArr, int i) {
        d((int) (j >>> 32), bArr, i);
        d((int) (j & 4294967295L), bArr, i + 4);
    }

    public static void m(long[] jArr, byte[] bArr, int i) {
        for (long j : jArr) {
            l(j, bArr, i);
            i += 8;
        }
    }

    public static byte[] n(long j) {
        byte[] bArr = new byte[8];
        l(j, bArr, 0);
        return bArr;
    }

    public static void o(long j, byte[] bArr, int i) {
        e((int) (4294967295L & j), bArr, i);
        e((int) (j >>> 32), bArr, i + 4);
    }

    public static void p(long[] jArr, int i, int i2, byte[] bArr, int i3) {
        for (int i4 = 0; i4 < i2; i4++) {
            o(jArr[i + i4], bArr, i3);
            i3 += 8;
        }
    }

    public static byte[] q(long j) {
        byte[] bArr = new byte[8];
        o(j, bArr, 0);
        return bArr;
    }

    public static void r(short s, byte[] bArr, int i) {
        bArr[i] = (byte) s;
        bArr[i + 1] = (byte) (s >>> 8);
    }
}

package e.a.b.a.a0.c;

import e.a.b.c.c;
import e.a.b.c.g;
import e.a.b.c.m;
import java.math.BigInteger;

/* loaded from: classes4.dex */
public class b {
    static final int[] a = {-1, -1, -1, -3};

    /* renamed from: b  reason: collision with root package name */
    static final int[] f15356b = {1, 0, 0, 4, -2, -1, 3, -4};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f15357c = {-1, -1, -1, -5, 1, 0, -4, 3};

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (c.a(iArr, iArr2, iArr3) != 0 || ((iArr3[3] >>> 1) >= 2147483646 && c.n(iArr3, a))) {
            c(iArr3);
        }
    }

    public static void b(int[] iArr, int[] iArr2) {
        if (m.s(4, iArr, iArr2) != 0 || ((iArr2[3] >>> 1) >= 2147483646 && c.n(iArr2, a))) {
            c(iArr2);
        }
    }

    private static void c(int[] iArr) {
        long j = (iArr[0] & 4294967295L) + 1;
        iArr[0] = (int) j;
        long j2 = j >> 32;
        if (j2 != 0) {
            long j3 = j2 + (iArr[1] & 4294967295L);
            iArr[1] = (int) j3;
            long j4 = (j3 >> 32) + (iArr[2] & 4294967295L);
            iArr[2] = (int) j4;
            j2 = j4 >> 32;
        }
        iArr[3] = (int) (j2 + (4294967295L & iArr[3]) + 2);
    }

    public static int[] d(BigInteger bigInteger) {
        int[] k = c.k(bigInteger);
        if ((k[3] >>> 1) >= 2147483646) {
            int[] iArr = a;
            if (c.n(k, iArr)) {
                c.w(iArr, k);
            }
        }
        return k;
    }

    public static void e(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] g = c.g();
        c.s(iArr, iArr2, g);
        h(g, iArr3);
    }

    public static void f(int[] iArr, int[] iArr2, int[] iArr3) {
        if (c.t(iArr, iArr2, iArr3) != 0 || ((iArr3[7] >>> 1) >= 2147483646 && g.s(iArr3, f15356b))) {
            int[] iArr4 = f15357c;
            m.e(iArr4.length, iArr4, iArr3);
        }
    }

    public static void g(int[] iArr, int[] iArr2) {
        if (c.q(iArr)) {
            c.z(iArr2);
        } else {
            c.v(a, iArr, iArr2);
        }
    }

    public static void h(int[] iArr, int[] iArr2) {
        long j = iArr[7] & 4294967295L;
        long j2 = (iArr[3] & 4294967295L) + j;
        long j3 = (iArr[6] & 4294967295L) + (j << 1);
        long j4 = (iArr[2] & 4294967295L) + j3;
        long j5 = (iArr[5] & 4294967295L) + (j3 << 1);
        long j6 = (iArr[1] & 4294967295L) + j5;
        long j7 = (iArr[4] & 4294967295L) + (j5 << 1);
        long j8 = (iArr[0] & 4294967295L) + j7;
        iArr2[0] = (int) j8;
        long j9 = j6 + (j8 >>> 32);
        iArr2[1] = (int) j9;
        long j10 = j4 + (j9 >>> 32);
        iArr2[2] = (int) j10;
        long j11 = j2 + (j7 << 1) + (j10 >>> 32);
        iArr2[3] = (int) j11;
        i((int) (j11 >>> 32), iArr2);
    }

    public static void i(int i, int[] iArr) {
        while (i != 0) {
            long j = i & 4294967295L;
            long j2 = (iArr[0] & 4294967295L) + j;
            iArr[0] = (int) j2;
            long j3 = j2 >> 32;
            if (j3 != 0) {
                long j4 = j3 + (iArr[1] & 4294967295L);
                iArr[1] = (int) j4;
                long j5 = (j4 >> 32) + (iArr[2] & 4294967295L);
                iArr[2] = (int) j5;
                j3 = j5 >> 32;
            }
            long j6 = j3 + (4294967295L & iArr[3]) + (j << 1);
            iArr[3] = (int) j6;
            i = (int) (j6 >> 32);
        }
    }

    public static void j(int[] iArr, int[] iArr2) {
        int[] g = c.g();
        c.u(iArr, g);
        h(g, iArr2);
    }

    public static void k(int[] iArr, int i, int[] iArr2) {
        int[] g = c.g();
        c.u(iArr, g);
        while (true) {
            h(g, iArr2);
            i--;
            if (i > 0) {
                c.u(iArr2, g);
            } else {
                return;
            }
        }
    }

    private static void l(int[] iArr) {
        long j = (iArr[0] & 4294967295L) - 1;
        iArr[0] = (int) j;
        long j2 = j >> 32;
        if (j2 != 0) {
            long j3 = j2 + (iArr[1] & 4294967295L);
            iArr[1] = (int) j3;
            long j4 = (j3 >> 32) + (iArr[2] & 4294967295L);
            iArr[2] = (int) j4;
            j2 = j4 >> 32;
        }
        iArr[3] = (int) (j2 + ((4294967295L & iArr[3]) - 2));
    }

    public static void m(int[] iArr, int[] iArr2, int[] iArr3) {
        if (c.v(iArr, iArr2, iArr3) != 0) {
            l(iArr3);
        }
    }

    public static void n(int[] iArr, int[] iArr2) {
        if (m.E(4, iArr, 0, iArr2) != 0 || ((iArr2[3] >>> 1) >= 2147483646 && c.n(iArr2, a))) {
            c(iArr2);
        }
    }
}

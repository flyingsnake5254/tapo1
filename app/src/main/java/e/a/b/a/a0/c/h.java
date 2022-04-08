package e.a.b.a.a0.c;

import e.a.b.c.d;
import e.a.b.c.m;
import java.math.BigInteger;

/* loaded from: classes4.dex */
public class h {
    static final int[] a = {Integer.MAX_VALUE, -1, -1, -1, -1};

    /* renamed from: b  reason: collision with root package name */
    static final int[] f15376b = {1, 1073741825, 0, 0, 0, -2, -2, -1, -1, -1};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f15377c = {-1, -1073741826, -1, -1, -1, 1, 1};

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (d.a(iArr, iArr2, iArr3) != 0 || (iArr3[4] == -1 && d.i(iArr3, a))) {
            m.g(5, -2147483647, iArr3);
        }
    }

    public static void b(int[] iArr, int[] iArr2) {
        if (m.s(5, iArr, iArr2) != 0 || (iArr2[4] == -1 && d.i(iArr2, a))) {
            m.g(5, -2147483647, iArr2);
        }
    }

    public static int[] c(BigInteger bigInteger) {
        int[] g = d.g(bigInteger);
        if (g[4] == -1) {
            int[] iArr = a;
            if (d.i(g, iArr)) {
                d.t(iArr, g);
            }
        }
        return g;
    }

    public static void d(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] e2 = d.e();
        d.l(iArr, iArr2, e2);
        g(e2, iArr3);
    }

    public static void e(int[] iArr, int[] iArr2, int[] iArr3) {
        if (d.p(iArr, iArr2, iArr3) != 0 || (iArr3[9] == -1 && m.q(10, iArr3, f15376b))) {
            int[] iArr4 = f15377c;
            if (m.e(iArr4.length, iArr4, iArr3) != 0) {
                m.t(10, iArr3, iArr4.length);
            }
        }
    }

    public static void f(int[] iArr, int[] iArr2) {
        if (d.k(iArr)) {
            d.v(iArr2);
        } else {
            d.s(a, iArr, iArr2);
        }
    }

    public static void g(int[] iArr, int[] iArr2) {
        long j = iArr[5] & 4294967295L;
        long j2 = iArr[6] & 4294967295L;
        long j3 = iArr[7] & 4294967295L;
        long j4 = iArr[8] & 4294967295L;
        long j5 = iArr[9] & 4294967295L;
        long j6 = (iArr[0] & 4294967295L) + j + (j << 31) + 0;
        iArr2[0] = (int) j6;
        long j7 = (j6 >>> 32) + (iArr[1] & 4294967295L) + j2 + (j2 << 31);
        iArr2[1] = (int) j7;
        long j8 = (j7 >>> 32) + (iArr[2] & 4294967295L) + j3 + (j3 << 31);
        iArr2[2] = (int) j8;
        long j9 = (j8 >>> 32) + (iArr[3] & 4294967295L) + j4 + (j4 << 31);
        iArr2[3] = (int) j9;
        long j10 = (j9 >>> 32) + (4294967295L & iArr[4]) + j5 + (j5 << 31);
        iArr2[4] = (int) j10;
        h((int) (j10 >>> 32), iArr2);
    }

    public static void h(int i, int[] iArr) {
        if ((i != 0 && d.q(-2147483647, i, iArr, 0) != 0) || (iArr[4] == -1 && d.i(iArr, a))) {
            m.g(5, -2147483647, iArr);
        }
    }

    public static void i(int[] iArr, int[] iArr2) {
        int[] e2 = d.e();
        d.r(iArr, e2);
        g(e2, iArr2);
    }

    public static void j(int[] iArr, int i, int[] iArr2) {
        int[] e2 = d.e();
        d.r(iArr, e2);
        while (true) {
            g(e2, iArr2);
            i--;
            if (i > 0) {
                d.r(iArr2, e2);
            } else {
                return;
            }
        }
    }

    public static void k(int[] iArr, int[] iArr2, int[] iArr3) {
        if (d.s(iArr, iArr2, iArr3) != 0) {
            m.O(5, -2147483647, iArr3);
        }
    }

    public static void l(int[] iArr, int[] iArr2) {
        if (m.E(5, iArr, 0, iArr2) != 0 || (iArr2[4] == -1 && d.i(iArr2, a))) {
            m.g(5, -2147483647, iArr2);
        }
    }
}

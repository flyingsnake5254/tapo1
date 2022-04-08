package e.a.b.a.a0.c;

import e.a.b.c.d;
import e.a.b.c.m;
import java.math.BigInteger;

/* loaded from: classes4.dex */
public class l {
    static final int[] a = {-21389, -2, -1, -1, -1};

    /* renamed from: b  reason: collision with root package name */
    static final int[] f15389b = {457489321, 42778, 1, 0, 0, -42778, -3, -1, -1, -1};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f15390c = {-457489321, -42779, -2, -1, -1, 42777, 2};

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (d.a(iArr, iArr2, iArr3) != 0 || (iArr3[4] == -1 && d.i(iArr3, a))) {
            m.b(5, 21389, iArr3);
        }
    }

    public static void b(int[] iArr, int[] iArr2) {
        if (m.s(5, iArr, iArr2) != 0 || (iArr2[4] == -1 && d.i(iArr2, a))) {
            m.b(5, 21389, iArr2);
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
        if (d.p(iArr, iArr2, iArr3) != 0 || (iArr3[9] == -1 && m.q(10, iArr3, f15389b))) {
            int[] iArr4 = f15390c;
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
        if (d.n(21389, d.m(21389, iArr, 5, iArr, 0, iArr2, 0), iArr2, 0) != 0 || (iArr2[4] == -1 && d.i(iArr2, a))) {
            m.b(5, 21389, iArr2);
        }
    }

    public static void h(int i, int[] iArr) {
        if ((i != 0 && d.o(21389, i, iArr, 0) != 0) || (iArr[4] == -1 && d.i(iArr, a))) {
            m.b(5, 21389, iArr);
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
            m.L(5, 21389, iArr3);
        }
    }

    public static void l(int[] iArr, int[] iArr2) {
        if (m.E(5, iArr, 0, iArr2) != 0 || (iArr2[4] == -1 && d.i(iArr2, a))) {
            m.b(5, 21389, iArr2);
        }
    }
}

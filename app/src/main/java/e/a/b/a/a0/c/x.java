package e.a.b.a.a0.c;

import e.a.b.c.f;
import e.a.b.c.m;
import java.math.BigInteger;

/* loaded from: classes4.dex */
public class x {
    static final int[] a = {-6803, -2, -1, -1, -1, -1, -1};

    /* renamed from: b  reason: collision with root package name */
    static final int[] f15425b = {46280809, 13606, 1, 0, 0, 0, 0, -13606, -3, -1, -1, -1, -1, -1};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f15426c = {-46280809, -13607, -2, -1, -1, -1, -1, 13605, 2};

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (f.a(iArr, iArr2, iArr3) != 0 || (iArr3[6] == -1 && f.j(iArr3, a))) {
            m.b(7, 6803, iArr3);
        }
    }

    public static void b(int[] iArr, int[] iArr2) {
        if (m.s(7, iArr, iArr2) != 0 || (iArr2[6] == -1 && f.j(iArr2, a))) {
            m.b(7, 6803, iArr2);
        }
    }

    public static int[] c(BigInteger bigInteger) {
        int[] h = f.h(bigInteger);
        if (h[6] == -1 && f.j(h, a)) {
            m.b(7, 6803, h);
        }
        return h;
    }

    public static void d(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] f2 = f.f();
        f.m(iArr, iArr2, f2);
        g(f2, iArr3);
    }

    public static void e(int[] iArr, int[] iArr2, int[] iArr3) {
        if (f.q(iArr, iArr2, iArr3) != 0 || (iArr3[13] == -1 && m.q(14, iArr3, f15425b))) {
            int[] iArr4 = f15426c;
            if (m.e(iArr4.length, iArr4, iArr3) != 0) {
                m.t(14, iArr3, iArr4.length);
            }
        }
    }

    public static void f(int[] iArr, int[] iArr2) {
        if (f.l(iArr)) {
            f.v(iArr2);
        } else {
            f.s(a, iArr, iArr2);
        }
    }

    public static void g(int[] iArr, int[] iArr2) {
        if (f.o(6803, f.n(6803, iArr, 7, iArr, 0, iArr2, 0), iArr2, 0) != 0 || (iArr2[6] == -1 && f.j(iArr2, a))) {
            m.b(7, 6803, iArr2);
        }
    }

    public static void h(int i, int[] iArr) {
        if ((i != 0 && f.p(6803, i, iArr, 0) != 0) || (iArr[6] == -1 && f.j(iArr, a))) {
            m.b(7, 6803, iArr);
        }
    }

    public static void i(int[] iArr, int[] iArr2) {
        int[] f2 = f.f();
        f.r(iArr, f2);
        g(f2, iArr2);
    }

    public static void j(int[] iArr, int i, int[] iArr2) {
        int[] f2 = f.f();
        f.r(iArr, f2);
        while (true) {
            g(f2, iArr2);
            i--;
            if (i > 0) {
                f.r(iArr2, f2);
            } else {
                return;
            }
        }
    }

    public static void k(int[] iArr, int[] iArr2, int[] iArr3) {
        if (f.s(iArr, iArr2, iArr3) != 0) {
            m.L(7, 6803, iArr3);
        }
    }

    public static void l(int[] iArr, int[] iArr2) {
        if (m.E(7, iArr, 0, iArr2) != 0 || (iArr2[6] == -1 && f.j(iArr2, a))) {
            m.b(7, 6803, iArr2);
        }
    }
}

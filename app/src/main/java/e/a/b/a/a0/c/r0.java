package e.a.b.a.a0.c;

import androidx.core.app.FrameMetricsAggregator;
import e.a.b.c.k;
import e.a.b.c.m;
import java.math.BigInteger;

/* loaded from: classes4.dex */
public class r0 {
    static final int[] a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, FrameMetricsAggregator.EVERY_DURATION};

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        int a2 = m.a(16, iArr, iArr2, iArr3) + iArr[16] + iArr2[16];
        if (a2 > 511 || (a2 == 511 && m.n(16, iArr3, a))) {
            a2 = (a2 + m.r(16, iArr3)) & FrameMetricsAggregator.EVERY_DURATION;
        }
        iArr3[16] = a2;
    }

    public static void b(int[] iArr, int[] iArr2) {
        int s = m.s(16, iArr, iArr2) + iArr[16];
        if (s > 511 || (s == 511 && m.n(16, iArr2, a))) {
            s = (s + m.r(16, iArr2)) & FrameMetricsAggregator.EVERY_DURATION;
        }
        iArr2[16] = s;
    }

    public static int[] c(BigInteger bigInteger) {
        int[] o = m.o(521, bigInteger);
        if (m.n(17, o, a)) {
            m.Q(17, o);
        }
        return o;
    }

    protected static void d(int[] iArr, int[] iArr2, int[] iArr3) {
        k.a(iArr, iArr2, iArr3);
        int i = iArr[16];
        int i2 = iArr2[16];
        iArr3[32] = m.x(16, i, iArr2, i2, iArr, iArr3, 16) + (i * i2);
    }

    protected static void e(int[] iArr, int[] iArr2) {
        k.b(iArr, iArr2);
        int i = iArr[16];
        iArr2[32] = m.y(16, i << 1, iArr, 0, iArr2, 16) + (i * i);
    }

    public static void f(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] j = m.j(33);
        d(iArr, iArr2, j);
        h(j, iArr3);
    }

    public static void g(int[] iArr, int[] iArr2) {
        if (m.w(17, iArr)) {
            m.Q(17, iArr2);
        } else {
            m.K(17, a, iArr, iArr2);
        }
    }

    public static void h(int[] iArr, int[] iArr2) {
        int i = iArr[32];
        int B = (m.B(16, iArr, 16, 9, i, iArr2, 0) >>> 23) + (i >>> 9) + m.e(16, iArr, iArr2);
        if (B > 511 || (B == 511 && m.n(16, iArr2, a))) {
            B = (B + m.r(16, iArr2)) & FrameMetricsAggregator.EVERY_DURATION;
        }
        iArr2[16] = B;
    }

    public static void i(int[] iArr) {
        int i = iArr[16];
        int g = m.g(16, i >>> 9, iArr) + (i & FrameMetricsAggregator.EVERY_DURATION);
        if (g > 511 || (g == 511 && m.n(16, iArr, a))) {
            g = (g + m.r(16, iArr)) & FrameMetricsAggregator.EVERY_DURATION;
        }
        iArr[16] = g;
    }

    public static void j(int[] iArr, int[] iArr2) {
        int[] j = m.j(33);
        e(iArr, j);
        h(j, iArr2);
    }

    public static void k(int[] iArr, int i, int[] iArr2) {
        int[] j = m.j(33);
        e(iArr, j);
        while (true) {
            h(j, iArr2);
            i--;
            if (i > 0) {
                e(iArr2, j);
            } else {
                return;
            }
        }
    }

    public static void l(int[] iArr, int[] iArr2, int[] iArr3) {
        int K = (m.K(16, iArr, iArr2, iArr3) + iArr[16]) - iArr2[16];
        if (K < 0) {
            K = (K + m.l(16, iArr3)) & FrameMetricsAggregator.EVERY_DURATION;
        }
        iArr3[16] = K;
    }

    public static void m(int[] iArr, int[] iArr2) {
        int i = iArr[16];
        iArr2[16] = (m.E(16, iArr, i << 23, iArr2) | (i << 1)) & FrameMetricsAggregator.EVERY_DURATION;
    }
}

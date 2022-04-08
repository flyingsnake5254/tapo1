package e.a.b.a.a0.c;

import e.a.b.c.a;
import e.a.b.c.l;
import e.a.b.c.m;
import java.math.BigInteger;

/* loaded from: classes4.dex */
public class q2 {
    private static final long[] a = {3161836309350906777L, -7642453882179322845L, -3821226941089661423L, 7312758566309945096L, -556661012383879292L, 8945041530681231562L, -4750851271514160027L, 6847946401097695794L, 541669439031730457L};

    private static void a(long[] jArr, int i, long[] jArr2, int i2, long[] jArr3, int i3) {
        for (int i4 = 0; i4 < 9; i4++) {
            jArr3[i3 + i4] = jArr[i + i4] ^ jArr2[i2 + i4];
        }
    }

    public static void b(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 0; i < 9; i++) {
            jArr3[i] = jArr[i] ^ jArr2[i];
        }
    }

    private static void c(long[] jArr, int i, long[] jArr2, int i2, long[] jArr3, int i3) {
        for (int i4 = 0; i4 < 9; i4++) {
            int i5 = i3 + i4;
            jArr3[i5] = jArr3[i5] ^ (jArr[i + i4] ^ jArr2[i2 + i4]);
        }
    }

    public static void d(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 0; i < 9; i++) {
            jArr3[i] = jArr3[i] ^ (jArr[i] ^ jArr2[i]);
        }
    }

    public static void e(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 0; i < 18; i++) {
            jArr3[i] = jArr[i] ^ jArr2[i];
        }
    }

    public static void f(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        for (int i = 1; i < 9; i++) {
            jArr2[i] = jArr[i];
        }
    }

    public static long[] g(BigInteger bigInteger) {
        long[] e2 = l.e(bigInteger);
        r(e2, 0);
        return e2;
    }

    protected static void h(long[] jArr, long[] jArr2, long[] jArr3) {
        i(jArr, p(jArr2), jArr3);
    }

    protected static void i(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 56; i >= 0; i -= 8) {
            for (int i2 = 1; i2 < 9; i2 += 2) {
                int i3 = (int) (jArr[i2] >>> i);
                c(jArr2, (i3 & 15) * 9, jArr2, (((i3 >>> 4) & 15) + 16) * 9, jArr3, i2 - 1);
            }
            m.I(16, jArr3, 0, 8, 0L);
        }
        for (int i4 = 56; i4 >= 0; i4 -= 8) {
            for (int i5 = 0; i5 < 9; i5 += 2) {
                int i6 = (int) (jArr[i5] >>> i4);
                c(jArr2, (i6 & 15) * 9, jArr2, (((i6 >>> 4) & 15) + 16) * 9, jArr3, i5);
            }
            if (i4 > 0) {
                m.I(18, jArr3, 0, 8, 0L);
            }
        }
    }

    protected static void j(long[] jArr, long[] jArr2) {
        for (int i = 0; i < 9; i++) {
            a.c(jArr[i], jArr2, i << 1);
        }
    }

    public static void k(long[] jArr, long[] jArr2) {
        if (!l.g(jArr)) {
            long[] b2 = l.b();
            long[] b3 = l.b();
            long[] b4 = l.b();
            t(jArr, b4);
            t(b4, b2);
            t(b2, b3);
            l(b2, b3, b2);
            v(b2, 2, b3);
            l(b2, b3, b2);
            l(b2, b4, b2);
            v(b2, 5, b3);
            l(b2, b3, b2);
            v(b3, 5, b3);
            l(b2, b3, b2);
            v(b2, 15, b3);
            l(b2, b3, b4);
            v(b4, 30, b2);
            v(b2, 30, b3);
            l(b2, b3, b2);
            v(b2, 60, b3);
            l(b2, b3, b2);
            v(b3, 60, b3);
            l(b2, b3, b2);
            v(b2, 180, b3);
            l(b2, b3, b2);
            v(b3, 180, b3);
            l(b2, b3, b2);
            l(b2, b4, jArr2);
            return;
        }
        throw new IllegalStateException();
    }

    public static void l(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] c2 = l.c();
        h(jArr, jArr2, c2);
        q(c2, jArr3);
    }

    public static void m(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] c2 = l.c();
        h(jArr, jArr2, c2);
        e(jArr3, c2, jArr3);
    }

    public static void n(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] c2 = l.c();
        i(jArr, jArr2, c2);
        q(c2, jArr3);
    }

    public static void o(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] c2 = l.c();
        i(jArr, jArr2, c2);
        e(jArr3, c2, jArr3);
    }

    public static long[] p(long[] jArr) {
        long[] jArr2 = new long[288];
        int i = 0;
        System.arraycopy(jArr, 0, jArr2, 9, 9);
        int i2 = 7;
        while (i2 > 0) {
            int i3 = i + 18;
            m.F(9, jArr2, i3 >>> 1, 0L, jArr2, i3);
            r(jArr2, i3);
            a(jArr2, 9, jArr2, i3, jArr2, i3 + 9);
            i2--;
            i = i3;
        }
        m.J(144, jArr2, 0, 4, 0L, jArr2, 144);
        return jArr2;
    }

    public static void q(long[] jArr, long[] jArr2) {
        long j = jArr[9];
        long j2 = jArr[17];
        long j3 = (((j ^ (j2 >>> 59)) ^ (j2 >>> 57)) ^ (j2 >>> 54)) ^ (j2 >>> 49);
        long j4 = (j2 << 15) ^ (((jArr[8] ^ (j2 << 5)) ^ (j2 << 7)) ^ (j2 << 10));
        for (int i = 16; i >= 10; i--) {
            long j5 = jArr[i];
            jArr2[i - 8] = (((j4 ^ (j5 >>> 59)) ^ (j5 >>> 57)) ^ (j5 >>> 54)) ^ (j5 >>> 49);
            j4 = (((jArr[i - 9] ^ (j5 << 5)) ^ (j5 << 7)) ^ (j5 << 10)) ^ (j5 << 15);
        }
        jArr2[1] = (((j4 ^ (j3 >>> 59)) ^ (j3 >>> 57)) ^ (j3 >>> 54)) ^ (j3 >>> 49);
        long j6 = (j3 << 15) ^ (((jArr[0] ^ (j3 << 5)) ^ (j3 << 7)) ^ (j3 << 10));
        long j7 = jArr2[8];
        long j8 = j7 >>> 59;
        jArr2[0] = (((j6 ^ j8) ^ (j8 << 2)) ^ (j8 << 5)) ^ (j8 << 10);
        jArr2[8] = 576460752303423487L & j7;
    }

    public static void r(long[] jArr, int i) {
        int i2 = i + 8;
        long j = jArr[i2];
        long j2 = j >>> 59;
        jArr[i] = ((j2 << 10) ^ (((j2 << 2) ^ j2) ^ (j2 << 5))) ^ jArr[i];
        jArr[i2] = j & 576460752303423487L;
    }

    public static void s(long[] jArr, long[] jArr2) {
        long[] b2 = l.b();
        long[] b3 = l.b();
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = i + 1;
            long f2 = a.f(jArr[i]);
            i = i3 + 1;
            long f3 = a.f(jArr[i3]);
            b2[i2] = (4294967295L & f2) | (f3 << 32);
            b3[i2] = (f2 >>> 32) | ((-4294967296L) & f3);
        }
        long f4 = a.f(jArr[i]);
        b2[4] = 4294967295L & f4;
        b3[4] = f4 >>> 32;
        l(b3, a, jArr2);
        b(jArr2, b2, jArr2);
    }

    public static void t(long[] jArr, long[] jArr2) {
        long[] c2 = l.c();
        j(jArr, c2);
        q(c2, jArr2);
    }

    public static void u(long[] jArr, long[] jArr2) {
        long[] c2 = l.c();
        j(jArr, c2);
        e(jArr2, c2, jArr2);
    }

    public static void v(long[] jArr, int i, long[] jArr2) {
        long[] c2 = l.c();
        j(jArr, c2);
        while (true) {
            q(c2, jArr2);
            i--;
            if (i > 0) {
                j(jArr2, c2);
            } else {
                return;
            }
        }
    }

    public static int w(long[] jArr) {
        return ((int) ((jArr[0] ^ (jArr[8] >>> 49)) ^ (jArr[8] >>> 57))) & 1;
    }
}

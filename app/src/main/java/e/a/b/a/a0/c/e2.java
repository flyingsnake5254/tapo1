package e.a.b.a.a0.c;

import e.a.b.c.a;
import e.a.b.c.h;
import e.a.b.c.m;
import java.math.BigInteger;

/* loaded from: classes4.dex */
public class e2 {
    private static final long[] a = {878416384462358536L, 3513665537849438403L, -9076969306111048948L, 585610922974906400L, 34087042};

    public static void a(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr2[4] ^ jArr[4];
    }

    public static void b(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr[6] ^ jArr2[6];
        jArr3[7] = jArr[7] ^ jArr2[7];
        jArr3[8] = jArr2[8] ^ jArr[8];
    }

    public static void c(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
        jArr2[4] = jArr[4];
    }

    public static long[] d(BigInteger bigInteger) {
        long[] e2 = h.e(bigInteger);
        n(e2, 0);
        return e2;
    }

    protected static void e(long[] jArr) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        long j9 = jArr[8];
        long j10 = jArr[9];
        jArr[0] = j ^ (j2 << 57);
        jArr[1] = (j2 >>> 7) ^ (j3 << 50);
        jArr[2] = (j3 >>> 14) ^ (j4 << 43);
        jArr[3] = (j4 >>> 21) ^ (j5 << 36);
        jArr[4] = (j5 >>> 28) ^ (j6 << 29);
        jArr[5] = (j6 >>> 35) ^ (j7 << 22);
        jArr[6] = (j7 >>> 42) ^ (j8 << 15);
        jArr[7] = (j8 >>> 49) ^ (j9 << 8);
        jArr[8] = (j9 >>> 56) ^ (j10 << 1);
        jArr[9] = j10 >>> 63;
    }

    protected static void f(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        jArr2[0] = j & 144115188075855871L;
        jArr2[1] = ((j >>> 57) ^ (j2 << 7)) & 144115188075855871L;
        jArr2[2] = ((j2 >>> 50) ^ (j3 << 14)) & 144115188075855871L;
        jArr2[3] = ((j3 >>> 43) ^ (j4 << 21)) & 144115188075855871L;
        jArr2[4] = (j4 >>> 36) ^ (j5 << 28);
    }

    protected static void g(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[5];
        long[] jArr5 = new long[5];
        f(jArr, jArr4);
        f(jArr2, jArr5);
        long[] jArr6 = new long[26];
        h(jArr4[0], jArr5[0], jArr6, 0);
        h(jArr4[1], jArr5[1], jArr6, 2);
        h(jArr4[2], jArr5[2], jArr6, 4);
        h(jArr4[3], jArr5[3], jArr6, 6);
        h(jArr4[4], jArr5[4], jArr6, 8);
        long j = jArr4[0] ^ jArr4[1];
        long j2 = jArr5[0] ^ jArr5[1];
        long j3 = jArr4[0] ^ jArr4[2];
        long j4 = jArr5[0] ^ jArr5[2];
        long j5 = jArr4[2] ^ jArr4[4];
        long j6 = jArr5[2] ^ jArr5[4];
        long j7 = jArr4[3] ^ jArr4[4];
        long j8 = jArr5[3] ^ jArr5[4];
        h(j3 ^ jArr4[3], j4 ^ jArr5[3], jArr6, 18);
        h(j5 ^ jArr4[1], j6 ^ jArr5[1], jArr6, 20);
        long j9 = j ^ j7;
        long j10 = j2 ^ j8;
        h(j9, j10, jArr6, 22);
        h(j9 ^ jArr4[2], jArr5[2] ^ j10, jArr6, 24);
        h(j, j2, jArr6, 10);
        h(j3, j4, jArr6, 12);
        h(j5, j6, jArr6, 14);
        h(j7, j8, jArr6, 16);
        jArr3[0] = jArr6[0];
        jArr3[9] = jArr6[9];
        long j11 = jArr6[0] ^ jArr6[1];
        long j12 = jArr6[2] ^ j11;
        long j13 = jArr6[10] ^ j12;
        jArr3[1] = j13;
        long j14 = jArr6[3] ^ jArr6[4];
        long j15 = j12 ^ (j14 ^ (jArr6[11] ^ jArr6[12]));
        jArr3[2] = j15;
        long j16 = jArr6[5] ^ jArr6[6];
        long j17 = ((j11 ^ j14) ^ j16) ^ jArr6[8];
        long j18 = jArr6[13] ^ jArr6[14];
        jArr3[3] = (j17 ^ j18) ^ ((jArr6[18] ^ jArr6[22]) ^ jArr6[24]);
        long j19 = (jArr6[7] ^ jArr6[8]) ^ jArr6[9];
        long j20 = j19 ^ jArr6[17];
        jArr3[8] = j20;
        long j21 = (j19 ^ j16) ^ (jArr6[15] ^ jArr6[16]);
        jArr3[7] = j21;
        long j22 = j13 ^ j21;
        long j23 = (jArr6[19] ^ jArr6[20]) ^ (jArr6[25] ^ jArr6[24]);
        jArr3[4] = (j23 ^ (jArr6[18] ^ jArr6[23])) ^ j22;
        jArr3[5] = ((j15 ^ j20) ^ j23) ^ (jArr6[21] ^ jArr6[22]);
        jArr3[6] = ((((jArr6[9] ^ (j17 ^ jArr6[0])) ^ j18) ^ jArr6[21]) ^ jArr6[23]) ^ jArr6[25];
        e(jArr3);
    }

    protected static void h(long j, long j2, long[] jArr, int i) {
        long[] jArr2 = new long[8];
        jArr2[1] = j2;
        jArr2[2] = jArr2[1] << 1;
        jArr2[3] = jArr2[2] ^ j2;
        jArr2[4] = jArr2[2] << 1;
        jArr2[5] = jArr2[4] ^ j2;
        jArr2[6] = jArr2[3] << 1;
        jArr2[7] = jArr2[6] ^ j2;
        long j3 = jArr2[((int) j) & 7];
        long j4 = 0;
        int i2 = 48;
        do {
            int i3 = (int) (j >>> i2);
            long j5 = (jArr2[(i3 >>> 6) & 7] << 6) ^ (jArr2[i3 & 7] ^ (jArr2[(i3 >>> 3) & 7] << 3));
            j3 ^= j5 << i2;
            j4 ^= j5 >>> (-i2);
            i2 -= 9;
        } while (i2 > 0);
        jArr[i] = 144115188075855871L & j3;
        jArr[i + 1] = (((((j & 72198606942111744L) & ((j2 << 7) >> 63)) >>> 8) ^ j4) << 7) ^ (j3 >>> 57);
    }

    protected static void i(long[] jArr, long[] jArr2) {
        for (int i = 0; i < 4; i++) {
            a.c(jArr[i], jArr2, i << 1);
        }
        jArr2[8] = a.b((int) jArr[4]);
    }

    public static void j(long[] jArr, long[] jArr2) {
        if (!h.g(jArr)) {
            long[] b2 = h.b();
            long[] b3 = h.b();
            p(jArr, b2);
            k(b2, jArr, b2);
            r(b2, 2, b3);
            k(b3, b2, b3);
            r(b3, 4, b2);
            k(b2, b3, b2);
            r(b2, 8, b3);
            k(b3, b2, b3);
            p(b3, b3);
            k(b3, jArr, b3);
            r(b3, 17, b2);
            k(b2, b3, b2);
            p(b2, b2);
            k(b2, jArr, b2);
            r(b2, 35, b3);
            k(b3, b2, b3);
            r(b3, 70, b2);
            k(b2, b3, b2);
            p(b2, b2);
            k(b2, jArr, b2);
            r(b2, 141, b3);
            k(b3, b2, b3);
            p(b3, jArr2);
            return;
        }
        throw new IllegalStateException();
    }

    public static void k(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] c2 = h.c();
        g(jArr, jArr2, c2);
        m(c2, jArr3);
    }

    public static void l(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] c2 = h.c();
        g(jArr, jArr2, c2);
        b(jArr3, c2, jArr3);
    }

    public static void m(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        long j9 = jArr[8];
        long j10 = j5 ^ ((((j9 >>> 27) ^ (j9 >>> 22)) ^ (j9 >>> 20)) ^ (j9 >>> 15));
        long j11 = j ^ ((((j6 << 37) ^ (j6 << 42)) ^ (j6 << 44)) ^ (j6 << 49));
        long j12 = (j2 ^ ((((j7 << 37) ^ (j7 << 42)) ^ (j7 << 44)) ^ (j7 << 49))) ^ ((((j6 >>> 27) ^ (j6 >>> 22)) ^ (j6 >>> 20)) ^ (j6 >>> 15));
        long j13 = j10 >>> 27;
        jArr2[0] = (((j11 ^ j13) ^ (j13 << 5)) ^ (j13 << 7)) ^ (j13 << 12);
        jArr2[1] = j12;
        jArr2[2] = (j3 ^ ((((j8 << 37) ^ (j8 << 42)) ^ (j8 << 44)) ^ (j8 << 49))) ^ ((((j7 >>> 27) ^ (j7 >>> 22)) ^ (j7 >>> 20)) ^ (j7 >>> 15));
        jArr2[3] = (j4 ^ ((((j9 << 37) ^ (j9 << 42)) ^ (j9 << 44)) ^ (j9 << 49))) ^ ((((j8 >>> 27) ^ (j8 >>> 22)) ^ (j8 >>> 20)) ^ (j8 >>> 15));
        jArr2[4] = 134217727 & j10;
    }

    public static void n(long[] jArr, int i) {
        int i2 = i + 4;
        long j = jArr[i2];
        long j2 = j >>> 27;
        jArr[i] = ((j2 << 12) ^ (((j2 << 5) ^ j2) ^ (j2 << 7))) ^ jArr[i];
        jArr[i2] = j & 134217727;
    }

    public static void o(long[] jArr, long[] jArr2) {
        long[] b2 = h.b();
        long f2 = a.f(jArr[0]);
        long f3 = a.f(jArr[1]);
        long j = (f2 & 4294967295L) | (f3 << 32);
        b2[0] = (f2 >>> 32) | (f3 & (-4294967296L));
        long f4 = a.f(jArr[2]);
        long f5 = a.f(jArr[3]);
        b2[1] = (f4 >>> 32) | ((-4294967296L) & f5);
        long f6 = a.f(jArr[4]);
        b2[2] = f6 >>> 32;
        k(b2, a, jArr2);
        jArr2[0] = jArr2[0] ^ j;
        jArr2[1] = jArr2[1] ^ ((f4 & 4294967295L) | (f5 << 32));
        jArr2[2] = jArr2[2] ^ (4294967295L & f6);
    }

    public static void p(long[] jArr, long[] jArr2) {
        long[] k = m.k(9);
        i(jArr, k);
        m(k, jArr2);
    }

    public static void q(long[] jArr, long[] jArr2) {
        long[] k = m.k(9);
        i(jArr, k);
        b(jArr2, k, jArr2);
    }

    public static void r(long[] jArr, int i, long[] jArr2) {
        long[] k = m.k(9);
        i(jArr, k);
        while (true) {
            m(k, jArr2);
            i--;
            if (i > 0) {
                i(jArr2, k);
            } else {
                return;
            }
        }
    }

    public static int s(long[] jArr) {
        return ((int) (jArr[0] ^ (jArr[4] >>> 15))) & 1;
    }
}

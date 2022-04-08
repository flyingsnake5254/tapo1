package com.google.common.primitives;

import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;

/* compiled from: UnsignedLongs.java */
/* loaded from: classes2.dex */
public final class j {

    /* compiled from: UnsignedLongs.java */
    /* loaded from: classes2.dex */
    private static final class a {
        static final long[] a = new long[37];

        /* renamed from: b  reason: collision with root package name */
        static final int[] f4729b = new int[37];

        /* renamed from: c  reason: collision with root package name */
        static final int[] f4730c = new int[37];

        static {
            BigInteger bigInteger = new BigInteger("10000000000000000", 16);
            for (int i = 2; i <= 36; i++) {
                long j = i;
                a[i] = j.b(-1L, j);
                f4729b[i] = (int) j.e(-1L, j);
                f4730c[i] = bigInteger.toString(i).length() - 1;
            }
        }

        static boolean a(long j, int i, int i2) {
            if (j < 0) {
                return true;
            }
            long[] jArr = a;
            if (j < jArr[i2]) {
                return false;
            }
            return j > jArr[i2] || i > f4729b[i2];
        }
    }

    public static int a(long j, long j2) {
        return e.c(c(j), c(j2));
    }

    public static long b(long j, long j2) {
        if (j2 < 0) {
            return a(j, j2) < 0 ? 0L : 1L;
        }
        if (j >= 0) {
            return j / j2;
        }
        int i = 1;
        long j3 = ((j >>> 1) / j2) << 1;
        if (a(j - (j3 * j2), j2) < 0) {
            i = 0;
        }
        return j3 + i;
    }

    private static long c(long j) {
        return j ^ Long.MIN_VALUE;
    }

    @CanIgnoreReturnValue
    public static long d(String str, int i) {
        n.o(str);
        if (str.length() == 0) {
            throw new NumberFormatException("empty string");
        } else if (i < 2 || i > 36) {
            throw new NumberFormatException("illegal radix: " + i);
        } else {
            int i2 = a.f4730c[i] - 1;
            long j = 0;
            for (int i3 = 0; i3 < str.length(); i3++) {
                int digit = Character.digit(str.charAt(i3), i);
                if (digit == -1) {
                    throw new NumberFormatException(str);
                } else if (i3 <= i2 || !a.a(j, digit, i)) {
                    j = (j * i) + digit;
                } else {
                    throw new NumberFormatException("Too large for unsigned long: " + str);
                }
            }
            return j;
        }
    }

    public static long e(long j, long j2) {
        if (j2 < 0) {
            return a(j, j2) < 0 ? j : j - j2;
        }
        if (j >= 0) {
            return j % j2;
        }
        long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
        if (a(j3, j2) < 0) {
            j2 = 0;
        }
        return j3 - j2;
    }

    public static String f(long j) {
        return g(j, 10);
    }

    public static String g(long j, int i) {
        long j2;
        n.f(i >= 2 && i <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i);
        int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i2 == 0) {
            return "0";
        }
        if (i2 > 0) {
            return Long.toString(j, i);
        }
        int i3 = 64;
        char[] cArr = new char[64];
        int i4 = i - 1;
        if ((i & i4) == 0) {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
            do {
                i3--;
                cArr[i3] = Character.forDigit(((int) j) & i4, i);
                j >>>= numberOfTrailingZeros;
            } while (j != 0);
        } else {
            if ((i & 1) == 0) {
                j2 = (j >>> 1) / (i >>> 1);
            } else {
                j2 = b(j, i);
            }
            long j3 = i;
            cArr[63] = Character.forDigit((int) (j - (j2 * j3)), i);
            i3 = 63;
            while (j2 > 0) {
                i3--;
                cArr[i3] = Character.forDigit((int) (j2 % j3), i);
                j2 /= j3;
            }
        }
        return new String(cArr, i3, 64 - i3);
    }
}

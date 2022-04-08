package com.google.common.math;

import com.github.mikephil.charting.utils.Utils;
import java.math.RoundingMode;

/* compiled from: DoubleMath.java */
/* loaded from: classes2.dex */
public final class a {
    private static final double a = Math.log(2.0d);

    /* renamed from: b  reason: collision with root package name */
    static final double[] f4695b = {1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DoubleMath.java */
    /* renamed from: com.google.common.math.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C0168a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RoundingMode.FLOOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RoundingMode.CEILING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[RoundingMode.DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[RoundingMode.UP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[RoundingMode.HALF_EVEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[RoundingMode.HALF_DOWN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static boolean a(double d2) {
        return b.c(d2) && (d2 == Utils.DOUBLE_EPSILON || 52 - Long.numberOfTrailingZeros(b.b(d2)) <= Math.getExponent(d2));
    }

    static double b(double d2, RoundingMode roundingMode) {
        if (b.c(d2)) {
            switch (C0168a.a[roundingMode.ordinal()]) {
                case 1:
                    f.c(a(d2));
                    return d2;
                case 2:
                    return (d2 >= Utils.DOUBLE_EPSILON || a(d2)) ? d2 : ((long) d2) - 1;
                case 3:
                    return (d2 <= Utils.DOUBLE_EPSILON || a(d2)) ? d2 : ((long) d2) + 1;
                case 4:
                    return d2;
                case 5:
                    if (a(d2)) {
                        return d2;
                    }
                    return ((long) d2) + (d2 > Utils.DOUBLE_EPSILON ? 1 : -1);
                case 6:
                    return Math.rint(d2);
                case 7:
                    double rint = Math.rint(d2);
                    return Math.abs(d2 - rint) == 0.5d ? d2 + Math.copySign(0.5d, d2) : rint;
                case 8:
                    double rint2 = Math.rint(d2);
                    return Math.abs(d2 - rint2) == 0.5d ? d2 : rint2;
                default:
                    throw new AssertionError();
            }
        } else {
            throw new ArithmeticException("input is infinite or NaN");
        }
    }

    public static long c(double d2, RoundingMode roundingMode) {
        double b2 = b(d2, roundingMode);
        boolean z = true;
        boolean z2 = (-9.223372036854776E18d) - b2 < 1.0d;
        if (b2 >= 9.223372036854776E18d) {
            z = false;
        }
        f.a(z2 & z, d2, roundingMode);
        return (long) b2;
    }
}

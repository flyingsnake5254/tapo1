package com.google.common.math;

import com.github.mikephil.charting.utils.Utils;
import com.google.common.base.n;

/* compiled from: DoubleUtils.java */
/* loaded from: classes2.dex */
final class b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static double a(double d2) {
        n.d(!Double.isNaN(d2));
        return d2 > Utils.DOUBLE_EPSILON ? d2 : Utils.DOUBLE_EPSILON;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long b(double d2) {
        n.e(c(d2), "not a normal value");
        int exponent = Math.getExponent(d2);
        long doubleToRawLongBits = Double.doubleToRawLongBits(d2) & 4503599627370495L;
        return exponent == -1023 ? doubleToRawLongBits << 1 : doubleToRawLongBits | 4503599627370496L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(double d2) {
        return Math.getExponent(d2) <= 1023;
    }
}

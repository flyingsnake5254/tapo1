package com.google.common.math;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.RoundingMode;

/* compiled from: MathPreconditions.java */
@CanIgnoreReturnValue
/* loaded from: classes2.dex */
final class f {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z, double d2, RoundingMode roundingMode) {
        if (!z) {
            throw new ArithmeticException("rounded value is out of range for input " + d2 + " and rounding mode " + roundingMode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(boolean z, String str, int i, int i2) {
        if (!z) {
            throw new ArithmeticException("overflow: " + str + "(" + i + ", " + i2 + ")");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(boolean z) {
        if (!z) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}

package com.google.common.collect;

import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Hashing.java */
/* loaded from: classes2.dex */
final class y0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, double d2) {
        int max = Math.max(i, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max <= ((int) (d2 * highestOneBit))) {
            return highestOneBit;
        }
        int i2 = highestOneBit << 1;
        return i2 > 0 ? i2 : Pow2.MAX_POW2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(int i, int i2, double d2) {
        return ((double) i) > d2 * ((double) i2) && i2 < 1073741824;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i) {
        return (int) (Integer.rotateLeft((int) (i * (-862048943)), 15) * 461845907);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(@NullableDecl Object obj) {
        return c(obj == null ? 0 : obj.hashCode());
    }
}

package com.google.common.primitives;

import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* compiled from: UnsignedBytes.java */
/* loaded from: classes2.dex */
public final class h {
    @CanIgnoreReturnValue
    public static byte a(long j) {
        n.h((j >> 8) == 0, "out of range: %s", j);
        return (byte) j;
    }

    public static int b(byte b2) {
        return b2 & 255;
    }
}

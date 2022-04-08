package com.google.common.math;

import com.google.android.exoplayer2.PlaybackException;
import com.google.common.primitives.d;

/* compiled from: IntMath.java */
/* loaded from: classes2.dex */
public final class c {
    static final byte[] a = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};

    /* renamed from: b  reason: collision with root package name */
    static final int[] f4696b = {1, 10, 100, 1000, 10000, 100000, PlaybackException.CUSTOM_ERROR_CODE_BASE, 10000000, 100000000, 1000000000};

    /* renamed from: c  reason: collision with root package name */
    static final int[] f4697c = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f4698d = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};

    /* renamed from: e  reason: collision with root package name */
    static int[] f4699e = {Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

    public static int a(int i, int i2) {
        long j = i + i2;
        int i3 = (int) j;
        f.b(j == ((long) i3), "checkedAdd", i, i2);
        return i3;
    }

    public static int b(int i, int i2) {
        return d.i(i + i2);
    }
}

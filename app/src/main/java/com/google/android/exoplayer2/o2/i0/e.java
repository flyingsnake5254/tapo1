package com.google.android.exoplayer2.o2.i0;

import android.util.Pair;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.o2.y;
import com.google.android.exoplayer2.o2.z;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.w0;

/* compiled from: MlltSeeker.java */
/* loaded from: classes.dex */
final class e implements g {
    private final long[] a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f2746b;

    /* renamed from: c  reason: collision with root package name */
    private final long f2747c;

    private e(long[] jArr, long[] jArr2, long j) {
        this.a = jArr;
        this.f2746b = jArr2;
        this.f2747c = j == -9223372036854775807L ? w0.d(jArr2[jArr2.length - 1]) : j;
    }

    public static e b(long j, MlltFrame mlltFrame, long j2) {
        int length = mlltFrame.x.length;
        int i = length + 1;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        jArr[0] = j;
        long j3 = 0;
        jArr2[0] = 0;
        for (int i2 = 1; i2 <= length; i2++) {
            int i3 = i2 - 1;
            j += mlltFrame.f2572f + mlltFrame.x[i3];
            j3 += mlltFrame.q + mlltFrame.y[i3];
            jArr[i2] = j;
            jArr2[i2] = j3;
        }
        return new e(jArr, jArr2, j2);
    }

    private static Pair<Long, Long> c(long j, long[] jArr, long[] jArr2) {
        int h = o0.h(jArr, j, true, true);
        long j2 = jArr[h];
        long j3 = jArr2[h];
        int i = h + 1;
        if (i == jArr.length) {
            return Pair.create(Long.valueOf(j2), Long.valueOf(j3));
        }
        long j4 = jArr[i];
        return Pair.create(Long.valueOf(j), Long.valueOf(((long) ((j4 == j2 ? Utils.DOUBLE_EPSILON : (j - j2) / (j4 - j2)) * (jArr2[i] - j3))) + j3));
    }

    @Override // com.google.android.exoplayer2.o2.y
    public y.a a(long j) {
        Pair<Long, Long> c2 = c(w0.e(o0.q(j, 0L, this.f2747c)), this.f2746b, this.a);
        return new y.a(new z(w0.d(((Long) c2.first).longValue()), ((Long) c2.second).longValue()));
    }

    @Override // com.google.android.exoplayer2.o2.i0.g
    public long f() {
        return -1L;
    }

    @Override // com.google.android.exoplayer2.o2.y
    public boolean g() {
        return true;
    }

    @Override // com.google.android.exoplayer2.o2.i0.g
    public long h(long j) {
        return w0.d(((Long) c(j, this.a, this.f2746b).second).longValue());
    }

    @Override // com.google.android.exoplayer2.o2.y
    public long i() {
        return this.f2747c;
    }
}

package com.google.android.exoplayer2.o2.j0;

import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;

/* compiled from: TrackSampleTable.java */
/* loaded from: classes.dex */
final class r {
    public final o a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2834b;

    /* renamed from: c  reason: collision with root package name */
    public final long[] f2835c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f2836d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2837e;

    /* renamed from: f  reason: collision with root package name */
    public final long[] f2838f;
    public final int[] g;
    public final long h;

    public r(o oVar, long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j) {
        boolean z = false;
        g.a(iArr.length == jArr2.length);
        g.a(jArr.length == jArr2.length);
        g.a(iArr2.length == jArr2.length ? true : z);
        this.a = oVar;
        this.f2835c = jArr;
        this.f2836d = iArr;
        this.f2837e = i;
        this.f2838f = jArr2;
        this.g = iArr2;
        this.h = j;
        this.f2834b = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public int a(long j) {
        for (int h = o0.h(this.f2838f, j, true, false); h >= 0; h--) {
            if ((this.g[h] & 1) != 0) {
                return h;
            }
        }
        return -1;
    }

    public int b(long j) {
        for (int d2 = o0.d(this.f2838f, j, true, false); d2 < this.f2838f.length; d2++) {
            if ((this.g[d2] & 1) != 0) {
                return d2;
            }
        }
        return -1;
    }
}

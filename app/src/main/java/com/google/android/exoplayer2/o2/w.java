package com.google.android.exoplayer2.o2;

import com.google.android.exoplayer2.o2.y;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;

/* compiled from: IndexSeekMap.java */
/* loaded from: classes.dex */
public final class w implements y {
    private final long[] a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f3073b;

    /* renamed from: c  reason: collision with root package name */
    private final long f3074c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f3075d;

    public w(long[] jArr, long[] jArr2, long j) {
        g.a(jArr.length == jArr2.length);
        int length = jArr2.length;
        boolean z = length > 0;
        this.f3075d = z;
        if (!z || jArr2[0] <= 0) {
            this.a = jArr;
            this.f3073b = jArr2;
        } else {
            int i = length + 1;
            long[] jArr3 = new long[i];
            this.a = jArr3;
            long[] jArr4 = new long[i];
            this.f3073b = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length);
            System.arraycopy(jArr2, 0, jArr4, 1, length);
        }
        this.f3074c = j;
    }

    @Override // com.google.android.exoplayer2.o2.y
    public y.a a(long j) {
        if (!this.f3075d) {
            return new y.a(z.a);
        }
        int h = o0.h(this.f3073b, j, true, true);
        z zVar = new z(this.f3073b[h], this.a[h]);
        if (zVar.f3078b == j || h == this.f3073b.length - 1) {
            return new y.a(zVar);
        }
        int i = h + 1;
        return new y.a(zVar, new z(this.f3073b[i], this.a[i]));
    }

    @Override // com.google.android.exoplayer2.o2.y
    public boolean g() {
        return this.f3075d;
    }

    @Override // com.google.android.exoplayer2.o2.y
    public long i() {
        return this.f3074c;
    }
}

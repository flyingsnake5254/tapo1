package com.google.android.exoplayer2.o2;

import com.google.android.exoplayer2.o2.s;
import com.google.android.exoplayer2.o2.y;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;

/* compiled from: FlacSeekTableSeekMap.java */
/* loaded from: classes.dex */
public final class r implements y {
    private final s a;

    /* renamed from: b  reason: collision with root package name */
    private final long f3063b;

    public r(s sVar, long j) {
        this.a = sVar;
        this.f3063b = j;
    }

    private z b(long j, long j2) {
        return new z((j * 1000000) / this.a.f3067e, this.f3063b + j2);
    }

    @Override // com.google.android.exoplayer2.o2.y
    public y.a a(long j) {
        g.i(this.a.k);
        s sVar = this.a;
        s.a aVar = sVar.k;
        long[] jArr = aVar.a;
        long[] jArr2 = aVar.f3069b;
        int h = o0.h(jArr, sVar.j(j), true, false);
        long j2 = 0;
        long j3 = h == -1 ? 0L : jArr[h];
        if (h != -1) {
            j2 = jArr2[h];
        }
        z b2 = b(j3, j2);
        if (b2.f3078b == j || h == jArr.length - 1) {
            return new y.a(b2);
        }
        int i = h + 1;
        return new y.a(b2, b(jArr[i], jArr2[i]));
    }

    @Override // com.google.android.exoplayer2.o2.y
    public boolean g() {
        return true;
    }

    @Override // com.google.android.exoplayer2.o2.y
    public long i() {
        return this.a.g();
    }
}

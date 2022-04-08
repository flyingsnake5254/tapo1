package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.j2;

/* compiled from: ForwardingTimeline.java */
/* loaded from: classes.dex */
public abstract class v extends j2 {

    /* renamed from: c  reason: collision with root package name */
    protected final j2 f3418c;

    public v(j2 j2Var) {
        this.f3418c = j2Var;
    }

    @Override // com.google.android.exoplayer2.j2
    public int a(boolean z) {
        return this.f3418c.a(z);
    }

    @Override // com.google.android.exoplayer2.j2
    public int b(Object obj) {
        return this.f3418c.b(obj);
    }

    @Override // com.google.android.exoplayer2.j2
    public int c(boolean z) {
        return this.f3418c.c(z);
    }

    @Override // com.google.android.exoplayer2.j2
    public int e(int i, int i2, boolean z) {
        return this.f3418c.e(i, i2, z);
    }

    @Override // com.google.android.exoplayer2.j2
    public j2.b g(int i, j2.b bVar, boolean z) {
        return this.f3418c.g(i, bVar, z);
    }

    @Override // com.google.android.exoplayer2.j2
    public int i() {
        return this.f3418c.i();
    }

    @Override // com.google.android.exoplayer2.j2
    public int l(int i, int i2, boolean z) {
        return this.f3418c.l(i, i2, z);
    }

    @Override // com.google.android.exoplayer2.j2
    public Object m(int i) {
        return this.f3418c.m(i);
    }

    @Override // com.google.android.exoplayer2.j2
    public j2.c o(int i, j2.c cVar, long j) {
        return this.f3418c.o(i, cVar, j);
    }

    @Override // com.google.android.exoplayer2.j2
    public int p() {
        return this.f3418c.p();
    }
}

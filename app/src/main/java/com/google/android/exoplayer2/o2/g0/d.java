package com.google.android.exoplayer2.o2.g0;

import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.y;
import com.google.android.exoplayer2.o2.z;

/* compiled from: StartOffsetExtractorOutput.java */
/* loaded from: classes.dex */
public final class d implements l {

    /* renamed from: c  reason: collision with root package name */
    private final long f2706c;

    /* renamed from: d  reason: collision with root package name */
    private final l f2707d;

    /* compiled from: StartOffsetExtractorOutput.java */
    /* loaded from: classes.dex */
    class a implements y {
        final /* synthetic */ y a;

        a(y yVar) {
            this.a = yVar;
        }

        @Override // com.google.android.exoplayer2.o2.y
        public y.a a(long j) {
            y.a a = this.a.a(j);
            z zVar = a.a;
            z zVar2 = new z(zVar.f3078b, zVar.f3079c + d.this.f2706c);
            z zVar3 = a.f3076b;
            return new y.a(zVar2, new z(zVar3.f3078b, zVar3.f3079c + d.this.f2706c));
        }

        @Override // com.google.android.exoplayer2.o2.y
        public boolean g() {
            return this.a.g();
        }

        @Override // com.google.android.exoplayer2.o2.y
        public long i() {
            return this.a.i();
        }
    }

    public d(long j, l lVar) {
        this.f2706c = j;
        this.f2707d = lVar;
    }

    @Override // com.google.android.exoplayer2.o2.l
    public void o(y yVar) {
        this.f2707d.o(new a(yVar));
    }

    @Override // com.google.android.exoplayer2.o2.l
    public void r() {
        this.f2707d.r();
    }

    @Override // com.google.android.exoplayer2.o2.l
    public b0 t(int i, int i2) {
        return this.f2707d.t(i, i2);
    }
}

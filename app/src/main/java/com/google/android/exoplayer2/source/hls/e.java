package com.google.android.exoplayer2.source.hls;

import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.o2.j;
import com.google.android.exoplayer2.o2.j0.i;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.l0.f;
import com.google.android.exoplayer2.o2.l0.h;
import com.google.android.exoplayer2.o2.l0.h0;
import com.google.android.exoplayer2.o2.x;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.l0;
import java.io.IOException;

/* compiled from: BundledHlsMediaChunkExtractor.java */
/* loaded from: classes.dex */
public final class e implements n {
    private static final x a = new x();
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    final j f3249b;

    /* renamed from: c  reason: collision with root package name */
    private final Format f3250c;

    /* renamed from: d  reason: collision with root package name */
    private final l0 f3251d;

    public e(j jVar, Format format, l0 l0Var) {
        this.f3249b = jVar;
        this.f3250c = format;
        this.f3251d = l0Var;
    }

    @Override // com.google.android.exoplayer2.source.hls.n
    public boolean a(k kVar) throws IOException {
        return this.f3249b.e(kVar, a) == 0;
    }

    @Override // com.google.android.exoplayer2.source.hls.n
    public void b(l lVar) {
        this.f3249b.b(lVar);
    }

    @Override // com.google.android.exoplayer2.source.hls.n
    public void c() {
        this.f3249b.c(0L, 0L);
    }

    @Override // com.google.android.exoplayer2.source.hls.n
    public boolean d() {
        j jVar = this.f3249b;
        return (jVar instanceof h0) || (jVar instanceof i);
    }

    @Override // com.google.android.exoplayer2.source.hls.n
    public boolean e() {
        j jVar = this.f3249b;
        return (jVar instanceof com.google.android.exoplayer2.o2.l0.j) || (jVar instanceof f) || (jVar instanceof h) || (jVar instanceof com.google.android.exoplayer2.o2.i0.f);
    }

    @Override // com.google.android.exoplayer2.source.hls.n
    public n f() {
        j jVar;
        g.g(!d());
        j jVar2 = this.f3249b;
        if (jVar2 instanceof s) {
            jVar = new s(this.f3250c.f2006f, this.f3251d);
        } else if (jVar2 instanceof com.google.android.exoplayer2.o2.l0.j) {
            jVar = new com.google.android.exoplayer2.o2.l0.j();
        } else if (jVar2 instanceof f) {
            jVar = new f();
        } else if (jVar2 instanceof h) {
            jVar = new h();
        } else if (jVar2 instanceof com.google.android.exoplayer2.o2.i0.f) {
            jVar = new com.google.android.exoplayer2.o2.i0.f();
        } else {
            String simpleName = this.f3249b.getClass().getSimpleName();
            throw new IllegalStateException(simpleName.length() != 0 ? "Unexpected extractor type for recreation: ".concat(simpleName) : new String("Unexpected extractor type for recreation: "));
        }
        return new e(jVar, this.f3250c, this.f3251d);
    }
}

package com.google.android.exoplayer2.source;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.l1;
import com.google.android.exoplayer2.source.e0;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.upstream.l;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.upstream.t;
import com.google.android.exoplayer2.upstream.x;
import com.google.android.exoplayer2.util.g;
import java.util.Collections;

/* compiled from: SingleSampleMediaSource.java */
/* loaded from: classes.dex */
public final class s0 extends m {
    private final n g;
    private final l.a h;
    private final Format i;
    private final long j;
    private final x k;
    private final boolean l;
    private final j2 m;
    private final l1 n;
    @Nullable
    private a0 o;

    /* compiled from: SingleSampleMediaSource.java */
    /* loaded from: classes.dex */
    public static final class b {
        private final l.a a;

        /* renamed from: b  reason: collision with root package name */
        private x f3399b = new t();

        /* renamed from: c  reason: collision with root package name */
        private boolean f3400c = true;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private Object f3401d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private String f3402e;

        public b(l.a aVar) {
            this.a = (l.a) g.e(aVar);
        }

        public s0 a(l1.h hVar, long j) {
            return new s0(this.f3402e, hVar, this.a, j, this.f3399b, this.f3400c, this.f3401d);
        }

        public b b(@Nullable x xVar) {
            if (xVar == null) {
                xVar = new t();
            }
            this.f3399b = xVar;
            return this;
        }
    }

    @Override // com.google.android.exoplayer2.source.e0
    public b0 a(e0.a aVar, e eVar, long j) {
        return new r0(this.g, this.h, this.o, this.i, this.j, this.k, t(aVar), this.l);
    }

    @Override // com.google.android.exoplayer2.source.e0
    public l1 f() {
        return this.n;
    }

    @Override // com.google.android.exoplayer2.source.e0
    public void g(b0 b0Var) {
        ((r0) b0Var).t();
    }

    @Override // com.google.android.exoplayer2.source.e0
    public void n() {
    }

    @Override // com.google.android.exoplayer2.source.m
    protected void x(@Nullable a0 a0Var) {
        this.o = a0Var;
        y(this.m);
    }

    @Override // com.google.android.exoplayer2.source.m
    protected void z() {
    }

    private s0(@Nullable String str, l1.h hVar, l.a aVar, long j, x xVar, boolean z, @Nullable Object obj) {
        this.h = aVar;
        this.j = j;
        this.k = xVar;
        this.l = z;
        l1 a2 = new l1.c().u(Uri.EMPTY).p(hVar.a.toString()).s(Collections.singletonList(hVar)).t(obj).a();
        this.n = a2;
        this.i = new Format.b().S(str).e0(hVar.f2375b).V(hVar.f2376c).g0(hVar.f2377d).c0(hVar.f2378e).U(hVar.f2379f).E();
        this.g = new n.b().i(hVar.a).b(1).a();
        this.m = new q0(j, true, false, false, null, a2);
    }
}

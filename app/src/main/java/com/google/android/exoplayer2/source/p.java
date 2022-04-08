package com.google.android.exoplayer2.source;

import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.u;
import com.google.android.exoplayer2.drm.v;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.source.e0;
import com.google.android.exoplayer2.source.f0;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;
import java.util.HashMap;

/* compiled from: CompositeMediaSource.java */
/* loaded from: classes.dex */
public abstract class p<T> extends m {
    private final HashMap<T, b<T>> g = new HashMap<>();
    @Nullable
    private Handler h;
    @Nullable
    private a0 i;

    /* compiled from: CompositeMediaSource.java */
    /* loaded from: classes.dex */
    private final class a implements f0, v {

        /* renamed from: c  reason: collision with root package name */
        private final T f3379c;

        /* renamed from: d  reason: collision with root package name */
        private f0.a f3380d;

        /* renamed from: f  reason: collision with root package name */
        private v.a f3381f;

        public a(T t) {
            this.f3380d = p.this.t(null);
            this.f3381f = p.this.r(null);
            this.f3379c = t;
        }

        private boolean a(int i, @Nullable e0.a aVar) {
            e0.a aVar2;
            if (aVar != null) {
                aVar2 = p.this.A(this.f3379c, aVar);
                if (aVar2 == null) {
                    return false;
                }
            } else {
                aVar2 = null;
            }
            int C = p.this.C(this.f3379c, i);
            f0.a aVar3 = this.f3380d;
            if (aVar3.a != C || !o0.b(aVar3.f3216b, aVar2)) {
                this.f3380d = p.this.s(C, aVar2, 0L);
            }
            v.a aVar4 = this.f3381f;
            if (aVar4.a == C && o0.b(aVar4.f2244b, aVar2)) {
                return true;
            }
            this.f3381f = p.this.q(C, aVar2);
            return true;
        }

        private a0 b(a0 a0Var) {
            long B = p.this.B(this.f3379c, a0Var.f3168f);
            long B2 = p.this.B(this.f3379c, a0Var.g);
            return (B == a0Var.f3168f && B2 == a0Var.g) ? a0Var : new a0(a0Var.a, a0Var.f3164b, a0Var.f3165c, a0Var.f3166d, a0Var.f3167e, B, B2);
        }

        @Override // com.google.android.exoplayer2.drm.v
        public /* synthetic */ void A(int i, e0.a aVar) {
            u.a(this, i, aVar);
        }

        @Override // com.google.android.exoplayer2.source.f0
        public void N(int i, @Nullable e0.a aVar, a0 a0Var) {
            if (a(i, aVar)) {
                this.f3380d.E(b(a0Var));
            }
        }

        @Override // com.google.android.exoplayer2.drm.v
        public void Q(int i, @Nullable e0.a aVar, Exception exc) {
            if (a(i, aVar)) {
                this.f3381f.f(exc);
            }
        }

        @Override // com.google.android.exoplayer2.drm.v
        public void a0(int i, @Nullable e0.a aVar) {
            if (a(i, aVar)) {
                this.f3381f.b();
            }
        }

        @Override // com.google.android.exoplayer2.source.f0
        public void e0(int i, @Nullable e0.a aVar, x xVar, a0 a0Var) {
            if (a(i, aVar)) {
                this.f3380d.v(xVar, b(a0Var));
            }
        }

        @Override // com.google.android.exoplayer2.drm.v
        public void f0(int i, @Nullable e0.a aVar, int i2) {
            if (a(i, aVar)) {
                this.f3381f.e(i2);
            }
        }

        @Override // com.google.android.exoplayer2.drm.v
        public void g0(int i, @Nullable e0.a aVar) {
            if (a(i, aVar)) {
                this.f3381f.g();
            }
        }

        @Override // com.google.android.exoplayer2.source.f0
        public void i0(int i, @Nullable e0.a aVar, x xVar, a0 a0Var, IOException iOException, boolean z) {
            if (a(i, aVar)) {
                this.f3380d.y(xVar, b(a0Var), iOException, z);
            }
        }

        @Override // com.google.android.exoplayer2.source.f0
        public void l(int i, @Nullable e0.a aVar, a0 a0Var) {
            if (a(i, aVar)) {
                this.f3380d.d(b(a0Var));
            }
        }

        @Override // com.google.android.exoplayer2.drm.v
        public void l0(int i, @Nullable e0.a aVar) {
            if (a(i, aVar)) {
                this.f3381f.d();
            }
        }

        @Override // com.google.android.exoplayer2.source.f0
        public void m(int i, @Nullable e0.a aVar, x xVar, a0 a0Var) {
            if (a(i, aVar)) {
                this.f3380d.s(xVar, b(a0Var));
            }
        }

        @Override // com.google.android.exoplayer2.source.f0
        public void p(int i, @Nullable e0.a aVar, x xVar, a0 a0Var) {
            if (a(i, aVar)) {
                this.f3380d.B(xVar, b(a0Var));
            }
        }

        @Override // com.google.android.exoplayer2.drm.v
        public void y(int i, @Nullable e0.a aVar) {
            if (a(i, aVar)) {
                this.f3381f.c();
            }
        }
    }

    /* compiled from: CompositeMediaSource.java */
    /* loaded from: classes.dex */
    private static final class b<T> {
        public final e0 a;

        /* renamed from: b  reason: collision with root package name */
        public final e0.b f3382b;

        /* renamed from: c  reason: collision with root package name */
        public final p<T>.a f3383c;

        public b(e0 e0Var, e0.b bVar, p<T>.a aVar) {
            this.a = e0Var;
            this.f3382b = bVar;
            this.f3383c = aVar;
        }
    }

    @Nullable
    protected e0.a A(T t, e0.a aVar) {
        return aVar;
    }

    protected long B(T t, long j) {
        return j;
    }

    protected int C(T t, int i) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: F */
    public abstract void D(T t, e0 e0Var, j2 j2Var);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void G(final T t, e0 e0Var) {
        g.a(!this.g.containsKey(t));
        e0.b aVar = new e0.b() { // from class: com.google.android.exoplayer2.source.a
            @Override // com.google.android.exoplayer2.source.e0.b
            public final void a(e0 e0Var2, j2 j2Var) {
                p.this.E(t, e0Var2, j2Var);
            }
        };
        a aVar2 = new a(t);
        this.g.put(t, new b<>(e0Var, aVar, aVar2));
        e0Var.d((Handler) g.e(this.h), aVar2);
        e0Var.l((Handler) g.e(this.h), aVar2);
        e0Var.h(aVar, this.i);
        if (!w()) {
            e0Var.j(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void H(T t) {
        b bVar = (b) g.e(this.g.remove(t));
        bVar.a.b(bVar.f3382b);
        bVar.a.e(bVar.f3383c);
        bVar.a.m(bVar.f3383c);
    }

    @Override // com.google.android.exoplayer2.source.e0
    @CallSuper
    public void n() throws IOException {
        for (b<T> bVar : this.g.values()) {
            bVar.a.n();
        }
    }

    @Override // com.google.android.exoplayer2.source.m
    @CallSuper
    protected void u() {
        for (b<T> bVar : this.g.values()) {
            bVar.a.j(bVar.f3382b);
        }
    }

    @Override // com.google.android.exoplayer2.source.m
    @CallSuper
    protected void v() {
        for (b<T> bVar : this.g.values()) {
            bVar.a.i(bVar.f3382b);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.m
    @CallSuper
    public void x(@Nullable a0 a0Var) {
        this.i = a0Var;
        this.h = o0.v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.m
    @CallSuper
    public void z() {
        for (b<T> bVar : this.g.values()) {
            bVar.a.b(bVar.f3382b);
            bVar.a.e(bVar.f3383c);
            bVar.a.m(bVar.f3383c);
        }
        this.g.clear();
    }
}

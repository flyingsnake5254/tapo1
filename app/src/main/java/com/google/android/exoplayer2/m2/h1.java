package com.google.android.exoplayer2.m2;

import android.os.Looper;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.audio.s;
import com.google.android.exoplayer2.audio.t;
import com.google.android.exoplayer2.decoder.d;
import com.google.android.exoplayer2.decoder.e;
import com.google.android.exoplayer2.drm.u;
import com.google.android.exoplayer2.drm.v;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.l1;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.m2.i1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.n2.b;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.a0;
import com.google.android.exoplayer2.source.c0;
import com.google.android.exoplayer2.source.e0;
import com.google.android.exoplayer2.source.f0;
import com.google.android.exoplayer2.t1;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.upstream.g;
import com.google.android.exoplayer2.util.h;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.p;
import com.google.android.exoplayer2.util.r;
import com.google.android.exoplayer2.util.t;
import com.google.android.exoplayer2.v1;
import com.google.android.exoplayer2.video.x;
import com.google.android.exoplayer2.video.y;
import com.google.android.exoplayer2.video.z;
import com.google.android.exoplayer2.w0;
import com.google.android.exoplayer2.w1;
import com.google.common.base.k;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.j1;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: AnalyticsCollector.java */
/* loaded from: classes.dex */
public class h1 implements u1.e, t, y, f0, g.a, v {

    /* renamed from: c  reason: collision with root package name */
    private final h f2431c;

    /* renamed from: d  reason: collision with root package name */
    private final j2.b f2432d;
    private r p0;
    private boolean p1;
    private final a q;
    private com.google.android.exoplayer2.util.t<i1> y;
    private u1 z;

    /* renamed from: f  reason: collision with root package name */
    private final j2.c f2433f = new j2.c();
    private final SparseArray<i1.a> x = new SparseArray<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnalyticsCollector.java */
    /* loaded from: classes.dex */
    public static final class a {
        private final j2.b a;

        /* renamed from: b  reason: collision with root package name */
        private ImmutableList<e0.a> f2434b = ImmutableList.of();

        /* renamed from: c  reason: collision with root package name */
        private ImmutableMap<e0.a, j2> f2435c = ImmutableMap.of();
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private e0.a f2436d;

        /* renamed from: e  reason: collision with root package name */
        private e0.a f2437e;

        /* renamed from: f  reason: collision with root package name */
        private e0.a f2438f;

        public a(j2.b bVar) {
            this.a = bVar;
        }

        private void b(ImmutableMap.b<e0.a, j2> bVar, @Nullable e0.a aVar, j2 j2Var) {
            if (aVar != null) {
                if (j2Var.b(aVar.a) != -1) {
                    bVar.c(aVar, j2Var);
                    return;
                }
                j2 j2Var2 = this.f2435c.get(aVar);
                if (j2Var2 != null) {
                    bVar.c(aVar, j2Var2);
                }
            }
        }

        @Nullable
        private static e0.a c(u1 u1Var, ImmutableList<e0.a> immutableList, @Nullable e0.a aVar, j2.b bVar) {
            j2 w = u1Var.w();
            int H = u1Var.H();
            Object m = w.q() ? null : w.m(H);
            int d2 = (u1Var.f() || w.q()) ? -1 : w.f(H, bVar).d(w0.d(u1Var.V()) - bVar.m());
            for (int i = 0; i < immutableList.size(); i++) {
                e0.a aVar2 = immutableList.get(i);
                if (i(aVar2, m, u1Var.f(), u1Var.r(), u1Var.K(), d2)) {
                    return aVar2;
                }
            }
            if (!immutableList.isEmpty() || aVar == null || !i(aVar, m, u1Var.f(), u1Var.r(), u1Var.K(), d2)) {
                return null;
            }
            return aVar;
        }

        private static boolean i(e0.a aVar, @Nullable Object obj, boolean z, int i, int i2, int i3) {
            if (!aVar.a.equals(obj)) {
                return false;
            }
            return (z && aVar.f3203b == i && aVar.f3204c == i2) || (!z && aVar.f3203b == -1 && aVar.f3206e == i3);
        }

        private void m(j2 j2Var) {
            ImmutableMap.b<e0.a, j2> builder = ImmutableMap.builder();
            if (this.f2434b.isEmpty()) {
                b(builder, this.f2437e, j2Var);
                if (!k.a(this.f2438f, this.f2437e)) {
                    b(builder, this.f2438f, j2Var);
                }
                if (!k.a(this.f2436d, this.f2437e) && !k.a(this.f2436d, this.f2438f)) {
                    b(builder, this.f2436d, j2Var);
                }
            } else {
                for (int i = 0; i < this.f2434b.size(); i++) {
                    b(builder, this.f2434b.get(i), j2Var);
                }
                if (!this.f2434b.contains(this.f2436d)) {
                    b(builder, this.f2436d, j2Var);
                }
            }
            this.f2435c = builder.a();
        }

        @Nullable
        public e0.a d() {
            return this.f2436d;
        }

        @Nullable
        public e0.a e() {
            if (this.f2434b.isEmpty()) {
                return null;
            }
            return (e0.a) j1.f(this.f2434b);
        }

        @Nullable
        public j2 f(e0.a aVar) {
            return this.f2435c.get(aVar);
        }

        @Nullable
        public e0.a g() {
            return this.f2437e;
        }

        @Nullable
        public e0.a h() {
            return this.f2438f;
        }

        public void j(u1 u1Var) {
            this.f2436d = c(u1Var, this.f2434b, this.f2437e, this.a);
        }

        public void k(List<e0.a> list, @Nullable e0.a aVar, u1 u1Var) {
            this.f2434b = ImmutableList.copyOf((Collection) list);
            if (!list.isEmpty()) {
                this.f2437e = list.get(0);
                this.f2438f = (e0.a) com.google.android.exoplayer2.util.g.e(aVar);
            }
            if (this.f2436d == null) {
                this.f2436d = c(u1Var, this.f2434b, this.f2437e, this.a);
            }
            m(u1Var.w());
        }

        public void l(u1 u1Var) {
            this.f2436d = c(u1Var, this.f2434b, this.f2437e, this.a);
            m(u1Var.w());
        }
    }

    public h1(h hVar) {
        this.f2431c = (h) com.google.android.exoplayer2.util.g.e(hVar);
        this.y = new com.google.android.exoplayer2.util.t<>(o0.L(), hVar, m0.a);
        j2.b bVar = new j2.b();
        this.f2432d = bVar;
        this.q = new a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void A0(i1.a aVar, d dVar, i1 i1Var) {
        i1Var.i(aVar, dVar);
        i1Var.k(aVar, 1, dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void B0(i1.a aVar, Format format, e eVar, i1 i1Var) {
        i1Var.Y(aVar, format);
        i1Var.l0(aVar, format, eVar);
        i1Var.J(aVar, 1, format);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B1 */
    public /* synthetic */ void C1(u1 u1Var, i1 i1Var, p pVar) {
        i1Var.n(u1Var, new i1.b(pVar, this.x));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void L0(i1.a aVar, int i, i1 i1Var) {
        i1Var.E(aVar);
        i1Var.c(aVar, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void P0(i1.a aVar, boolean z, i1 i1Var) {
        i1Var.g(aVar, z);
        i1Var.q0(aVar, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e1(i1.a aVar, int i, u1.f fVar, u1.f fVar2, i1 i1Var) {
        i1Var.O(aVar, i);
        i1Var.i0(aVar, fVar, fVar2, i);
    }

    private i1.a p0(@Nullable e0.a aVar) {
        com.google.android.exoplayer2.util.g.e(this.z);
        j2 f2 = aVar == null ? null : this.q.f(aVar);
        if (aVar != null && f2 != null) {
            return o0(f2, f2.h(aVar.a, this.f2432d).f2330d, aVar);
        }
        int m = this.z.m();
        j2 w = this.z.w();
        if (!(m < w.p())) {
            w = j2.a;
        }
        return o0(w, m, null);
    }

    private i1.a q0() {
        return p0(this.q.e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void q1(i1.a aVar, String str, long j, long j2, i1 i1Var) {
        i1Var.k0(aVar, str, j);
        i1Var.y(aVar, str, j2, j);
        i1Var.M(aVar, 2, str, j);
    }

    private i1.a r0(int i, @Nullable e0.a aVar) {
        com.google.android.exoplayer2.util.g.e(this.z);
        boolean z = true;
        if (aVar != null) {
            if (this.q.f(aVar) == null) {
                z = false;
            }
            if (z) {
                return p0(aVar);
            }
            return o0(j2.a, i, aVar);
        }
        j2 w = this.z.w();
        if (i >= w.p()) {
            z = false;
        }
        if (!z) {
            w = j2.a;
        }
        return o0(w, i, null);
    }

    private i1.a s0() {
        return p0(this.q.g());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void s1(i1.a aVar, d dVar, i1 i1Var) {
        i1Var.F(aVar, dVar);
        i1Var.o0(aVar, 2, dVar);
    }

    private i1.a t0() {
        return p0(this.q.h());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void t1(i1.a aVar, d dVar, i1 i1Var) {
        i1Var.T(aVar, dVar);
        i1Var.k(aVar, 2, dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void u0(i1 i1Var, p pVar) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void v1(i1.a aVar, Format format, e eVar, i1 i1Var) {
        i1Var.q(aVar, format);
        i1Var.z(aVar, format, eVar);
        i1Var.J(aVar, 2, format);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void w1(i1.a aVar, z zVar, i1 i1Var) {
        i1Var.X(aVar, zVar);
        i1Var.I(aVar, zVar.f4077c, zVar.f4078d, zVar.f4079e, zVar.f4080f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void x0(i1.a aVar, String str, long j, long j2, i1 i1Var) {
        i1Var.l(aVar, str, j);
        i1Var.U(aVar, str, j2, j);
        i1Var.M(aVar, 1, str, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void z0(i1.a aVar, d dVar, i1 i1Var) {
        i1Var.S(aVar, dVar);
        i1Var.o0(aVar, 1, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z1 */
    public /* synthetic */ void A1() {
        this.y.h();
    }

    @Override // com.google.android.exoplayer2.drm.v
    public /* synthetic */ void A(int i, e0.a aVar) {
        u.a(this, i, aVar);
    }

    @Override // com.google.android.exoplayer2.text.k
    public /* synthetic */ void B(List list) {
        w1.b(this, list);
    }

    @Override // com.google.android.exoplayer2.video.y
    public /* synthetic */ void C(Format format) {
        x.a(this, format);
    }

    @Override // com.google.android.exoplayer2.video.y
    public final void D(final Format format, @Nullable final e eVar) {
        final i1.a t0 = t0();
        F1(t0, 1022, new t.a() { // from class: com.google.android.exoplayer2.m2.t0
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                h1.v1(i1.a.this, format, eVar, (i1) obj);
            }
        });
    }

    public final void D1() {
        if (!this.p1) {
            final i1.a n0 = n0();
            this.p1 = true;
            F1(n0, -1, new t.a() { // from class: com.google.android.exoplayer2.m2.o
                @Override // com.google.android.exoplayer2.util.t.a
                public final void invoke(Object obj) {
                    ((i1) obj).C(i1.a.this);
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.audio.t
    public final void E(final long j) {
        final i1.a t0 = t0();
        F1(t0, PointerIconCompat.TYPE_COPY, new t.a() { // from class: com.google.android.exoplayer2.m2.x0
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).r(i1.a.this, j);
            }
        });
    }

    @CallSuper
    public void E1() {
        final i1.a n0 = n0();
        this.x.put(1036, n0);
        F1(n0, 1036, new t.a() { // from class: com.google.android.exoplayer2.m2.y
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).W(i1.a.this);
            }
        });
        ((r) com.google.android.exoplayer2.util.g.i(this.p0)).h(new Runnable() { // from class: com.google.android.exoplayer2.m2.v
            @Override // java.lang.Runnable
            public final void run() {
                h1.this.A1();
            }
        });
    }

    @Override // com.google.android.exoplayer2.video.y
    public final void F(final Exception exc) {
        final i1.a t0 = t0();
        F1(t0, 1038, new t.a() { // from class: com.google.android.exoplayer2.m2.d
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).A(i1.a.this, exc);
            }
        });
    }

    protected final void F1(i1.a aVar, int i, t.a<i1> aVar2) {
        this.x.put(i, aVar);
        this.y.j(i, aVar2);
    }

    @Override // com.google.android.exoplayer2.u1.c
    public final void G(final TrackGroupArray trackGroupArray, final com.google.android.exoplayer2.trackselection.k kVar) {
        final i1.a n0 = n0();
        F1(n0, 2, new t.a() { // from class: com.google.android.exoplayer2.m2.f0
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).c0(i1.a.this, trackGroupArray, kVar);
            }
        });
    }

    @CallSuper
    public void G1(final u1 u1Var, Looper looper) {
        com.google.android.exoplayer2.util.g.g(this.z == null || this.q.f2434b.isEmpty());
        this.z = (u1) com.google.android.exoplayer2.util.g.e(u1Var);
        this.p0 = this.f2431c.b(looper, null);
        this.y = this.y.b(looper, new t.b() { // from class: com.google.android.exoplayer2.m2.f
            @Override // com.google.android.exoplayer2.util.t.b
            public final void a(Object obj, p pVar) {
                h1.this.C1(u1Var, (i1) obj, pVar);
            }
        });
    }

    @Override // com.google.android.exoplayer2.video.y
    public final void H(final d dVar) {
        final i1.a s0 = s0();
        F1(s0, InputDeviceCompat.SOURCE_GAMEPAD, new t.a() { // from class: com.google.android.exoplayer2.m2.o0
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                h1.s1(i1.a.this, dVar, (i1) obj);
            }
        });
    }

    public final void H1(List<e0.a> list, @Nullable e0.a aVar) {
        this.q.k(list, aVar, (u1) com.google.android.exoplayer2.util.g.e(this.z));
    }

    @Override // com.google.android.exoplayer2.video.w
    public void I(final int i, final int i2) {
        final i1.a t0 = t0();
        F1(t0, 1029, new t.a() { // from class: com.google.android.exoplayer2.m2.h
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).s(i1.a.this, i, i2);
            }
        });
    }

    @Override // com.google.android.exoplayer2.u1.c
    public /* synthetic */ void J(PlaybackException playbackException) {
        w1.p(this, playbackException);
    }

    @Override // com.google.android.exoplayer2.u1.c
    public /* synthetic */ void K(int i) {
        v1.l(this, i);
    }

    @Override // com.google.android.exoplayer2.audio.t
    public final void L(final d dVar) {
        final i1.a s0 = s0();
        F1(s0, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, new t.a() { // from class: com.google.android.exoplayer2.m2.q
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                h1.z0(i1.a.this, dVar, (i1) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.u1.c
    public final void M(final boolean z) {
        final i1.a n0 = n0();
        F1(n0, 4, new t.a() { // from class: com.google.android.exoplayer2.m2.k
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                h1.P0(i1.a.this, z, (i1) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.f0
    public final void N(int i, @Nullable e0.a aVar, final a0 a0Var) {
        final i1.a r0 = r0(i, aVar);
        F1(r0, 1005, new t.a() { // from class: com.google.android.exoplayer2.m2.w0
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).h0(i1.a.this, a0Var);
            }
        });
    }

    @Override // com.google.android.exoplayer2.u1.c
    public final void O() {
        final i1.a n0 = n0();
        F1(n0, -1, new t.a() { // from class: com.google.android.exoplayer2.m2.r0
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).K(i1.a.this);
            }
        });
    }

    @Override // com.google.android.exoplayer2.u1.c
    public final void P(final PlaybackException playbackException) {
        c0 c0Var;
        final i1.a p0 = (!(playbackException instanceof ExoPlaybackException) || (c0Var = ((ExoPlaybackException) playbackException).mediaPeriodId) == null) ? null : p0(new e0.a(c0Var));
        if (p0 == null) {
            p0 = n0();
        }
        F1(p0, 11, new t.a() { // from class: com.google.android.exoplayer2.m2.p0
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).N(i1.a.this, playbackException);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.v
    public final void Q(int i, @Nullable e0.a aVar, final Exception exc) {
        final i1.a r0 = r0(i, aVar);
        F1(r0, 1032, new t.a() { // from class: com.google.android.exoplayer2.m2.w
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).d(i1.a.this, exc);
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.r
    public final void R(final float f2) {
        final i1.a t0 = t0();
        F1(t0, PointerIconCompat.TYPE_ZOOM_OUT, new t.a() { // from class: com.google.android.exoplayer2.m2.e1
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).a0(i1.a.this, f2);
            }
        });
    }

    @Override // com.google.android.exoplayer2.u1.c
    public /* synthetic */ void S(u1 u1Var, u1.d dVar) {
        w1.e(this, u1Var, dVar);
    }

    @Override // com.google.android.exoplayer2.video.y
    public final void T(final int i, final long j) {
        final i1.a s0 = s0();
        F1(s0, 1023, new t.a() { // from class: com.google.android.exoplayer2.m2.z
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).u(i1.a.this, i, j);
            }
        });
    }

    @Override // com.google.android.exoplayer2.u1.c
    public final void U(final boolean z, final int i) {
        final i1.a n0 = n0();
        F1(n0, -1, new t.a() { // from class: com.google.android.exoplayer2.m2.a0
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).o(i1.a.this, z, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.t
    public final void V(final Format format, @Nullable final e eVar) {
        final i1.a t0 = t0();
        F1(t0, PointerIconCompat.TYPE_ALIAS, new t.a() { // from class: com.google.android.exoplayer2.m2.e0
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                h1.B0(i1.a.this, format, eVar, (i1) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.video.w
    public /* synthetic */ void W(int i, int i2, int i3, float f2) {
        com.google.android.exoplayer2.video.v.a(this, i, i2, i3, f2);
    }

    @Override // com.google.android.exoplayer2.video.y
    public final void X(final Object obj, final long j) {
        final i1.a t0 = t0();
        F1(t0, 1027, new t.a() { // from class: com.google.android.exoplayer2.m2.j0
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj2) {
                ((i1) obj2).n0(i1.a.this, obj, j);
            }
        });
    }

    @Override // com.google.android.exoplayer2.u1.c
    public final void Y(@Nullable final l1 l1Var, final int i) {
        final i1.a n0 = n0();
        F1(n0, 1, new t.a() { // from class: com.google.android.exoplayer2.m2.v0
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).D(i1.a.this, l1Var, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.video.y
    public final void Z(final d dVar) {
        final i1.a t0 = t0();
        F1(t0, PointerIconCompat.TYPE_GRAB, new t.a() { // from class: com.google.android.exoplayer2.m2.j
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                h1.t1(i1.a.this, dVar, (i1) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.r, com.google.android.exoplayer2.audio.t
    public final void a(final boolean z) {
        final i1.a t0 = t0();
        F1(t0, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, new t.a() { // from class: com.google.android.exoplayer2.m2.d0
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).w(i1.a.this, z);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.v
    public final void a0(int i, @Nullable e0.a aVar) {
        final i1.a r0 = r0(i, aVar);
        F1(r0, 1031, new t.a() { // from class: com.google.android.exoplayer2.m2.p
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).Z(i1.a.this);
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.t
    public final void b(final Exception exc) {
        final i1.a t0 = t0();
        F1(t0, PointerIconCompat.TYPE_ZOOM_IN, new t.a() { // from class: com.google.android.exoplayer2.m2.g
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).v(i1.a.this, exc);
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.t
    public final void b0(final Exception exc) {
        final i1.a t0 = t0();
        F1(t0, 1037, new t.a() { // from class: com.google.android.exoplayer2.m2.a1
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).e0(i1.a.this, exc);
            }
        });
    }

    @Override // com.google.android.exoplayer2.video.w, com.google.android.exoplayer2.video.y
    public final void c(final z zVar) {
        final i1.a t0 = t0();
        F1(t0, 1028, new t.a() { // from class: com.google.android.exoplayer2.m2.g1
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                h1.w1(i1.a.this, zVar, (i1) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.t
    public /* synthetic */ void c0(Format format) {
        s.a(this, format);
    }

    @Override // com.google.android.exoplayer2.u1.c
    public final void d(final t1 t1Var) {
        final i1.a n0 = n0();
        F1(n0, 13, new t.a() { // from class: com.google.android.exoplayer2.m2.r
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).Q(i1.a.this, t1Var);
            }
        });
    }

    @Override // com.google.android.exoplayer2.u1.c
    public final void d0(final boolean z, final int i) {
        final i1.a n0 = n0();
        F1(n0, 6, new t.a() { // from class: com.google.android.exoplayer2.m2.y0
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).x(i1.a.this, z, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.u1.c
    public final void e(final u1.f fVar, final u1.f fVar2, final int i) {
        if (i == 1) {
            this.p1 = false;
        }
        this.q.j((u1) com.google.android.exoplayer2.util.g.e(this.z));
        final i1.a n0 = n0();
        F1(n0, 12, new t.a() { // from class: com.google.android.exoplayer2.m2.c1
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                h1.e1(i1.a.this, i, fVar, fVar2, (i1) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.f0
    public final void e0(int i, @Nullable e0.a aVar, final com.google.android.exoplayer2.source.x xVar, final a0 a0Var) {
        final i1.a r0 = r0(i, aVar);
        F1(r0, 1001, new t.a() { // from class: com.google.android.exoplayer2.m2.m
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).g0(i1.a.this, xVar, a0Var);
            }
        });
    }

    @Override // com.google.android.exoplayer2.u1.c
    public final void f(final int i) {
        final i1.a n0 = n0();
        F1(n0, 7, new t.a() { // from class: com.google.android.exoplayer2.m2.a
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).f(i1.a.this, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.v
    public final void f0(int i, @Nullable e0.a aVar, final int i2) {
        final i1.a r0 = r0(i, aVar);
        F1(r0, 1030, new t.a() { // from class: com.google.android.exoplayer2.m2.i0
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                h1.L0(i1.a.this, i2, (i1) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.u1.c
    public /* synthetic */ void g(boolean z) {
        v1.d(this, z);
    }

    @Override // com.google.android.exoplayer2.drm.v
    public final void g0(int i, @Nullable e0.a aVar) {
        final i1.a r0 = r0(i, aVar);
        F1(r0, 1035, new t.a() { // from class: com.google.android.exoplayer2.m2.u
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).P(i1.a.this);
            }
        });
    }

    @Override // com.google.android.exoplayer2.video.y
    public final void h(final String str) {
        final i1.a t0 = t0();
        F1(t0, 1024, new t.a() { // from class: com.google.android.exoplayer2.m2.n0
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).a(i1.a.this, str);
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.t
    public final void h0(final int i, final long j, final long j2) {
        final i1.a t0 = t0();
        F1(t0, PointerIconCompat.TYPE_NO_DROP, new t.a() { // from class: com.google.android.exoplayer2.m2.b1
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).R(i1.a.this, i, j, j2);
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.t
    public final void i(final d dVar) {
        final i1.a t0 = t0();
        F1(t0, PointerIconCompat.TYPE_TEXT, new t.a() { // from class: com.google.android.exoplayer2.m2.n
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                h1.A0(i1.a.this, dVar, (i1) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.f0
    public final void i0(int i, @Nullable e0.a aVar, final com.google.android.exoplayer2.source.x xVar, final a0 a0Var, final IOException iOException, final boolean z) {
        final i1.a r0 = r0(i, aVar);
        F1(r0, 1003, new t.a() { // from class: com.google.android.exoplayer2.m2.l
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).j(i1.a.this, xVar, a0Var, iOException, z);
            }
        });
    }

    @Override // com.google.android.exoplayer2.u1.c
    @Deprecated
    public final void j(final List<Metadata> list) {
        final i1.a n0 = n0();
        F1(n0, 3, new t.a() { // from class: com.google.android.exoplayer2.m2.t
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).p0(i1.a.this, list);
            }
        });
    }

    @Override // com.google.android.exoplayer2.video.y
    public final void j0(final long j, final int i) {
        final i1.a s0 = s0();
        F1(s0, 1026, new t.a() { // from class: com.google.android.exoplayer2.m2.z0
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).b(i1.a.this, j, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.video.y
    public final void k(final String str, final long j, final long j2) {
        final i1.a t0 = t0();
        F1(t0, PointerIconCompat.TYPE_GRABBING, new t.a() { // from class: com.google.android.exoplayer2.m2.b
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                h1.q1(i1.a.this, str, j2, j, (i1) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.n2.c
    public /* synthetic */ void k0(b bVar) {
        w1.c(this, bVar);
    }

    @Override // com.google.android.exoplayer2.source.f0
    public final void l(int i, @Nullable e0.a aVar, final a0 a0Var) {
        final i1.a r0 = r0(i, aVar);
        F1(r0, 1004, new t.a() { // from class: com.google.android.exoplayer2.m2.d1
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).f0(i1.a.this, a0Var);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.v
    public final void l0(int i, @Nullable e0.a aVar) {
        final i1.a r0 = r0(i, aVar);
        F1(r0, 1033, new t.a() { // from class: com.google.android.exoplayer2.m2.i
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).e(i1.a.this);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.f0
    public final void m(int i, @Nullable e0.a aVar, final com.google.android.exoplayer2.source.x xVar, final a0 a0Var) {
        final i1.a r0 = r0(i, aVar);
        F1(r0, 1002, new t.a() { // from class: com.google.android.exoplayer2.m2.q0
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).b0(i1.a.this, xVar, a0Var);
            }
        });
    }

    @Override // com.google.android.exoplayer2.u1.c
    public void m0(final boolean z) {
        final i1.a n0 = n0();
        F1(n0, 8, new t.a() { // from class: com.google.android.exoplayer2.m2.l0
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).d0(i1.a.this, z);
            }
        });
    }

    @Override // com.google.android.exoplayer2.u1.c
    public void n(final u1.b bVar) {
        final i1.a n0 = n0();
        F1(n0, 14, new t.a() { // from class: com.google.android.exoplayer2.m2.c
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).m0(i1.a.this, bVar);
            }
        });
    }

    protected final i1.a n0() {
        return p0(this.q.d());
    }

    @Override // com.google.android.exoplayer2.u1.c
    public final void o(j2 j2Var, final int i) {
        this.q.l((u1) com.google.android.exoplayer2.util.g.e(this.z));
        final i1.a n0 = n0();
        F1(n0, 0, new t.a() { // from class: com.google.android.exoplayer2.m2.u0
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).B(i1.a.this, i);
            }
        });
    }

    @RequiresNonNull({"player"})
    protected final i1.a o0(j2 j2Var, int i, @Nullable e0.a aVar) {
        e0.a aVar2 = j2Var.q() ? null : aVar;
        long elapsedRealtime = this.f2431c.elapsedRealtime();
        boolean z = true;
        boolean z2 = j2Var.equals(this.z.w()) && i == this.z.m();
        long j = 0;
        if (aVar2 != null && aVar2.b()) {
            if (!(z2 && this.z.r() == aVar2.f3203b && this.z.K() == aVar2.f3204c)) {
                z = false;
            }
            if (z) {
                j = this.z.V();
            }
        } else if (z2) {
            j = this.z.M();
            return new i1.a(elapsedRealtime, j2Var, i, aVar2, j, this.z.w(), this.z.m(), this.q.d(), this.z.V(), this.z.g());
        } else if (!j2Var.q()) {
            j = j2Var.n(i, this.f2433f).b();
        }
        return new i1.a(elapsedRealtime, j2Var, i, aVar2, j, this.z.w(), this.z.m(), this.q.d(), this.z.V(), this.z.g());
    }

    @Override // com.google.android.exoplayer2.u1.c
    public final void onRepeatModeChanged(final int i) {
        final i1.a n0 = n0();
        F1(n0, 9, new t.a() { // from class: com.google.android.exoplayer2.m2.f1
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).V(i1.a.this, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.f0
    public final void p(int i, @Nullable e0.a aVar, final com.google.android.exoplayer2.source.x xVar, final a0 a0Var) {
        final i1.a r0 = r0(i, aVar);
        F1(r0, 1000, new t.a() { // from class: com.google.android.exoplayer2.m2.s
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).L(i1.a.this, xVar, a0Var);
            }
        });
    }

    @Override // com.google.android.exoplayer2.u1.c
    public final void q(final int i) {
        final i1.a n0 = n0();
        F1(n0, 5, new t.a() { // from class: com.google.android.exoplayer2.m2.s0
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).p(i1.a.this, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.upstream.g.a
    public final void r(final int i, final long j, final long j2) {
        final i1.a q0 = q0();
        F1(q0, PointerIconCompat.TYPE_CELL, new t.a() { // from class: com.google.android.exoplayer2.m2.c0
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).H(i1.a.this, i, j, j2);
            }
        });
    }

    @Override // com.google.android.exoplayer2.u1.c
    public void s(final m1 m1Var) {
        final i1.a n0 = n0();
        F1(n0, 15, new t.a() { // from class: com.google.android.exoplayer2.m2.h0
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).h(i1.a.this, m1Var);
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.t
    public final void t(final String str) {
        final i1.a t0 = t0();
        F1(t0, PointerIconCompat.TYPE_ALL_SCROLL, new t.a() { // from class: com.google.android.exoplayer2.m2.e
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).j0(i1.a.this, str);
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.t
    public final void u(final String str, final long j, final long j2) {
        final i1.a t0 = t0();
        F1(t0, PointerIconCompat.TYPE_VERTICAL_TEXT, new t.a() { // from class: com.google.android.exoplayer2.m2.g0
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                h1.x0(i1.a.this, str, j2, j, (i1) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.u1.c
    public final void v(final boolean z) {
        final i1.a n0 = n0();
        F1(n0, 10, new t.a() { // from class: com.google.android.exoplayer2.m2.b0
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).t(i1.a.this, z);
            }
        });
    }

    @Override // com.google.android.exoplayer2.metadata.e
    public final void w(final Metadata metadata) {
        final i1.a n0 = n0();
        F1(n0, PointerIconCompat.TYPE_CROSSHAIR, new t.a() { // from class: com.google.android.exoplayer2.m2.k0
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).m(i1.a.this, metadata);
            }
        });
    }

    @Override // com.google.android.exoplayer2.n2.c
    public /* synthetic */ void x(int i, boolean z) {
        w1.d(this, i, z);
    }

    @Override // com.google.android.exoplayer2.drm.v
    public final void y(int i, @Nullable e0.a aVar) {
        final i1.a r0 = r0(i, aVar);
        F1(r0, 1034, new t.a() { // from class: com.google.android.exoplayer2.m2.x
            @Override // com.google.android.exoplayer2.util.t.a
            public final void invoke(Object obj) {
                ((i1) obj).G(i1.a.this);
            }
        });
    }

    @Override // com.google.android.exoplayer2.video.w
    public /* synthetic */ void z() {
        w1.r(this);
    }
}

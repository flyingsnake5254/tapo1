package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.google.android.exoplayer2.e1;
import com.google.android.exoplayer2.g1;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.m2.h1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.r1;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.e0;
import com.google.android.exoplayer2.source.g0;
import com.google.android.exoplayer2.source.p0;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.trackselection.k;
import com.google.android.exoplayer2.trackselection.m;
import com.google.android.exoplayer2.trackselection.n;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.upstream.g;
import com.google.android.exoplayer2.util.h;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.p;
import com.google.android.exoplayer2.util.r;
import com.google.android.exoplayer2.util.t;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.video.z;
import com.google.android.exoplayer2.x1;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExoPlayerImpl.java */
/* loaded from: classes.dex */
public final class f1 extends t0 implements e1 {
    private g2 A;
    private p0 B;
    private boolean C;
    private u1.b D;
    private m1 E;
    private m1 F;
    private s1 G;
    private int H;
    private int I;
    private long J;

    /* renamed from: b  reason: collision with root package name */
    final n f2267b;

    /* renamed from: c  reason: collision with root package name */
    final u1.b f2268c;

    /* renamed from: d  reason: collision with root package name */
    private final b2[] f2269d;

    /* renamed from: e  reason: collision with root package name */
    private final m f2270e;

    /* renamed from: f  reason: collision with root package name */
    private final r f2271f;
    private final g1.f g;
    private final g1 h;
    private final t<u1.c> i;
    private final CopyOnWriteArraySet<e1.a> j;
    private final j2.b k;
    private final List<a> l;
    private final boolean m;
    private final g0 n;
    @Nullable
    private final h1 o;
    private final Looper p;
    private final g q;
    private final long r;
    private final long s;
    private final h t;
    private int u;
    private boolean v;
    private int w;
    private int x;
    private boolean y;
    private int z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ExoPlayerImpl.java */
    /* loaded from: classes.dex */
    public static final class a implements q1 {
        private final Object a;

        /* renamed from: b  reason: collision with root package name */
        private j2 f2272b;

        public a(Object obj, j2 j2Var) {
            this.a = obj;
            this.f2272b = j2Var;
        }

        @Override // com.google.android.exoplayer2.q1
        public j2 a() {
            return this.f2272b;
        }

        @Override // com.google.android.exoplayer2.q1
        public Object getUid() {
            return this.a;
        }
    }

    @SuppressLint({"HandlerLeak"})
    public f1(b2[] b2VarArr, m mVar, g0 g0Var, k1 k1Var, g gVar, @Nullable h1 h1Var, boolean z, g2 g2Var, long j, long j2, j1 j1Var, long j3, boolean z2, h hVar, Looper looper, @Nullable u1 u1Var, u1.b bVar) {
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = o0.f3936e;
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 30 + String.valueOf(str).length());
        sb.append("Init ");
        sb.append(hexString);
        sb.append(" [");
        sb.append("ExoPlayerLib/2.15.0");
        sb.append("] [");
        sb.append(str);
        sb.append("]");
        u.f("ExoPlayerImpl", sb.toString());
        com.google.android.exoplayer2.util.g.g(b2VarArr.length > 0);
        this.f2269d = (b2[]) com.google.android.exoplayer2.util.g.e(b2VarArr);
        this.f2270e = (m) com.google.android.exoplayer2.util.g.e(mVar);
        this.n = g0Var;
        this.q = gVar;
        this.o = h1Var;
        this.m = z;
        this.A = g2Var;
        this.r = j;
        this.s = j2;
        this.C = z2;
        this.p = looper;
        this.t = hVar;
        this.u = 0;
        final u1 u1Var2 = u1Var != null ? u1Var : this;
        this.i = new t<>(looper, hVar, new t.b() { // from class: com.google.android.exoplayer2.n
            @Override // com.google.android.exoplayer2.util.t.b
            public final void a(Object obj, p pVar) {
                ((u1.c) obj).S(u1.this, new u1.d(pVar));
            }
        });
        this.j = new CopyOnWriteArraySet<>();
        this.l = new ArrayList();
        this.B = new p0.a(0);
        n nVar = new n(new e2[b2VarArr.length], new com.google.android.exoplayer2.trackselection.g[b2VarArr.length], null);
        this.f2267b = nVar;
        this.k = new j2.b();
        u1.b e2 = new u1.b.a().c(1, 2, 12, 13, 14, 15, 16, 17, 18, 19).b(bVar).e();
        this.f2268c = e2;
        this.D = new u1.b.a().b(e2).a(3).a(9).e();
        m1 m1Var = m1.a;
        this.E = m1Var;
        this.F = m1Var;
        this.H = -1;
        this.f2271f = hVar.b(looper, null);
        g1.f rVar = new g1.f() { // from class: com.google.android.exoplayer2.r
            @Override // com.google.android.exoplayer2.g1.f
            public final void a(g1.e eVar) {
                f1.this.J0(eVar);
            }
        };
        this.g = rVar;
        this.G = s1.k(nVar);
        if (h1Var != null) {
            h1Var.G1(u1Var2, looper);
            N(h1Var);
            gVar.g(new Handler(looper), h1Var);
        }
        this.h = new g1(b2VarArr, mVar, nVar, k1Var, gVar, this.u, this.v, h1Var, g2Var, j1Var, j3, z2, looper, hVar, rVar);
    }

    private u1.f A0(long j) {
        int i;
        Object obj;
        int m = m();
        Object obj2 = null;
        if (!this.G.f3137b.q()) {
            s1 s1Var = this.G;
            Object obj3 = s1Var.f3138c.a;
            s1Var.f3137b.h(obj3, this.k);
            i = this.G.f3137b.b(obj3);
            obj2 = this.G.f3137b.n(m, this.a).f2336e;
            obj = obj3;
        } else {
            obj = null;
            i = -1;
        }
        long e2 = w0.e(j);
        long e3 = this.G.f3138c.b() ? w0.e(C0(this.G)) : e2;
        e0.a aVar = this.G.f3138c;
        return new u1.f(obj2, m, obj, i, e2, e3, aVar.f3203b, aVar.f3204c);
    }

    private u1.f B0(int i, s1 s1Var, int i2) {
        int i3;
        Object obj;
        int i4;
        long j;
        long j2;
        j2.b bVar = new j2.b();
        Object obj2 = null;
        if (!s1Var.f3137b.q()) {
            Object obj3 = s1Var.f3138c.a;
            s1Var.f3137b.h(obj3, bVar);
            int i5 = bVar.f2330d;
            i3 = s1Var.f3137b.b(obj3);
            obj2 = s1Var.f3137b.n(i5, this.a).f2336e;
            i4 = i5;
            obj = obj3;
        } else {
            i4 = i2;
            obj = null;
            i3 = -1;
        }
        if (i == 0) {
            j = bVar.f2332f + bVar.f2331e;
            if (s1Var.f3138c.b()) {
                e0.a aVar = s1Var.f3138c;
                j = bVar.b(aVar.f3203b, aVar.f3204c);
                j2 = C0(s1Var);
            } else {
                if (s1Var.f3138c.f3206e != -1 && this.G.f3138c.b()) {
                    j = C0(this.G);
                }
                j2 = j;
            }
        } else if (s1Var.f3138c.b()) {
            j = s1Var.t;
            j2 = C0(s1Var);
        } else {
            j = bVar.f2332f + s1Var.t;
            j2 = j;
        }
        long e2 = w0.e(j);
        long e3 = w0.e(j2);
        e0.a aVar2 = s1Var.f3138c;
        return new u1.f(obj2, i4, obj, i3, e2, e3, aVar2.f3203b, aVar2.f3204c);
    }

    private static long C0(s1 s1Var) {
        j2.c cVar = new j2.c();
        j2.b bVar = new j2.b();
        s1Var.f3137b.h(s1Var.f3138c.a, bVar);
        if (s1Var.f3139d == -9223372036854775807L) {
            return s1Var.f3137b.n(bVar.f2330d, cVar).c();
        }
        return bVar.m() + s1Var.f3139d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D0 */
    public void G0(g1.e eVar) {
        long j;
        boolean z;
        int i = this.w - eVar.f2289c;
        this.w = i;
        boolean z2 = true;
        if (eVar.f2290d) {
            this.x = eVar.f2291e;
            this.y = true;
        }
        if (eVar.f2292f) {
            this.z = eVar.g;
        }
        if (i == 0) {
            j2 j2Var = eVar.f2288b.f3137b;
            if (!this.G.f3137b.q() && j2Var.q()) {
                this.H = -1;
                this.J = 0L;
                this.I = 0;
            }
            if (!j2Var.q()) {
                List<j2> E = ((y1) j2Var).E();
                com.google.android.exoplayer2.util.g.g(E.size() == this.l.size());
                for (int i2 = 0; i2 < E.size(); i2++) {
                    this.l.get(i2).f2272b = E.get(i2);
                }
            }
            if (this.y) {
                if (eVar.f2288b.f3138c.equals(this.G.f3138c) && eVar.f2288b.f3140e == this.G.t) {
                    z2 = false;
                }
                if (!z2) {
                    j = -9223372036854775807L;
                } else if (j2Var.q() || eVar.f2288b.f3138c.b()) {
                    j = eVar.f2288b.f3140e;
                } else {
                    s1 s1Var = eVar.f2288b;
                    j = i1(j2Var, s1Var.f3138c, s1Var.f3140e);
                }
                z = z2;
            } else {
                j = -9223372036854775807L;
                z = false;
            }
            this.y = false;
            r1(eVar.f2288b, 1, this.z, false, z, this.x, j, -1);
        }
    }

    private static boolean E0(s1 s1Var) {
        return s1Var.f3141f == 3 && s1Var.m && s1Var.n == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I0 */
    public /* synthetic */ void J0(final g1.e eVar) {
        this.f2271f.h(new Runnable() { // from class: com.google.android.exoplayer2.x
            @Override // java.lang.Runnable
            public final void run() {
                f1.this.H0(eVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K0 */
    public /* synthetic */ void L0(u1.c cVar) {
        cVar.s(this.E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P0 */
    public /* synthetic */ void Q0(u1.c cVar) {
        cVar.n(this.D);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void X0(s1 s1Var, u1.c cVar) {
        cVar.g(s1Var.h);
        cVar.M(s1Var.h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void f1(int i, u1.f fVar, u1.f fVar2, u1.c cVar) {
        cVar.K(i);
        cVar.e(fVar, fVar2, i);
    }

    private s1 g1(s1 s1Var, j2 j2Var, @Nullable Pair<Object, Long> pair) {
        int i;
        long j;
        com.google.android.exoplayer2.util.g.a(j2Var.q() || pair != null);
        j2 j2Var2 = s1Var.f3137b;
        s1 j2 = s1Var.j(j2Var);
        if (j2Var.q()) {
            e0.a l = s1.l();
            long d2 = w0.d(this.J);
            s1 b2 = j2.c(l, d2, d2, d2, 0L, TrackGroupArray.f3160c, this.f2267b, ImmutableList.of()).b(l);
            b2.r = b2.t;
            return b2;
        }
        Object obj = j2.f3138c.a;
        boolean z = !obj.equals(((Pair) o0.i(pair)).first);
        e0.a aVar = z ? new e0.a(pair.first) : j2.f3138c;
        long longValue = ((Long) pair.second).longValue();
        long d3 = w0.d(M());
        if (!j2Var2.q()) {
            d3 -= j2Var2.h(obj, this.k).m();
        }
        if (z || longValue < d3) {
            com.google.android.exoplayer2.util.g.g(!aVar.b());
            s1 b3 = j2.c(aVar, longValue, longValue, longValue, 0L, z ? TrackGroupArray.f3160c : j2.i, z ? this.f2267b : j2.j, z ? ImmutableList.of() : j2.k).b(aVar);
            b3.r = longValue;
            return b3;
        }
        if (i == 0) {
            int b4 = j2Var.b(j2.l.a);
            if (b4 == -1 || j2Var.f(b4, this.k).f2330d != j2Var.h(aVar.a, this.k).f2330d) {
                j2Var.h(aVar.a, this.k);
                if (aVar.b()) {
                    j = this.k.b(aVar.f3203b, aVar.f3204c);
                } else {
                    j = this.k.f2331e;
                }
                j2 = j2.c(aVar, j2.t, j2.t, j2.f3140e, j - j2.t, j2.i, j2.j, j2.k).b(aVar);
                j2.r = j;
            }
        } else {
            com.google.android.exoplayer2.util.g.g(!aVar.b());
            long max = Math.max(0L, j2.s - (longValue - d3));
            long j3 = j2.r;
            if (j2.l.equals(j2.f3138c)) {
                j3 = longValue + max;
            }
            j2 = j2.c(aVar, longValue, longValue, longValue, max, j2.i, j2.j, j2.k);
            j2.r = j3;
        }
        return j2;
    }

    private long i1(j2 j2Var, e0.a aVar, long j) {
        j2Var.h(aVar.a, this.k);
        return j + this.k.m();
    }

    private s1 k1(int i, int i2) {
        boolean z = false;
        com.google.android.exoplayer2.util.g.a(i >= 0 && i2 >= i && i2 <= this.l.size());
        int m = m();
        j2 w = w();
        int size = this.l.size();
        this.w++;
        l1(i, i2);
        j2 o0 = o0();
        s1 g1 = g1(this.G, o0, x0(w, o0));
        int i3 = g1.f3141f;
        if (i3 != 1 && i3 != 4 && i < i2 && i2 == size && m >= g1.f3137b.p()) {
            z = true;
        }
        if (z) {
            g1 = g1.h(4);
        }
        this.h.o0(i, i2, this.B);
        return g1;
    }

    private void l1(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            this.l.remove(i3);
        }
        this.B = this.B.b(i, i2);
    }

    private List<r1.c> n0(int i, List<e0> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            r1.c cVar = new r1.c(list.get(i2), this.m);
            arrayList.add(cVar);
            this.l.add(i2 + i, new a(cVar.f3126b, cVar.a.M()));
        }
        this.B = this.B.h(i, arrayList.size());
        return arrayList;
    }

    private void n1(List<e0> list, int i, long j, boolean z) {
        int i2;
        long j2;
        int w0 = w0();
        long V = V();
        boolean z2 = true;
        this.w++;
        if (!this.l.isEmpty()) {
            l1(0, this.l.size());
        }
        List<r1.c> n0 = n0(0, list);
        j2 o0 = o0();
        if (o0.q() || i < o0.p()) {
            if (z) {
                i2 = o0.a(this.v);
                j2 = -9223372036854775807L;
            } else if (i == -1) {
                i2 = w0;
                j2 = V;
            } else {
                i2 = i;
                j2 = j;
            }
            s1 g1 = g1(this.G, o0, y0(o0, i2, j2));
            int i3 = g1.f3141f;
            if (!(i2 == -1 || i3 == 1)) {
                i3 = (o0.q() || i2 >= o0.p()) ? 4 : 2;
            }
            s1 h = g1.h(i3);
            this.h.N0(n0, i2, w0.d(j2), this.B);
            if (this.G.f3138c.a.equals(h.f3138c.a) || this.G.f3137b.q()) {
                z2 = false;
            }
            r1(h, 0, 1, false, z2, 4, v0(h), -1);
            return;
        }
        throw new IllegalSeekPositionException(o0, i, j);
    }

    private j2 o0() {
        return new y1(this.l, this.B);
    }

    private List<e0> p0(List<l1> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(this.n.a(list.get(i)));
        }
        return arrayList;
    }

    private void q1() {
        u1.b bVar = this.D;
        u1.b d2 = d(this.f2268c);
        this.D = d2;
        if (!d2.equals(bVar)) {
            this.i.g(14, new t.a() { // from class: com.google.android.exoplayer2.v
                @Override // com.google.android.exoplayer2.util.t.a
                public final void invoke(Object obj) {
                    f1.this.Q0((u1.c) obj);
                }
            });
        }
    }

    private Pair<Boolean, Integer> r0(s1 s1Var, s1 s1Var2, boolean z, int i, boolean z2) {
        j2 j2Var = s1Var2.f3137b;
        j2 j2Var2 = s1Var.f3137b;
        if (j2Var2.q() && j2Var.q()) {
            return new Pair<>(Boolean.FALSE, -1);
        }
        int i2 = 3;
        if (j2Var2.q() != j2Var.q()) {
            return new Pair<>(Boolean.TRUE, 3);
        }
        if (!j2Var.n(j2Var.h(s1Var2.f3138c.a, this.k).f2330d, this.a).f2336e.equals(j2Var2.n(j2Var2.h(s1Var.f3138c.a, this.k).f2330d, this.a).f2336e)) {
            if (z && i == 0) {
                i2 = 1;
            } else if (z && i == 1) {
                i2 = 2;
            } else if (!z2) {
                throw new IllegalStateException();
            }
            return new Pair<>(Boolean.TRUE, Integer.valueOf(i2));
        } else if (!z || i != 0 || s1Var2.f3138c.f3205d >= s1Var.f3138c.f3205d) {
            return new Pair<>(Boolean.FALSE, -1);
        } else {
            return new Pair<>(Boolean.TRUE, 0);
        }
    }

    private void r1(final s1 s1Var, final int i, final int i2, boolean z, boolean z2, final int i3, long j, int i4) {
        s1 s1Var2 = this.G;
        this.G = s1Var;
        Pair<Boolean, Integer> r0 = r0(s1Var, s1Var2, z2, i3, !s1Var2.f3137b.equals(s1Var.f3137b));
        boolean booleanValue = ((Boolean) r0.first).booleanValue();
        final int intValue = ((Integer) r0.second).intValue();
        m1 m1Var = this.E;
        final l1 l1Var = null;
        if (booleanValue) {
            if (!s1Var.f3137b.q()) {
                l1Var = s1Var.f3137b.n(s1Var.f3137b.h(s1Var.f3138c.a, this.k).f2330d, this.a).g;
            }
            m1Var = l1Var != null ? l1Var.f2348f : m1.a;
        }
        if (!s1Var2.k.equals(s1Var.k)) {
            m1Var = m1Var.a().I(s1Var.k).F();
        }
        boolean z3 = !m1Var.equals(this.E);
        this.E = m1Var;
        if (!s1Var2.f3137b.equals(s1Var.f3137b)) {
            this.i.g(0, new t.a() { // from class: com.google.android.exoplayer2.q
                @Override // com.google.android.exoplayer2.util.t.a
                public final void invoke(Object obj) {
                    u1.c cVar = (u1.c) obj;
                    cVar.o(s1.this.f3137b, i);
                }
            });
        }
        if (z2) {
            final u1.f B0 = B0(i3, s1Var2, i4);
            final u1.f A0 = A0(j);
            this.i.g(12, new t.a() { // from class: com.google.android.exoplayer2.o
                @Override // com.google.android.exoplayer2.util.t.a
                public final void invoke(Object obj) {
                    f1.f1(i3, B0, A0, (u1.c) obj);
                }
            });
        }
        if (booleanValue) {
            this.i.g(1, new t.a() { // from class: com.google.android.exoplayer2.m
                @Override // com.google.android.exoplayer2.util.t.a
                public final void invoke(Object obj) {
                    ((u1.c) obj).Y(l1.this, intValue);
                }
            });
        }
        if (s1Var2.g != s1Var.g) {
            this.i.g(11, new t.a() { // from class: com.google.android.exoplayer2.h
                @Override // com.google.android.exoplayer2.util.t.a
                public final void invoke(Object obj) {
                    ((u1.c) obj).J(s1.this.g);
                }
            });
            if (s1Var.g != null) {
                this.i.g(11, new t.a() { // from class: com.google.android.exoplayer2.e
                    @Override // com.google.android.exoplayer2.util.t.a
                    public final void invoke(Object obj) {
                        ((u1.c) obj).P(s1.this.g);
                    }
                });
            }
        }
        n nVar = s1Var2.j;
        n nVar2 = s1Var.j;
        if (nVar != nVar2) {
            this.f2270e.d(nVar2.f3654d);
            final k kVar = new k(s1Var.j.f3653c);
            this.i.g(2, new t.a() { // from class: com.google.android.exoplayer2.l
                @Override // com.google.android.exoplayer2.util.t.a
                public final void invoke(Object obj) {
                    u1.c cVar = (u1.c) obj;
                    cVar.G(s1.this.i, kVar);
                }
            });
        }
        if (!s1Var2.k.equals(s1Var.k)) {
            this.i.g(3, new t.a() { // from class: com.google.android.exoplayer2.i
                @Override // com.google.android.exoplayer2.util.t.a
                public final void invoke(Object obj) {
                    ((u1.c) obj).j(s1.this.k);
                }
            });
        }
        if (z3) {
            final m1 m1Var2 = this.E;
            this.i.g(15, new t.a() { // from class: com.google.android.exoplayer2.u
                @Override // com.google.android.exoplayer2.util.t.a
                public final void invoke(Object obj) {
                    ((u1.c) obj).s(m1.this);
                }
            });
        }
        if (s1Var2.h != s1Var.h) {
            this.i.g(4, new t.a() { // from class: com.google.android.exoplayer2.w
                @Override // com.google.android.exoplayer2.util.t.a
                public final void invoke(Object obj) {
                    f1.X0(s1.this, (u1.c) obj);
                }
            });
        }
        if (!(s1Var2.f3141f == s1Var.f3141f && s1Var2.m == s1Var.m)) {
            this.i.g(-1, new t.a() { // from class: com.google.android.exoplayer2.g
                @Override // com.google.android.exoplayer2.util.t.a
                public final void invoke(Object obj) {
                    ((u1.c) obj).U(r0.m, s1.this.f3141f);
                }
            });
        }
        if (s1Var2.f3141f != s1Var.f3141f) {
            this.i.g(5, new t.a() { // from class: com.google.android.exoplayer2.z
                @Override // com.google.android.exoplayer2.util.t.a
                public final void invoke(Object obj) {
                    ((u1.c) obj).q(s1.this.f3141f);
                }
            });
        }
        if (s1Var2.m != s1Var.m) {
            this.i.g(6, new t.a() { // from class: com.google.android.exoplayer2.k
                @Override // com.google.android.exoplayer2.util.t.a
                public final void invoke(Object obj) {
                    u1.c cVar = (u1.c) obj;
                    cVar.d0(s1.this.m, i2);
                }
            });
        }
        if (s1Var2.n != s1Var.n) {
            this.i.g(7, new t.a() { // from class: com.google.android.exoplayer2.y
                @Override // com.google.android.exoplayer2.util.t.a
                public final void invoke(Object obj) {
                    ((u1.c) obj).f(s1.this.n);
                }
            });
        }
        if (E0(s1Var2) != E0(s1Var)) {
            this.i.g(8, new t.a() { // from class: com.google.android.exoplayer2.j
                @Override // com.google.android.exoplayer2.util.t.a
                public final void invoke(Object obj) {
                    ((u1.c) obj).m0(f1.E0(s1.this));
                }
            });
        }
        if (!s1Var2.o.equals(s1Var.o)) {
            this.i.g(13, new t.a() { // from class: com.google.android.exoplayer2.p
                @Override // com.google.android.exoplayer2.util.t.a
                public final void invoke(Object obj) {
                    ((u1.c) obj).d(s1.this.o);
                }
            });
        }
        if (z) {
            this.i.g(-1, a.a);
        }
        q1();
        this.i.c();
        if (s1Var2.p != s1Var.p) {
            Iterator<e1.a> it = this.j.iterator();
            while (it.hasNext()) {
                it.next().I(s1Var.p);
            }
        }
        if (s1Var2.q != s1Var.q) {
            Iterator<e1.a> it2 = this.j.iterator();
            while (it2.hasNext()) {
                it2.next().y(s1Var.q);
            }
        }
    }

    private long v0(s1 s1Var) {
        if (s1Var.f3137b.q()) {
            return w0.d(this.J);
        }
        if (s1Var.f3138c.b()) {
            return s1Var.t;
        }
        return i1(s1Var.f3137b, s1Var.f3138c, s1Var.t);
    }

    private int w0() {
        if (this.G.f3137b.q()) {
            return this.H;
        }
        s1 s1Var = this.G;
        return s1Var.f3137b.h(s1Var.f3138c.a, this.k).f2330d;
    }

    @Nullable
    private Pair<Object, Long> x0(j2 j2Var, j2 j2Var2) {
        long M = M();
        int i = -1;
        if (j2Var.q() || j2Var2.q()) {
            boolean z = !j2Var.q() && j2Var2.q();
            if (!z) {
                i = w0();
            }
            if (z) {
                M = -9223372036854775807L;
            }
            return y0(j2Var2, i, M);
        }
        Pair<Object, Long> j = j2Var.j(this.a, this.k, m(), w0.d(M));
        Object obj = ((Pair) o0.i(j)).first;
        if (j2Var2.b(obj) != -1) {
            return j;
        }
        Object z0 = g1.z0(this.a, this.k, this.u, this.v, obj, j2Var, j2Var2);
        if (z0 == null) {
            return y0(j2Var2, -1, -9223372036854775807L);
        }
        j2Var2.h(z0, this.k);
        int i2 = this.k.f2330d;
        return y0(j2Var2, i2, j2Var2.n(i2, this.a).b());
    }

    @Nullable
    private Pair<Object, Long> y0(j2 j2Var, int i, long j) {
        if (j2Var.q()) {
            this.H = i;
            if (j == -9223372036854775807L) {
                j = 0;
            }
            this.J = j;
            this.I = 0;
            return null;
        }
        if (i == -1 || i >= j2Var.p()) {
            i = j2Var.a(this.v);
            j = j2Var.n(i, this.a).b();
        }
        return j2Var.j(this.a, this.k, i, w0.d(j));
    }

    @Override // com.google.android.exoplayer2.u1
    public k A() {
        return new k(this.G.j.f3653c);
    }

    @Override // com.google.android.exoplayer2.u1
    public void B(int i, long j) {
        j2 j2Var = this.G.f3137b;
        if (i < 0 || (!j2Var.q() && i >= j2Var.p())) {
            throw new IllegalSeekPositionException(j2Var, i, j);
        }
        int i2 = 1;
        this.w++;
        if (f()) {
            u.h("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            g1.e eVar = new g1.e(this.G);
            eVar.b(1);
            this.g.a(eVar);
            return;
        }
        if (getPlaybackState() != 1) {
            i2 = 2;
        }
        int m = m();
        s1 g1 = g1(this.G.h(i2), j2Var, y0(j2Var, i, j));
        this.h.B0(j2Var, i, w0.d(j));
        r1(g1, 0, 1, true, true, 1, v0(g1), m);
    }

    @Override // com.google.android.exoplayer2.u1
    public u1.b C() {
        return this.D;
    }

    @Override // com.google.android.exoplayer2.u1
    public boolean E() {
        return this.G.m;
    }

    @Override // com.google.android.exoplayer2.u1
    public void F(final boolean z) {
        if (this.v != z) {
            this.v = z;
            this.h.X0(z);
            this.i.g(10, new t.a() { // from class: com.google.android.exoplayer2.f
                @Override // com.google.android.exoplayer2.util.t.a
                public final void invoke(Object obj) {
                    ((u1.c) obj).v(z);
                }
            });
            q1();
            this.i.c();
        }
    }

    @Override // com.google.android.exoplayer2.u1
    public int G() {
        return PathInterpolatorCompat.MAX_NUM_POINTS;
    }

    @Override // com.google.android.exoplayer2.u1
    public int H() {
        if (this.G.f3137b.q()) {
            return this.I;
        }
        s1 s1Var = this.G;
        return s1Var.f3137b.b(s1Var.f3138c.a);
    }

    @Override // com.google.android.exoplayer2.u1
    public void I(@Nullable TextureView textureView) {
    }

    @Override // com.google.android.exoplayer2.u1
    public z J() {
        return z.a;
    }

    @Override // com.google.android.exoplayer2.u1
    public int K() {
        if (f()) {
            return this.G.f3138c.f3204c;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.u1
    public long L() {
        return this.s;
    }

    @Override // com.google.android.exoplayer2.u1
    public long M() {
        if (!f()) {
            return V();
        }
        s1 s1Var = this.G;
        s1Var.f3137b.h(s1Var.f3138c.a, this.k);
        s1 s1Var2 = this.G;
        if (s1Var2.f3139d == -9223372036854775807L) {
            return s1Var2.f3137b.n(m(), this.a).b();
        }
        return this.k.l() + w0.e(this.G.f3139d);
    }

    @Override // com.google.android.exoplayer2.u1
    public void N(u1.e eVar) {
        m0(eVar);
    }

    @Override // com.google.android.exoplayer2.u1
    public void P(@Nullable SurfaceView surfaceView) {
    }

    @Override // com.google.android.exoplayer2.u1
    public boolean Q() {
        return this.v;
    }

    @Override // com.google.android.exoplayer2.u1
    public long R() {
        if (this.G.f3137b.q()) {
            return this.J;
        }
        s1 s1Var = this.G;
        if (s1Var.l.f3205d != s1Var.f3138c.f3205d) {
            return s1Var.f3137b.n(m(), this.a).d();
        }
        long j = s1Var.r;
        if (this.G.l.b()) {
            s1 s1Var2 = this.G;
            j2.b h = s1Var2.f3137b.h(s1Var2.l.a, this.k);
            long f2 = h.f(this.G.l.f3203b);
            j = f2 == Long.MIN_VALUE ? h.f2331e : f2;
        }
        s1 s1Var3 = this.G;
        return w0.e(i1(s1Var3.f3137b, s1Var3.l, j));
    }

    @Override // com.google.android.exoplayer2.u1
    public m1 U() {
        return this.E;
    }

    @Override // com.google.android.exoplayer2.u1
    public long V() {
        return w0.e(v0(this.G));
    }

    @Override // com.google.android.exoplayer2.u1
    public long W() {
        return this.r;
    }

    @Override // com.google.android.exoplayer2.e1
    @Nullable
    public m a() {
        return this.f2270e;
    }

    @Override // com.google.android.exoplayer2.u1
    public t1 c() {
        return this.G.o;
    }

    @Override // com.google.android.exoplayer2.u1
    public void e(t1 t1Var) {
        if (t1Var == null) {
            t1Var = t1.a;
        }
        if (!this.G.o.equals(t1Var)) {
            s1 g = this.G.g(t1Var);
            this.w++;
            this.h.S0(t1Var);
            r1(g, 0, 1, false, false, 5, -9223372036854775807L, -1);
        }
    }

    @Override // com.google.android.exoplayer2.u1
    public boolean f() {
        return this.G.f3138c.b();
    }

    @Override // com.google.android.exoplayer2.u1
    public long g() {
        return w0.e(this.G.s);
    }

    @Override // com.google.android.exoplayer2.u1
    public int getPlaybackState() {
        return this.G.f3141f;
    }

    @Override // com.google.android.exoplayer2.u1
    public int getRepeatMode() {
        return this.u;
    }

    public void h1(Metadata metadata) {
        m1 F = this.E.a().H(metadata).F();
        if (!F.equals(this.E)) {
            this.E = F;
            this.i.j(15, new t.a() { // from class: com.google.android.exoplayer2.s
                @Override // com.google.android.exoplayer2.util.t.a
                public final void invoke(Object obj) {
                    f1.this.L0((u1.c) obj);
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.u1
    public void i(u1.e eVar) {
        j1(eVar);
    }

    @Override // com.google.android.exoplayer2.u1
    public void j(List<l1> list, boolean z) {
        m1(p0(list), z);
    }

    public void j1(u1.c cVar) {
        this.i.i(cVar);
    }

    @Override // com.google.android.exoplayer2.u1
    public void k(@Nullable SurfaceView surfaceView) {
    }

    @Override // com.google.android.exoplayer2.u1
    public void l(int i, int i2) {
        s1 k1 = k1(i, Math.min(i2, this.l.size()));
        r1(k1, 0, 1, false, !k1.f3138c.a.equals(this.G.f3138c.a), 4, v0(k1), -1);
    }

    public void l0(e1.a aVar) {
        this.j.add(aVar);
    }

    @Override // com.google.android.exoplayer2.u1
    public int m() {
        int w0 = w0();
        if (w0 == -1) {
            return 0;
        }
        return w0;
    }

    public void m0(u1.c cVar) {
        this.i.a(cVar);
    }

    public void m1(List<e0> list, boolean z) {
        n1(list, -1, -9223372036854775807L, z);
    }

    public void o1(boolean z, int i, int i2) {
        s1 s1Var = this.G;
        if (s1Var.m != z || s1Var.n != i) {
            this.w++;
            s1 e2 = s1Var.e(z, i);
            this.h.Q0(z, i);
            r1(e2, 0, i2, false, false, 5, -9223372036854775807L, -1);
        }
    }

    @Override // com.google.android.exoplayer2.u1
    public void p(boolean z) {
        o1(z, 0, 1);
    }

    public void p1(boolean z, @Nullable ExoPlaybackException exoPlaybackException) {
        s1 s1Var;
        if (z) {
            s1Var = k1(0, this.l.size()).f(null);
        } else {
            s1 s1Var2 = this.G;
            s1Var = s1Var2.b(s1Var2.f3138c);
            s1Var.r = s1Var.t;
            s1Var.s = 0L;
        }
        s1 h = s1Var.h(1);
        if (exoPlaybackException != null) {
            h = h.f(exoPlaybackException);
        }
        this.w++;
        this.h.h1();
        r1(h, 0, 1, false, h.f3137b.q() && !this.G.f3137b.q(), 4, v0(h), -1);
    }

    @Override // com.google.android.exoplayer2.u1
    public void prepare() {
        s1 s1Var = this.G;
        if (s1Var.f3141f == 1) {
            s1 f2 = s1Var.f(null);
            s1 h = f2.h(f2.f3137b.q() ? 4 : 2);
            this.w++;
            this.h.j0();
            r1(h, 1, 1, false, false, 5, -9223372036854775807L, -1);
        }
    }

    public x1 q0(x1.b bVar) {
        return new x1(this.h, bVar, this.G.f3137b, m(), this.t, this.h.A());
    }

    @Override // com.google.android.exoplayer2.u1
    public int r() {
        if (f()) {
            return this.G.f3138c.f3203b;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.u1
    public void release() {
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = o0.f3936e;
        String b2 = h1.b();
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 36 + String.valueOf(str).length() + String.valueOf(b2).length());
        sb.append("Release ");
        sb.append(hexString);
        sb.append(" [");
        sb.append("ExoPlayerLib/2.15.0");
        sb.append("] [");
        sb.append(str);
        sb.append("] [");
        sb.append(b2);
        sb.append("]");
        u.f("ExoPlayerImpl", sb.toString());
        if (!this.h.l0()) {
            this.i.j(11, t.a);
        }
        this.i.h();
        this.f2271f.f(null);
        h1 h1Var = this.o;
        if (h1Var != null) {
            this.q.d(h1Var);
        }
        s1 h = this.G.h(1);
        this.G = h;
        s1 b3 = h.b(h.f3138c);
        this.G = b3;
        b3.r = b3.t;
        this.G.s = 0L;
    }

    public boolean s0() {
        return this.G.q;
    }

    @Override // com.google.android.exoplayer2.u1
    public void setRepeatMode(final int i) {
        if (this.u != i) {
            this.u = i;
            this.h.U0(i);
            this.i.g(9, new t.a() { // from class: com.google.android.exoplayer2.d
                @Override // com.google.android.exoplayer2.util.t.a
                public final void invoke(Object obj) {
                    ((u1.c) obj).onRepeatModeChanged(i);
                }
            });
            q1();
            this.i.c();
        }
    }

    @Override // com.google.android.exoplayer2.u1
    public int t() {
        return this.G.n;
    }

    public void t0(long j) {
        this.h.t(j);
    }

    @Override // com.google.android.exoplayer2.u1
    public TrackGroupArray u() {
        return this.G.i;
    }

    /* renamed from: u0 */
    public ImmutableList<c> q() {
        return ImmutableList.of();
    }

    @Override // com.google.android.exoplayer2.u1
    public long v() {
        if (!f()) {
            return X();
        }
        s1 s1Var = this.G;
        e0.a aVar = s1Var.f3138c;
        s1Var.f3137b.h(aVar.a, this.k);
        return w0.e(this.k.b(aVar.f3203b, aVar.f3204c));
    }

    @Override // com.google.android.exoplayer2.u1
    public j2 w() {
        return this.G.f3137b;
    }

    @Override // com.google.android.exoplayer2.u1
    public Looper x() {
        return this.p;
    }

    @Override // com.google.android.exoplayer2.u1
    public void z(@Nullable TextureView textureView) {
    }

    @Nullable
    /* renamed from: z0 */
    public ExoPlaybackException o() {
        return this.G.g;
    }
}

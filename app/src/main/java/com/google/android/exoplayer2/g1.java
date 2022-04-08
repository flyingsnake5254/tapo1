package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.b1;
import com.google.android.exoplayer2.b2;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.l1;
import com.google.android.exoplayer2.m2.h1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.r1;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.b0;
import com.google.android.exoplayer2.source.e0;
import com.google.android.exoplayer2.source.n0;
import com.google.android.exoplayer2.source.p0;
import com.google.android.exoplayer2.text.l;
import com.google.android.exoplayer2.trackselection.m;
import com.google.android.exoplayer2.trackselection.n;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.util.m0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.r;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.x1;
import com.google.common.base.t;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ExoPlayerImplInternal.java */
/* loaded from: classes.dex */
final class g1 implements Handler.Callback, b0.a, m.a, r1.d, b1.a, x1.a {
    private final long H3;
    private final boolean I3;
    private final b1 J3;
    private final ArrayList<d> K3;
    private final com.google.android.exoplayer2.util.h L3;
    private final f M3;
    private final p1 N3;
    private final r1 O3;
    private final j1 P3;
    private final long Q3;
    private g2 R3;
    private s1 S3;
    private e T3;
    private boolean U3;
    private boolean V3;
    private boolean W3;
    private boolean X3;
    private boolean Y3;
    private int Z3;
    private boolean a4;
    private boolean b4;

    /* renamed from: c  reason: collision with root package name */
    private final b2[] f2276c;
    private boolean c4;

    /* renamed from: d  reason: collision with root package name */
    private final d2[] f2277d;
    private boolean d4;
    private int e4;

    /* renamed from: f  reason: collision with root package name */
    private final m f2278f;
    @Nullable
    private h f4;
    private long g4;
    private int h4;
    private boolean i4;
    @Nullable
    private ExoPlaybackException j4;
    private long k4;
    private final HandlerThread p0;
    private final Looper p1;
    private final j2.c p2;
    private final j2.b p3;
    private final n q;
    private final k1 x;
    private final com.google.android.exoplayer2.upstream.g y;
    private final r z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ExoPlayerImplInternal.java */
    /* loaded from: classes.dex */
    public class a implements b2.a {
        a() {
        }

        @Override // com.google.android.exoplayer2.b2.a
        public void a() {
            g1.this.z.i(2);
        }

        @Override // com.google.android.exoplayer2.b2.a
        public void b(long j) {
            if (j >= 2000) {
                g1.this.c4 = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ExoPlayerImplInternal.java */
    /* loaded from: classes.dex */
    public static final class b {
        private final List<r1.c> a;

        /* renamed from: b  reason: collision with root package name */
        private final p0 f2279b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2280c;

        /* renamed from: d  reason: collision with root package name */
        private final long f2281d;

        /* synthetic */ b(List list, p0 p0Var, int i, long j, a aVar) {
            this(list, p0Var, i, j);
        }

        private b(List<r1.c> list, p0 p0Var, int i, long j) {
            this.a = list;
            this.f2279b = p0Var;
            this.f2280c = i;
            this.f2281d = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ExoPlayerImplInternal.java */
    /* loaded from: classes.dex */
    public static class c {
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f2282b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2283c;

        /* renamed from: d  reason: collision with root package name */
        public final p0 f2284d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ExoPlayerImplInternal.java */
    /* loaded from: classes.dex */
    public static final class d implements Comparable<d> {

        /* renamed from: c  reason: collision with root package name */
        public final x1 f2285c;

        /* renamed from: d  reason: collision with root package name */
        public int f2286d;

        /* renamed from: f  reason: collision with root package name */
        public long f2287f;
        @Nullable
        public Object q;

        public d(x1 x1Var) {
            this.f2285c = x1Var;
        }

        /* renamed from: a */
        public int compareTo(d dVar) {
            Object obj = this.q;
            if ((obj == null) != (dVar.q == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i = this.f2286d - dVar.f2286d;
            return i != 0 ? i : o0.n(this.f2287f, dVar.f2287f);
        }

        public void b(int i, long j, Object obj) {
            this.f2286d = i;
            this.f2287f = j;
            this.q = obj;
        }
    }

    /* compiled from: ExoPlayerImplInternal.java */
    /* loaded from: classes.dex */
    public static final class e {
        private boolean a;

        /* renamed from: b  reason: collision with root package name */
        public s1 f2288b;

        /* renamed from: c  reason: collision with root package name */
        public int f2289c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f2290d;

        /* renamed from: e  reason: collision with root package name */
        public int f2291e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f2292f;
        public int g;

        public e(s1 s1Var) {
            this.f2288b = s1Var;
        }

        public void b(int i) {
            this.a |= i > 0;
            this.f2289c += i;
        }

        public void c(int i) {
            this.a = true;
            this.f2292f = true;
            this.g = i;
        }

        public void d(s1 s1Var) {
            this.a |= this.f2288b != s1Var;
            this.f2288b = s1Var;
        }

        public void e(int i) {
            boolean z = true;
            if (!this.f2290d || this.f2291e == 5) {
                this.a = true;
                this.f2290d = true;
                this.f2291e = i;
                return;
            }
            if (i != 5) {
                z = false;
            }
            com.google.android.exoplayer2.util.g.a(z);
        }
    }

    /* compiled from: ExoPlayerImplInternal.java */
    /* loaded from: classes.dex */
    public interface f {
        void a(e eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ExoPlayerImplInternal.java */
    /* loaded from: classes.dex */
    public static final class g {
        public final e0.a a;

        /* renamed from: b  reason: collision with root package name */
        public final long f2293b;

        /* renamed from: c  reason: collision with root package name */
        public final long f2294c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f2295d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f2296e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f2297f;

        public g(e0.a aVar, long j, long j2, boolean z, boolean z2, boolean z3) {
            this.a = aVar;
            this.f2293b = j;
            this.f2294c = j2;
            this.f2295d = z;
            this.f2296e = z2;
            this.f2297f = z3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ExoPlayerImplInternal.java */
    /* loaded from: classes.dex */
    public static final class h {
        public final j2 a;

        /* renamed from: b  reason: collision with root package name */
        public final int f2298b;

        /* renamed from: c  reason: collision with root package name */
        public final long f2299c;

        public h(j2 j2Var, int i, long j) {
            this.a = j2Var;
            this.f2298b = i;
            this.f2299c = j;
        }
    }

    public g1(b2[] b2VarArr, m mVar, n nVar, k1 k1Var, com.google.android.exoplayer2.upstream.g gVar, int i, boolean z, @Nullable h1 h1Var, g2 g2Var, j1 j1Var, long j, boolean z2, Looper looper, com.google.android.exoplayer2.util.h hVar, f fVar) {
        this.M3 = fVar;
        this.f2276c = b2VarArr;
        this.f2278f = mVar;
        this.q = nVar;
        this.x = k1Var;
        this.y = gVar;
        this.Z3 = i;
        this.a4 = z;
        this.R3 = g2Var;
        this.P3 = j1Var;
        this.Q3 = j;
        this.k4 = j;
        this.V3 = z2;
        this.L3 = hVar;
        this.H3 = k1Var.d();
        this.I3 = k1Var.c();
        s1 k = s1.k(nVar);
        this.S3 = k;
        this.T3 = new e(k);
        this.f2277d = new d2[b2VarArr.length];
        for (int i2 = 0; i2 < b2VarArr.length; i2++) {
            b2VarArr[i2].h(i2);
            this.f2277d[i2] = b2VarArr[i2].o();
        }
        this.J3 = new b1(this, hVar);
        this.K3 = new ArrayList<>();
        this.p2 = new j2.c();
        this.p3 = new j2.b();
        mVar.b(this, gVar);
        this.i4 = true;
        Handler handler = new Handler(looper);
        this.N3 = new p1(h1Var, handler);
        this.O3 = new r1(this, h1Var, handler);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
        this.p0 = handlerThread;
        handlerThread.start();
        Looper looper2 = handlerThread.getLooper();
        this.p1 = looper2;
        this.z = hVar.b(looper2, this);
    }

    private void A0(long j, long j2) {
        this.z.k(2);
        this.z.j(2, j + j2);
    }

    private long B() {
        return C(this.S3.r);
    }

    private long C(long j) {
        n1 i = this.N3.i();
        if (i == null) {
            return 0L;
        }
        return Math.max(0L, j - i.y(this.g4));
    }

    private void C0(boolean z) throws ExoPlaybackException {
        e0.a aVar = this.N3.o().f2618f.a;
        long F0 = F0(aVar, this.S3.t, true, false);
        if (F0 != this.S3.t) {
            s1 s1Var = this.S3;
            this.S3 = K(aVar, F0, s1Var.f3139d, s1Var.f3140e, z, 5);
        }
    }

    private void D(b0 b0Var) {
        if (this.N3.u(b0Var)) {
            this.N3.y(this.g4);
            V();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ab A[Catch: all -> 0x0147, TryCatch #1 {all -> 0x0147, blocks: (B:22:0x00a1, B:24:0x00ab, B:27:0x00b1, B:29:0x00b7, B:30:0x00ba, B:32:0x00c0, B:34:0x00ca, B:36:0x00d2, B:40:0x00da, B:42:0x00e4, B:44:0x00f4, B:48:0x00fe, B:52:0x0110, B:56:0x0119), top: B:73:0x00a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void D0(com.google.android.exoplayer2.g1.h r20) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            Method dump skipped, instructions count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.g1.D0(com.google.android.exoplayer2.g1$h):void");
    }

    private void E(IOException iOException, int i) {
        ExoPlaybackException createForSource = ExoPlaybackException.createForSource(iOException, i);
        n1 o = this.N3.o();
        if (o != null) {
            createForSource = createForSource.copyWithMediaPeriodId(o.f2618f.a);
        }
        u.d("ExoPlayerImplInternal", "Playback error", createForSource);
        i1(false, false);
        this.S3 = this.S3.f(createForSource);
    }

    private long E0(e0.a aVar, long j, boolean z) throws ExoPlaybackException {
        return F0(aVar, j, this.N3.o() != this.N3.p(), z);
    }

    private void F(boolean z) {
        long j;
        n1 i = this.N3.i();
        e0.a aVar = i == null ? this.S3.f3138c : i.f2618f.a;
        boolean z2 = !this.S3.l.equals(aVar);
        if (z2) {
            this.S3 = this.S3.b(aVar);
        }
        s1 s1Var = this.S3;
        if (i == null) {
            j = s1Var.t;
        } else {
            j = i.i();
        }
        s1Var.r = j;
        this.S3.s = B();
        if ((z2 || z) && i != null && i.f2616d) {
            m1(i.n(), i.o());
        }
    }

    private long F0(e0.a aVar, long j, boolean z, boolean z2) throws ExoPlaybackException {
        j1();
        this.X3 = false;
        if (z2 || this.S3.f3141f == 3) {
            a1(2);
        }
        n1 o = this.N3.o();
        n1 n1Var = o;
        while (n1Var != null && !aVar.equals(n1Var.f2618f.a)) {
            n1Var = n1Var.j();
        }
        if (z || o != n1Var || (n1Var != null && n1Var.z(j) < 0)) {
            for (b2 b2Var : this.f2276c) {
                k(b2Var);
            }
            if (n1Var != null) {
                while (this.N3.o() != n1Var) {
                    this.N3.a();
                }
                this.N3.z(n1Var);
                n1Var.x(0L);
                q();
            }
        }
        if (n1Var != null) {
            this.N3.z(n1Var);
            if (!n1Var.f2616d) {
                n1Var.f2618f = n1Var.f2618f.b(j);
            } else {
                long j2 = n1Var.f2618f.f2628e;
                if (j2 != -9223372036854775807L && j >= j2) {
                    j = Math.max(0L, j2 - 1);
                }
                if (n1Var.f2617e) {
                    long i = n1Var.a.i(j);
                    n1Var.a.u(i - this.H3, this.I3);
                    j = i;
                }
            }
            t0(j);
            V();
        } else {
            this.N3.e();
            t0(j);
        }
        F(false);
        this.z.i(2);
        return j;
    }

    private void G(j2 j2Var, boolean z) throws ExoPlaybackException {
        Throwable th;
        boolean z2;
        g x0 = x0(j2Var, this.S3, this.f4, this.N3, this.Z3, this.a4, this.p2, this.p3);
        e0.a aVar = x0.a;
        long j = x0.f2294c;
        boolean z3 = x0.f2295d;
        long j2 = x0.f2293b;
        boolean z4 = !this.S3.f3138c.equals(aVar) || j2 != this.S3.t;
        int i = 3;
        h hVar = null;
        long j3 = -9223372036854775807L;
        try {
            if (x0.f2296e) {
                if (this.S3.f3141f != 1) {
                    a1(4);
                }
                r0(false, false, false, true);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            if (!z4) {
                z2 = false;
                if (!this.N3.F(j2Var, this.g4, y())) {
                    C0(false);
                }
            } else {
                z2 = false;
                if (!j2Var.q()) {
                    for (n1 o = this.N3.o(); o != null; o = o.j()) {
                        if (o.f2618f.a.equals(aVar)) {
                            o.f2618f = this.N3.q(j2Var, o.f2618f);
                            o.A();
                        }
                    }
                    j2 = E0(aVar, j2, z3);
                }
            }
            s1 s1Var = this.S3;
            l1(j2Var, aVar, s1Var.f3137b, s1Var.f3138c, x0.f2297f ? j2 : -9223372036854775807L);
            if (z4 || j != this.S3.f3139d) {
                s1 s1Var2 = this.S3;
                Object obj = s1Var2.f3138c.a;
                j2 j2Var2 = s1Var2.f3137b;
                boolean z5 = z4 && z && !j2Var2.q() && !j2Var2.h(obj, this.p3).g;
                long j4 = this.S3.f3140e;
                if (j2Var.b(obj) == -1) {
                    i = 4;
                }
                this.S3 = K(aVar, j2, j, j4, z5, i);
            }
            s0();
            w0(j2Var, this.S3.f3137b);
            this.S3 = this.S3.j(j2Var);
            if (!j2Var.q()) {
                this.f4 = null;
            }
            F(z2);
        } catch (Throwable th3) {
            th = th3;
            hVar = null;
            s1 s1Var3 = this.S3;
            j2 j2Var3 = s1Var3.f3137b;
            e0.a aVar2 = s1Var3.f3138c;
            if (x0.f2297f) {
                j3 = j2;
            }
            l1(j2Var, aVar, j2Var3, aVar2, j3);
            if (z4 || j != this.S3.f3139d) {
                s1 s1Var4 = this.S3;
                Object obj2 = s1Var4.f3138c.a;
                j2 j2Var4 = s1Var4.f3137b;
                boolean z6 = z4 && z && !j2Var4.q() && !j2Var4.h(obj2, this.p3).g;
                long j5 = this.S3.f3140e;
                if (j2Var.b(obj2) == -1) {
                    i = 4;
                }
                this.S3 = K(aVar, j2, j, j5, z6, i);
            }
            s0();
            w0(j2Var, this.S3.f3137b);
            this.S3 = this.S3.j(j2Var);
            if (!j2Var.q()) {
                this.f4 = hVar;
            }
            F(false);
            throw th;
        }
    }

    private void G0(x1 x1Var) throws ExoPlaybackException {
        if (x1Var.e() == -9223372036854775807L) {
            H0(x1Var);
        } else if (this.S3.f3137b.q()) {
            this.K3.add(new d(x1Var));
        } else {
            d dVar = new d(x1Var);
            j2 j2Var = this.S3.f3137b;
            if (v0(dVar, j2Var, j2Var, this.Z3, this.a4, this.p2, this.p3)) {
                this.K3.add(dVar);
                Collections.sort(this.K3);
                return;
            }
            x1Var.k(false);
        }
    }

    private void H(b0 b0Var) throws ExoPlaybackException {
        if (this.N3.u(b0Var)) {
            n1 i = this.N3.i();
            i.p(this.J3.c().f3437c, this.S3.f3137b);
            m1(i.n(), i.o());
            if (i == this.N3.o()) {
                t0(i.f2618f.f2625b);
                q();
                s1 s1Var = this.S3;
                e0.a aVar = s1Var.f3138c;
                long j = i.f2618f.f2625b;
                this.S3 = K(aVar, j, s1Var.f3139d, j, false, 5);
            }
            V();
        }
    }

    private void H0(x1 x1Var) throws ExoPlaybackException {
        if (x1Var.c() == this.p1) {
            j(x1Var);
            int i = this.S3.f3141f;
            if (i == 3 || i == 2) {
                this.z.i(2);
                return;
            }
            return;
        }
        this.z.e(15, x1Var).a();
    }

    private void I(t1 t1Var, float f2, boolean z, boolean z2) throws ExoPlaybackException {
        b2[] b2VarArr;
        if (z) {
            if (z2) {
                this.T3.b(1);
            }
            this.S3 = this.S3.g(t1Var);
        }
        p1(t1Var.f3437c);
        for (b2 b2Var : this.f2276c) {
            if (b2Var != null) {
                b2Var.q(f2, t1Var.f3437c);
            }
        }
    }

    private void I0(final x1 x1Var) {
        Looper c2 = x1Var.c();
        if (!c2.getThread().isAlive()) {
            u.h("TAG", "Trying to send message on a dead thread.");
            x1Var.k(false);
            return;
        }
        this.L3.b(c2, null).h(new Runnable() { // from class: com.google.android.exoplayer2.b0
            @Override // java.lang.Runnable
            public final void run() {
                g1.this.U(x1Var);
            }
        });
    }

    private void J(t1 t1Var, boolean z) throws ExoPlaybackException {
        I(t1Var, t1Var.f3437c, true, z);
    }

    private void J0(long j) {
        b2[] b2VarArr;
        for (b2 b2Var : this.f2276c) {
            if (b2Var.getStream() != null) {
                K0(b2Var, j);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckResult
    private s1 K(e0.a aVar, long j, long j2, long j3, boolean z, int i) {
        List list;
        n nVar;
        n nVar2;
        this.i4 = this.i4 || j != this.S3.t || !aVar.equals(this.S3.f3138c);
        s0();
        s1 s1Var = this.S3;
        TrackGroupArray trackGroupArray = s1Var.i;
        n nVar3 = s1Var.j;
        List list2 = s1Var.k;
        if (this.O3.r()) {
            n1 o = this.N3.o();
            if (o == null) {
                trackGroupArray = TrackGroupArray.f3160c;
            } else {
                trackGroupArray = o.n();
            }
            if (o == null) {
                nVar2 = this.q;
            } else {
                nVar2 = o.o();
            }
            list = u(nVar2.f3653c);
            if (o != null) {
                o1 o1Var = o.f2618f;
                if (o1Var.f2626c != j2) {
                    o.f2618f = o1Var.a(j2);
                }
            }
            nVar = nVar2;
        } else if (!aVar.equals(this.S3.f3138c)) {
            trackGroupArray = TrackGroupArray.f3160c;
            nVar = this.q;
            list = ImmutableList.of();
        } else {
            list = list2;
            nVar = nVar3;
        }
        if (z) {
            this.T3.e(i);
        }
        return this.S3.c(aVar, j, j2, j3, B(), trackGroupArray, nVar, list);
    }

    private void K0(b2 b2Var, long j) {
        b2Var.j();
        if (b2Var instanceof l) {
            ((l) b2Var).V(j);
        }
    }

    private boolean L(b2 b2Var, n1 n1Var) {
        n1 j = n1Var.j();
        return n1Var.f2618f.f2629f && j.f2616d && ((b2Var instanceof l) || b2Var.u() >= j.m());
    }

    private void L0(boolean z, @Nullable AtomicBoolean atomicBoolean) {
        b2[] b2VarArr;
        if (this.b4 != z) {
            this.b4 = z;
            if (!z) {
                for (b2 b2Var : this.f2276c) {
                    if (!O(b2Var)) {
                        b2Var.reset();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    private boolean M() {
        n1 p = this.N3.p();
        if (!p.f2616d) {
            return false;
        }
        int i = 0;
        while (true) {
            b2[] b2VarArr = this.f2276c;
            if (i >= b2VarArr.length) {
                return true;
            }
            b2 b2Var = b2VarArr[i];
            n0 n0Var = p.f2615c[i];
            if (b2Var.getStream() != n0Var || (n0Var != null && !b2Var.i() && !L(b2Var, p))) {
                break;
            }
            i++;
        }
        return false;
    }

    private void M0(b bVar) throws ExoPlaybackException {
        this.T3.b(1);
        if (bVar.f2280c != -1) {
            this.f4 = new h(new y1(bVar.a, bVar.f2279b), bVar.f2280c, bVar.f2281d);
        }
        G(this.O3.C(bVar.a, bVar.f2279b), false);
    }

    private boolean N() {
        n1 i = this.N3.i();
        return (i == null || i.k() == Long.MIN_VALUE) ? false : true;
    }

    private static boolean O(b2 b2Var) {
        return b2Var.getState() != 0;
    }

    private void O0(boolean z) {
        if (z != this.d4) {
            this.d4 = z;
            s1 s1Var = this.S3;
            int i = s1Var.f3141f;
            if (z || i == 4 || i == 1) {
                this.S3 = s1Var.d(z);
            } else {
                this.z.i(2);
            }
        }
    }

    private boolean P() {
        n1 o = this.N3.o();
        long j = o.f2618f.f2628e;
        return o.f2616d && (j == -9223372036854775807L || this.S3.t < j || !d1());
    }

    private void P0(boolean z) throws ExoPlaybackException {
        this.V3 = z;
        s0();
        if (this.W3 && this.N3.p() != this.N3.o()) {
            C0(true);
            F(false);
        }
    }

    private static boolean Q(s1 s1Var, j2.b bVar) {
        e0.a aVar = s1Var.f3138c;
        j2 j2Var = s1Var.f3137b;
        return j2Var.q() || j2Var.h(aVar.a, bVar).g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R */
    public /* synthetic */ Boolean S() {
        return Boolean.valueOf(this.U3);
    }

    private void R0(boolean z, int i, boolean z2, int i2) throws ExoPlaybackException {
        this.T3.b(z2 ? 1 : 0);
        this.T3.c(i2);
        this.S3 = this.S3.e(z, i);
        this.X3 = false;
        g0(z);
        if (!d1()) {
            j1();
            o1();
            return;
        }
        int i3 = this.S3.f3141f;
        if (i3 == 3) {
            g1();
            this.z.i(2);
        } else if (i3 == 2) {
            this.z.i(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T */
    public /* synthetic */ void U(x1 x1Var) {
        try {
            j(x1Var);
        } catch (ExoPlaybackException e2) {
            u.d("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e2);
            throw new RuntimeException(e2);
        }
    }

    private void T0(t1 t1Var) throws ExoPlaybackException {
        this.J3.e(t1Var);
        J(this.J3.c(), true);
    }

    private void V() {
        boolean c1 = c1();
        this.Y3 = c1;
        if (c1) {
            this.N3.i().d(this.g4);
        }
        k1();
    }

    private void V0(int i) throws ExoPlaybackException {
        this.Z3 = i;
        if (!this.N3.G(this.S3.f3137b, i)) {
            C0(true);
        }
        F(false);
    }

    private void W() {
        this.T3.d(this.S3);
        if (this.T3.a) {
            this.M3.a(this.T3);
            this.T3 = new e(this.S3);
        }
    }

    private void W0(g2 g2Var) {
        this.R3 = g2Var;
    }

    private boolean X(long j, long j2) {
        if (this.d4 && this.c4) {
            return false;
        }
        A0(j, j2);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0090 A[LOOP:1: B:26:0x0074->B:36:0x0090, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0073 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00dc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00d3 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0044 -> B:13:0x0045). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0073 -> B:26:0x0074). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void Y(long r8, long r10) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.g1.Y(long, long):void");
    }

    private void Y0(boolean z) throws ExoPlaybackException {
        this.a4 = z;
        if (!this.N3.H(this.S3.f3137b, z)) {
            C0(true);
        }
        F(false);
    }

    private void Z() throws ExoPlaybackException {
        o1 n;
        this.N3.y(this.g4);
        if (this.N3.D() && (n = this.N3.n(this.g4, this.S3)) != null) {
            n1 f2 = this.N3.f(this.f2277d, this.f2278f, this.x.getAllocator(), this.O3, n, this.q);
            f2.a.l(this, n.f2625b);
            if (this.N3.o() == f2) {
                t0(f2.m());
            }
            F(false);
        }
        if (this.Y3) {
            this.Y3 = N();
            k1();
            return;
        }
        V();
    }

    private void Z0(p0 p0Var) throws ExoPlaybackException {
        this.T3.b(1);
        G(this.O3.D(p0Var), false);
    }

    private void a0() throws ExoPlaybackException {
        boolean z = false;
        while (b1()) {
            if (z) {
                W();
            }
            n1 o = this.N3.o();
            n1 a2 = this.N3.a();
            o1 o1Var = a2.f2618f;
            e0.a aVar = o1Var.a;
            long j = o1Var.f2625b;
            s1 K = K(aVar, j, o1Var.f2626c, j, true, 0);
            this.S3 = K;
            j2 j2Var = K.f3137b;
            l1(j2Var, a2.f2618f.a, j2Var, o.f2618f.a, -9223372036854775807L);
            s0();
            o1();
            z = true;
        }
    }

    private void a1(int i) {
        s1 s1Var = this.S3;
        if (s1Var.f3141f != i) {
            this.S3 = s1Var.h(i);
        }
    }

    private void b0() {
        n1 p = this.N3.p();
        if (p != null) {
            int i = 0;
            if (p.j() == null || this.W3) {
                if (p.f2618f.i || this.W3) {
                    while (true) {
                        b2[] b2VarArr = this.f2276c;
                        if (i < b2VarArr.length) {
                            b2 b2Var = b2VarArr[i];
                            n0 n0Var = p.f2615c[i];
                            if (n0Var != null && b2Var.getStream() == n0Var && b2Var.i()) {
                                long j = p.f2618f.f2628e;
                                K0(b2Var, (j == -9223372036854775807L || j == Long.MIN_VALUE) ? -9223372036854775807L : p.l() + p.f2618f.f2628e);
                            }
                            i++;
                        } else {
                            return;
                        }
                    }
                }
            } else if (M()) {
                if (p.j().f2616d || this.g4 >= p.j().m()) {
                    n o = p.o();
                    n1 b2 = this.N3.b();
                    n o2 = b2.o();
                    if (!b2.f2616d || b2.a.k() == -9223372036854775807L) {
                        for (int i2 = 0; i2 < this.f2276c.length; i2++) {
                            boolean c2 = o.c(i2);
                            boolean c3 = o2.c(i2);
                            if (c2 && !this.f2276c[i2].m()) {
                                boolean z = this.f2277d[i2].f() == 7;
                                e2 e2Var = o.f3652b[i2];
                                e2 e2Var2 = o2.f3652b[i2];
                                if (!c3 || !e2Var2.equals(e2Var) || z) {
                                    K0(this.f2276c[i2], b2.m());
                                }
                            }
                        }
                        return;
                    }
                    J0(b2.m());
                }
            }
        }
    }

    private boolean b1() {
        n1 o;
        n1 j;
        return d1() && !this.W3 && (o = this.N3.o()) != null && (j = o.j()) != null && this.g4 >= j.m() && j.g;
    }

    private void c0() throws ExoPlaybackException {
        n1 p = this.N3.p();
        if (p != null && this.N3.o() != p && !p.g && p0()) {
            q();
        }
    }

    private boolean c1() {
        long j;
        if (!N()) {
            return false;
        }
        n1 i = this.N3.i();
        long C = C(i.k());
        if (i == this.N3.o()) {
            j = i.y(this.g4);
        } else {
            j = i.y(this.g4) - i.f2618f.f2625b;
        }
        return this.x.i(j, C, this.J3.c().f3437c);
    }

    private void d0() throws ExoPlaybackException {
        G(this.O3.h(), true);
    }

    private boolean d1() {
        s1 s1Var = this.S3;
        return s1Var.m && s1Var.n == 0;
    }

    private void e0(c cVar) throws ExoPlaybackException {
        this.T3.b(1);
        G(this.O3.v(cVar.a, cVar.f2282b, cVar.f2283c, cVar.f2284d), false);
    }

    private boolean e1(boolean z) {
        if (this.e4 == 0) {
            return P();
        }
        if (!z) {
            return false;
        }
        s1 s1Var = this.S3;
        if (!s1Var.h) {
            return true;
        }
        long c2 = f1(s1Var.f3137b, this.N3.o().f2618f.a) ? this.P3.c() : -9223372036854775807L;
        n1 i = this.N3.i();
        return (i.q() && i.f2618f.i) || (i.f2618f.a.b() && !i.f2616d) || this.x.f(B(), this.J3.c().f3437c, this.X3, c2);
    }

    private void f0() {
        com.google.android.exoplayer2.trackselection.g[] gVarArr;
        for (n1 o = this.N3.o(); o != null; o = o.j()) {
            for (com.google.android.exoplayer2.trackselection.g gVar : o.o().f3653c) {
                if (gVar != null) {
                    gVar.k();
                }
            }
        }
    }

    private boolean f1(j2 j2Var, e0.a aVar) {
        if (aVar.b() || j2Var.q()) {
            return false;
        }
        j2Var.n(j2Var.h(aVar.a, this.p3).f2330d, this.p2);
        if (!this.p2.f()) {
            return false;
        }
        j2.c cVar = this.p2;
        return cVar.m && cVar.j != -9223372036854775807L;
    }

    private void g0(boolean z) {
        com.google.android.exoplayer2.trackselection.g[] gVarArr;
        for (n1 o = this.N3.o(); o != null; o = o.j()) {
            for (com.google.android.exoplayer2.trackselection.g gVar : o.o().f3653c) {
                if (gVar != null) {
                    gVar.n(z);
                }
            }
        }
    }

    private void g1() throws ExoPlaybackException {
        b2[] b2VarArr;
        this.X3 = false;
        this.J3.g();
        for (b2 b2Var : this.f2276c) {
            if (O(b2Var)) {
                b2Var.start();
            }
        }
    }

    private void h(b bVar, int i) throws ExoPlaybackException {
        this.T3.b(1);
        r1 r1Var = this.O3;
        if (i == -1) {
            i = r1Var.p();
        }
        G(r1Var.e(i, bVar.a, bVar.f2279b), false);
    }

    private void h0() {
        com.google.android.exoplayer2.trackselection.g[] gVarArr;
        for (n1 o = this.N3.o(); o != null; o = o.j()) {
            for (com.google.android.exoplayer2.trackselection.g gVar : o.o().f3653c) {
                if (gVar != null) {
                    gVar.u();
                }
            }
        }
    }

    private void i() throws ExoPlaybackException {
        C0(true);
    }

    private void i1(boolean z, boolean z2) {
        r0(z || !this.b4, false, true, false);
        this.T3.b(z2 ? 1 : 0);
        this.x.g();
        a1(1);
    }

    private void j(x1 x1Var) throws ExoPlaybackException {
        if (!x1Var.j()) {
            try {
                x1Var.f().k(x1Var.h(), x1Var.d());
            } finally {
                x1Var.k(true);
            }
        }
    }

    private void j1() throws ExoPlaybackException {
        b2[] b2VarArr;
        this.J3.h();
        for (b2 b2Var : this.f2276c) {
            if (O(b2Var)) {
                s(b2Var);
            }
        }
    }

    private void k(b2 b2Var) throws ExoPlaybackException {
        if (O(b2Var)) {
            this.J3.a(b2Var);
            s(b2Var);
            b2Var.b();
            this.e4--;
        }
    }

    private void k0() {
        this.T3.b(1);
        r0(false, false, false, true);
        this.x.b();
        a1(this.S3.f3137b.q() ? 4 : 2);
        this.O3.w(this.y.c());
        this.z.i(2);
    }

    private void k1() {
        n1 i = this.N3.i();
        boolean z = this.Y3 || (i != null && i.a.c());
        s1 s1Var = this.S3;
        if (z != s1Var.h) {
            this.S3 = s1Var.a(z);
        }
    }

    private void l() throws ExoPlaybackException, IOException {
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        long a2 = this.L3.a();
        n1();
        int i2 = this.S3.f3141f;
        if (i2 == 1 || i2 == 4) {
            this.z.k(2);
            return;
        }
        n1 o = this.N3.o();
        if (o == null) {
            A0(a2, 10L);
            return;
        }
        m0.a("doSomeWork");
        o1();
        if (o.f2616d) {
            long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            o.a.u(this.S3.t - this.H3, this.I3);
            int i3 = 0;
            z2 = true;
            z = true;
            while (true) {
                b2[] b2VarArr = this.f2276c;
                if (i3 >= b2VarArr.length) {
                    break;
                }
                b2 b2Var = b2VarArr[i3];
                if (O(b2Var)) {
                    b2Var.t(this.g4, elapsedRealtime);
                    z2 = z2 && b2Var.d();
                    boolean z4 = o.f2615c[i3] != b2Var.getStream();
                    boolean z5 = z4 || (!z4 && b2Var.i()) || b2Var.g() || b2Var.d();
                    z = z && z5;
                    if (!z5) {
                        b2Var.l();
                    }
                }
                i3++;
            }
        } else {
            o.a.q();
            z2 = true;
            z = true;
        }
        long j = o.f2618f.f2628e;
        boolean z6 = z2 && o.f2616d && (j == -9223372036854775807L || j <= this.S3.t);
        if (z6 && this.W3) {
            this.W3 = false;
            R0(false, this.S3.n, false, 5);
        }
        if (z6 && o.f2618f.i) {
            a1(4);
            j1();
        } else if (this.S3.f3141f == 2 && e1(z)) {
            a1(3);
            this.j4 = null;
            if (d1()) {
                g1();
            }
        } else if (this.S3.f3141f == 3 && (this.e4 != 0 ? !z : !P())) {
            this.X3 = d1();
            a1(2);
            if (this.X3) {
                h0();
                this.P3.d();
            }
            j1();
        }
        if (this.S3.f3141f == 2) {
            int i4 = 0;
            while (true) {
                b2[] b2VarArr2 = this.f2276c;
                if (i4 >= b2VarArr2.length) {
                    break;
                }
                if (O(b2VarArr2[i4]) && this.f2276c[i4].getStream() == o.f2615c[i4]) {
                    this.f2276c[i4].l();
                }
                i4++;
            }
            s1 s1Var = this.S3;
            if (!s1Var.h && s1Var.s < 500000 && N()) {
                throw new IllegalStateException("Playback stuck buffering and not loading");
            }
        }
        boolean z7 = this.d4;
        s1 s1Var2 = this.S3;
        if (z7 != s1Var2.p) {
            this.S3 = s1Var2.d(z7);
        }
        if ((!d1() || this.S3.f3141f != 3) && (i = this.S3.f3141f) != 2) {
            if (this.e4 == 0 || i == 4) {
                this.z.k(2);
            } else {
                A0(a2, 1000L);
            }
            z3 = false;
        } else {
            z3 = !X(a2, 10L);
        }
        s1 s1Var3 = this.S3;
        if (s1Var3.q != z3) {
            this.S3 = s1Var3.i(z3);
        }
        this.c4 = false;
        m0.c();
    }

    private void l1(j2 j2Var, e0.a aVar, j2 j2Var2, e0.a aVar2, long j) {
        if (j2Var.q() || !f1(j2Var, aVar)) {
            float f2 = this.J3.c().f3437c;
            t1 t1Var = this.S3.o;
            if (f2 != t1Var.f3437c) {
                this.J3.e(t1Var);
                return;
            }
            return;
        }
        j2Var.n(j2Var.h(aVar.a, this.p3).f2330d, this.p2);
        this.P3.a((l1.f) o0.i(this.p2.o));
        if (j != -9223372036854775807L) {
            this.P3.e(x(j2Var, aVar.a, j));
            return;
        }
        Object obj = this.p2.f2336e;
        Object obj2 = null;
        if (!j2Var2.q()) {
            obj2 = j2Var2.n(j2Var2.h(aVar2.a, this.p3).f2330d, this.p2).f2336e;
        }
        if (!o0.b(obj2, obj)) {
            this.P3.e(-9223372036854775807L);
        }
    }

    private void m(int i, boolean z) throws ExoPlaybackException {
        b2 b2Var = this.f2276c[i];
        if (!O(b2Var)) {
            n1 p = this.N3.p();
            boolean z2 = p == this.N3.o();
            n o = p.o();
            e2 e2Var = o.f3652b[i];
            Format[] w = w(o.f3653c[i]);
            boolean z3 = d1() && this.S3.f3141f == 3;
            boolean z4 = !z && z3;
            this.e4++;
            b2Var.r(e2Var, w, p.f2615c[i], this.g4, z4, z2, p.m(), p.l());
            b2Var.k(103, new a());
            this.J3.b(b2Var);
            if (z3) {
                b2Var.start();
            }
        }
    }

    private void m0() {
        r0(true, false, true, false);
        this.x.h();
        a1(1);
        this.p0.quit();
        synchronized (this) {
            this.U3 = true;
            notifyAll();
        }
    }

    private void m1(TrackGroupArray trackGroupArray, n nVar) {
        this.x.e(this.f2276c, trackGroupArray, nVar.f3653c);
    }

    private void n0(int i, int i2, p0 p0Var) throws ExoPlaybackException {
        this.T3.b(1);
        G(this.O3.A(i, i2, p0Var), false);
    }

    private void n1() throws ExoPlaybackException, IOException {
        if (!this.S3.f3137b.q() && this.O3.r()) {
            Z();
            b0();
            c0();
            a0();
        }
    }

    private void o1() throws ExoPlaybackException {
        n1 o = this.N3.o();
        if (o != null) {
            long k = o.f2616d ? o.a.k() : -9223372036854775807L;
            if (k != -9223372036854775807L) {
                t0(k);
                if (k != this.S3.t) {
                    s1 s1Var = this.S3;
                    this.S3 = K(s1Var.f3138c, k, s1Var.f3139d, k, true, 5);
                }
            } else {
                long i = this.J3.i(o != this.N3.p());
                this.g4 = i;
                long y = o.y(i);
                Y(this.S3.t, y);
                this.S3.t = y;
            }
            this.S3.r = this.N3.i().i();
            this.S3.s = B();
            s1 s1Var2 = this.S3;
            if (s1Var2.m && s1Var2.f3141f == 3 && f1(s1Var2.f3137b, s1Var2.f3138c) && this.S3.o.f3437c == 1.0f) {
                float b2 = this.P3.b(v(), B());
                if (this.J3.c().f3437c != b2) {
                    this.J3.e(this.S3.o.b(b2));
                    I(this.S3.o, this.J3.c().f3437c, false, false);
                }
            }
        }
    }

    private boolean p0() throws ExoPlaybackException {
        n1 p = this.N3.p();
        n o = p.o();
        int i = 0;
        boolean z = false;
        while (true) {
            b2[] b2VarArr = this.f2276c;
            if (i >= b2VarArr.length) {
                return !z;
            }
            b2 b2Var = b2VarArr[i];
            if (O(b2Var)) {
                boolean z2 = b2Var.getStream() != p.f2615c[i];
                if (!o.c(i) || z2) {
                    if (!b2Var.m()) {
                        b2Var.n(w(o.f3653c[i]), p.f2615c[i], p.m(), p.l());
                    } else if (b2Var.d()) {
                        k(b2Var);
                    } else {
                        z = true;
                    }
                }
            }
            i++;
        }
    }

    private void p1(float f2) {
        com.google.android.exoplayer2.trackselection.g[] gVarArr;
        for (n1 o = this.N3.o(); o != null; o = o.j()) {
            for (com.google.android.exoplayer2.trackselection.g gVar : o.o().f3653c) {
                if (gVar != null) {
                    gVar.i(f2);
                }
            }
        }
    }

    private void q() throws ExoPlaybackException {
        r(new boolean[this.f2276c.length]);
    }

    private void q0() throws ExoPlaybackException {
        float f2 = this.J3.c().f3437c;
        n1 p = this.N3.p();
        boolean z = true;
        for (n1 o = this.N3.o(); o != null && o.f2616d; o = o.j()) {
            n v = o.v(f2, this.S3.f3137b);
            if (!v.a(o.o())) {
                if (z) {
                    n1 o2 = this.N3.o();
                    boolean z2 = this.N3.z(o2);
                    boolean[] zArr = new boolean[this.f2276c.length];
                    long b2 = o2.b(v, this.S3.t, z2, zArr);
                    s1 s1Var = this.S3;
                    boolean z3 = (s1Var.f3141f == 4 || b2 == s1Var.t) ? false : true;
                    s1 s1Var2 = this.S3;
                    this.S3 = K(s1Var2.f3138c, b2, s1Var2.f3139d, s1Var2.f3140e, z3, 5);
                    if (z3) {
                        t0(b2);
                    }
                    boolean[] zArr2 = new boolean[this.f2276c.length];
                    int i = 0;
                    while (true) {
                        b2[] b2VarArr = this.f2276c;
                        if (i >= b2VarArr.length) {
                            break;
                        }
                        b2 b2Var = b2VarArr[i];
                        zArr2[i] = O(b2Var);
                        n0 n0Var = o2.f2615c[i];
                        if (zArr2[i]) {
                            if (n0Var != b2Var.getStream()) {
                                k(b2Var);
                            } else if (zArr[i]) {
                                b2Var.v(this.g4);
                            }
                        }
                        i++;
                    }
                    r(zArr2);
                } else {
                    this.N3.z(o);
                    if (o.f2616d) {
                        o.a(v, Math.max(o.f2618f.f2625b, o.y(this.g4)), false);
                    }
                }
                F(true);
                if (this.S3.f3141f != 4) {
                    V();
                    o1();
                    this.z.i(2);
                    return;
                }
                return;
            }
            if (o == p) {
                z = false;
            }
        }
    }

    private synchronized void q1(t<Boolean> tVar, long j) {
        long elapsedRealtime = this.L3.elapsedRealtime() + j;
        boolean z = false;
        while (!tVar.get().booleanValue() && j > 0) {
            try {
                this.L3.c();
                wait(j);
            } catch (InterruptedException unused) {
                z = true;
            }
            j = elapsedRealtime - this.L3.elapsedRealtime();
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private void r(boolean[] zArr) throws ExoPlaybackException {
        n1 p = this.N3.p();
        n o = p.o();
        for (int i = 0; i < this.f2276c.length; i++) {
            if (!o.c(i)) {
                this.f2276c[i].reset();
            }
        }
        for (int i2 = 0; i2 < this.f2276c.length; i2++) {
            if (o.c(i2)) {
                m(i2, zArr[i2]);
            }
        }
        p.g = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void r0(boolean r30, boolean r31, boolean r32, boolean r33) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.g1.r0(boolean, boolean, boolean, boolean):void");
    }

    private void s(b2 b2Var) throws ExoPlaybackException {
        if (b2Var.getState() == 2) {
            b2Var.stop();
        }
    }

    private void s0() {
        n1 o = this.N3.o();
        this.W3 = o != null && o.f2618f.h && this.V3;
    }

    private void t0(long j) throws ExoPlaybackException {
        b2[] b2VarArr;
        n1 o = this.N3.o();
        if (o != null) {
            j = o.z(j);
        }
        this.g4 = j;
        this.J3.d(j);
        for (b2 b2Var : this.f2276c) {
            if (O(b2Var)) {
                b2Var.v(this.g4);
            }
        }
        f0();
    }

    private ImmutableList<Metadata> u(com.google.android.exoplayer2.trackselection.g[] gVarArr) {
        ImmutableList.a aVar = new ImmutableList.a();
        boolean z = false;
        for (com.google.android.exoplayer2.trackselection.g gVar : gVarArr) {
            if (gVar != null) {
                Metadata metadata = gVar.a(0).p2;
                if (metadata == null) {
                    aVar.a(new Metadata(new Metadata.Entry[0]));
                } else {
                    aVar.a(metadata);
                    z = true;
                }
            }
        }
        return z ? aVar.j() : ImmutableList.of();
    }

    private static void u0(j2 j2Var, d dVar, j2.c cVar, j2.b bVar) {
        int i = j2Var.n(j2Var.h(dVar.q, bVar).f2330d, cVar).t;
        Object obj = j2Var.g(i, bVar, true).f2329c;
        long j = bVar.f2331e;
        dVar.b(i, j != -9223372036854775807L ? j - 1 : Long.MAX_VALUE, obj);
    }

    private long v() {
        s1 s1Var = this.S3;
        return x(s1Var.f3137b, s1Var.f3138c.a, s1Var.t);
    }

    private static boolean v0(d dVar, j2 j2Var, j2 j2Var2, int i, boolean z, j2.c cVar, j2.b bVar) {
        Object obj = dVar.q;
        if (obj == null) {
            Pair<Object, Long> y0 = y0(j2Var, new h(dVar.f2285c.g(), dVar.f2285c.i(), dVar.f2285c.e() == Long.MIN_VALUE ? -9223372036854775807L : w0.d(dVar.f2285c.e())), false, i, z, cVar, bVar);
            if (y0 == null) {
                return false;
            }
            dVar.b(j2Var.b(y0.first), ((Long) y0.second).longValue(), y0.first);
            if (dVar.f2285c.e() == Long.MIN_VALUE) {
                u0(j2Var, dVar, cVar, bVar);
            }
            return true;
        }
        int b2 = j2Var.b(obj);
        if (b2 == -1) {
            return false;
        }
        if (dVar.f2285c.e() == Long.MIN_VALUE) {
            u0(j2Var, dVar, cVar, bVar);
            return true;
        }
        dVar.f2286d = b2;
        j2Var2.h(dVar.q, bVar);
        if (bVar.g && j2Var2.n(bVar.f2330d, cVar).s == j2Var2.b(dVar.q)) {
            Pair<Object, Long> j = j2Var.j(cVar, bVar, j2Var.h(dVar.q, bVar).f2330d, dVar.f2287f + bVar.m());
            dVar.b(j2Var.b(j.first), ((Long) j.second).longValue(), j.first);
        }
        return true;
    }

    private static Format[] w(com.google.android.exoplayer2.trackselection.g gVar) {
        int length = gVar != null ? gVar.length() : 0;
        Format[] formatArr = new Format[length];
        for (int i = 0; i < length; i++) {
            formatArr[i] = gVar.a(i);
        }
        return formatArr;
    }

    private void w0(j2 j2Var, j2 j2Var2) {
        if (!j2Var.q() || !j2Var2.q()) {
            for (int size = this.K3.size() - 1; size >= 0; size--) {
                if (!v0(this.K3.get(size), j2Var, j2Var2, this.Z3, this.a4, this.p2, this.p3)) {
                    this.K3.get(size).f2285c.k(false);
                    this.K3.remove(size);
                }
            }
            Collections.sort(this.K3);
        }
    }

    private long x(j2 j2Var, Object obj, long j) {
        j2Var.n(j2Var.h(obj, this.p3).f2330d, this.p2);
        j2.c cVar = this.p2;
        if (cVar.j != -9223372036854775807L && cVar.f()) {
            j2.c cVar2 = this.p2;
            if (cVar2.m) {
                return w0.d(cVar2.a() - this.p2.j) - (j + this.p3.m());
            }
        }
        return -9223372036854775807L;
    }

    private static g x0(j2 j2Var, s1 s1Var, @Nullable h hVar, p1 p1Var, int i, boolean z, j2.c cVar, j2.b bVar) {
        long j;
        boolean z2;
        boolean z3;
        boolean z4;
        int i2;
        e0.a aVar;
        int i3;
        long j2;
        long j3;
        p1 p1Var2;
        int i4;
        if (j2Var.q()) {
            return new g(s1.l(), 0L, -9223372036854775807L, false, true, false);
        }
        e0.a aVar2 = s1Var.f3138c;
        Object obj = aVar2.a;
        boolean Q = Q(s1Var, bVar);
        if (s1Var.f3138c.b() || Q) {
            j = s1Var.f3139d;
        } else {
            j = s1Var.t;
        }
        boolean z5 = false;
        if (hVar != null) {
            i2 = -1;
            Pair<Object, Long> y0 = y0(j2Var, hVar, true, i, z, cVar, bVar);
            if (y0 == null) {
                i3 = j2Var.a(z);
                j2 = j;
                z2 = false;
                z4 = false;
                z3 = true;
            } else {
                if (hVar.f2299c == -9223372036854775807L) {
                    i3 = j2Var.h(y0.first, bVar).f2330d;
                    j2 = j;
                    z2 = false;
                } else {
                    obj = y0.first;
                    j2 = ((Long) y0.second).longValue();
                    z2 = true;
                    i3 = -1;
                }
                z4 = s1Var.f3141f == 4;
                z3 = false;
            }
            aVar = aVar2;
        } else {
            i2 = -1;
            if (s1Var.f3137b.q()) {
                i3 = j2Var.a(z);
            } else if (j2Var.b(obj) == -1) {
                Object z0 = z0(cVar, bVar, i, z, obj, s1Var.f3137b, j2Var);
                if (z0 == null) {
                    i3 = j2Var.a(z);
                    z3 = true;
                } else {
                    i3 = j2Var.h(z0, bVar).f2330d;
                    z3 = false;
                }
                j2 = j;
                aVar = aVar2;
                z4 = false;
                z2 = false;
            } else if (j == -9223372036854775807L) {
                i3 = j2Var.h(obj, bVar).f2330d;
            } else if (Q) {
                aVar = aVar2;
                s1Var.f3137b.h(aVar.a, bVar);
                if (s1Var.f3137b.n(bVar.f2330d, cVar).s == s1Var.f3137b.b(aVar.a)) {
                    Pair<Object, Long> j4 = j2Var.j(cVar, bVar, j2Var.h(obj, bVar).f2330d, j + bVar.m());
                    Object obj2 = j4.first;
                    j2 = ((Long) j4.second).longValue();
                    obj = obj2;
                } else {
                    j2 = j;
                }
                i3 = -1;
                z4 = false;
                z3 = false;
                z2 = true;
            } else {
                aVar = aVar2;
                j2 = j;
                i3 = -1;
                z4 = false;
                z3 = false;
                z2 = false;
            }
            j2 = j;
            aVar = aVar2;
            z4 = false;
            z3 = false;
            z2 = false;
        }
        if (i3 != i2) {
            Pair<Object, Long> j5 = j2Var.j(cVar, bVar, i3, -9223372036854775807L);
            obj = j5.first;
            j2 = ((Long) j5.second).longValue();
            p1Var2 = p1Var;
            j3 = -9223372036854775807L;
        } else {
            p1Var2 = p1Var;
            j3 = j2;
        }
        e0.a A = p1Var2.A(j2Var, obj, j2);
        boolean z6 = A.f3206e == i2 || ((i4 = aVar.f3206e) != i2 && A.f3203b >= i4);
        boolean equals = aVar.a.equals(obj);
        boolean z7 = equals && !aVar.b() && !A.b() && z6;
        j2Var.h(obj, bVar);
        if (equals && !Q && j == j3 && ((A.b() && bVar.p(A.f3203b)) || (aVar.b() && bVar.p(aVar.f3203b)))) {
            z5 = true;
        }
        if (z7 || z5) {
            A = aVar;
        }
        if (A.b()) {
            if (A.equals(aVar)) {
                j2 = s1Var.t;
            } else {
                j2Var.h(A.a, bVar);
                j2 = A.f3204c == bVar.j(A.f3203b) ? bVar.g() : 0L;
            }
        }
        return new g(A, j2, j3, z4, z3, z2);
    }

    private long y() {
        n1 p = this.N3.p();
        if (p == null) {
            return 0L;
        }
        long l = p.l();
        if (!p.f2616d) {
            return l;
        }
        int i = 0;
        while (true) {
            b2[] b2VarArr = this.f2276c;
            if (i >= b2VarArr.length) {
                return l;
            }
            if (O(b2VarArr[i]) && this.f2276c[i].getStream() == p.f2615c[i]) {
                long u = this.f2276c[i].u();
                if (u == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                l = Math.max(u, l);
            }
            i++;
        }
    }

    @Nullable
    private static Pair<Object, Long> y0(j2 j2Var, h hVar, boolean z, int i, boolean z2, j2.c cVar, j2.b bVar) {
        Pair<Object, Long> j;
        Object z0;
        j2 j2Var2 = hVar.a;
        if (j2Var.q()) {
            return null;
        }
        j2 j2Var3 = j2Var2.q() ? j2Var : j2Var2;
        try {
            j = j2Var3.j(cVar, bVar, hVar.f2298b, hVar.f2299c);
        } catch (IndexOutOfBoundsException unused) {
        }
        if (j2Var.equals(j2Var3)) {
            return j;
        }
        if (j2Var.b(j.first) != -1) {
            return (!j2Var3.h(j.first, bVar).g || j2Var3.n(bVar.f2330d, cVar).s != j2Var3.b(j.first)) ? j : j2Var.j(cVar, bVar, j2Var.h(j.first, bVar).f2330d, hVar.f2299c);
        }
        if (z && (z0 = z0(cVar, bVar, i, z2, j.first, j2Var3, j2Var)) != null) {
            return j2Var.j(cVar, bVar, j2Var.h(z0, bVar).f2330d, -9223372036854775807L);
        }
        return null;
    }

    private Pair<e0.a, Long> z(j2 j2Var) {
        long j = 0;
        if (j2Var.q()) {
            return Pair.create(s1.l(), 0L);
        }
        Pair<Object, Long> j2 = j2Var.j(this.p2, this.p3, j2Var.a(this.a4), -9223372036854775807L);
        e0.a A = this.N3.A(j2Var, j2.first, 0L);
        j = ((Long) j2.second).longValue();
        if (A.b()) {
            j2Var.h(A.a, this.p3);
            if (A.f3204c == this.p3.j(A.f3203b)) {
                j = this.p3.g();
            }
        }
        return Pair.create(A, Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Object z0(j2.c cVar, j2.b bVar, int i, boolean z, Object obj, j2 j2Var, j2 j2Var2) {
        int b2 = j2Var.b(obj);
        int i2 = j2Var.i();
        int i3 = b2;
        int i4 = -1;
        for (int i5 = 0; i5 < i2 && i4 == -1; i5++) {
            i3 = j2Var.d(i3, bVar, cVar, i, z);
            if (i3 == -1) {
                break;
            }
            i4 = j2Var2.b(j2Var.m(i3));
        }
        if (i4 == -1) {
            return null;
        }
        return j2Var2.m(i4);
    }

    public Looper A() {
        return this.p1;
    }

    public void B0(j2 j2Var, int i, long j) {
        this.z.e(3, new h(j2Var, i, j)).a();
    }

    public void N0(List<r1.c> list, int i, long j, p0 p0Var) {
        this.z.e(17, new b(list, p0Var, i, j, null)).a();
    }

    public void Q0(boolean z, int i) {
        this.z.g(1, z ? 1 : 0, i).a();
    }

    public void S0(t1 t1Var) {
        this.z.e(4, t1Var).a();
    }

    public void U0(int i) {
        this.z.g(11, i, 0).a();
    }

    public void X0(boolean z) {
        this.z.g(12, z ? 1 : 0, 0).a();
    }

    @Override // com.google.android.exoplayer2.trackselection.m.a
    public void a() {
        this.z.i(10);
    }

    @Override // com.google.android.exoplayer2.r1.d
    public void c() {
        this.z.i(22);
    }

    @Override // com.google.android.exoplayer2.b1.a
    public void d(t1 t1Var) {
        this.z.e(16, t1Var).a();
    }

    @Override // com.google.android.exoplayer2.x1.a
    public synchronized void e(x1 x1Var) {
        if (!this.U3 && this.p0.isAlive()) {
            this.z.e(14, x1Var).a();
            return;
        }
        u.h("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        x1Var.k(false);
    }

    public void h1() {
        this.z.a(6).a();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        n1 p;
        int i = 1000;
        try {
            switch (message.what) {
                case 0:
                    k0();
                    break;
                case 1:
                    R0(message.arg1 != 0, message.arg2, true, 1);
                    break;
                case 2:
                    l();
                    break;
                case 3:
                    D0((h) message.obj);
                    break;
                case 4:
                    T0((t1) message.obj);
                    break;
                case 5:
                    W0((g2) message.obj);
                    break;
                case 6:
                    i1(false, true);
                    break;
                case 7:
                    m0();
                    return true;
                case 8:
                    H((b0) message.obj);
                    break;
                case 9:
                    D((b0) message.obj);
                    break;
                case 10:
                    q0();
                    break;
                case 11:
                    V0(message.arg1);
                    break;
                case 12:
                    Y0(message.arg1 != 0);
                    break;
                case 13:
                    L0(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    G0((x1) message.obj);
                    break;
                case 15:
                    I0((x1) message.obj);
                    break;
                case 16:
                    J((t1) message.obj, false);
                    break;
                case 17:
                    M0((b) message.obj);
                    break;
                case 18:
                    h((b) message.obj, message.arg1);
                    break;
                case 19:
                    e0((c) message.obj);
                    break;
                case 20:
                    n0(message.arg1, message.arg2, (p0) message.obj);
                    break;
                case 21:
                    Z0((p0) message.obj);
                    break;
                case 22:
                    d0();
                    break;
                case 23:
                    P0(message.arg1 != 0);
                    break;
                case 24:
                    O0(message.arg1 == 1);
                    break;
                case 25:
                    i();
                    break;
                default:
                    return false;
            }
        } catch (ExoPlaybackException e2) {
            e = e2;
            if (e.type == 1 && (p = this.N3.p()) != null) {
                e = e.copyWithMediaPeriodId(p.f2618f.a);
            }
            if (!e.isRecoverable || this.j4 != null) {
                ExoPlaybackException exoPlaybackException = this.j4;
                if (exoPlaybackException != null) {
                    exoPlaybackException.addSuppressed(e);
                    e = this.j4;
                }
                u.d("ExoPlayerImplInternal", "Playback error", e);
                i1(true, false);
                this.S3 = this.S3.f(e);
            } else {
                u.i("ExoPlayerImplInternal", "Recoverable renderer error", e);
                this.j4 = e;
                r rVar = this.z;
                rVar.b(rVar.e(25, e));
            }
        } catch (ParserException e3) {
            int i2 = e3.dataType;
            if (i2 == 1) {
                i = e3.contentIsMalformed ? PlaybackException.ERROR_CODE_PARSING_CONTAINER_MALFORMED : PlaybackException.ERROR_CODE_PARSING_CONTAINER_UNSUPPORTED;
            } else if (i2 == 4) {
                i = e3.contentIsMalformed ? PlaybackException.ERROR_CODE_PARSING_MANIFEST_MALFORMED : PlaybackException.ERROR_CODE_PARSING_MANIFEST_UNSUPPORTED;
            }
            E(e3, i);
        } catch (DrmSession.DrmSessionException e4) {
            E(e4, e4.errorCode);
        } catch (BehindLiveWindowException e5) {
            E(e5, 1002);
        } catch (DataSourceException e6) {
            E(e6, e6.reason);
        } catch (IOException e7) {
            E(e7, PlaybackException.ERROR_CODE_IO_UNSPECIFIED);
        } catch (RuntimeException e8) {
            if ((e8 instanceof IllegalStateException) || (e8 instanceof IllegalArgumentException)) {
                i = 1004;
            }
            ExoPlaybackException createForUnexpected = ExoPlaybackException.createForUnexpected(e8, i);
            u.d("ExoPlayerImplInternal", "Playback error", createForUnexpected);
            i1(true, false);
            this.S3 = this.S3.f(createForUnexpected);
        }
        W();
        return true;
    }

    /* renamed from: i0 */
    public void n(b0 b0Var) {
        this.z.e(9, b0Var).a();
    }

    public void j0() {
        this.z.a(0).a();
    }

    public synchronized boolean l0() {
        if (!this.U3 && this.p0.isAlive()) {
            this.z.i(7);
            q1(new t() { // from class: com.google.android.exoplayer2.a0
                @Override // com.google.common.base.t
                public final Object get() {
                    return g1.this.S();
                }
            }, this.Q3);
            return this.U3;
        }
        return true;
    }

    public void o0(int i, int i2, p0 p0Var) {
        this.z.d(20, i, i2, p0Var).a();
    }

    @Override // com.google.android.exoplayer2.source.b0.a
    public void p(b0 b0Var) {
        this.z.e(8, b0Var).a();
    }

    public void t(long j) {
        this.k4 = j;
    }
}

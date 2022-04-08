package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.v;
import com.google.android.exoplayer2.drm.x;
import com.google.android.exoplayer2.g2;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.y;
import com.google.android.exoplayer2.source.b0;
import com.google.android.exoplayer2.source.f0;
import com.google.android.exoplayer2.source.m0;
import com.google.android.exoplayer2.source.w;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.upstream.x;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.w0;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProgressiveMediaPeriod.java */
/* loaded from: classes.dex */
public final class j0 implements b0, l, Loader.b<a>, Loader.f, m0.d {

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, String> f3332c = H();

    /* renamed from: d  reason: collision with root package name */
    private static final Format f3333d = new Format.b().S("icy").e0("application/x-icy").E();
    private final long H3;
    private final i0 J3;
    @Nullable
    private b0.a O3;
    @Nullable
    private IcyHeaders P3;
    private boolean S3;
    private boolean T3;
    private boolean U3;
    private e V3;
    private y W3;
    private boolean Y3;
    private boolean a4;
    private boolean b4;
    private int c4;
    private long e4;

    /* renamed from: f  reason: collision with root package name */
    private final Uri f3334f;
    private boolean g4;
    private int h4;
    private boolean i4;
    private boolean j4;
    private final v.a p0;
    private final b p1;
    private final com.google.android.exoplayer2.upstream.e p2;
    @Nullable
    private final String p3;
    private final com.google.android.exoplayer2.upstream.l q;
    private final x x;
    private final com.google.android.exoplayer2.upstream.x y;
    private final f0.a z;
    private final Loader I3 = new Loader("ProgressiveMediaPeriod");
    private final k K3 = new k();
    private final Runnable L3 = new Runnable() { // from class: com.google.android.exoplayer2.source.h
        @Override // java.lang.Runnable
        public final void run() {
            j0.this.S();
        }
    };
    private final Runnable M3 = new Runnable() { // from class: com.google.android.exoplayer2.source.j
        @Override // java.lang.Runnable
        public final void run() {
            j0.this.P();
        }
    };
    private final Handler N3 = o0.v();
    private d[] R3 = new d[0];
    private m0[] Q3 = new m0[0];
    private long f4 = -9223372036854775807L;
    private long d4 = -1;
    private long X3 = -9223372036854775807L;
    private int Z3 = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProgressiveMediaPeriod.java */
    /* loaded from: classes.dex */
    public final class a implements Loader.e, w.a {

        /* renamed from: b  reason: collision with root package name */
        private final Uri f3335b;

        /* renamed from: c  reason: collision with root package name */
        private final z f3336c;

        /* renamed from: d  reason: collision with root package name */
        private final i0 f3337d;

        /* renamed from: e  reason: collision with root package name */
        private final l f3338e;

        /* renamed from: f  reason: collision with root package name */
        private final k f3339f;
        private volatile boolean h;
        private long j;
        @Nullable
        private com.google.android.exoplayer2.o2.b0 m;
        private boolean n;
        private final com.google.android.exoplayer2.o2.x g = new com.google.android.exoplayer2.o2.x();
        private boolean i = true;
        private long l = -1;
        private final long a = x.a();
        private n k = j(0);

        public a(Uri uri, com.google.android.exoplayer2.upstream.l lVar, i0 i0Var, l lVar2, k kVar) {
            this.f3335b = uri;
            this.f3336c = new z(lVar);
            this.f3337d = i0Var;
            this.f3338e = lVar2;
            this.f3339f = kVar;
        }

        private n j(long j) {
            return new n.b().i(this.f3335b).h(j).f(j0.this.p3).b(6).e(j0.f3332c).a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(long j, long j2) {
            this.g.a = j;
            this.j = j2;
            this.i = true;
            this.n = false;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.e
        public void a() throws IOException {
            int i = 0;
            while (i == 0 && !this.h) {
                try {
                    long j = this.g.a;
                    n j2 = j(j);
                    this.k = j2;
                    long j3 = this.f3336c.j(j2);
                    this.l = j3;
                    if (j3 != -1) {
                        this.l = j3 + j;
                    }
                    j0.this.P3 = IcyHeaders.a(this.f3336c.d());
                    i iVar = this.f3336c;
                    if (!(j0.this.P3 == null || j0.this.P3.y == -1)) {
                        iVar = new w(this.f3336c, j0.this.P3.y, this);
                        com.google.android.exoplayer2.o2.b0 K = j0.this.K();
                        this.m = K;
                        K.d(j0.f3333d);
                    }
                    long j4 = j;
                    this.f3337d.d(iVar, this.f3335b, this.f3336c.d(), j, this.l, this.f3338e);
                    if (j0.this.P3 != null) {
                        this.f3337d.b();
                    }
                    if (this.i) {
                        this.f3337d.c(j4, this.j);
                        this.i = false;
                    }
                    while (true) {
                        while (i == 0 && !this.h) {
                            try {
                                this.f3339f.a();
                                i = this.f3337d.a(this.g);
                                j4 = this.f3337d.e();
                                if (j4 > j0.this.H3 + j4) {
                                    break;
                                }
                            } catch (InterruptedException unused) {
                                throw new InterruptedIOException();
                            }
                        }
                        this.f3339f.c();
                        j0.this.N3.post(j0.this.M3);
                    }
                    if (i == 1) {
                        i = 0;
                    } else if (this.f3337d.e() != -1) {
                        this.g.a = this.f3337d.e();
                    }
                    o0.l(this.f3336c);
                } catch (Throwable th) {
                    if (!(i == 1 || this.f3337d.e() == -1)) {
                        this.g.a = this.f3337d.e();
                    }
                    o0.l(this.f3336c);
                    throw th;
                }
            }
        }

        @Override // com.google.android.exoplayer2.source.w.a
        public void b(d0 d0Var) {
            long max = !this.n ? this.j : Math.max(j0.this.J(), this.j);
            int a = d0Var.a();
            com.google.android.exoplayer2.o2.b0 b0Var = (com.google.android.exoplayer2.o2.b0) g.e(this.m);
            b0Var.c(d0Var, a);
            b0Var.e(max, 1, a, 0, null);
            this.n = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.e
        public void c() {
            this.h = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProgressiveMediaPeriod.java */
    /* loaded from: classes.dex */
    public interface b {
        void k(long j, boolean z, boolean z2);
    }

    /* compiled from: ProgressiveMediaPeriod.java */
    /* loaded from: classes.dex */
    private final class c implements n0 {
        private final int a;

        public c(int i) {
            this.a = i;
        }

        @Override // com.google.android.exoplayer2.source.n0
        public void a() throws IOException {
            j0.this.W(this.a);
        }

        @Override // com.google.android.exoplayer2.source.n0
        public int b(i1 i1Var, DecoderInputBuffer decoderInputBuffer, int i) {
            return j0.this.b0(this.a, i1Var, decoderInputBuffer, i);
        }

        @Override // com.google.android.exoplayer2.source.n0
        public int c(long j) {
            return j0.this.f0(this.a, j);
        }

        @Override // com.google.android.exoplayer2.source.n0
        public boolean g() {
            return j0.this.M(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProgressiveMediaPeriod.java */
    /* loaded from: classes.dex */
    public static final class d {
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f3341b;

        public d(int i, boolean z) {
            this.a = i;
            this.f3341b = z;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.a == dVar.a && this.f3341b == dVar.f3341b;
        }

        public int hashCode() {
            return (this.a * 31) + (this.f3341b ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProgressiveMediaPeriod.java */
    /* loaded from: classes.dex */
    public static final class e {
        public final TrackGroupArray a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean[] f3342b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean[] f3343c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean[] f3344d;

        public e(TrackGroupArray trackGroupArray, boolean[] zArr) {
            this.a = trackGroupArray;
            this.f3342b = zArr;
            int i = trackGroupArray.f3161d;
            this.f3343c = new boolean[i];
            this.f3344d = new boolean[i];
        }
    }

    public j0(Uri uri, com.google.android.exoplayer2.upstream.l lVar, i0 i0Var, x xVar, v.a aVar, com.google.android.exoplayer2.upstream.x xVar2, f0.a aVar2, b bVar, com.google.android.exoplayer2.upstream.e eVar, @Nullable String str, int i) {
        this.f3334f = uri;
        this.q = lVar;
        this.x = xVar;
        this.p0 = aVar;
        this.y = xVar2;
        this.z = aVar2;
        this.p1 = bVar;
        this.p2 = eVar;
        this.p3 = str;
        this.H3 = i;
        this.J3 = i0Var;
    }

    @EnsuresNonNull({"trackState", "seekMap"})
    private void E() {
        g.g(this.T3);
        g.e(this.V3);
        g.e(this.W3);
    }

    private boolean F(a aVar, int i) {
        y yVar;
        if (this.d4 == -1 && ((yVar = this.W3) == null || yVar.i() == -9223372036854775807L)) {
            if (!this.T3 || h0()) {
                this.b4 = this.T3;
                this.e4 = 0L;
                this.h4 = 0;
                for (m0 m0Var : this.Q3) {
                    m0Var.P();
                }
                aVar.k(0L, 0L);
                return true;
            }
            this.g4 = true;
            return false;
        }
        this.h4 = i;
        return true;
    }

    private void G(a aVar) {
        if (this.d4 == -1) {
            this.d4 = aVar.l;
        }
    }

    private static Map<String, String> H() {
        HashMap hashMap = new HashMap();
        hashMap.put("Icy-MetaData", "1");
        return Collections.unmodifiableMap(hashMap);
    }

    private int I() {
        int i = 0;
        for (m0 m0Var : this.Q3) {
            i += m0Var.A();
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long J() {
        long j = Long.MIN_VALUE;
        for (m0 m0Var : this.Q3) {
            j = Math.max(j, m0Var.t());
        }
        return j;
    }

    private boolean L() {
        return this.f4 != -9223372036854775807L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O */
    public /* synthetic */ void P() {
        if (!this.j4) {
            ((b0.a) g.e(this.O3)).n(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        Metadata metadata;
        if (!(this.j4 || this.T3 || !this.S3 || this.W3 == null)) {
            for (m0 m0Var : this.Q3) {
                if (m0Var.z() == null) {
                    return;
                }
            }
            this.K3.c();
            int length = this.Q3.length;
            TrackGroup[] trackGroupArr = new TrackGroup[length];
            boolean[] zArr = new boolean[length];
            for (int i = 0; i < length; i++) {
                Format format = (Format) g.e(this.Q3[i].z());
                String str = format.H3;
                boolean o = com.google.android.exoplayer2.util.y.o(str);
                boolean z = o || com.google.android.exoplayer2.util.y.q(str);
                zArr[i] = z;
                this.U3 = z | this.U3;
                IcyHeaders icyHeaders = this.P3;
                if (icyHeaders != null) {
                    if (o || this.R3[i].f3341b) {
                        Metadata metadata2 = format.p2;
                        if (metadata2 == null) {
                            metadata = new Metadata(icyHeaders);
                        } else {
                            metadata = metadata2.a(icyHeaders);
                        }
                        format = format.a().X(metadata).E();
                    }
                    if (o && format.y == -1 && format.z == -1 && icyHeaders.f2549c != -1) {
                        format = format.a().G(icyHeaders.f2549c).E();
                    }
                }
                trackGroupArr[i] = new TrackGroup(format.b(this.x.c(format)));
            }
            this.V3 = new e(new TrackGroupArray(trackGroupArr), zArr);
            this.T3 = true;
            ((b0.a) g.e(this.O3)).p(this);
        }
    }

    private void T(int i) {
        E();
        e eVar = this.V3;
        boolean[] zArr = eVar.f3344d;
        if (!zArr[i]) {
            Format a2 = eVar.a.a(i).a(0);
            this.z.c(com.google.android.exoplayer2.util.y.k(a2.H3), a2, 0, null, this.e4);
            zArr[i] = true;
        }
    }

    private void U(int i) {
        E();
        boolean[] zArr = this.V3.f3342b;
        if (this.g4 && zArr[i]) {
            if (!this.Q3[i].E(false)) {
                this.f4 = 0L;
                this.g4 = false;
                this.b4 = true;
                this.e4 = 0L;
                this.h4 = 0;
                for (m0 m0Var : this.Q3) {
                    m0Var.P();
                }
                ((b0.a) g.e(this.O3)).n(this);
            }
        }
    }

    private com.google.android.exoplayer2.o2.b0 a0(d dVar) {
        int length = this.Q3.length;
        for (int i = 0; i < length; i++) {
            if (dVar.equals(this.R3[i])) {
                return this.Q3[i];
            }
        }
        m0 j = m0.j(this.p2, this.N3.getLooper(), this.x, this.p0);
        j.W(this);
        int i2 = length + 1;
        d[] dVarArr = (d[]) Arrays.copyOf(this.R3, i2);
        dVarArr[length] = dVar;
        this.R3 = (d[]) o0.j(dVarArr);
        m0[] m0VarArr = (m0[]) Arrays.copyOf(this.Q3, i2);
        m0VarArr[length] = j;
        this.Q3 = (m0[]) o0.j(m0VarArr);
        return j;
    }

    private boolean d0(boolean[] zArr, long j) {
        int length = this.Q3.length;
        for (int i = 0; i < length; i++) {
            if (!this.Q3[i].S(j, false) && (zArr[i] || !this.U3)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e0 */
    public void Q(y yVar) {
        this.W3 = this.P3 == null ? yVar : new y.b(-9223372036854775807L);
        this.X3 = yVar.i();
        int i = 1;
        boolean z = this.d4 == -1 && yVar.i() == -9223372036854775807L;
        this.Y3 = z;
        if (z) {
            i = 7;
        }
        this.Z3 = i;
        this.p1.k(this.X3, yVar.g(), this.Y3);
        if (!this.T3) {
            S();
        }
    }

    private void g0() {
        a aVar = new a(this.f3334f, this.q, this.J3, this, this.K3);
        if (this.T3) {
            g.g(L());
            long j = this.X3;
            if (j == -9223372036854775807L || this.f4 <= j) {
                aVar.k(((y) g.e(this.W3)).a(this.f4).a.f3079c, this.f4);
                for (m0 m0Var : this.Q3) {
                    m0Var.U(this.f4);
                }
                this.f4 = -9223372036854775807L;
            } else {
                this.i4 = true;
                this.f4 = -9223372036854775807L;
                return;
            }
        }
        this.h4 = I();
        this.z.A(new x(aVar.a, aVar.k, this.I3.n(aVar, this, this.y.b(this.Z3))), 1, -1, null, 0, null, aVar.j, this.X3);
    }

    private boolean h0() {
        return this.b4 || L();
    }

    com.google.android.exoplayer2.o2.b0 K() {
        return a0(new d(0, true));
    }

    boolean M(int i) {
        return !h0() && this.Q3[i].E(this.i4);
    }

    void V() throws IOException {
        this.I3.k(this.y.b(this.Z3));
    }

    void W(int i) throws IOException {
        this.Q3[i].H();
        V();
    }

    /* renamed from: X */
    public void b(a aVar, long j, long j2, boolean z) {
        z zVar = aVar.f3336c;
        x xVar = new x(aVar.a, aVar.k, zVar.p(), zVar.q(), j, j2, zVar.o());
        this.y.d(aVar.a);
        this.z.r(xVar, 1, -1, null, 0, null, aVar.j, this.X3);
        if (!z) {
            G(aVar);
            for (m0 m0Var : this.Q3) {
                m0Var.P();
            }
            if (this.c4 > 0) {
                ((b0.a) g.e(this.O3)).n(this);
            }
        }
    }

    /* renamed from: Y */
    public void h(a aVar, long j, long j2) {
        y yVar;
        if (this.X3 == -9223372036854775807L && (yVar = this.W3) != null) {
            boolean g = yVar.g();
            long J = J();
            long j3 = J == Long.MIN_VALUE ? 0L : J + 10000;
            this.X3 = j3;
            this.p1.k(j3, g, this.Y3);
        }
        z zVar = aVar.f3336c;
        x xVar = new x(aVar.a, aVar.k, zVar.p(), zVar.q(), j, j2, zVar.o());
        this.y.d(aVar.a);
        this.z.u(xVar, 1, -1, null, 0, null, aVar.j, this.X3);
        G(aVar);
        this.i4 = true;
        ((b0.a) g.e(this.O3)).n(this);
    }

    /* renamed from: Z */
    public Loader.c n(a aVar, long j, long j2, IOException iOException, int i) {
        Loader.c cVar;
        a aVar2;
        boolean z;
        G(aVar);
        z zVar = aVar.f3336c;
        x xVar = new x(aVar.a, aVar.k, zVar.p(), zVar.q(), j, j2, zVar.o());
        long a2 = this.y.a(new x.c(xVar, new a0(1, -1, null, 0, null, w0.e(aVar.j), w0.e(this.X3)), iOException, i));
        if (a2 == -9223372036854775807L) {
            cVar = Loader.f3802d;
        } else {
            int I = I();
            if (I > this.h4) {
                aVar2 = aVar;
                z = true;
            } else {
                z = false;
                aVar2 = aVar;
            }
            if (F(aVar2, I)) {
                cVar = Loader.g(z, a2);
            } else {
                cVar = Loader.f3801c;
            }
        }
        boolean z2 = !cVar.c();
        this.z.w(xVar, 1, -1, null, 0, null, aVar.j, this.X3, iOException, z2);
        if (z2) {
            this.y.d(aVar.a);
        }
        return cVar;
    }

    @Override // com.google.android.exoplayer2.source.b0, com.google.android.exoplayer2.source.o0
    public long a() {
        if (this.c4 == 0) {
            return Long.MIN_VALUE;
        }
        return e();
    }

    int b0(int i, i1 i1Var, DecoderInputBuffer decoderInputBuffer, int i2) {
        if (h0()) {
            return -3;
        }
        T(i);
        int M = this.Q3[i].M(i1Var, decoderInputBuffer, i2, this.i4);
        if (M == -3) {
            U(i);
        }
        return M;
    }

    @Override // com.google.android.exoplayer2.source.b0, com.google.android.exoplayer2.source.o0
    public boolean c() {
        return this.I3.i() && this.K3.d();
    }

    public void c0() {
        if (this.T3) {
            for (m0 m0Var : this.Q3) {
                m0Var.L();
            }
        }
        this.I3.m(this);
        this.N3.removeCallbacksAndMessages(null);
        this.O3 = null;
        this.j4 = true;
    }

    @Override // com.google.android.exoplayer2.source.b0, com.google.android.exoplayer2.source.o0
    public boolean d(long j) {
        if (this.i4 || this.I3.h() || this.g4) {
            return false;
        }
        if (this.T3 && this.c4 == 0) {
            return false;
        }
        boolean e2 = this.K3.e();
        if (this.I3.i()) {
            return e2;
        }
        g0();
        return true;
    }

    @Override // com.google.android.exoplayer2.source.b0, com.google.android.exoplayer2.source.o0
    public long e() {
        long j;
        E();
        boolean[] zArr = this.V3.f3342b;
        if (this.i4) {
            return Long.MIN_VALUE;
        }
        if (L()) {
            return this.f4;
        }
        if (this.U3) {
            int length = this.Q3.length;
            j = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                if (zArr[i] && !this.Q3[i].D()) {
                    j = Math.min(j, this.Q3[i].t());
                }
            }
        } else {
            j = Long.MAX_VALUE;
        }
        if (j == Long.MAX_VALUE) {
            j = J();
        }
        return j == Long.MIN_VALUE ? this.e4 : j;
    }

    @Override // com.google.android.exoplayer2.source.b0, com.google.android.exoplayer2.source.o0
    public void f(long j) {
    }

    int f0(int i, long j) {
        if (h0()) {
            return 0;
        }
        T(i);
        m0 m0Var = this.Q3[i];
        int y = m0Var.y(j, this.i4);
        m0Var.X(y);
        if (y == 0) {
            U(i);
        }
        return y;
    }

    @Override // com.google.android.exoplayer2.source.m0.d
    public void g(Format format) {
        this.N3.post(this.L3);
    }

    @Override // com.google.android.exoplayer2.source.b0
    public long i(long j) {
        E();
        boolean[] zArr = this.V3.f3342b;
        if (!this.W3.g()) {
            j = 0;
        }
        int i = 0;
        this.b4 = false;
        this.e4 = j;
        if (L()) {
            this.f4 = j;
            return j;
        } else if (this.Z3 != 7 && d0(zArr, j)) {
            return j;
        } else {
            this.g4 = false;
            this.f4 = j;
            this.i4 = false;
            if (this.I3.i()) {
                m0[] m0VarArr = this.Q3;
                int length = m0VarArr.length;
                while (i < length) {
                    m0VarArr[i].o();
                    i++;
                }
                this.I3.e();
            } else {
                this.I3.f();
                m0[] m0VarArr2 = this.Q3;
                int length2 = m0VarArr2.length;
                while (i < length2) {
                    m0VarArr2[i].P();
                    i++;
                }
            }
            return j;
        }
    }

    @Override // com.google.android.exoplayer2.source.b0
    public long j(long j, g2 g2Var) {
        E();
        if (!this.W3.g()) {
            return 0L;
        }
        y.a a2 = this.W3.a(j);
        return g2Var.a(j, a2.a.f3078b, a2.f3076b.f3078b);
    }

    @Override // com.google.android.exoplayer2.source.b0
    public long k() {
        if (!this.b4) {
            return -9223372036854775807L;
        }
        if (!this.i4 && I() <= this.h4) {
            return -9223372036854775807L;
        }
        this.b4 = false;
        return this.e4;
    }

    @Override // com.google.android.exoplayer2.source.b0
    public void l(b0.a aVar, long j) {
        this.O3 = aVar;
        this.K3.e();
        g0();
    }

    @Override // com.google.android.exoplayer2.source.b0
    public long m(com.google.android.exoplayer2.trackselection.g[] gVarArr, boolean[] zArr, n0[] n0VarArr, boolean[] zArr2, long j) {
        E();
        e eVar = this.V3;
        TrackGroupArray trackGroupArray = eVar.a;
        boolean[] zArr3 = eVar.f3343c;
        int i = this.c4;
        int i2 = 0;
        for (int i3 = 0; i3 < gVarArr.length; i3++) {
            if (n0VarArr[i3] != null && (gVarArr[i3] == null || !zArr[i3])) {
                int i4 = ((c) n0VarArr[i3]).a;
                g.g(zArr3[i4]);
                this.c4--;
                zArr3[i4] = false;
                n0VarArr[i3] = null;
            }
        }
        boolean z = !this.a4 ? j != 0 : i == 0;
        for (int i5 = 0; i5 < gVarArr.length; i5++) {
            if (n0VarArr[i5] == null && gVarArr[i5] != null) {
                com.google.android.exoplayer2.trackselection.g gVar = gVarArr[i5];
                g.g(gVar.length() == 1);
                g.g(gVar.h(0) == 0);
                int b2 = trackGroupArray.b(gVar.m());
                g.g(!zArr3[b2]);
                this.c4++;
                zArr3[b2] = true;
                n0VarArr[i5] = new c(b2);
                zArr2[i5] = true;
                if (!z) {
                    m0 m0Var = this.Q3[b2];
                    z = !m0Var.S(j, true) && m0Var.w() != 0;
                }
            }
        }
        if (this.c4 == 0) {
            this.g4 = false;
            this.b4 = false;
            if (this.I3.i()) {
                m0[] m0VarArr = this.Q3;
                int length = m0VarArr.length;
                while (i2 < length) {
                    m0VarArr[i2].o();
                    i2++;
                }
                this.I3.e();
            } else {
                m0[] m0VarArr2 = this.Q3;
                int length2 = m0VarArr2.length;
                while (i2 < length2) {
                    m0VarArr2[i2].P();
                    i2++;
                }
            }
        } else if (z) {
            j = i(j);
            while (i2 < n0VarArr.length) {
                if (n0VarArr[i2] != null) {
                    zArr2[i2] = true;
                }
                i2++;
            }
        }
        this.a4 = true;
        return j;
    }

    @Override // com.google.android.exoplayer2.o2.l
    public void o(final y yVar) {
        this.N3.post(new Runnable() { // from class: com.google.android.exoplayer2.source.i
            @Override // java.lang.Runnable
            public final void run() {
                j0.this.R(yVar);
            }
        });
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.f
    public void p() {
        for (m0 m0Var : this.Q3) {
            m0Var.N();
        }
        this.J3.release();
    }

    @Override // com.google.android.exoplayer2.source.b0
    public void q() throws IOException {
        V();
        if (this.i4 && !this.T3) {
            throw ParserException.createForMalformedContainer("Loading finished before preparation is complete.", null);
        }
    }

    @Override // com.google.android.exoplayer2.o2.l
    public void r() {
        this.S3 = true;
        this.N3.post(this.L3);
    }

    @Override // com.google.android.exoplayer2.source.b0
    public TrackGroupArray s() {
        E();
        return this.V3.a;
    }

    @Override // com.google.android.exoplayer2.o2.l
    public com.google.android.exoplayer2.o2.b0 t(int i, int i2) {
        return a0(new d(i, false));
    }

    @Override // com.google.android.exoplayer2.source.b0
    public void u(long j, boolean z) {
        E();
        if (!L()) {
            boolean[] zArr = this.V3.f3343c;
            int length = this.Q3.length;
            for (int i = 0; i < length; i++) {
                this.Q3[i].n(j, z, zArr[i]);
            }
        }
    }
}

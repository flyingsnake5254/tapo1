package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.g2;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.source.b0;
import com.google.android.exoplayer2.source.f0;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.l;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.upstream.x;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.util.y;
import com.google.android.exoplayer2.w0;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SingleSampleMediaPeriod.java */
/* loaded from: classes.dex */
public final class r0 implements b0, Loader.b<c> {
    boolean H3;
    byte[] I3;
    int J3;

    /* renamed from: c  reason: collision with root package name */
    private final n f3391c;

    /* renamed from: d  reason: collision with root package name */
    private final l.a f3392d;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final a0 f3393f;
    private final long p0;
    final Format p2;
    final boolean p3;
    private final x q;
    private final f0.a x;
    private final TrackGroupArray y;
    private final ArrayList<b> z = new ArrayList<>();
    final Loader p1 = new Loader("SingleSampleMediaPeriod");

    /* compiled from: SingleSampleMediaPeriod.java */
    /* loaded from: classes.dex */
    private final class b implements n0 {
        private int a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f3394b;

        private b() {
        }

        private void d() {
            if (!this.f3394b) {
                r0.this.x.c(y.k(r0.this.p2.H3), r0.this.p2, 0, null, 0L);
                this.f3394b = true;
            }
        }

        @Override // com.google.android.exoplayer2.source.n0
        public void a() throws IOException {
            r0 r0Var = r0.this;
            if (!r0Var.p3) {
                r0Var.p1.j();
            }
        }

        @Override // com.google.android.exoplayer2.source.n0
        public int b(i1 i1Var, DecoderInputBuffer decoderInputBuffer, int i) {
            d();
            r0 r0Var = r0.this;
            boolean z = r0Var.H3;
            if (z && r0Var.I3 == null) {
                this.a = 2;
            }
            int i2 = this.a;
            if (i2 == 2) {
                decoderInputBuffer.e(4);
                return -4;
            } else if ((i & 2) != 0 || i2 == 0) {
                i1Var.f2321b = r0Var.p2;
                this.a = 1;
                return -5;
            } else if (!z) {
                return -3;
            } else {
                g.e(r0Var.I3);
                decoderInputBuffer.e(1);
                decoderInputBuffer.x = 0L;
                if ((i & 4) == 0) {
                    decoderInputBuffer.o(r0.this.J3);
                    ByteBuffer byteBuffer = decoderInputBuffer.f2153f;
                    r0 r0Var2 = r0.this;
                    byteBuffer.put(r0Var2.I3, 0, r0Var2.J3);
                }
                if ((i & 1) == 0) {
                    this.a = 2;
                }
                return -4;
            }
        }

        @Override // com.google.android.exoplayer2.source.n0
        public int c(long j) {
            d();
            if (j <= 0 || this.a == 2) {
                return 0;
            }
            this.a = 2;
            return 1;
        }

        public void e() {
            if (this.a == 2) {
                this.a = 1;
            }
        }

        @Override // com.google.android.exoplayer2.source.n0
        public boolean g() {
            return r0.this.H3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleSampleMediaPeriod.java */
    /* loaded from: classes.dex */
    public static final class c implements Loader.e {
        public final long a = x.a();

        /* renamed from: b  reason: collision with root package name */
        public final n f3396b;

        /* renamed from: c  reason: collision with root package name */
        private final z f3397c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private byte[] f3398d;

        public c(n nVar, l lVar) {
            this.f3396b = nVar;
            this.f3397c = new z(lVar);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.e
        public void a() throws IOException {
            this.f3397c.r();
            try {
                this.f3397c.j(this.f3396b);
                int i = 0;
                while (i != -1) {
                    int o = (int) this.f3397c.o();
                    byte[] bArr = this.f3398d;
                    if (bArr == null) {
                        this.f3398d = new byte[1024];
                    } else if (o == bArr.length) {
                        this.f3398d = Arrays.copyOf(bArr, bArr.length * 2);
                    }
                    z zVar = this.f3397c;
                    byte[] bArr2 = this.f3398d;
                    i = zVar.read(bArr2, o, bArr2.length - o);
                }
            } finally {
                o0.l(this.f3397c);
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.e
        public void c() {
        }
    }

    public r0(n nVar, l.a aVar, @Nullable a0 a0Var, Format format, long j, x xVar, f0.a aVar2, boolean z) {
        this.f3391c = nVar;
        this.f3392d = aVar;
        this.f3393f = a0Var;
        this.p2 = format;
        this.p0 = j;
        this.q = xVar;
        this.x = aVar2;
        this.p3 = z;
        this.y = new TrackGroupArray(new TrackGroup(format));
    }

    @Override // com.google.android.exoplayer2.source.b0, com.google.android.exoplayer2.source.o0
    public long a() {
        return (this.H3 || this.p1.i()) ? Long.MIN_VALUE : 0L;
    }

    @Override // com.google.android.exoplayer2.source.b0, com.google.android.exoplayer2.source.o0
    public boolean c() {
        return this.p1.i();
    }

    @Override // com.google.android.exoplayer2.source.b0, com.google.android.exoplayer2.source.o0
    public boolean d(long j) {
        if (this.H3 || this.p1.i() || this.p1.h()) {
            return false;
        }
        l a2 = this.f3392d.a();
        a0 a0Var = this.f3393f;
        if (a0Var != null) {
            a2.b(a0Var);
        }
        c cVar = new c(this.f3391c, a2);
        this.x.A(new x(cVar.a, this.f3391c, this.p1.n(cVar, this, this.q.b(1))), 1, -1, this.p2, 0, null, 0L, this.p0);
        return true;
    }

    @Override // com.google.android.exoplayer2.source.b0, com.google.android.exoplayer2.source.o0
    public long e() {
        return this.H3 ? Long.MIN_VALUE : 0L;
    }

    @Override // com.google.android.exoplayer2.source.b0, com.google.android.exoplayer2.source.o0
    public void f(long j) {
    }

    @Override // com.google.android.exoplayer2.source.b0
    public long i(long j) {
        for (int i = 0; i < this.z.size(); i++) {
            this.z.get(i).e();
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.b0
    public long j(long j, g2 g2Var) {
        return j;
    }

    @Override // com.google.android.exoplayer2.source.b0
    public long k() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.b0
    public void l(b0.a aVar, long j) {
        aVar.p(this);
    }

    @Override // com.google.android.exoplayer2.source.b0
    public long m(com.google.android.exoplayer2.trackselection.g[] gVarArr, boolean[] zArr, n0[] n0VarArr, boolean[] zArr2, long j) {
        for (int i = 0; i < gVarArr.length; i++) {
            if (n0VarArr[i] != null && (gVarArr[i] == null || !zArr[i])) {
                this.z.remove(n0VarArr[i]);
                n0VarArr[i] = null;
            }
            if (n0VarArr[i] == null && gVarArr[i] != null) {
                b bVar = new b();
                this.z.add(bVar);
                n0VarArr[i] = bVar;
                zArr2[i] = true;
            }
        }
        return j;
    }

    /* renamed from: o */
    public void b(c cVar, long j, long j2, boolean z) {
        z zVar = cVar.f3397c;
        x xVar = new x(cVar.a, cVar.f3396b, zVar.p(), zVar.q(), j, j2, zVar.o());
        this.q.d(cVar.a);
        this.x.r(xVar, 1, -1, null, 0, null, 0L, this.p0);
    }

    /* renamed from: p */
    public void h(c cVar, long j, long j2) {
        this.J3 = (int) cVar.f3397c.o();
        this.I3 = (byte[]) g.e(cVar.f3398d);
        this.H3 = true;
        z zVar = cVar.f3397c;
        x xVar = new x(cVar.a, cVar.f3396b, zVar.p(), zVar.q(), j, j2, this.J3);
        this.q.d(cVar.a);
        this.x.u(xVar, 1, -1, this.p2, 0, null, 0L, this.p0);
    }

    @Override // com.google.android.exoplayer2.source.b0
    public void q() {
    }

    /* renamed from: r */
    public Loader.c n(c cVar, long j, long j2, IOException iOException, int i) {
        Loader.c cVar2;
        z zVar = cVar.f3397c;
        x xVar = new x(cVar.a, cVar.f3396b, zVar.p(), zVar.q(), j, j2, zVar.o());
        long a2 = this.q.a(new x.c(xVar, new a0(1, -1, this.p2, 0, null, 0L, w0.e(this.p0)), iOException, i));
        int i2 = (a2 > (-9223372036854775807L) ? 1 : (a2 == (-9223372036854775807L) ? 0 : -1));
        boolean z = i2 == 0 || i >= this.q.b(1);
        if (this.p3 && z) {
            u.i("SingleSampleMediaPeriod", "Loading failed, treating as end-of-stream.", iOException);
            this.H3 = true;
            cVar2 = Loader.f3801c;
        } else if (i2 != 0) {
            cVar2 = Loader.g(false, a2);
        } else {
            cVar2 = Loader.f3802d;
        }
        boolean z2 = !cVar2.c();
        this.x.w(xVar, 1, -1, this.p2, 0, null, 0L, this.p0, iOException, z2);
        if (z2) {
            this.q.d(cVar.a);
        }
        return cVar2;
    }

    @Override // com.google.android.exoplayer2.source.b0
    public TrackGroupArray s() {
        return this.y;
    }

    public void t() {
        this.p1.l();
    }

    @Override // com.google.android.exoplayer2.source.b0
    public void u(long j, boolean z) {
    }
}

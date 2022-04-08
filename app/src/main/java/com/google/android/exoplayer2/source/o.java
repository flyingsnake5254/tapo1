package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.g2;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.source.b0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.y;
import java.io.IOException;

/* compiled from: ClippingMediaPeriod.java */
/* loaded from: classes.dex */
public final class o implements b0, b0.a {

    /* renamed from: c  reason: collision with root package name */
    public final b0 f3374c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private b0.a f3375d;

    /* renamed from: f  reason: collision with root package name */
    private a[] f3376f = new a[0];
    private long q;
    long x;
    long y;

    /* compiled from: ClippingMediaPeriod.java */
    /* loaded from: classes.dex */
    private final class a implements n0 {
        public final n0 a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f3377b;

        public a(n0 n0Var) {
            this.a = n0Var;
        }

        @Override // com.google.android.exoplayer2.source.n0
        public void a() throws IOException {
            this.a.a();
        }

        @Override // com.google.android.exoplayer2.source.n0
        public int b(i1 i1Var, DecoderInputBuffer decoderInputBuffer, int i) {
            if (o.this.h()) {
                return -3;
            }
            if (this.f3377b) {
                decoderInputBuffer.m(4);
                return -4;
            }
            int b2 = this.a.b(i1Var, decoderInputBuffer, i);
            if (b2 == -5) {
                Format format = (Format) g.e(i1Var.f2321b);
                int i2 = format.X3;
                if (!(i2 == 0 && format.Y3 == 0)) {
                    o oVar = o.this;
                    int i3 = 0;
                    if (oVar.x != 0) {
                        i2 = 0;
                    }
                    if (oVar.y == Long.MIN_VALUE) {
                        i3 = format.Y3;
                    }
                    i1Var.f2321b = format.a().M(i2).N(i3).E();
                }
                return -5;
            }
            o oVar2 = o.this;
            long j = oVar2.y;
            if (j == Long.MIN_VALUE || ((b2 != -4 || decoderInputBuffer.x < j) && (b2 != -3 || oVar2.e() != Long.MIN_VALUE || decoderInputBuffer.q))) {
                return b2;
            }
            decoderInputBuffer.f();
            decoderInputBuffer.m(4);
            this.f3377b = true;
            return -4;
        }

        @Override // com.google.android.exoplayer2.source.n0
        public int c(long j) {
            if (o.this.h()) {
                return -3;
            }
            return this.a.c(j);
        }

        public void d() {
            this.f3377b = false;
        }

        @Override // com.google.android.exoplayer2.source.n0
        public boolean g() {
            return !o.this.h() && this.a.g();
        }
    }

    public o(b0 b0Var, boolean z, long j, long j2) {
        this.f3374c = b0Var;
        this.q = z ? j : -9223372036854775807L;
        this.x = j;
        this.y = j2;
    }

    private g2 g(long j, g2 g2Var) {
        long q = o0.q(g2Var.f2304f, 0L, j - this.x);
        long j2 = g2Var.g;
        long j3 = this.y;
        long q2 = o0.q(j2, 0L, j3 == Long.MIN_VALUE ? Long.MAX_VALUE : j3 - j);
        return (q == g2Var.f2304f && q2 == g2Var.g) ? g2Var : new g2(q, q2);
    }

    private static boolean t(long j, com.google.android.exoplayer2.trackselection.g[] gVarArr) {
        if (j != 0) {
            for (com.google.android.exoplayer2.trackselection.g gVar : gVarArr) {
                if (gVar != null) {
                    Format s = gVar.s();
                    if (!y.a(s.H3, s.p1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.b0, com.google.android.exoplayer2.source.o0
    public long a() {
        long a2 = this.f3374c.a();
        if (a2 != Long.MIN_VALUE) {
            long j = this.y;
            if (j == Long.MIN_VALUE || a2 < j) {
                return a2;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.b0, com.google.android.exoplayer2.source.o0
    public boolean c() {
        return this.f3374c.c();
    }

    @Override // com.google.android.exoplayer2.source.b0, com.google.android.exoplayer2.source.o0
    public boolean d(long j) {
        return this.f3374c.d(j);
    }

    @Override // com.google.android.exoplayer2.source.b0, com.google.android.exoplayer2.source.o0
    public long e() {
        long e2 = this.f3374c.e();
        if (e2 != Long.MIN_VALUE) {
            long j = this.y;
            if (j == Long.MIN_VALUE || e2 < j) {
                return e2;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.b0, com.google.android.exoplayer2.source.o0
    public void f(long j) {
        this.f3374c.f(j);
    }

    boolean h() {
        return this.q != -9223372036854775807L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0032, code lost:
        if (r0 > r7) goto L_0x0035;
     */
    @Override // com.google.android.exoplayer2.source.b0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long i(long r7) {
        /*
            r6 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6.q = r0
            com.google.android.exoplayer2.source.o$a[] r0 = r6.f3376f
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L_0x000c:
            if (r3 >= r1) goto L_0x0018
            r4 = r0[r3]
            if (r4 == 0) goto L_0x0015
            r4.d()
        L_0x0015:
            int r3 = r3 + 1
            goto L_0x000c
        L_0x0018:
            com.google.android.exoplayer2.source.b0 r0 = r6.f3374c
            long r0 = r0.i(r7)
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0034
            long r7 = r6.x
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 < 0) goto L_0x0035
            long r7 = r6.y
            r3 = -9223372036854775808
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0034
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 > 0) goto L_0x0035
        L_0x0034:
            r2 = 1
        L_0x0035:
            com.google.android.exoplayer2.util.g.g(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.o.i(long):long");
    }

    @Override // com.google.android.exoplayer2.source.b0
    public long j(long j, g2 g2Var) {
        long j2 = this.x;
        if (j == j2) {
            return j2;
        }
        return this.f3374c.j(j, g(j, g2Var));
    }

    @Override // com.google.android.exoplayer2.source.b0
    public long k() {
        if (h()) {
            long j = this.q;
            this.q = -9223372036854775807L;
            long k = k();
            return k != -9223372036854775807L ? k : j;
        }
        long k2 = this.f3374c.k();
        if (k2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z = true;
        g.g(k2 >= this.x);
        long j2 = this.y;
        if (j2 != Long.MIN_VALUE && k2 > j2) {
            z = false;
        }
        g.g(z);
        return k2;
    }

    @Override // com.google.android.exoplayer2.source.b0
    public void l(b0.a aVar, long j) {
        this.f3375d = aVar;
        this.f3374c.l(this, j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0062, code lost:
        if (r2 > r4) goto L_0x0065;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006e  */
    @Override // com.google.android.exoplayer2.source.b0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long m(com.google.android.exoplayer2.trackselection.g[] r13, boolean[] r14, com.google.android.exoplayer2.source.n0[] r15, boolean[] r16, long r17) {
        /*
            r12 = this;
            r0 = r12
            r1 = r15
            int r2 = r1.length
            com.google.android.exoplayer2.source.o$a[] r2 = new com.google.android.exoplayer2.source.o.a[r2]
            r0.f3376f = r2
            int r2 = r1.length
            com.google.android.exoplayer2.source.n0[] r9 = new com.google.android.exoplayer2.source.n0[r2]
            r10 = 0
            r2 = 0
        L_0x000c:
            int r3 = r1.length
            r11 = 0
            if (r2 >= r3) goto L_0x0025
            com.google.android.exoplayer2.source.o$a[] r3 = r0.f3376f
            r4 = r1[r2]
            com.google.android.exoplayer2.source.o$a r4 = (com.google.android.exoplayer2.source.o.a) r4
            r3[r2] = r4
            r4 = r3[r2]
            if (r4 == 0) goto L_0x0020
            r3 = r3[r2]
            com.google.android.exoplayer2.source.n0 r11 = r3.a
        L_0x0020:
            r9[r2] = r11
            int r2 = r2 + 1
            goto L_0x000c
        L_0x0025:
            com.google.android.exoplayer2.source.b0 r2 = r0.f3374c
            r3 = r13
            r4 = r14
            r5 = r9
            r6 = r16
            r7 = r17
            long r2 = r2.m(r3, r4, r5, r6, r7)
            boolean r4 = r12.h()
            if (r4 == 0) goto L_0x0047
            long r4 = r0.x
            int r6 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0047
            r6 = r13
            boolean r4 = t(r4, r13)
            if (r4 == 0) goto L_0x0047
            r4 = r2
            goto L_0x004c
        L_0x0047:
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x004c:
            r0.q = r4
            int r4 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r4 == 0) goto L_0x0067
            long r4 = r0.x
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 < 0) goto L_0x0065
            long r4 = r0.y
            r6 = -9223372036854775808
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0067
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            r4 = 0
            goto L_0x0068
        L_0x0067:
            r4 = 1
        L_0x0068:
            com.google.android.exoplayer2.util.g.g(r4)
        L_0x006b:
            int r4 = r1.length
            if (r10 >= r4) goto L_0x0097
            r4 = r9[r10]
            if (r4 != 0) goto L_0x0077
            com.google.android.exoplayer2.source.o$a[] r4 = r0.f3376f
            r4[r10] = r11
            goto L_0x008e
        L_0x0077:
            com.google.android.exoplayer2.source.o$a[] r4 = r0.f3376f
            r5 = r4[r10]
            if (r5 == 0) goto L_0x0085
            r5 = r4[r10]
            com.google.android.exoplayer2.source.n0 r5 = r5.a
            r6 = r9[r10]
            if (r5 == r6) goto L_0x008e
        L_0x0085:
            com.google.android.exoplayer2.source.o$a r5 = new com.google.android.exoplayer2.source.o$a
            r6 = r9[r10]
            r5.<init>(r6)
            r4[r10] = r5
        L_0x008e:
            com.google.android.exoplayer2.source.o$a[] r4 = r0.f3376f
            r4 = r4[r10]
            r1[r10] = r4
            int r10 = r10 + 1
            goto L_0x006b
        L_0x0097:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.o.m(com.google.android.exoplayer2.trackselection.g[], boolean[], com.google.android.exoplayer2.source.n0[], boolean[], long):long");
    }

    @Override // com.google.android.exoplayer2.source.b0.a
    public void p(b0 b0Var) {
        ((b0.a) g.e(this.f3375d)).p(this);
    }

    @Override // com.google.android.exoplayer2.source.b0
    public void q() throws IOException {
        this.f3374c.q();
    }

    /* renamed from: r */
    public void n(b0 b0Var) {
        ((b0.a) g.e(this.f3375d)).n(this);
    }

    @Override // com.google.android.exoplayer2.source.b0
    public TrackGroupArray s() {
        return this.f3374c.s();
    }

    @Override // com.google.android.exoplayer2.source.b0
    public void u(long j, boolean z) {
        this.f3374c.u(j, z);
    }

    public void v(long j, long j2) {
        this.x = j;
        this.y = j2;
    }
}

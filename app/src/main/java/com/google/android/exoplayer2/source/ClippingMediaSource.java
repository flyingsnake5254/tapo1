package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import androidx.core.os.EnvironmentCompat;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.l1;
import com.google.android.exoplayer2.source.e0;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.w0;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class ClippingMediaSource extends p<Void> {
    private final e0 j;
    private final long k;
    private final long l;
    private final boolean m;
    private final boolean n;
    private final boolean o;
    private final ArrayList<o> p;
    private final j2.c q;
    @Nullable
    private a r;
    @Nullable
    private IllegalClippingException s;
    private long t;
    private long u;

    /* loaded from: classes.dex */
    public static final class IllegalClippingException extends IOException {
        public static final int REASON_INVALID_PERIOD_COUNT = 0;
        public static final int REASON_NOT_SEEKABLE_TO_START = 1;
        public static final int REASON_START_EXCEEDS_END = 2;
        public final int reason;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public IllegalClippingException(int r4) {
            /*
                r3 = this;
                java.lang.String r0 = getReasonDescription(r4)
                java.lang.String r0 = java.lang.String.valueOf(r0)
                int r1 = r0.length()
                java.lang.String r2 = "Illegal clipping: "
                if (r1 == 0) goto L_0x0015
                java.lang.String r0 = r2.concat(r0)
                goto L_0x001a
            L_0x0015:
                java.lang.String r0 = new java.lang.String
                r0.<init>(r2)
            L_0x001a:
                r3.<init>(r0)
                r3.reason = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.ClippingMediaSource.IllegalClippingException.<init>(int):void");
        }

        private static String getReasonDescription(int i) {
            return i != 0 ? i != 1 ? i != 2 ? EnvironmentCompat.MEDIA_UNKNOWN : "start exceeds end" : "not seekable to start" : "invalid period count";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a extends v {

        /* renamed from: d  reason: collision with root package name */
        private final long f3152d;

        /* renamed from: e  reason: collision with root package name */
        private final long f3153e;

        /* renamed from: f  reason: collision with root package name */
        private final long f3154f;
        private final boolean g;

        public a(j2 j2Var, long j, long j2) throws IllegalClippingException {
            super(j2Var);
            boolean z = false;
            if (j2Var.i() == 1) {
                j2.c n = j2Var.n(0, new j2.c());
                long max = Math.max(0L, j);
                if (n.p || max == 0 || n.l) {
                    long max2 = j2 == Long.MIN_VALUE ? n.r : Math.max(0L, j2);
                    long j3 = n.r;
                    if (j3 != -9223372036854775807L) {
                        max2 = max2 > j3 ? j3 : max2;
                        if (max > max2) {
                            throw new IllegalClippingException(2);
                        }
                    }
                    this.f3152d = max;
                    this.f3153e = max2;
                    int i = (max2 > (-9223372036854775807L) ? 1 : (max2 == (-9223372036854775807L) ? 0 : -1));
                    this.f3154f = i == 0 ? -9223372036854775807L : max2 - max;
                    if (n.m && (i == 0 || (j3 != -9223372036854775807L && max2 == j3))) {
                        z = true;
                    }
                    this.g = z;
                    return;
                }
                throw new IllegalClippingException(1);
            }
            throw new IllegalClippingException(0);
        }

        @Override // com.google.android.exoplayer2.source.v, com.google.android.exoplayer2.j2
        public j2.b g(int i, j2.b bVar, boolean z) {
            this.f3418c.g(0, bVar, z);
            long m = bVar.m() - this.f3152d;
            long j = this.f3154f;
            return bVar.q(bVar.f2328b, bVar.f2329c, 0, j == -9223372036854775807L ? -9223372036854775807L : j - m, m);
        }

        @Override // com.google.android.exoplayer2.source.v, com.google.android.exoplayer2.j2
        public j2.c o(int i, j2.c cVar, long j) {
            this.f3418c.o(0, cVar, 0L);
            long j2 = cVar.u;
            long j3 = this.f3152d;
            cVar.u = j2 + j3;
            cVar.r = this.f3154f;
            cVar.m = this.g;
            long j4 = cVar.q;
            if (j4 != -9223372036854775807L) {
                long max = Math.max(j4, j3);
                cVar.q = max;
                long j5 = this.f3153e;
                if (j5 != -9223372036854775807L) {
                    max = Math.min(max, j5);
                }
                cVar.q = max;
                cVar.q = max - this.f3152d;
            }
            long e2 = w0.e(this.f3152d);
            long j6 = cVar.i;
            if (j6 != -9223372036854775807L) {
                cVar.i = j6 + e2;
            }
            long j7 = cVar.j;
            if (j7 != -9223372036854775807L) {
                cVar.j = j7 + e2;
            }
            return cVar;
        }
    }

    public ClippingMediaSource(e0 e0Var, long j, long j2, boolean z, boolean z2, boolean z3) {
        g.a(j >= 0);
        this.j = (e0) g.e(e0Var);
        this.k = j;
        this.l = j2;
        this.m = z;
        this.n = z2;
        this.o = z3;
        this.p = new ArrayList<>();
        this.q = new j2.c();
    }

    private void J(j2 j2Var) {
        long j;
        j2Var.n(0, this.q);
        long e2 = this.q.e();
        long j2 = Long.MIN_VALUE;
        if (this.r == null || this.p.isEmpty() || this.n) {
            long j3 = this.k;
            long j4 = this.l;
            if (this.o) {
                long c2 = this.q.c();
                j3 += c2;
                j4 += c2;
            }
            this.t = e2 + j3;
            if (this.l != Long.MIN_VALUE) {
                j2 = e2 + j4;
            }
            this.u = j2;
            int size = this.p.size();
            for (int i = 0; i < size; i++) {
                this.p.get(i).v(this.t, this.u);
            }
            j = j3;
            j2 = j4;
        } else {
            j = this.t - e2;
            if (this.l != Long.MIN_VALUE) {
                j2 = this.u - e2;
            }
        }
        try {
            a aVar = new a(j2Var, j, j2);
            this.r = aVar;
            y(aVar);
        } catch (IllegalClippingException e3) {
            this.s = e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: I */
    public void F(Void r1, e0 e0Var, j2 j2Var) {
        if (this.s == null) {
            J(j2Var);
        }
    }

    @Override // com.google.android.exoplayer2.source.e0
    public b0 a(e0.a aVar, e eVar, long j) {
        o oVar = new o(this.j.a(aVar, eVar, j), this.m, this.t, this.u);
        this.p.add(oVar);
        return oVar;
    }

    @Override // com.google.android.exoplayer2.source.e0
    public l1 f() {
        return this.j.f();
    }

    @Override // com.google.android.exoplayer2.source.e0
    public void g(b0 b0Var) {
        g.g(this.p.remove(b0Var));
        this.j.g(((o) b0Var).f3374c);
        if (this.p.isEmpty() && !this.n) {
            J(((a) g.e(this.r)).f3418c);
        }
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.e0
    public void n() throws IOException {
        IllegalClippingException illegalClippingException = this.s;
        if (illegalClippingException == null) {
            super.n();
            return;
        }
        throw illegalClippingException;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m
    public void x(@Nullable a0 a0Var) {
        super.x(a0Var);
        G(null, this.j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m
    public void z() {
        super.z();
        this.s = null;
        this.r = null;
    }
}

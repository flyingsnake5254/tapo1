package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.l1;
import com.google.android.exoplayer2.source.ads.g;
import com.google.android.exoplayer2.source.e0;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.util.o0;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: MaskingMediaSource.java */
/* loaded from: classes.dex */
public final class z extends p<Void> {
    private final e0 j;
    private final boolean k;
    private final j2.c l;
    private final j2.b m;
    private a n;
    @Nullable
    private y o;
    private boolean p;
    private boolean q;
    private boolean r;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MaskingMediaSource.java */
    /* loaded from: classes.dex */
    public static final class a extends v {

        /* renamed from: d  reason: collision with root package name */
        public static final Object f3432d = new Object();
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private final Object f3433e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private final Object f3434f;

        private a(j2 j2Var, @Nullable Object obj, @Nullable Object obj2) {
            super(j2Var);
            this.f3433e = obj;
            this.f3434f = obj2;
        }

        public static a u(l1 l1Var) {
            return new a(new b(l1Var), j2.c.a, f3432d);
        }

        public static a v(j2 j2Var, @Nullable Object obj, @Nullable Object obj2) {
            return new a(j2Var, obj, obj2);
        }

        @Override // com.google.android.exoplayer2.source.v, com.google.android.exoplayer2.j2
        public int b(Object obj) {
            Object obj2;
            j2 j2Var = this.f3418c;
            if (f3432d.equals(obj) && (obj2 = this.f3434f) != null) {
                obj = obj2;
            }
            return j2Var.b(obj);
        }

        @Override // com.google.android.exoplayer2.source.v, com.google.android.exoplayer2.j2
        public j2.b g(int i, j2.b bVar, boolean z) {
            this.f3418c.g(i, bVar, z);
            if (o0.b(bVar.f2329c, this.f3434f) && z) {
                bVar.f2329c = f3432d;
            }
            return bVar;
        }

        @Override // com.google.android.exoplayer2.source.v, com.google.android.exoplayer2.j2
        public Object m(int i) {
            Object m = this.f3418c.m(i);
            return o0.b(m, this.f3434f) ? f3432d : m;
        }

        @Override // com.google.android.exoplayer2.source.v, com.google.android.exoplayer2.j2
        public j2.c o(int i, j2.c cVar, long j) {
            this.f3418c.o(i, cVar, j);
            if (o0.b(cVar.f2336e, this.f3433e)) {
                cVar.f2336e = j2.c.a;
            }
            return cVar;
        }

        public a t(j2 j2Var) {
            return new a(j2Var, this.f3433e, this.f3434f);
        }
    }

    /* compiled from: MaskingMediaSource.java */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static final class b extends j2 {

        /* renamed from: c  reason: collision with root package name */
        private final l1 f3435c;

        public b(l1 l1Var) {
            this.f3435c = l1Var;
        }

        @Override // com.google.android.exoplayer2.j2
        public int b(Object obj) {
            return obj == a.f3432d ? 0 : -1;
        }

        @Override // com.google.android.exoplayer2.j2
        public j2.b g(int i, j2.b bVar, boolean z) {
            Object obj = null;
            Integer num = z ? 0 : null;
            if (z) {
                obj = a.f3432d;
            }
            bVar.r(num, obj, 0, -9223372036854775807L, 0L, g.a, true);
            return bVar;
        }

        @Override // com.google.android.exoplayer2.j2
        public int i() {
            return 1;
        }

        @Override // com.google.android.exoplayer2.j2
        public Object m(int i) {
            return a.f3432d;
        }

        @Override // com.google.android.exoplayer2.j2
        public j2.c o(int i, j2.c cVar, long j) {
            cVar.g(j2.c.a, this.f3435c, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, null, 0L, -9223372036854775807L, 0, 0, 0L);
            cVar.p = true;
            return cVar;
        }

        @Override // com.google.android.exoplayer2.j2
        public int p() {
            return 1;
        }
    }

    public z(e0 e0Var, boolean z) {
        this.j = e0Var;
        this.k = z && e0Var.o();
        this.l = new j2.c();
        this.m = new j2.b();
        j2 p = e0Var.p();
        if (p != null) {
            this.n = a.v(p, null, null);
            this.r = true;
            return;
        }
        this.n = a.u(e0Var.f());
    }

    private Object J(Object obj) {
        return (this.n.f3434f == null || !this.n.f3434f.equals(obj)) ? obj : a.f3432d;
    }

    private Object K(Object obj) {
        return (this.n.f3434f == null || !obj.equals(a.f3432d)) ? obj : this.n.f3434f;
    }

    @RequiresNonNull({"unpreparedMaskingMediaPeriod"})
    private void O(long j) {
        y yVar = this.o;
        int b2 = this.n.b(yVar.f3429c.a);
        if (b2 != -1) {
            long j2 = this.n.f(b2, this.m).f2331e;
            if (j2 != -9223372036854775807L && j >= j2) {
                j = Math.max(0L, j2 - 1);
            }
            yVar.w(j);
        }
    }

    /* renamed from: I */
    public y a(e0.a aVar, e eVar, long j) {
        y yVar = new y(aVar, eVar, j);
        yVar.y(this.j);
        if (this.q) {
            yVar.g(aVar.c(K(aVar.a)));
        } else {
            this.o = yVar;
            if (!this.p) {
                this.p = true;
                G(null, this.j);
            }
        }
        return yVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: L */
    public e0.a A(Void r1, e0.a aVar) {
        return aVar.c(J(aVar.a));
    }

    public j2 M() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* renamed from: N */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void F(java.lang.Void r13, com.google.android.exoplayer2.source.e0 r14, com.google.android.exoplayer2.j2 r15) {
        /*
            r12 = this;
            boolean r13 = r12.q
            if (r13 == 0) goto L_0x0019
            com.google.android.exoplayer2.source.z$a r13 = r12.n
            com.google.android.exoplayer2.source.z$a r13 = r13.t(r15)
            r12.n = r13
            com.google.android.exoplayer2.source.y r13 = r12.o
            if (r13 == 0) goto L_0x00ae
            long r13 = r13.h()
            r12.O(r13)
            goto L_0x00ae
        L_0x0019:
            boolean r13 = r15.q()
            if (r13 == 0) goto L_0x0036
            boolean r13 = r12.r
            if (r13 == 0) goto L_0x002a
            com.google.android.exoplayer2.source.z$a r13 = r12.n
            com.google.android.exoplayer2.source.z$a r13 = r13.t(r15)
            goto L_0x0032
        L_0x002a:
            java.lang.Object r13 = com.google.android.exoplayer2.j2.c.a
            java.lang.Object r14 = com.google.android.exoplayer2.source.z.a.f3432d
            com.google.android.exoplayer2.source.z$a r13 = com.google.android.exoplayer2.source.z.a.v(r15, r13, r14)
        L_0x0032:
            r12.n = r13
            goto L_0x00ae
        L_0x0036:
            com.google.android.exoplayer2.j2$c r13 = r12.l
            r14 = 0
            r15.n(r14, r13)
            com.google.android.exoplayer2.j2$c r13 = r12.l
            long r0 = r13.c()
            com.google.android.exoplayer2.j2$c r13 = r12.l
            java.lang.Object r13 = r13.f2336e
            com.google.android.exoplayer2.source.y r2 = r12.o
            if (r2 == 0) goto L_0x0074
            long r2 = r2.r()
            com.google.android.exoplayer2.source.z$a r4 = r12.n
            com.google.android.exoplayer2.source.y r5 = r12.o
            com.google.android.exoplayer2.source.e0$a r5 = r5.f3429c
            java.lang.Object r5 = r5.a
            com.google.android.exoplayer2.j2$b r6 = r12.m
            r4.h(r5, r6)
            com.google.android.exoplayer2.j2$b r4 = r12.m
            long r4 = r4.m()
            long r4 = r4 + r2
            com.google.android.exoplayer2.source.z$a r2 = r12.n
            com.google.android.exoplayer2.j2$c r3 = r12.l
            com.google.android.exoplayer2.j2$c r14 = r2.n(r14, r3)
            long r2 = r14.c()
            int r14 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r14 == 0) goto L_0x0074
            r10 = r4
            goto L_0x0075
        L_0x0074:
            r10 = r0
        L_0x0075:
            com.google.android.exoplayer2.j2$c r7 = r12.l
            com.google.android.exoplayer2.j2$b r8 = r12.m
            r9 = 0
            r6 = r15
            android.util.Pair r14 = r6.j(r7, r8, r9, r10)
            java.lang.Object r0 = r14.first
            java.lang.Object r14 = r14.second
            java.lang.Long r14 = (java.lang.Long) r14
            long r1 = r14.longValue()
            boolean r14 = r12.r
            if (r14 == 0) goto L_0x0094
            com.google.android.exoplayer2.source.z$a r13 = r12.n
            com.google.android.exoplayer2.source.z$a r13 = r13.t(r15)
            goto L_0x0098
        L_0x0094:
            com.google.android.exoplayer2.source.z$a r13 = com.google.android.exoplayer2.source.z.a.v(r15, r13, r0)
        L_0x0098:
            r12.n = r13
            com.google.android.exoplayer2.source.y r13 = r12.o
            if (r13 == 0) goto L_0x00ae
            r12.O(r1)
            com.google.android.exoplayer2.source.e0$a r13 = r13.f3429c
            java.lang.Object r14 = r13.a
            java.lang.Object r14 = r12.K(r14)
            com.google.android.exoplayer2.source.e0$a r13 = r13.c(r14)
            goto L_0x00af
        L_0x00ae:
            r13 = 0
        L_0x00af:
            r14 = 1
            r12.r = r14
            r12.q = r14
            com.google.android.exoplayer2.source.z$a r14 = r12.n
            r12.y(r14)
            if (r13 == 0) goto L_0x00c6
            com.google.android.exoplayer2.source.y r14 = r12.o
            java.lang.Object r14 = com.google.android.exoplayer2.util.g.e(r14)
            com.google.android.exoplayer2.source.y r14 = (com.google.android.exoplayer2.source.y) r14
            r14.g(r13)
        L_0x00c6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.z.F(java.lang.Void, com.google.android.exoplayer2.source.e0, com.google.android.exoplayer2.j2):void");
    }

    @Override // com.google.android.exoplayer2.source.e0
    public l1 f() {
        return this.j.f();
    }

    @Override // com.google.android.exoplayer2.source.e0
    public void g(b0 b0Var) {
        ((y) b0Var).x();
        if (b0Var == this.o) {
            this.o = null;
        }
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.e0
    public void n() {
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m
    public void x(@Nullable a0 a0Var) {
        super.x(a0Var);
        if (!this.k) {
            this.p = true;
            G(null, this.j);
        }
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m
    public void z() {
        this.q = false;
        this.p = false;
        super.z();
    }
}

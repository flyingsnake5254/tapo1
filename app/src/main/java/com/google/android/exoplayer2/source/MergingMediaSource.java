package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.l1;
import com.google.android.exoplayer2.source.e0;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.util.g;
import com.google.common.collect.r1;
import com.google.common.collect.s1;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class MergingMediaSource extends p<Integer> {
    private static final l1 j = new l1.c().p("MergingMediaSource").a();
    private final boolean k;
    private final boolean l;
    private final e0[] m;
    private final j2[] n;
    private final ArrayList<e0> o;
    private final r p;
    private final Map<Object, Long> q;
    private final r1<Object, o> r;
    private int s;
    private long[][] t;
    @Nullable
    private IllegalMergeException u;

    /* loaded from: classes.dex */
    public static final class IllegalMergeException extends IOException {
        public static final int REASON_PERIOD_COUNT_MISMATCH = 0;
        public final int reason;

        public IllegalMergeException(int i) {
            this.reason = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a extends v {

        /* renamed from: d  reason: collision with root package name */
        private final long[] f3155d;

        /* renamed from: e  reason: collision with root package name */
        private final long[] f3156e;

        public a(j2 j2Var, Map<Object, Long> map) {
            super(j2Var);
            int p = j2Var.p();
            this.f3156e = new long[j2Var.p()];
            j2.c cVar = new j2.c();
            for (int i = 0; i < p; i++) {
                this.f3156e[i] = j2Var.n(i, cVar).r;
            }
            int i2 = j2Var.i();
            this.f3155d = new long[i2];
            j2.b bVar = new j2.b();
            for (int i3 = 0; i3 < i2; i3++) {
                j2Var.g(i3, bVar, true);
                long longValue = ((Long) g.e(map.get(bVar.f2329c))).longValue();
                long[] jArr = this.f3155d;
                jArr[i3] = longValue == Long.MIN_VALUE ? bVar.f2331e : longValue;
                long j = bVar.f2331e;
                if (j != -9223372036854775807L) {
                    long[] jArr2 = this.f3156e;
                    int i4 = bVar.f2330d;
                    jArr2[i4] = jArr2[i4] - (j - jArr[i3]);
                }
            }
        }

        @Override // com.google.android.exoplayer2.source.v, com.google.android.exoplayer2.j2
        public j2.b g(int i, j2.b bVar, boolean z) {
            super.g(i, bVar, z);
            bVar.f2331e = this.f3155d[i];
            return bVar;
        }

        @Override // com.google.android.exoplayer2.source.v, com.google.android.exoplayer2.j2
        public j2.c o(int i, j2.c cVar, long j) {
            long j2;
            super.o(i, cVar, j);
            long j3 = this.f3156e[i];
            cVar.r = j3;
            if (j3 != -9223372036854775807L) {
                long j4 = cVar.q;
                if (j4 != -9223372036854775807L) {
                    j2 = Math.min(j4, j3);
                    cVar.q = j2;
                    return cVar;
                }
            }
            j2 = cVar.q;
            cVar.q = j2;
            return cVar;
        }
    }

    public MergingMediaSource(e0... e0VarArr) {
        this(false, e0VarArr);
    }

    private void I() {
        j2.b bVar = new j2.b();
        for (int i = 0; i < this.s; i++) {
            long j2 = -this.n[0].f(i, bVar).m();
            int i2 = 1;
            while (true) {
                j2[] j2VarArr = this.n;
                if (i2 < j2VarArr.length) {
                    this.t[i][i2] = j2 - (-j2VarArr[i2].f(i, bVar).m());
                    i2++;
                }
            }
        }
    }

    private void L() {
        j2[] j2VarArr;
        j2.b bVar = new j2.b();
        for (int i = 0; i < this.s; i++) {
            long j2 = Long.MIN_VALUE;
            int i2 = 0;
            while (true) {
                j2VarArr = this.n;
                if (i2 >= j2VarArr.length) {
                    break;
                }
                long i3 = j2VarArr[i2].f(i, bVar).i();
                if (i3 != -9223372036854775807L) {
                    long j3 = i3 + this.t[i][i2];
                    if (j2 == Long.MIN_VALUE || j3 < j2) {
                        j2 = j3;
                    }
                }
                i2++;
            }
            Object m = j2VarArr[0].m(i);
            this.q.put(m, Long.valueOf(j2));
            for (o oVar : this.r.get(m)) {
                oVar.v(0L, j2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: J */
    public e0.a A(Integer num, e0.a aVar) {
        if (num.intValue() == 0) {
            return aVar;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: K */
    public void F(Integer num, e0 e0Var, j2 j2Var) {
        if (this.u == null) {
            if (this.s == -1) {
                this.s = j2Var.i();
            } else if (j2Var.i() != this.s) {
                this.u = new IllegalMergeException(0);
                return;
            }
            if (this.t.length == 0) {
                this.t = (long[][]) Array.newInstance(long.class, this.s, this.n.length);
            }
            this.o.remove(e0Var);
            this.n[num.intValue()] = j2Var;
            if (this.o.isEmpty()) {
                if (this.k) {
                    I();
                }
                a aVar = this.n[0];
                if (this.l) {
                    L();
                    aVar = new a(aVar, this.q);
                }
                y(aVar);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.e0
    public b0 a(e0.a aVar, e eVar, long j2) {
        int length = this.m.length;
        b0[] b0VarArr = new b0[length];
        int b2 = this.n[0].b(aVar.a);
        for (int i = 0; i < length; i++) {
            b0VarArr[i] = this.m[i].a(aVar.c(this.n[i].m(b2)), eVar, j2 - this.t[b2][i]);
        }
        h0 h0Var = new h0(this.p, this.t[b2], b0VarArr);
        if (!this.l) {
            return h0Var;
        }
        o oVar = new o(h0Var, true, 0L, ((Long) g.e(this.q.get(aVar.a))).longValue());
        this.r.put(aVar.a, oVar);
        return oVar;
    }

    @Override // com.google.android.exoplayer2.source.e0
    public l1 f() {
        e0[] e0VarArr = this.m;
        return e0VarArr.length > 0 ? e0VarArr[0].f() : j;
    }

    @Override // com.google.android.exoplayer2.source.e0
    public void g(b0 b0Var) {
        if (this.l) {
            o oVar = (o) b0Var;
            Iterator<Map.Entry<Object, o>> it = this.r.entries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Object, o> next = it.next();
                if (next.getValue().equals(oVar)) {
                    this.r.remove(next.getKey(), next.getValue());
                    break;
                }
            }
            b0Var = oVar.f3374c;
        }
        h0 h0Var = (h0) b0Var;
        int i = 0;
        while (true) {
            e0[] e0VarArr = this.m;
            if (i < e0VarArr.length) {
                e0VarArr[i].g(h0Var.g(i));
                i++;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.e0
    public void n() throws IOException {
        IllegalMergeException illegalMergeException = this.u;
        if (illegalMergeException == null) {
            super.n();
            return;
        }
        throw illegalMergeException;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m
    public void x(@Nullable a0 a0Var) {
        super.x(a0Var);
        for (int i = 0; i < this.m.length; i++) {
            G(Integer.valueOf(i), this.m[i]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m
    public void z() {
        super.z();
        Arrays.fill(this.n, (Object) null);
        this.s = -1;
        this.u = null;
        this.o.clear();
        Collections.addAll(this.o, this.m);
    }

    public MergingMediaSource(boolean z, e0... e0VarArr) {
        this(z, false, e0VarArr);
    }

    public MergingMediaSource(boolean z, boolean z2, e0... e0VarArr) {
        this(z, z2, new s(), e0VarArr);
    }

    public MergingMediaSource(boolean z, boolean z2, r rVar, e0... e0VarArr) {
        this.k = z;
        this.l = z2;
        this.m = e0VarArr;
        this.p = rVar;
        this.o = new ArrayList<>(Arrays.asList(e0VarArr));
        this.s = -1;
        this.n = new j2[e0VarArr.length];
        this.t = new long[0];
        this.q = new HashMap();
        this.r = s1.a().a().e();
    }
}

package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.g2;
import com.google.android.exoplayer2.source.b0;
import com.google.android.exoplayer2.source.e0;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;

/* compiled from: MaskingMediaPeriod.java */
/* loaded from: classes.dex */
public final class y implements b0, b0.a {

    /* renamed from: c  reason: collision with root package name */
    public final e0.a f3429c;

    /* renamed from: d  reason: collision with root package name */
    private final long f3430d;

    /* renamed from: f  reason: collision with root package name */
    private final e f3431f;
    private boolean p0;
    private long p1 = -9223372036854775807L;
    private e0 q;
    private b0 x;
    @Nullable
    private b0.a y;
    @Nullable
    private a z;

    /* compiled from: MaskingMediaPeriod.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(e0.a aVar);

        void b(e0.a aVar, IOException iOException);
    }

    public y(e0.a aVar, e eVar, long j) {
        this.f3429c = aVar;
        this.f3431f = eVar;
        this.f3430d = j;
    }

    private long t(long j) {
        long j2 = this.p1;
        return j2 != -9223372036854775807L ? j2 : j;
    }

    @Override // com.google.android.exoplayer2.source.b0, com.google.android.exoplayer2.source.o0
    public long a() {
        return ((b0) o0.i(this.x)).a();
    }

    @Override // com.google.android.exoplayer2.source.b0, com.google.android.exoplayer2.source.o0
    public boolean c() {
        b0 b0Var = this.x;
        return b0Var != null && b0Var.c();
    }

    @Override // com.google.android.exoplayer2.source.b0, com.google.android.exoplayer2.source.o0
    public boolean d(long j) {
        b0 b0Var = this.x;
        return b0Var != null && b0Var.d(j);
    }

    @Override // com.google.android.exoplayer2.source.b0, com.google.android.exoplayer2.source.o0
    public long e() {
        return ((b0) o0.i(this.x)).e();
    }

    @Override // com.google.android.exoplayer2.source.b0, com.google.android.exoplayer2.source.o0
    public void f(long j) {
        ((b0) o0.i(this.x)).f(j);
    }

    public void g(e0.a aVar) {
        long t = t(this.f3430d);
        b0 a2 = ((e0) g.e(this.q)).a(aVar, this.f3431f, t);
        this.x = a2;
        if (this.y != null) {
            a2.l(this, t);
        }
    }

    public long h() {
        return this.p1;
    }

    @Override // com.google.android.exoplayer2.source.b0
    public long i(long j) {
        return ((b0) o0.i(this.x)).i(j);
    }

    @Override // com.google.android.exoplayer2.source.b0
    public long j(long j, g2 g2Var) {
        return ((b0) o0.i(this.x)).j(j, g2Var);
    }

    @Override // com.google.android.exoplayer2.source.b0
    public long k() {
        return ((b0) o0.i(this.x)).k();
    }

    @Override // com.google.android.exoplayer2.source.b0
    public void l(b0.a aVar, long j) {
        this.y = aVar;
        b0 b0Var = this.x;
        if (b0Var != null) {
            b0Var.l(this, t(this.f3430d));
        }
    }

    @Override // com.google.android.exoplayer2.source.b0
    public long m(com.google.android.exoplayer2.trackselection.g[] gVarArr, boolean[] zArr, n0[] n0VarArr, boolean[] zArr2, long j) {
        long j2;
        long j3 = this.p1;
        if (j3 == -9223372036854775807L || j != this.f3430d) {
            j2 = j;
        } else {
            this.p1 = -9223372036854775807L;
            j2 = j3;
        }
        return ((b0) o0.i(this.x)).m(gVarArr, zArr, n0VarArr, zArr2, j2);
    }

    @Override // com.google.android.exoplayer2.source.b0.a
    public void p(b0 b0Var) {
        ((b0.a) o0.i(this.y)).p(this);
        a aVar = this.z;
        if (aVar != null) {
            aVar.a(this.f3429c);
        }
    }

    @Override // com.google.android.exoplayer2.source.b0
    public void q() throws IOException {
        try {
            b0 b0Var = this.x;
            if (b0Var != null) {
                b0Var.q();
            } else {
                e0 e0Var = this.q;
                if (e0Var != null) {
                    e0Var.n();
                }
            }
        } catch (IOException e2) {
            a aVar = this.z;
            if (aVar == null) {
                throw e2;
            } else if (!this.p0) {
                this.p0 = true;
                aVar.b(this.f3429c, e2);
            }
        }
    }

    public long r() {
        return this.f3430d;
    }

    @Override // com.google.android.exoplayer2.source.b0
    public TrackGroupArray s() {
        return ((b0) o0.i(this.x)).s();
    }

    @Override // com.google.android.exoplayer2.source.b0
    public void u(long j, boolean z) {
        ((b0) o0.i(this.x)).u(j, z);
    }

    /* renamed from: v */
    public void n(b0 b0Var) {
        ((b0.a) o0.i(this.y)).n(this);
    }

    public void w(long j) {
        this.p1 = j;
    }

    public void x() {
        if (this.x != null) {
            ((e0) g.e(this.q)).g(this.x);
        }
    }

    public void y(e0 e0Var) {
        g.g(this.q == null);
        this.q = e0Var;
    }

    public void z(a aVar) {
        this.z = aVar;
    }
}

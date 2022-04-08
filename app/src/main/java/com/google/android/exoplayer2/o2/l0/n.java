package com.google.android.exoplayer2.o2.l0;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.l0.i0;
import com.google.android.exoplayer2.util.d0;
import java.util.Collections;
import java.util.List;

/* compiled from: DvbSubtitleReader.java */
/* loaded from: classes.dex */
public final class n implements o {
    private final List<i0.a> a;

    /* renamed from: b  reason: collision with root package name */
    private final b0[] f2956b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2957c;

    /* renamed from: d  reason: collision with root package name */
    private int f2958d;

    /* renamed from: e  reason: collision with root package name */
    private int f2959e;

    /* renamed from: f  reason: collision with root package name */
    private long f2960f;

    public n(List<i0.a> list) {
        this.a = list;
        this.f2956b = new b0[list.size()];
    }

    private boolean a(d0 d0Var, int i) {
        if (d0Var.a() == 0) {
            return false;
        }
        if (d0Var.D() != i) {
            this.f2957c = false;
        }
        this.f2958d--;
        return this.f2957c;
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void b(d0 d0Var) {
        b0[] b0VarArr;
        if (!this.f2957c) {
            return;
        }
        if (this.f2958d != 2 || a(d0Var, 32)) {
            if (this.f2958d != 1 || a(d0Var, 0)) {
                int e2 = d0Var.e();
                int a = d0Var.a();
                for (b0 b0Var : this.f2956b) {
                    d0Var.P(e2);
                    b0Var.c(d0Var, a);
                }
                this.f2959e += a;
            }
        }
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void c() {
        this.f2957c = false;
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void d(l lVar, i0.d dVar) {
        for (int i = 0; i < this.f2956b.length; i++) {
            i0.a aVar = this.a.get(i);
            dVar.a();
            b0 t = lVar.t(dVar.c(), 3);
            t.d(new Format.b().S(dVar.b()).e0("application/dvbsubs").T(Collections.singletonList(aVar.f2931c)).V(aVar.a).E());
            this.f2956b[i] = t;
        }
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void e() {
        if (this.f2957c) {
            for (b0 b0Var : this.f2956b) {
                b0Var.e(this.f2960f, 1, this.f2959e, 0, null);
            }
            this.f2957c = false;
        }
    }

    @Override // com.google.android.exoplayer2.o2.l0.o
    public void f(long j, int i) {
        if ((i & 4) != 0) {
            this.f2957c = true;
            this.f2960f = j;
            this.f2959e = 0;
            this.f2958d = 2;
        }
    }
}

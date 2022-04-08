package com.google.android.exoplayer2.o2.l0;

import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.x;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;

/* compiled from: TsDurationReader.java */
/* loaded from: classes.dex */
final class g0 {
    private final int a;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2909d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2910e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2911f;

    /* renamed from: b  reason: collision with root package name */
    private final l0 f2907b = new l0(0);
    private long g = -9223372036854775807L;
    private long h = -9223372036854775807L;
    private long i = -9223372036854775807L;

    /* renamed from: c  reason: collision with root package name */
    private final d0 f2908c = new d0();

    /* JADX INFO: Access modifiers changed from: package-private */
    public g0(int i) {
        this.a = i;
    }

    private int a(k kVar) {
        this.f2908c.M(o0.f3937f);
        this.f2909d = true;
        kVar.e();
        return 0;
    }

    private int f(k kVar, x xVar, int i) throws IOException {
        int min = (int) Math.min(this.a, kVar.a());
        long j = 0;
        if (kVar.getPosition() != j) {
            xVar.a = j;
            return 1;
        }
        this.f2908c.L(min);
        kVar.e();
        kVar.n(this.f2908c.d(), 0, min);
        this.g = g(this.f2908c, i);
        this.f2910e = true;
        return 0;
    }

    private long g(d0 d0Var, int i) {
        int f2 = d0Var.f();
        for (int e2 = d0Var.e(); e2 < f2; e2++) {
            if (d0Var.d()[e2] == 71) {
                long c2 = j0.c(d0Var, e2, i);
                if (c2 != -9223372036854775807L) {
                    return c2;
                }
            }
        }
        return -9223372036854775807L;
    }

    private int h(k kVar, x xVar, int i) throws IOException {
        long a = kVar.a();
        int min = (int) Math.min(this.a, a);
        long j = a - min;
        if (kVar.getPosition() != j) {
            xVar.a = j;
            return 1;
        }
        this.f2908c.L(min);
        kVar.e();
        kVar.n(this.f2908c.d(), 0, min);
        this.h = i(this.f2908c, i);
        this.f2911f = true;
        return 0;
    }

    private long i(d0 d0Var, int i) {
        int e2 = d0Var.e();
        int f2 = d0Var.f();
        for (int i2 = f2 - 188; i2 >= e2; i2--) {
            if (j0.b(d0Var.d(), e2, f2, i2)) {
                long c2 = j0.c(d0Var, i2, i);
                if (c2 != -9223372036854775807L) {
                    return c2;
                }
            }
        }
        return -9223372036854775807L;
    }

    public long b() {
        return this.i;
    }

    public l0 c() {
        return this.f2907b;
    }

    public boolean d() {
        return this.f2909d;
    }

    public int e(k kVar, x xVar, int i) throws IOException {
        if (i <= 0) {
            return a(kVar);
        }
        if (!this.f2911f) {
            return h(kVar, xVar, i);
        }
        if (this.h == -9223372036854775807L) {
            return a(kVar);
        }
        if (!this.f2910e) {
            return f(kVar, xVar, i);
        }
        long j = this.g;
        if (j == -9223372036854775807L) {
            return a(kVar);
        }
        this.i = this.f2907b.b(this.h) - this.f2907b.b(j);
        return a(kVar);
    }
}

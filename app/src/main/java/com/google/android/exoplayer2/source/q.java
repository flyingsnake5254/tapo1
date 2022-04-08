package com.google.android.exoplayer2.source;

/* compiled from: CompositeSequenceableLoader.java */
/* loaded from: classes.dex */
public class q implements o0 {

    /* renamed from: c  reason: collision with root package name */
    protected final o0[] f3386c;

    public q(o0[] o0VarArr) {
        this.f3386c = o0VarArr;
    }

    @Override // com.google.android.exoplayer2.source.o0
    public final long a() {
        long j = Long.MAX_VALUE;
        for (o0 o0Var : this.f3386c) {
            long a = o0Var.a();
            if (a != Long.MIN_VALUE) {
                j = Math.min(j, a);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.o0
    public boolean c() {
        for (o0 o0Var : this.f3386c) {
            if (o0Var.c()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.o0
    public boolean d(long j) {
        o0[] o0VarArr;
        boolean z;
        boolean z2 = false;
        do {
            long a = a();
            if (a == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (o0 o0Var : this.f3386c) {
                long a2 = o0Var.a();
                boolean z3 = a2 != Long.MIN_VALUE && a2 <= j;
                if (a2 == a || z3) {
                    z |= o0Var.d(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }

    @Override // com.google.android.exoplayer2.source.o0
    public final long e() {
        long j = Long.MAX_VALUE;
        for (o0 o0Var : this.f3386c) {
            long e2 = o0Var.e();
            if (e2 != Long.MIN_VALUE) {
                j = Math.min(j, e2);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.o0
    public final void f(long j) {
        for (o0 o0Var : this.f3386c) {
            o0Var.f(j);
        }
    }
}

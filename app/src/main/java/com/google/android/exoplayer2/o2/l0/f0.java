package com.google.android.exoplayer2.o2.l0;

import com.google.android.exoplayer2.o2.b;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;

/* compiled from: TsBinarySearchSeeker.java */
/* loaded from: classes.dex */
final class f0 extends b {

    /* compiled from: TsBinarySearchSeeker.java */
    /* loaded from: classes.dex */
    private static final class a implements b.f {
        private final l0 a;

        /* renamed from: b  reason: collision with root package name */
        private final d0 f2899b = new d0();

        /* renamed from: c  reason: collision with root package name */
        private final int f2900c;

        /* renamed from: d  reason: collision with root package name */
        private final int f2901d;

        public a(int i, l0 l0Var, int i2) {
            this.f2900c = i;
            this.a = l0Var;
            this.f2901d = i2;
        }

        private b.e c(d0 d0Var, long j, long j2) {
            int a;
            int a2;
            int f2 = d0Var.f();
            long j3 = -1;
            long j4 = -1;
            long j5 = -9223372036854775807L;
            while (d0Var.a() >= 188 && (a2 = (a = j0.a(d0Var.d(), d0Var.e(), f2)) + 188) <= f2) {
                long c2 = j0.c(d0Var, a, this.f2900c);
                if (c2 != -9223372036854775807L) {
                    long b2 = this.a.b(c2);
                    if (b2 > j) {
                        if (j5 == -9223372036854775807L) {
                            return b.e.d(b2, j2);
                        }
                        return b.e.e(j2 + j4);
                    } else if (100000 + b2 > j) {
                        return b.e.e(j2 + a);
                    } else {
                        j4 = a;
                        j5 = b2;
                    }
                }
                d0Var.P(a2);
                j3 = a2;
            }
            if (j5 != -9223372036854775807L) {
                return b.e.f(j5, j2 + j3);
            }
            return b.e.a;
        }

        @Override // com.google.android.exoplayer2.o2.b.f
        public b.e a(k kVar, long j) throws IOException {
            long position = kVar.getPosition();
            int min = (int) Math.min(this.f2901d, kVar.a() - position);
            this.f2899b.L(min);
            kVar.n(this.f2899b.d(), 0, min);
            return c(this.f2899b, j, position);
        }

        @Override // com.google.android.exoplayer2.o2.b.f
        public void b() {
            this.f2899b.M(o0.f3937f);
        }
    }

    public f0(l0 l0Var, long j, long j2, int i, int i2) {
        super(new b.C0077b(), new a(i, l0Var, i2), j, 0L, j + 1, 0L, j2, 188L, 940);
    }
}

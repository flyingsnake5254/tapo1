package com.google.android.exoplayer2.o2.k0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.k0.i;
import com.google.android.exoplayer2.o2.p;
import com.google.android.exoplayer2.o2.q;
import com.google.android.exoplayer2.o2.r;
import com.google.android.exoplayer2.o2.s;
import com.google.android.exoplayer2.o2.y;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: FlacReader.java */
/* loaded from: classes.dex */
final class c extends i {
    @Nullable
    private s n;
    @Nullable
    private a o;

    /* compiled from: FlacReader.java */
    /* loaded from: classes.dex */
    private static final class a implements g {
        private s a;

        /* renamed from: b  reason: collision with root package name */
        private s.a f2845b;

        /* renamed from: c  reason: collision with root package name */
        private long f2846c = -1;

        /* renamed from: d  reason: collision with root package name */
        private long f2847d = -1;

        public a(s sVar, s.a aVar) {
            this.a = sVar;
            this.f2845b = aVar;
        }

        @Override // com.google.android.exoplayer2.o2.k0.g
        public long a(k kVar) {
            long j = this.f2847d;
            if (j < 0) {
                return -1L;
            }
            long j2 = -(j + 2);
            this.f2847d = -1L;
            return j2;
        }

        @Override // com.google.android.exoplayer2.o2.k0.g
        public y b() {
            g.g(this.f2846c != -1);
            return new r(this.a, this.f2846c);
        }

        @Override // com.google.android.exoplayer2.o2.k0.g
        public void c(long j) {
            long[] jArr = this.f2845b.a;
            this.f2847d = jArr[o0.h(jArr, j, true, true)];
        }

        public void d(long j) {
            this.f2846c = j;
        }
    }

    private int n(d0 d0Var) {
        int i = (d0Var.d()[2] & 255) >> 4;
        if (i == 6 || i == 7) {
            d0Var.Q(4);
            d0Var.K();
        }
        int j = p.j(d0Var, i);
        d0Var.P(0);
        return j;
    }

    private static boolean o(byte[] bArr) {
        return bArr[0] == -1;
    }

    public static boolean p(d0 d0Var) {
        return d0Var.a() >= 5 && d0Var.D() == 127 && d0Var.F() == 1179402563;
    }

    @Override // com.google.android.exoplayer2.o2.k0.i
    protected long f(d0 d0Var) {
        if (!o(d0Var.d())) {
            return -1L;
        }
        return n(d0Var);
    }

    @Override // com.google.android.exoplayer2.o2.k0.i
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected boolean i(d0 d0Var, long j, i.b bVar) {
        byte[] d2 = d0Var.d();
        s sVar = this.n;
        if (sVar == null) {
            s sVar2 = new s(d2, 17);
            this.n = sVar2;
            bVar.a = sVar2.h(Arrays.copyOfRange(d2, 9, d0Var.f()), null);
            return true;
        } else if ((d2[0] & Byte.MAX_VALUE) == 3) {
            s.a h = q.h(d0Var);
            s c2 = sVar.c(h);
            this.n = c2;
            this.o = new a(c2, h);
            return true;
        } else if (!o(d2)) {
            return true;
        } else {
            a aVar = this.o;
            if (aVar != null) {
                aVar.d(j);
                bVar.f2865b = this.o;
            }
            g.e(bVar.a);
            return false;
        }
    }

    @Override // com.google.android.exoplayer2.o2.k0.i
    protected void l(boolean z) {
        super.l(z);
        if (z) {
            this.n = null;
            this.o = null;
        }
    }
}

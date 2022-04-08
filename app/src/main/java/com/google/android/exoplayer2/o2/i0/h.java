package com.google.android.exoplayer2.o2.i0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.e0;
import com.google.android.exoplayer2.o2.y;
import com.google.android.exoplayer2.o2.z;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;

/* compiled from: VbriSeeker.java */
/* loaded from: classes.dex */
final class h implements g {
    private final long[] a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f2753b;

    /* renamed from: c  reason: collision with root package name */
    private final long f2754c;

    /* renamed from: d  reason: collision with root package name */
    private final long f2755d;

    private h(long[] jArr, long[] jArr2, long j, long j2) {
        this.a = jArr;
        this.f2753b = jArr2;
        this.f2754c = j;
        this.f2755d = j2;
    }

    @Nullable
    public static h b(long j, long j2, e0.a aVar, d0 d0Var) {
        int i;
        d0Var.Q(10);
        int n = d0Var.n();
        if (n <= 0) {
            return null;
        }
        int i2 = aVar.f2061d;
        long C0 = o0.C0(n, 1000000 * (i2 >= 32000 ? 1152 : 576), i2);
        int J = d0Var.J();
        int J2 = d0Var.J();
        int J3 = d0Var.J();
        d0Var.Q(2);
        long j3 = j2 + aVar.f2060c;
        long[] jArr = new long[J];
        long[] jArr2 = new long[J];
        int i3 = 0;
        long j4 = j2;
        while (i3 < J) {
            jArr[i3] = (i3 * C0) / J;
            jArr2[i3] = Math.max(j4, j3);
            if (J3 == 1) {
                i = d0Var.D();
            } else if (J3 == 2) {
                i = d0Var.J();
            } else if (J3 == 3) {
                i = d0Var.G();
            } else if (J3 != 4) {
                return null;
            } else {
                i = d0Var.H();
            }
            j4 += i * J2;
            i3++;
            j3 = j3;
            J2 = J2;
        }
        if (!(j == -1 || j == j4)) {
            StringBuilder sb = new StringBuilder(67);
            sb.append("VBRI data size mismatch: ");
            sb.append(j);
            sb.append(", ");
            sb.append(j4);
            u.h("VbriSeeker", sb.toString());
        }
        return new h(jArr, jArr2, C0, j4);
    }

    @Override // com.google.android.exoplayer2.o2.y
    public y.a a(long j) {
        int h = o0.h(this.a, j, true, true);
        z zVar = new z(this.a[h], this.f2753b[h]);
        if (zVar.f3078b >= j || h == this.a.length - 1) {
            return new y.a(zVar);
        }
        int i = h + 1;
        return new y.a(zVar, new z(this.a[i], this.f2753b[i]));
    }

    @Override // com.google.android.exoplayer2.o2.i0.g
    public long f() {
        return this.f2755d;
    }

    @Override // com.google.android.exoplayer2.o2.y
    public boolean g() {
        return true;
    }

    @Override // com.google.android.exoplayer2.o2.i0.g
    public long h(long j) {
        return this.a[o0.h(this.f2753b, j, true, true)];
    }

    @Override // com.google.android.exoplayer2.o2.y
    public long i() {
        return this.f2754c;
    }
}

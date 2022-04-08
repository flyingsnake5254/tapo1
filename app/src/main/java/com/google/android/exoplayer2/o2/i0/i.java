package com.google.android.exoplayer2.o2.i0;

import androidx.annotation.Nullable;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.exoplayer2.audio.e0;
import com.google.android.exoplayer2.o2.y;
import com.google.android.exoplayer2.o2.z;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;

/* compiled from: XingSeeker.java */
/* loaded from: classes.dex */
final class i implements g {
    private final long a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2756b;

    /* renamed from: c  reason: collision with root package name */
    private final long f2757c;

    /* renamed from: d  reason: collision with root package name */
    private final long f2758d;

    /* renamed from: e  reason: collision with root package name */
    private final long f2759e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final long[] f2760f;

    private i(long j, int i, long j2) {
        this(j, i, j2, -1L, null);
    }

    @Nullable
    public static i b(long j, long j2, e0.a aVar, d0 d0Var) {
        int H;
        int i = aVar.g;
        int i2 = aVar.f2061d;
        int n = d0Var.n();
        if ((n & 1) != 1 || (H = d0Var.H()) == 0) {
            return null;
        }
        long C0 = o0.C0(H, i * 1000000, i2);
        if ((n & 6) != 6) {
            return new i(j2, aVar.f2060c, C0);
        }
        long F = d0Var.F();
        long[] jArr = new long[100];
        for (int i3 = 0; i3 < 100; i3++) {
            jArr[i3] = d0Var.D();
        }
        if (j != -1) {
            long j3 = j2 + F;
            if (j != j3) {
                StringBuilder sb = new StringBuilder(67);
                sb.append("XING data size mismatch: ");
                sb.append(j);
                sb.append(", ");
                sb.append(j3);
                u.h("XingSeeker", sb.toString());
            }
        }
        return new i(j2, aVar.f2060c, C0, F, jArr);
    }

    private long c(int i) {
        return (this.f2757c * i) / 100;
    }

    @Override // com.google.android.exoplayer2.o2.y
    public y.a a(long j) {
        long[] jArr;
        if (!g()) {
            return new y.a(new z(0L, this.a + this.f2756b));
        }
        long q = o0.q(j, 0L, this.f2757c);
        double d2 = (q * 100.0d) / this.f2757c;
        double d3 = Utils.DOUBLE_EPSILON;
        if (d2 > Utils.DOUBLE_EPSILON) {
            if (d2 >= 100.0d) {
                d3 = 256.0d;
            } else {
                int i = (int) d2;
                double d4 = ((long[]) g.i(this.f2760f))[i];
                d3 = d4 + ((d2 - i) * ((i == 99 ? 256.0d : jArr[i + 1]) - d4));
            }
        }
        return new y.a(new z(q, this.a + o0.q(Math.round((d3 / 256.0d) * this.f2758d), this.f2756b, this.f2758d - 1)));
    }

    @Override // com.google.android.exoplayer2.o2.i0.g
    public long f() {
        return this.f2759e;
    }

    @Override // com.google.android.exoplayer2.o2.y
    public boolean g() {
        return this.f2760f != null;
    }

    @Override // com.google.android.exoplayer2.o2.i0.g
    public long h(long j) {
        long j2 = j - this.a;
        if (!g() || j2 <= this.f2756b) {
            return 0L;
        }
        long[] jArr = (long[]) g.i(this.f2760f);
        double d2 = (j2 * 256.0d) / this.f2758d;
        int h = o0.h(jArr, (long) d2, true, true);
        long c2 = c(h);
        long j3 = jArr[h];
        int i = h + 1;
        long c3 = c(i);
        long j4 = h == 99 ? 256L : jArr[i];
        return c2 + Math.round((j3 == j4 ? Utils.DOUBLE_EPSILON : (d2 - j3) / (j4 - j3)) * (c3 - c2));
    }

    @Override // com.google.android.exoplayer2.o2.y
    public long i() {
        return this.f2757c;
    }

    private i(long j, int i, long j2, long j3, @Nullable long[] jArr) {
        this.a = j;
        this.f2756b = i;
        this.f2757c = j2;
        this.f2760f = jArr;
        this.f2758d = j3;
        this.f2759e = j3 != -1 ? j + j3 : -1L;
    }
}

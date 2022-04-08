package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;

/* compiled from: SeekParameters.java */
/* loaded from: classes.dex */
public final class g2 {
    public static final g2 a;

    /* renamed from: b  reason: collision with root package name */
    public static final g2 f2300b = new g2(Long.MAX_VALUE, Long.MAX_VALUE);

    /* renamed from: c  reason: collision with root package name */
    public static final g2 f2301c = new g2(Long.MAX_VALUE, 0);

    /* renamed from: d  reason: collision with root package name */
    public static final g2 f2302d = new g2(0, Long.MAX_VALUE);

    /* renamed from: e  reason: collision with root package name */
    public static final g2 f2303e;

    /* renamed from: f  reason: collision with root package name */
    public final long f2304f;
    public final long g;

    static {
        g2 g2Var = new g2(0L, 0L);
        a = g2Var;
        f2303e = g2Var;
    }

    public g2(long j, long j2) {
        boolean z = true;
        g.a(j >= 0);
        g.a(j2 < 0 ? false : z);
        this.f2304f = j;
        this.g = j2;
    }

    public long a(long j, long j2, long j3) {
        long j4 = this.f2304f;
        if (j4 == 0 && this.g == 0) {
            return j;
        }
        long I0 = o0.I0(j, j4, Long.MIN_VALUE);
        long a2 = o0.a(j, this.g, Long.MAX_VALUE);
        boolean z = true;
        boolean z2 = I0 <= j2 && j2 <= a2;
        if (I0 > j3 || j3 > a2) {
            z = false;
        }
        return (!z2 || !z) ? z2 ? j2 : z ? j3 : I0 : Math.abs(j2 - j) <= Math.abs(j3 - j) ? j2 : j3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g2.class != obj.getClass()) {
            return false;
        }
        g2 g2Var = (g2) obj;
        return this.f2304f == g2Var.f2304f && this.g == g2Var.g;
    }

    public int hashCode() {
        return (((int) this.f2304f) * 31) + ((int) this.g);
    }
}

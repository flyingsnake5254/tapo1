package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.e0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;

/* compiled from: MediaPeriodInfo.java */
/* loaded from: classes.dex */
final class o1 {
    public final e0.a a;

    /* renamed from: b  reason: collision with root package name */
    public final long f2625b;

    /* renamed from: c  reason: collision with root package name */
    public final long f2626c;

    /* renamed from: d  reason: collision with root package name */
    public final long f2627d;

    /* renamed from: e  reason: collision with root package name */
    public final long f2628e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f2629f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o1(e0.a aVar, long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        g.a(!z4 || z2);
        g.a(!z3 || z2);
        if (!z || (!z2 && !z3 && !z4)) {
            z5 = true;
        }
        g.a(z5);
        this.a = aVar;
        this.f2625b = j;
        this.f2626c = j2;
        this.f2627d = j3;
        this.f2628e = j4;
        this.f2629f = z;
        this.g = z2;
        this.h = z3;
        this.i = z4;
    }

    public o1 a(long j) {
        if (j == this.f2626c) {
            return this;
        }
        return new o1(this.a, this.f2625b, j, this.f2627d, this.f2628e, this.f2629f, this.g, this.h, this.i);
    }

    public o1 b(long j) {
        if (j == this.f2625b) {
            return this;
        }
        return new o1(this.a, j, this.f2626c, this.f2627d, this.f2628e, this.f2629f, this.g, this.h, this.i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o1.class != obj.getClass()) {
            return false;
        }
        o1 o1Var = (o1) obj;
        return this.f2625b == o1Var.f2625b && this.f2626c == o1Var.f2626c && this.f2627d == o1Var.f2627d && this.f2628e == o1Var.f2628e && this.f2629f == o1Var.f2629f && this.g == o1Var.g && this.h == o1Var.h && this.i == o1Var.i && o0.b(this.a, o1Var.a);
    }

    public int hashCode() {
        return ((((((((((((((((527 + this.a.hashCode()) * 31) + ((int) this.f2625b)) * 31) + ((int) this.f2626c)) * 31) + ((int) this.f2627d)) * 31) + ((int) this.f2628e)) * 31) + (this.f2629f ? 1 : 0)) * 31) + (this.g ? 1 : 0)) * 31) + (this.h ? 1 : 0)) * 31) + (this.i ? 1 : 0);
    }
}

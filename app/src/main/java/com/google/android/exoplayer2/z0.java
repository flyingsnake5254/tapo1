package com.google.android.exoplayer2;

import android.os.SystemClock;
import com.google.android.exoplayer2.l1;
import com.google.android.exoplayer2.util.o0;
import com.google.common.primitives.e;

/* compiled from: DefaultLivePlaybackSpeedControl.java */
/* loaded from: classes.dex */
public final class z0 implements j1 {
    private final float a;

    /* renamed from: b  reason: collision with root package name */
    private final float f4095b;

    /* renamed from: c  reason: collision with root package name */
    private final long f4096c;

    /* renamed from: d  reason: collision with root package name */
    private final float f4097d;

    /* renamed from: e  reason: collision with root package name */
    private final long f4098e;

    /* renamed from: f  reason: collision with root package name */
    private final long f4099f;
    private final float g;
    private long h;
    private long i;
    private long j;
    private long k;
    private long l;
    private long m;
    private float n;
    private float o;
    private float p;
    private long q;
    private long r;
    private long s;

    /* compiled from: DefaultLivePlaybackSpeedControl.java */
    /* loaded from: classes.dex */
    public static final class b {
        private float a = 0.97f;

        /* renamed from: b  reason: collision with root package name */
        private float f4100b = 1.03f;

        /* renamed from: c  reason: collision with root package name */
        private long f4101c = 1000;

        /* renamed from: d  reason: collision with root package name */
        private float f4102d = 1.0E-7f;

        /* renamed from: e  reason: collision with root package name */
        private long f4103e = w0.d(20);

        /* renamed from: f  reason: collision with root package name */
        private long f4104f = w0.d(500);
        private float g = 0.999f;

        public z0 a() {
            return new z0(this.a, this.f4100b, this.f4101c, this.f4102d, this.f4103e, this.f4104f, this.g);
        }
    }

    private void f(long j) {
        long j2 = this.r + (this.s * 3);
        if (this.m > j2) {
            float d2 = (float) w0.d(this.f4096c);
            this.m = e.h(j2, this.j, this.m - (((this.p - 1.0f) * d2) + ((this.n - 1.0f) * d2)));
            return;
        }
        long q = o0.q(j - (Math.max(0.0f, this.p - 1.0f) / this.f4097d), this.m, j2);
        this.m = q;
        long j3 = this.l;
        if (j3 != -9223372036854775807L && q > j3) {
            this.m = j3;
        }
    }

    private void g() {
        long j = this.h;
        if (j != -9223372036854775807L) {
            long j2 = this.i;
            if (j2 != -9223372036854775807L) {
                j = j2;
            }
            long j3 = this.k;
            if (j3 != -9223372036854775807L && j < j3) {
                j = j3;
            }
            long j4 = this.l;
            if (j4 != -9223372036854775807L && j > j4) {
                j = j4;
            }
        } else {
            j = -9223372036854775807L;
        }
        if (this.j != j) {
            this.j = j;
            this.m = j;
            this.r = -9223372036854775807L;
            this.s = -9223372036854775807L;
            this.q = -9223372036854775807L;
        }
    }

    private static long h(long j, long j2, float f2) {
        return (((float) j) * f2) + ((1.0f - f2) * ((float) j2));
    }

    private void i(long j, long j2) {
        long j3 = j - j2;
        long j4 = this.r;
        if (j4 == -9223372036854775807L) {
            this.r = j3;
            this.s = 0L;
            return;
        }
        long max = Math.max(j3, h(j4, j3, this.g));
        this.r = max;
        this.s = h(this.s, Math.abs(j3 - max), this.g);
    }

    @Override // com.google.android.exoplayer2.j1
    public void a(l1.f fVar) {
        this.h = w0.d(fVar.f2366c);
        this.k = w0.d(fVar.f2367d);
        this.l = w0.d(fVar.f2368e);
        float f2 = fVar.f2369f;
        if (f2 == -3.4028235E38f) {
            f2 = this.a;
        }
        this.o = f2;
        float f3 = fVar.g;
        if (f3 == -3.4028235E38f) {
            f3 = this.f4095b;
        }
        this.n = f3;
        g();
    }

    @Override // com.google.android.exoplayer2.j1
    public float b(long j, long j2) {
        if (this.h == -9223372036854775807L) {
            return 1.0f;
        }
        i(j, j2);
        if (this.q != -9223372036854775807L && SystemClock.elapsedRealtime() - this.q < this.f4096c) {
            return this.p;
        }
        this.q = SystemClock.elapsedRealtime();
        f(j);
        long j3 = j - this.m;
        if (Math.abs(j3) < this.f4098e) {
            this.p = 1.0f;
        } else {
            this.p = o0.o((this.f4097d * ((float) j3)) + 1.0f, this.o, this.n);
        }
        return this.p;
    }

    @Override // com.google.android.exoplayer2.j1
    public long c() {
        return this.m;
    }

    @Override // com.google.android.exoplayer2.j1
    public void d() {
        long j = this.m;
        if (j != -9223372036854775807L) {
            long j2 = j + this.f4099f;
            this.m = j2;
            long j3 = this.l;
            if (j3 != -9223372036854775807L && j2 > j3) {
                this.m = j3;
            }
            this.q = -9223372036854775807L;
        }
    }

    @Override // com.google.android.exoplayer2.j1
    public void e(long j) {
        this.i = j;
        g();
    }

    private z0(float f2, float f3, long j, float f4, long j2, long j3, float f5) {
        this.a = f2;
        this.f4095b = f3;
        this.f4096c = j;
        this.f4097d = f4;
        this.f4098e = j2;
        this.f4099f = j3;
        this.g = f5;
        this.h = -9223372036854775807L;
        this.i = -9223372036854775807L;
        this.k = -9223372036854775807L;
        this.l = -9223372036854775807L;
        this.o = f2;
        this.n = f3;
        this.p = 1.0f;
        this.q = -9223372036854775807L;
        this.j = -9223372036854775807L;
        this.m = -9223372036854775807L;
        this.r = -9223372036854775807L;
        this.s = -9223372036854775807L;
    }
}

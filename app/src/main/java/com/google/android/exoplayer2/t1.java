package com.google.android.exoplayer2;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;

/* compiled from: PlaybackParameters.java */
/* loaded from: classes.dex */
public final class t1 {
    public static final t1 a = new t1(1.0f);

    /* renamed from: b  reason: collision with root package name */
    public static final v0<t1> f3436b = i0.a;

    /* renamed from: c  reason: collision with root package name */
    public final float f3437c;

    /* renamed from: d  reason: collision with root package name */
    public final float f3438d;

    /* renamed from: e  reason: collision with root package name */
    private final int f3439e;

    public t1(float f2) {
        this(f2, 1.0f);
    }

    public long a(long j) {
        return j * this.f3439e;
    }

    @CheckResult
    public t1 b(float f2) {
        return new t1(f2, this.f3438d);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || t1.class != obj.getClass()) {
            return false;
        }
        t1 t1Var = (t1) obj;
        return this.f3437c == t1Var.f3437c && this.f3438d == t1Var.f3438d;
    }

    public int hashCode() {
        return ((527 + Float.floatToRawIntBits(this.f3437c)) * 31) + Float.floatToRawIntBits(this.f3438d);
    }

    public String toString() {
        return o0.A("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.f3437c), Float.valueOf(this.f3438d));
    }

    public t1(float f2, float f3) {
        boolean z = true;
        g.a(f2 > 0.0f);
        g.a(f3 <= 0.0f ? false : z);
        this.f3437c = f2;
        this.f3438d = f3;
        this.f3439e = Math.round(f2 * 1000.0f);
    }
}

package com.google.android.exoplayer2.video;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.exoplayer2.v0;

/* compiled from: VideoSize.java */
/* loaded from: classes.dex */
public final class z {
    public static final z a = new z(0, 0);

    /* renamed from: b  reason: collision with root package name */
    public static final v0<z> f4076b = l.a;
    @IntRange(from = 0)

    /* renamed from: c  reason: collision with root package name */
    public final int f4077c;
    @IntRange(from = 0)

    /* renamed from: d  reason: collision with root package name */
    public final int f4078d;
    @IntRange(from = 0, to = 359)

    /* renamed from: e  reason: collision with root package name */
    public final int f4079e;
    @FloatRange(from = Utils.DOUBLE_EPSILON, fromInclusive = false)

    /* renamed from: f  reason: collision with root package name */
    public final float f4080f;

    public z(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        this(i, i2, 0, 1.0f);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return this.f4077c == zVar.f4077c && this.f4078d == zVar.f4078d && this.f4079e == zVar.f4079e && this.f4080f == zVar.f4080f;
    }

    public int hashCode() {
        return ((((((217 + this.f4077c) * 31) + this.f4078d) * 31) + this.f4079e) * 31) + Float.floatToRawIntBits(this.f4080f);
    }

    public z(@IntRange(from = 0) int i, @IntRange(from = 0) int i2, @IntRange(from = 0, to = 359) int i3, @FloatRange(from = 0.0d, fromInclusive = false) float f2) {
        this.f4077c = i;
        this.f4078d = i2;
        this.f4079e = i3;
        this.f4080f = f2;
    }
}

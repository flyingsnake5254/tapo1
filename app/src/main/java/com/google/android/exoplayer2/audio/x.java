package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;

/* compiled from: AuxEffectInfo.java */
/* loaded from: classes.dex */
public final class x {
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final float f2134b;

    public x(int i, float f2) {
        this.a = i;
        this.f2134b = f2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || x.class != obj.getClass()) {
            return false;
        }
        x xVar = (x) obj;
        return this.a == xVar.a && Float.compare(xVar.f2134b, this.f2134b) == 0;
    }

    public int hashCode() {
        return ((527 + this.a) * 31) + Float.floatToIntBits(this.f2134b);
    }
}

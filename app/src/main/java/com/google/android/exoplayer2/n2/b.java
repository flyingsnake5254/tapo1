package com.google.android.exoplayer2.n2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.v0;

/* compiled from: DeviceInfo.java */
/* loaded from: classes.dex */
public final class b {
    public static final b a = new b(0, 0, 0);

    /* renamed from: b  reason: collision with root package name */
    public static final v0<b> f2619b = a.a;

    /* renamed from: c  reason: collision with root package name */
    public final int f2620c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2621d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2622e;

    public b(int i, int i2, int i3) {
        this.f2620c = i;
        this.f2621d = i2;
        this.f2622e = i3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f2620c == bVar.f2620c && this.f2621d == bVar.f2621d && this.f2622e == bVar.f2622e;
    }

    public int hashCode() {
        return ((((527 + this.f2620c) * 31) + this.f2621d) * 31) + this.f2622e;
    }
}

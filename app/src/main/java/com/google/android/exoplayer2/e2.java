package com.google.android.exoplayer2;

import androidx.annotation.Nullable;

/* compiled from: RendererConfiguration.java */
/* loaded from: classes.dex */
public final class e2 {
    public static final e2 a = new e2(false);

    /* renamed from: b  reason: collision with root package name */
    public final boolean f2248b;

    public e2(boolean z) {
        this.f2248b = z;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && e2.class == obj.getClass() && this.f2248b == ((e2) obj).f2248b;
    }

    public int hashCode() {
        return !this.f2248b ? 1 : 0;
    }
}

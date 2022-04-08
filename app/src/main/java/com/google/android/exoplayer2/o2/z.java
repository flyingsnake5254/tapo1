package com.google.android.exoplayer2.o2;

import androidx.annotation.Nullable;

/* compiled from: SeekPoint.java */
/* loaded from: classes.dex */
public final class z {
    public static final z a = new z(0, 0);

    /* renamed from: b  reason: collision with root package name */
    public final long f3078b;

    /* renamed from: c  reason: collision with root package name */
    public final long f3079c;

    public z(long j, long j2) {
        this.f3078b = j;
        this.f3079c = j2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || z.class != obj.getClass()) {
            return false;
        }
        z zVar = (z) obj;
        return this.f3078b == zVar.f3078b && this.f3079c == zVar.f3079c;
    }

    public int hashCode() {
        return (((int) this.f3078b) * 31) + ((int) this.f3079c);
    }

    public String toString() {
        long j = this.f3078b;
        long j2 = this.f3079c;
        StringBuilder sb = new StringBuilder(60);
        sb.append("[timeUs=");
        sb.append(j);
        sb.append(", position=");
        sb.append(j2);
        sb.append("]");
        return sb.toString();
    }
}

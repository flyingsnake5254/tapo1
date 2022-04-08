package com.tplink.iot.h.h;

import androidx.annotation.NonNull;

/* compiled from: M3U8Ts.java */
/* loaded from: classes2.dex */
public class b implements Comparable<b> {

    /* renamed from: c  reason: collision with root package name */
    private String f7995c;

    /* renamed from: d  reason: collision with root package name */
    private float f7996d;

    /* renamed from: f  reason: collision with root package name */
    private long f7997f;

    public b(String str, float f2, long j) {
        this.f7995c = str;
        this.f7996d = f2;
        this.f7997f = j;
    }

    /* renamed from: a */
    public int compareTo(@NonNull b bVar) {
        return this.f7995c.compareTo(bVar.f7995c);
    }

    public long b() {
        return this.f7997f;
    }

    public float c() {
        return this.f7996d;
    }

    public String toString() {
        return this.f7995c + " (" + this.f7996d + "sec)";
    }
}

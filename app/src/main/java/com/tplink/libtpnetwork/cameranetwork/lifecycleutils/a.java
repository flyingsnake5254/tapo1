package com.tplink.libtpnetwork.cameranetwork.lifecycleutils;

import androidx.annotation.Nullable;

/* compiled from: Event.java */
/* loaded from: classes3.dex */
public class a<T> {
    private T a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f14936b;

    public a(T t) {
        this.f14936b = false;
        if (t != null) {
            this.a = t;
            return;
        }
        throw new IllegalArgumentException("null values in Event are not allowed.");
    }

    @Nullable
    public T a() {
        if (this.f14936b) {
            return null;
        }
        this.f14936b = true;
        return this.a;
    }

    public boolean b() {
        return this.f14936b;
    }

    public T c() {
        return this.a;
    }

    public a(T t, boolean z) {
        this.f14936b = false;
        if (t != null) {
            this.a = t;
            this.f14936b = z;
            return;
        }
        throw new IllegalArgumentException("null values in Event are not allowed.");
    }
}

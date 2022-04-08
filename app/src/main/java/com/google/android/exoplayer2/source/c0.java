package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;

/* compiled from: MediaPeriodId.java */
/* loaded from: classes.dex */
public class c0 {
    public final Object a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3203b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3204c;

    /* renamed from: d  reason: collision with root package name */
    public final long f3205d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3206e;

    public c0(Object obj) {
        this(obj, -1L);
    }

    public c0 a(Object obj) {
        return this.a.equals(obj) ? this : new c0(obj, this.f3203b, this.f3204c, this.f3205d, this.f3206e);
    }

    public boolean b() {
        return this.f3203b != -1;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return this.a.equals(c0Var.a) && this.f3203b == c0Var.f3203b && this.f3204c == c0Var.f3204c && this.f3205d == c0Var.f3205d && this.f3206e == c0Var.f3206e;
    }

    public int hashCode() {
        return ((((((((527 + this.a.hashCode()) * 31) + this.f3203b) * 31) + this.f3204c) * 31) + ((int) this.f3205d)) * 31) + this.f3206e;
    }

    public c0(Object obj, long j) {
        this(obj, -1, -1, j, -1);
    }

    public c0(Object obj, long j, int i) {
        this(obj, -1, -1, j, i);
    }

    public c0(Object obj, int i, int i2, long j) {
        this(obj, i, i2, j, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c0(c0 c0Var) {
        this.a = c0Var.a;
        this.f3203b = c0Var.f3203b;
        this.f3204c = c0Var.f3204c;
        this.f3205d = c0Var.f3205d;
        this.f3206e = c0Var.f3206e;
    }

    private c0(Object obj, int i, int i2, long j, int i3) {
        this.a = obj;
        this.f3203b = i;
        this.f3204c = i2;
        this.f3205d = j;
        this.f3206e = i3;
    }
}

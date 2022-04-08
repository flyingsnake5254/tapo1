package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: MultiClassKey.java */
/* loaded from: classes.dex */
public class h {
    private Class<?> a;

    /* renamed from: b  reason: collision with root package name */
    private Class<?> f1776b;

    /* renamed from: c  reason: collision with root package name */
    private Class<?> f1777c;

    public h() {
    }

    public void a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.a = cls;
        this.f1776b = cls2;
        this.f1777c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        return this.a.equals(hVar.a) && this.f1776b.equals(hVar.f1776b) && j.d(this.f1777c, hVar.f1777c);
    }

    public int hashCode() {
        int hashCode = ((this.a.hashCode() * 31) + this.f1776b.hashCode()) * 31;
        Class<?> cls = this.f1777c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.a + ", second=" + this.f1776b + '}';
    }

    public h(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        a(cls, cls2, cls3);
    }
}

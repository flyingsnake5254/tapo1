package com.google.android.datatransport.h.u.a;

/* compiled from: InstanceFactory.java */
/* loaded from: classes.dex */
public final class c<T> implements b<T> {
    private static final c<Object> a = new c<>(null);

    /* renamed from: b  reason: collision with root package name */
    private final T f1896b;

    private c(T t) {
        this.f1896b = t;
    }

    public static <T> b<T> a(T t) {
        return new c(d.c(t, "instance cannot be null"));
    }

    @Override // d.a.a
    public T get() {
        return this.f1896b;
    }
}

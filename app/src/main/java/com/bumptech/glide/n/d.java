package com.bumptech.glide.n;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.util.h;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ModelToResourceClassCache.java */
/* loaded from: classes.dex */
public class d {
    private final AtomicReference<h> a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    private final ArrayMap<h, List<Class<?>>> f1707b = new ArrayMap<>();

    @Nullable
    public List<Class<?>> a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3) {
        List<Class<?>> list;
        h andSet = this.a.getAndSet(null);
        if (andSet == null) {
            andSet = new h(cls, cls2, cls3);
        } else {
            andSet.a(cls, cls2, cls3);
        }
        synchronized (this.f1707b) {
            list = this.f1707b.get(andSet);
        }
        this.a.set(andSet);
        return list;
    }

    public void b(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3, @NonNull List<Class<?>> list) {
        synchronized (this.f1707b) {
            this.f1707b.put(new h(cls, cls2, cls3), list);
        }
    }
}

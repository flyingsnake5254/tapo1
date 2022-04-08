package com.bumptech.glide.load.k;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.util.i;

/* compiled from: SimpleResource.java */
/* loaded from: classes.dex */
public class b<T> implements u<T> {

    /* renamed from: c  reason: collision with root package name */
    protected final T f1605c;

    public b(@NonNull T t) {
        this.f1605c = (T) i.d(t);
    }

    @Override // com.bumptech.glide.load.engine.u
    public final int a() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.u
    public void c() {
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    public Class<T> e() {
        return (Class<T>) this.f1605c.getClass();
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    public final T get() {
        return this.f1605c;
    }
}

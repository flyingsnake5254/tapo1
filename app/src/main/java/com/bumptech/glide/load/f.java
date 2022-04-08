package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;

/* compiled from: Options.java */
/* loaded from: classes.dex */
public final class f implements c {

    /* renamed from: b  reason: collision with root package name */
    private final ArrayMap<e<?>, Object> f1543b = new CachedHashCodeArrayMap();

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void f(@NonNull e<T> eVar, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        eVar.g(obj, messageDigest);
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        for (int i = 0; i < this.f1543b.size(); i++) {
            f(this.f1543b.keyAt(i), this.f1543b.valueAt(i), messageDigest);
        }
    }

    @Nullable
    public <T> T c(@NonNull e<T> eVar) {
        return this.f1543b.containsKey(eVar) ? (T) this.f1543b.get(eVar) : eVar.c();
    }

    public void d(@NonNull f fVar) {
        this.f1543b.putAll((SimpleArrayMap<? extends e<?>, ? extends Object>) fVar.f1543b);
    }

    @NonNull
    public <T> f e(@NonNull e<T> eVar, @NonNull T t) {
        this.f1543b.put(eVar, t);
        return this;
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f1543b.equals(((f) obj).f1543b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.f1543b.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f1543b + '}';
    }
}

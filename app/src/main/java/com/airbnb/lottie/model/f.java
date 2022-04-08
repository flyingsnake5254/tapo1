package com.airbnb.lottie.model;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import com.airbnb.lottie.d;

/* compiled from: LottieCompositionCache.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class f {
    private static final f a = new f();

    /* renamed from: b  reason: collision with root package name */
    private final LruCache<String, d> f1016b = new LruCache<>(20);

    @VisibleForTesting
    f() {
    }

    public static f b() {
        return a;
    }

    @Nullable
    public d a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.f1016b.get(str);
    }

    public void c(@Nullable String str, d dVar) {
        if (str != null) {
            this.f1016b.put(str, dVar);
        }
    }
}

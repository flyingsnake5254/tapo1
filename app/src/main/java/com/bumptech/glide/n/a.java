package com.bumptech.glide.n;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: EncoderRegistry.java */
/* loaded from: classes.dex */
public class a {
    private final List<C0063a<?>> a = new ArrayList();

    /* compiled from: EncoderRegistry.java */
    /* renamed from: com.bumptech.glide.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static final class C0063a<T> {
        private final Class<T> a;

        /* renamed from: b  reason: collision with root package name */
        final com.bumptech.glide.load.a<T> f1704b;

        C0063a(@NonNull Class<T> cls, @NonNull com.bumptech.glide.load.a<T> aVar) {
            this.a = cls;
            this.f1704b = aVar;
        }

        boolean a(@NonNull Class<?> cls) {
            return this.a.isAssignableFrom(cls);
        }
    }

    public synchronized <T> void a(@NonNull Class<T> cls, @NonNull com.bumptech.glide.load.a<T> aVar) {
        this.a.add(new C0063a<>(cls, aVar));
    }

    @Nullable
    public synchronized <T> com.bumptech.glide.load.a<T> b(@NonNull Class<T> cls) {
        for (C0063a<?> aVar : this.a) {
            if (aVar.a(cls)) {
                return (com.bumptech.glide.load.a<T>) aVar.f1704b;
            }
        }
        return null;
    }
}

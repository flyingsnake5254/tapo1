package com.bumptech.glide.n;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.h;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ResourceEncoderRegistry.java */
/* loaded from: classes.dex */
public class f {
    private final List<a<?>> a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ResourceEncoderRegistry.java */
    /* loaded from: classes.dex */
    public static final class a<T> {
        private final Class<T> a;

        /* renamed from: b  reason: collision with root package name */
        final h<T> f1711b;

        a(@NonNull Class<T> cls, @NonNull h<T> hVar) {
            this.a = cls;
            this.f1711b = hVar;
        }

        boolean a(@NonNull Class<?> cls) {
            return this.a.isAssignableFrom(cls);
        }
    }

    public synchronized <Z> void a(@NonNull Class<Z> cls, @NonNull h<Z> hVar) {
        this.a.add(new a<>(cls, hVar));
    }

    @Nullable
    public synchronized <Z> h<Z> b(@NonNull Class<Z> cls) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            a<?> aVar = this.a.get(i);
            if (aVar.a(cls)) {
                return (h<Z>) aVar.f1711b;
            }
        }
        return null;
    }
}

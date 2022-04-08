package com.bumptech.glide.load.j;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ModelLoaderRegistry.java */
/* loaded from: classes.dex */
public class p {
    private final r a;

    /* renamed from: b  reason: collision with root package name */
    private final a f1576b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ModelLoaderRegistry.java */
    /* loaded from: classes.dex */
    public static class a {
        private final Map<Class<?>, C0056a<?>> a = new HashMap();

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: ModelLoaderRegistry.java */
        /* renamed from: com.bumptech.glide.load.j.p$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0056a<Model> {
            final List<n<Model, ?>> a;

            public C0056a(List<n<Model, ?>> list) {
                this.a = list;
            }
        }

        a() {
        }

        public void a() {
            this.a.clear();
        }

        @Nullable
        public <Model> List<n<Model, ?>> b(Class<Model> cls) {
            C0056a<?> aVar = this.a.get(cls);
            if (aVar == null) {
                return null;
            }
            return (List<n<Model, ?>>) aVar.a;
        }

        public <Model> void c(Class<Model> cls, List<n<Model, ?>> list) {
            if (this.a.put(cls, new C0056a<>(list)) != null) {
                throw new IllegalStateException("Already cached loaders for model: " + cls);
            }
        }
    }

    public p(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(new r(pool));
    }

    @NonNull
    private static <A> Class<A> b(@NonNull A a2) {
        return (Class<A>) a2.getClass();
    }

    @NonNull
    private synchronized <A> List<n<A, ?>> e(@NonNull Class<A> cls) {
        List<n<A, ?>> b2;
        b2 = this.f1576b.b(cls);
        if (b2 == null) {
            b2 = Collections.unmodifiableList(this.a.e(cls));
            this.f1576b.c(cls, b2);
        }
        return b2;
    }

    private <Model, Data> void g(@NonNull List<o<? extends Model, ? extends Data>> list) {
        for (o<? extends Model, ? extends Data> oVar : list) {
            oVar.a();
        }
    }

    public synchronized <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        this.a.b(cls, cls2, oVar);
        this.f1576b.a();
    }

    @NonNull
    public synchronized List<Class<?>> c(@NonNull Class<?> cls) {
        return this.a.g(cls);
    }

    @NonNull
    public <A> List<n<A, ?>> d(@NonNull A a2) {
        List<n<A, ?>> e2 = e(b(a2));
        if (!e2.isEmpty()) {
            int size = e2.size();
            List<n<A, ?>> emptyList = Collections.emptyList();
            boolean z = true;
            for (int i = 0; i < size; i++) {
                n<A, ?> nVar = e2.get(i);
                if (nVar.a(a2)) {
                    if (z) {
                        emptyList = new ArrayList<>(size - i);
                        z = false;
                    }
                    emptyList.add(nVar);
                }
            }
            if (!emptyList.isEmpty()) {
                return emptyList;
            }
            throw new Registry.NoModelLoaderAvailableException(a2, e2);
        }
        throw new Registry.NoModelLoaderAvailableException(a2);
    }

    public synchronized <Model, Data> void f(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        g(this.a.j(cls, cls2, oVar));
        this.f1576b.a();
    }

    private p(@NonNull r rVar) {
        this.f1576b = new a();
        this.a = rVar;
    }
}

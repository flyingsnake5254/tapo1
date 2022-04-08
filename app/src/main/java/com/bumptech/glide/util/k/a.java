package com.bumptech.glide.util.k;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FactoryPools.java */
/* loaded from: classes.dex */
public final class a {
    private static final g<Object> a = new C0068a();

    /* compiled from: FactoryPools.java */
    /* renamed from: com.bumptech.glide.util.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0068a implements g<Object> {
        C0068a() {
        }

        @Override // com.bumptech.glide.util.k.a.g
        public void a(@NonNull Object obj) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FactoryPools.java */
    /* loaded from: classes.dex */
    public class b implements d<List<T>> {
        b() {
        }

        @NonNull
        /* renamed from: a */
        public List<T> c() {
            return new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FactoryPools.java */
    /* loaded from: classes.dex */
    public class c implements g<List<T>> {
        c() {
        }

        /* renamed from: b */
        public void a(@NonNull List<T> list) {
            list.clear();
        }
    }

    /* compiled from: FactoryPools.java */
    /* loaded from: classes.dex */
    public interface d<T> {
        T c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FactoryPools.java */
    /* loaded from: classes.dex */
    public static final class e<T> implements Pools.Pool<T> {
        private final d<T> a;

        /* renamed from: b  reason: collision with root package name */
        private final g<T> f1780b;

        /* renamed from: c  reason: collision with root package name */
        private final Pools.Pool<T> f1781c;

        e(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar, @NonNull g<T> gVar) {
            this.f1781c = pool;
            this.a = dVar;
            this.f1780b = gVar;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            T acquire = this.f1781c.acquire();
            if (acquire == null) {
                acquire = this.a.c();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + acquire.getClass());
                }
            }
            if (acquire instanceof f) {
                ((f) acquire).d().b(false);
            }
            return acquire;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t) {
            if (t instanceof f) {
                ((f) t).d().b(true);
            }
            this.f1780b.a(t);
            return this.f1781c.release(t);
        }
    }

    /* compiled from: FactoryPools.java */
    /* loaded from: classes.dex */
    public interface f {
        @NonNull
        c d();
    }

    /* compiled from: FactoryPools.java */
    /* loaded from: classes.dex */
    public interface g<T> {
        void a(@NonNull T t);
    }

    @NonNull
    private static <T extends f> Pools.Pool<T> a(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar) {
        return b(pool, dVar, c());
    }

    @NonNull
    private static <T> Pools.Pool<T> b(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar, @NonNull g<T> gVar) {
        return new e(pool, dVar, gVar);
    }

    @NonNull
    private static <T> g<T> c() {
        return (g<T>) a;
    }

    @NonNull
    public static <T extends f> Pools.Pool<T> d(int i, @NonNull d<T> dVar) {
        return a(new Pools.SynchronizedPool(i), dVar);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> e() {
        return f(20);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> f(int i) {
        return b(new Pools.SynchronizedPool(i), new b(), new c());
    }
}

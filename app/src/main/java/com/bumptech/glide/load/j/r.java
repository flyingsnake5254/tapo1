package com.bumptech.glide.load.j;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.j.n;
import com.bumptech.glide.util.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: MultiModelLoaderFactory.java */
/* loaded from: classes.dex */
public class r {
    private static final c a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static final n<Object, Object> f1581b = new a();

    /* renamed from: c  reason: collision with root package name */
    private final List<b<?, ?>> f1582c;

    /* renamed from: d  reason: collision with root package name */
    private final c f1583d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<b<?, ?>> f1584e;

    /* renamed from: f  reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f1585f;

    /* compiled from: MultiModelLoaderFactory.java */
    /* loaded from: classes.dex */
    private static class a implements n<Object, Object> {
        a() {
        }

        @Override // com.bumptech.glide.load.j.n
        public boolean a(@NonNull Object obj) {
            return false;
        }

        @Override // com.bumptech.glide.load.j.n
        @Nullable
        public n.a<Object> b(@NonNull Object obj, int i, int i2, @NonNull f fVar) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MultiModelLoaderFactory.java */
    /* loaded from: classes.dex */
    public static class b<Model, Data> {
        private final Class<Model> a;

        /* renamed from: b  reason: collision with root package name */
        final Class<Data> f1586b;

        /* renamed from: c  reason: collision with root package name */
        final o<? extends Model, ? extends Data> f1587c;

        public b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
            this.a = cls;
            this.f1586b = cls2;
            this.f1587c = oVar;
        }

        public boolean a(@NonNull Class<?> cls) {
            return this.a.isAssignableFrom(cls);
        }

        public boolean b(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return a(cls) && this.f1586b.isAssignableFrom(cls2);
        }
    }

    /* compiled from: MultiModelLoaderFactory.java */
    /* loaded from: classes.dex */
    static class c {
        c() {
        }

        @NonNull
        public <Model, Data> q<Model, Data> a(@NonNull List<n<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            return new q<>(list, pool);
        }
    }

    public r(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(pool, a);
    }

    private <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar, boolean z) {
        b<?, ?> bVar = new b<>(cls, cls2, oVar);
        List<b<?, ?>> list = this.f1582c;
        list.add(z ? list.size() : 0, bVar);
    }

    @NonNull
    private <Model, Data> n<Model, Data> c(@NonNull b<?, ?> bVar) {
        return (n) i.d(bVar.f1587c.c(this));
    }

    @NonNull
    private static <Model, Data> n<Model, Data> f() {
        return (n<Model, Data>) f1581b;
    }

    @NonNull
    private <Model, Data> o<Model, Data> h(@NonNull b<?, ?> bVar) {
        return (o<Model, Data>) bVar.f1587c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized <Model, Data> void b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        a(cls, cls2, oVar, true);
    }

    @NonNull
    public synchronized <Model, Data> n<Model, Data> d(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (b<?, ?> bVar : this.f1582c) {
                if (this.f1584e.contains(bVar)) {
                    z = true;
                } else if (bVar.b(cls, cls2)) {
                    this.f1584e.add(bVar);
                    arrayList.add(c(bVar));
                    this.f1584e.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.f1583d.a(arrayList, this.f1585f);
            } else if (arrayList.size() == 1) {
                return (n) arrayList.get(0);
            } else if (z) {
                return f();
            } else {
                throw new Registry.NoModelLoaderAvailableException((Class<?>) cls, (Class<?>) cls2);
            }
        } catch (Throwable th) {
            this.f1584e.clear();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public synchronized <Model> List<n<Model, ?>> e(@NonNull Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b<?, ?> bVar : this.f1582c) {
                if (!this.f1584e.contains(bVar) && bVar.a(cls)) {
                    this.f1584e.add(bVar);
                    arrayList.add(c(bVar));
                    this.f1584e.remove(bVar);
                }
            }
        } catch (Throwable th) {
            this.f1584e.clear();
            throw th;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public synchronized List<Class<?>> g(@NonNull Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b<?, ?> bVar : this.f1582c) {
            if (!arrayList.contains(bVar.f1586b) && bVar.a(cls)) {
                arrayList.add(bVar.f1586b);
            }
        }
        return arrayList;
    }

    @NonNull
    synchronized <Model, Data> List<o<? extends Model, ? extends Data>> i(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<b<?, ?>> it = this.f1582c.iterator();
        while (it.hasNext()) {
            b<?, ?> next = it.next();
            if (next.b(cls, cls2)) {
                it.remove();
                arrayList.add(h(next));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public synchronized <Model, Data> List<o<? extends Model, ? extends Data>> j(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        List<o<? extends Model, ? extends Data>> i;
        i = i(cls, cls2);
        b(cls, cls2, oVar);
        return i;
    }

    @VisibleForTesting
    r(@NonNull Pools.Pool<List<Throwable>> pool, @NonNull c cVar) {
        this.f1582c = new ArrayList();
        this.f1584e = new HashSet();
        this.f1585f = pool;
        this.f1583d = cVar;
    }
}

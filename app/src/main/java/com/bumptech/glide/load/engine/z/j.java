package com.bumptech.glide.load.engine.z;

import android.util.Log;
import androidx.annotation.Nullable;
import com.bumptech.glide.util.i;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* compiled from: LruArrayPool.java */
/* loaded from: classes.dex */
public final class j implements b {
    private final h<a, Object> a = new h<>();

    /* renamed from: b  reason: collision with root package name */
    private final b f1524b = new b();

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f1525c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map<Class<?>, a<?>> f1526d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final int f1527e;

    /* renamed from: f  reason: collision with root package name */
    private int f1528f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LruArrayPool.java */
    /* loaded from: classes.dex */
    public static final class a implements m {
        private final b a;

        /* renamed from: b  reason: collision with root package name */
        int f1529b;

        /* renamed from: c  reason: collision with root package name */
        private Class<?> f1530c;

        a(b bVar) {
            this.a = bVar;
        }

        @Override // com.bumptech.glide.load.engine.z.m
        public void a() {
            this.a.c(this);
        }

        void b(int i, Class<?> cls) {
            this.f1529b = i;
            this.f1530c = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f1529b == aVar.f1529b && this.f1530c == aVar.f1530c;
        }

        public int hashCode() {
            int i = this.f1529b * 31;
            Class<?> cls = this.f1530c;
            return i + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.f1529b + "array=" + this.f1530c + '}';
        }
    }

    /* compiled from: LruArrayPool.java */
    /* loaded from: classes.dex */
    private static final class b extends d<a> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d */
        public a a() {
            return new a(this);
        }

        a e(int i, Class<?> cls) {
            a b2 = b();
            b2.b(i, cls);
            return b2;
        }
    }

    public j(int i) {
        this.f1527e = i;
    }

    private void f(int i, Class<?> cls) {
        NavigableMap<Integer, Integer> m = m(cls);
        Integer num = (Integer) m.get(Integer.valueOf(i));
        if (num == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
        } else if (num.intValue() == 1) {
            m.remove(Integer.valueOf(i));
        } else {
            m.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
        }
    }

    private void g() {
        h(this.f1527e);
    }

    private void h(int i) {
        while (this.f1528f > i) {
            Object f2 = this.a.f();
            i.d(f2);
            a i2 = i(f2);
            this.f1528f -= i2.b(f2) * i2.a();
            f(i2.b(f2), f2.getClass());
            if (Log.isLoggable(i2.getTag(), 2)) {
                Log.v(i2.getTag(), "evicted: " + i2.b(f2));
            }
        }
    }

    private <T> a<T> i(T t) {
        return j(t.getClass());
    }

    private <T> a<T> j(Class<T> cls) {
        g gVar = (a<T>) this.f1526d.get(cls);
        if (gVar == null) {
            if (cls.equals(int[].class)) {
                gVar = new i();
            } else if (cls.equals(byte[].class)) {
                gVar = new g();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.f1526d.put(cls, gVar);
        }
        return gVar;
    }

    @Nullable
    private <T> T k(a aVar) {
        return (T) this.a.a(aVar);
    }

    private <T> T l(a aVar, Class<T> cls) {
        a<T> j = j(cls);
        T t = (T) k(aVar);
        if (t != null) {
            this.f1528f -= j.b(t) * j.a();
            f(j.b(t), cls);
        }
        if (t != null) {
            return t;
        }
        if (Log.isLoggable(j.getTag(), 2)) {
            Log.v(j.getTag(), "Allocated " + aVar.f1529b + " bytes");
        }
        return j.newArray(aVar.f1529b);
    }

    private NavigableMap<Integer, Integer> m(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f1525c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f1525c.put(cls, treeMap);
        return treeMap;
    }

    private boolean n() {
        int i = this.f1528f;
        return i == 0 || this.f1527e / i >= 2;
    }

    private boolean o(int i) {
        return i <= this.f1527e / 2;
    }

    private boolean p(int i, Integer num) {
        return num != null && (n() || num.intValue() <= i * 8);
    }

    @Override // com.bumptech.glide.load.engine.z.b
    public synchronized void a(int i) {
        try {
            if (i >= 40) {
                b();
            } else if (i >= 20 || i == 15) {
                h(this.f1527e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.engine.z.b
    public synchronized void b() {
        h(0);
    }

    @Override // com.bumptech.glide.load.engine.z.b
    public synchronized <T> T c(int i, Class<T> cls) {
        a aVar;
        Integer ceilingKey = m(cls).ceilingKey(Integer.valueOf(i));
        if (p(i, ceilingKey)) {
            aVar = this.f1524b.e(ceilingKey.intValue(), cls);
        } else {
            aVar = this.f1524b.e(i, cls);
        }
        return (T) l(aVar, cls);
    }

    @Override // com.bumptech.glide.load.engine.z.b
    public synchronized <T> T d(int i, Class<T> cls) {
        return (T) l(this.f1524b.e(i, cls), cls);
    }

    @Override // com.bumptech.glide.load.engine.z.b
    public synchronized <T> void e(T t) {
        Class<?> cls = t.getClass();
        a<T> j = j(cls);
        int b2 = j.b(t);
        int a2 = j.a() * b2;
        if (o(a2)) {
            a e2 = this.f1524b.e(b2, cls);
            this.a.d(e2, t);
            NavigableMap<Integer, Integer> m = m(cls);
            Integer num = (Integer) m.get(Integer.valueOf(e2.f1529b));
            Integer valueOf = Integer.valueOf(e2.f1529b);
            int i = 1;
            if (num != null) {
                i = 1 + num.intValue();
            }
            m.put(valueOf, Integer.valueOf(i));
            this.f1528f += a2;
            g();
        }
    }
}

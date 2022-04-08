package com.google.gson.internal;

import com.google.gson.JsonIOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* compiled from: ConstructorConstructor.java */
/* loaded from: classes2.dex */
public final class c {
    private final Map<Type, com.google.gson.e<?>> a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.gson.internal.k.b f4911b = com.google.gson.internal.k.b.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes2.dex */
    public class a implements f<T> {
        a() {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.concurrent.ConcurrentHashMap] */
        @Override // com.google.gson.internal.f
        public T a() {
            return new ConcurrentHashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes2.dex */
    public class b implements f<T> {
        b() {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.TreeMap, T] */
        @Override // com.google.gson.internal.f
        public T a() {
            return new TreeMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: com.google.gson.internal.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0178c implements f<T> {
        C0178c() {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, T] */
        @Override // com.google.gson.internal.f
        public T a() {
            return new LinkedHashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes2.dex */
    public class d implements f<T> {
        d() {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, com.google.gson.internal.LinkedTreeMap] */
        @Override // com.google.gson.internal.f
        public T a() {
            return new LinkedTreeMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes2.dex */
    public class e implements f<T> {
        private final j a = j.b();

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Class f4912b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Type f4913c;

        e(Class cls, Type type) {
            this.f4912b = cls;
            this.f4913c = type;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
        @Override // com.google.gson.internal.f
        public T a() {
            try {
                return this.a.c(this.f4912b);
            } catch (Exception e2) {
                throw new RuntimeException("Unable to invoke no-args constructor for " + this.f4913c + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e2);
            }
        }
    }

    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes2.dex */
    class f implements f<T> {
        final /* synthetic */ com.google.gson.e a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Type f4915b;

        f(com.google.gson.e eVar, Type type) {
            this.a = eVar;
            this.f4915b = type;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
        @Override // com.google.gson.internal.f
        public T a() {
            return this.a.a(this.f4915b);
        }
    }

    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes2.dex */
    class g implements f<T> {
        final /* synthetic */ com.google.gson.e a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Type f4917b;

        g(com.google.gson.e eVar, Type type) {
            this.a = eVar;
            this.f4917b = type;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
        @Override // com.google.gson.internal.f
        public T a() {
            return this.a.a(this.f4917b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes2.dex */
    public class h implements f<T> {
        final /* synthetic */ Constructor a;

        h(Constructor constructor) {
            this.a = constructor;
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [T, java.lang.Object] */
        @Override // com.google.gson.internal.f
        public T a() {
            try {
                return this.a.newInstance(null);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Failed to invoke " + this.a + " with no args", e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Failed to invoke " + this.a + " with no args", e4.getTargetException());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes2.dex */
    public class i implements f<T> {
        i() {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.TreeSet] */
        @Override // com.google.gson.internal.f
        public T a() {
            return new TreeSet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes2.dex */
    public class j implements f<T> {
        final /* synthetic */ Type a;

        j(Type type) {
            this.a = type;
        }

        /* JADX WARN: Type inference failed for: r0v7, types: [T, java.util.EnumSet] */
        @Override // com.google.gson.internal.f
        public T a() {
            Type type = this.a;
            if (type instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return EnumSet.noneOf((Class) type2);
                }
                throw new JsonIOException("Invalid EnumSet type: " + this.a.toString());
            }
            throw new JsonIOException("Invalid EnumSet type: " + this.a.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes2.dex */
    public class k implements f<T> {
        k() {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.LinkedHashSet] */
        @Override // com.google.gson.internal.f
        public T a() {
            return new LinkedHashSet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes2.dex */
    public class l implements f<T> {
        l() {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.ArrayDeque] */
        @Override // com.google.gson.internal.f
        public T a() {
            return new ArrayDeque();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes2.dex */
    public class m implements f<T> {
        m() {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.ArrayList] */
        @Override // com.google.gson.internal.f
        public T a() {
            return new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes2.dex */
    public class n implements f<T> {
        n() {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.concurrent.ConcurrentSkipListMap, T] */
        @Override // com.google.gson.internal.f
        public T a() {
            return new ConcurrentSkipListMap();
        }
    }

    public c(Map<Type, com.google.gson.e<?>> map) {
        this.a = map;
    }

    private <T> f<T> b(Class<? super T> cls) {
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.f4911b.b(declaredConstructor);
            }
            return new h(declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private <T> f<T> c(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new i();
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new j(type);
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new k();
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new l();
            }
            return new m();
        } else if (!Map.class.isAssignableFrom(cls)) {
            return null;
        } else {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                return new n();
            }
            if (ConcurrentMap.class.isAssignableFrom(cls)) {
                return new a();
            }
            if (SortedMap.class.isAssignableFrom(cls)) {
                return new b();
            }
            if (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(com.google.gson.r.a.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
                return new d();
            }
            return new C0178c();
        }
    }

    private <T> f<T> d(Type type, Class<? super T> cls) {
        return new e(cls, type);
    }

    public <T> f<T> a(com.google.gson.r.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        com.google.gson.e<?> eVar = this.a.get(type);
        if (eVar != null) {
            return new f(eVar, type);
        }
        com.google.gson.e<?> eVar2 = this.a.get(rawType);
        if (eVar2 != null) {
            return new g(eVar2, type);
        }
        f<T> b2 = b(rawType);
        if (b2 != null) {
            return b2;
        }
        f<T> c2 = c(type, rawType);
        return c2 != null ? c2 : d(type, rawType);
    }

    public String toString() {
        return this.a.toString();
    }
}

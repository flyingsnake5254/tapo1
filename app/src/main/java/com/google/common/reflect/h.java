package com.google.common.reflect;

import com.google.common.base.k;
import com.google.common.base.n;
import com.google.common.base.p;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.j1;
import com.google.common.collect.j3;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Types.java */
/* loaded from: classes2.dex */
public final class h {
    private static final com.google.common.base.h<Type, String> a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final com.google.common.base.i f4762b = com.google.common.base.i.g(", ").i("null");

    /* compiled from: Types.java */
    /* loaded from: classes2.dex */
    static class a implements com.google.common.base.h<Type, String> {
        a() {
        }

        /* renamed from: a */
        public String apply(Type type) {
            return e.x.d(type);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Types.java */
    /* loaded from: classes2.dex */
    public static class b extends g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AtomicReference f4763b;

        b(AtomicReference atomicReference) {
            this.f4763b = atomicReference;
        }

        @Override // com.google.common.reflect.g
        void b(Class<?> cls) {
            this.f4763b.set(cls.getComponentType());
        }

        @Override // com.google.common.reflect.g
        void c(GenericArrayType genericArrayType) {
            this.f4763b.set(genericArrayType.getGenericComponentType());
        }

        @Override // com.google.common.reflect.g
        void e(TypeVariable<?> typeVariable) {
            this.f4763b.set(h.q(typeVariable.getBounds()));
        }

        @Override // com.google.common.reflect.g
        void f(WildcardType wildcardType) {
            this.f4763b.set(h.q(wildcardType.getUpperBounds()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: Types.java */
    /* loaded from: classes2.dex */
    public static abstract class c extends Enum<c> {

        /* renamed from: c  reason: collision with root package name */
        public static final c f4764c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f4765d;

        /* renamed from: f  reason: collision with root package name */
        static final c f4766f = a();
        private static final /* synthetic */ c[] q;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: Types.java */
        /* loaded from: classes2.dex */
        static class a extends c {
            a(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.reflect.h.c
            @NullableDecl
            Class<?> b(Class<?> cls) {
                return cls.getEnclosingClass();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Types.java */
        /* loaded from: classes2.dex */
        public class b<T> {
            b() {
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: Types.java */
        /* renamed from: com.google.common.reflect.h$c$c  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        static class C0171c extends c {
            C0171c(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.reflect.h.c
            @NullableDecl
            Class<?> b(Class<?> cls) {
                if (cls.isLocalClass()) {
                    return null;
                }
                return cls.getEnclosingClass();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Types.java */
        /* loaded from: classes2.dex */
        public static class d extends b<String> {
            d() {
            }
        }

        static {
            a aVar = new a("OWNED_BY_ENCLOSING_CLASS", 0);
            f4764c = aVar;
            C0171c cVar = new C0171c("LOCAL_CLASS_HAS_NO_OWNER", 1);
            f4765d = cVar;
            q = new c[]{aVar, cVar};
        }

        private c(String str, int i) {
        }

        private static c a() {
            c[] values;
            new d();
            ParameterizedType parameterizedType = (ParameterizedType) d.class.getGenericSuperclass();
            for (c cVar : values()) {
                if (cVar.b(b.class) == parameterizedType.getOwnerType()) {
                    return cVar;
                }
            }
            throw new AssertionError();
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) q.clone();
        }

        @NullableDecl
        abstract Class<?> b(Class<?> cls);

        /* synthetic */ c(String str, int i, a aVar) {
            this(str, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Types.java */
    /* loaded from: classes2.dex */
    public static final class d implements GenericArrayType, Serializable {

        /* renamed from: c  reason: collision with root package name */
        private final Type f4767c;

        d(Type type) {
            this.f4767c = e.x.g(type);
        }

        public boolean equals(Object obj) {
            if (obj instanceof GenericArrayType) {
                return k.a(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
            }
            return false;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f4767c;
        }

        public int hashCode() {
            return this.f4767c.hashCode();
        }

        public String toString() {
            return h.t(this.f4767c) + "[]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: Types.java */
    /* loaded from: classes2.dex */
    public static abstract class e extends Enum<e> {

        /* renamed from: c  reason: collision with root package name */
        public static final e f4768c;

        /* renamed from: d  reason: collision with root package name */
        public static final e f4769d;

        /* renamed from: f  reason: collision with root package name */
        public static final e f4770f;
        public static final e q;
        static final e x;
        private static final /* synthetic */ e[] y;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: Types.java */
        /* loaded from: classes2.dex */
        static class a extends e {
            a(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.reflect.h.e
            Type g(Type type) {
                n.o(type);
                if (!(type instanceof Class)) {
                    return type;
                }
                Class cls = (Class) type;
                return cls.isArray() ? new d(cls.getComponentType()) : type;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: h */
            public GenericArrayType b(Type type) {
                return new d(type);
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: Types.java */
        /* loaded from: classes2.dex */
        static class b extends e {
            b(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.reflect.h.e
            Type b(Type type) {
                if (type instanceof Class) {
                    return h.i((Class) type);
                }
                return new d(type);
            }

            @Override // com.google.common.reflect.h.e
            Type g(Type type) {
                return (Type) n.o(type);
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: Types.java */
        /* loaded from: classes2.dex */
        static class c extends e {
            c(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.reflect.h.e
            Type b(Type type) {
                return e.f4769d.b(type);
            }

            @Override // com.google.common.reflect.h.e
            String d(Type type) {
                Throwable e2;
                try {
                    return (String) Type.class.getMethod("getTypeName", new Class[0]).invoke(type, new Object[0]);
                } catch (IllegalAccessException e3) {
                    e2 = e3;
                    throw new RuntimeException(e2);
                } catch (NoSuchMethodException unused) {
                    throw new AssertionError("Type.getTypeName should be available in Java 8");
                } catch (InvocationTargetException e4) {
                    e2 = e4;
                    throw new RuntimeException(e2);
                }
            }

            @Override // com.google.common.reflect.h.e
            Type g(Type type) {
                return e.f4769d.g(type);
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: Types.java */
        /* loaded from: classes2.dex */
        static class d extends e {
            d(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.reflect.h.e
            boolean a() {
                return false;
            }

            @Override // com.google.common.reflect.h.e
            Type b(Type type) {
                return e.f4770f.b(type);
            }

            @Override // com.google.common.reflect.h.e
            String d(Type type) {
                return e.f4770f.d(type);
            }

            @Override // com.google.common.reflect.h.e
            Type g(Type type) {
                return e.f4770f.g(type);
            }
        }

        /* compiled from: Types.java */
        /* renamed from: com.google.common.reflect.h$e$e  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        static class C0172e extends d<Map.Entry<String, int[][]>> {
            C0172e() {
            }
        }

        /* compiled from: Types.java */
        /* loaded from: classes2.dex */
        static class f extends d<int[]> {
            f() {
            }
        }

        static {
            a aVar = new a("JAVA6", 0);
            f4768c = aVar;
            b bVar = new b("JAVA7", 1);
            f4769d = bVar;
            c cVar = new c("JAVA8", 2);
            f4770f = cVar;
            d dVar = new d("JAVA9", 3);
            q = dVar;
            y = new e[]{aVar, bVar, cVar, dVar};
            if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class)) {
                if (new C0172e().capture().toString().contains("java.util.Map.java.util.Map")) {
                    x = cVar;
                } else {
                    x = dVar;
                }
            } else if (new f().capture() instanceof Class) {
                x = bVar;
            } else {
                x = aVar;
            }
        }

        private e(String str, int i) {
        }

        public static e valueOf(String str) {
            return (e) Enum.valueOf(e.class, str);
        }

        public static e[] values() {
            return (e[]) y.clone();
        }

        boolean a() {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Type b(Type type);

        String d(Type type) {
            return h.t(type);
        }

        final ImmutableList<Type> f(Type[] typeArr) {
            ImmutableList.a builder = ImmutableList.builder();
            for (Type type : typeArr) {
                builder.a(g(type));
            }
            return builder.j();
        }

        abstract Type g(Type type);

        /* synthetic */ e(String str, int i, a aVar) {
            this(str, i);
        }
    }

    /* compiled from: Types.java */
    /* loaded from: classes2.dex */
    static final class f<X> {
        static final boolean a = !f.class.getTypeParameters()[0].equals(h.l(f.class, "X", new Type[0]));

        f() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Types.java */
    /* loaded from: classes2.dex */
    public static final class g implements ParameterizedType, Serializable {
        @NullableDecl

        /* renamed from: c  reason: collision with root package name */
        private final Type f4771c;

        /* renamed from: d  reason: collision with root package name */
        private final ImmutableList<Type> f4772d;

        /* renamed from: f  reason: collision with root package name */
        private final Class<?> f4773f;

        g(@NullableDecl Type type, Class<?> cls, Type[] typeArr) {
            n.o(cls);
            n.d(typeArr.length == cls.getTypeParameters().length);
            h.g(typeArr, "type parameter");
            this.f4771c = type;
            this.f4773f = cls;
            this.f4772d = e.x.f(typeArr);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            return getRawType().equals(parameterizedType.getRawType()) && k.a(getOwnerType(), parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments());
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return h.s(this.f4772d);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.f4771c;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f4773f;
        }

        public int hashCode() {
            Type type = this.f4771c;
            return ((type == null ? 0 : type.hashCode()) ^ this.f4772d.hashCode()) ^ this.f4773f.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.f4771c != null) {
                e eVar = e.x;
                if (eVar.a()) {
                    sb.append(eVar.d(this.f4771c));
                    sb.append('.');
                }
            }
            sb.append(this.f4773f.getName());
            sb.append('<');
            sb.append(h.f4762b.c(j1.o(this.f4772d, h.a)));
            sb.append('>');
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Types.java */
    /* renamed from: com.google.common.reflect.h$h  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0173h<D extends GenericDeclaration> {
        private final D a;

        /* renamed from: b  reason: collision with root package name */
        private final String f4774b;

        /* renamed from: c  reason: collision with root package name */
        private final ImmutableList<Type> f4775c;

        C0173h(D d2, String str, Type[] typeArr) {
            h.g(typeArr, "bound for type variable");
            this.a = (D) ((GenericDeclaration) n.o(d2));
            this.f4774b = (String) n.o(str);
            this.f4775c = ImmutableList.copyOf(typeArr);
        }

        public D a() {
            return this.a;
        }

        public String b() {
            return this.f4774b;
        }

        public boolean equals(Object obj) {
            if (f.a) {
                if (obj == null || !Proxy.isProxyClass(obj.getClass()) || !(Proxy.getInvocationHandler(obj) instanceof i)) {
                    return false;
                }
                C0173h hVar = ((i) Proxy.getInvocationHandler(obj)).f4776b;
                return this.f4774b.equals(hVar.b()) && this.a.equals(hVar.a()) && this.f4775c.equals(hVar.f4775c);
            } else if (!(obj instanceof TypeVariable)) {
                return false;
            } else {
                TypeVariable typeVariable = (TypeVariable) obj;
                return this.f4774b.equals(typeVariable.getName()) && this.a.equals(typeVariable.getGenericDeclaration());
            }
        }

        public int hashCode() {
            return this.a.hashCode() ^ this.f4774b.hashCode();
        }

        public String toString() {
            return this.f4774b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Types.java */
    /* loaded from: classes2.dex */
    public static final class i implements InvocationHandler {
        private static final ImmutableMap<String, Method> a;

        /* renamed from: b  reason: collision with root package name */
        private final C0173h<?> f4776b;

        static {
            Method[] methods;
            ImmutableMap.b builder = ImmutableMap.builder();
            for (Method method : C0173h.class.getMethods()) {
                if (method.getDeclaringClass().equals(C0173h.class)) {
                    try {
                        method.setAccessible(true);
                    } catch (AccessControlException unused) {
                    }
                    builder.c(method.getName(), method);
                }
            }
            a = builder.a();
        }

        i(C0173h<?> hVar) {
            this.f4776b = hVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Method method2 = a.get(name);
            if (method2 != null) {
                try {
                    return method2.invoke(this.f4776b, objArr);
                } catch (InvocationTargetException e2) {
                    throw e2.getCause();
                }
            } else {
                throw new UnsupportedOperationException(name);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Types.java */
    /* loaded from: classes2.dex */
    public static final class j implements WildcardType, Serializable {

        /* renamed from: c  reason: collision with root package name */
        private final ImmutableList<Type> f4777c;

        /* renamed from: d  reason: collision with root package name */
        private final ImmutableList<Type> f4778d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(Type[] typeArr, Type[] typeArr2) {
            h.g(typeArr, "lower bound for wildcard");
            h.g(typeArr2, "upper bound for wildcard");
            e eVar = e.x;
            this.f4777c = eVar.f(typeArr);
            this.f4778d = eVar.f(typeArr2);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) obj;
            return this.f4777c.equals(Arrays.asList(wildcardType.getLowerBounds())) && this.f4778d.equals(Arrays.asList(wildcardType.getUpperBounds()));
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            return h.s(this.f4777c);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return h.s(this.f4778d);
        }

        public int hashCode() {
            return this.f4777c.hashCode() ^ this.f4778d.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("?");
            j3<Type> it = this.f4777c.iterator();
            while (it.hasNext()) {
                sb.append(" super ");
                sb.append(e.x.d(it.next()));
            }
            for (Type type : h.h(this.f4778d)) {
                sb.append(" extends ");
                sb.append(e.x.d(type));
            }
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Type[] typeArr, String str) {
        Class cls;
        for (Type type : typeArr) {
            if (type instanceof Class) {
                n.k(!cls.isPrimitive(), "Primitive type '%s' used as %s", (Class) type, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Iterable<Type> h(Iterable<Type> iterable) {
        return j1.d(iterable, p.f(p.c(Object.class)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?> i(Class<?> cls) {
        return Array.newInstance(cls, 0).getClass();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NullableDecl
    public static Type j(Type type) {
        n.o(type);
        AtomicReference atomicReference = new AtomicReference();
        new b(atomicReference).a(type);
        return (Type) atomicReference.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Type k(Type type) {
        if (!(type instanceof WildcardType)) {
            return e.x.b(type);
        }
        WildcardType wildcardType = (WildcardType) type;
        Type[] lowerBounds = wildcardType.getLowerBounds();
        boolean z = true;
        n.e(lowerBounds.length <= 1, "Wildcard cannot have more than one lower bounds.");
        if (lowerBounds.length == 1) {
            return r(k(lowerBounds[0]));
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        if (upperBounds.length != 1) {
            z = false;
        }
        n.e(z, "Wildcard should have only one upper bound.");
        return p(k(upperBounds[0]));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <D extends GenericDeclaration> TypeVariable<D> l(D d2, String str, Type... typeArr) {
        if (typeArr.length == 0) {
            typeArr = new Type[]{Object.class};
        }
        return o(d2, str, typeArr);
    }

    static ParameterizedType m(Class<?> cls, Type... typeArr) {
        return new g(c.f4766f.b(cls), cls, typeArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ParameterizedType n(@NullableDecl Type type, Class<?> cls, Type... typeArr) {
        if (type == null) {
            return m(cls, typeArr);
        }
        n.o(typeArr);
        n.j(cls.getEnclosingClass() != null, "Owner type for unenclosed %s", cls);
        return new g(type, cls, typeArr);
    }

    private static <D extends GenericDeclaration> TypeVariable<D> o(D d2, String str, Type[] typeArr) {
        return (TypeVariable) c.a(TypeVariable.class, new i(new C0173h(d2, str, typeArr)));
    }

    static WildcardType p(Type type) {
        return new j(new Type[0], new Type[]{type});
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NullableDecl
    public static Type q(Type[] typeArr) {
        for (Type type : typeArr) {
            Type j2 = j(type);
            if (j2 != null) {
                if (j2 instanceof Class) {
                    Class cls = (Class) j2;
                    if (cls.isPrimitive()) {
                        return cls;
                    }
                }
                return p(j2);
            }
        }
        return null;
    }

    static WildcardType r(Type type) {
        return new j(new Type[]{type}, new Type[]{Object.class});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Type[] s(Collection<Type> collection) {
        return (Type[]) collection.toArray(new Type[collection.size()]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String t(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }
}

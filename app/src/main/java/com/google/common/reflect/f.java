package com.google.common.reflect;

import com.google.common.base.i;
import com.google.common.base.k;
import com.google.common.base.n;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.q1;
import com.google.common.reflect.h;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: TypeResolver.java */
/* loaded from: classes2.dex */
public final class f {
    private final c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeResolver.java */
    /* loaded from: classes2.dex */
    public static class a extends g {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Map f4753b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Type f4754c;

        a(Map map, Type type) {
            this.f4753b = map;
            this.f4754c = type;
        }

        @Override // com.google.common.reflect.g
        void b(Class<?> cls) {
            if (!(this.f4754c instanceof WildcardType)) {
                throw new IllegalArgumentException("No type mapping from " + cls + " to " + this.f4754c);
            }
        }

        @Override // com.google.common.reflect.g
        void c(GenericArrayType genericArrayType) {
            Type type = this.f4754c;
            if (!(type instanceof WildcardType)) {
                Type j = h.j(type);
                n.j(j != null, "%s is not an array type.", this.f4754c);
                f.g(this.f4753b, genericArrayType.getGenericComponentType(), j);
            }
        }

        @Override // com.google.common.reflect.g
        void d(ParameterizedType parameterizedType) {
            Type type = this.f4754c;
            if (!(type instanceof WildcardType)) {
                ParameterizedType parameterizedType2 = (ParameterizedType) f.e(ParameterizedType.class, type);
                if (!(parameterizedType.getOwnerType() == null || parameterizedType2.getOwnerType() == null)) {
                    f.g(this.f4753b, parameterizedType.getOwnerType(), parameterizedType2.getOwnerType());
                }
                n.k(parameterizedType.getRawType().equals(parameterizedType2.getRawType()), "Inconsistent raw type: %s vs. %s", parameterizedType, this.f4754c);
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
                n.k(actualTypeArguments.length == actualTypeArguments2.length, "%s not compatible with %s", parameterizedType, parameterizedType2);
                for (int i = 0; i < actualTypeArguments.length; i++) {
                    f.g(this.f4753b, actualTypeArguments[i], actualTypeArguments2[i]);
                }
            }
        }

        @Override // com.google.common.reflect.g
        void e(TypeVariable<?> typeVariable) {
            this.f4753b.put(new d(typeVariable), this.f4754c);
        }

        @Override // com.google.common.reflect.g
        void f(WildcardType wildcardType) {
            Type type = this.f4754c;
            if (type instanceof WildcardType) {
                WildcardType wildcardType2 = (WildcardType) type;
                Type[] upperBounds = wildcardType.getUpperBounds();
                Type[] upperBounds2 = wildcardType2.getUpperBounds();
                Type[] lowerBounds = wildcardType.getLowerBounds();
                Type[] lowerBounds2 = wildcardType2.getLowerBounds();
                n.k(upperBounds.length == upperBounds2.length && lowerBounds.length == lowerBounds2.length, "Incompatible type: %s vs. %s", wildcardType, this.f4754c);
                for (int i = 0; i < upperBounds.length; i++) {
                    f.g(this.f4753b, upperBounds[i], upperBounds2[i]);
                }
                for (int i2 = 0; i2 < lowerBounds.length; i2++) {
                    f.g(this.f4753b, lowerBounds[i2], lowerBounds2[i2]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TypeResolver.java */
    /* loaded from: classes2.dex */
    public static final class b extends g {

        /* renamed from: b  reason: collision with root package name */
        private final Map<d, Type> f4755b = q1.o();

        private b() {
        }

        static ImmutableMap<d, Type> g(Type type) {
            n.o(type);
            b bVar = new b();
            bVar.a(type);
            return ImmutableMap.copyOf(bVar.f4755b);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0014, code lost:
            r4 = r2.f4755b.remove(com.google.common.reflect.f.d.c(r4));
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0012, code lost:
            if (r4 == null) goto L_0x0022;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void h(com.google.common.reflect.f.d r3, java.lang.reflect.Type r4) {
            /*
                r2 = this;
                java.util.Map<com.google.common.reflect.f$d, java.lang.reflect.Type> r0 = r2.f4755b
                boolean r0 = r0.containsKey(r3)
                if (r0 == 0) goto L_0x0009
                return
            L_0x0009:
                r0 = r4
            L_0x000a:
                if (r0 == 0) goto L_0x0030
                boolean r1 = r3.a(r0)
                if (r1 == 0) goto L_0x0023
            L_0x0012:
                if (r4 == 0) goto L_0x0022
                java.util.Map<com.google.common.reflect.f$d, java.lang.reflect.Type> r3 = r2.f4755b
                com.google.common.reflect.f$d r4 = com.google.common.reflect.f.d.c(r4)
                java.lang.Object r3 = r3.remove(r4)
                r4 = r3
                java.lang.reflect.Type r4 = (java.lang.reflect.Type) r4
                goto L_0x0012
            L_0x0022:
                return
            L_0x0023:
                java.util.Map<com.google.common.reflect.f$d, java.lang.reflect.Type> r1 = r2.f4755b
                com.google.common.reflect.f$d r0 = com.google.common.reflect.f.d.c(r0)
                java.lang.Object r0 = r1.get(r0)
                java.lang.reflect.Type r0 = (java.lang.reflect.Type) r0
                goto L_0x000a
            L_0x0030:
                java.util.Map<com.google.common.reflect.f$d, java.lang.reflect.Type> r0 = r2.f4755b
                r0.put(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.reflect.f.b.h(com.google.common.reflect.f$d, java.lang.reflect.Type):void");
        }

        @Override // com.google.common.reflect.g
        void b(Class<?> cls) {
            a(cls.getGenericSuperclass());
            a(cls.getGenericInterfaces());
        }

        @Override // com.google.common.reflect.g
        void d(ParameterizedType parameterizedType) {
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            n.u(typeParameters.length == actualTypeArguments.length);
            for (int i = 0; i < typeParameters.length; i++) {
                h(new d(typeParameters[i]), actualTypeArguments[i]);
            }
            a(cls);
            a(parameterizedType.getOwnerType());
        }

        @Override // com.google.common.reflect.g
        void e(TypeVariable<?> typeVariable) {
            a(typeVariable.getBounds());
        }

        @Override // com.google.common.reflect.g
        void f(WildcardType wildcardType) {
            a(wildcardType.getUpperBounds());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeResolver.java */
    /* loaded from: classes2.dex */
    public static final class d {
        private final TypeVariable<?> a;

        d(TypeVariable<?> typeVariable) {
            this.a = (TypeVariable) n.o(typeVariable);
        }

        private boolean b(TypeVariable<?> typeVariable) {
            return this.a.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) && this.a.getName().equals(typeVariable.getName());
        }

        static d c(Type type) {
            if (type instanceof TypeVariable) {
                return new d((TypeVariable) type);
            }
            return null;
        }

        boolean a(Type type) {
            if (type instanceof TypeVariable) {
                return b((TypeVariable) type);
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return b(((d) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return k.b(this.a.getGenericDeclaration(), this.a.getName());
        }

        public String toString() {
            return this.a.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TypeResolver.java */
    /* loaded from: classes2.dex */
    public static class e {
        static final e a = new e();

        /* renamed from: b  reason: collision with root package name */
        private final AtomicInteger f4759b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TypeResolver.java */
        /* loaded from: classes2.dex */
        public class a extends e {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ TypeVariable f4760c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(AtomicInteger atomicInteger, TypeVariable typeVariable) {
                super(atomicInteger, null);
                this.f4760c = typeVariable;
            }

            @Override // com.google.common.reflect.f.e
            TypeVariable<?> b(Type[] typeArr) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(typeArr));
                linkedHashSet.addAll(Arrays.asList(this.f4760c.getBounds()));
                if (linkedHashSet.size() > 1) {
                    linkedHashSet.remove(Object.class);
                }
                return super.b((Type[]) linkedHashSet.toArray(new Type[0]));
            }
        }

        /* synthetic */ e(AtomicInteger atomicInteger, a aVar) {
            this(atomicInteger);
        }

        private Type c(@NullableDecl Type type) {
            if (type == null) {
                return null;
            }
            return a(type);
        }

        private e d(TypeVariable<?> typeVariable) {
            return new a(this.f4759b, typeVariable);
        }

        private e e() {
            return new e(this.f4759b);
        }

        final Type a(Type type) {
            n.o(type);
            if ((type instanceof Class) || (type instanceof TypeVariable)) {
                return type;
            }
            if (type instanceof GenericArrayType) {
                return h.k(e().a(((GenericArrayType) type).getGenericComponentType()));
            }
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Class cls = (Class) parameterizedType.getRawType();
                TypeVariable<?>[] typeParameters = cls.getTypeParameters();
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (int i = 0; i < actualTypeArguments.length; i++) {
                    actualTypeArguments[i] = d(typeParameters[i]).a(actualTypeArguments[i]);
                }
                return h.n(e().c(parameterizedType.getOwnerType()), cls, actualTypeArguments);
            } else if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                return wildcardType.getLowerBounds().length == 0 ? b(wildcardType.getUpperBounds()) : type;
            } else {
                throw new AssertionError("must have been one of the known types");
            }
        }

        TypeVariable<?> b(Type[] typeArr) {
            return h.l(e.class, "capture#" + this.f4759b.incrementAndGet() + "-of ? extends " + i.f('&').e(typeArr), typeArr);
        }

        private e() {
            this(new AtomicInteger());
        }

        private e(AtomicInteger atomicInteger) {
            this.f4759b = atomicInteger;
        }
    }

    /* synthetic */ f(c cVar, a aVar) {
        this(cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f d(Type type) {
        return new f().o(b.g(type));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T e(Class<T> cls, Object obj) {
        try {
            return cls.cast(obj);
        } catch (ClassCastException unused) {
            throw new IllegalArgumentException(obj + " is not a " + cls.getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f f(Type type) {
        return new f().o(b.g(e.a.a(type)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Map<d, Type> map, Type type, Type type2) {
        if (!type.equals(type2)) {
            new a(map, type2).a(type);
        }
    }

    private Type h(GenericArrayType genericArrayType) {
        return h.k(j(genericArrayType.getGenericComponentType()));
    }

    private ParameterizedType i(ParameterizedType parameterizedType) {
        Type ownerType = parameterizedType.getOwnerType();
        return h.n(ownerType == null ? null : j(ownerType), (Class) j(parameterizedType.getRawType()), k(parameterizedType.getActualTypeArguments()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Type[] k(Type[] typeArr) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i = 0; i < typeArr.length; i++) {
            typeArr2[i] = j(typeArr[i]);
        }
        return typeArr2;
    }

    private WildcardType m(WildcardType wildcardType) {
        return new h.j(k(wildcardType.getLowerBounds()), k(wildcardType.getUpperBounds()));
    }

    public Type j(Type type) {
        n.o(type);
        if (type instanceof TypeVariable) {
            return this.a.a((TypeVariable) type);
        }
        if (type instanceof ParameterizedType) {
            return i((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return h((GenericArrayType) type);
        }
        return type instanceof WildcardType ? m((WildcardType) type) : type;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Type[] l(Type[] typeArr) {
        for (int i = 0; i < typeArr.length; i++) {
            typeArr[i] = j(typeArr[i]);
        }
        return typeArr;
    }

    public f n(Type type, Type type2) {
        HashMap o = q1.o();
        g(o, (Type) n.o(type), (Type) n.o(type2));
        return o(o);
    }

    f o(Map<d, ? extends Type> map) {
        return new f(this.a.c(map));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TypeResolver.java */
    /* loaded from: classes2.dex */
    public static class c {
        private final ImmutableMap<d, Type> a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TypeResolver.java */
        /* loaded from: classes2.dex */
        public class a extends c {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ TypeVariable f4756b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ c f4757c;

            a(TypeVariable typeVariable, c cVar) {
                this.f4756b = typeVariable;
                this.f4757c = cVar;
            }

            @Override // com.google.common.reflect.f.c
            public Type b(TypeVariable<?> typeVariable, c cVar) {
                return typeVariable.getGenericDeclaration().equals(this.f4756b.getGenericDeclaration()) ? typeVariable : this.f4757c.b(typeVariable, cVar);
            }
        }

        c() {
            this.a = ImmutableMap.of();
        }

        final Type a(TypeVariable<?> typeVariable) {
            return b(typeVariable, new a(typeVariable, this));
        }

        Type b(TypeVariable<?> typeVariable, c cVar) {
            Type type = this.a.get(new d(typeVariable));
            if (type != null) {
                return new f(cVar, null).j(type);
            }
            Type[] bounds = typeVariable.getBounds();
            if (bounds.length == 0) {
                return typeVariable;
            }
            Type[] k = new f(cVar, null).k(bounds);
            return (!h.f.a || !Arrays.equals(bounds, k)) ? h.l(typeVariable.getGenericDeclaration(), typeVariable.getName(), k) : typeVariable;
        }

        final c c(Map<d, ? extends Type> map) {
            ImmutableMap.b builder = ImmutableMap.builder();
            builder.f(this.a);
            for (Map.Entry<d, ? extends Type> entry : map.entrySet()) {
                d key = entry.getKey();
                Type type = (Type) entry.getValue();
                n.j(!key.a(type), "Type variable %s bound to itself", key);
                builder.c(key, type);
            }
            return new c(builder.a());
        }

        private c(ImmutableMap<d, Type> immutableMap) {
            this.a = immutableMap;
        }
    }

    public f() {
        this.a = new c();
    }

    private f(c cVar) {
        this.a = cVar;
    }
}

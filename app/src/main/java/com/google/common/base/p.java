package com.google.common.base;

import java.io.Serializable;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Predicates.java */
/* loaded from: classes2.dex */
public final class p {

    /* compiled from: Predicates.java */
    /* loaded from: classes2.dex */
    private static class b<A, B> implements o<A>, Serializable {

        /* renamed from: c  reason: collision with root package name */
        final o<B> f4138c;

        /* renamed from: d  reason: collision with root package name */
        final h<A, ? extends B> f4139d;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.base.o
        public boolean apply(@NullableDecl A a) {
            return this.f4138c.apply(this.f4139d.apply(a));
        }

        @Override // com.google.common.base.o
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f4139d.equals(bVar.f4139d) && this.f4138c.equals(bVar.f4138c);
        }

        public int hashCode() {
            return this.f4139d.hashCode() ^ this.f4138c.hashCode();
        }

        public String toString() {
            return this.f4138c + "(" + this.f4139d + ")";
        }

        private b(o<B> oVar, h<A, ? extends B> hVar) {
            this.f4138c = (o) n.o(oVar);
            this.f4139d = (h) n.o(hVar);
        }
    }

    /* compiled from: Predicates.java */
    /* loaded from: classes2.dex */
    private static class c<T> implements o<T>, Serializable {

        /* renamed from: c  reason: collision with root package name */
        private final Collection<?> f4140c;

        @Override // com.google.common.base.o
        public boolean apply(@NullableDecl T t) {
            try {
                return this.f4140c.contains(t);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        @Override // com.google.common.base.o
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof c) {
                return this.f4140c.equals(((c) obj).f4140c);
            }
            return false;
        }

        public int hashCode() {
            return this.f4140c.hashCode();
        }

        public String toString() {
            return "Predicates.in(" + this.f4140c + ")";
        }

        private c(Collection<?> collection) {
            this.f4140c = (Collection) n.o(collection);
        }
    }

    /* compiled from: Predicates.java */
    /* loaded from: classes2.dex */
    private static class d<T> implements o<T>, Serializable {

        /* renamed from: c  reason: collision with root package name */
        private final T f4141c;

        @Override // com.google.common.base.o
        public boolean apply(T t) {
            return this.f4141c.equals(t);
        }

        @Override // com.google.common.base.o
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof d) {
                return this.f4141c.equals(((d) obj).f4141c);
            }
            return false;
        }

        public int hashCode() {
            return this.f4141c.hashCode();
        }

        public String toString() {
            return "Predicates.equalTo(" + this.f4141c + ")";
        }

        private d(T t) {
            this.f4141c = t;
        }
    }

    /* compiled from: Predicates.java */
    /* loaded from: classes2.dex */
    private static class e<T> implements o<T>, Serializable {

        /* renamed from: c  reason: collision with root package name */
        final o<T> f4142c;

        e(o<T> oVar) {
            this.f4142c = (o) n.o(oVar);
        }

        @Override // com.google.common.base.o
        public boolean apply(@NullableDecl T t) {
            return !this.f4142c.apply(t);
        }

        @Override // com.google.common.base.o
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof e) {
                return this.f4142c.equals(((e) obj).f4142c);
            }
            return false;
        }

        public int hashCode() {
            return ~this.f4142c.hashCode();
        }

        public String toString() {
            return "Predicates.not(" + this.f4142c + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: Predicates.java */
    /* loaded from: classes2.dex */
    public static abstract class f extends Enum<f> implements o<Object> {

        /* renamed from: c  reason: collision with root package name */
        public static final f f4143c;

        /* renamed from: d  reason: collision with root package name */
        public static final f f4144d;

        /* renamed from: f  reason: collision with root package name */
        public static final f f4145f;
        public static final f q;
        private static final /* synthetic */ f[] x;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: Predicates.java */
        /* loaded from: classes2.dex */
        static class a extends f {
            a(String str, int i) {
                super(str, i);
            }

            @Override // com.google.common.base.o
            public boolean apply(@NullableDecl Object obj) {
                return true;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: Predicates.java */
        /* loaded from: classes2.dex */
        static class b extends f {
            b(String str, int i) {
                super(str, i);
            }

            @Override // com.google.common.base.o
            public boolean apply(@NullableDecl Object obj) {
                return false;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: Predicates.java */
        /* loaded from: classes2.dex */
        static class c extends f {
            c(String str, int i) {
                super(str, i);
            }

            @Override // com.google.common.base.o
            public boolean apply(@NullableDecl Object obj) {
                return obj == null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.isNull()";
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: Predicates.java */
        /* loaded from: classes2.dex */
        static class d extends f {
            d(String str, int i) {
                super(str, i);
            }

            @Override // com.google.common.base.o
            public boolean apply(@NullableDecl Object obj) {
                return obj != null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.notNull()";
            }
        }

        static {
            a aVar = new a("ALWAYS_TRUE", 0);
            f4143c = aVar;
            b bVar = new b("ALWAYS_FALSE", 1);
            f4144d = bVar;
            c cVar = new c("IS_NULL", 2);
            f4145f = cVar;
            d dVar = new d("NOT_NULL", 3);
            q = dVar;
            x = new f[]{aVar, bVar, cVar, dVar};
        }

        private f(String str, int i) {
        }

        public static f valueOf(String str) {
            return (f) Enum.valueOf(f.class, str);
        }

        public static f[] values() {
            return (f[]) x.clone();
        }

        <T> o<T> a() {
            return this;
        }
    }

    public static <T> o<T> a() {
        return f.f4143c.a();
    }

    public static <A, B> o<A> b(o<B> oVar, h<A, ? extends B> hVar) {
        return new b(oVar, hVar);
    }

    public static <T> o<T> c(@NullableDecl T t) {
        return t == null ? e() : new d(t);
    }

    public static <T> o<T> d(Collection<? extends T> collection) {
        return new c(collection);
    }

    public static <T> o<T> e() {
        return f.f4145f.a();
    }

    public static <T> o<T> f(o<T> oVar) {
        return new e(oVar);
    }
}

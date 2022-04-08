package com.google.common.collect;

import com.google.common.base.k;
import com.google.common.base.n;
import com.google.common.collect.u1;
import com.google.common.collect.u2;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Multisets.java */
/* loaded from: classes2.dex */
public final class v1 {

    /* compiled from: Multisets.java */
    /* loaded from: classes2.dex */
    static class a extends h3<u1.a<E>, E> {
        a(Iterator it) {
            super(it);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Type inference failed for: r1v1, types: [E, java.lang.Object] */
        /* renamed from: b */
        public E a(u1.a<E> aVar) {
            return aVar.a();
        }
    }

    /* compiled from: Multisets.java */
    /* loaded from: classes2.dex */
    static abstract class b<E> implements u1.a<E> {
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof u1.a)) {
                return false;
            }
            u1.a aVar = (u1.a) obj;
            return getCount() == aVar.getCount() && k.a(a(), aVar.a());
        }

        public int hashCode() {
            E a = a();
            return (a == null ? 0 : a.hashCode()) ^ getCount();
        }

        @Override // com.google.common.collect.u1.a
        public String toString() {
            String valueOf = String.valueOf(a());
            int count = getCount();
            if (count == 1) {
                return valueOf;
            }
            return valueOf + " x " + count;
        }
    }

    /* compiled from: Multisets.java */
    /* loaded from: classes2.dex */
    static abstract class c<E> extends u2.b<E> {
        abstract u1<E> c();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            c().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return c().contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return c().containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return c().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return c().remove(obj, Integer.MAX_VALUE) > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return c().entrySet().size();
        }
    }

    /* compiled from: Multisets.java */
    /* loaded from: classes2.dex */
    static abstract class d<E> extends u2.b<u1.a<E>> {
        abstract u1<E> c();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            c().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof u1.a)) {
                return false;
            }
            u1.a aVar = (u1.a) obj;
            return aVar.getCount() > 0 && c().count(aVar.a()) == aVar.getCount();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (obj instanceof u1.a) {
                u1.a aVar = (u1.a) obj;
                E e2 = (E) aVar.a();
                int count = aVar.getCount();
                if (count != 0) {
                    return c().setCount(e2, count, 0);
                }
            }
            return false;
        }
    }

    /* compiled from: Multisets.java */
    /* loaded from: classes2.dex */
    static class e<E> extends b<E> implements Serializable {
        @NullableDecl

        /* renamed from: c  reason: collision with root package name */
        private final E f4626c;

        /* renamed from: d  reason: collision with root package name */
        private final int f4627d;

        e(@NullableDecl E e2, int i) {
            this.f4626c = e2;
            this.f4627d = i;
            v.b(i, "count");
        }

        @Override // com.google.common.collect.u1.a
        @NullableDecl
        public final E a() {
            return this.f4626c;
        }

        @Override // com.google.common.collect.u1.a
        public final int getCount() {
            return this.f4627d;
        }
    }

    /* compiled from: Multisets.java */
    /* loaded from: classes2.dex */
    static final class f<E> implements Iterator<E> {

        /* renamed from: c  reason: collision with root package name */
        private final u1<E> f4628c;

        /* renamed from: d  reason: collision with root package name */
        private final Iterator<u1.a<E>> f4629d;
        @MonotonicNonNullDecl

        /* renamed from: f  reason: collision with root package name */
        private u1.a<E> f4630f;
        private int q;
        private int x;
        private boolean y;

        f(u1<E> u1Var, Iterator<u1.a<E>> it) {
            this.f4628c = u1Var;
            this.f4629d = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.q > 0 || this.f4629d.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (hasNext()) {
                if (this.q == 0) {
                    u1.a<E> next = this.f4629d.next();
                    this.f4630f = next;
                    int count = next.getCount();
                    this.q = count;
                    this.x = count;
                }
                this.q--;
                this.y = true;
                return this.f4630f.a();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            v.e(this.y);
            if (this.x == 1) {
                this.f4629d.remove();
            } else {
                this.f4628c.remove(this.f4630f.a());
            }
            this.x--;
            this.y = false;
        }
    }

    private static <E> boolean a(u1<E> u1Var, f<? extends E> fVar) {
        if (fVar.isEmpty()) {
            return false;
        }
        fVar.addTo(u1Var);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <E> boolean b(u1<E> u1Var, u1<? extends E> u1Var2) {
        if (u1Var2 instanceof f) {
            return a(u1Var, (f) u1Var2);
        }
        if (u1Var2.isEmpty()) {
            return false;
        }
        for (u1.a<? extends E> aVar : u1Var2.entrySet()) {
            u1Var.add(aVar.a(), aVar.getCount());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> boolean c(u1<E> u1Var, Collection<? extends E> collection) {
        n.o(u1Var);
        n.o(collection);
        if (collection instanceof u1) {
            return b(u1Var, d(collection));
        }
        if (collection.isEmpty()) {
            return false;
        }
        return k1.a(u1Var, collection.iterator());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> u1<T> d(Iterable<T> iterable) {
        return (u1) iterable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> Iterator<E> e(Iterator<u1.a<E>> it) {
        return new a(it);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(u1<?> u1Var, @NullableDecl Object obj) {
        if (obj == u1Var) {
            return true;
        }
        if (obj instanceof u1) {
            u1 u1Var2 = (u1) obj;
            if (u1Var.size() == u1Var2.size() && u1Var.entrySet().size() == u1Var2.entrySet().size()) {
                for (u1.a aVar : u1Var2.entrySet()) {
                    if (u1Var.count(aVar.a()) != aVar.getCount()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static <E> u1.a<E> g(@NullableDecl E e2, int i) {
        return new e(e2, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(Iterable<?> iterable) {
        if (iterable instanceof u1) {
            return ((u1) iterable).elementSet().size();
        }
        return 11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> Iterator<E> i(u1<E> u1Var) {
        return new f(u1Var, u1Var.entrySet().iterator());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean j(u1<?> u1Var, Collection<?> collection) {
        if (collection instanceof u1) {
            collection = ((u1) collection).elementSet();
        }
        return u1Var.elementSet().removeAll(collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean k(u1<?> u1Var, Collection<?> collection) {
        n.o(collection);
        if (collection instanceof u1) {
            collection = ((u1) collection).elementSet();
        }
        return u1Var.elementSet().retainAll(collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> int l(u1<E> u1Var, E e2, int i) {
        v.b(i, "count");
        int count = u1Var.count(e2);
        int i2 = i - count;
        if (i2 > 0) {
            u1Var.add(e2, i2);
        } else if (i2 < 0) {
            u1Var.remove(e2, -i2);
        }
        return count;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> boolean m(u1<E> u1Var, E e2, int i, int i2) {
        v.b(i, "oldCount");
        v.b(i2, "newCount");
        if (u1Var.count(e2) != i) {
            return false;
        }
        u1Var.setCount(e2, i2);
        return true;
    }
}

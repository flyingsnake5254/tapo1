package com.google.common.collect;

import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Sets.java */
/* loaded from: classes2.dex */
public final class u2 {

    /* compiled from: Sets.java */
    /* loaded from: classes2.dex */
    static class a extends c<E> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Set f4620c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Set f4621d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Sets.java */
        /* renamed from: com.google.common.collect.u2$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0165a extends c<E> {

            /* renamed from: f  reason: collision with root package name */
            final Iterator<E> f4622f;

            C0165a() {
                this.f4622f = a.this.f4620c.iterator();
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [E, java.lang.Object] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.common.collect.c
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            protected E a() {
                /*
                    r2 = this;
                L_0x0000:
                    java.util.Iterator<E> r0 = r2.f4622f
                    boolean r0 = r0.hasNext()
                    if (r0 == 0) goto L_0x0019
                    java.util.Iterator<E> r0 = r2.f4622f
                    java.lang.Object r0 = r0.next()
                    com.google.common.collect.u2$a r1 = com.google.common.collect.u2.a.this
                    java.util.Set r1 = r1.f4621d
                    boolean r1 = r1.contains(r0)
                    if (r1 == 0) goto L_0x0000
                    return r0
                L_0x0019:
                    java.lang.Object r0 = r2.b()
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.u2.a.C0165a.a():java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Set set, Set set2) {
            super(null);
            this.f4620c = set;
            this.f4621d = set2;
        }

        /* renamed from: a */
        public j3<E> iterator() {
            return new C0165a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f4620c.contains(obj) && this.f4621d.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return this.f4620c.containsAll(collection) && this.f4621d.containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return Collections.disjoint(this.f4621d, this.f4620c);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            int i = 0;
            for (Object obj : this.f4620c) {
                if (this.f4621d.contains(obj)) {
                    i++;
                }
            }
            return i;
        }
    }

    /* compiled from: Sets.java */
    /* loaded from: classes2.dex */
    static abstract class b<E> extends AbstractSet<E> {
        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return u2.g(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return super.retainAll((Collection) n.o(collection));
        }
    }

    /* compiled from: Sets.java */
    /* loaded from: classes2.dex */
    public static abstract class c<E> extends AbstractSet<E> {
        /* synthetic */ c(t2 t2Var) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @Deprecated
        public final boolean add(E e2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @Deprecated
        public final boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @Deprecated
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @Deprecated
        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @Deprecated
        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        private c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Sets.java */
    /* loaded from: classes2.dex */
    public static final class d<E> extends v0<E> implements NavigableSet<E>, Serializable {

        /* renamed from: c  reason: collision with root package name */
        private final NavigableSet<E> f4623c;

        /* renamed from: d  reason: collision with root package name */
        private final SortedSet<E> f4624d;
        @MonotonicNonNullDecl

        /* renamed from: f  reason: collision with root package name */
        private transient d<E> f4625f;

        d(NavigableSet<E> navigableSet) {
            this.f4623c = (NavigableSet) n.o(navigableSet);
            this.f4624d = Collections.unmodifiableSortedSet(navigableSet);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.v0
        /* renamed from: a */
        public SortedSet<E> delegate() {
            return this.f4624d;
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e2) {
            return this.f4623c.ceiling(e2);
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return k1.y(this.f4623c.descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            d<E> dVar = this.f4625f;
            if (dVar != null) {
                return dVar;
            }
            d<E> dVar2 = new d<>(this.f4623c.descendingSet());
            this.f4625f = dVar2;
            dVar2.f4625f = this;
            return dVar2;
        }

        @Override // java.util.NavigableSet
        public E floor(E e2) {
            return this.f4623c.floor(e2);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E e2, boolean z) {
            return u2.i(this.f4623c.headSet(e2, z));
        }

        @Override // java.util.NavigableSet
        public E higher(E e2) {
            return this.f4623c.higher(e2);
        }

        @Override // java.util.NavigableSet
        public E lower(E e2) {
            return this.f4623c.lower(e2);
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E e2, boolean z, E e3, boolean z2) {
            return u2.i(this.f4623c.subSet(e2, z, e3, z2));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E e2, boolean z) {
            return u2.i(this.f4623c.tailSet(e2, z));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Set<?> set, @NullableDecl Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(Set<?> set) {
        Iterator<?> it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i = ~(~(i + (next != null ? next.hashCode() : 0)));
        }
        return i;
    }

    public static <E> c<E> c(Set<E> set, Set<?> set2) {
        n.p(set, "set1");
        n.p(set2, "set2");
        return new a(set, set2);
    }

    public static <E> HashSet<E> d() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> e(int i) {
        return new HashSet<>(q1.d(i));
    }

    public static <E> Set<E> f() {
        return Collections.newSetFromMap(q1.q());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean g(Set<?> set, Collection<?> collection) {
        n.o(collection);
        if (collection instanceof u1) {
            collection = ((u1) collection).elementSet();
        }
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            return h(set, collection.iterator());
        }
        return k1.s(set.iterator(), collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean h(Set<?> set, Iterator<?> it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= set.remove(it.next());
        }
        return z;
    }

    public static <E> NavigableSet<E> i(NavigableSet<E> navigableSet) {
        return ((navigableSet instanceof ImmutableCollection) || (navigableSet instanceof d)) ? navigableSet : new d(navigableSet);
    }
}

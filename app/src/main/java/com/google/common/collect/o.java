package com.google.common.collect;

import com.google.common.base.n;
import com.google.common.collect.b3;
import com.google.common.collect.u1;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: AbstractSortedMultiset.java */
/* loaded from: classes2.dex */
abstract class o<E> extends i<E> implements a3<E> {
    final Comparator<? super E> comparator;
    @MonotonicNonNullDecl
    private transient a3<E> descendingMultiset;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractSortedMultiset.java */
    /* loaded from: classes2.dex */
    public class a extends h0<E> {
        a() {
        }

        @Override // com.google.common.collect.h0
        Iterator<u1.a<E>> d() {
            return o.this.descendingEntryIterator();
        }

        @Override // com.google.common.collect.h0
        a3<E> f() {
            return o.this;
        }

        @Override // com.google.common.collect.n0, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return o.this.descendingIterator();
        }
    }

    o() {
        this(a2.g());
    }

    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    a3<E> createDescendingMultiset() {
        return new a();
    }

    abstract Iterator<u1.a<E>> descendingEntryIterator();

    Iterator<E> descendingIterator() {
        return v1.i(descendingMultiset());
    }

    public a3<E> descendingMultiset() {
        a3<E> a3Var = this.descendingMultiset;
        if (a3Var != null) {
            return a3Var;
        }
        a3<E> createDescendingMultiset = createDescendingMultiset();
        this.descendingMultiset = createDescendingMultiset;
        return createDescendingMultiset;
    }

    public u1.a<E> firstEntry() {
        Iterator<u1.a<E>> entryIterator = entryIterator();
        if (entryIterator.hasNext()) {
            return entryIterator.next();
        }
        return null;
    }

    public u1.a<E> lastEntry() {
        Iterator<u1.a<E>> descendingEntryIterator = descendingEntryIterator();
        if (descendingEntryIterator.hasNext()) {
            return descendingEntryIterator.next();
        }
        return null;
    }

    public u1.a<E> pollFirstEntry() {
        Iterator<u1.a<E>> entryIterator = entryIterator();
        if (!entryIterator.hasNext()) {
            return null;
        }
        u1.a<E> next = entryIterator.next();
        u1.a<E> g = v1.g(next.a(), next.getCount());
        entryIterator.remove();
        return g;
    }

    public u1.a<E> pollLastEntry() {
        Iterator<u1.a<E>> descendingEntryIterator = descendingEntryIterator();
        if (!descendingEntryIterator.hasNext()) {
            return null;
        }
        u1.a<E> next = descendingEntryIterator.next();
        u1.a<E> g = v1.g(next.a(), next.getCount());
        descendingEntryIterator.remove();
        return g;
    }

    public a3<E> subMultiset(@NullableDecl E e2, BoundType boundType, @NullableDecl E e3, BoundType boundType2) {
        n.o(boundType);
        n.o(boundType2);
        return tailMultiset(e2, boundType).headMultiset(e3, boundType2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Comparator<? super E> comparator) {
        this.comparator = (Comparator) n.o(comparator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.i
    public NavigableSet<E> createElementSet() {
        return new b3.b(this);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.u1
    public NavigableSet<E> elementSet() {
        return (NavigableSet) super.elementSet();
    }
}

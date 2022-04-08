package com.google.common.collect;

import com.google.common.collect.b3;
import com.google.common.collect.u1;
import com.google.common.collect.v1;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* compiled from: DescendingMultiset.java */
/* loaded from: classes2.dex */
abstract class h0<E> extends r0<E> implements a3<E> {
    @MonotonicNonNullDecl

    /* renamed from: c  reason: collision with root package name */
    private transient Comparator<? super E> f4467c;
    @MonotonicNonNullDecl

    /* renamed from: d  reason: collision with root package name */
    private transient NavigableSet<E> f4468d;
    @MonotonicNonNullDecl

    /* renamed from: f  reason: collision with root package name */
    private transient Set<u1.a<E>> f4469f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DescendingMultiset.java */
    /* loaded from: classes2.dex */
    public class a extends v1.d<E> {
        a() {
        }

        @Override // com.google.common.collect.v1.d
        u1<E> c() {
            return h0.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<u1.a<E>> iterator() {
            return h0.this.d();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h0.this.f().entrySet().size();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.r0
    /* renamed from: a */
    public u1<E> delegate() {
        return f();
    }

    Set<u1.a<E>> b() {
        return new a();
    }

    @Override // com.google.common.collect.a3, com.google.common.collect.x2
    public Comparator<? super E> comparator() {
        Comparator<? super E> comparator = this.f4467c;
        if (comparator != null) {
            return comparator;
        }
        a2 j = a2.a(f().comparator()).j();
        this.f4467c = j;
        return j;
    }

    abstract Iterator<u1.a<E>> d();

    @Override // com.google.common.collect.a3
    public a3<E> descendingMultiset() {
        return f();
    }

    @Override // com.google.common.collect.r0, com.google.common.collect.u1
    public Set<u1.a<E>> entrySet() {
        Set<u1.a<E>> set = this.f4469f;
        if (set != null) {
            return set;
        }
        Set<u1.a<E>> b2 = b();
        this.f4469f = b2;
        return b2;
    }

    abstract a3<E> f();

    @Override // com.google.common.collect.a3
    public u1.a<E> firstEntry() {
        return f().lastEntry();
    }

    @Override // com.google.common.collect.a3
    public a3<E> headMultiset(E e2, BoundType boundType) {
        return f().tailMultiset(e2, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.a3
    public u1.a<E> lastEntry() {
        return f().firstEntry();
    }

    @Override // com.google.common.collect.a3
    public u1.a<E> pollFirstEntry() {
        return f().pollLastEntry();
    }

    @Override // com.google.common.collect.a3
    public u1.a<E> pollLastEntry() {
        return f().pollFirstEntry();
    }

    @Override // com.google.common.collect.a3
    public a3<E> subMultiset(E e2, BoundType boundType, E e3, BoundType boundType2) {
        return f().subMultiset(e3, boundType2, e2, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.a3
    public a3<E> tailMultiset(E e2, BoundType boundType) {
        return f().headMultiset(e2, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.n0, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return standardToArray();
    }

    @Override // com.google.common.collect.s0
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.u1
    public NavigableSet<E> elementSet() {
        NavigableSet<E> navigableSet = this.f4468d;
        if (navigableSet != null) {
            return navigableSet;
        }
        b3.b bVar = new b3.b(this);
        this.f4468d = bVar;
        return bVar;
    }

    @Override // com.google.common.collect.n0, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) standardToArray(tArr);
    }
}

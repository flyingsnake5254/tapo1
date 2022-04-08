package com.google.common.collect;

import com.google.common.collect.e;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: AbstractSortedSetMultimap.java */
/* loaded from: classes2.dex */
abstract class p<K, V> extends m<K, V> implements s2 {
    private static final long serialVersionUID = 430848587173315748L;

    /* JADX INFO: Access modifiers changed from: protected */
    public p(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // com.google.common.collect.m, com.google.common.collect.h, com.google.common.collect.r1
    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.m, com.google.common.collect.e
    abstract /* bridge */ /* synthetic */ Collection createCollection();

    @Override // com.google.common.collect.m, com.google.common.collect.e
    abstract /* bridge */ /* synthetic */ Set createCollection();

    @Override // com.google.common.collect.m, com.google.common.collect.e
    abstract SortedSet<V> createCollection();

    @Override // com.google.common.collect.m, com.google.common.collect.e, com.google.common.collect.r1
    public abstract /* bridge */ /* synthetic */ Collection get(@NullableDecl Object obj);

    @Override // com.google.common.collect.m, com.google.common.collect.e, com.google.common.collect.r1
    public abstract /* bridge */ /* synthetic */ Set get(@NullableDecl Object obj);

    @Override // com.google.common.collect.m, com.google.common.collect.e, com.google.common.collect.r1
    public SortedSet<V> get(@NullableDecl K k) {
        return (SortedSet) super.get((p<K, V>) k);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.h, com.google.common.collect.r1
    public Collection<V> values() {
        return super.values();
    }

    @Override // com.google.common.collect.m, com.google.common.collect.e
    Collection<V> wrapCollection(K k, Collection<V> collection) {
        if (collection instanceof NavigableSet) {
            return new e.m(k, (NavigableSet) collection, null);
        }
        return new e.o(k, (SortedSet) collection, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.m, com.google.common.collect.e
    public <E> SortedSet<E> unmodifiableCollectionSubclass(Collection<E> collection) {
        if (collection instanceof NavigableSet) {
            return u2.i((NavigableSet) collection);
        }
        return Collections.unmodifiableSortedSet((SortedSet) collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.m, com.google.common.collect.e
    public SortedSet<V> createUnmodifiableEmptyCollection() {
        return (SortedSet<V>) unmodifiableCollectionSubclass((Collection) createCollection());
    }

    @Override // com.google.common.collect.m, com.google.common.collect.e, com.google.common.collect.r1
    @CanIgnoreReturnValue
    public SortedSet<V> removeAll(@NullableDecl Object obj) {
        return (SortedSet) super.removeAll(obj);
    }

    @Override // com.google.common.collect.m, com.google.common.collect.e, com.google.common.collect.h
    @CanIgnoreReturnValue
    public SortedSet<V> replaceValues(@NullableDecl K k, Iterable<? extends V> iterable) {
        return (SortedSet) super.replaceValues((p<K, V>) k, (Iterable) iterable);
    }
}

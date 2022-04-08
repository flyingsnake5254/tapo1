package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: AbstractListMultimap.java */
/* loaded from: classes2.dex */
abstract class d<K, V> extends e<K, V> implements m1<K, V> {
    private static final long serialVersionUID = 6588350623831699109L;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.r1
    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.e
    abstract /* bridge */ /* synthetic */ Collection createCollection();

    @Override // com.google.common.collect.e
    abstract List<V> createCollection();

    @Override // com.google.common.collect.h
    public boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.h, com.google.common.collect.r1
    @CanIgnoreReturnValue
    public boolean put(@NullableDecl K k, @NullableDecl V v) {
        return super.put(k, v);
    }

    @Override // com.google.common.collect.e
    <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
        return Collections.unmodifiableList((List) collection);
    }

    @Override // com.google.common.collect.e
    Collection<V> wrapCollection(K k, Collection<V> collection) {
        return wrapList(k, (List) collection, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.e
    public List<V> createUnmodifiableEmptyCollection() {
        return Collections.emptyList();
    }

    @Override // com.google.common.collect.e, com.google.common.collect.r1
    public List<V> get(@NullableDecl K k) {
        return (List) super.get((d<K, V>) k);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.r1
    @CanIgnoreReturnValue
    public List<V> removeAll(@NullableDecl Object obj) {
        return (List) super.removeAll(obj);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.h
    @CanIgnoreReturnValue
    public List<V> replaceValues(@NullableDecl K k, Iterable<? extends V> iterable) {
        return (List) super.replaceValues((d<K, V>) k, (Iterable) iterable);
    }
}

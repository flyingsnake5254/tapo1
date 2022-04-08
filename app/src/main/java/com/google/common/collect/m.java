package com.google.common.collect;

import com.google.common.collect.e;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: AbstractSetMultimap.java */
/* loaded from: classes2.dex */
abstract class m<K, V> extends e<K, V> implements s2<K, V> {
    private static final long serialVersionUID = 7431625294878419160L;

    /* JADX INFO: Access modifiers changed from: protected */
    public m(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.r1
    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.e
    abstract /* bridge */ /* synthetic */ Collection createCollection();

    @Override // com.google.common.collect.e
    abstract Set<V> createCollection();

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
        return Collections.unmodifiableSet((Set) collection);
    }

    @Override // com.google.common.collect.e
    Collection<V> wrapCollection(K k, Collection<V> collection) {
        return new e.n(k, (Set) collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.e
    public Set<V> createUnmodifiableEmptyCollection() {
        return Collections.emptySet();
    }

    @Override // com.google.common.collect.e, com.google.common.collect.h, com.google.common.collect.r1
    public Set<Map.Entry<K, V>> entries() {
        return (Set) super.entries();
    }

    @Override // com.google.common.collect.e, com.google.common.collect.r1
    public Set<V> get(@NullableDecl K k) {
        return (Set) super.get((m<K, V>) k);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.r1
    @CanIgnoreReturnValue
    public Set<V> removeAll(@NullableDecl Object obj) {
        return (Set) super.removeAll(obj);
    }

    @Override // com.google.common.collect.e, com.google.common.collect.h
    @CanIgnoreReturnValue
    public Set<V> replaceValues(@NullableDecl K k, Iterable<? extends V> iterable) {
        return (Set) super.replaceValues((m<K, V>) k, (Iterable) iterable);
    }
}

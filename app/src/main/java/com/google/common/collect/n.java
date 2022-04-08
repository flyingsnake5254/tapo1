package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* compiled from: AbstractSortedKeySortedSetMultimap.java */
/* loaded from: classes2.dex */
abstract class n<K, V> extends p<K, V> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public n(SortedMap<K, Collection<V>> sortedMap) {
        super(sortedMap);
    }

    @Override // com.google.common.collect.p, com.google.common.collect.m, com.google.common.collect.h, com.google.common.collect.r1
    public abstract /* bridge */ /* synthetic */ Map asMap();

    @Override // com.google.common.collect.p, com.google.common.collect.m, com.google.common.collect.h, com.google.common.collect.r1
    public SortedMap<K, Collection<V>> asMap() {
        return (SortedMap) super.asMap();
    }

    @Override // com.google.common.collect.e, com.google.common.collect.h
    Set<K> createKeySet() {
        return createMaybeNavigableKeySet();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.r1
    public abstract /* bridge */ /* synthetic */ Set keySet();

    @Override // com.google.common.collect.h, com.google.common.collect.r1
    public SortedSet<K> keySet() {
        return (SortedSet) super.keySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.e
    public SortedMap<K, Collection<V>> backingMap() {
        return (SortedMap) super.backingMap();
    }
}

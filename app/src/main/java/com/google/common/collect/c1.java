package com.google.common.collect;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImmutableMapKeySet.java */
/* loaded from: classes2.dex */
public final class c1<K, V> extends i1<K> {

    /* renamed from: c  reason: collision with root package name */
    private final ImmutableMap<K, V> f4381c;

    /* compiled from: ImmutableMapKeySet.java */
    /* loaded from: classes2.dex */
    private static class a<K> implements Serializable {

        /* renamed from: c  reason: collision with root package name */
        final ImmutableMap<K, ?> f4382c;

        a(ImmutableMap<K, ?> immutableMap) {
            this.f4382c = immutableMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c1(ImmutableMap<K, V> immutableMap) {
        this.f4381c = immutableMap;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(@NullableDecl Object obj) {
        return this.f4381c.containsKey(obj);
    }

    @Override // com.google.common.collect.i1
    K get(int i) {
        return this.f4381c.entrySet().asList().get(i).getKey();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f4381c.size();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new a(this.f4381c);
    }

    @Override // com.google.common.collect.i1, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public j3<K> iterator() {
        return this.f4381c.keyIterator();
    }
}

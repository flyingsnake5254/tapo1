package com.google.common.collect;

import java.io.Serializable;

/* compiled from: ImmutableAsList.java */
/* loaded from: classes2.dex */
abstract class z0<E> extends ImmutableList<E> {

    /* compiled from: ImmutableAsList.java */
    /* loaded from: classes2.dex */
    static class a implements Serializable {

        /* renamed from: c  reason: collision with root package name */
        final ImmutableCollection<?> f4666c;

        a(ImmutableCollection<?> immutableCollection) {
            this.f4666c = immutableCollection;
        }
    }

    abstract ImmutableCollection<E> a();

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return a().contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return a().isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return a().isPartialView();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return a().size();
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new a(a());
    }
}

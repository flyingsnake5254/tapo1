package com.google.common.collect;

import com.google.common.base.n;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RegularImmutableList.java */
/* loaded from: classes2.dex */
public class i2<E> extends ImmutableList<E> {

    /* renamed from: c  reason: collision with root package name */
    static final ImmutableList<Object> f4481c = new i2(new Object[0], 0);

    /* renamed from: d  reason: collision with root package name */
    final transient Object[] f4482d;

    /* renamed from: f  reason: collision with root package name */
    private final transient int f4483f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i2(Object[] objArr, int i) {
        this.f4482d = objArr;
        this.f4483f = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i) {
        System.arraycopy(this.f4482d, 0, objArr, i, this.f4483f);
        return i + this.f4483f;
    }

    @Override // java.util.List
    public E get(int i) {
        n.m(i, this.f4483f);
        return (E) this.f4482d[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public Object[] internalArray() {
        return this.f4482d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayEnd() {
        return this.f4483f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayStart() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f4483f;
    }
}

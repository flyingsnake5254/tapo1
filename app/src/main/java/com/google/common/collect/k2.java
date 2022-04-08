package com.google.common.collect;

import com.google.common.collect.u1;
import com.google.common.primitives.d;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: RegularImmutableMultiset.java */
/* loaded from: classes2.dex */
class k2<E> extends ImmutableMultiset<E> {

    /* renamed from: c  reason: collision with root package name */
    static final k2<Object> f4524c = new k2<>(y1.b());

    /* renamed from: d  reason: collision with root package name */
    final transient y1<E> f4525d;

    /* renamed from: f  reason: collision with root package name */
    private final transient int f4526f;
    @LazyInit
    private transient ImmutableSet<E> q;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RegularImmutableMultiset.java */
    /* loaded from: classes2.dex */
    public final class b extends i1<E> {
        private b() {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            return k2.this.contains(obj);
        }

        @Override // com.google.common.collect.i1
        E get(int i) {
            return k2.this.f4525d.i(i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return k2.this.f4525d.C();
        }
    }

    /* compiled from: RegularImmutableMultiset.java */
    /* loaded from: classes2.dex */
    private static class c implements Serializable {

        /* renamed from: c  reason: collision with root package name */
        final Object[] f4528c;

        /* renamed from: d  reason: collision with root package name */
        final int[] f4529d;

        c(u1<?> u1Var) {
            int size = u1Var.entrySet().size();
            this.f4528c = new Object[size];
            this.f4529d = new int[size];
            int i = 0;
            for (u1.a<?> aVar : u1Var.entrySet()) {
                this.f4528c[i] = aVar.a();
                this.f4529d[i] = aVar.getCount();
                i++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k2(y1<E> y1Var) {
        this.f4525d = y1Var;
        long j = 0;
        for (int i = 0; i < y1Var.C(); i++) {
            j += y1Var.k(i);
        }
        this.f4526f = d.i(j);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.u1
    public int count(@NullableDecl Object obj) {
        return this.f4525d.f(obj);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    u1.a<E> getEntry(int i) {
        return this.f4525d.g(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.u1
    public int size() {
        return this.f4526f;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new c(this);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.u1
    public ImmutableSet<E> elementSet() {
        ImmutableSet<E> immutableSet = this.q;
        if (immutableSet != null) {
            return immutableSet;
        }
        b bVar = new b();
        this.q = bVar;
        return bVar;
    }
}

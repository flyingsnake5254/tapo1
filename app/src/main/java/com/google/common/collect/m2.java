package com.google.common.collect;

import com.google.common.base.n;
import com.google.common.collect.u1;
import com.google.common.primitives.d;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RegularImmutableSortedMultiset.java */
/* loaded from: classes2.dex */
public final class m2<E> extends ImmutableSortedMultiset<E> {

    /* renamed from: c  reason: collision with root package name */
    private static final long[] f4539c = {0};

    /* renamed from: d  reason: collision with root package name */
    static final ImmutableSortedMultiset<Comparable> f4540d = new m2(a2.g());

    /* renamed from: f  reason: collision with root package name */
    final transient n2<E> f4541f;
    private final transient long[] q;
    private final transient int x;
    private final transient int y;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m2(Comparator<? super E> comparator) {
        this.f4541f = ImmutableSortedSet.emptySet(comparator);
        this.q = f4539c;
        this.x = 0;
        this.y = 0;
    }

    private int a(int i) {
        long[] jArr = this.q;
        int i2 = this.x;
        return (int) (jArr[(i2 + i) + 1] - jArr[i2 + i]);
    }

    ImmutableSortedMultiset<E> b(int i, int i2) {
        n.t(i, i2, this.y);
        if (i == i2) {
            return ImmutableSortedMultiset.emptyMultiset(comparator());
        }
        return (i == 0 && i2 == this.y) ? this : new m2(this.f4541f.a(i, i2), this.q, this.x + i, i2 - i);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.u1
    public int count(@NullableDecl Object obj) {
        int indexOf = this.f4541f.indexOf(obj);
        if (indexOf >= 0) {
            return a(indexOf);
        }
        return 0;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.a3
    public u1.a<E> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(0);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    u1.a<E> getEntry(int i) {
        return v1.g(this.f4541f.asList().get(i), a(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.x > 0 || this.y < this.q.length - 1;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.a3
    public u1.a<E> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(this.y - 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.u1
    public int size() {
        long[] jArr = this.q;
        int i = this.x;
        return d.i(jArr[this.y + i] - jArr[i]);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.a3
    public ImmutableSortedMultiset<E> headMultiset(E e2, BoundType boundType) {
        return b(0, this.f4541f.b(e2, n.o(boundType) == BoundType.CLOSED));
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.a3
    public ImmutableSortedMultiset<E> tailMultiset(E e2, BoundType boundType) {
        return b(this.f4541f.d(e2, n.o(boundType) == BoundType.CLOSED), this.y);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.u1
    public ImmutableSortedSet<E> elementSet() {
        return this.f4541f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m2(n2<E> n2Var, long[] jArr, int i, int i2) {
        this.f4541f = n2Var;
        this.q = jArr;
        this.x = i;
        this.y = i2;
    }
}

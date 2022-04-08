package com.google.common.collect;

import com.google.common.base.n;
import java.util.NoSuchElementException;

/* compiled from: AbstractIndexedListIterator.java */
/* loaded from: classes2.dex */
abstract class b<E> extends k3<E> {

    /* renamed from: c  reason: collision with root package name */
    private final int f4368c;

    /* renamed from: d  reason: collision with root package name */
    private int f4369d;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(int i) {
        this(i, 0);
    }

    protected abstract E a(int i);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f4369d < this.f4368c;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f4369d > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (hasNext()) {
            int i = this.f4369d;
            this.f4369d = i + 1;
            return a(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f4369d;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            int i = this.f4369d - 1;
            this.f4369d = i;
            return a(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f4369d - 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(int i, int i2) {
        n.r(i2, i);
        this.f4368c = i;
        this.f4369d = i2;
    }
}

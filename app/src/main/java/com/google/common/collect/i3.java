package com.google.common.collect;

import java.util.ListIterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TransformedListIterator.java */
/* loaded from: classes2.dex */
public abstract class i3<F, T> extends h3<F, T> implements ListIterator<T> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public i3(ListIterator<? extends F> listIterator) {
        super(listIterator);
    }

    private ListIterator<? extends F> b() {
        return k1.c(this.f4474c);
    }

    @Override // java.util.ListIterator
    public void add(T t) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return b().hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return b().nextIndex();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.ListIterator
    public final T previous() {
        return (T) a(b().previous());
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return b().previousIndex();
    }

    public void set(T t) {
        throw new UnsupportedOperationException();
    }
}

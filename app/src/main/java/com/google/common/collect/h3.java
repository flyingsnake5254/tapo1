package com.google.common.collect;

import com.google.common.base.n;
import java.util.Iterator;

/* compiled from: TransformedIterator.java */
/* loaded from: classes2.dex */
abstract class h3<F, T> implements Iterator<T> {

    /* renamed from: c  reason: collision with root package name */
    final Iterator<? extends F> f4474c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h3(Iterator<? extends F> it) {
        this.f4474c = (Iterator) n.o(it);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T a(F f2);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f4474c.hasNext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Iterator
    public final T next() {
        return (T) a(this.f4474c.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f4474c.remove();
    }
}

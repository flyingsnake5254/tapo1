package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Queue;

/* compiled from: ForwardingQueue.java */
/* loaded from: classes2.dex */
public abstract class t0<E> extends n0<E> implements Queue<E> {
    @Override // com.google.common.collect.n0, com.google.common.collect.s0
    protected abstract /* bridge */ /* synthetic */ Object delegate();

    @Override // com.google.common.collect.n0, com.google.common.collect.s0
    protected abstract /* bridge */ /* synthetic */ Collection delegate();

    @Override // com.google.common.collect.n0, com.google.common.collect.s0
    protected abstract Queue<E> delegate();

    @Override // java.util.Queue
    public E element() {
        return delegate().element();
    }

    @CanIgnoreReturnValue
    public abstract boolean offer(E e2);

    @Override // java.util.Queue
    public E peek() {
        return delegate().peek();
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    public E poll() {
        return delegate().poll();
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    public E remove() {
        return delegate().remove();
    }

    protected boolean standardOffer(E e2) {
        try {
            return add(e2);
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    protected E standardPeek() {
        try {
            return element();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }

    protected E standardPoll() {
        try {
            return remove();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }
}

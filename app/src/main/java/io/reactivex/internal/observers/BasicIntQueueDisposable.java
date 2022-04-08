package io.reactivex.internal.observers;

import io.reactivex.h0.b.d;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public abstract class BasicIntQueueDisposable<T> extends AtomicInteger implements d<T> {
    private static final long serialVersionUID = -1001730202384742097L;

    @Override // io.reactivex.h0.b.i
    public abstract /* synthetic */ void clear();

    public abstract /* synthetic */ void dispose();

    @Override // io.reactivex.e0.c
    public abstract /* synthetic */ boolean isDisposed();

    @Override // io.reactivex.h0.b.i
    public abstract /* synthetic */ boolean isEmpty();

    @Override // io.reactivex.h0.b.i
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }

    @Override // io.reactivex.h0.b.i
    public abstract /* synthetic */ T poll() throws Exception;

    @Override // io.reactivex.h0.b.e
    public abstract /* synthetic */ int requestFusion(int i);

    public final boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called");
    }
}

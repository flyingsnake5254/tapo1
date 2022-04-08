package io.reactivex.internal.subscriptions;

import io.reactivex.h0.b.f;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes4.dex */
public abstract class BasicQueueSubscription<T> extends AtomicLong implements f<T> {
    private static final long serialVersionUID = -6671519529404341862L;

    @Override // e.b.c
    public abstract /* synthetic */ void cancel();

    @Override // io.reactivex.h0.b.i
    public abstract /* synthetic */ void clear();

    @Override // io.reactivex.h0.b.i
    public abstract /* synthetic */ boolean isEmpty();

    @Override // io.reactivex.h0.b.i
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.h0.b.i
    public abstract /* synthetic */ T poll() throws Exception;

    @Override // e.b.c
    public abstract /* synthetic */ void request(long j);

    @Override // io.reactivex.h0.b.e
    public abstract /* synthetic */ int requestFusion(int i);

    public final boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}

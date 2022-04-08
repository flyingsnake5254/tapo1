package io.reactivex.internal.observers;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.v;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class BlockingObserver<T> extends AtomicReference<c> implements v<T>, c {
    public static final Object TERMINATED = new Object();
    private static final long serialVersionUID = -4875965440900746268L;
    final Queue<Object> queue;

    public BlockingObserver(Queue<Object> queue) {
        this.queue = queue;
    }

    @Override // io.reactivex.e0.c
    public void dispose() {
        if (DisposableHelper.dispose(this)) {
            this.queue.offer(TERMINATED);
        }
    }

    @Override // io.reactivex.e0.c
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.v
    public void onComplete() {
        this.queue.offer(NotificationLite.complete());
    }

    @Override // io.reactivex.v
    public void onError(Throwable th) {
        this.queue.offer(NotificationLite.error(th));
    }

    @Override // io.reactivex.v
    public void onNext(T t) {
        this.queue.offer(NotificationLite.next(t));
    }

    @Override // io.reactivex.v
    public void onSubscribe(c cVar) {
        DisposableHelper.setOnce(this, cVar);
    }
}

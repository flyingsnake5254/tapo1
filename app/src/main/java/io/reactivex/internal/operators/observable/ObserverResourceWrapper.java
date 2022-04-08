package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class ObserverResourceWrapper<T> extends AtomicReference<c> implements v<T>, c {
    private static final long serialVersionUID = -8612022020200669122L;
    final v<? super T> downstream;
    final AtomicReference<c> upstream = new AtomicReference<>();

    public ObserverResourceWrapper(v<? super T> vVar) {
        this.downstream = vVar;
    }

    @Override // io.reactivex.e0.c
    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.e0.c
    public boolean isDisposed() {
        return this.upstream.get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.v
    public void onComplete() {
        dispose();
        this.downstream.onComplete();
    }

    @Override // io.reactivex.v
    public void onError(Throwable th) {
        dispose();
        this.downstream.onError(th);
    }

    @Override // io.reactivex.v
    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    @Override // io.reactivex.v
    public void onSubscribe(c cVar) {
        if (DisposableHelper.setOnce(this.upstream, cVar)) {
            this.downstream.onSubscribe(this);
        }
    }

    public void setResource(c cVar) {
        DisposableHelper.set(this, cVar);
    }
}

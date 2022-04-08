package io.reactivex.internal.observers;

import io.reactivex.e0.c;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.j0.a;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class EmptyCompletableObserver extends AtomicReference<c> implements io.reactivex.c, c {
    private static final long serialVersionUID = -7545121636549663526L;

    @Override // io.reactivex.e0.c
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return false;
    }

    @Override // io.reactivex.e0.c
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.c
    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // io.reactivex.c
    public void onError(Throwable th) {
        lazySet(DisposableHelper.DISPOSED);
        a.r(new OnErrorNotImplementedException(th));
    }

    @Override // io.reactivex.c
    public void onSubscribe(c cVar) {
        DisposableHelper.setOnce(this, cVar);
    }
}

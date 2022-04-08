package io.reactivex.internal.observers;

import io.reactivex.e0.c;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.g0.a;
import io.reactivex.g0.g;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class CallbackCompletableObserver extends AtomicReference<c> implements io.reactivex.c, c, g<Throwable> {
    private static final long serialVersionUID = -4361286194466301354L;
    final a onComplete;
    final g<? super Throwable> onError;

    public CallbackCompletableObserver(a aVar) {
        this.onError = this;
        this.onComplete = aVar;
    }

    @Override // io.reactivex.e0.c
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return this.onError != this;
    }

    @Override // io.reactivex.e0.c
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.c
    public void onComplete() {
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            io.reactivex.j0.a.r(th);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // io.reactivex.c
    public void onError(Throwable th) {
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            io.reactivex.j0.a.r(th2);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // io.reactivex.c
    public void onSubscribe(c cVar) {
        DisposableHelper.setOnce(this, cVar);
    }

    public void accept(Throwable th) {
        io.reactivex.j0.a.r(new OnErrorNotImplementedException(th));
    }

    public CallbackCompletableObserver(g<? super Throwable> gVar, a aVar) {
        this.onError = gVar;
        this.onComplete = aVar;
    }
}

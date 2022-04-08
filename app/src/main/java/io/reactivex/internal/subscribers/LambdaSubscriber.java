package io.reactivex.internal.subscribers;

import e.b.c;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.g0.a;
import io.reactivex.g0.g;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.k;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class LambdaSubscriber<T> extends AtomicReference<c> implements k<T>, c, io.reactivex.e0.c {
    private static final long serialVersionUID = -7251123623727029452L;
    final a onComplete;
    final g<? super Throwable> onError;
    final g<? super T> onNext;
    final g<? super c> onSubscribe;

    public LambdaSubscriber(g<? super T> gVar, g<? super Throwable> gVar2, a aVar, g<? super c> gVar3) {
        this.onNext = gVar;
        this.onError = gVar2;
        this.onComplete = aVar;
        this.onSubscribe = gVar3;
    }

    @Override // e.b.c
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // io.reactivex.e0.c
    public void dispose() {
        cancel();
    }

    public boolean hasCustomOnError() {
        return this.onError != io.reactivex.h0.a.a.f15638f;
    }

    @Override // io.reactivex.e0.c
    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    @Override // e.b.b
    public void onComplete() {
        c cVar = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (cVar != subscriptionHelper) {
            lazySet(subscriptionHelper);
            try {
                this.onComplete.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                io.reactivex.j0.a.r(th);
            }
        }
    }

    @Override // e.b.b
    public void onError(Throwable th) {
        c cVar = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (cVar != subscriptionHelper) {
            lazySet(subscriptionHelper);
            try {
                this.onError.accept(th);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                io.reactivex.j0.a.r(new CompositeException(th, th2));
            }
        } else {
            io.reactivex.j0.a.r(th);
        }
    }

    @Override // e.b.b
    public void onNext(T t) {
        if (!isDisposed()) {
            try {
                this.onNext.accept(t);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                get().cancel();
                onError(th);
            }
        }
    }

    @Override // io.reactivex.k, e.b.b
    public void onSubscribe(c cVar) {
        if (SubscriptionHelper.setOnce(this, cVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                cVar.cancel();
                onError(th);
            }
        }
    }

    @Override // e.b.c
    public void request(long j) {
        get().request(j);
    }
}

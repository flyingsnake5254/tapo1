package io.reactivex.internal.operators.maybe;

import e.b.b;
import io.reactivex.e0.c;
import io.reactivex.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.n;
import io.reactivex.o;

/* compiled from: MaybeToFlowable.java */
/* loaded from: classes4.dex */
public final class i<T> extends h<T> {

    /* renamed from: d  reason: collision with root package name */
    final o<T> f15881d;

    /* compiled from: MaybeToFlowable.java */
    /* loaded from: classes4.dex */
    static final class a<T> extends DeferredScalarSubscription<T> implements n<T> {

        /* renamed from: c  reason: collision with root package name */
        c f15882c;

        a(b<? super T> bVar) {
            super(bVar);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, e.b.c
        public void cancel() {
            super.cancel();
            this.f15882c.dispose();
        }

        @Override // io.reactivex.n
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.n
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.n
        public void onSubscribe(c cVar) {
            if (DisposableHelper.validate(this.f15882c, cVar)) {
                this.f15882c = cVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.n
        public void onSuccess(T t) {
            complete(t);
        }
    }

    public i(o<T> oVar) {
        this.f15881d = oVar;
    }

    @Override // io.reactivex.h
    protected void H(b<? super T> bVar) {
        this.f15881d.a(new a(bVar));
    }
}

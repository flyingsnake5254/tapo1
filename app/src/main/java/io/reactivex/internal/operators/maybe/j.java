package io.reactivex.internal.operators.maybe;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.n;
import io.reactivex.o;
import io.reactivex.q;
import io.reactivex.v;

/* compiled from: MaybeToObservable.java */
/* loaded from: classes4.dex */
public final class j<T> extends q<T> {

    /* renamed from: c  reason: collision with root package name */
    final o<T> f15883c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MaybeToObservable.java */
    /* loaded from: classes4.dex */
    public static final class a<T> extends DeferredScalarDisposable<T> implements n<T> {

        /* renamed from: c  reason: collision with root package name */
        c f15884c;

        a(v<? super T> vVar) {
            super(vVar);
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.e0.c
        public void dispose() {
            super.dispose();
            this.f15884c.dispose();
        }

        @Override // io.reactivex.n
        public void onComplete() {
            complete();
        }

        @Override // io.reactivex.n
        public void onError(Throwable th) {
            error(th);
        }

        @Override // io.reactivex.n
        public void onSubscribe(c cVar) {
            if (DisposableHelper.validate(this.f15884c, cVar)) {
                this.f15884c = cVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.n
        public void onSuccess(T t) {
            complete(t);
        }
    }

    public j(o<T> oVar) {
        this.f15883c = oVar;
    }

    public static <T> n<T> j1(v<? super T> vVar) {
        return new a(vVar);
    }

    @Override // io.reactivex.q
    protected void K0(v<? super T> vVar) {
        this.f15883c.a(j1(vVar));
    }
}

package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.g0.j;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;
import io.reactivex.v;

/* compiled from: ObservableOnErrorReturn.java */
/* loaded from: classes4.dex */
public final class l0<T> extends a<T, T> {

    /* renamed from: d  reason: collision with root package name */
    final j<? super Throwable, ? extends T> f16028d;

    /* compiled from: ObservableOnErrorReturn.java */
    /* loaded from: classes4.dex */
    static final class a<T> implements v<T>, c {

        /* renamed from: c  reason: collision with root package name */
        final v<? super T> f16029c;

        /* renamed from: d  reason: collision with root package name */
        final j<? super Throwable, ? extends T> f16030d;

        /* renamed from: f  reason: collision with root package name */
        c f16031f;

        a(v<? super T> vVar, j<? super Throwable, ? extends T> jVar) {
            this.f16029c = vVar;
            this.f16030d = jVar;
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            this.f16031f.dispose();
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.f16031f.isDisposed();
        }

        @Override // io.reactivex.v
        public void onComplete() {
            this.f16029c.onComplete();
        }

        @Override // io.reactivex.v
        public void onError(Throwable th) {
            try {
                Object apply = this.f16030d.apply(th);
                if (apply == null) {
                    NullPointerException nullPointerException = new NullPointerException("The supplied value is null");
                    nullPointerException.initCause(th);
                    this.f16029c.onError(nullPointerException);
                    return;
                }
                this.f16029c.onNext(apply);
                this.f16029c.onComplete();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f16029c.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.v
        public void onNext(T t) {
            this.f16029c.onNext(t);
        }

        @Override // io.reactivex.v
        public void onSubscribe(c cVar) {
            if (DisposableHelper.validate(this.f16031f, cVar)) {
                this.f16031f = cVar;
                this.f16029c.onSubscribe(this);
            }
        }
    }

    public l0(t<T> tVar, j<? super Throwable, ? extends T> jVar) {
        super(tVar);
        this.f16028d = jVar;
    }

    @Override // io.reactivex.q
    public void K0(v<? super T> vVar) {
        this.f15892c.a(new a(vVar, this.f16028d));
    }
}

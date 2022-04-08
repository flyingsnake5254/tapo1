package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;
import io.reactivex.v;

/* compiled from: ObservableSkip.java */
/* loaded from: classes4.dex */
public final class u0<T> extends a<T, T> {

    /* renamed from: d  reason: collision with root package name */
    final long f16110d;

    /* compiled from: ObservableSkip.java */
    /* loaded from: classes4.dex */
    static final class a<T> implements v<T>, c {

        /* renamed from: c  reason: collision with root package name */
        final v<? super T> f16111c;

        /* renamed from: d  reason: collision with root package name */
        long f16112d;

        /* renamed from: f  reason: collision with root package name */
        c f16113f;

        a(v<? super T> vVar, long j) {
            this.f16111c = vVar;
            this.f16112d = j;
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            this.f16113f.dispose();
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.f16113f.isDisposed();
        }

        @Override // io.reactivex.v
        public void onComplete() {
            this.f16111c.onComplete();
        }

        @Override // io.reactivex.v
        public void onError(Throwable th) {
            this.f16111c.onError(th);
        }

        @Override // io.reactivex.v
        public void onNext(T t) {
            long j = this.f16112d;
            if (j != 0) {
                this.f16112d = j - 1;
            } else {
                this.f16111c.onNext(t);
            }
        }

        @Override // io.reactivex.v
        public void onSubscribe(c cVar) {
            if (DisposableHelper.validate(this.f16113f, cVar)) {
                this.f16113f = cVar;
                this.f16111c.onSubscribe(this);
            }
        }
    }

    public u0(t<T> tVar, long j) {
        super(tVar);
        this.f16110d = j;
    }

    @Override // io.reactivex.q
    public void K0(v<? super T> vVar) {
        this.f15892c.a(new a(vVar, this.f16110d));
    }
}

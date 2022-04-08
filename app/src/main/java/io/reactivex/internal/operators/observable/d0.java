package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.t;
import io.reactivex.v;

/* compiled from: ObservableIgnoreElements.java */
/* loaded from: classes4.dex */
public final class d0<T> extends a<T, T> {

    /* compiled from: ObservableIgnoreElements.java */
    /* loaded from: classes4.dex */
    static final class a<T> implements v<T>, c {

        /* renamed from: c  reason: collision with root package name */
        final v<? super T> f15940c;

        /* renamed from: d  reason: collision with root package name */
        c f15941d;

        a(v<? super T> vVar) {
            this.f15940c = vVar;
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            this.f15941d.dispose();
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.f15941d.isDisposed();
        }

        @Override // io.reactivex.v
        public void onComplete() {
            this.f15940c.onComplete();
        }

        @Override // io.reactivex.v
        public void onError(Throwable th) {
            this.f15940c.onError(th);
        }

        @Override // io.reactivex.v
        public void onNext(T t) {
        }

        @Override // io.reactivex.v
        public void onSubscribe(c cVar) {
            this.f15941d = cVar;
            this.f15940c.onSubscribe(this);
        }
    }

    public d0(t<T> tVar) {
        super(tVar);
    }

    @Override // io.reactivex.q
    public void K0(v<? super T> vVar) {
        this.f15892c.a(new a(vVar));
    }
}

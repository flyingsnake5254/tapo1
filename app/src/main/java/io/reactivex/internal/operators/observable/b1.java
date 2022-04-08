package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.g0.l;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;
import io.reactivex.v;

/* compiled from: ObservableTakeUntilPredicate.java */
/* loaded from: classes4.dex */
public final class b1<T> extends a<T, T> {

    /* renamed from: d  reason: collision with root package name */
    final l<? super T> f15901d;

    /* compiled from: ObservableTakeUntilPredicate.java */
    /* loaded from: classes4.dex */
    static final class a<T> implements v<T>, c {

        /* renamed from: c  reason: collision with root package name */
        final v<? super T> f15902c;

        /* renamed from: d  reason: collision with root package name */
        final l<? super T> f15903d;

        /* renamed from: f  reason: collision with root package name */
        c f15904f;
        boolean q;

        a(v<? super T> vVar, l<? super T> lVar) {
            this.f15902c = vVar;
            this.f15903d = lVar;
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            this.f15904f.dispose();
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.f15904f.isDisposed();
        }

        @Override // io.reactivex.v
        public void onComplete() {
            if (!this.q) {
                this.q = true;
                this.f15902c.onComplete();
            }
        }

        @Override // io.reactivex.v
        public void onError(Throwable th) {
            if (!this.q) {
                this.q = true;
                this.f15902c.onError(th);
                return;
            }
            io.reactivex.j0.a.r(th);
        }

        @Override // io.reactivex.v
        public void onNext(T t) {
            if (!this.q) {
                this.f15902c.onNext(t);
                try {
                    if (this.f15903d.test(t)) {
                        this.q = true;
                        this.f15904f.dispose();
                        this.f15902c.onComplete();
                    }
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.f15904f.dispose();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.v
        public void onSubscribe(c cVar) {
            if (DisposableHelper.validate(this.f15904f, cVar)) {
                this.f15904f = cVar;
                this.f15902c.onSubscribe(this);
            }
        }
    }

    public b1(t<T> tVar, l<? super T> lVar) {
        super(tVar);
        this.f15901d = lVar;
    }

    @Override // io.reactivex.q
    public void K0(v<? super T> vVar) {
        this.f15892c.a(new a(vVar, this.f15901d));
    }
}

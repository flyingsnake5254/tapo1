package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.n;
import io.reactivex.t;
import io.reactivex.v;

/* compiled from: ObservableSingleMaybe.java */
/* loaded from: classes4.dex */
public final class s0<T> extends m<T> {

    /* renamed from: c  reason: collision with root package name */
    final t<T> f16088c;

    /* compiled from: ObservableSingleMaybe.java */
    /* loaded from: classes4.dex */
    static final class a<T> implements v<T>, c {

        /* renamed from: c  reason: collision with root package name */
        final n<? super T> f16089c;

        /* renamed from: d  reason: collision with root package name */
        c f16090d;

        /* renamed from: f  reason: collision with root package name */
        T f16091f;
        boolean q;

        a(n<? super T> nVar) {
            this.f16089c = nVar;
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            this.f16090d.dispose();
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.f16090d.isDisposed();
        }

        @Override // io.reactivex.v
        public void onComplete() {
            if (!this.q) {
                this.q = true;
                T t = this.f16091f;
                this.f16091f = null;
                if (t == null) {
                    this.f16089c.onComplete();
                } else {
                    this.f16089c.onSuccess(t);
                }
            }
        }

        @Override // io.reactivex.v
        public void onError(Throwable th) {
            if (this.q) {
                io.reactivex.j0.a.r(th);
                return;
            }
            this.q = true;
            this.f16089c.onError(th);
        }

        @Override // io.reactivex.v
        public void onNext(T t) {
            if (!this.q) {
                if (this.f16091f != null) {
                    this.q = true;
                    this.f16090d.dispose();
                    this.f16089c.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f16091f = t;
            }
        }

        @Override // io.reactivex.v
        public void onSubscribe(c cVar) {
            if (DisposableHelper.validate(this.f16090d, cVar)) {
                this.f16090d = cVar;
                this.f16089c.onSubscribe(this);
            }
        }
    }

    public s0(t<T> tVar) {
        this.f16088c = tVar;
    }

    @Override // io.reactivex.m
    public void n(n<? super T> nVar) {
        this.f16088c.a(new a(nVar));
    }
}

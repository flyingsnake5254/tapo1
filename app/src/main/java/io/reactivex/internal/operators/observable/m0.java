package io.reactivex.internal.operators.observable;

import io.reactivex.g0.c;
import io.reactivex.h0.a.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.n;
import io.reactivex.t;
import io.reactivex.v;

/* compiled from: ObservableReduceMaybe.java */
/* loaded from: classes4.dex */
public final class m0<T> extends m<T> {

    /* renamed from: c  reason: collision with root package name */
    final t<T> f16037c;

    /* renamed from: d  reason: collision with root package name */
    final c<T, T, T> f16038d;

    /* compiled from: ObservableReduceMaybe.java */
    /* loaded from: classes4.dex */
    static final class a<T> implements v<T>, io.reactivex.e0.c {

        /* renamed from: c  reason: collision with root package name */
        final n<? super T> f16039c;

        /* renamed from: d  reason: collision with root package name */
        final c<T, T, T> f16040d;

        /* renamed from: f  reason: collision with root package name */
        boolean f16041f;
        T q;
        io.reactivex.e0.c x;

        a(n<? super T> nVar, c<T, T, T> cVar) {
            this.f16039c = nVar;
            this.f16040d = cVar;
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            this.x.dispose();
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.x.isDisposed();
        }

        @Override // io.reactivex.v
        public void onComplete() {
            if (!this.f16041f) {
                this.f16041f = true;
                T t = this.q;
                this.q = null;
                if (t != null) {
                    this.f16039c.onSuccess(t);
                } else {
                    this.f16039c.onComplete();
                }
            }
        }

        @Override // io.reactivex.v
        public void onError(Throwable th) {
            if (this.f16041f) {
                io.reactivex.j0.a.r(th);
                return;
            }
            this.f16041f = true;
            this.q = null;
            this.f16039c.onError(th);
        }

        @Override // io.reactivex.v
        public void onNext(T t) {
            if (!this.f16041f) {
                T t2 = this.q;
                if (t2 == null) {
                    this.q = t;
                    return;
                }
                try {
                    this.q = (T) b.e(this.f16040d.apply(t2, t), "The reducer returned a null value");
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.x.dispose();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.v
        public void onSubscribe(io.reactivex.e0.c cVar) {
            if (DisposableHelper.validate(this.x, cVar)) {
                this.x = cVar;
                this.f16039c.onSubscribe(this);
            }
        }
    }

    public m0(t<T> tVar, c<T, T, T> cVar) {
        this.f16037c = tVar;
        this.f16038d = cVar;
    }

    @Override // io.reactivex.m
    protected void n(n<? super T> nVar) {
        this.f16037c.a(new a(nVar, this.f16038d));
    }
}

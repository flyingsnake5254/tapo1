package io.reactivex.internal.operators.observable;

import io.reactivex.h0.b.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.v;

/* compiled from: ObservableElementAtMaybe.java */
/* loaded from: classes4.dex */
public final class n<T> extends m<T> implements c<T> {

    /* renamed from: c  reason: collision with root package name */
    final t<T> f16042c;

    /* renamed from: d  reason: collision with root package name */
    final long f16043d;

    /* compiled from: ObservableElementAtMaybe.java */
    /* loaded from: classes4.dex */
    static final class a<T> implements v<T>, io.reactivex.e0.c {

        /* renamed from: c  reason: collision with root package name */
        final io.reactivex.n<? super T> f16044c;

        /* renamed from: d  reason: collision with root package name */
        final long f16045d;

        /* renamed from: f  reason: collision with root package name */
        io.reactivex.e0.c f16046f;
        long q;
        boolean x;

        a(io.reactivex.n<? super T> nVar, long j) {
            this.f16044c = nVar;
            this.f16045d = j;
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            this.f16046f.dispose();
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.f16046f.isDisposed();
        }

        @Override // io.reactivex.v
        public void onComplete() {
            if (!this.x) {
                this.x = true;
                this.f16044c.onComplete();
            }
        }

        @Override // io.reactivex.v
        public void onError(Throwable th) {
            if (this.x) {
                io.reactivex.j0.a.r(th);
                return;
            }
            this.x = true;
            this.f16044c.onError(th);
        }

        @Override // io.reactivex.v
        public void onNext(T t) {
            if (!this.x) {
                long j = this.q;
                if (j == this.f16045d) {
                    this.x = true;
                    this.f16046f.dispose();
                    this.f16044c.onSuccess(t);
                    return;
                }
                this.q = j + 1;
            }
        }

        @Override // io.reactivex.v
        public void onSubscribe(io.reactivex.e0.c cVar) {
            if (DisposableHelper.validate(this.f16046f, cVar)) {
                this.f16046f = cVar;
                this.f16044c.onSubscribe(this);
            }
        }
    }

    public n(t<T> tVar, long j) {
        this.f16042c = tVar;
        this.f16043d = j;
    }

    @Override // io.reactivex.h0.b.c
    public q<T> b() {
        return io.reactivex.j0.a.n(new m(this.f16042c, this.f16043d, null, false));
    }

    @Override // io.reactivex.m
    public void n(io.reactivex.n<? super T> nVar) {
        this.f16042c.a(new a(nVar, this.f16043d));
    }
}

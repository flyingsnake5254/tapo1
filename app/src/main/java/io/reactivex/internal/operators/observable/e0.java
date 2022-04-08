package io.reactivex.internal.operators.observable;

import io.reactivex.h0.b.c;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.v;

/* compiled from: ObservableIgnoreElementsCompletable.java */
/* loaded from: classes4.dex */
public final class e0<T> extends io.reactivex.a implements c<T> {

    /* renamed from: c  reason: collision with root package name */
    final t<T> f15948c;

    /* compiled from: ObservableIgnoreElementsCompletable.java */
    /* loaded from: classes4.dex */
    static final class a<T> implements v<T>, io.reactivex.e0.c {

        /* renamed from: c  reason: collision with root package name */
        final io.reactivex.c f15949c;

        /* renamed from: d  reason: collision with root package name */
        io.reactivex.e0.c f15950d;

        a(io.reactivex.c cVar) {
            this.f15949c = cVar;
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            this.f15950d.dispose();
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.f15950d.isDisposed();
        }

        @Override // io.reactivex.v
        public void onComplete() {
            this.f15949c.onComplete();
        }

        @Override // io.reactivex.v
        public void onError(Throwable th) {
            this.f15949c.onError(th);
        }

        @Override // io.reactivex.v
        public void onNext(T t) {
        }

        @Override // io.reactivex.v
        public void onSubscribe(io.reactivex.e0.c cVar) {
            this.f15950d = cVar;
            this.f15949c.onSubscribe(this);
        }
    }

    public e0(t<T> tVar) {
        this.f15948c = tVar;
    }

    @Override // io.reactivex.a
    public void B(io.reactivex.c cVar) {
        this.f15948c.a(new a(cVar));
    }

    @Override // io.reactivex.h0.b.c
    public q<T> b() {
        return io.reactivex.j0.a.n(new d0(this.f15948c));
    }
}

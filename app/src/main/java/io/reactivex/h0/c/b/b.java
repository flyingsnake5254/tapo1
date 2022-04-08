package io.reactivex.h0.c.b;

import io.reactivex.b0;
import io.reactivex.e0.c;
import io.reactivex.g0.j;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.v;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleFlatMapObservable.java */
/* loaded from: classes4.dex */
public final class b<T, R> extends q<R> {

    /* renamed from: c  reason: collision with root package name */
    final b0<T> f15723c;

    /* renamed from: d  reason: collision with root package name */
    final j<? super T, ? extends t<? extends R>> f15724d;

    /* compiled from: SingleFlatMapObservable.java */
    /* loaded from: classes4.dex */
    static final class a<T, R> extends AtomicReference<c> implements v<R>, z<T>, c {

        /* renamed from: c  reason: collision with root package name */
        final v<? super R> f15725c;

        /* renamed from: d  reason: collision with root package name */
        final j<? super T, ? extends t<? extends R>> f15726d;

        a(v<? super R> vVar, j<? super T, ? extends t<? extends R>> jVar) {
            this.f15725c = vVar;
            this.f15726d = jVar;
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.v
        public void onComplete() {
            this.f15725c.onComplete();
        }

        @Override // io.reactivex.v
        public void onError(Throwable th) {
            this.f15725c.onError(th);
        }

        @Override // io.reactivex.v
        public void onNext(R r) {
            this.f15725c.onNext(r);
        }

        @Override // io.reactivex.v
        public void onSubscribe(c cVar) {
            DisposableHelper.replace(this, cVar);
        }

        @Override // io.reactivex.z
        public void onSuccess(T t) {
            try {
                ((t) io.reactivex.h0.a.b.e(this.f15726d.apply(t), "The mapper returned a null Publisher")).a(this);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f15725c.onError(th);
            }
        }
    }

    public b(b0<T> b0Var, j<? super T, ? extends t<? extends R>> jVar) {
        this.f15723c = b0Var;
        this.f15724d = jVar;
    }

    @Override // io.reactivex.q
    protected void K0(v<? super R> vVar) {
        a aVar = new a(vVar, this.f15724d);
        vVar.onSubscribe(aVar);
        this.f15723c.a(aVar);
    }
}

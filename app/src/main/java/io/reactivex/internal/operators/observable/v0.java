package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;
import io.reactivex.v;
import io.reactivex.w;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableSubscribeOn.java */
/* loaded from: classes4.dex */
public final class v0<T> extends a<T, T> {

    /* renamed from: d  reason: collision with root package name */
    final w f16118d;

    /* compiled from: ObservableSubscribeOn.java */
    /* loaded from: classes4.dex */
    static final class a<T> extends AtomicReference<c> implements v<T>, c {

        /* renamed from: c  reason: collision with root package name */
        final v<? super T> f16119c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReference<c> f16120d = new AtomicReference<>();

        a(v<? super T> vVar) {
            this.f16119c = vVar;
        }

        void a(c cVar) {
            DisposableHelper.setOnce(this, cVar);
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            DisposableHelper.dispose(this.f16120d);
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.v
        public void onComplete() {
            this.f16119c.onComplete();
        }

        @Override // io.reactivex.v
        public void onError(Throwable th) {
            this.f16119c.onError(th);
        }

        @Override // io.reactivex.v
        public void onNext(T t) {
            this.f16119c.onNext(t);
        }

        @Override // io.reactivex.v
        public void onSubscribe(c cVar) {
            DisposableHelper.setOnce(this.f16120d, cVar);
        }
    }

    /* compiled from: ObservableSubscribeOn.java */
    /* loaded from: classes4.dex */
    final class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        private final a<T> f16121c;

        b(a<T> aVar) {
            this.f16121c = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            v0.this.f15892c.a(this.f16121c);
        }
    }

    public v0(t<T> tVar, w wVar) {
        super(tVar);
        this.f16118d = wVar;
    }

    @Override // io.reactivex.q
    public void K0(v<? super T> vVar) {
        a aVar = new a(vVar);
        vVar.onSubscribe(aVar);
        aVar.a(this.f16118d.c(new b(aVar)));
    }
}

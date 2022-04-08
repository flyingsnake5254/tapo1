package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;
import io.reactivex.v;
import io.reactivex.w;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ObservableUnsubscribeOn.java */
/* loaded from: classes4.dex */
public final class g1<T> extends a<T, T> {

    /* renamed from: d  reason: collision with root package name */
    final w f15987d;

    /* compiled from: ObservableUnsubscribeOn.java */
    /* loaded from: classes4.dex */
    static final class a<T> extends AtomicBoolean implements v<T>, c {

        /* renamed from: c  reason: collision with root package name */
        final v<? super T> f15988c;

        /* renamed from: d  reason: collision with root package name */
        final w f15989d;

        /* renamed from: f  reason: collision with root package name */
        c f15990f;

        /* compiled from: ObservableUnsubscribeOn.java */
        /* renamed from: io.reactivex.internal.operators.observable.g1$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        final class RunnableC0306a implements Runnable {
            RunnableC0306a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f15990f.dispose();
            }
        }

        a(v<? super T> vVar, w wVar) {
            this.f15988c = vVar;
            this.f15989d = wVar;
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.f15989d.c(new RunnableC0306a());
            }
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return get();
        }

        @Override // io.reactivex.v
        public void onComplete() {
            if (!get()) {
                this.f15988c.onComplete();
            }
        }

        @Override // io.reactivex.v
        public void onError(Throwable th) {
            if (get()) {
                io.reactivex.j0.a.r(th);
            } else {
                this.f15988c.onError(th);
            }
        }

        @Override // io.reactivex.v
        public void onNext(T t) {
            if (!get()) {
                this.f15988c.onNext(t);
            }
        }

        @Override // io.reactivex.v
        public void onSubscribe(c cVar) {
            if (DisposableHelper.validate(this.f15990f, cVar)) {
                this.f15990f = cVar;
                this.f15988c.onSubscribe(this);
            }
        }
    }

    public g1(t<T> tVar, w wVar) {
        super(tVar);
        this.f15987d = wVar;
    }

    @Override // io.reactivex.q
    public void K0(v<? super T> vVar) {
        this.f15892c.a(new a(vVar, this.f15987d));
    }
}

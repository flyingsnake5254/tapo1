package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.g0.j;
import io.reactivex.h0.a.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.f;
import io.reactivex.m0.d;
import io.reactivex.m0.g;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableRepeatWhen.java */
/* loaded from: classes4.dex */
public final class o0<T> extends a<T, T> {

    /* renamed from: d  reason: collision with root package name */
    final j<? super q<Object>, ? extends t<?>> f16052d;

    /* compiled from: ObservableRepeatWhen.java */
    /* loaded from: classes4.dex */
    static final class a<T> extends AtomicInteger implements v<T>, c {

        /* renamed from: c  reason: collision with root package name */
        final v<? super T> f16053c;
        volatile boolean p0;
        final g<Object> q;
        final t<T> z;

        /* renamed from: d  reason: collision with root package name */
        final AtomicInteger f16054d = new AtomicInteger();

        /* renamed from: f  reason: collision with root package name */
        final AtomicThrowable f16055f = new AtomicThrowable();
        final a<T>.C0307a x = new C0307a();
        final AtomicReference<c> y = new AtomicReference<>();

        /* compiled from: ObservableRepeatWhen.java */
        /* renamed from: io.reactivex.internal.operators.observable.o0$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        final class C0307a extends AtomicReference<c> implements v<Object> {
            C0307a() {
            }

            @Override // io.reactivex.v
            public void onComplete() {
                a.this.a();
            }

            @Override // io.reactivex.v
            public void onError(Throwable th) {
                a.this.b(th);
            }

            @Override // io.reactivex.v
            public void onNext(Object obj) {
                a.this.d();
            }

            @Override // io.reactivex.v
            public void onSubscribe(c cVar) {
                DisposableHelper.setOnce(this, cVar);
            }
        }

        a(v<? super T> vVar, g<Object> gVar, t<T> tVar) {
            this.f16053c = vVar;
            this.q = gVar;
            this.z = tVar;
        }

        void a() {
            DisposableHelper.dispose(this.y);
            f.a(this.f16053c, this, this.f16055f);
        }

        void b(Throwable th) {
            DisposableHelper.dispose(this.y);
            f.c(this.f16053c, th, this, this.f16055f);
        }

        void d() {
            f();
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            DisposableHelper.dispose(this.y);
            DisposableHelper.dispose(this.x);
        }

        void f() {
            if (this.f16054d.getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.p0) {
                        this.p0 = true;
                        this.z.a(this);
                    }
                    if (this.f16054d.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.y.get());
        }

        @Override // io.reactivex.v
        public void onComplete() {
            DisposableHelper.replace(this.y, null);
            this.p0 = false;
            this.q.onNext(0);
        }

        @Override // io.reactivex.v
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.x);
            f.c(this.f16053c, th, this, this.f16055f);
        }

        @Override // io.reactivex.v
        public void onNext(T t) {
            f.e(this.f16053c, t, this, this.f16055f);
        }

        @Override // io.reactivex.v
        public void onSubscribe(c cVar) {
            DisposableHelper.setOnce(this.y, cVar);
        }
    }

    public o0(t<T> tVar, j<? super q<Object>, ? extends t<?>> jVar) {
        super(tVar);
        this.f16052d = jVar;
    }

    @Override // io.reactivex.q
    protected void K0(v<? super T> vVar) {
        g<T> l1 = d.n1().l1();
        try {
            t tVar = (t) b.e(this.f16052d.apply(l1), "The handler returned a null ObservableSource");
            a aVar = new a(vVar, l1, this.f15892c);
            vVar.onSubscribe(aVar);
            tVar.a(aVar.x);
            aVar.f();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            EmptyDisposable.error(th, vVar);
        }
    }
}

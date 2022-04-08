package io.reactivex.internal.operators.observable;

import io.reactivex.e;
import io.reactivex.e0.b;
import io.reactivex.g0.j;
import io.reactivex.h0.b.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.q;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableFlatMapCompletableCompletable.java */
/* loaded from: classes4.dex */
public final class t<T> extends io.reactivex.a implements c<T> {

    /* renamed from: c  reason: collision with root package name */
    final io.reactivex.t<T> f16092c;

    /* renamed from: d  reason: collision with root package name */
    final j<? super T, ? extends e> f16093d;

    /* renamed from: f  reason: collision with root package name */
    final boolean f16094f;

    /* compiled from: ObservableFlatMapCompletableCompletable.java */
    /* loaded from: classes4.dex */
    static final class a<T> extends AtomicInteger implements io.reactivex.e0.c, v<T> {

        /* renamed from: c  reason: collision with root package name */
        final io.reactivex.c f16095c;

        /* renamed from: f  reason: collision with root package name */
        final j<? super T, ? extends e> f16097f;
        final boolean q;
        io.reactivex.e0.c y;
        volatile boolean z;

        /* renamed from: d  reason: collision with root package name */
        final AtomicThrowable f16096d = new AtomicThrowable();
        final b x = new b();

        /* compiled from: ObservableFlatMapCompletableCompletable.java */
        /* renamed from: io.reactivex.internal.operators.observable.t$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        final class C0310a extends AtomicReference<io.reactivex.e0.c> implements io.reactivex.c, io.reactivex.e0.c {
            C0310a() {
            }

            @Override // io.reactivex.e0.c
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.e0.c
            public boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }

            @Override // io.reactivex.c
            public void onComplete() {
                a.this.a(this);
            }

            @Override // io.reactivex.c
            public void onError(Throwable th) {
                a.this.b(this, th);
            }

            @Override // io.reactivex.c
            public void onSubscribe(io.reactivex.e0.c cVar) {
                DisposableHelper.setOnce(this, cVar);
            }
        }

        a(io.reactivex.c cVar, j<? super T, ? extends e> jVar, boolean z) {
            this.f16095c = cVar;
            this.f16097f = jVar;
            this.q = z;
            lazySet(1);
        }

        void a(a<T>.C0310a aVar) {
            this.x.c(aVar);
            onComplete();
        }

        void b(a<T>.C0310a aVar, Throwable th) {
            this.x.c(aVar);
            onError(th);
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            this.z = true;
            this.y.dispose();
            this.x.dispose();
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.y.isDisposed();
        }

        @Override // io.reactivex.v
        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable terminate = this.f16096d.terminate();
                if (terminate != null) {
                    this.f16095c.onError(terminate);
                } else {
                    this.f16095c.onComplete();
                }
            }
        }

        @Override // io.reactivex.v
        public void onError(Throwable th) {
            if (!this.f16096d.addThrowable(th)) {
                io.reactivex.j0.a.r(th);
            } else if (!this.q) {
                dispose();
                if (getAndSet(0) > 0) {
                    this.f16095c.onError(this.f16096d.terminate());
                }
            } else if (decrementAndGet() == 0) {
                this.f16095c.onError(this.f16096d.terminate());
            }
        }

        @Override // io.reactivex.v
        public void onNext(T t) {
            try {
                e eVar = (e) io.reactivex.h0.a.b.e(this.f16097f.apply(t), "The mapper returned a null CompletableSource");
                getAndIncrement();
                C0310a aVar = new C0310a();
                if (!this.z && this.x.b(aVar)) {
                    eVar.a(aVar);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.y.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.v
        public void onSubscribe(io.reactivex.e0.c cVar) {
            if (DisposableHelper.validate(this.y, cVar)) {
                this.y = cVar;
                this.f16095c.onSubscribe(this);
            }
        }
    }

    public t(io.reactivex.t<T> tVar, j<? super T, ? extends e> jVar, boolean z) {
        this.f16092c = tVar;
        this.f16093d = jVar;
        this.f16094f = z;
    }

    @Override // io.reactivex.a
    protected void B(io.reactivex.c cVar) {
        this.f16092c.a(new a(cVar, this.f16093d, this.f16094f));
    }

    @Override // io.reactivex.h0.b.c
    public q<T> b() {
        return io.reactivex.j0.a.n(new s(this.f16092c, this.f16093d, this.f16094f));
    }
}

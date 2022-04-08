package io.reactivex.internal.operators.observable;

import io.reactivex.e;
import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.g0.j;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.t;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableFlatMapCompletable.java */
/* loaded from: classes4.dex */
public final class s<T> extends a<T, T> {

    /* renamed from: d  reason: collision with root package name */
    final j<? super T, ? extends e> f16082d;

    /* renamed from: f  reason: collision with root package name */
    final boolean f16083f;

    /* compiled from: ObservableFlatMapCompletable.java */
    /* loaded from: classes4.dex */
    static final class a<T> extends BasicIntQueueDisposable<T> implements v<T> {

        /* renamed from: c  reason: collision with root package name */
        final v<? super T> f16084c;

        /* renamed from: f  reason: collision with root package name */
        final j<? super T, ? extends e> f16086f;
        final boolean q;
        c y;
        volatile boolean z;

        /* renamed from: d  reason: collision with root package name */
        final AtomicThrowable f16085d = new AtomicThrowable();
        final b x = new b();

        /* compiled from: ObservableFlatMapCompletable.java */
        /* renamed from: io.reactivex.internal.operators.observable.s$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        final class C0309a extends AtomicReference<c> implements io.reactivex.c, c {
            C0309a() {
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
            public void onSubscribe(c cVar) {
                DisposableHelper.setOnce(this, cVar);
            }
        }

        a(v<? super T> vVar, j<? super T, ? extends e> jVar, boolean z) {
            this.f16084c = vVar;
            this.f16086f = jVar;
            this.q = z;
            lazySet(1);
        }

        void a(a<T>.C0309a aVar) {
            this.x.c(aVar);
            onComplete();
        }

        void b(a<T>.C0309a aVar, Throwable th) {
            this.x.c(aVar);
            onError(th);
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.h0.b.i
        public void clear() {
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.e0.c
        public void dispose() {
            this.z = true;
            this.y.dispose();
            this.x.dispose();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.e0.c
        public boolean isDisposed() {
            return this.y.isDisposed();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.h0.b.i
        public boolean isEmpty() {
            return true;
        }

        @Override // io.reactivex.v
        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable terminate = this.f16085d.terminate();
                if (terminate != null) {
                    this.f16084c.onError(terminate);
                } else {
                    this.f16084c.onComplete();
                }
            }
        }

        @Override // io.reactivex.v
        public void onError(Throwable th) {
            if (!this.f16085d.addThrowable(th)) {
                io.reactivex.j0.a.r(th);
            } else if (!this.q) {
                dispose();
                if (getAndSet(0) > 0) {
                    this.f16084c.onError(this.f16085d.terminate());
                }
            } else if (decrementAndGet() == 0) {
                this.f16084c.onError(this.f16085d.terminate());
            }
        }

        @Override // io.reactivex.v
        public void onNext(T t) {
            try {
                e eVar = (e) io.reactivex.h0.a.b.e(this.f16086f.apply(t), "The mapper returned a null CompletableSource");
                getAndIncrement();
                C0309a aVar = new C0309a();
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
        public void onSubscribe(c cVar) {
            if (DisposableHelper.validate(this.y, cVar)) {
                this.y = cVar;
                this.f16084c.onSubscribe(this);
            }
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.h0.b.i
        public T poll() throws Exception {
            return null;
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.h0.b.e
        public int requestFusion(int i) {
            return i & 2;
        }
    }

    public s(t<T> tVar, j<? super T, ? extends e> jVar, boolean z) {
        super(tVar);
        this.f16082d = jVar;
        this.f16083f = z;
    }

    @Override // io.reactivex.q
    protected void K0(v<? super T> vVar) {
        this.f15892c.a(new a(vVar, this.f16082d, this.f16083f));
    }
}

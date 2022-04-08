package io.reactivex.internal.operators.observable;

import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.g0.j;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.n;
import io.reactivex.o;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableFlatMapMaybe.java */
/* loaded from: classes4.dex */
public final class u<T, R> extends a<T, R> {

    /* renamed from: d  reason: collision with root package name */
    final j<? super T, ? extends o<? extends R>> f16104d;

    /* renamed from: f  reason: collision with root package name */
    final boolean f16105f;

    /* compiled from: ObservableFlatMapMaybe.java */
    /* loaded from: classes4.dex */
    static final class a<T, R> extends AtomicInteger implements v<T>, c {

        /* renamed from: c  reason: collision with root package name */
        final v<? super R> f16106c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f16107d;
        c p0;
        volatile boolean p1;
        final j<? super T, ? extends o<? extends R>> y;

        /* renamed from: f  reason: collision with root package name */
        final b f16108f = new b();
        final AtomicThrowable x = new AtomicThrowable();
        final AtomicInteger q = new AtomicInteger(1);
        final AtomicReference<io.reactivex.internal.queue.b<R>> z = new AtomicReference<>();

        /* compiled from: ObservableFlatMapMaybe.java */
        /* renamed from: io.reactivex.internal.operators.observable.u$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        final class C0311a extends AtomicReference<c> implements n<R>, c {
            C0311a() {
            }

            @Override // io.reactivex.e0.c
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.e0.c
            public boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }

            @Override // io.reactivex.n
            public void onComplete() {
                a.this.g(this);
            }

            @Override // io.reactivex.n
            public void onError(Throwable th) {
                a.this.h(this, th);
            }

            @Override // io.reactivex.n
            public void onSubscribe(c cVar) {
                DisposableHelper.setOnce(this, cVar);
            }

            @Override // io.reactivex.n
            public void onSuccess(R r) {
                a.this.i(this, r);
            }
        }

        a(v<? super R> vVar, j<? super T, ? extends o<? extends R>> jVar, boolean z) {
            this.f16106c = vVar;
            this.y = jVar;
            this.f16107d = z;
        }

        void a() {
            io.reactivex.internal.queue.b<R> bVar = this.z.get();
            if (bVar != null) {
                bVar.clear();
            }
        }

        void b() {
            if (getAndIncrement() == 0) {
                d();
            }
        }

        void d() {
            v<? super R> vVar = this.f16106c;
            AtomicInteger atomicInteger = this.q;
            AtomicReference<io.reactivex.internal.queue.b<R>> atomicReference = this.z;
            int i = 1;
            while (!this.p1) {
                if (this.f16107d || this.x.get() == null) {
                    boolean z = false;
                    boolean z2 = atomicInteger.get() == 0;
                    io.reactivex.internal.queue.b<R> bVar = atomicReference.get();
                    R poll = bVar != null ? bVar.poll() : (Object) null;
                    if (poll == null) {
                        z = true;
                    }
                    if (z2 && z) {
                        Throwable terminate = this.x.terminate();
                        if (terminate != null) {
                            vVar.onError(terminate);
                            return;
                        } else {
                            vVar.onComplete();
                            return;
                        }
                    } else if (z) {
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        vVar.onNext(poll);
                    }
                } else {
                    Throwable terminate2 = this.x.terminate();
                    a();
                    vVar.onError(terminate2);
                    return;
                }
            }
            a();
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            this.p1 = true;
            this.p0.dispose();
            this.f16108f.dispose();
        }

        io.reactivex.internal.queue.b<R> f() {
            io.reactivex.internal.queue.b<R> bVar;
            do {
                io.reactivex.internal.queue.b<R> bVar2 = this.z.get();
                if (bVar2 != null) {
                    return bVar2;
                }
                bVar = new io.reactivex.internal.queue.b<>(q.d());
            } while (!this.z.compareAndSet(null, bVar));
            return bVar;
        }

        void g(a<T, R>.C0311a aVar) {
            this.f16108f.c(aVar);
            if (get() == 0) {
                boolean z = false;
                if (compareAndSet(0, 1)) {
                    if (this.q.decrementAndGet() == 0) {
                        z = true;
                    }
                    io.reactivex.internal.queue.b<R> bVar = this.z.get();
                    if (z && (bVar == null || bVar.isEmpty())) {
                        Throwable terminate = this.x.terminate();
                        if (terminate != null) {
                            this.f16106c.onError(terminate);
                            return;
                        } else {
                            this.f16106c.onComplete();
                            return;
                        }
                    } else if (decrementAndGet() != 0) {
                        d();
                        return;
                    } else {
                        return;
                    }
                }
            }
            this.q.decrementAndGet();
            b();
        }

        void h(a<T, R>.C0311a aVar, Throwable th) {
            this.f16108f.c(aVar);
            if (this.x.addThrowable(th)) {
                if (!this.f16107d) {
                    this.p0.dispose();
                    this.f16108f.dispose();
                }
                this.q.decrementAndGet();
                b();
                return;
            }
            io.reactivex.j0.a.r(th);
        }

        void i(a<T, R>.C0311a aVar, R r) {
            this.f16108f.c(aVar);
            if (get() == 0) {
                boolean z = false;
                if (compareAndSet(0, 1)) {
                    this.f16106c.onNext(r);
                    if (this.q.decrementAndGet() == 0) {
                        z = true;
                    }
                    io.reactivex.internal.queue.b<R> bVar = this.z.get();
                    if (!z || (bVar != null && !bVar.isEmpty())) {
                        if (decrementAndGet() == 0) {
                            return;
                        }
                        d();
                    }
                    Throwable terminate = this.x.terminate();
                    if (terminate != null) {
                        this.f16106c.onError(terminate);
                        return;
                    } else {
                        this.f16106c.onComplete();
                        return;
                    }
                }
            }
            io.reactivex.internal.queue.b<R> f2 = f();
            synchronized (f2) {
                f2.offer(r);
            }
            this.q.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            d();
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.p1;
        }

        @Override // io.reactivex.v
        public void onComplete() {
            this.q.decrementAndGet();
            b();
        }

        @Override // io.reactivex.v
        public void onError(Throwable th) {
            this.q.decrementAndGet();
            if (this.x.addThrowable(th)) {
                if (!this.f16107d) {
                    this.f16108f.dispose();
                }
                b();
                return;
            }
            io.reactivex.j0.a.r(th);
        }

        @Override // io.reactivex.v
        public void onNext(T t) {
            try {
                o oVar = (o) io.reactivex.h0.a.b.e(this.y.apply(t), "The mapper returned a null MaybeSource");
                this.q.getAndIncrement();
                C0311a aVar = new C0311a();
                if (!this.p1 && this.f16108f.b(aVar)) {
                    oVar.a(aVar);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.p0.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.v
        public void onSubscribe(c cVar) {
            if (DisposableHelper.validate(this.p0, cVar)) {
                this.p0 = cVar;
                this.f16106c.onSubscribe(this);
            }
        }
    }

    public u(t<T> tVar, j<? super T, ? extends o<? extends R>> jVar, boolean z) {
        super(tVar);
        this.f16104d = jVar;
        this.f16105f = z;
    }

    @Override // io.reactivex.q
    protected void K0(v<? super R> vVar) {
        this.f15892c.a(new a(vVar, this.f16104d, this.f16105f));
    }
}

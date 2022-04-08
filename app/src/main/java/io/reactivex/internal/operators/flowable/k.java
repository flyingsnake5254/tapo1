package io.reactivex.internal.operators.flowable;

import e.b.b;
import e.b.c;
import io.reactivex.g0.j;
import io.reactivex.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.n;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableFlatMapMaybe.java */
/* loaded from: classes4.dex */
public final class k<T, R> extends a<T, R> {

    /* renamed from: f  reason: collision with root package name */
    final j<? super T, ? extends o<? extends R>> f15806f;
    final boolean q;
    final int x;

    /* compiled from: FlowableFlatMapMaybe.java */
    /* loaded from: classes4.dex */
    static final class a<T, R> extends AtomicInteger implements io.reactivex.k<T>, c {

        /* renamed from: c  reason: collision with root package name */
        final b<? super R> f15807c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f15808d;

        /* renamed from: f  reason: collision with root package name */
        final int f15809f;
        final j<? super T, ? extends o<? extends R>> p0;
        c p2;
        volatile boolean p3;
        final AtomicLong q = new AtomicLong();
        final io.reactivex.e0.b x = new io.reactivex.e0.b();
        final AtomicThrowable z = new AtomicThrowable();
        final AtomicInteger y = new AtomicInteger(1);
        final AtomicReference<io.reactivex.internal.queue.b<R>> p1 = new AtomicReference<>();

        /* compiled from: FlowableFlatMapMaybe.java */
        /* renamed from: io.reactivex.internal.operators.flowable.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        final class C0300a extends AtomicReference<io.reactivex.e0.c> implements n<R>, io.reactivex.e0.c {
            C0300a() {
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
                a.this.h(this);
            }

            @Override // io.reactivex.n
            public void onError(Throwable th) {
                a.this.i(this, th);
            }

            @Override // io.reactivex.n
            public void onSubscribe(io.reactivex.e0.c cVar) {
                DisposableHelper.setOnce(this, cVar);
            }

            @Override // io.reactivex.n
            public void onSuccess(R r) {
                a.this.j(this, r);
            }
        }

        a(b<? super R> bVar, j<? super T, ? extends o<? extends R>> jVar, boolean z, int i) {
            this.f15807c = bVar;
            this.p0 = jVar;
            this.f15808d = z;
            this.f15809f = i;
        }

        void a() {
            io.reactivex.internal.queue.b<R> bVar = this.p1.get();
            if (bVar != null) {
                bVar.clear();
            }
        }

        @Override // e.b.c
        public void cancel() {
            this.p3 = true;
            this.p2.cancel();
            this.x.dispose();
        }

        void d() {
            if (getAndIncrement() == 0) {
                f();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:36:0x0077, code lost:
            if (r13 != 0) goto L_0x00c8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x007b, code lost:
            if (r17.p3 == false) goto L_0x0081;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x007d, code lost:
            a();
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0080, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0083, code lost:
            if (r17.f15808d != false) goto L_0x009c;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x008d, code lost:
            if (r17.z.get() == null) goto L_0x009c;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x008f, code lost:
            r2 = r17.z.terminate();
            a();
            r1.onError(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x009b, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00a0, code lost:
            if (r2.get() != 0) goto L_0x00a4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00a2, code lost:
            r6 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00a4, code lost:
            r6 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00a5, code lost:
            r7 = r3.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00ab, code lost:
            if (r7 == null) goto L_0x00b3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00b1, code lost:
            if (r7.isEmpty() == false) goto L_0x00b4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00b3, code lost:
            r12 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00b4, code lost:
            if (r6 == false) goto L_0x00c8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00b6, code lost:
            if (r12 == false) goto L_0x00c8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00b8, code lost:
            r2 = r17.z.terminate();
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00be, code lost:
            if (r2 == null) goto L_0x00c4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00c0, code lost:
            r1.onError(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00c4, code lost:
            r1.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00c7, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x00ca, code lost:
            if (r10 == 0) goto L_0x00dd;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00cc, code lost:
            io.reactivex.internal.util.b.c(r17.q, r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x00d6, code lost:
            if (r17.f15809f == Integer.MAX_VALUE) goto L_0x00dd;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00d8, code lost:
            r17.p2.request(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x00dd, code lost:
            r5 = addAndGet(-r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:?, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void f() {
            /*
                Method dump skipped, instructions count: 229
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.k.a.f():void");
        }

        io.reactivex.internal.queue.b<R> g() {
            io.reactivex.internal.queue.b<R> bVar;
            do {
                io.reactivex.internal.queue.b<R> bVar2 = this.p1.get();
                if (bVar2 != null) {
                    return bVar2;
                }
                bVar = new io.reactivex.internal.queue.b<>(h.c());
            } while (!this.p1.compareAndSet(null, bVar));
            return bVar;
        }

        void h(a<T, R>.C0300a aVar) {
            this.x.c(aVar);
            if (get() == 0) {
                boolean z = false;
                if (compareAndSet(0, 1)) {
                    if (this.y.decrementAndGet() == 0) {
                        z = true;
                    }
                    io.reactivex.internal.queue.b<R> bVar = this.p1.get();
                    if (!z || (bVar != null && !bVar.isEmpty())) {
                        if (this.f15809f != Integer.MAX_VALUE) {
                            this.p2.request(1L);
                        }
                        if (decrementAndGet() != 0) {
                            f();
                            return;
                        }
                        return;
                    }
                    Throwable terminate = this.z.terminate();
                    if (terminate != null) {
                        this.f15807c.onError(terminate);
                        return;
                    } else {
                        this.f15807c.onComplete();
                        return;
                    }
                }
            }
            this.y.decrementAndGet();
            if (this.f15809f != Integer.MAX_VALUE) {
                this.p2.request(1L);
            }
            d();
        }

        void i(a<T, R>.C0300a aVar, Throwable th) {
            this.x.c(aVar);
            if (this.z.addThrowable(th)) {
                if (!this.f15808d) {
                    this.p2.cancel();
                    this.x.dispose();
                } else if (this.f15809f != Integer.MAX_VALUE) {
                    this.p2.request(1L);
                }
                this.y.decrementAndGet();
                d();
                return;
            }
            io.reactivex.j0.a.r(th);
        }

        void j(a<T, R>.C0300a aVar, R r) {
            this.x.c(aVar);
            if (get() == 0) {
                boolean z = false;
                if (compareAndSet(0, 1)) {
                    if (this.y.decrementAndGet() == 0) {
                        z = true;
                    }
                    if (this.q.get() != 0) {
                        this.f15807c.onNext(r);
                        io.reactivex.internal.queue.b<R> bVar = this.p1.get();
                        if (!z || (bVar != null && !bVar.isEmpty())) {
                            io.reactivex.internal.util.b.c(this.q, 1L);
                            if (this.f15809f != Integer.MAX_VALUE) {
                                this.p2.request(1L);
                            }
                        } else {
                            Throwable terminate = this.z.terminate();
                            if (terminate != null) {
                                this.f15807c.onError(terminate);
                                return;
                            } else {
                                this.f15807c.onComplete();
                                return;
                            }
                        }
                    } else {
                        io.reactivex.internal.queue.b<R> g = g();
                        synchronized (g) {
                            g.offer(r);
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    f();
                }
            }
            io.reactivex.internal.queue.b<R> g2 = g();
            synchronized (g2) {
                g2.offer(r);
            }
            this.y.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            f();
        }

        @Override // e.b.b
        public void onComplete() {
            this.y.decrementAndGet();
            d();
        }

        @Override // e.b.b
        public void onError(Throwable th) {
            this.y.decrementAndGet();
            if (this.z.addThrowable(th)) {
                if (!this.f15808d) {
                    this.x.dispose();
                }
                d();
                return;
            }
            io.reactivex.j0.a.r(th);
        }

        @Override // e.b.b
        public void onNext(T t) {
            try {
                o oVar = (o) io.reactivex.h0.a.b.e(this.p0.apply(t), "The mapper returned a null MaybeSource");
                this.y.getAndIncrement();
                C0300a aVar = new C0300a();
                if (!this.p3 && this.x.b(aVar)) {
                    oVar.a(aVar);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.p2.cancel();
                onError(th);
            }
        }

        @Override // io.reactivex.k, e.b.b
        public void onSubscribe(c cVar) {
            if (SubscriptionHelper.validate(this.p2, cVar)) {
                this.p2 = cVar;
                this.f15807c.onSubscribe(this);
                int i = this.f15809f;
                if (i == Integer.MAX_VALUE) {
                    cVar.request(Long.MAX_VALUE);
                } else {
                    cVar.request(i);
                }
            }
        }

        @Override // e.b.c
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.q, j);
                d();
            }
        }
    }

    public k(h<T> hVar, j<? super T, ? extends o<? extends R>> jVar, boolean z, int i) {
        super(hVar);
        this.f15806f = jVar;
        this.q = z;
        this.x = i;
    }

    @Override // io.reactivex.h
    protected void H(b<? super R> bVar) {
        this.f15765d.G(new a(bVar, this.f15806f, this.q, this.x));
    }
}

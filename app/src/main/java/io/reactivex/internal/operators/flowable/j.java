package io.reactivex.internal.operators.flowable;

import e.b.c;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.h0.b.f;
import io.reactivex.h0.b.h;
import io.reactivex.h0.b.i;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.e;
import io.reactivex.k;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableFlatMap.java */
/* loaded from: classes4.dex */
public final class j<T, U> extends a<T, U> {

    /* renamed from: f  reason: collision with root package name */
    final io.reactivex.g0.j<? super T, ? extends e.b.a<? extends U>> f15799f;
    final boolean q;
    final int x;
    final int y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableFlatMap.java */
    /* loaded from: classes4.dex */
    public static final class a<T, U> extends AtomicReference<c> implements k<U>, io.reactivex.e0.c {

        /* renamed from: c  reason: collision with root package name */
        final long f15800c;

        /* renamed from: d  reason: collision with root package name */
        final b<T, U> f15801d;

        /* renamed from: f  reason: collision with root package name */
        final int f15802f;
        int p0;
        final int q;
        volatile boolean x;
        volatile i<U> y;
        long z;

        a(b<T, U> bVar, long j) {
            this.f15800c = j;
            this.f15801d = bVar;
            int i = bVar.z;
            this.q = i;
            this.f15802f = i >> 2;
        }

        void a(long j) {
            if (this.p0 != 1) {
                long j2 = this.z + j;
                if (j2 >= this.f15802f) {
                    this.z = 0L;
                    get().request(j2);
                    return;
                }
                this.z = j2;
            }
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        @Override // e.b.b
        public void onComplete() {
            this.x = true;
            this.f15801d.h();
        }

        @Override // e.b.b
        public void onError(Throwable th) {
            lazySet(SubscriptionHelper.CANCELLED);
            this.f15801d.l(this, th);
        }

        @Override // e.b.b
        public void onNext(U u) {
            if (this.p0 != 2) {
                this.f15801d.n(u, this);
            } else {
                this.f15801d.h();
            }
        }

        @Override // io.reactivex.k, e.b.b
        public void onSubscribe(c cVar) {
            if (SubscriptionHelper.setOnce(this, cVar)) {
                if (cVar instanceof f) {
                    f fVar = (f) cVar;
                    int requestFusion = fVar.requestFusion(7);
                    if (requestFusion == 1) {
                        this.p0 = requestFusion;
                        this.y = fVar;
                        this.x = true;
                        this.f15801d.h();
                        return;
                    } else if (requestFusion == 2) {
                        this.p0 = requestFusion;
                        this.y = fVar;
                    }
                }
                cVar.request(this.q);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableFlatMap.java */
    /* loaded from: classes4.dex */
    public static final class b<T, U> extends AtomicInteger implements k<T>, c {

        /* renamed from: c  reason: collision with root package name */
        static final a<?, ?>[] f15803c = new a[0];

        /* renamed from: d  reason: collision with root package name */
        static final a<?, ?>[] f15804d = new a[0];
        final AtomicReference<a<?, ?>[]> H3;
        c J3;
        long K3;
        long L3;
        int M3;
        int N3;
        final int O3;

        /* renamed from: f  reason: collision with root package name */
        final e.b.b<? super U> f15805f;
        volatile h<U> p0;
        volatile boolean p1;
        volatile boolean p3;
        final io.reactivex.g0.j<? super T, ? extends e.b.a<? extends U>> q;
        final boolean x;
        final int y;
        final int z;
        final AtomicThrowable p2 = new AtomicThrowable();
        final AtomicLong I3 = new AtomicLong();

        b(e.b.b<? super U> bVar, io.reactivex.g0.j<? super T, ? extends e.b.a<? extends U>> jVar, boolean z, int i, int i2) {
            AtomicReference<a<?, ?>[]> atomicReference = new AtomicReference<>();
            this.H3 = atomicReference;
            this.f15805f = bVar;
            this.q = jVar;
            this.x = z;
            this.y = i;
            this.z = i2;
            this.O3 = Math.max(1, i >> 1);
            atomicReference.lazySet(f15803c);
        }

        /* JADX WARN: Multi-variable type inference failed */
        boolean a(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = this.H3.get();
                if (aVarArr == f15804d) {
                    aVar.dispose();
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!this.H3.compareAndSet(aVarArr, aVarArr2));
            return true;
        }

        @Override // e.b.c
        public void cancel() {
            h<U> hVar;
            if (!this.p3) {
                this.p3 = true;
                this.J3.cancel();
                g();
                if (getAndIncrement() == 0 && (hVar = this.p0) != null) {
                    hVar.clear();
                }
            }
        }

        boolean d() {
            if (this.p3) {
                f();
                return true;
            } else if (this.x || this.p2.get() == null) {
                return false;
            } else {
                f();
                Throwable terminate = this.p2.terminate();
                if (terminate != e.a) {
                    this.f15805f.onError(terminate);
                }
                return true;
            }
        }

        void f() {
            h<U> hVar = this.p0;
            if (hVar != null) {
                hVar.clear();
            }
        }

        void g() {
            a<?, ?>[] andSet;
            a<?, ?>[] aVarArr = this.H3.get();
            a<?, ?>[] aVarArr2 = f15804d;
            if (!(aVarArr == aVarArr2 || (andSet = this.H3.getAndSet(aVarArr2)) == aVarArr2)) {
                for (a<?, ?> aVar : andSet) {
                    aVar.dispose();
                }
                Throwable terminate = this.p2.terminate();
                if (!(terminate == null || terminate == e.a)) {
                    io.reactivex.j0.a.r(terminate);
                }
            }
        }

        void h() {
            if (getAndIncrement() == 0) {
                i();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:117:0x018f, code lost:
            r24.M3 = r3;
            r24.L3 = r13[r3].f15800c;
            r5 = 0;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void i() {
            /*
                Method dump skipped, instructions count: 446
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.j.b.i():void");
        }

        i<U> j(a<T, U> aVar) {
            i<U> iVar = aVar.y;
            if (iVar != null) {
                return iVar;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.z);
            aVar.y = spscArrayQueue;
            return spscArrayQueue;
        }

        i<U> k() {
            h<U> hVar = this.p0;
            if (hVar == null) {
                if (this.y == Integer.MAX_VALUE) {
                    hVar = new io.reactivex.internal.queue.b<>(this.z);
                } else {
                    hVar = new SpscArrayQueue<>(this.y);
                }
                this.p0 = hVar;
            }
            return hVar;
        }

        void l(a<T, U> aVar, Throwable th) {
            if (this.p2.addThrowable(th)) {
                aVar.x = true;
                if (!this.x) {
                    this.J3.cancel();
                    for (a<?, ?> aVar2 : this.H3.getAndSet(f15804d)) {
                        aVar2.dispose();
                    }
                }
                h();
                return;
            }
            io.reactivex.j0.a.r(th);
        }

        void m(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a<?, ?>[] aVarArr2;
            do {
                aVarArr = this.H3.get();
                int length = aVarArr.length;
                if (length != 0) {
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (aVarArr[i2] == aVar) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            aVarArr2 = f15803c;
                        } else {
                            a<?, ?>[] aVarArr3 = new a[length - 1];
                            System.arraycopy(aVarArr, 0, aVarArr3, 0, i);
                            System.arraycopy(aVarArr, i + 1, aVarArr3, i, (length - i) - 1);
                            aVarArr2 = aVarArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.H3.compareAndSet(aVarArr, aVarArr2));
        }

        void n(U u, a<T, U> aVar) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                i iVar = aVar.y;
                if (iVar == null) {
                    iVar = new SpscArrayQueue(this.z);
                    aVar.y = iVar;
                }
                if (!iVar.offer(u)) {
                    onError(new MissingBackpressureException("Inner queue full?!"));
                    return;
                } else if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                long j = this.I3.get();
                i<U> iVar2 = aVar.y;
                if (j == 0 || (iVar2 != null && !iVar2.isEmpty())) {
                    if (iVar2 == null) {
                        iVar2 = j(aVar);
                    }
                    if (!iVar2.offer(u)) {
                        onError(new MissingBackpressureException("Inner queue full?!"));
                        return;
                    }
                } else {
                    this.f15805f.onNext(u);
                    if (j != Long.MAX_VALUE) {
                        this.I3.decrementAndGet();
                    }
                    aVar.a(1L);
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            i();
        }

        void o(U u) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j = this.I3.get();
                i<U> iVar = this.p0;
                if (j == 0 || (iVar != null && !iVar.isEmpty())) {
                    if (iVar == null) {
                        iVar = k();
                    }
                    if (!iVar.offer(u)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return;
                    }
                } else {
                    this.f15805f.onNext(u);
                    if (j != Long.MAX_VALUE) {
                        this.I3.decrementAndGet();
                    }
                    if (this.y != Integer.MAX_VALUE && !this.p3) {
                        int i = this.N3 + 1;
                        this.N3 = i;
                        int i2 = this.O3;
                        if (i == i2) {
                            this.N3 = 0;
                            this.J3.request(i2);
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!k().offer(u)) {
                onError(new IllegalStateException("Scalar queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            i();
        }

        @Override // e.b.b
        public void onComplete() {
            if (!this.p1) {
                this.p1 = true;
                h();
            }
        }

        @Override // e.b.b
        public void onError(Throwable th) {
            if (this.p1) {
                io.reactivex.j0.a.r(th);
            } else if (this.p2.addThrowable(th)) {
                this.p1 = true;
                if (!this.x) {
                    for (a<?, ?> aVar : this.H3.getAndSet(f15804d)) {
                        aVar.dispose();
                    }
                }
                h();
            } else {
                io.reactivex.j0.a.r(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // e.b.b
        public void onNext(T t) {
            if (!this.p1) {
                try {
                    e.b.a aVar = (e.b.a) io.reactivex.h0.a.b.e(this.q.apply(t), "The mapper returned a null Publisher");
                    if (aVar instanceof Callable) {
                        try {
                            Object call = ((Callable) aVar).call();
                            if (call != null) {
                                o(call);
                            } else if (this.y != Integer.MAX_VALUE && !this.p3) {
                                int i = this.N3 + 1;
                                this.N3 = i;
                                int i2 = this.O3;
                                if (i == i2) {
                                    this.N3 = 0;
                                    this.J3.request(i2);
                                }
                            }
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.b(th);
                            this.p2.addThrowable(th);
                            h();
                        }
                    } else {
                        long j = this.K3;
                        this.K3 = 1 + j;
                        a aVar2 = new a(this, j);
                        if (a(aVar2)) {
                            aVar.a(aVar2);
                        }
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.J3.cancel();
                    onError(th2);
                }
            }
        }

        @Override // io.reactivex.k, e.b.b
        public void onSubscribe(c cVar) {
            if (SubscriptionHelper.validate(this.J3, cVar)) {
                this.J3 = cVar;
                this.f15805f.onSubscribe(this);
                if (!this.p3) {
                    int i = this.y;
                    if (i == Integer.MAX_VALUE) {
                        cVar.request(Long.MAX_VALUE);
                    } else {
                        cVar.request(i);
                    }
                }
            }
        }

        @Override // e.b.c
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.I3, j);
                h();
            }
        }
    }

    public j(io.reactivex.h<T> hVar, io.reactivex.g0.j<? super T, ? extends e.b.a<? extends U>> jVar, boolean z, int i, int i2) {
        super(hVar);
        this.f15799f = jVar;
        this.q = z;
        this.x = i;
        this.y = i2;
    }

    public static <T, U> k<T> M(e.b.b<? super U> bVar, io.reactivex.g0.j<? super T, ? extends e.b.a<? extends U>> jVar, boolean z, int i, int i2) {
        return new b(bVar, jVar, z, i, i2);
    }

    @Override // io.reactivex.h
    protected void H(e.b.b<? super U> bVar) {
        if (!a0.b(this.f15765d, bVar, this.f15799f)) {
            this.f15765d.G(M(bVar, this.f15799f, this.q, this.x, this.y));
        }
    }
}

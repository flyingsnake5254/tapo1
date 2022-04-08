package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.g0.j;
import io.reactivex.h0.b.d;
import io.reactivex.h0.b.h;
import io.reactivex.h0.b.i;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.e;
import io.reactivex.t;
import io.reactivex.v;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableFlatMap.java */
/* loaded from: classes4.dex */
public final class r<T, U> extends a<T, U> {

    /* renamed from: d  reason: collision with root package name */
    final j<? super T, ? extends t<? extends U>> f16069d;

    /* renamed from: f  reason: collision with root package name */
    final boolean f16070f;
    final int q;
    final int x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableFlatMap.java */
    /* loaded from: classes4.dex */
    public static final class a<T, U> extends AtomicReference<c> implements v<U> {

        /* renamed from: c  reason: collision with root package name */
        final long f16071c;

        /* renamed from: d  reason: collision with root package name */
        final b<T, U> f16072d;

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f16073f;
        volatile i<U> q;
        int x;

        a(b<T, U> bVar, long j) {
            this.f16071c = j;
            this.f16072d = bVar;
        }

        public void a() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.v
        public void onComplete() {
            this.f16073f = true;
            this.f16072d.f();
        }

        @Override // io.reactivex.v
        public void onError(Throwable th) {
            if (this.f16072d.p2.addThrowable(th)) {
                b<T, U> bVar = this.f16072d;
                if (!bVar.x) {
                    bVar.d();
                }
                this.f16073f = true;
                this.f16072d.f();
                return;
            }
            io.reactivex.j0.a.r(th);
        }

        @Override // io.reactivex.v
        public void onNext(U u) {
            if (this.x == 0) {
                this.f16072d.k(u, this);
            } else {
                this.f16072d.f();
            }
        }

        @Override // io.reactivex.v
        public void onSubscribe(c cVar) {
            if (DisposableHelper.setOnce(this, cVar) && (cVar instanceof d)) {
                d dVar = (d) cVar;
                int requestFusion = dVar.requestFusion(7);
                if (requestFusion == 1) {
                    this.x = requestFusion;
                    this.q = dVar;
                    this.f16073f = true;
                    this.f16072d.f();
                } else if (requestFusion == 2) {
                    this.x = requestFusion;
                    this.q = dVar;
                }
            }
        }
    }

    /* compiled from: ObservableFlatMap.java */
    /* loaded from: classes4.dex */
    static final class b<T, U> extends AtomicInteger implements c, v<T> {

        /* renamed from: c  reason: collision with root package name */
        static final a<?, ?>[] f16074c = new a[0];

        /* renamed from: d  reason: collision with root package name */
        static final a<?, ?>[] f16075d = new a[0];
        final AtomicReference<a<?, ?>[]> H3;
        c I3;
        long J3;
        long K3;
        int L3;
        Queue<t<? extends U>> M3;
        int N3;

        /* renamed from: f  reason: collision with root package name */
        final v<? super U> f16076f;
        volatile h<U> p0;
        volatile boolean p1;
        final AtomicThrowable p2 = new AtomicThrowable();
        volatile boolean p3;
        final j<? super T, ? extends t<? extends U>> q;
        final boolean x;
        final int y;
        final int z;

        b(v<? super U> vVar, j<? super T, ? extends t<? extends U>> jVar, boolean z, int i, int i2) {
            this.f16076f = vVar;
            this.q = jVar;
            this.x = z;
            this.y = i;
            this.z = i2;
            if (i != Integer.MAX_VALUE) {
                this.M3 = new ArrayDeque(i);
            }
            this.H3 = new AtomicReference<>(f16074c);
        }

        /* JADX WARN: Multi-variable type inference failed */
        boolean a(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = this.H3.get();
                if (aVarArr == f16075d) {
                    aVar.a();
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!this.H3.compareAndSet(aVarArr, aVarArr2));
            return true;
        }

        boolean b() {
            if (this.p3) {
                return true;
            }
            Throwable th = this.p2.get();
            if (this.x || th == null) {
                return false;
            }
            d();
            Throwable terminate = this.p2.terminate();
            if (terminate != e.a) {
                this.f16076f.onError(terminate);
            }
            return true;
        }

        boolean d() {
            a<?, ?>[] andSet;
            this.I3.dispose();
            a<?, ?>[] aVarArr = this.H3.get();
            a<?, ?>[] aVarArr2 = f16075d;
            if (aVarArr == aVarArr2 || (andSet = this.H3.getAndSet(aVarArr2)) == aVarArr2) {
                return false;
            }
            for (a<?, ?> aVar : andSet) {
                aVar.a();
            }
            return true;
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            Throwable terminate;
            if (!this.p3) {
                this.p3 = true;
                if (d() && (terminate = this.p2.terminate()) != null && terminate != e.a) {
                    io.reactivex.j0.a.r(terminate);
                }
            }
        }

        void f() {
            if (getAndIncrement() == 0) {
                g();
            }
        }

        void g() {
            int i;
            v<? super U> vVar = this.f16076f;
            int i2 = 1;
            while (!b()) {
                h<U> hVar = this.p0;
                int i3 = 0;
                if (hVar != null) {
                    while (!b()) {
                        Object obj = (U) hVar.poll();
                        if (obj != null) {
                            vVar.onNext(obj);
                            i3++;
                        }
                    }
                    return;
                }
                if (i3 == 0) {
                    boolean z = this.p1;
                    h<U> hVar2 = this.p0;
                    a<?, ?>[] aVarArr = this.H3.get();
                    int length = aVarArr.length;
                    if (this.y != Integer.MAX_VALUE) {
                        synchronized (this) {
                            i = this.M3.size();
                        }
                    } else {
                        i = 0;
                    }
                    if (!z || !((hVar2 == null || hVar2.isEmpty()) && length == 0 && i == 0)) {
                        if (length != 0) {
                            long j = this.K3;
                            int i4 = this.L3;
                            if (length <= i4 || aVarArr[i4].f16071c != j) {
                                if (length <= i4) {
                                    i4 = 0;
                                }
                                for (int i5 = 0; i5 < length && aVarArr[i4].f16071c != j; i5++) {
                                    i4++;
                                    if (i4 == length) {
                                        i4 = 0;
                                    }
                                }
                                this.L3 = i4;
                                this.K3 = aVarArr[i4].f16071c;
                            }
                            for (int i6 = 0; i6 < length; i6++) {
                                if (!b()) {
                                    a<T, U> aVar = aVarArr[i4];
                                    i<U> iVar = aVar.q;
                                    if (iVar != null) {
                                        while (true) {
                                            try {
                                                Object obj2 = (U) iVar.poll();
                                                if (obj2 == null) {
                                                    break;
                                                }
                                                vVar.onNext(obj2);
                                                if (b()) {
                                                    return;
                                                }
                                            } catch (Throwable th) {
                                                io.reactivex.exceptions.a.b(th);
                                                aVar.a();
                                                this.p2.addThrowable(th);
                                                if (!b()) {
                                                    h(aVar);
                                                    i3++;
                                                    i4++;
                                                    if (i4 != length) {
                                                    }
                                                } else {
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                    boolean z2 = aVar.f16073f;
                                    i<U> iVar2 = aVar.q;
                                    if (z2 && (iVar2 == null || iVar2.isEmpty())) {
                                        h(aVar);
                                        if (!b()) {
                                            i3++;
                                        } else {
                                            return;
                                        }
                                    }
                                    i4++;
                                    if (i4 != length) {
                                    }
                                    i4 = 0;
                                } else {
                                    return;
                                }
                            }
                            this.L3 = i4;
                            this.K3 = aVarArr[i4].f16071c;
                        }
                        if (i3 == 0) {
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else if (this.y != Integer.MAX_VALUE) {
                            j(i3);
                        }
                    } else {
                        Throwable terminate = this.p2.terminate();
                        if (terminate == e.a) {
                            return;
                        }
                        if (terminate == null) {
                            vVar.onComplete();
                            return;
                        } else {
                            vVar.onError(terminate);
                            return;
                        }
                    }
                } else if (this.y != Integer.MAX_VALUE) {
                    j(i3);
                }
            }
        }

        void h(a<T, U> aVar) {
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
                            aVarArr2 = f16074c;
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

        void i(t<? extends U> tVar) {
            t<? extends U> poll;
            while (tVar instanceof Callable) {
                if (l((Callable) tVar) && this.y != Integer.MAX_VALUE) {
                    boolean z = false;
                    synchronized (this) {
                        poll = this.M3.poll();
                        if (poll == null) {
                            this.N3--;
                            z = true;
                        }
                    }
                    if (z) {
                        f();
                        return;
                    }
                    tVar = poll;
                } else {
                    return;
                }
            }
            long j = this.J3;
            this.J3 = 1 + j;
            a<T, U> aVar = new a<>(this, j);
            if (a(aVar)) {
                tVar.a(aVar);
            }
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.p3;
        }

        void j(int i) {
            while (true) {
                int i2 = i - 1;
                if (i != 0) {
                    synchronized (this) {
                        t<? extends U> poll = this.M3.poll();
                        if (poll == null) {
                            this.N3--;
                        } else {
                            i(poll);
                        }
                    }
                    i = i2;
                } else {
                    return;
                }
            }
        }

        void k(U u, a<T, U> aVar) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                i iVar = aVar.q;
                if (iVar == null) {
                    iVar = new io.reactivex.internal.queue.b(this.z);
                    aVar.q = iVar;
                }
                iVar.offer(u);
                if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                this.f16076f.onNext(u);
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            g();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v3, types: [io.reactivex.h0.b.i] */
        boolean l(Callable<? extends U> callable) {
            h<U> hVar;
            try {
                Object call = callable.call();
                if (call == null) {
                    return true;
                }
                if (get() != 0 || !compareAndSet(0, 1)) {
                    h<U> hVar2 = this.p0;
                    h<U> hVar3 = hVar2;
                    if (hVar2 == null) {
                        if (this.y == Integer.MAX_VALUE) {
                            hVar = new io.reactivex.internal.queue.b(this.z);
                        } else {
                            hVar = new SpscArrayQueue(this.y);
                        }
                        this.p0 = hVar;
                        hVar3 = hVar;
                    }
                    if (!hVar3.offer(call)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return true;
                    } else if (getAndIncrement() != 0) {
                        return false;
                    }
                } else {
                    this.f16076f.onNext(call);
                    if (decrementAndGet() == 0) {
                        return true;
                    }
                }
                g();
                return true;
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.p2.addThrowable(th);
                f();
                return true;
            }
        }

        @Override // io.reactivex.v
        public void onComplete() {
            if (!this.p1) {
                this.p1 = true;
                f();
            }
        }

        @Override // io.reactivex.v
        public void onError(Throwable th) {
            if (this.p1) {
                io.reactivex.j0.a.r(th);
            } else if (this.p2.addThrowable(th)) {
                this.p1 = true;
                f();
            } else {
                io.reactivex.j0.a.r(th);
            }
        }

        @Override // io.reactivex.v
        public void onNext(T t) {
            if (!this.p1) {
                try {
                    t<? extends U> tVar = (t) io.reactivex.h0.a.b.e(this.q.apply(t), "The mapper returned a null ObservableSource");
                    if (this.y != Integer.MAX_VALUE) {
                        synchronized (this) {
                            int i = this.N3;
                            if (i == this.y) {
                                this.M3.offer(tVar);
                                return;
                            }
                            this.N3 = i + 1;
                        }
                    }
                    i(tVar);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.I3.dispose();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.v
        public void onSubscribe(c cVar) {
            if (DisposableHelper.validate(this.I3, cVar)) {
                this.I3 = cVar;
                this.f16076f.onSubscribe(this);
            }
        }
    }

    public r(t<T> tVar, j<? super T, ? extends t<? extends U>> jVar, boolean z, int i, int i2) {
        super(tVar);
        this.f16069d = jVar;
        this.f16070f = z;
        this.q = i;
        this.x = i2;
    }

    @Override // io.reactivex.q
    public void K0(v<? super U> vVar) {
        if (!ObservableScalarXMap.b(this.f15892c, vVar, this.f16069d)) {
            this.f15892c.a(new b(vVar, this.f16069d, this.f16070f, this.q, this.x));
        }
    }
}

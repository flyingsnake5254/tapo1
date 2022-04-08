package io.reactivex.m0;

import io.reactivex.e0.c;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.internal.util.a;
import io.reactivex.internal.util.e;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: BehaviorSubject.java */
/* loaded from: classes4.dex */
public final class b<T> extends g<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final Object[] f16262c = new Object[0];

    /* renamed from: d  reason: collision with root package name */
    static final a[] f16263d = new a[0];

    /* renamed from: f  reason: collision with root package name */
    static final a[] f16264f = new a[0];
    final Lock p0;
    long p2;
    final ReadWriteLock y;
    final Lock z;
    final AtomicReference<a<T>[]> x = new AtomicReference<>(f16263d);
    final AtomicReference<Object> q = new AtomicReference<>();
    final AtomicReference<Throwable> p1 = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BehaviorSubject.java */
    /* loaded from: classes4.dex */
    public static final class a<T> implements c, a.AbstractC0315a<Object> {

        /* renamed from: c  reason: collision with root package name */
        final v<? super T> f16265c;

        /* renamed from: d  reason: collision with root package name */
        final b<T> f16266d;

        /* renamed from: f  reason: collision with root package name */
        boolean f16267f;
        long p0;
        boolean q;
        io.reactivex.internal.util.a<Object> x;
        boolean y;
        volatile boolean z;

        a(v<? super T> vVar, b<T> bVar) {
            this.f16265c = vVar;
            this.f16266d = bVar;
        }

        void a() {
            if (!this.z) {
                synchronized (this) {
                    if (!this.z) {
                        if (!this.f16267f) {
                            b<T> bVar = this.f16266d;
                            Lock lock = bVar.z;
                            lock.lock();
                            this.p0 = bVar.p2;
                            Object obj = bVar.q.get();
                            lock.unlock();
                            this.q = obj != null;
                            this.f16267f = true;
                            if (obj != null && !test(obj)) {
                                b();
                            }
                        }
                    }
                }
            }
        }

        void b() {
            io.reactivex.internal.util.a<Object> aVar;
            while (!this.z) {
                synchronized (this) {
                    aVar = this.x;
                    if (aVar == null) {
                        this.q = false;
                        return;
                    }
                    this.x = null;
                }
                aVar.d(this);
            }
        }

        void c(Object obj, long j) {
            if (!this.z) {
                if (!this.y) {
                    synchronized (this) {
                        if (!this.z) {
                            if (this.p0 != j) {
                                if (this.q) {
                                    io.reactivex.internal.util.a<Object> aVar = this.x;
                                    if (aVar == null) {
                                        aVar = new io.reactivex.internal.util.a<>(4);
                                        this.x = aVar;
                                    }
                                    aVar.c(obj);
                                    return;
                                }
                                this.f16267f = true;
                                this.y = true;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
                test(obj);
            }
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            if (!this.z) {
                this.z = true;
                this.f16266d.o1(this);
            }
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.z;
        }

        @Override // io.reactivex.internal.util.a.AbstractC0315a, io.reactivex.g0.l
        public boolean test(Object obj) {
            return this.z || NotificationLite.accept(obj, this.f16265c);
        }
    }

    b() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.y = reentrantReadWriteLock;
        this.z = reentrantReadWriteLock.readLock();
        this.p0 = reentrantReadWriteLock.writeLock();
    }

    public static <T> b<T> n1() {
        return new b<>();
    }

    @Override // io.reactivex.q
    protected void K0(v<? super T> vVar) {
        a<T> aVar = new a<>(vVar, this);
        vVar.onSubscribe(aVar);
        if (!m1(aVar)) {
            Throwable th = this.p1.get();
            if (th == e.a) {
                vVar.onComplete();
            } else {
                vVar.onError(th);
            }
        } else if (aVar.z) {
            o1(aVar);
        } else {
            aVar.a();
        }
    }

    @Override // io.reactivex.m0.g
    public boolean j1() {
        return NotificationLite.isComplete(this.q.get());
    }

    @Override // io.reactivex.m0.g
    public boolean k1() {
        return NotificationLite.isError(this.q.get());
    }

    boolean m1(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.x.get();
            if (aVarArr == f16264f) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.x.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    void o1(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.x.get();
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
                        aVarArr2 = f16263d;
                    } else {
                        a<T>[] aVarArr3 = new a[length - 1];
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
        } while (!this.x.compareAndSet(aVarArr, aVarArr2));
    }

    @Override // io.reactivex.v
    public void onComplete() {
        if (this.p1.compareAndSet(null, e.a)) {
            Object complete = NotificationLite.complete();
            for (a<T> aVar : q1(complete)) {
                aVar.c(complete, this.p2);
            }
        }
    }

    @Override // io.reactivex.v
    public void onError(Throwable th) {
        io.reactivex.h0.a.b.e(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.p1.compareAndSet(null, th)) {
            io.reactivex.j0.a.r(th);
            return;
        }
        Object error = NotificationLite.error(th);
        for (a<T> aVar : q1(error)) {
            aVar.c(error, this.p2);
        }
    }

    @Override // io.reactivex.v
    public void onNext(T t) {
        io.reactivex.h0.a.b.e(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.p1.get() == null) {
            Object next = NotificationLite.next(t);
            p1(next);
            for (a<T> aVar : this.x.get()) {
                aVar.c(next, this.p2);
            }
        }
    }

    @Override // io.reactivex.v
    public void onSubscribe(c cVar) {
        if (this.p1.get() != null) {
            cVar.dispose();
        }
    }

    void p1(Object obj) {
        this.p0.lock();
        this.p2++;
        this.q.lazySet(obj);
        this.p0.unlock();
    }

    a<T>[] q1(Object obj) {
        AtomicReference<a<T>[]> atomicReference = this.x;
        a<T>[] aVarArr = f16264f;
        a<T>[] andSet = atomicReference.getAndSet(aVarArr);
        if (andSet != aVarArr) {
            p1(obj);
        }
        return andSet;
    }
}

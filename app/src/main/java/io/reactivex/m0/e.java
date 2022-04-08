package io.reactivex.m0;

import io.reactivex.internal.util.NotificationLite;
import io.reactivex.v;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ReplaySubject.java */
/* loaded from: classes4.dex */
public final class e<T> extends g<T> {

    /* renamed from: c  reason: collision with root package name */
    static final b[] f16277c = new b[0];

    /* renamed from: d  reason: collision with root package name */
    static final b[] f16278d = new b[0];

    /* renamed from: f  reason: collision with root package name */
    private static final Object[] f16279f = new Object[0];
    final a<T> q;
    final AtomicReference<b<T>[]> x = new AtomicReference<>(f16277c);
    boolean y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReplaySubject.java */
    /* loaded from: classes4.dex */
    public interface a<T> {
        void a(Object obj);

        void add(T t);

        void b(b<T> bVar);

        boolean compareAndSet(Object obj, Object obj2);

        Object get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReplaySubject.java */
    /* loaded from: classes4.dex */
    public static final class b<T> extends AtomicInteger implements io.reactivex.e0.c {

        /* renamed from: c  reason: collision with root package name */
        final v<? super T> f16280c;

        /* renamed from: d  reason: collision with root package name */
        final e<T> f16281d;

        /* renamed from: f  reason: collision with root package name */
        Object f16282f;
        volatile boolean q;

        b(v<? super T> vVar, e<T> eVar) {
            this.f16280c = vVar;
            this.f16281d = eVar;
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            if (!this.q) {
                this.q = true;
                this.f16281d.o1(this);
            }
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.q;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReplaySubject.java */
    /* loaded from: classes4.dex */
    public static final class c<T> extends AtomicReference<Object> implements a<T> {

        /* renamed from: c  reason: collision with root package name */
        final List<Object> f16283c;

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f16284d;

        /* renamed from: f  reason: collision with root package name */
        volatile int f16285f;

        c(int i) {
            this.f16283c = new ArrayList(io.reactivex.h0.a.b.f(i, "capacityHint"));
        }

        @Override // io.reactivex.m0.e.a
        public void a(Object obj) {
            this.f16283c.add(obj);
            d();
            this.f16285f++;
            this.f16284d = true;
        }

        @Override // io.reactivex.m0.e.a
        public void add(T t) {
            this.f16283c.add(t);
            this.f16285f++;
        }

        @Override // io.reactivex.m0.e.a
        public void b(b<T> bVar) {
            int i;
            if (bVar.getAndIncrement() == 0) {
                List<Object> list = this.f16283c;
                v<? super T> vVar = bVar.f16280c;
                Integer num = (Integer) bVar.f16282f;
                int i2 = 0;
                if (num != null) {
                    i2 = num.intValue();
                } else {
                    bVar.f16282f = 0;
                }
                int i3 = 1;
                while (!bVar.q) {
                    int i4 = this.f16285f;
                    while (i4 != i2) {
                        if (bVar.q) {
                            bVar.f16282f = null;
                            return;
                        }
                        Object obj = list.get(i2);
                        if (this.f16284d && (i = i2 + 1) == i4 && i == (i4 = this.f16285f)) {
                            if (NotificationLite.isComplete(obj)) {
                                vVar.onComplete();
                            } else {
                                vVar.onError(NotificationLite.getError(obj));
                            }
                            bVar.f16282f = null;
                            bVar.q = true;
                            return;
                        }
                        vVar.onNext(obj);
                        i2++;
                    }
                    if (i2 == this.f16285f) {
                        bVar.f16282f = Integer.valueOf(i2);
                        i3 = bVar.addAndGet(-i3);
                        if (i3 == 0) {
                            return;
                        }
                    }
                }
                bVar.f16282f = null;
            }
        }

        public void d() {
        }
    }

    e(a<T> aVar) {
        this.q = aVar;
    }

    public static <T> e<T> n1() {
        return new e<>(new c(16));
    }

    @Override // io.reactivex.q
    protected void K0(v<? super T> vVar) {
        b<T> bVar = new b<>(vVar, this);
        vVar.onSubscribe(bVar);
        if (bVar.q) {
            return;
        }
        if (!m1(bVar) || !bVar.q) {
            this.q.b(bVar);
        } else {
            o1(bVar);
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

    boolean m1(b<T> bVar) {
        b<T>[] bVarArr;
        b<T>[] bVarArr2;
        do {
            bVarArr = this.x.get();
            if (bVarArr == f16278d) {
                return false;
            }
            int length = bVarArr.length;
            bVarArr2 = new b[length + 1];
            System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
            bVarArr2[length] = bVar;
        } while (!this.x.compareAndSet(bVarArr, bVarArr2));
        return true;
    }

    void o1(b<T> bVar) {
        b<T>[] bVarArr;
        b<T>[] bVarArr2;
        do {
            bVarArr = this.x.get();
            if (bVarArr != f16278d && bVarArr != f16277c) {
                int length = bVarArr.length;
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (bVarArr[i2] == bVar) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        bVarArr2 = f16277c;
                    } else {
                        b<T>[] bVarArr3 = new b[length - 1];
                        System.arraycopy(bVarArr, 0, bVarArr3, 0, i);
                        System.arraycopy(bVarArr, i + 1, bVarArr3, i, (length - i) - 1);
                        bVarArr2 = bVarArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.x.compareAndSet(bVarArr, bVarArr2));
    }

    @Override // io.reactivex.v
    public void onComplete() {
        if (!this.y) {
            this.y = true;
            Object complete = NotificationLite.complete();
            a<T> aVar = this.q;
            aVar.a(complete);
            for (b<T> bVar : p1(complete)) {
                aVar.b(bVar);
            }
        }
    }

    @Override // io.reactivex.v
    public void onError(Throwable th) {
        io.reactivex.h0.a.b.e(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.y) {
            io.reactivex.j0.a.r(th);
            return;
        }
        this.y = true;
        Object error = NotificationLite.error(th);
        a<T> aVar = this.q;
        aVar.a(error);
        for (b<T> bVar : p1(error)) {
            aVar.b(bVar);
        }
    }

    @Override // io.reactivex.v
    public void onNext(T t) {
        io.reactivex.h0.a.b.e(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.y) {
            a<T> aVar = this.q;
            aVar.add(t);
            for (b<T> bVar : this.x.get()) {
                aVar.b(bVar);
            }
        }
    }

    @Override // io.reactivex.v
    public void onSubscribe(io.reactivex.e0.c cVar) {
        if (this.y) {
            cVar.dispose();
        }
    }

    b<T>[] p1(Object obj) {
        if (this.q.compareAndSet(null, obj)) {
            return this.x.getAndSet(f16278d);
        }
        return f16278d;
    }
}

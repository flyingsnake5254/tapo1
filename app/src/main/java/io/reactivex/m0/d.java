package io.reactivex.m0;

import io.reactivex.e0.c;
import io.reactivex.h0.a.b;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: PublishSubject.java */
/* loaded from: classes4.dex */
public final class d<T> extends g<T> {

    /* renamed from: c  reason: collision with root package name */
    static final a[] f16272c = new a[0];

    /* renamed from: d  reason: collision with root package name */
    static final a[] f16273d = new a[0];

    /* renamed from: f  reason: collision with root package name */
    final AtomicReference<a<T>[]> f16274f = new AtomicReference<>(f16273d);
    Throwable q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PublishSubject.java */
    /* loaded from: classes4.dex */
    public static final class a<T> extends AtomicBoolean implements c {

        /* renamed from: c  reason: collision with root package name */
        final v<? super T> f16275c;

        /* renamed from: d  reason: collision with root package name */
        final d<T> f16276d;

        a(v<? super T> vVar, d<T> dVar) {
            this.f16275c = vVar;
            this.f16276d = dVar;
        }

        public void a() {
            if (!get()) {
                this.f16275c.onComplete();
            }
        }

        public void b(Throwable th) {
            if (get()) {
                io.reactivex.j0.a.r(th);
            } else {
                this.f16275c.onError(th);
            }
        }

        public void d(T t) {
            if (!get()) {
                this.f16275c.onNext(t);
            }
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.f16276d.o1(this);
            }
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return get();
        }
    }

    d() {
    }

    public static <T> d<T> n1() {
        return new d<>();
    }

    @Override // io.reactivex.q
    protected void K0(v<? super T> vVar) {
        a<T> aVar = new a<>(vVar, this);
        vVar.onSubscribe(aVar);
        if (!m1(aVar)) {
            Throwable th = this.q;
            if (th != null) {
                vVar.onError(th);
            } else {
                vVar.onComplete();
            }
        } else if (aVar.isDisposed()) {
            o1(aVar);
        }
    }

    @Override // io.reactivex.m0.g
    public boolean j1() {
        return this.f16274f.get() == f16272c && this.q == null;
    }

    @Override // io.reactivex.m0.g
    public boolean k1() {
        return this.f16274f.get() == f16272c && this.q != null;
    }

    boolean m1(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f16274f.get();
            if (aVarArr == f16272c) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f16274f.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    void o1(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f16274f.get();
            if (aVarArr != f16272c && aVarArr != f16273d) {
                int length = aVarArr.length;
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
                        aVarArr2 = f16273d;
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
        } while (!this.f16274f.compareAndSet(aVarArr, aVarArr2));
    }

    @Override // io.reactivex.v
    public void onComplete() {
        a<T>[] aVarArr = this.f16274f.get();
        a<T>[] aVarArr2 = f16272c;
        if (aVarArr != aVarArr2) {
            for (a<T> aVar : this.f16274f.getAndSet(aVarArr2)) {
                aVar.a();
            }
        }
    }

    @Override // io.reactivex.v
    public void onError(Throwable th) {
        b.e(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        a<T>[] aVarArr = this.f16274f.get();
        a<T>[] aVarArr2 = f16272c;
        if (aVarArr == aVarArr2) {
            io.reactivex.j0.a.r(th);
            return;
        }
        this.q = th;
        for (a<T> aVar : this.f16274f.getAndSet(aVarArr2)) {
            aVar.b(th);
        }
    }

    @Override // io.reactivex.v
    public void onNext(T t) {
        b.e(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (a<T> aVar : this.f16274f.get()) {
            aVar.d(t);
        }
    }

    @Override // io.reactivex.v
    public void onSubscribe(c cVar) {
        if (this.f16274f.get() == f16272c) {
            cVar.dispose();
        }
    }
}

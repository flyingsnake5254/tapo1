package io.reactivex.m0;

import io.reactivex.e0.c;
import io.reactivex.h0.a.b;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: AsyncSubject.java */
/* loaded from: classes4.dex */
public final class a<T> extends g<T> {

    /* renamed from: c  reason: collision with root package name */
    static final C0317a[] f16258c = new C0317a[0];

    /* renamed from: d  reason: collision with root package name */
    static final C0317a[] f16259d = new C0317a[0];

    /* renamed from: f  reason: collision with root package name */
    final AtomicReference<C0317a<T>[]> f16260f = new AtomicReference<>(f16258c);
    Throwable q;
    T x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AsyncSubject.java */
    /* renamed from: io.reactivex.m0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0317a<T> extends DeferredScalarDisposable<T> {

        /* renamed from: c  reason: collision with root package name */
        final a<T> f16261c;

        C0317a(v<? super T> vVar, a<T> aVar) {
            super(vVar);
            this.f16261c = aVar;
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.e0.c
        public void dispose() {
            if (super.tryDispose()) {
                this.f16261c.o1(this);
            }
        }

        void onComplete() {
            if (!isDisposed()) {
                this.downstream.onComplete();
            }
        }

        void onError(Throwable th) {
            if (isDisposed()) {
                io.reactivex.j0.a.r(th);
            } else {
                this.downstream.onError(th);
            }
        }
    }

    a() {
    }

    public static <T> a<T> n1() {
        return new a<>();
    }

    @Override // io.reactivex.q
    protected void K0(v<? super T> vVar) {
        C0317a<T> aVar = new C0317a<>(vVar, this);
        vVar.onSubscribe(aVar);
        if (!m1(aVar)) {
            Throwable th = this.q;
            if (th != null) {
                vVar.onError(th);
                return;
            }
            T t = this.x;
            if (t != null) {
                aVar.complete(t);
            } else {
                aVar.onComplete();
            }
        } else if (aVar.isDisposed()) {
            o1(aVar);
        }
    }

    @Override // io.reactivex.m0.g
    public boolean j1() {
        return this.f16260f.get() == f16259d && this.q == null;
    }

    @Override // io.reactivex.m0.g
    public boolean k1() {
        return this.f16260f.get() == f16259d && this.q != null;
    }

    boolean m1(C0317a<T> aVar) {
        C0317a<T>[] aVarArr;
        C0317a<T>[] aVarArr2;
        do {
            aVarArr = this.f16260f.get();
            if (aVarArr == f16259d) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new C0317a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f16260f.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    void o1(C0317a<T> aVar) {
        C0317a<T>[] aVarArr;
        C0317a<T>[] aVarArr2;
        do {
            aVarArr = this.f16260f.get();
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
                        aVarArr2 = f16258c;
                    } else {
                        C0317a<T>[] aVarArr3 = new C0317a[length - 1];
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
        } while (!this.f16260f.compareAndSet(aVarArr, aVarArr2));
    }

    @Override // io.reactivex.v
    public void onComplete() {
        C0317a<T>[] aVarArr = this.f16260f.get();
        C0317a<T>[] aVarArr2 = f16259d;
        if (aVarArr != aVarArr2) {
            T t = this.x;
            C0317a<T>[] andSet = this.f16260f.getAndSet(aVarArr2);
            int i = 0;
            if (t == null) {
                int length = andSet.length;
                while (i < length) {
                    andSet[i].onComplete();
                    i++;
                }
                return;
            }
            int length2 = andSet.length;
            while (i < length2) {
                andSet[i].complete(t);
                i++;
            }
        }
    }

    @Override // io.reactivex.v
    public void onError(Throwable th) {
        b.e(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        C0317a<T>[] aVarArr = this.f16260f.get();
        C0317a<T>[] aVarArr2 = f16259d;
        if (aVarArr == aVarArr2) {
            io.reactivex.j0.a.r(th);
            return;
        }
        this.x = null;
        this.q = th;
        for (C0317a<T> aVar : this.f16260f.getAndSet(aVarArr2)) {
            aVar.onError(th);
        }
    }

    @Override // io.reactivex.v
    public void onNext(T t) {
        b.e(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f16260f.get() != f16259d) {
            this.x = t;
        }
    }

    @Override // io.reactivex.v
    public void onSubscribe(c cVar) {
        if (this.f16260f.get() == f16259d) {
            cVar.dispose();
        }
    }
}

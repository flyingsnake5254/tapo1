package io.reactivex.m0;

import io.reactivex.h0.a.b;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CompletableSubject.java */
/* loaded from: classes4.dex */
public final class c extends io.reactivex.a implements io.reactivex.c {

    /* renamed from: c  reason: collision with root package name */
    static final a[] f16268c = new a[0];

    /* renamed from: d  reason: collision with root package name */
    static final a[] f16269d = new a[0];
    Throwable x;
    final AtomicBoolean q = new AtomicBoolean();

    /* renamed from: f  reason: collision with root package name */
    final AtomicReference<a[]> f16270f = new AtomicReference<>(f16268c);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CompletableSubject.java */
    /* loaded from: classes4.dex */
    public static final class a extends AtomicReference<c> implements io.reactivex.e0.c {

        /* renamed from: c  reason: collision with root package name */
        final io.reactivex.c f16271c;

        a(io.reactivex.c cVar, c cVar2) {
            this.f16271c = cVar;
            lazySet(cVar2);
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            c andSet = getAndSet(null);
            if (andSet != null) {
                andSet.N(this);
            }
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return get() == null;
        }
    }

    c() {
    }

    public static c M() {
        return new c();
    }

    @Override // io.reactivex.a
    protected void B(io.reactivex.c cVar) {
        a aVar = new a(cVar, this);
        cVar.onSubscribe(aVar);
        if (!L(aVar)) {
            Throwable th = this.x;
            if (th != null) {
                cVar.onError(th);
            } else {
                cVar.onComplete();
            }
        } else if (aVar.isDisposed()) {
            N(aVar);
        }
    }

    boolean L(a aVar) {
        a[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = this.f16270f.get();
            if (aVarArr == f16269d) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f16270f.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    void N(a aVar) {
        a[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = this.f16270f.get();
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
                        aVarArr2 = f16268c;
                    } else {
                        a[] aVarArr3 = new a[length - 1];
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
        } while (!this.f16270f.compareAndSet(aVarArr, aVarArr2));
    }

    @Override // io.reactivex.c
    public void onComplete() {
        if (this.q.compareAndSet(false, true)) {
            for (a aVar : this.f16270f.getAndSet(f16269d)) {
                aVar.f16271c.onComplete();
            }
        }
    }

    @Override // io.reactivex.c
    public void onError(Throwable th) {
        b.e(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.q.compareAndSet(false, true)) {
            this.x = th;
            for (a aVar : this.f16270f.getAndSet(f16269d)) {
                aVar.f16271c.onError(th);
            }
            return;
        }
        io.reactivex.j0.a.r(th);
    }

    @Override // io.reactivex.c
    public void onSubscribe(io.reactivex.e0.c cVar) {
        if (this.f16270f.get() == f16269d) {
            cVar.dispose();
        }
    }
}

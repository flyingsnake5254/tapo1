package io.reactivex.internal.observers;

import io.reactivex.internal.util.e;
import io.reactivex.n;
import io.reactivex.z;
import java.util.concurrent.CountDownLatch;

/* compiled from: BlockingMultiObserver.java */
/* loaded from: classes4.dex */
public final class c<T> extends CountDownLatch implements z<T>, io.reactivex.c, n<T> {

    /* renamed from: c  reason: collision with root package name */
    T f15752c;

    /* renamed from: d  reason: collision with root package name */
    Throwable f15753d;

    /* renamed from: f  reason: collision with root package name */
    io.reactivex.e0.c f15754f;
    volatile boolean q;

    public c() {
        super(1);
    }

    public T a() {
        if (getCount() != 0) {
            try {
                io.reactivex.internal.util.c.a();
                await();
            } catch (InterruptedException e2) {
                b();
                throw e.e(e2);
            }
        }
        Throwable th = this.f15753d;
        if (th == null) {
            return this.f15752c;
        }
        throw e.e(th);
    }

    void b() {
        this.q = true;
        io.reactivex.e0.c cVar = this.f15754f;
        if (cVar != null) {
            cVar.dispose();
        }
    }

    @Override // io.reactivex.c
    public void onComplete() {
        countDown();
    }

    @Override // io.reactivex.z
    public void onError(Throwable th) {
        this.f15753d = th;
        countDown();
    }

    @Override // io.reactivex.z
    public void onSubscribe(io.reactivex.e0.c cVar) {
        this.f15754f = cVar;
        if (this.q) {
            cVar.dispose();
        }
    }

    @Override // io.reactivex.z
    public void onSuccess(T t) {
        this.f15752c = t;
        countDown();
    }
}

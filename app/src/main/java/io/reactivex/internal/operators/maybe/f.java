package io.reactivex.internal.operators.maybe;

import io.reactivex.e0.c;
import io.reactivex.e0.d;
import io.reactivex.exceptions.a;
import io.reactivex.m;
import io.reactivex.n;
import java.util.concurrent.Callable;

/* compiled from: MaybeFromCallable.java */
/* loaded from: classes4.dex */
public final class f<T> extends m<T> implements Callable<T> {

    /* renamed from: c  reason: collision with root package name */
    final Callable<? extends T> f15868c;

    public f(Callable<? extends T> callable) {
        this.f15868c = callable;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return (T) this.f15868c.call();
    }

    @Override // io.reactivex.m
    protected void n(n<? super T> nVar) {
        c b2 = d.b();
        nVar.onSubscribe(b2);
        if (!b2.isDisposed()) {
            try {
                Object obj = (Object) this.f15868c.call();
                if (b2.isDisposed()) {
                    return;
                }
                if (obj == 0) {
                    nVar.onComplete();
                } else {
                    nVar.onSuccess(obj);
                }
            } catch (Throwable th) {
                a.b(th);
                if (!b2.isDisposed()) {
                    nVar.onError(th);
                } else {
                    io.reactivex.j0.a.r(th);
                }
            }
        }
    }
}

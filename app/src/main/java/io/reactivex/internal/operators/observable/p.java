package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.a;
import io.reactivex.h0.a.b;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.q;
import io.reactivex.v;
import java.util.concurrent.Callable;

/* compiled from: ObservableError.java */
/* loaded from: classes4.dex */
public final class p<T> extends q<T> {

    /* renamed from: c  reason: collision with root package name */
    final Callable<? extends Throwable> f16057c;

    public p(Callable<? extends Throwable> callable) {
        this.f16057c = callable;
    }

    @Override // io.reactivex.q
    public void K0(v<? super T> vVar) {
        Throwable th;
        try {
            th = (Throwable) b.e(this.f16057c.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th2) {
            th = th2;
            a.b(th);
        }
        EmptyDisposable.error(th, vVar);
    }
}

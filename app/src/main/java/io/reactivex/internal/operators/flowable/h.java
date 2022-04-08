package io.reactivex.internal.operators.flowable;

import e.b.b;
import io.reactivex.exceptions.a;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;

/* compiled from: FlowableError.java */
/* loaded from: classes4.dex */
public final class h<T> extends io.reactivex.h<T> {

    /* renamed from: d  reason: collision with root package name */
    final Callable<? extends Throwable> f15797d;

    public h(Callable<? extends Throwable> callable) {
        this.f15797d = callable;
    }

    @Override // io.reactivex.h
    public void H(b<? super T> bVar) {
        Throwable th;
        try {
            th = (Throwable) io.reactivex.h0.a.b.e(this.f15797d.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th2) {
            th = th2;
            a.b(th);
        }
        EmptySubscription.error(th, bVar);
    }
}

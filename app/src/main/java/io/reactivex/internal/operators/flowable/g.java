package io.reactivex.internal.operators.flowable;

import e.b.b;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.EmptySubscription;

/* compiled from: FlowableEmpty.java */
/* loaded from: classes4.dex */
public final class g extends h<Object> implements io.reactivex.h0.b.g<Object> {

    /* renamed from: d  reason: collision with root package name */
    public static final h<Object> f15796d = new g();

    private g() {
    }

    @Override // io.reactivex.h
    public void H(b<? super Object> bVar) {
        EmptySubscription.complete(bVar);
    }

    @Override // io.reactivex.h0.b.g, java.util.concurrent.Callable
    public Object call() {
        return null;
    }
}

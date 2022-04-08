package io.reactivex.internal.operators.flowable;

import e.b.a;
import e.b.c;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.k;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableRepeatWhen.java */
/* loaded from: classes4.dex */
final class w<T, U> extends AtomicInteger implements k<Object>, c {

    /* renamed from: c  reason: collision with root package name */
    final a<T> f15842c;

    /* renamed from: d  reason: collision with root package name */
    final AtomicReference<c> f15843d = new AtomicReference<>();

    /* renamed from: f  reason: collision with root package name */
    final AtomicLong f15844f = new AtomicLong();
    x<T, U> q;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(a<T> aVar) {
        this.f15842c = aVar;
    }

    @Override // e.b.c
    public void cancel() {
        SubscriptionHelper.cancel(this.f15843d);
    }

    @Override // e.b.b
    public void onComplete() {
        this.q.cancel();
        this.q.f15845c.onComplete();
    }

    @Override // e.b.b
    public void onError(Throwable th) {
        this.q.cancel();
        this.q.f15845c.onError(th);
    }

    @Override // e.b.b
    public void onNext(Object obj) {
        if (getAndIncrement() == 0) {
            while (this.f15843d.get() != SubscriptionHelper.CANCELLED) {
                this.f15842c.a(this.q);
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    @Override // io.reactivex.k, e.b.b
    public void onSubscribe(c cVar) {
        SubscriptionHelper.deferredSetOnce(this.f15843d, this.f15844f, cVar);
    }

    @Override // e.b.c
    public void request(long j) {
        SubscriptionHelper.deferredRequest(this.f15843d, this.f15844f, j);
    }
}

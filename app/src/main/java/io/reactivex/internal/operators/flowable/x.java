package io.reactivex.internal.operators.flowable;

import e.b.b;
import e.b.c;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.k;
import io.reactivex.k0.a;

/* compiled from: FlowableRepeatWhen.java */
/* loaded from: classes4.dex */
abstract class x<T, U> extends SubscriptionArbiter implements k<T> {

    /* renamed from: c  reason: collision with root package name */
    protected final b<? super T> f15845c;

    /* renamed from: d  reason: collision with root package name */
    protected final a<U> f15846d;

    /* renamed from: f  reason: collision with root package name */
    protected final c f15847f;
    private long q;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(b<? super T> bVar, a<U> aVar, c cVar) {
        super(false);
        this.f15845c = bVar;
        this.f15846d = aVar;
        this.f15847f = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(U u) {
        setSubscription(EmptySubscription.INSTANCE);
        long j = this.q;
        if (j != 0) {
            this.q = 0L;
            produced(j);
        }
        this.f15847f.request(1L);
        this.f15846d.onNext(u);
    }

    @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, e.b.c
    public final void cancel() {
        super.cancel();
        this.f15847f.cancel();
    }

    @Override // e.b.b
    public final void onNext(T t) {
        this.q++;
        this.f15845c.onNext(t);
    }

    @Override // io.reactivex.k, e.b.b
    public final void onSubscribe(c cVar) {
        setSubscription(cVar);
    }
}

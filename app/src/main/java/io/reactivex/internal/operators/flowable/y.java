package io.reactivex.internal.operators.flowable;

import e.b.b;
import e.b.c;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.g0.l;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.k;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: FlowableRetryPredicate.java */
/* loaded from: classes4.dex */
public final class y<T> extends a<T, T> {

    /* renamed from: f  reason: collision with root package name */
    final l<? super Throwable> f15848f;
    final long q;

    /* compiled from: FlowableRetryPredicate.java */
    /* loaded from: classes4.dex */
    static final class a<T> extends AtomicInteger implements k<T> {

        /* renamed from: c  reason: collision with root package name */
        final b<? super T> f15849c;

        /* renamed from: d  reason: collision with root package name */
        final SubscriptionArbiter f15850d;

        /* renamed from: f  reason: collision with root package name */
        final e.b.a<? extends T> f15851f;
        final l<? super Throwable> q;
        long x;
        long y;

        a(b<? super T> bVar, long j, l<? super Throwable> lVar, SubscriptionArbiter subscriptionArbiter, e.b.a<? extends T> aVar) {
            this.f15849c = bVar;
            this.f15850d = subscriptionArbiter;
            this.f15851f = aVar;
            this.q = lVar;
            this.x = j;
        }

        void a() {
            if (getAndIncrement() == 0) {
                int i = 1;
                while (!this.f15850d.isCancelled()) {
                    long j = this.y;
                    if (j != 0) {
                        this.y = 0L;
                        this.f15850d.produced(j);
                    }
                    this.f15851f.a(this);
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        @Override // e.b.b
        public void onComplete() {
            this.f15849c.onComplete();
        }

        @Override // e.b.b
        public void onError(Throwable th) {
            long j = this.x;
            if (j != Long.MAX_VALUE) {
                this.x = j - 1;
            }
            if (j == 0) {
                this.f15849c.onError(th);
                return;
            }
            try {
                if (!this.q.test(th)) {
                    this.f15849c.onError(th);
                } else {
                    a();
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f15849c.onError(new CompositeException(th, th2));
            }
        }

        @Override // e.b.b
        public void onNext(T t) {
            this.y++;
            this.f15849c.onNext(t);
        }

        @Override // io.reactivex.k, e.b.b
        public void onSubscribe(c cVar) {
            this.f15850d.setSubscription(cVar);
        }
    }

    public y(h<T> hVar, long j, l<? super Throwable> lVar) {
        super(hVar);
        this.f15848f = lVar;
        this.q = j;
    }

    @Override // io.reactivex.h
    public void H(b<? super T> bVar) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter(false);
        bVar.onSubscribe(subscriptionArbiter);
        new a(bVar, this.q, this.f15848f, subscriptionArbiter, this.f15765d).a();
    }
}

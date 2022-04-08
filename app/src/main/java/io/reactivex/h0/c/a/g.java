package io.reactivex.h0.c.a;

import io.reactivex.e0.c;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.k;

/* compiled from: CompletableFromPublisher.java */
/* loaded from: classes4.dex */
public final class g<T> extends io.reactivex.a {

    /* renamed from: c  reason: collision with root package name */
    final e.b.a<T> f15664c;

    /* compiled from: CompletableFromPublisher.java */
    /* loaded from: classes4.dex */
    static final class a<T> implements k<T>, c {

        /* renamed from: c  reason: collision with root package name */
        final io.reactivex.c f15665c;

        /* renamed from: d  reason: collision with root package name */
        e.b.c f15666d;

        a(io.reactivex.c cVar) {
            this.f15665c = cVar;
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            this.f15666d.cancel();
            this.f15666d = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.f15666d == SubscriptionHelper.CANCELLED;
        }

        @Override // e.b.b
        public void onComplete() {
            this.f15665c.onComplete();
        }

        @Override // e.b.b
        public void onError(Throwable th) {
            this.f15665c.onError(th);
        }

        @Override // e.b.b
        public void onNext(T t) {
        }

        @Override // io.reactivex.k, e.b.b
        public void onSubscribe(e.b.c cVar) {
            if (SubscriptionHelper.validate(this.f15666d, cVar)) {
                this.f15666d = cVar;
                this.f15665c.onSubscribe(this);
                cVar.request(Long.MAX_VALUE);
            }
        }
    }

    public g(e.b.a<T> aVar) {
        this.f15664c = aVar;
    }

    @Override // io.reactivex.a
    protected void B(io.reactivex.c cVar) {
        this.f15664c.a(new a(cVar));
    }
}

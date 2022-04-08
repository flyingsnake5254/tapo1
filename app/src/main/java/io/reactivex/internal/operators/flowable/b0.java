package io.reactivex.internal.operators.flowable;

import e.b.b;
import e.b.c;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.k;
import io.reactivex.w;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableSubscribeOn.java */
/* loaded from: classes4.dex */
public final class b0<T> extends a<T, T> {

    /* renamed from: f  reason: collision with root package name */
    final w f15773f;
    final boolean q;

    /* compiled from: FlowableSubscribeOn.java */
    /* loaded from: classes4.dex */
    static final class a<T> extends AtomicReference<Thread> implements k<T>, c, Runnable {

        /* renamed from: c  reason: collision with root package name */
        final b<? super T> f15774c;

        /* renamed from: d  reason: collision with root package name */
        final w.c f15775d;

        /* renamed from: f  reason: collision with root package name */
        final AtomicReference<c> f15776f = new AtomicReference<>();
        final AtomicLong q = new AtomicLong();
        final boolean x;
        e.b.a<T> y;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: FlowableSubscribeOn.java */
        /* renamed from: io.reactivex.internal.operators.flowable.b0$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class RunnableC0297a implements Runnable {

            /* renamed from: c  reason: collision with root package name */
            final c f15777c;

            /* renamed from: d  reason: collision with root package name */
            final long f15778d;

            RunnableC0297a(c cVar, long j) {
                this.f15777c = cVar;
                this.f15778d = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f15777c.request(this.f15778d);
            }
        }

        a(b<? super T> bVar, w.c cVar, e.b.a<T> aVar, boolean z) {
            this.f15774c = bVar;
            this.f15775d = cVar;
            this.y = aVar;
            this.x = !z;
        }

        void a(long j, c cVar) {
            if (this.x || Thread.currentThread() == get()) {
                cVar.request(j);
            } else {
                this.f15775d.b(new RunnableC0297a(cVar, j));
            }
        }

        @Override // e.b.c
        public void cancel() {
            SubscriptionHelper.cancel(this.f15776f);
            this.f15775d.dispose();
        }

        @Override // e.b.b
        public void onComplete() {
            this.f15774c.onComplete();
            this.f15775d.dispose();
        }

        @Override // e.b.b
        public void onError(Throwable th) {
            this.f15774c.onError(th);
            this.f15775d.dispose();
        }

        @Override // e.b.b
        public void onNext(T t) {
            this.f15774c.onNext(t);
        }

        @Override // io.reactivex.k, e.b.b
        public void onSubscribe(c cVar) {
            if (SubscriptionHelper.setOnce(this.f15776f, cVar)) {
                long andSet = this.q.getAndSet(0L);
                if (andSet != 0) {
                    a(andSet, cVar);
                }
            }
        }

        @Override // e.b.c
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                c cVar = this.f15776f.get();
                if (cVar != null) {
                    a(j, cVar);
                    return;
                }
                io.reactivex.internal.util.b.a(this.q, j);
                c cVar2 = this.f15776f.get();
                if (cVar2 != null) {
                    long andSet = this.q.getAndSet(0L);
                    if (andSet != 0) {
                        a(andSet, cVar2);
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            lazySet(Thread.currentThread());
            e.b.a<T> aVar = this.y;
            this.y = null;
            aVar.a(this);
        }
    }

    public b0(h<T> hVar, w wVar, boolean z) {
        super(hVar);
        this.f15773f = wVar;
        this.q = z;
    }

    @Override // io.reactivex.h
    public void H(b<? super T> bVar) {
        w.c b2 = this.f15773f.b();
        a aVar = new a(bVar, b2, this.f15765d, this.q);
        bVar.onSubscribe(aVar);
        b2.b(aVar);
    }
}

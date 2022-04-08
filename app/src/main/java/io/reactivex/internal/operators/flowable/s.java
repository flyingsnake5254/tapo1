package io.reactivex.internal.operators.flowable;

import e.b.b;
import e.b.c;
import io.reactivex.g0.g;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.k;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FlowableOnBackpressureDrop.java */
/* loaded from: classes4.dex */
public final class s<T> extends a<T, T> implements g<T> {

    /* renamed from: f  reason: collision with root package name */
    final g<? super T> f15828f = this;

    /* compiled from: FlowableOnBackpressureDrop.java */
    /* loaded from: classes4.dex */
    static final class a<T> extends AtomicLong implements k<T>, c {

        /* renamed from: c  reason: collision with root package name */
        final b<? super T> f15829c;

        /* renamed from: d  reason: collision with root package name */
        final g<? super T> f15830d;

        /* renamed from: f  reason: collision with root package name */
        c f15831f;
        boolean q;

        a(b<? super T> bVar, g<? super T> gVar) {
            this.f15829c = bVar;
            this.f15830d = gVar;
        }

        @Override // e.b.c
        public void cancel() {
            this.f15831f.cancel();
        }

        @Override // e.b.b
        public void onComplete() {
            if (!this.q) {
                this.q = true;
                this.f15829c.onComplete();
            }
        }

        @Override // e.b.b
        public void onError(Throwable th) {
            if (this.q) {
                io.reactivex.j0.a.r(th);
                return;
            }
            this.q = true;
            this.f15829c.onError(th);
        }

        @Override // e.b.b
        public void onNext(T t) {
            if (!this.q) {
                if (get() != 0) {
                    this.f15829c.onNext(t);
                    io.reactivex.internal.util.b.c(this, 1L);
                    return;
                }
                try {
                    this.f15830d.accept(t);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    cancel();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.k, e.b.b
        public void onSubscribe(c cVar) {
            if (SubscriptionHelper.validate(this.f15831f, cVar)) {
                this.f15831f = cVar;
                this.f15829c.onSubscribe(this);
                cVar.request(Long.MAX_VALUE);
            }
        }

        @Override // e.b.c
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this, j);
            }
        }
    }

    public s(h<T> hVar) {
        super(hVar);
    }

    @Override // io.reactivex.h
    protected void H(b<? super T> bVar) {
        this.f15765d.G(new a(bVar, this.f15828f));
    }

    @Override // io.reactivex.g0.g
    public void accept(T t) {
    }
}

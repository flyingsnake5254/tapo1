package io.reactivex.internal.subscribers;

import e.b.c;
import io.reactivex.h0.b.f;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* compiled from: BasicFuseableConditionalSubscriber.java */
/* loaded from: classes4.dex */
public abstract class a<T, R> implements io.reactivex.h0.b.a<T>, f<R> {

    /* renamed from: c  reason: collision with root package name */
    protected final io.reactivex.h0.b.a<? super R> f16228c;

    /* renamed from: d  reason: collision with root package name */
    protected c f16229d;

    /* renamed from: f  reason: collision with root package name */
    protected f<T> f16230f;
    protected boolean q;
    protected int x;

    public a(io.reactivex.h0.b.a<? super R> aVar) {
        this.f16228c = aVar;
    }

    protected void a() {
    }

    protected boolean c() {
        return true;
    }

    @Override // e.b.c
    public void cancel() {
        this.f16229d.cancel();
    }

    @Override // io.reactivex.h0.b.i
    public void clear() {
        this.f16230f.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d(Throwable th) {
        io.reactivex.exceptions.a.b(th);
        this.f16229d.cancel();
        onError(th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int e(int i) {
        f<T> fVar = this.f16230f;
        if (fVar == null || (i & 4) != 0) {
            return 0;
        }
        int requestFusion = fVar.requestFusion(i);
        if (requestFusion != 0) {
            this.x = requestFusion;
        }
        return requestFusion;
    }

    @Override // io.reactivex.h0.b.i
    public boolean isEmpty() {
        return this.f16230f.isEmpty();
    }

    @Override // io.reactivex.h0.b.i
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // e.b.b
    public void onComplete() {
        if (!this.q) {
            this.q = true;
            this.f16228c.onComplete();
        }
    }

    @Override // e.b.b
    public void onError(Throwable th) {
        if (this.q) {
            io.reactivex.j0.a.r(th);
            return;
        }
        this.q = true;
        this.f16228c.onError(th);
    }

    @Override // io.reactivex.k, e.b.b
    public final void onSubscribe(c cVar) {
        if (SubscriptionHelper.validate(this.f16229d, cVar)) {
            this.f16229d = cVar;
            if (cVar instanceof f) {
                this.f16230f = (f) cVar;
            }
            if (c()) {
                this.f16228c.onSubscribe(this);
                a();
            }
        }
    }

    @Override // e.b.c
    public void request(long j) {
        this.f16229d.request(j);
    }
}

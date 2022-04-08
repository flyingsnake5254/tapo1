package io.reactivex.n0;

import e.b.b;
import e.b.c;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.k;

/* compiled from: SerializedSubscriber.java */
/* loaded from: classes4.dex */
public final class a<T> implements k<T>, c {

    /* renamed from: c  reason: collision with root package name */
    final b<? super T> f16293c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f16294d;

    /* renamed from: f  reason: collision with root package name */
    c f16295f;
    boolean q;
    io.reactivex.internal.util.a<Object> x;
    volatile boolean y;

    public a(b<? super T> bVar) {
        this(bVar, false);
    }

    void a() {
        io.reactivex.internal.util.a<Object> aVar;
        do {
            synchronized (this) {
                aVar = this.x;
                if (aVar == null) {
                    this.q = false;
                    return;
                }
                this.x = null;
            }
        } while (!aVar.b((b<? super T>) this.f16293c));
    }

    @Override // e.b.c
    public void cancel() {
        this.f16295f.cancel();
    }

    @Override // e.b.b
    public void onComplete() {
        if (!this.y) {
            synchronized (this) {
                if (!this.y) {
                    if (this.q) {
                        io.reactivex.internal.util.a<Object> aVar = this.x;
                        if (aVar == null) {
                            aVar = new io.reactivex.internal.util.a<>(4);
                            this.x = aVar;
                        }
                        aVar.c(NotificationLite.complete());
                        return;
                    }
                    this.y = true;
                    this.q = true;
                    this.f16293c.onComplete();
                }
            }
        }
    }

    @Override // e.b.b
    public void onError(Throwable th) {
        if (this.y) {
            io.reactivex.j0.a.r(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.y) {
                if (this.q) {
                    this.y = true;
                    io.reactivex.internal.util.a<Object> aVar = this.x;
                    if (aVar == null) {
                        aVar = new io.reactivex.internal.util.a<>(4);
                        this.x = aVar;
                    }
                    Object error = NotificationLite.error(th);
                    if (this.f16294d) {
                        aVar.c(error);
                    } else {
                        aVar.e(error);
                    }
                    return;
                }
                this.y = true;
                this.q = true;
                z = false;
            }
            if (z) {
                io.reactivex.j0.a.r(th);
            } else {
                this.f16293c.onError(th);
            }
        }
    }

    @Override // e.b.b
    public void onNext(T t) {
        if (!this.y) {
            if (t == null) {
                this.f16295f.cancel();
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            synchronized (this) {
                if (!this.y) {
                    if (this.q) {
                        io.reactivex.internal.util.a<Object> aVar = this.x;
                        if (aVar == null) {
                            aVar = new io.reactivex.internal.util.a<>(4);
                            this.x = aVar;
                        }
                        aVar.c(NotificationLite.next(t));
                        return;
                    }
                    this.q = true;
                    this.f16293c.onNext(t);
                    a();
                }
            }
        }
    }

    @Override // io.reactivex.k, e.b.b
    public void onSubscribe(c cVar) {
        if (SubscriptionHelper.validate(this.f16295f, cVar)) {
            this.f16295f = cVar;
            this.f16293c.onSubscribe(this);
        }
    }

    @Override // e.b.c
    public void request(long j) {
        this.f16295f.request(j);
    }

    public a(b<? super T> bVar, boolean z) {
        this.f16293c = bVar;
        this.f16294d = z;
    }
}

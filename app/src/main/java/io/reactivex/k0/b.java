package io.reactivex.k0;

import e.b.c;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.internal.util.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SerializedProcessor.java */
/* loaded from: classes4.dex */
public final class b<T> extends a<T> {

    /* renamed from: d  reason: collision with root package name */
    final a<T> f16249d;

    /* renamed from: f  reason: collision with root package name */
    boolean f16250f;
    a<Object> q;
    volatile boolean x;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a<T> aVar) {
        this.f16249d = aVar;
    }

    @Override // io.reactivex.h
    protected void H(e.b.b<? super T> bVar) {
        this.f16249d.a(bVar);
    }

    void N() {
        a<Object> aVar;
        while (true) {
            synchronized (this) {
                aVar = this.q;
                if (aVar == null) {
                    this.f16250f = false;
                    return;
                }
                this.q = null;
            }
            aVar.b(this.f16249d);
        }
    }

    @Override // e.b.b
    public void onComplete() {
        if (!this.x) {
            synchronized (this) {
                if (!this.x) {
                    this.x = true;
                    if (this.f16250f) {
                        a<Object> aVar = this.q;
                        if (aVar == null) {
                            aVar = new a<>(4);
                            this.q = aVar;
                        }
                        aVar.c(NotificationLite.complete());
                        return;
                    }
                    this.f16250f = true;
                    this.f16249d.onComplete();
                }
            }
        }
    }

    @Override // e.b.b
    public void onError(Throwable th) {
        if (this.x) {
            io.reactivex.j0.a.r(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.x) {
                this.x = true;
                if (this.f16250f) {
                    a<Object> aVar = this.q;
                    if (aVar == null) {
                        aVar = new a<>(4);
                        this.q = aVar;
                    }
                    aVar.e(NotificationLite.error(th));
                    return;
                }
                this.f16250f = true;
                z = false;
            }
            if (z) {
                io.reactivex.j0.a.r(th);
            } else {
                this.f16249d.onError(th);
            }
        }
    }

    @Override // e.b.b
    public void onNext(T t) {
        if (!this.x) {
            synchronized (this) {
                if (!this.x) {
                    if (this.f16250f) {
                        a<Object> aVar = this.q;
                        if (aVar == null) {
                            aVar = new a<>(4);
                            this.q = aVar;
                        }
                        aVar.c(NotificationLite.next(t));
                        return;
                    }
                    this.f16250f = true;
                    this.f16249d.onNext(t);
                    N();
                }
            }
        }
    }

    @Override // io.reactivex.k, e.b.b
    public void onSubscribe(c cVar) {
        boolean z = true;
        if (!this.x) {
            synchronized (this) {
                if (!this.x) {
                    if (this.f16250f) {
                        a<Object> aVar = this.q;
                        if (aVar == null) {
                            aVar = new a<>(4);
                            this.q = aVar;
                        }
                        aVar.c(NotificationLite.subscription(cVar));
                        return;
                    }
                    this.f16250f = true;
                    z = false;
                }
            }
        }
        if (z) {
            cVar.cancel();
            return;
        }
        this.f16249d.onSubscribe(cVar);
        N();
    }
}

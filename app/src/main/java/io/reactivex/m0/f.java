package io.reactivex.m0;

import io.reactivex.e0.c;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.internal.util.a;
import io.reactivex.v;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SerializedSubject.java */
/* loaded from: classes4.dex */
public final class f<T> extends g<T> implements a.AbstractC0315a<Object> {

    /* renamed from: c  reason: collision with root package name */
    final g<T> f16286c;

    /* renamed from: d  reason: collision with root package name */
    boolean f16287d;

    /* renamed from: f  reason: collision with root package name */
    a<Object> f16288f;
    volatile boolean q;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(g<T> gVar) {
        this.f16286c = gVar;
    }

    @Override // io.reactivex.q
    protected void K0(v<? super T> vVar) {
        this.f16286c.a(vVar);
    }

    @Override // io.reactivex.m0.g
    public boolean j1() {
        return this.f16286c.j1();
    }

    @Override // io.reactivex.m0.g
    public boolean k1() {
        return this.f16286c.k1();
    }

    void m1() {
        a<Object> aVar;
        while (true) {
            synchronized (this) {
                aVar = this.f16288f;
                if (aVar == null) {
                    this.f16287d = false;
                    return;
                }
                this.f16288f = null;
            }
            aVar.d(this);
        }
    }

    @Override // io.reactivex.v
    public void onComplete() {
        if (!this.q) {
            synchronized (this) {
                if (!this.q) {
                    this.q = true;
                    if (this.f16287d) {
                        a<Object> aVar = this.f16288f;
                        if (aVar == null) {
                            aVar = new a<>(4);
                            this.f16288f = aVar;
                        }
                        aVar.c(NotificationLite.complete());
                        return;
                    }
                    this.f16287d = true;
                    this.f16286c.onComplete();
                }
            }
        }
    }

    @Override // io.reactivex.v
    public void onError(Throwable th) {
        if (this.q) {
            io.reactivex.j0.a.r(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.q) {
                this.q = true;
                if (this.f16287d) {
                    a<Object> aVar = this.f16288f;
                    if (aVar == null) {
                        aVar = new a<>(4);
                        this.f16288f = aVar;
                    }
                    aVar.e(NotificationLite.error(th));
                    return;
                }
                this.f16287d = true;
                z = false;
            }
            if (z) {
                io.reactivex.j0.a.r(th);
            } else {
                this.f16286c.onError(th);
            }
        }
    }

    @Override // io.reactivex.v
    public void onNext(T t) {
        if (!this.q) {
            synchronized (this) {
                if (!this.q) {
                    if (this.f16287d) {
                        a<Object> aVar = this.f16288f;
                        if (aVar == null) {
                            aVar = new a<>(4);
                            this.f16288f = aVar;
                        }
                        aVar.c(NotificationLite.next(t));
                        return;
                    }
                    this.f16287d = true;
                    this.f16286c.onNext(t);
                    m1();
                }
            }
        }
    }

    @Override // io.reactivex.v
    public void onSubscribe(c cVar) {
        boolean z = true;
        if (!this.q) {
            synchronized (this) {
                if (!this.q) {
                    if (this.f16287d) {
                        a<Object> aVar = this.f16288f;
                        if (aVar == null) {
                            aVar = new a<>(4);
                            this.f16288f = aVar;
                        }
                        aVar.c(NotificationLite.disposable(cVar));
                        return;
                    }
                    this.f16287d = true;
                    z = false;
                }
            }
        }
        if (z) {
            cVar.dispose();
            return;
        }
        this.f16286c.onSubscribe(cVar);
        m1();
    }

    @Override // io.reactivex.internal.util.a.AbstractC0315a, io.reactivex.g0.l
    public boolean test(Object obj) {
        return NotificationLite.acceptFull(obj, this.f16286c);
    }
}

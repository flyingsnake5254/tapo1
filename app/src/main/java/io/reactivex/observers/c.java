package io.reactivex.observers;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.v;

/* compiled from: SafeObserver.java */
/* loaded from: classes4.dex */
public final class c<T> implements v<T>, io.reactivex.e0.c {

    /* renamed from: c  reason: collision with root package name */
    final v<? super T> f16297c;

    /* renamed from: d  reason: collision with root package name */
    io.reactivex.e0.c f16298d;

    /* renamed from: f  reason: collision with root package name */
    boolean f16299f;

    public c(v<? super T> vVar) {
        this.f16297c = vVar;
    }

    void a() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f16297c.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.f16297c.onError(nullPointerException);
            } catch (Throwable th) {
                a.b(th);
                io.reactivex.j0.a.r(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            a.b(th2);
            io.reactivex.j0.a.r(new CompositeException(nullPointerException, th2));
        }
    }

    void b() {
        this.f16299f = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f16297c.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.f16297c.onError(nullPointerException);
            } catch (Throwable th) {
                a.b(th);
                io.reactivex.j0.a.r(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            a.b(th2);
            io.reactivex.j0.a.r(new CompositeException(nullPointerException, th2));
        }
    }

    @Override // io.reactivex.e0.c
    public void dispose() {
        this.f16298d.dispose();
    }

    @Override // io.reactivex.e0.c
    public boolean isDisposed() {
        return this.f16298d.isDisposed();
    }

    @Override // io.reactivex.v
    public void onComplete() {
        if (!this.f16299f) {
            this.f16299f = true;
            if (this.f16298d == null) {
                a();
                return;
            }
            try {
                this.f16297c.onComplete();
            } catch (Throwable th) {
                a.b(th);
                io.reactivex.j0.a.r(th);
            }
        }
    }

    @Override // io.reactivex.v
    public void onError(Throwable th) {
        if (this.f16299f) {
            io.reactivex.j0.a.r(th);
            return;
        }
        this.f16299f = true;
        if (this.f16298d == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.f16297c.onSubscribe(EmptyDisposable.INSTANCE);
                try {
                    this.f16297c.onError(new CompositeException(th, nullPointerException));
                } catch (Throwable th2) {
                    a.b(th2);
                    io.reactivex.j0.a.r(new CompositeException(th, nullPointerException, th2));
                }
            } catch (Throwable th3) {
                a.b(th3);
                io.reactivex.j0.a.r(new CompositeException(th, nullPointerException, th3));
            }
        } else {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            try {
                this.f16297c.onError(th);
            } catch (Throwable th4) {
                a.b(th4);
                io.reactivex.j0.a.r(new CompositeException(th, th4));
            }
        }
    }

    @Override // io.reactivex.v
    public void onNext(T t) {
        if (!this.f16299f) {
            if (this.f16298d == null) {
                b();
            } else if (t == null) {
                NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
                try {
                    this.f16298d.dispose();
                    onError(nullPointerException);
                } catch (Throwable th) {
                    a.b(th);
                    onError(new CompositeException(nullPointerException, th));
                }
            } else {
                try {
                    this.f16297c.onNext(t);
                } catch (Throwable th2) {
                    a.b(th2);
                    try {
                        this.f16298d.dispose();
                        onError(th2);
                    } catch (Throwable th3) {
                        a.b(th3);
                        onError(new CompositeException(th2, th3));
                    }
                }
            }
        }
    }

    @Override // io.reactivex.v
    public void onSubscribe(io.reactivex.e0.c cVar) {
        if (DisposableHelper.validate(this.f16298d, cVar)) {
            this.f16298d = cVar;
            try {
                this.f16297c.onSubscribe(this);
            } catch (Throwable th) {
                a.b(th);
                this.f16299f = true;
                try {
                    cVar.dispose();
                    io.reactivex.j0.a.r(th);
                } catch (Throwable th2) {
                    a.b(th2);
                    io.reactivex.j0.a.r(new CompositeException(th, th2));
                }
            }
        }
    }
}

package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.queue.b;
import io.reactivex.t;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ObservableGroupBy.java */
/* loaded from: classes4.dex */
public final class c0<T, K> extends AtomicInteger implements c, t<T> {

    /* renamed from: c  reason: collision with root package name */
    final K f15913c;

    /* renamed from: d  reason: collision with root package name */
    final b<T> f15914d;

    /* renamed from: f  reason: collision with root package name */
    final ObservableGroupBy$GroupByObserver<?, K, T> f15915f;
    final boolean q;
    volatile boolean x;
    Throwable y;
    final AtomicBoolean z = new AtomicBoolean();
    final AtomicBoolean p0 = new AtomicBoolean();
    final AtomicReference<v<? super T>> p1 = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(int i, ObservableGroupBy$GroupByObserver<?, K, T> observableGroupBy$GroupByObserver, K k, boolean z) {
        this.f15914d = new b<>(i);
        this.f15915f = observableGroupBy$GroupByObserver;
        this.f15913c = k;
        this.q = z;
    }

    @Override // io.reactivex.t
    public void a(v<? super T> vVar) {
        if (this.p0.compareAndSet(false, true)) {
            vVar.onSubscribe(this);
            this.p1.lazySet(vVar);
            if (this.z.get()) {
                this.p1.lazySet(null);
            } else {
                d();
            }
        } else {
            EmptyDisposable.error(new IllegalStateException("Only one Observer allowed!"), vVar);
        }
    }

    boolean b(boolean z, boolean z2, v<? super T> vVar, boolean z3) {
        if (this.z.get()) {
            this.f15914d.clear();
            this.f15915f.cancel(this.f15913c);
            this.p1.lazySet(null);
            return true;
        } else if (!z) {
            return false;
        } else {
            if (!z3) {
                Throwable th = this.y;
                if (th != null) {
                    this.f15914d.clear();
                    this.p1.lazySet(null);
                    vVar.onError(th);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    this.p1.lazySet(null);
                    vVar.onComplete();
                    return true;
                }
            } else if (!z2) {
                return false;
            } else {
                Throwable th2 = this.y;
                this.p1.lazySet(null);
                if (th2 != null) {
                    vVar.onError(th2);
                } else {
                    vVar.onComplete();
                }
                return true;
            }
        }
    }

    void d() {
        if (getAndIncrement() == 0) {
            b<T> bVar = this.f15914d;
            boolean z = this.q;
            v<? super T> vVar = this.p1.get();
            int i = 1;
            while (true) {
                if (vVar != null) {
                    while (true) {
                        boolean z2 = this.x;
                        Object obj = (T) bVar.poll();
                        boolean z3 = obj == null;
                        if (!b(z2, z3, vVar, z)) {
                            if (z3) {
                                break;
                            }
                            vVar.onNext(obj);
                        } else {
                            return;
                        }
                    }
                }
                i = addAndGet(-i);
                if (i != 0) {
                    if (vVar == null) {
                        vVar = this.p1.get();
                    }
                } else {
                    return;
                }
            }
        }
    }

    @Override // io.reactivex.e0.c
    public void dispose() {
        if (this.z.compareAndSet(false, true) && getAndIncrement() == 0) {
            this.p1.lazySet(null);
            this.f15915f.cancel(this.f15913c);
        }
    }

    public void f() {
        this.x = true;
        d();
    }

    public void g(Throwable th) {
        this.y = th;
        this.x = true;
        d();
    }

    public void h(T t) {
        this.f15914d.offer(t);
        d();
    }

    @Override // io.reactivex.e0.c
    public boolean isDisposed() {
        return this.z.get();
    }
}

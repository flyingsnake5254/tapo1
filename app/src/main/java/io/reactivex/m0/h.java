package io.reactivex.m0;

import io.reactivex.e0.c;
import io.reactivex.h0.b.i;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.b;
import io.reactivex.q;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: UnicastSubject.java */
/* loaded from: classes4.dex */
public final class h<T> extends g<T> {

    /* renamed from: c  reason: collision with root package name */
    final b<T> f16289c;
    boolean p2;
    final boolean q;
    volatile boolean x;
    volatile boolean y;
    Throwable z;

    /* renamed from: f  reason: collision with root package name */
    final AtomicReference<Runnable> f16291f = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    final AtomicReference<v<? super T>> f16290d = new AtomicReference<>();
    final AtomicBoolean p0 = new AtomicBoolean();
    final BasicIntQueueDisposable<T> p1 = new a();

    /* compiled from: UnicastSubject.java */
    /* loaded from: classes4.dex */
    final class a extends BasicIntQueueDisposable<T> {
        a() {
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.h0.b.i
        public void clear() {
            h.this.f16289c.clear();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.e0.c
        public void dispose() {
            if (!h.this.x) {
                h.this.x = true;
                h.this.n1();
                h.this.f16290d.lazySet(null);
                if (h.this.p1.getAndIncrement() == 0) {
                    h.this.f16290d.lazySet(null);
                    h hVar = h.this;
                    if (!hVar.p2) {
                        hVar.f16289c.clear();
                    }
                }
            }
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.e0.c
        public boolean isDisposed() {
            return h.this.x;
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.h0.b.i
        public boolean isEmpty() {
            return h.this.f16289c.isEmpty();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.h0.b.i
        public T poll() throws Exception {
            return h.this.f16289c.poll();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.h0.b.e
        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            h.this.p2 = true;
            return 2;
        }
    }

    h(int i, boolean z) {
        this.f16289c = new b<>(io.reactivex.h0.a.b.f(i, "capacityHint"));
        this.q = z;
    }

    public static <T> h<T> m1() {
        return new h<>(q.d(), true);
    }

    @Override // io.reactivex.q
    protected void K0(v<? super T> vVar) {
        if (this.p0.get() || !this.p0.compareAndSet(false, true)) {
            EmptyDisposable.error(new IllegalStateException("Only a single observer allowed."), vVar);
            return;
        }
        vVar.onSubscribe(this.p1);
        this.f16290d.lazySet(vVar);
        if (this.x) {
            this.f16290d.lazySet(null);
        } else {
            o1();
        }
    }

    @Override // io.reactivex.m0.g
    public boolean j1() {
        return this.y && this.z == null;
    }

    @Override // io.reactivex.m0.g
    public boolean k1() {
        return this.y && this.z != null;
    }

    void n1() {
        Runnable runnable = this.f16291f.get();
        if (runnable != null && this.f16291f.compareAndSet(runnable, null)) {
            runnable.run();
        }
    }

    void o1() {
        if (this.p1.getAndIncrement() == 0) {
            v<? super T> vVar = this.f16290d.get();
            int i = 1;
            while (vVar == null) {
                i = this.p1.addAndGet(-i);
                if (i != 0) {
                    vVar = this.f16290d.get();
                } else {
                    return;
                }
            }
            if (this.p2) {
                p1(vVar);
            } else {
                q1(vVar);
            }
        }
    }

    @Override // io.reactivex.v
    public void onComplete() {
        if (!this.y && !this.x) {
            this.y = true;
            n1();
            o1();
        }
    }

    @Override // io.reactivex.v
    public void onError(Throwable th) {
        io.reactivex.h0.a.b.e(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.y || this.x) {
            io.reactivex.j0.a.r(th);
            return;
        }
        this.z = th;
        this.y = true;
        n1();
        o1();
    }

    @Override // io.reactivex.v
    public void onNext(T t) {
        io.reactivex.h0.a.b.e(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.y && !this.x) {
            this.f16289c.offer(t);
            o1();
        }
    }

    @Override // io.reactivex.v
    public void onSubscribe(c cVar) {
        if (this.y || this.x) {
            cVar.dispose();
        }
    }

    void p1(v<? super T> vVar) {
        b<T> bVar = this.f16289c;
        int i = 1;
        boolean z = !this.q;
        while (!this.x) {
            boolean z2 = this.y;
            if (!z || !z2 || !s1(bVar, vVar)) {
                vVar.onNext(null);
                if (z2) {
                    r1(vVar);
                    return;
                }
                i = this.p1.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                return;
            }
        }
        this.f16290d.lazySet(null);
    }

    void q1(v<? super T> vVar) {
        b<T> bVar = this.f16289c;
        boolean z = !this.q;
        boolean z2 = true;
        int i = 1;
        while (!this.x) {
            boolean z3 = this.y;
            Object obj = (T) this.f16289c.poll();
            boolean z4 = obj == null;
            if (z3) {
                if (z && z2) {
                    if (!s1(bVar, vVar)) {
                        z2 = false;
                    } else {
                        return;
                    }
                }
                if (z4) {
                    r1(vVar);
                    return;
                }
            }
            if (z4) {
                i = this.p1.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                vVar.onNext(obj);
            }
        }
        this.f16290d.lazySet(null);
        bVar.clear();
    }

    void r1(v<? super T> vVar) {
        this.f16290d.lazySet(null);
        Throwable th = this.z;
        if (th != null) {
            vVar.onError(th);
        } else {
            vVar.onComplete();
        }
    }

    boolean s1(i<T> iVar, v<? super T> vVar) {
        Throwable th = this.z;
        if (th == null) {
            return false;
        }
        this.f16290d.lazySet(null);
        iVar.clear();
        vVar.onError(th);
        return true;
    }
}

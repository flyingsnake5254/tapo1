package io.reactivex.k0;

import io.reactivex.internal.queue.b;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: UnicastProcessor.java */
/* loaded from: classes4.dex */
public final class c<T> extends a<T> {
    boolean H3;

    /* renamed from: d  reason: collision with root package name */
    final b<T> f16251d;

    /* renamed from: f  reason: collision with root package name */
    final AtomicReference<Runnable> f16252f;
    volatile boolean p0;
    final AtomicBoolean p1;
    final BasicIntQueueSubscription<T> p2;
    final AtomicLong p3;
    final boolean q;
    volatile boolean x;
    Throwable y;
    final AtomicReference<e.b.b<? super T>> z;

    /* compiled from: UnicastProcessor.java */
    /* loaded from: classes4.dex */
    final class a extends BasicIntQueueSubscription<T> {
        a() {
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, e.b.c
        public void cancel() {
            if (!c.this.p0) {
                c.this.p0 = true;
                c.this.P();
                c.this.z.lazySet(null);
                if (c.this.p2.getAndIncrement() == 0) {
                    c.this.z.lazySet(null);
                    c cVar = c.this;
                    if (!cVar.H3) {
                        cVar.f16251d.clear();
                    }
                }
            }
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, io.reactivex.h0.b.i
        public void clear() {
            c.this.f16251d.clear();
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, io.reactivex.h0.b.i
        public boolean isEmpty() {
            return c.this.f16251d.isEmpty();
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, io.reactivex.h0.b.i
        public T poll() {
            return c.this.f16251d.poll();
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, e.b.c
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(c.this.p3, j);
                c.this.Q();
            }
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, io.reactivex.h0.b.e
        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            c.this.H3 = true;
            return 2;
        }
    }

    c(int i) {
        this(i, null, true);
    }

    public static <T> c<T> O(int i) {
        return new c<>(i);
    }

    @Override // io.reactivex.h
    protected void H(e.b.b<? super T> bVar) {
        if (this.p1.get() || !this.p1.compareAndSet(false, true)) {
            EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), bVar);
            return;
        }
        bVar.onSubscribe(this.p2);
        this.z.set(bVar);
        if (this.p0) {
            this.z.lazySet(null);
        } else {
            Q();
        }
    }

    boolean N(boolean z, boolean z2, boolean z3, e.b.b<? super T> bVar, b<T> bVar2) {
        if (this.p0) {
            bVar2.clear();
            this.z.lazySet(null);
            return true;
        } else if (!z2) {
            return false;
        } else {
            if (z && this.y != null) {
                bVar2.clear();
                this.z.lazySet(null);
                bVar.onError(this.y);
                return true;
            } else if (!z3) {
                return false;
            } else {
                Throwable th = this.y;
                this.z.lazySet(null);
                if (th != null) {
                    bVar.onError(th);
                } else {
                    bVar.onComplete();
                }
                return true;
            }
        }
    }

    void P() {
        Runnable andSet = this.f16252f.getAndSet(null);
        if (andSet != null) {
            andSet.run();
        }
    }

    void Q() {
        if (this.p2.getAndIncrement() == 0) {
            int i = 1;
            e.b.b<? super T> bVar = this.z.get();
            while (bVar == null) {
                i = this.p2.addAndGet(-i);
                if (i != 0) {
                    bVar = this.z.get();
                } else {
                    return;
                }
            }
            if (this.H3) {
                R(bVar);
            } else {
                S(bVar);
            }
        }
    }

    void R(e.b.b<? super T> bVar) {
        b<T> bVar2 = this.f16251d;
        int i = 1;
        boolean z = !this.q;
        while (!this.p0) {
            boolean z2 = this.x;
            if (!z || !z2 || this.y == null) {
                bVar.onNext(null);
                if (z2) {
                    this.z.lazySet(null);
                    Throwable th = this.y;
                    if (th != null) {
                        bVar.onError(th);
                        return;
                    } else {
                        bVar.onComplete();
                        return;
                    }
                } else {
                    i = this.p2.addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            } else {
                bVar2.clear();
                this.z.lazySet(null);
                bVar.onError(this.y);
                return;
            }
        }
        this.z.lazySet(null);
    }

    void S(e.b.b<? super T> bVar) {
        int i;
        long j;
        b<T> bVar2 = this.f16251d;
        boolean z = !this.q;
        int i2 = 1;
        while (true) {
            long j2 = this.p3.get();
            long j3 = 0;
            while (true) {
                i = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                if (i == 0) {
                    j = j3;
                    break;
                }
                boolean z2 = this.x;
                T poll = bVar2.poll();
                boolean z3 = poll == null;
                j = j3;
                if (!N(z, z2, z3, bVar, bVar2)) {
                    if (z3) {
                        break;
                    }
                    bVar.onNext(poll);
                    j3 = 1 + j;
                } else {
                    return;
                }
            }
            if (i != 0 || !N(z, this.x, bVar2.isEmpty(), bVar, bVar2)) {
                if (!(j == 0 || j2 == Long.MAX_VALUE)) {
                    this.p3.addAndGet(-j);
                }
                i2 = this.p2.addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    @Override // e.b.b
    public void onComplete() {
        if (!this.x && !this.p0) {
            this.x = true;
            P();
            Q();
        }
    }

    @Override // e.b.b
    public void onError(Throwable th) {
        io.reactivex.h0.a.b.e(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.x || this.p0) {
            io.reactivex.j0.a.r(th);
            return;
        }
        this.y = th;
        this.x = true;
        P();
        Q();
    }

    @Override // e.b.b
    public void onNext(T t) {
        io.reactivex.h0.a.b.e(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.x && !this.p0) {
            this.f16251d.offer(t);
            Q();
        }
    }

    @Override // io.reactivex.k, e.b.b
    public void onSubscribe(e.b.c cVar) {
        if (this.x || this.p0) {
            cVar.cancel();
        } else {
            cVar.request(Long.MAX_VALUE);
        }
    }

    c(int i, Runnable runnable, boolean z) {
        this.f16251d = new b<>(io.reactivex.h0.a.b.f(i, "capacityHint"));
        this.f16252f = new AtomicReference<>(runnable);
        this.q = z;
        this.z = new AtomicReference<>();
        this.p1 = new AtomicBoolean();
        this.p2 = new a();
        this.p3 = new AtomicLong();
    }
}

package io.reactivex.internal.operators.flowable;

import e.b.b;
import e.b.c;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.k;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableOnBackpressureLatest.java */
/* loaded from: classes4.dex */
public final class u<T> extends a<T, T> {

    /* compiled from: FlowableOnBackpressureLatest.java */
    /* loaded from: classes4.dex */
    static final class a<T> extends AtomicInteger implements k<T>, c {

        /* renamed from: c  reason: collision with root package name */
        final b<? super T> f15835c;

        /* renamed from: d  reason: collision with root package name */
        c f15836d;

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f15837f;
        Throwable q;
        volatile boolean x;
        final AtomicLong y = new AtomicLong();
        final AtomicReference<T> z = new AtomicReference<>();

        a(b<? super T> bVar) {
            this.f15835c = bVar;
        }

        boolean a(boolean z, boolean z2, b<?> bVar, AtomicReference<T> atomicReference) {
            if (this.x) {
                atomicReference.lazySet(null);
                return true;
            } else if (!z) {
                return false;
            } else {
                Throwable th = this.q;
                if (th != null) {
                    atomicReference.lazySet(null);
                    bVar.onError(th);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    bVar.onComplete();
                    return true;
                }
            }
        }

        @Override // e.b.c
        public void cancel() {
            if (!this.x) {
                this.x = true;
                this.f15836d.cancel();
                if (getAndIncrement() == 0) {
                    this.z.lazySet(null);
                }
            }
        }

        void d() {
            boolean z;
            if (getAndIncrement() == 0) {
                b<? super T> bVar = this.f15835c;
                AtomicLong atomicLong = this.y;
                AtomicReference<T> atomicReference = this.z;
                int i = 1;
                do {
                    long j = 0;
                    while (true) {
                        z = false;
                        if (j == atomicLong.get()) {
                            break;
                        }
                        boolean z2 = this.f15837f;
                        Object obj = (T) atomicReference.getAndSet(null);
                        boolean z3 = obj == null;
                        if (!a(z2, z3, bVar, atomicReference)) {
                            if (z3) {
                                break;
                            }
                            bVar.onNext(obj);
                            j++;
                        } else {
                            return;
                        }
                    }
                    if (j == atomicLong.get()) {
                        boolean z4 = this.f15837f;
                        if (atomicReference.get() == null) {
                            z = true;
                        }
                        if (a(z4, z, bVar, atomicReference)) {
                            return;
                        }
                    }
                    if (j != 0) {
                        io.reactivex.internal.util.b.c(atomicLong, j);
                    }
                    i = addAndGet(-i);
                } while (i != 0);
            }
        }

        @Override // e.b.b
        public void onComplete() {
            this.f15837f = true;
            d();
        }

        @Override // e.b.b
        public void onError(Throwable th) {
            this.q = th;
            this.f15837f = true;
            d();
        }

        @Override // e.b.b
        public void onNext(T t) {
            this.z.lazySet(t);
            d();
        }

        @Override // io.reactivex.k, e.b.b
        public void onSubscribe(c cVar) {
            if (SubscriptionHelper.validate(this.f15836d, cVar)) {
                this.f15836d = cVar;
                this.f15835c.onSubscribe(this);
                cVar.request(Long.MAX_VALUE);
            }
        }

        @Override // e.b.c
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.y, j);
                d();
            }
        }
    }

    public u(h<T> hVar) {
        super(hVar);
    }

    @Override // io.reactivex.h
    protected void H(b<? super T> bVar) {
        this.f15765d.G(new a(bVar));
    }
}

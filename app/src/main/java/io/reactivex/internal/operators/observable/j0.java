package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.h0.b.d;
import io.reactivex.h0.b.i;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.b;
import io.reactivex.internal.schedulers.l;
import io.reactivex.t;
import io.reactivex.v;
import io.reactivex.w;

/* compiled from: ObservableObserveOn.java */
/* loaded from: classes4.dex */
public final class j0<T> extends a<T, T> {

    /* renamed from: d  reason: collision with root package name */
    final w f16011d;

    /* renamed from: f  reason: collision with root package name */
    final boolean f16012f;
    final int q;

    /* compiled from: ObservableObserveOn.java */
    /* loaded from: classes4.dex */
    static final class a<T> extends BasicIntQueueDisposable<T> implements v<T>, Runnable {

        /* renamed from: c  reason: collision with root package name */
        final v<? super T> f16013c;

        /* renamed from: d  reason: collision with root package name */
        final w.c f16014d;

        /* renamed from: f  reason: collision with root package name */
        final boolean f16015f;
        volatile boolean p0;
        volatile boolean p1;
        int p2;
        boolean p3;
        final int q;
        i<T> x;
        c y;
        Throwable z;

        a(v<? super T> vVar, w.c cVar, boolean z, int i) {
            this.f16013c = vVar;
            this.f16014d = cVar;
            this.f16015f = z;
            this.q = i;
        }

        boolean a(boolean z, boolean z2, v<? super T> vVar) {
            if (this.p1) {
                this.x.clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                Throwable th = this.z;
                if (this.f16015f) {
                    if (!z2) {
                        return false;
                    }
                    this.p1 = true;
                    if (th != null) {
                        vVar.onError(th);
                    } else {
                        vVar.onComplete();
                    }
                    this.f16014d.dispose();
                    return true;
                } else if (th != null) {
                    this.p1 = true;
                    this.x.clear();
                    vVar.onError(th);
                    this.f16014d.dispose();
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    this.p1 = true;
                    vVar.onComplete();
                    this.f16014d.dispose();
                    return true;
                }
            }
        }

        void b() {
            int i = 1;
            while (!this.p1) {
                boolean z = this.p0;
                Throwable th = this.z;
                if (this.f16015f || !z || th == null) {
                    this.f16013c.onNext(null);
                    if (z) {
                        this.p1 = true;
                        Throwable th2 = this.z;
                        if (th2 != null) {
                            this.f16013c.onError(th2);
                        } else {
                            this.f16013c.onComplete();
                        }
                        this.f16014d.dispose();
                        return;
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    this.p1 = true;
                    this.f16013c.onError(this.z);
                    this.f16014d.dispose();
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.h0.b.i
        public void clear() {
            this.x.clear();
        }

        void d() {
            i<T> iVar = this.x;
            v<? super T> vVar = this.f16013c;
            int i = 1;
            while (!a(this.p0, iVar.isEmpty(), vVar)) {
                while (true) {
                    boolean z = this.p0;
                    try {
                        Object obj = (T) iVar.poll();
                        boolean z2 = obj == null;
                        if (!a(z, z2, vVar)) {
                            if (z2) {
                                i = addAndGet(-i);
                                if (i == 0) {
                                    return;
                                }
                            } else {
                                vVar.onNext(obj);
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.p1 = true;
                        this.y.dispose();
                        iVar.clear();
                        vVar.onError(th);
                        this.f16014d.dispose();
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.e0.c
        public void dispose() {
            if (!this.p1) {
                this.p1 = true;
                this.y.dispose();
                this.f16014d.dispose();
                if (!this.p3 && getAndIncrement() == 0) {
                    this.x.clear();
                }
            }
        }

        void f() {
            if (getAndIncrement() == 0) {
                this.f16014d.b(this);
            }
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.e0.c
        public boolean isDisposed() {
            return this.p1;
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.h0.b.i
        public boolean isEmpty() {
            return this.x.isEmpty();
        }

        @Override // io.reactivex.v
        public void onComplete() {
            if (!this.p0) {
                this.p0 = true;
                f();
            }
        }

        @Override // io.reactivex.v
        public void onError(Throwable th) {
            if (this.p0) {
                io.reactivex.j0.a.r(th);
                return;
            }
            this.z = th;
            this.p0 = true;
            f();
        }

        @Override // io.reactivex.v
        public void onNext(T t) {
            if (!this.p0) {
                if (this.p2 != 2) {
                    this.x.offer(t);
                }
                f();
            }
        }

        @Override // io.reactivex.v
        public void onSubscribe(c cVar) {
            if (DisposableHelper.validate(this.y, cVar)) {
                this.y = cVar;
                if (cVar instanceof d) {
                    d dVar = (d) cVar;
                    int requestFusion = dVar.requestFusion(7);
                    if (requestFusion == 1) {
                        this.p2 = requestFusion;
                        this.x = dVar;
                        this.p0 = true;
                        this.f16013c.onSubscribe(this);
                        f();
                        return;
                    } else if (requestFusion == 2) {
                        this.p2 = requestFusion;
                        this.x = dVar;
                        this.f16013c.onSubscribe(this);
                        return;
                    }
                }
                this.x = new b(this.q);
                this.f16013c.onSubscribe(this);
            }
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.h0.b.i
        public T poll() throws Exception {
            return this.x.poll();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.h0.b.e
        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.p3 = true;
            return 2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.p3) {
                b();
            } else {
                d();
            }
        }
    }

    public j0(t<T> tVar, w wVar, boolean z, int i) {
        super(tVar);
        this.f16011d = wVar;
        this.f16012f = z;
        this.q = i;
    }

    @Override // io.reactivex.q
    protected void K0(v<? super T> vVar) {
        w wVar = this.f16011d;
        if (wVar instanceof l) {
            this.f15892c.a(vVar);
            return;
        }
        this.f15892c.a(new a(vVar, wVar.b(), this.f16012f, this.q));
    }
}

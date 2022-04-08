package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.g0.g;
import io.reactivex.h;

/* compiled from: FlowableDoOnEach.java */
/* loaded from: classes4.dex */
public final class e<T> extends a<T, T> {

    /* renamed from: f  reason: collision with root package name */
    final g<? super T> f15791f;
    final g<? super Throwable> q;
    final io.reactivex.g0.a x;
    final io.reactivex.g0.a y;

    /* compiled from: FlowableDoOnEach.java */
    /* loaded from: classes4.dex */
    static final class a<T> extends io.reactivex.internal.subscribers.a<T, T> {
        final io.reactivex.g0.a p0;
        final io.reactivex.g0.a p1;
        final g<? super T> y;
        final g<? super Throwable> z;

        a(io.reactivex.h0.b.a<? super T> aVar, g<? super T> gVar, g<? super Throwable> gVar2, io.reactivex.g0.a aVar2, io.reactivex.g0.a aVar3) {
            super(aVar);
            this.y = gVar;
            this.z = gVar2;
            this.p0 = aVar2;
            this.p1 = aVar3;
        }

        @Override // io.reactivex.h0.b.a
        public boolean b(T t) {
            if (this.q) {
                return false;
            }
            try {
                this.y.accept(t);
                return this.f16228c.b(t);
            } catch (Throwable th) {
                d(th);
                return false;
            }
        }

        @Override // io.reactivex.internal.subscribers.a, e.b.b
        public void onComplete() {
            if (!this.q) {
                try {
                    this.p0.run();
                    this.q = true;
                    this.f16228c.onComplete();
                    try {
                        this.p1.run();
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        io.reactivex.j0.a.r(th);
                    }
                } catch (Throwable th2) {
                    d(th2);
                }
            }
        }

        @Override // io.reactivex.internal.subscribers.a, e.b.b
        public void onError(Throwable th) {
            if (this.q) {
                io.reactivex.j0.a.r(th);
                return;
            }
            boolean z = true;
            this.q = true;
            try {
                this.z.accept(th);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f16228c.onError(new CompositeException(th, th2));
                z = false;
            }
            if (z) {
                this.f16228c.onError(th);
            }
            try {
                this.p1.run();
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                io.reactivex.j0.a.r(th3);
            }
        }

        @Override // e.b.b
        public void onNext(T t) {
            if (!this.q) {
                if (this.x != 0) {
                    this.f16228c.onNext(null);
                    return;
                }
                try {
                    this.y.accept(t);
                    this.f16228c.onNext(t);
                } catch (Throwable th) {
                    d(th);
                }
            }
        }

        @Override // io.reactivex.h0.b.i
        public T poll() throws Exception {
            try {
                T poll = this.f16230f.poll();
                if (poll != null) {
                    try {
                        this.y.accept(poll);
                    } catch (Throwable th) {
                        try {
                            io.reactivex.exceptions.a.b(th);
                            this.z.accept(th);
                            throw io.reactivex.internal.util.e.c(th);
                        } finally {
                            this.p1.run();
                        }
                    }
                } else if (this.x == 1) {
                    this.p0.run();
                }
                return poll;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                try {
                    this.z.accept(th2);
                    throw io.reactivex.internal.util.e.c(th2);
                } catch (Throwable th3) {
                    throw new CompositeException(th2, th3);
                }
            }
        }

        @Override // io.reactivex.h0.b.e
        public int requestFusion(int i) {
            return e(i);
        }
    }

    /* compiled from: FlowableDoOnEach.java */
    /* loaded from: classes4.dex */
    static final class b<T> extends io.reactivex.internal.subscribers.b<T, T> {
        final io.reactivex.g0.a p0;
        final io.reactivex.g0.a p1;
        final g<? super T> y;
        final g<? super Throwable> z;

        b(e.b.b<? super T> bVar, g<? super T> gVar, g<? super Throwable> gVar2, io.reactivex.g0.a aVar, io.reactivex.g0.a aVar2) {
            super(bVar);
            this.y = gVar;
            this.z = gVar2;
            this.p0 = aVar;
            this.p1 = aVar2;
        }

        @Override // io.reactivex.internal.subscribers.b, e.b.b
        public void onComplete() {
            if (!this.q) {
                try {
                    this.p0.run();
                    this.q = true;
                    this.f16231c.onComplete();
                    try {
                        this.p1.run();
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        io.reactivex.j0.a.r(th);
                    }
                } catch (Throwable th2) {
                    d(th2);
                }
            }
        }

        @Override // io.reactivex.internal.subscribers.b, e.b.b
        public void onError(Throwable th) {
            if (this.q) {
                io.reactivex.j0.a.r(th);
                return;
            }
            boolean z = true;
            this.q = true;
            try {
                this.z.accept(th);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f16231c.onError(new CompositeException(th, th2));
                z = false;
            }
            if (z) {
                this.f16231c.onError(th);
            }
            try {
                this.p1.run();
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                io.reactivex.j0.a.r(th3);
            }
        }

        @Override // e.b.b
        public void onNext(T t) {
            if (!this.q) {
                if (this.x != 0) {
                    this.f16231c.onNext(null);
                    return;
                }
                try {
                    this.y.accept(t);
                    this.f16231c.onNext(t);
                } catch (Throwable th) {
                    d(th);
                }
            }
        }

        @Override // io.reactivex.h0.b.i
        public T poll() throws Exception {
            try {
                T poll = this.f16233f.poll();
                if (poll != null) {
                    try {
                        this.y.accept(poll);
                    } catch (Throwable th) {
                        try {
                            io.reactivex.exceptions.a.b(th);
                            this.z.accept(th);
                            throw io.reactivex.internal.util.e.c(th);
                        } finally {
                            this.p1.run();
                        }
                    }
                } else if (this.x == 1) {
                    this.p0.run();
                }
                return poll;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                try {
                    this.z.accept(th2);
                    throw io.reactivex.internal.util.e.c(th2);
                } catch (Throwable th3) {
                    throw new CompositeException(th2, th3);
                }
            }
        }

        @Override // io.reactivex.h0.b.e
        public int requestFusion(int i) {
            return e(i);
        }
    }

    public e(h<T> hVar, g<? super T> gVar, g<? super Throwable> gVar2, io.reactivex.g0.a aVar, io.reactivex.g0.a aVar2) {
        super(hVar);
        this.f15791f = gVar;
        this.q = gVar2;
        this.x = aVar;
        this.y = aVar2;
    }

    @Override // io.reactivex.h
    protected void H(e.b.b<? super T> bVar) {
        if (bVar instanceof io.reactivex.h0.b.a) {
            this.f15765d.G(new a((io.reactivex.h0.b.a) bVar, this.f15791f, this.q, this.x, this.y));
        } else {
            this.f15765d.G(new b(bVar, this.f15791f, this.q, this.x, this.y));
        }
    }
}

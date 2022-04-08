package io.reactivex.internal.operators.flowable;

import io.reactivex.g0.l;
import io.reactivex.h;
import io.reactivex.h0.b.f;

/* compiled from: FlowableFilter.java */
/* loaded from: classes4.dex */
public final class i<T> extends a<T, T> {

    /* renamed from: f  reason: collision with root package name */
    final l<? super T> f15798f;

    /* compiled from: FlowableFilter.java */
    /* loaded from: classes4.dex */
    static final class a<T> extends io.reactivex.internal.subscribers.a<T, T> {
        final l<? super T> y;

        a(io.reactivex.h0.b.a<? super T> aVar, l<? super T> lVar) {
            super(aVar);
            this.y = lVar;
        }

        @Override // io.reactivex.h0.b.a
        public boolean b(T t) {
            if (this.q) {
                return false;
            }
            if (this.x != 0) {
                return this.f16228c.b(null);
            }
            try {
                return this.y.test(t) && this.f16228c.b(t);
            } catch (Throwable th) {
                d(th);
                return true;
            }
        }

        @Override // e.b.b
        public void onNext(T t) {
            if (!b(t)) {
                this.f16229d.request(1L);
            }
        }

        @Override // io.reactivex.h0.b.i
        public T poll() throws Exception {
            f<T> fVar = this.f16230f;
            l<? super T> lVar = this.y;
            while (true) {
                T poll = fVar.poll();
                if (poll == null) {
                    return null;
                }
                if (lVar.test(poll)) {
                    return poll;
                }
                if (this.x == 2) {
                    fVar.request(1L);
                }
            }
        }

        @Override // io.reactivex.h0.b.e
        public int requestFusion(int i) {
            return e(i);
        }
    }

    /* compiled from: FlowableFilter.java */
    /* loaded from: classes4.dex */
    static final class b<T> extends io.reactivex.internal.subscribers.b<T, T> implements io.reactivex.h0.b.a<T> {
        final l<? super T> y;

        b(e.b.b<? super T> bVar, l<? super T> lVar) {
            super(bVar);
            this.y = lVar;
        }

        @Override // io.reactivex.h0.b.a
        public boolean b(T t) {
            if (this.q) {
                return false;
            }
            if (this.x != 0) {
                this.f16231c.onNext(null);
                return true;
            }
            try {
                boolean test = this.y.test(t);
                if (test) {
                    this.f16231c.onNext(t);
                }
                return test;
            } catch (Throwable th) {
                d(th);
                return true;
            }
        }

        @Override // e.b.b
        public void onNext(T t) {
            if (!b(t)) {
                this.f16232d.request(1L);
            }
        }

        @Override // io.reactivex.h0.b.i
        public T poll() throws Exception {
            f<T> fVar = this.f16233f;
            l<? super T> lVar = this.y;
            while (true) {
                T poll = fVar.poll();
                if (poll == null) {
                    return null;
                }
                if (lVar.test(poll)) {
                    return poll;
                }
                if (this.x == 2) {
                    fVar.request(1L);
                }
            }
        }

        @Override // io.reactivex.h0.b.e
        public int requestFusion(int i) {
            return e(i);
        }
    }

    public i(h<T> hVar, l<? super T> lVar) {
        super(hVar);
        this.f15798f = lVar;
    }

    @Override // io.reactivex.h
    protected void H(e.b.b<? super T> bVar) {
        if (bVar instanceof io.reactivex.h0.b.a) {
            this.f15765d.G(new a((io.reactivex.h0.b.a) bVar, this.f15798f));
        } else {
            this.f15765d.G(new b(bVar, this.f15798f));
        }
    }
}

package io.reactivex.internal.operators.observable;

import io.reactivex.g0.d;
import io.reactivex.g0.j;
import io.reactivex.t;
import io.reactivex.v;

/* compiled from: ObservableDistinctUntilChanged.java */
/* loaded from: classes4.dex */
public final class i<T, K> extends a<T, T> {

    /* renamed from: d  reason: collision with root package name */
    final j<? super T, K> f16004d;

    /* renamed from: f  reason: collision with root package name */
    final d<? super K, ? super K> f16005f;

    /* compiled from: ObservableDistinctUntilChanged.java */
    /* loaded from: classes4.dex */
    static final class a<T, K> extends io.reactivex.internal.observers.a<T, T> {
        K p0;
        boolean p1;
        final j<? super T, K> y;
        final d<? super K, ? super K> z;

        a(v<? super T> vVar, j<? super T, K> jVar, d<? super K, ? super K> dVar) {
            super(vVar);
            this.y = jVar;
            this.z = dVar;
        }

        @Override // io.reactivex.v
        public void onNext(T t) {
            if (!this.q) {
                if (this.x != 0) {
                    this.f15749c.onNext(t);
                    return;
                }
                try {
                    K apply = this.y.apply(t);
                    if (this.p1) {
                        boolean a = this.z.a((K) this.p0, apply);
                        this.p0 = apply;
                        if (a) {
                            return;
                        }
                    } else {
                        this.p1 = true;
                        this.p0 = apply;
                    }
                    this.f15749c.onNext(t);
                } catch (Throwable th) {
                    c(th);
                }
            }
        }

        @Override // io.reactivex.h0.b.i
        public T poll() throws Exception {
            while (true) {
                T poll = this.f15751f.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.y.apply(poll);
                if (!this.p1) {
                    this.p1 = true;
                    this.p0 = apply;
                    return poll;
                } else if (!this.z.a((K) this.p0, apply)) {
                    this.p0 = apply;
                    return poll;
                } else {
                    this.p0 = apply;
                }
            }
        }

        @Override // io.reactivex.h0.b.e
        public int requestFusion(int i) {
            return d(i);
        }
    }

    public i(t<T> tVar, j<? super T, K> jVar, d<? super K, ? super K> dVar) {
        super(tVar);
        this.f16004d = jVar;
        this.f16005f = dVar;
    }

    @Override // io.reactivex.q
    protected void K0(v<? super T> vVar) {
        this.f15892c.a(new a(vVar, this.f16004d, this.f16005f));
    }
}

package io.reactivex.internal.operators.observable;

import io.reactivex.g0.l;
import io.reactivex.t;
import io.reactivex.v;

/* compiled from: ObservableFilter.java */
/* loaded from: classes4.dex */
public final class q<T> extends a<T, T> {

    /* renamed from: d  reason: collision with root package name */
    final l<? super T> f16063d;

    /* compiled from: ObservableFilter.java */
    /* loaded from: classes4.dex */
    static final class a<T> extends io.reactivex.internal.observers.a<T, T> {
        final l<? super T> y;

        a(v<? super T> vVar, l<? super T> lVar) {
            super(vVar);
            this.y = lVar;
        }

        @Override // io.reactivex.v
        public void onNext(T t) {
            if (this.x == 0) {
                try {
                    if (this.y.test(t)) {
                        this.f15749c.onNext(t);
                    }
                } catch (Throwable th) {
                    c(th);
                }
            } else {
                this.f15749c.onNext(null);
            }
        }

        @Override // io.reactivex.h0.b.i
        public T poll() throws Exception {
            T poll;
            do {
                poll = this.f15751f.poll();
                if (poll == null) {
                    break;
                }
            } while (!this.y.test(poll));
            return poll;
        }

        @Override // io.reactivex.h0.b.e
        public int requestFusion(int i) {
            return d(i);
        }
    }

    public q(t<T> tVar, l<? super T> lVar) {
        super(tVar);
        this.f16063d = lVar;
    }

    @Override // io.reactivex.q
    public void K0(v<? super T> vVar) {
        this.f15892c.a(new a(vVar, this.f16063d));
    }
}

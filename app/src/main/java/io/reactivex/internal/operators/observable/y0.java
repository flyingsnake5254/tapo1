package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.t;
import io.reactivex.v;

/* compiled from: ObservableTake.java */
/* loaded from: classes4.dex */
public final class y0<T> extends a<T, T> {

    /* renamed from: d  reason: collision with root package name */
    final long f16144d;

    /* compiled from: ObservableTake.java */
    /* loaded from: classes4.dex */
    static final class a<T> implements v<T>, c {

        /* renamed from: c  reason: collision with root package name */
        final v<? super T> f16145c;

        /* renamed from: d  reason: collision with root package name */
        boolean f16146d;

        /* renamed from: f  reason: collision with root package name */
        c f16147f;
        long q;

        a(v<? super T> vVar, long j) {
            this.f16145c = vVar;
            this.q = j;
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            this.f16147f.dispose();
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.f16147f.isDisposed();
        }

        @Override // io.reactivex.v
        public void onComplete() {
            if (!this.f16146d) {
                this.f16146d = true;
                this.f16147f.dispose();
                this.f16145c.onComplete();
            }
        }

        @Override // io.reactivex.v
        public void onError(Throwable th) {
            if (this.f16146d) {
                io.reactivex.j0.a.r(th);
                return;
            }
            this.f16146d = true;
            this.f16147f.dispose();
            this.f16145c.onError(th);
        }

        @Override // io.reactivex.v
        public void onNext(T t) {
            if (!this.f16146d) {
                long j = this.q;
                long j2 = j - 1;
                this.q = j2;
                if (j > 0) {
                    boolean z = j2 == 0;
                    this.f16145c.onNext(t);
                    if (z) {
                        onComplete();
                    }
                }
            }
        }

        @Override // io.reactivex.v
        public void onSubscribe(c cVar) {
            if (DisposableHelper.validate(this.f16147f, cVar)) {
                this.f16147f = cVar;
                if (this.q == 0) {
                    this.f16146d = true;
                    cVar.dispose();
                    EmptyDisposable.complete(this.f16145c);
                    return;
                }
                this.f16145c.onSubscribe(this);
            }
        }
    }

    public y0(t<T> tVar, long j) {
        super(tVar);
        this.f16144d = j;
    }

    @Override // io.reactivex.q
    protected void K0(v<? super T> vVar) {
        this.f15892c.a(new a(vVar, this.f16144d));
    }
}

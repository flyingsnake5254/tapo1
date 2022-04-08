package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;
import io.reactivex.v;
import io.reactivex.x;
import io.reactivex.z;
import java.util.NoSuchElementException;

/* compiled from: ObservableSingleSingle.java */
/* loaded from: classes4.dex */
public final class t0<T> extends x<T> {

    /* renamed from: c  reason: collision with root package name */
    final t<? extends T> f16099c;

    /* renamed from: d  reason: collision with root package name */
    final T f16100d;

    /* compiled from: ObservableSingleSingle.java */
    /* loaded from: classes4.dex */
    static final class a<T> implements v<T>, c {

        /* renamed from: c  reason: collision with root package name */
        final z<? super T> f16101c;

        /* renamed from: d  reason: collision with root package name */
        final T f16102d;

        /* renamed from: f  reason: collision with root package name */
        c f16103f;
        T q;
        boolean x;

        a(z<? super T> zVar, T t) {
            this.f16101c = zVar;
            this.f16102d = t;
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            this.f16103f.dispose();
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.f16103f.isDisposed();
        }

        @Override // io.reactivex.v
        public void onComplete() {
            if (!this.x) {
                this.x = true;
                T t = this.q;
                this.q = null;
                if (t == null) {
                    t = this.f16102d;
                }
                if (t != null) {
                    this.f16101c.onSuccess(t);
                } else {
                    this.f16101c.onError(new NoSuchElementException());
                }
            }
        }

        @Override // io.reactivex.v
        public void onError(Throwable th) {
            if (this.x) {
                io.reactivex.j0.a.r(th);
                return;
            }
            this.x = true;
            this.f16101c.onError(th);
        }

        @Override // io.reactivex.v
        public void onNext(T t) {
            if (!this.x) {
                if (this.q != null) {
                    this.x = true;
                    this.f16103f.dispose();
                    this.f16101c.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.q = t;
            }
        }

        @Override // io.reactivex.v
        public void onSubscribe(c cVar) {
            if (DisposableHelper.validate(this.f16103f, cVar)) {
                this.f16103f = cVar;
                this.f16101c.onSubscribe(this);
            }
        }
    }

    public t0(t<? extends T> tVar, T t) {
        this.f16099c = tVar;
        this.f16100d = t;
    }

    @Override // io.reactivex.x
    public void l(z<? super T> zVar) {
        this.f16099c.a(new a(zVar, this.f16100d));
    }
}

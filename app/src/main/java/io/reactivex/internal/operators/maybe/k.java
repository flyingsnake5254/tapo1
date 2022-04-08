package io.reactivex.internal.operators.maybe;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.n;
import io.reactivex.o;
import io.reactivex.x;
import io.reactivex.z;
import java.util.NoSuchElementException;

/* compiled from: MaybeToSingle.java */
/* loaded from: classes4.dex */
public final class k<T> extends x<T> {

    /* renamed from: c  reason: collision with root package name */
    final o<T> f15885c;

    /* renamed from: d  reason: collision with root package name */
    final T f15886d;

    /* compiled from: MaybeToSingle.java */
    /* loaded from: classes4.dex */
    static final class a<T> implements n<T>, c {

        /* renamed from: c  reason: collision with root package name */
        final z<? super T> f15887c;

        /* renamed from: d  reason: collision with root package name */
        final T f15888d;

        /* renamed from: f  reason: collision with root package name */
        c f15889f;

        a(z<? super T> zVar, T t) {
            this.f15887c = zVar;
            this.f15888d = t;
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            this.f15889f.dispose();
            this.f15889f = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.f15889f.isDisposed();
        }

        @Override // io.reactivex.n
        public void onComplete() {
            this.f15889f = DisposableHelper.DISPOSED;
            T t = this.f15888d;
            if (t != null) {
                this.f15887c.onSuccess(t);
            } else {
                this.f15887c.onError(new NoSuchElementException("The MaybeSource is empty"));
            }
        }

        @Override // io.reactivex.n
        public void onError(Throwable th) {
            this.f15889f = DisposableHelper.DISPOSED;
            this.f15887c.onError(th);
        }

        @Override // io.reactivex.n
        public void onSubscribe(c cVar) {
            if (DisposableHelper.validate(this.f15889f, cVar)) {
                this.f15889f = cVar;
                this.f15887c.onSubscribe(this);
            }
        }

        @Override // io.reactivex.n
        public void onSuccess(T t) {
            this.f15889f = DisposableHelper.DISPOSED;
            this.f15887c.onSuccess(t);
        }
    }

    public k(o<T> oVar, T t) {
        this.f15885c = oVar;
        this.f15886d = t;
    }

    @Override // io.reactivex.x
    protected void l(z<? super T> zVar) {
        this.f15885c.a(new a(zVar, this.f15886d));
    }
}

package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;
import io.reactivex.v;
import java.util.NoSuchElementException;

/* compiled from: ObservableElementAt.java */
/* loaded from: classes4.dex */
public final class m<T> extends a<T, T> {

    /* renamed from: d  reason: collision with root package name */
    final long f16032d;

    /* renamed from: f  reason: collision with root package name */
    final T f16033f;
    final boolean q;

    /* compiled from: ObservableElementAt.java */
    /* loaded from: classes4.dex */
    static final class a<T> implements v<T>, c {

        /* renamed from: c  reason: collision with root package name */
        final v<? super T> f16034c;

        /* renamed from: d  reason: collision with root package name */
        final long f16035d;

        /* renamed from: f  reason: collision with root package name */
        final T f16036f;
        final boolean q;
        c x;
        long y;
        boolean z;

        a(v<? super T> vVar, long j, T t, boolean z) {
            this.f16034c = vVar;
            this.f16035d = j;
            this.f16036f = t;
            this.q = z;
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            this.x.dispose();
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.x.isDisposed();
        }

        @Override // io.reactivex.v
        public void onComplete() {
            if (!this.z) {
                this.z = true;
                T t = this.f16036f;
                if (t != null || !this.q) {
                    if (t != null) {
                        this.f16034c.onNext(t);
                    }
                    this.f16034c.onComplete();
                    return;
                }
                this.f16034c.onError(new NoSuchElementException());
            }
        }

        @Override // io.reactivex.v
        public void onError(Throwable th) {
            if (this.z) {
                io.reactivex.j0.a.r(th);
                return;
            }
            this.z = true;
            this.f16034c.onError(th);
        }

        @Override // io.reactivex.v
        public void onNext(T t) {
            if (!this.z) {
                long j = this.y;
                if (j == this.f16035d) {
                    this.z = true;
                    this.x.dispose();
                    this.f16034c.onNext(t);
                    this.f16034c.onComplete();
                    return;
                }
                this.y = j + 1;
            }
        }

        @Override // io.reactivex.v
        public void onSubscribe(c cVar) {
            if (DisposableHelper.validate(this.x, cVar)) {
                this.x = cVar;
                this.f16034c.onSubscribe(this);
            }
        }
    }

    public m(t<T> tVar, long j, T t, boolean z) {
        super(tVar);
        this.f16032d = j;
        this.f16033f = t;
        this.q = z;
    }

    @Override // io.reactivex.q
    public void K0(v<? super T> vVar) {
        this.f15892c.a(new a(vVar, this.f16032d, this.f16033f, this.q));
    }
}

package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.g0.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;
import io.reactivex.v;

/* compiled from: ObservableDoOnEach.java */
/* loaded from: classes4.dex */
public final class k<T> extends a<T, T> {

    /* renamed from: d  reason: collision with root package name */
    final g<? super T> f16016d;

    /* renamed from: f  reason: collision with root package name */
    final g<? super Throwable> f16017f;
    final io.reactivex.g0.a q;
    final io.reactivex.g0.a x;

    /* compiled from: ObservableDoOnEach.java */
    /* loaded from: classes4.dex */
    static final class a<T> implements v<T>, c {

        /* renamed from: c  reason: collision with root package name */
        final v<? super T> f16018c;

        /* renamed from: d  reason: collision with root package name */
        final g<? super T> f16019d;

        /* renamed from: f  reason: collision with root package name */
        final g<? super Throwable> f16020f;
        final io.reactivex.g0.a q;
        final io.reactivex.g0.a x;
        c y;
        boolean z;

        a(v<? super T> vVar, g<? super T> gVar, g<? super Throwable> gVar2, io.reactivex.g0.a aVar, io.reactivex.g0.a aVar2) {
            this.f16018c = vVar;
            this.f16019d = gVar;
            this.f16020f = gVar2;
            this.q = aVar;
            this.x = aVar2;
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            this.y.dispose();
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.y.isDisposed();
        }

        @Override // io.reactivex.v
        public void onComplete() {
            if (!this.z) {
                try {
                    this.q.run();
                    this.z = true;
                    this.f16018c.onComplete();
                    try {
                        this.x.run();
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        io.reactivex.j0.a.r(th);
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    onError(th2);
                }
            }
        }

        @Override // io.reactivex.v
        public void onError(Throwable th) {
            if (this.z) {
                io.reactivex.j0.a.r(th);
                return;
            }
            this.z = true;
            try {
                this.f16020f.accept(th);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                th = new CompositeException(th, th2);
            }
            this.f16018c.onError(th);
            try {
                this.x.run();
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                io.reactivex.j0.a.r(th3);
            }
        }

        @Override // io.reactivex.v
        public void onNext(T t) {
            if (!this.z) {
                try {
                    this.f16019d.accept(t);
                    this.f16018c.onNext(t);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.y.dispose();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.v
        public void onSubscribe(c cVar) {
            if (DisposableHelper.validate(this.y, cVar)) {
                this.y = cVar;
                this.f16018c.onSubscribe(this);
            }
        }
    }

    public k(t<T> tVar, g<? super T> gVar, g<? super Throwable> gVar2, io.reactivex.g0.a aVar, io.reactivex.g0.a aVar2) {
        super(tVar);
        this.f16016d = gVar;
        this.f16017f = gVar2;
        this.q = aVar;
        this.x = aVar2;
    }

    @Override // io.reactivex.q
    public void K0(v<? super T> vVar) {
        this.f15892c.a(new a(vVar, this.f16016d, this.f16017f, this.q, this.x));
    }
}

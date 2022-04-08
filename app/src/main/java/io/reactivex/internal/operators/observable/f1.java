package io.reactivex.internal.operators.observable;

import io.reactivex.h0.a.b;
import io.reactivex.h0.b.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.v;
import io.reactivex.x;
import io.reactivex.z;
import java.util.Collection;
import java.util.concurrent.Callable;

/* compiled from: ObservableToListSingle.java */
/* loaded from: classes4.dex */
public final class f1<T, U extends Collection<? super T>> extends x<U> implements c<U> {

    /* renamed from: c  reason: collision with root package name */
    final t<T> f15970c;

    /* renamed from: d  reason: collision with root package name */
    final Callable<U> f15971d;

    /* compiled from: ObservableToListSingle.java */
    /* loaded from: classes4.dex */
    static final class a<T, U extends Collection<? super T>> implements v<T>, io.reactivex.e0.c {

        /* renamed from: c  reason: collision with root package name */
        final z<? super U> f15972c;

        /* renamed from: d  reason: collision with root package name */
        U f15973d;

        /* renamed from: f  reason: collision with root package name */
        io.reactivex.e0.c f15974f;

        a(z<? super U> zVar, U u) {
            this.f15972c = zVar;
            this.f15973d = u;
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            this.f15974f.dispose();
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.f15974f.isDisposed();
        }

        @Override // io.reactivex.v
        public void onComplete() {
            U u = this.f15973d;
            this.f15973d = null;
            this.f15972c.onSuccess(u);
        }

        @Override // io.reactivex.v
        public void onError(Throwable th) {
            this.f15973d = null;
            this.f15972c.onError(th);
        }

        @Override // io.reactivex.v
        public void onNext(T t) {
            this.f15973d.add(t);
        }

        @Override // io.reactivex.v
        public void onSubscribe(io.reactivex.e0.c cVar) {
            if (DisposableHelper.validate(this.f15974f, cVar)) {
                this.f15974f = cVar;
                this.f15972c.onSubscribe(this);
            }
        }
    }

    public f1(t<T> tVar, int i) {
        this.f15970c = tVar;
        this.f15971d = io.reactivex.h0.a.a.d(i);
    }

    @Override // io.reactivex.h0.b.c
    public q<U> b() {
        return io.reactivex.j0.a.n(new e1(this.f15970c, this.f15971d));
    }

    @Override // io.reactivex.x
    public void l(z<? super U> zVar) {
        try {
            this.f15970c.a(new a(zVar, (Collection) b.e(this.f15971d.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            EmptyDisposable.error(th, zVar);
        }
    }
}

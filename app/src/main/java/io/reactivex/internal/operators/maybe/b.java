package io.reactivex.internal.operators.maybe;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.n;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: MaybeDoFinally.java */
/* loaded from: classes4.dex */
public final class b<T> extends a<T, T> {

    /* renamed from: d  reason: collision with root package name */
    final io.reactivex.g0.a f15854d;

    /* compiled from: MaybeDoFinally.java */
    /* loaded from: classes4.dex */
    static final class a<T> extends AtomicInteger implements n<T>, c {

        /* renamed from: c  reason: collision with root package name */
        final n<? super T> f15855c;

        /* renamed from: d  reason: collision with root package name */
        final io.reactivex.g0.a f15856d;

        /* renamed from: f  reason: collision with root package name */
        c f15857f;

        a(n<? super T> nVar, io.reactivex.g0.a aVar) {
            this.f15855c = nVar;
            this.f15856d = aVar;
        }

        void a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f15856d.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    io.reactivex.j0.a.r(th);
                }
            }
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            this.f15857f.dispose();
            a();
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.f15857f.isDisposed();
        }

        @Override // io.reactivex.n
        public void onComplete() {
            this.f15855c.onComplete();
            a();
        }

        @Override // io.reactivex.n
        public void onError(Throwable th) {
            this.f15855c.onError(th);
            a();
        }

        @Override // io.reactivex.n
        public void onSubscribe(c cVar) {
            if (DisposableHelper.validate(this.f15857f, cVar)) {
                this.f15857f = cVar;
                this.f15855c.onSubscribe(this);
            }
        }

        @Override // io.reactivex.n
        public void onSuccess(T t) {
            this.f15855c.onSuccess(t);
            a();
        }
    }

    public b(o<T> oVar, io.reactivex.g0.a aVar) {
        super(oVar);
        this.f15854d = aVar;
    }

    @Override // io.reactivex.m
    protected void n(n<? super T> nVar) {
        this.f15853c.a(new a(nVar, this.f15854d));
    }
}

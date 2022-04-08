package io.reactivex.internal.operators.maybe;

import io.reactivex.e0.c;
import io.reactivex.g0.l;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.n;
import io.reactivex.o;

/* compiled from: MaybeFilter.java */
/* loaded from: classes4.dex */
public final class d<T> extends a<T, T> {

    /* renamed from: d  reason: collision with root package name */
    final l<? super T> f15859d;

    /* compiled from: MaybeFilter.java */
    /* loaded from: classes4.dex */
    static final class a<T> implements n<T>, c {

        /* renamed from: c  reason: collision with root package name */
        final n<? super T> f15860c;

        /* renamed from: d  reason: collision with root package name */
        final l<? super T> f15861d;

        /* renamed from: f  reason: collision with root package name */
        c f15862f;

        a(n<? super T> nVar, l<? super T> lVar) {
            this.f15860c = nVar;
            this.f15861d = lVar;
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            c cVar = this.f15862f;
            this.f15862f = DisposableHelper.DISPOSED;
            cVar.dispose();
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.f15862f.isDisposed();
        }

        @Override // io.reactivex.n
        public void onComplete() {
            this.f15860c.onComplete();
        }

        @Override // io.reactivex.n
        public void onError(Throwable th) {
            this.f15860c.onError(th);
        }

        @Override // io.reactivex.n
        public void onSubscribe(c cVar) {
            if (DisposableHelper.validate(this.f15862f, cVar)) {
                this.f15862f = cVar;
                this.f15860c.onSubscribe(this);
            }
        }

        @Override // io.reactivex.n
        public void onSuccess(T t) {
            try {
                if (this.f15861d.test(t)) {
                    this.f15860c.onSuccess(t);
                } else {
                    this.f15860c.onComplete();
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f15860c.onError(th);
            }
        }
    }

    public d(o<T> oVar, l<? super T> lVar) {
        super(oVar);
        this.f15859d = lVar;
    }

    @Override // io.reactivex.m
    protected void n(n<? super T> nVar) {
        this.f15853c.a(new a(nVar, this.f15859d));
    }
}

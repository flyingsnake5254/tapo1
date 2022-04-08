package io.reactivex.internal.operators.maybe;

import io.reactivex.e0.c;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.g0.j;
import io.reactivex.h0.a.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.n;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MaybeOnErrorNext.java */
/* loaded from: classes4.dex */
public final class g<T> extends a<T, T> {

    /* renamed from: d  reason: collision with root package name */
    final j<? super Throwable, ? extends o<? extends T>> f15869d;

    /* renamed from: f  reason: collision with root package name */
    final boolean f15870f;

    /* compiled from: MaybeOnErrorNext.java */
    /* loaded from: classes4.dex */
    static final class a<T> extends AtomicReference<c> implements n<T>, c {

        /* renamed from: c  reason: collision with root package name */
        final n<? super T> f15871c;

        /* renamed from: d  reason: collision with root package name */
        final j<? super Throwable, ? extends o<? extends T>> f15872d;

        /* renamed from: f  reason: collision with root package name */
        final boolean f15873f;

        /* compiled from: MaybeOnErrorNext.java */
        /* renamed from: io.reactivex.internal.operators.maybe.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        static final class C0301a<T> implements n<T> {

            /* renamed from: c  reason: collision with root package name */
            final n<? super T> f15874c;

            /* renamed from: d  reason: collision with root package name */
            final AtomicReference<c> f15875d;

            C0301a(n<? super T> nVar, AtomicReference<c> atomicReference) {
                this.f15874c = nVar;
                this.f15875d = atomicReference;
            }

            @Override // io.reactivex.n
            public void onComplete() {
                this.f15874c.onComplete();
            }

            @Override // io.reactivex.n
            public void onError(Throwable th) {
                this.f15874c.onError(th);
            }

            @Override // io.reactivex.n
            public void onSubscribe(c cVar) {
                DisposableHelper.setOnce(this.f15875d, cVar);
            }

            @Override // io.reactivex.n
            public void onSuccess(T t) {
                this.f15874c.onSuccess(t);
            }
        }

        a(n<? super T> nVar, j<? super Throwable, ? extends o<? extends T>> jVar, boolean z) {
            this.f15871c = nVar;
            this.f15872d = jVar;
            this.f15873f = z;
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.n
        public void onComplete() {
            this.f15871c.onComplete();
        }

        @Override // io.reactivex.n
        public void onError(Throwable th) {
            if (this.f15873f || (th instanceof Exception)) {
                try {
                    o oVar = (o) b.e(this.f15872d.apply(th), "The resumeFunction returned a null MaybeSource");
                    DisposableHelper.replace(this, null);
                    oVar.a(new C0301a(this.f15871c, this));
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.f15871c.onError(new CompositeException(th, th2));
                }
            } else {
                this.f15871c.onError(th);
            }
        }

        @Override // io.reactivex.n
        public void onSubscribe(c cVar) {
            if (DisposableHelper.setOnce(this, cVar)) {
                this.f15871c.onSubscribe(this);
            }
        }

        @Override // io.reactivex.n
        public void onSuccess(T t) {
            this.f15871c.onSuccess(t);
        }
    }

    public g(o<T> oVar, j<? super Throwable, ? extends o<? extends T>> jVar, boolean z) {
        super(oVar);
        this.f15869d = jVar;
        this.f15870f = z;
    }

    @Override // io.reactivex.m
    protected void n(n<? super T> nVar) {
        this.f15853c.a(new a(nVar, this.f15869d, this.f15870f));
    }
}

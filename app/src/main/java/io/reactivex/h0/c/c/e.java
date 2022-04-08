package io.reactivex.h0.c.c;

import io.reactivex.b0;
import io.reactivex.e0.c;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.g0.j;
import io.reactivex.h0.a.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.x;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleResumeNext.java */
/* loaded from: classes4.dex */
public final class e<T> extends x<T> {

    /* renamed from: c  reason: collision with root package name */
    final b0<? extends T> f15735c;

    /* renamed from: d  reason: collision with root package name */
    final j<? super Throwable, ? extends b0<? extends T>> f15736d;

    /* compiled from: SingleResumeNext.java */
    /* loaded from: classes4.dex */
    static final class a<T> extends AtomicReference<c> implements z<T>, c {

        /* renamed from: c  reason: collision with root package name */
        final z<? super T> f15737c;

        /* renamed from: d  reason: collision with root package name */
        final j<? super Throwable, ? extends b0<? extends T>> f15738d;

        a(z<? super T> zVar, j<? super Throwable, ? extends b0<? extends T>> jVar) {
            this.f15737c = zVar;
            this.f15738d = jVar;
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.z
        public void onError(Throwable th) {
            try {
                ((b0) b.e(this.f15738d.apply(th), "The nextFunction returned a null SingleSource.")).a(new io.reactivex.internal.observers.j(this, this.f15737c));
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f15737c.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.z
        public void onSubscribe(c cVar) {
            if (DisposableHelper.setOnce(this, cVar)) {
                this.f15737c.onSubscribe(this);
            }
        }

        @Override // io.reactivex.z
        public void onSuccess(T t) {
            this.f15737c.onSuccess(t);
        }
    }

    public e(b0<? extends T> b0Var, j<? super Throwable, ? extends b0<? extends T>> jVar) {
        this.f15735c = b0Var;
        this.f15736d = jVar;
    }

    @Override // io.reactivex.x
    protected void l(z<? super T> zVar) {
        this.f15735c.a(new a(zVar, this.f15736d));
    }
}

package io.reactivex.h0.c.c;

import io.reactivex.b0;
import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.w;
import io.reactivex.x;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleSubscribeOn.java */
/* loaded from: classes4.dex */
public final class f<T> extends x<T> {

    /* renamed from: c  reason: collision with root package name */
    final b0<? extends T> f15739c;

    /* renamed from: d  reason: collision with root package name */
    final w f15740d;

    /* compiled from: SingleSubscribeOn.java */
    /* loaded from: classes4.dex */
    static final class a<T> extends AtomicReference<c> implements z<T>, c, Runnable {

        /* renamed from: c  reason: collision with root package name */
        final z<? super T> f15741c;

        /* renamed from: d  reason: collision with root package name */
        final SequentialDisposable f15742d = new SequentialDisposable();

        /* renamed from: f  reason: collision with root package name */
        final b0<? extends T> f15743f;

        a(z<? super T> zVar, b0<? extends T> b0Var) {
            this.f15741c = zVar;
            this.f15743f = b0Var;
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            DisposableHelper.dispose(this);
            this.f15742d.dispose();
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.z
        public void onError(Throwable th) {
            this.f15741c.onError(th);
        }

        @Override // io.reactivex.z
        public void onSubscribe(c cVar) {
            DisposableHelper.setOnce(this, cVar);
        }

        @Override // io.reactivex.z
        public void onSuccess(T t) {
            this.f15741c.onSuccess(t);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15743f.a(this);
        }
    }

    public f(b0<? extends T> b0Var, w wVar) {
        this.f15739c = b0Var;
        this.f15740d = wVar;
    }

    @Override // io.reactivex.x
    protected void l(z<? super T> zVar) {
        a aVar = new a(zVar, this.f15739c);
        zVar.onSubscribe(aVar);
        aVar.f15742d.replace(this.f15740d.c(aVar));
    }
}

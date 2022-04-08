package io.reactivex.h0.c.c;

import io.reactivex.b0;
import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.q;
import io.reactivex.v;
import io.reactivex.z;

/* compiled from: SingleToObservable.java */
/* loaded from: classes4.dex */
public final class g<T> extends q<T> {

    /* renamed from: c  reason: collision with root package name */
    final b0<? extends T> f15744c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleToObservable.java */
    /* loaded from: classes4.dex */
    public static final class a<T> extends DeferredScalarDisposable<T> implements z<T> {

        /* renamed from: c  reason: collision with root package name */
        c f15745c;

        a(v<? super T> vVar) {
            super(vVar);
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.e0.c
        public void dispose() {
            super.dispose();
            this.f15745c.dispose();
        }

        @Override // io.reactivex.z
        public void onError(Throwable th) {
            error(th);
        }

        @Override // io.reactivex.z
        public void onSubscribe(c cVar) {
            if (DisposableHelper.validate(this.f15745c, cVar)) {
                this.f15745c = cVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.z
        public void onSuccess(T t) {
            complete(t);
        }
    }

    public g(b0<? extends T> b0Var) {
        this.f15744c = b0Var;
    }

    public static <T> z<T> j1(v<? super T> vVar) {
        return new a(vVar);
    }

    @Override // io.reactivex.q
    public void K0(v<? super T> vVar) {
        this.f15744c.a(j1(vVar));
    }
}

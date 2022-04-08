package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.q;
import io.reactivex.v;
import io.reactivex.w;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableTimer.java */
/* loaded from: classes4.dex */
public final class d1 extends q<Long> {

    /* renamed from: c  reason: collision with root package name */
    final w f15942c;

    /* renamed from: d  reason: collision with root package name */
    final long f15943d;

    /* renamed from: f  reason: collision with root package name */
    final TimeUnit f15944f;

    /* compiled from: ObservableTimer.java */
    /* loaded from: classes4.dex */
    static final class a extends AtomicReference<c> implements c, Runnable {

        /* renamed from: c  reason: collision with root package name */
        final v<? super Long> f15945c;

        a(v<? super Long> vVar) {
            this.f15945c = vVar;
        }

        public void a(c cVar) {
            DisposableHelper.trySet(this, cVar);
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!isDisposed()) {
                this.f15945c.onNext(0L);
                lazySet(EmptyDisposable.INSTANCE);
                this.f15945c.onComplete();
            }
        }
    }

    public d1(long j, TimeUnit timeUnit, w wVar) {
        this.f15943d = j;
        this.f15944f = timeUnit;
        this.f15942c = wVar;
    }

    @Override // io.reactivex.q
    public void K0(v<? super Long> vVar) {
        a aVar = new a(vVar);
        vVar.onSubscribe(aVar);
        aVar.a(this.f15942c.d(aVar, this.f15943d, this.f15944f));
    }
}

package io.reactivex.h0.c.a;

import io.reactivex.e;
import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.w;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CompletableSubscribeOn.java */
/* loaded from: classes4.dex */
public final class o extends io.reactivex.a {

    /* renamed from: c  reason: collision with root package name */
    final e f15696c;

    /* renamed from: d  reason: collision with root package name */
    final w f15697d;

    /* compiled from: CompletableSubscribeOn.java */
    /* loaded from: classes4.dex */
    static final class a extends AtomicReference<c> implements io.reactivex.c, c, Runnable {

        /* renamed from: c  reason: collision with root package name */
        final io.reactivex.c f15698c;

        /* renamed from: d  reason: collision with root package name */
        final SequentialDisposable f15699d = new SequentialDisposable();

        /* renamed from: f  reason: collision with root package name */
        final e f15700f;

        a(io.reactivex.c cVar, e eVar) {
            this.f15698c = cVar;
            this.f15700f = eVar;
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            DisposableHelper.dispose(this);
            this.f15699d.dispose();
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.c
        public void onComplete() {
            this.f15698c.onComplete();
        }

        @Override // io.reactivex.c
        public void onError(Throwable th) {
            this.f15698c.onError(th);
        }

        @Override // io.reactivex.c
        public void onSubscribe(c cVar) {
            DisposableHelper.setOnce(this, cVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15700f.a(this);
        }
    }

    public o(e eVar, w wVar) {
        this.f15696c = eVar;
        this.f15697d = wVar;
    }

    @Override // io.reactivex.a
    protected void B(io.reactivex.c cVar) {
        a aVar = new a(cVar, this.f15696c);
        cVar.onSubscribe(aVar);
        aVar.f15699d.replace(this.f15697d.c(aVar));
    }
}

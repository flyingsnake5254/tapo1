package io.reactivex.h0.c.a;

import io.reactivex.e;
import io.reactivex.e0.c;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.g0.j;
import io.reactivex.h0.a.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CompletableResumeNext.java */
/* loaded from: classes4.dex */
public final class n extends io.reactivex.a {

    /* renamed from: c  reason: collision with root package name */
    final e f15691c;

    /* renamed from: d  reason: collision with root package name */
    final j<? super Throwable, ? extends e> f15692d;

    /* compiled from: CompletableResumeNext.java */
    /* loaded from: classes4.dex */
    static final class a extends AtomicReference<c> implements io.reactivex.c, c {

        /* renamed from: c  reason: collision with root package name */
        final io.reactivex.c f15693c;

        /* renamed from: d  reason: collision with root package name */
        final j<? super Throwable, ? extends e> f15694d;

        /* renamed from: f  reason: collision with root package name */
        boolean f15695f;

        a(io.reactivex.c cVar, j<? super Throwable, ? extends e> jVar) {
            this.f15693c = cVar;
            this.f15694d = jVar;
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.c
        public void onComplete() {
            this.f15693c.onComplete();
        }

        @Override // io.reactivex.c
        public void onError(Throwable th) {
            if (this.f15695f) {
                this.f15693c.onError(th);
                return;
            }
            this.f15695f = true;
            try {
                ((e) b.e(this.f15694d.apply(th), "The errorMapper returned a null CompletableSource")).a(this);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f15693c.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.c
        public void onSubscribe(c cVar) {
            DisposableHelper.replace(this, cVar);
        }
    }

    public n(e eVar, j<? super Throwable, ? extends e> jVar) {
        this.f15691c = eVar;
        this.f15692d = jVar;
    }

    @Override // io.reactivex.a
    protected void B(io.reactivex.c cVar) {
        a aVar = new a(cVar, this.f15692d);
        cVar.onSubscribe(aVar);
        this.f15691c.a(aVar);
    }
}

package io.reactivex.h0.c.a;

import io.reactivex.c;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CompletableAndThenCompletable.java */
/* loaded from: classes4.dex */
public final class a extends io.reactivex.a {

    /* renamed from: c  reason: collision with root package name */
    final e f15648c;

    /* renamed from: d  reason: collision with root package name */
    final e f15649d;

    /* compiled from: CompletableAndThenCompletable.java */
    /* renamed from: io.reactivex.h0.c.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static final class C0293a implements c {

        /* renamed from: c  reason: collision with root package name */
        final AtomicReference<io.reactivex.e0.c> f15650c;

        /* renamed from: d  reason: collision with root package name */
        final c f15651d;

        C0293a(AtomicReference<io.reactivex.e0.c> atomicReference, c cVar) {
            this.f15650c = atomicReference;
            this.f15651d = cVar;
        }

        @Override // io.reactivex.c
        public void onComplete() {
            this.f15651d.onComplete();
        }

        @Override // io.reactivex.c
        public void onError(Throwable th) {
            this.f15651d.onError(th);
        }

        @Override // io.reactivex.c
        public void onSubscribe(io.reactivex.e0.c cVar) {
            DisposableHelper.replace(this.f15650c, cVar);
        }
    }

    /* compiled from: CompletableAndThenCompletable.java */
    /* loaded from: classes4.dex */
    static final class b extends AtomicReference<io.reactivex.e0.c> implements c, io.reactivex.e0.c {

        /* renamed from: c  reason: collision with root package name */
        final c f15652c;

        /* renamed from: d  reason: collision with root package name */
        final e f15653d;

        b(c cVar, e eVar) {
            this.f15652c = cVar;
            this.f15653d = eVar;
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
            this.f15653d.a(new C0293a(this, this.f15652c));
        }

        @Override // io.reactivex.c
        public void onError(Throwable th) {
            this.f15652c.onError(th);
        }

        @Override // io.reactivex.c
        public void onSubscribe(io.reactivex.e0.c cVar) {
            if (DisposableHelper.setOnce(this, cVar)) {
                this.f15652c.onSubscribe(this);
            }
        }
    }

    public a(e eVar, e eVar2) {
        this.f15648c = eVar;
        this.f15649d = eVar2;
    }

    @Override // io.reactivex.a
    protected void B(c cVar) {
        this.f15648c.a(new b(cVar, this.f15649d));
    }
}

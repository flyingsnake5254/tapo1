package io.reactivex.h0.c.a;

import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: CompletableDoFinally.java */
/* loaded from: classes4.dex */
public final class c extends io.reactivex.a {

    /* renamed from: c  reason: collision with root package name */
    final e f15656c;

    /* renamed from: d  reason: collision with root package name */
    final io.reactivex.g0.a f15657d;

    /* compiled from: CompletableDoFinally.java */
    /* loaded from: classes4.dex */
    static final class a extends AtomicInteger implements io.reactivex.c, io.reactivex.e0.c {

        /* renamed from: c  reason: collision with root package name */
        final io.reactivex.c f15658c;

        /* renamed from: d  reason: collision with root package name */
        final io.reactivex.g0.a f15659d;

        /* renamed from: f  reason: collision with root package name */
        io.reactivex.e0.c f15660f;

        a(io.reactivex.c cVar, io.reactivex.g0.a aVar) {
            this.f15658c = cVar;
            this.f15659d = aVar;
        }

        void a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f15659d.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    io.reactivex.j0.a.r(th);
                }
            }
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            this.f15660f.dispose();
            a();
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.f15660f.isDisposed();
        }

        @Override // io.reactivex.c
        public void onComplete() {
            this.f15658c.onComplete();
            a();
        }

        @Override // io.reactivex.c
        public void onError(Throwable th) {
            this.f15658c.onError(th);
            a();
        }

        @Override // io.reactivex.c
        public void onSubscribe(io.reactivex.e0.c cVar) {
            if (DisposableHelper.validate(this.f15660f, cVar)) {
                this.f15660f = cVar;
                this.f15658c.onSubscribe(this);
            }
        }
    }

    public c(e eVar, io.reactivex.g0.a aVar) {
        this.f15656c = eVar;
        this.f15657d = aVar;
    }

    @Override // io.reactivex.a
    protected void B(io.reactivex.c cVar) {
        this.f15656c.a(new a(cVar, this.f15657d));
    }
}

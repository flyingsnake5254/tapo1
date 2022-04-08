package io.reactivex.h0.c.a;

import io.reactivex.c;
import io.reactivex.e;
import io.reactivex.exceptions.CompositeException;

/* compiled from: CompletableOnErrorComplete.java */
/* loaded from: classes4.dex */
public final class l extends io.reactivex.a {

    /* renamed from: c  reason: collision with root package name */
    final e f15681c;

    /* renamed from: d  reason: collision with root package name */
    final io.reactivex.g0.l<? super Throwable> f15682d;

    /* compiled from: CompletableOnErrorComplete.java */
    /* loaded from: classes4.dex */
    final class a implements c {

        /* renamed from: c  reason: collision with root package name */
        private final c f15683c;

        a(c cVar) {
            this.f15683c = cVar;
        }

        @Override // io.reactivex.c
        public void onComplete() {
            this.f15683c.onComplete();
        }

        @Override // io.reactivex.c
        public void onError(Throwable th) {
            try {
                if (l.this.f15682d.test(th)) {
                    this.f15683c.onComplete();
                } else {
                    this.f15683c.onError(th);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f15683c.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.c
        public void onSubscribe(io.reactivex.e0.c cVar) {
            this.f15683c.onSubscribe(cVar);
        }
    }

    public l(e eVar, io.reactivex.g0.l<? super Throwable> lVar) {
        this.f15681c = eVar;
        this.f15682d = lVar;
    }

    @Override // io.reactivex.a
    protected void B(c cVar) {
        this.f15681c.a(new a(cVar));
    }
}

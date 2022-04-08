package io.reactivex.internal.operators.flowable;

import e.b.b;
import e.b.c;
import io.reactivex.g0.j;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.EmptySubscription;

/* compiled from: FlowableRetryWhen.java */
/* loaded from: classes4.dex */
public final class z<T> extends a<T, T> {

    /* renamed from: f  reason: collision with root package name */
    final j<? super h<Throwable>, ? extends e.b.a<?>> f15852f;

    /* compiled from: FlowableRetryWhen.java */
    /* loaded from: classes4.dex */
    static final class a<T> extends x<T, Throwable> {
        a(b<? super T> bVar, io.reactivex.k0.a<Throwable> aVar, c cVar) {
            super(bVar, aVar, cVar);
        }

        @Override // e.b.b
        public void onComplete() {
            this.f15847f.cancel();
            this.f15845c.onComplete();
        }

        @Override // e.b.b
        public void onError(Throwable th) {
            a(th);
        }
    }

    public z(h<T> hVar, j<? super h<Throwable>, ? extends e.b.a<?>> jVar) {
        super(hVar);
        this.f15852f = jVar;
    }

    @Override // io.reactivex.h
    public void H(b<? super T> bVar) {
        io.reactivex.n0.a aVar = new io.reactivex.n0.a(bVar);
        io.reactivex.k0.a<T> M = io.reactivex.k0.c.O(8).M();
        try {
            e.b.a aVar2 = (e.b.a) io.reactivex.h0.a.b.e(this.f15852f.apply(M), "handler returned a null Publisher");
            w wVar = new w(this.f15765d);
            a aVar3 = new a(aVar, M, wVar);
            wVar.q = aVar3;
            bVar.onSubscribe(aVar3);
            aVar2.a(wVar);
            wVar.onNext(0);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            EmptySubscription.error(th, bVar);
        }
    }
}

package io.reactivex.internal.operators.flowable;

import e.b.b;
import e.b.c;
import io.reactivex.h;
import io.reactivex.q;
import io.reactivex.v;

/* compiled from: FlowableFromObservable.java */
/* loaded from: classes4.dex */
public final class l<T> extends h<T> {

    /* renamed from: d  reason: collision with root package name */
    private final q<T> f15811d;

    /* compiled from: FlowableFromObservable.java */
    /* loaded from: classes4.dex */
    static final class a<T> implements v<T>, c {

        /* renamed from: c  reason: collision with root package name */
        final b<? super T> f15812c;

        /* renamed from: d  reason: collision with root package name */
        io.reactivex.e0.c f15813d;

        a(b<? super T> bVar) {
            this.f15812c = bVar;
        }

        @Override // e.b.c
        public void cancel() {
            this.f15813d.dispose();
        }

        @Override // io.reactivex.v
        public void onComplete() {
            this.f15812c.onComplete();
        }

        @Override // io.reactivex.v
        public void onError(Throwable th) {
            this.f15812c.onError(th);
        }

        @Override // io.reactivex.v
        public void onNext(T t) {
            this.f15812c.onNext(t);
        }

        @Override // io.reactivex.v
        public void onSubscribe(io.reactivex.e0.c cVar) {
            this.f15813d = cVar;
            this.f15812c.onSubscribe(this);
        }

        @Override // e.b.c
        public void request(long j) {
        }
    }

    public l(q<T> qVar) {
        this.f15811d = qVar;
    }

    @Override // io.reactivex.h
    protected void H(b<? super T> bVar) {
        this.f15811d.a(new a(bVar));
    }
}

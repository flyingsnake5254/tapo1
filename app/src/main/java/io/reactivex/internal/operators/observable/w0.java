package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.t;
import io.reactivex.v;

/* compiled from: ObservableSwitchIfEmpty.java */
/* loaded from: classes4.dex */
public final class w0<T> extends a<T, T> {

    /* renamed from: d  reason: collision with root package name */
    final t<? extends T> f16127d;

    /* compiled from: ObservableSwitchIfEmpty.java */
    /* loaded from: classes4.dex */
    static final class a<T> implements v<T> {

        /* renamed from: c  reason: collision with root package name */
        final v<? super T> f16128c;

        /* renamed from: d  reason: collision with root package name */
        final t<? extends T> f16129d;
        boolean q = true;

        /* renamed from: f  reason: collision with root package name */
        final SequentialDisposable f16130f = new SequentialDisposable();

        a(v<? super T> vVar, t<? extends T> tVar) {
            this.f16128c = vVar;
            this.f16129d = tVar;
        }

        @Override // io.reactivex.v
        public void onComplete() {
            if (this.q) {
                this.q = false;
                this.f16129d.a(this);
                return;
            }
            this.f16128c.onComplete();
        }

        @Override // io.reactivex.v
        public void onError(Throwable th) {
            this.f16128c.onError(th);
        }

        @Override // io.reactivex.v
        public void onNext(T t) {
            if (this.q) {
                this.q = false;
            }
            this.f16128c.onNext(t);
        }

        @Override // io.reactivex.v
        public void onSubscribe(c cVar) {
            this.f16130f.update(cVar);
        }
    }

    public w0(t<T> tVar, t<? extends T> tVar2) {
        super(tVar);
        this.f16127d = tVar2;
    }

    @Override // io.reactivex.q
    public void K0(v<? super T> vVar) {
        a aVar = new a(vVar, this.f16127d);
        vVar.onSubscribe(aVar.f16130f);
        this.f15892c.a(aVar);
    }
}

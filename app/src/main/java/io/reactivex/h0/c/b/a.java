package io.reactivex.h0.c.b;

import io.reactivex.e;
import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CompletableAndThenObservable.java */
/* loaded from: classes4.dex */
public final class a<R> extends q<R> {

    /* renamed from: c  reason: collision with root package name */
    final e f15719c;

    /* renamed from: d  reason: collision with root package name */
    final t<? extends R> f15720d;

    /* compiled from: CompletableAndThenObservable.java */
    /* renamed from: io.reactivex.h0.c.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static final class C0295a<R> extends AtomicReference<c> implements v<R>, io.reactivex.c, c {

        /* renamed from: c  reason: collision with root package name */
        final v<? super R> f15721c;

        /* renamed from: d  reason: collision with root package name */
        t<? extends R> f15722d;

        C0295a(v<? super R> vVar, t<? extends R> tVar) {
            this.f15722d = tVar;
            this.f15721c = vVar;
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.v
        public void onComplete() {
            t<? extends R> tVar = this.f15722d;
            if (tVar == null) {
                this.f15721c.onComplete();
                return;
            }
            this.f15722d = null;
            tVar.a(this);
        }

        @Override // io.reactivex.v
        public void onError(Throwable th) {
            this.f15721c.onError(th);
        }

        @Override // io.reactivex.v
        public void onNext(R r) {
            this.f15721c.onNext(r);
        }

        @Override // io.reactivex.v
        public void onSubscribe(c cVar) {
            DisposableHelper.replace(this, cVar);
        }
    }

    public a(e eVar, t<? extends R> tVar) {
        this.f15719c = eVar;
        this.f15720d = tVar;
    }

    @Override // io.reactivex.q
    protected void K0(v<? super R> vVar) {
        C0295a aVar = new C0295a(vVar, this.f15720d);
        vVar.onSubscribe(aVar);
        this.f15719c.a(aVar);
    }
}

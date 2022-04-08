package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.v;

/* compiled from: ObservableDelaySubscriptionOther.java */
/* loaded from: classes4.dex */
public final class g<T, U> extends q<T> {

    /* renamed from: c  reason: collision with root package name */
    final t<? extends T> f15975c;

    /* renamed from: d  reason: collision with root package name */
    final t<U> f15976d;

    /* compiled from: ObservableDelaySubscriptionOther.java */
    /* loaded from: classes4.dex */
    final class a implements v<U> {

        /* renamed from: c  reason: collision with root package name */
        final SequentialDisposable f15977c;

        /* renamed from: d  reason: collision with root package name */
        final v<? super T> f15978d;

        /* renamed from: f  reason: collision with root package name */
        boolean f15979f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObservableDelaySubscriptionOther.java */
        /* renamed from: io.reactivex.internal.operators.observable.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public final class C0305a implements v<T> {
            C0305a() {
            }

            @Override // io.reactivex.v
            public void onComplete() {
                a.this.f15978d.onComplete();
            }

            @Override // io.reactivex.v
            public void onError(Throwable th) {
                a.this.f15978d.onError(th);
            }

            @Override // io.reactivex.v
            public void onNext(T t) {
                a.this.f15978d.onNext(t);
            }

            @Override // io.reactivex.v
            public void onSubscribe(c cVar) {
                a.this.f15977c.update(cVar);
            }
        }

        a(SequentialDisposable sequentialDisposable, v<? super T> vVar) {
            this.f15977c = sequentialDisposable;
            this.f15978d = vVar;
        }

        @Override // io.reactivex.v
        public void onComplete() {
            if (!this.f15979f) {
                this.f15979f = true;
                g.this.f15975c.a(new C0305a());
            }
        }

        @Override // io.reactivex.v
        public void onError(Throwable th) {
            if (this.f15979f) {
                io.reactivex.j0.a.r(th);
                return;
            }
            this.f15979f = true;
            this.f15978d.onError(th);
        }

        @Override // io.reactivex.v
        public void onNext(U u) {
            onComplete();
        }

        @Override // io.reactivex.v
        public void onSubscribe(c cVar) {
            this.f15977c.update(cVar);
        }
    }

    public g(t<? extends T> tVar, t<U> tVar2) {
        this.f15975c = tVar;
        this.f15976d = tVar2;
    }

    @Override // io.reactivex.q
    public void K0(v<? super T> vVar) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        vVar.onSubscribe(sequentialDisposable);
        this.f15976d.a(new a(sequentialDisposable, vVar));
    }
}

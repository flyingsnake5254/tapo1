package io.reactivex.h0.c.a;

import io.reactivex.c;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.b;
import io.reactivex.q;
import io.reactivex.v;

/* compiled from: CompletableToObservable.java */
/* loaded from: classes4.dex */
public final class s<T> extends q<T> {

    /* renamed from: c  reason: collision with root package name */
    final e f15716c;

    /* compiled from: CompletableToObservable.java */
    /* loaded from: classes4.dex */
    static final class a extends b<Void> implements c {

        /* renamed from: c  reason: collision with root package name */
        final v<?> f15717c;

        /* renamed from: d  reason: collision with root package name */
        io.reactivex.e0.c f15718d;

        a(v<?> vVar) {
            this.f15717c = vVar;
        }

        /* renamed from: a */
        public Void poll() throws Exception {
            return null;
        }

        @Override // io.reactivex.h0.b.i
        public void clear() {
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            this.f15718d.dispose();
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.f15718d.isDisposed();
        }

        @Override // io.reactivex.h0.b.i
        public boolean isEmpty() {
            return true;
        }

        @Override // io.reactivex.c
        public void onComplete() {
            this.f15717c.onComplete();
        }

        @Override // io.reactivex.c
        public void onError(Throwable th) {
            this.f15717c.onError(th);
        }

        @Override // io.reactivex.c
        public void onSubscribe(io.reactivex.e0.c cVar) {
            if (DisposableHelper.validate(this.f15718d, cVar)) {
                this.f15718d = cVar;
                this.f15717c.onSubscribe(this);
            }
        }

        @Override // io.reactivex.h0.b.e
        public int requestFusion(int i) {
            return i & 2;
        }
    }

    public s(e eVar) {
        this.f15716c = eVar;
    }

    @Override // io.reactivex.q
    protected void K0(v<? super T> vVar) {
        this.f15716c.a(new a(vVar));
    }
}

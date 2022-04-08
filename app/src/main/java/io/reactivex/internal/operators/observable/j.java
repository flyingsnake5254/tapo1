package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.h0.b.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.t;
import io.reactivex.v;

/* compiled from: ObservableDoFinally.java */
/* loaded from: classes4.dex */
public final class j<T> extends a<T, T> {

    /* renamed from: d  reason: collision with root package name */
    final io.reactivex.g0.a f16007d;

    /* compiled from: ObservableDoFinally.java */
    /* loaded from: classes4.dex */
    static final class a<T> extends BasicIntQueueDisposable<T> implements v<T> {

        /* renamed from: c  reason: collision with root package name */
        final v<? super T> f16008c;

        /* renamed from: d  reason: collision with root package name */
        final io.reactivex.g0.a f16009d;

        /* renamed from: f  reason: collision with root package name */
        c f16010f;
        d<T> q;
        boolean x;

        a(v<? super T> vVar, io.reactivex.g0.a aVar) {
            this.f16008c = vVar;
            this.f16009d = aVar;
        }

        void a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f16009d.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    io.reactivex.j0.a.r(th);
                }
            }
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.h0.b.i
        public void clear() {
            this.q.clear();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.e0.c
        public void dispose() {
            this.f16010f.dispose();
            a();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.e0.c
        public boolean isDisposed() {
            return this.f16010f.isDisposed();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.h0.b.i
        public boolean isEmpty() {
            return this.q.isEmpty();
        }

        @Override // io.reactivex.v
        public void onComplete() {
            this.f16008c.onComplete();
            a();
        }

        @Override // io.reactivex.v
        public void onError(Throwable th) {
            this.f16008c.onError(th);
            a();
        }

        @Override // io.reactivex.v
        public void onNext(T t) {
            this.f16008c.onNext(t);
        }

        @Override // io.reactivex.v
        public void onSubscribe(c cVar) {
            if (DisposableHelper.validate(this.f16010f, cVar)) {
                this.f16010f = cVar;
                if (cVar instanceof d) {
                    this.q = (d) cVar;
                }
                this.f16008c.onSubscribe(this);
            }
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.h0.b.i
        public T poll() throws Exception {
            T poll = this.q.poll();
            if (poll == null && this.x) {
                a();
            }
            return poll;
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, io.reactivex.h0.b.e
        public int requestFusion(int i) {
            d<T> dVar = this.q;
            boolean z = false;
            if (dVar == null || (i & 4) != 0) {
                return 0;
            }
            int requestFusion = dVar.requestFusion(i);
            if (requestFusion != 0) {
                if (requestFusion == 1) {
                    z = true;
                }
                this.x = z;
            }
            return requestFusion;
        }
    }

    public j(t<T> tVar, io.reactivex.g0.a aVar) {
        super(tVar);
        this.f16007d = aVar;
    }

    @Override // io.reactivex.q
    protected void K0(v<? super T> vVar) {
        this.f15892c.a(new a(vVar, this.f16007d));
    }
}

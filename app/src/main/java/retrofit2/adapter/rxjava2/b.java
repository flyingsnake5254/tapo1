package retrofit2.adapter.rxjava2;

import io.reactivex.e0.c;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.q;
import io.reactivex.v;
import retrofit2.d;

/* compiled from: CallEnqueueObservable.java */
/* loaded from: classes4.dex */
final class b<T> extends q<retrofit2.q<T>> {

    /* renamed from: c  reason: collision with root package name */
    private final retrofit2.b<T> f17550c;

    /* compiled from: CallEnqueueObservable.java */
    /* loaded from: classes4.dex */
    private static final class a<T> implements c, d<T> {

        /* renamed from: c  reason: collision with root package name */
        private final retrofit2.b<?> f17551c;

        /* renamed from: d  reason: collision with root package name */
        private final v<? super retrofit2.q<T>> f17552d;

        /* renamed from: f  reason: collision with root package name */
        private volatile boolean f17553f;
        boolean q = false;

        a(retrofit2.b<?> bVar, v<? super retrofit2.q<T>> vVar) {
            this.f17551c = bVar;
            this.f17552d = vVar;
        }

        @Override // retrofit2.d
        public void a(retrofit2.b<T> bVar, Throwable th) {
            if (!bVar.isCanceled()) {
                try {
                    this.f17552d.onError(th);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    io.reactivex.j0.a.r(new CompositeException(th, th2));
                }
            }
        }

        @Override // retrofit2.d
        public void b(retrofit2.b<T> bVar, retrofit2.q<T> qVar) {
            if (!this.f17553f) {
                try {
                    this.f17552d.onNext(qVar);
                    if (!this.f17553f) {
                        this.q = true;
                        this.f17552d.onComplete();
                    }
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    if (this.q) {
                        io.reactivex.j0.a.r(th);
                    } else if (!this.f17553f) {
                        try {
                            this.f17552d.onError(th);
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.b(th2);
                            io.reactivex.j0.a.r(new CompositeException(th, th2));
                        }
                    }
                }
            }
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            this.f17553f = true;
            this.f17551c.cancel();
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.f17553f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(retrofit2.b<T> bVar) {
        this.f17550c = bVar;
    }

    @Override // io.reactivex.q
    protected void K0(v<? super retrofit2.q<T>> vVar) {
        retrofit2.b<T> clone = this.f17550c.clone();
        a aVar = new a(clone, vVar);
        vVar.onSubscribe(aVar);
        if (!aVar.isDisposed()) {
            clone.i(aVar);
        }
    }
}

package retrofit2.adapter.rxjava2;

import io.reactivex.e0.c;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.q;
import io.reactivex.v;

/* compiled from: ResultObservable.java */
/* loaded from: classes4.dex */
final class e<T> extends q<d<T>> {

    /* renamed from: c  reason: collision with root package name */
    private final q<retrofit2.q<T>> f17558c;

    /* compiled from: ResultObservable.java */
    /* loaded from: classes4.dex */
    private static class a<R> implements v<retrofit2.q<R>> {

        /* renamed from: c  reason: collision with root package name */
        private final v<? super d<R>> f17559c;

        a(v<? super d<R>> vVar) {
            this.f17559c = vVar;
        }

        /* renamed from: a */
        public void onNext(retrofit2.q<R> qVar) {
            this.f17559c.onNext(d.b(qVar));
        }

        @Override // io.reactivex.v
        public void onComplete() {
            this.f17559c.onComplete();
        }

        @Override // io.reactivex.v
        public void onError(Throwable th) {
            try {
                this.f17559c.onNext(d.a(th));
                this.f17559c.onComplete();
            } catch (Throwable th2) {
                try {
                    this.f17559c.onError(th2);
                } catch (Throwable th3) {
                    io.reactivex.exceptions.a.b(th3);
                    io.reactivex.j0.a.r(new CompositeException(th2, th3));
                }
            }
        }

        @Override // io.reactivex.v
        public void onSubscribe(c cVar) {
            this.f17559c.onSubscribe(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(q<retrofit2.q<T>> qVar) {
        this.f17558c = qVar;
    }

    @Override // io.reactivex.q
    protected void K0(v<? super d<T>> vVar) {
        this.f17558c.a(new a(vVar));
    }
}

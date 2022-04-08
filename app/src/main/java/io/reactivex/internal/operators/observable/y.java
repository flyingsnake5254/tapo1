package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.observers.b;
import io.reactivex.q;
import io.reactivex.v;
import java.util.Iterator;

/* compiled from: ObservableFromIterable.java */
/* loaded from: classes4.dex */
public final class y<T> extends q<T> {

    /* renamed from: c  reason: collision with root package name */
    final Iterable<? extends T> f16140c;

    /* compiled from: ObservableFromIterable.java */
    /* loaded from: classes4.dex */
    static final class a<T> extends b<T> {

        /* renamed from: c  reason: collision with root package name */
        final v<? super T> f16141c;

        /* renamed from: d  reason: collision with root package name */
        final Iterator<? extends T> f16142d;

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f16143f;
        boolean q;
        boolean x;
        boolean y;

        a(v<? super T> vVar, Iterator<? extends T> it) {
            this.f16141c = vVar;
            this.f16142d = it;
        }

        void a() {
            while (!isDisposed()) {
                try {
                    this.f16141c.onNext(io.reactivex.h0.a.b.e(this.f16142d.next(), "The iterator returned a null value"));
                    if (!isDisposed()) {
                        try {
                            if (!this.f16142d.hasNext()) {
                                if (!isDisposed()) {
                                    this.f16141c.onComplete();
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.b(th);
                            this.f16141c.onError(th);
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.f16141c.onError(th2);
                    return;
                }
            }
        }

        @Override // io.reactivex.h0.b.i
        public void clear() {
            this.x = true;
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            this.f16143f = true;
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.f16143f;
        }

        @Override // io.reactivex.h0.b.i
        public boolean isEmpty() {
            return this.x;
        }

        @Override // io.reactivex.h0.b.i
        public T poll() {
            if (this.x) {
                return null;
            }
            if (!this.y) {
                this.y = true;
            } else if (!this.f16142d.hasNext()) {
                this.x = true;
                return null;
            }
            return (T) io.reactivex.h0.a.b.e(this.f16142d.next(), "The iterator returned a null value");
        }

        @Override // io.reactivex.h0.b.e
        public int requestFusion(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            this.q = true;
            return 1;
        }
    }

    public y(Iterable<? extends T> iterable) {
        this.f16140c = iterable;
    }

    @Override // io.reactivex.q
    public void K0(v<? super T> vVar) {
        try {
            Iterator<? extends T> it = this.f16140c.iterator();
            try {
                if (!it.hasNext()) {
                    EmptyDisposable.complete(vVar);
                    return;
                }
                a aVar = new a(vVar, it);
                vVar.onSubscribe(aVar);
                if (!aVar.q) {
                    aVar.a();
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                EmptyDisposable.error(th, vVar);
            }
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptyDisposable.error(th2, vVar);
        }
    }
}

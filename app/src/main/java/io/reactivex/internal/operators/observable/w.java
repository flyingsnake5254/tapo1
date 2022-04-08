package io.reactivex.internal.operators.observable;

import io.reactivex.internal.observers.b;
import io.reactivex.q;
import io.reactivex.v;

/* compiled from: ObservableFromArray.java */
/* loaded from: classes4.dex */
public final class w<T> extends q<T> {

    /* renamed from: c  reason: collision with root package name */
    final T[] f16123c;

    /* compiled from: ObservableFromArray.java */
    /* loaded from: classes4.dex */
    static final class a<T> extends b<T> {

        /* renamed from: c  reason: collision with root package name */
        final v<? super T> f16124c;

        /* renamed from: d  reason: collision with root package name */
        final T[] f16125d;

        /* renamed from: f  reason: collision with root package name */
        int f16126f;
        boolean q;
        volatile boolean x;

        a(v<? super T> vVar, T[] tArr) {
            this.f16124c = vVar;
            this.f16125d = tArr;
        }

        void a() {
            T[] tArr = this.f16125d;
            int length = tArr.length;
            for (int i = 0; i < length && !isDisposed(); i++) {
                T t = tArr[i];
                if (t == null) {
                    v<? super T> vVar = this.f16124c;
                    vVar.onError(new NullPointerException("The element at index " + i + " is null"));
                    return;
                }
                this.f16124c.onNext(t);
            }
            if (!isDisposed()) {
                this.f16124c.onComplete();
            }
        }

        @Override // io.reactivex.h0.b.i
        public void clear() {
            this.f16126f = this.f16125d.length;
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            this.x = true;
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.x;
        }

        @Override // io.reactivex.h0.b.i
        public boolean isEmpty() {
            return this.f16126f == this.f16125d.length;
        }

        @Override // io.reactivex.h0.b.i
        public T poll() {
            int i = this.f16126f;
            T[] tArr = this.f16125d;
            if (i == tArr.length) {
                return null;
            }
            this.f16126f = i + 1;
            return (T) io.reactivex.h0.a.b.e(tArr[i], "The array element is null");
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

    public w(T[] tArr) {
        this.f16123c = tArr;
    }

    @Override // io.reactivex.q
    public void K0(v<? super T> vVar) {
        a aVar = new a(vVar, this.f16123c);
        vVar.onSubscribe(aVar);
        if (!aVar.q) {
            aVar.a();
        }
    }
}

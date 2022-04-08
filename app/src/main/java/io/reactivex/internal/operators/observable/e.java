package io.reactivex.internal.operators.observable;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.q;
import io.reactivex.r;
import io.reactivex.s;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableCreate.java */
/* loaded from: classes4.dex */
public final class e<T> extends q<T> {

    /* renamed from: c  reason: collision with root package name */
    final s<T> f15946c;

    /* compiled from: ObservableCreate.java */
    /* loaded from: classes4.dex */
    static final class a<T> extends AtomicReference<c> implements r<T>, c {

        /* renamed from: c  reason: collision with root package name */
        final v<? super T> f15947c;

        a(v<? super T> vVar) {
            this.f15947c = vVar;
        }

        @Override // io.reactivex.r
        public void a(c cVar) {
            DisposableHelper.set(this, cVar);
        }

        /* JADX WARN: Finally extract failed */
        public boolean b(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isDisposed()) {
                return false;
            }
            try {
                this.f15947c.onError(th);
                dispose();
                return true;
            } catch (Throwable th2) {
                dispose();
                throw th2;
            }
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.g
        public void onComplete() {
            if (!isDisposed()) {
                try {
                    this.f15947c.onComplete();
                } finally {
                    dispose();
                }
            }
        }

        @Override // io.reactivex.g
        public void onError(Throwable th) {
            if (!b(th)) {
                io.reactivex.j0.a.r(th);
            }
        }

        @Override // io.reactivex.g
        public void onNext(T t) {
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else if (!isDisposed()) {
                this.f15947c.onNext(t);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", a.class.getSimpleName(), super.toString());
        }
    }

    public e(s<T> sVar) {
        this.f15946c = sVar;
    }

    @Override // io.reactivex.q
    protected void K0(v<? super T> vVar) {
        a aVar = new a(vVar);
        vVar.onSubscribe(aVar);
        try {
            this.f15946c.subscribe(aVar);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            aVar.onError(th);
        }
    }
}

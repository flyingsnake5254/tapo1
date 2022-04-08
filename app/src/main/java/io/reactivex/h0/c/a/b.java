package io.reactivex.h0.c.a;

import io.reactivex.d;
import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CompletableCreate.java */
/* loaded from: classes4.dex */
public final class b extends io.reactivex.a {

    /* renamed from: c  reason: collision with root package name */
    final d f15654c;

    /* compiled from: CompletableCreate.java */
    /* loaded from: classes4.dex */
    static final class a extends AtomicReference<c> implements io.reactivex.b, c {

        /* renamed from: c  reason: collision with root package name */
        final io.reactivex.c f15655c;

        a(io.reactivex.c cVar) {
            this.f15655c = cVar;
        }

        public boolean a(Throwable th) {
            c andSet;
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            c cVar = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (cVar == disposableHelper || (andSet = getAndSet(disposableHelper)) == disposableHelper) {
                return false;
            }
            try {
                this.f15655c.onError(th);
            } finally {
                if (andSet != null) {
                    andSet.dispose();
                }
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

        @Override // io.reactivex.b
        public void onComplete() {
            c andSet;
            c cVar = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (cVar != disposableHelper && (andSet = getAndSet(disposableHelper)) != disposableHelper) {
                try {
                    this.f15655c.onComplete();
                } finally {
                    if (andSet != null) {
                        andSet.dispose();
                    }
                }
            }
        }

        @Override // io.reactivex.b
        public void onError(Throwable th) {
            if (!a(th)) {
                io.reactivex.j0.a.r(th);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", a.class.getSimpleName(), super.toString());
        }
    }

    public b(d dVar) {
        this.f15654c = dVar;
    }

    @Override // io.reactivex.a
    protected void B(io.reactivex.c cVar) {
        a aVar = new a(cVar);
        cVar.onSubscribe(aVar);
        try {
            this.f15654c.a(aVar);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            aVar.onError(th);
        }
    }
}

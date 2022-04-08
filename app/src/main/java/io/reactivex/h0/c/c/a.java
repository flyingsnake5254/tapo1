package io.reactivex.h0.c.c;

import io.reactivex.a0;
import io.reactivex.e0.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.x;
import io.reactivex.y;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleCreate.java */
/* loaded from: classes4.dex */
public final class a<T> extends x<T> {

    /* renamed from: c  reason: collision with root package name */
    final a0<T> f15727c;

    /* compiled from: SingleCreate.java */
    /* renamed from: io.reactivex.h0.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static final class C0296a<T> extends AtomicReference<c> implements y<T>, c {

        /* renamed from: c  reason: collision with root package name */
        final z<? super T> f15728c;

        C0296a(z<? super T> zVar) {
            this.f15728c = zVar;
        }

        @Override // io.reactivex.y
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
                this.f15728c.onError(th);
            } finally {
                if (andSet != null) {
                    andSet.dispose();
                }
            }
        }

        public void b(Throwable th) {
            if (!a(th)) {
                io.reactivex.j0.a.r(th);
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

        @Override // io.reactivex.y
        public void onSuccess(T t) {
            c andSet;
            c cVar = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (cVar != disposableHelper && (andSet = getAndSet(disposableHelper)) != disposableHelper) {
                try {
                    if (t == null) {
                        this.f15728c.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));
                    } else {
                        this.f15728c.onSuccess(t);
                    }
                    if (andSet != null) {
                        andSet.dispose();
                    }
                } catch (Throwable th) {
                    if (andSet != null) {
                        andSet.dispose();
                    }
                    throw th;
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", C0296a.class.getSimpleName(), super.toString());
        }
    }

    public a(a0<T> a0Var) {
        this.f15727c = a0Var;
    }

    @Override // io.reactivex.x
    protected void l(z<? super T> zVar) {
        C0296a aVar = new C0296a(zVar);
        zVar.onSubscribe(aVar);
        try {
            this.f15727c.subscribe(aVar);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            aVar.b(th);
        }
    }
}

package io.reactivex.h0.c.c;

import io.reactivex.b0;
import io.reactivex.e0.c;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.g0.g;
import io.reactivex.x;
import io.reactivex.z;

/* compiled from: SingleDoOnError.java */
/* loaded from: classes4.dex */
public final class b<T> extends x<T> {

    /* renamed from: c  reason: collision with root package name */
    final b0<T> f15729c;

    /* renamed from: d  reason: collision with root package name */
    final g<? super Throwable> f15730d;

    /* compiled from: SingleDoOnError.java */
    /* loaded from: classes4.dex */
    final class a implements z<T> {

        /* renamed from: c  reason: collision with root package name */
        private final z<? super T> f15731c;

        a(z<? super T> zVar) {
            this.f15731c = zVar;
        }

        @Override // io.reactivex.z
        public void onError(Throwable th) {
            try {
                b.this.f15730d.accept(th);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                th = new CompositeException(th, th2);
            }
            this.f15731c.onError(th);
        }

        @Override // io.reactivex.z
        public void onSubscribe(c cVar) {
            this.f15731c.onSubscribe(cVar);
        }

        @Override // io.reactivex.z
        public void onSuccess(T t) {
            this.f15731c.onSuccess(t);
        }
    }

    public b(b0<T> b0Var, g<? super Throwable> gVar) {
        this.f15729c = b0Var;
        this.f15730d = gVar;
    }

    @Override // io.reactivex.x
    protected void l(z<? super T> zVar) {
        this.f15729c.a(new a(zVar));
    }
}

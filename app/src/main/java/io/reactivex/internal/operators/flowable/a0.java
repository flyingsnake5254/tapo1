package io.reactivex.internal.operators.flowable;

import e.b.b;
import io.reactivex.g0.j;
import io.reactivex.h;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import java.util.concurrent.Callable;

/* compiled from: FlowableScalarXMap.java */
/* loaded from: classes4.dex */
public final class a0 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowableScalarXMap.java */
    /* loaded from: classes4.dex */
    public static final class a<T, R> extends h<R> {

        /* renamed from: d  reason: collision with root package name */
        final T f15766d;

        /* renamed from: f  reason: collision with root package name */
        final j<? super T, ? extends e.b.a<? extends R>> f15767f;

        a(T t, j<? super T, ? extends e.b.a<? extends R>> jVar) {
            this.f15766d = t;
            this.f15767f = jVar;
        }

        @Override // io.reactivex.h
        public void H(b<? super R> bVar) {
            try {
                e.b.a aVar = (e.b.a) io.reactivex.h0.a.b.e(this.f15767f.apply((T) this.f15766d), "The mapper returned a null Publisher");
                if (aVar instanceof Callable) {
                    try {
                        Object call = ((Callable) aVar).call();
                        if (call == null) {
                            EmptySubscription.complete(bVar);
                        } else {
                            bVar.onSubscribe(new ScalarSubscription(bVar, call));
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        EmptySubscription.error(th, bVar);
                    }
                } else {
                    aVar.a(bVar);
                }
            } catch (Throwable th2) {
                EmptySubscription.error(th2, bVar);
            }
        }
    }

    public static <T, U> h<U> a(T t, j<? super T, ? extends e.b.a<? extends U>> jVar) {
        return io.reactivex.j0.a.l(new a(t, jVar));
    }

    public static <T, R> boolean b(e.b.a<T> aVar, b<? super R> bVar, j<? super T, ? extends e.b.a<? extends R>> jVar) {
        if (!(aVar instanceof Callable)) {
            return false;
        }
        try {
            Object obj = (Object) ((Callable) aVar).call();
            if (obj == 0) {
                EmptySubscription.complete(bVar);
                return true;
            }
            try {
                e.b.a aVar2 = (e.b.a) io.reactivex.h0.a.b.e(jVar.apply(obj), "The mapper returned a null Publisher");
                if (aVar2 instanceof Callable) {
                    try {
                        Object call = ((Callable) aVar2).call();
                        if (call == null) {
                            EmptySubscription.complete(bVar);
                            return true;
                        }
                        bVar.onSubscribe(new ScalarSubscription(bVar, call));
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        EmptySubscription.error(th, bVar);
                        return true;
                    }
                } else {
                    aVar2.a(bVar);
                }
                return true;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                EmptySubscription.error(th2, bVar);
                return true;
            }
        } catch (Throwable th3) {
            io.reactivex.exceptions.a.b(th3);
            EmptySubscription.error(th3, bVar);
            return true;
        }
    }
}

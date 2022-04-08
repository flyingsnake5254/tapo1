package io.reactivex;

import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.h0.a.b;
import io.reactivex.internal.operators.maybe.MaybeCallbackObserver;
import io.reactivex.internal.operators.maybe.c;
import io.reactivex.internal.operators.maybe.d;
import io.reactivex.internal.operators.maybe.f;
import io.reactivex.internal.operators.maybe.h;
import io.reactivex.internal.operators.maybe.k;
import io.reactivex.internal.operators.maybe.l;
import io.reactivex.j0.a;
import java.util.concurrent.Callable;

/* compiled from: Maybe.java */
/* loaded from: classes4.dex */
public abstract class m<T> implements o<T> {
    public static <T> m<T> h(Throwable th) {
        b.e(th, "exception is null");
        return a.m(new c(th));
    }

    public static <T> m<T> j(Callable<? extends T> callable) {
        b.e(callable, "callable is null");
        return a.m(new f(callable));
    }

    public static <T> m<T> r(o<T> oVar) {
        if (oVar instanceof m) {
            return a.m((m) oVar);
        }
        b.e(oVar, "onSubscribe is null");
        return a.m(new l(oVar));
    }

    @Override // io.reactivex.o
    public final void a(n<? super T> nVar) {
        b.e(nVar, "observer is null");
        n<? super T> w = a.w(this, nVar);
        b.e(w, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            n(w);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final <R> m<R> c(p<? super T, ? extends R> pVar) {
        return r(((p) b.e(pVar, "transformer is null")).a(this));
    }

    public final m<T> d(io.reactivex.g0.a aVar) {
        b.e(aVar, "onFinally is null");
        return a.m(new io.reactivex.internal.operators.maybe.b(this, aVar));
    }

    public final m<T> e(g<? super Throwable> gVar) {
        io.reactivex.g0.a aVar = io.reactivex.h0.a.a.f15635c;
        return a.m(new h(this, io.reactivex.h0.a.a.f(), io.reactivex.h0.a.a.f(), (g) b.e(gVar, "onError is null"), aVar, aVar, aVar));
    }

    public final m<T> f(g<? super io.reactivex.e0.c> gVar) {
        g f2 = io.reactivex.h0.a.a.f();
        g f3 = io.reactivex.h0.a.a.f();
        io.reactivex.g0.a aVar = io.reactivex.h0.a.a.f15635c;
        return a.m(new h(this, (g) b.e(gVar, "onSubscribe is null"), f2, f3, aVar, aVar, aVar));
    }

    public final m<T> g(g<? super T> gVar) {
        g f2 = io.reactivex.h0.a.a.f();
        io.reactivex.g0.a aVar = io.reactivex.h0.a.a.f15635c;
        return a.m(new h(this, io.reactivex.h0.a.a.f(), (g) b.e(gVar, "onSuccess is null"), f2, aVar, aVar, aVar));
    }

    public final m<T> i(io.reactivex.g0.l<? super T> lVar) {
        b.e(lVar, "predicate is null");
        return a.m(new d(this, lVar));
    }

    public final m<T> k(j<? super Throwable, ? extends o<? extends T>> jVar) {
        b.e(jVar, "resumeFunction is null");
        return a.m(new io.reactivex.internal.operators.maybe.g(this, jVar, true));
    }

    public final io.reactivex.e0.c l() {
        return m(io.reactivex.h0.a.a.f(), io.reactivex.h0.a.a.f15638f, io.reactivex.h0.a.a.f15635c);
    }

    public final io.reactivex.e0.c m(g<? super T> gVar, g<? super Throwable> gVar2, io.reactivex.g0.a aVar) {
        b.e(gVar, "onSuccess is null");
        b.e(gVar2, "onError is null");
        b.e(aVar, "onComplete is null");
        return (io.reactivex.e0.c) o(new MaybeCallbackObserver(gVar, gVar2, aVar));
    }

    protected abstract void n(n<? super T> nVar);

    public final <E extends n<? super T>> E o(E e2) {
        a(e2);
        return e2;
    }

    public final q<T> p() {
        if (this instanceof io.reactivex.h0.b.c) {
            return ((io.reactivex.h0.b.c) this).b();
        }
        return a.n(new io.reactivex.internal.operators.maybe.j(this));
    }

    public final x<T> q() {
        return a.o(new k(this, null));
    }
}

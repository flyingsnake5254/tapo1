package io.reactivex;

import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.g0.l;
import io.reactivex.h0.a.b;
import io.reactivex.h0.c.c.c;
import io.reactivex.h0.c.c.d;
import io.reactivex.h0.c.c.f;
import io.reactivex.internal.operators.maybe.e;
import io.reactivex.j0.a;
import java.util.concurrent.Callable;

/* compiled from: Single.java */
/* loaded from: classes4.dex */
public abstract class x<T> implements b0<T> {
    public static <T> x<T> e(a0<T> a0Var) {
        b.e(a0Var, "source is null");
        return a.o(new io.reactivex.h0.c.c.a(a0Var));
    }

    public static <T> x<T> g(Throwable th) {
        b.e(th, "exception is null");
        return h(io.reactivex.h0.a.a.h(th));
    }

    public static <T> x<T> h(Callable<? extends Throwable> callable) {
        b.e(callable, "errorSupplier is null");
        return a.o(new c(callable));
    }

    public static <T> x<T> o(b0<T> b0Var) {
        b.e(b0Var, "source is null");
        if (b0Var instanceof x) {
            return a.o((x) b0Var);
        }
        return a.o(new d(b0Var));
    }

    @Override // io.reactivex.b0
    public final void a(z<? super T> zVar) {
        b.e(zVar, "observer is null");
        z<? super T> y = a.y(this, zVar);
        b.e(y, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            l(y);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final T c() {
        io.reactivex.internal.observers.c cVar = new io.reactivex.internal.observers.c();
        a(cVar);
        return (T) cVar.a();
    }

    public final <R> x<R> d(c0<? super T, ? extends R> c0Var) {
        return o(((c0) b.e(c0Var, "transformer is null")).a(this));
    }

    public final x<T> f(g<? super Throwable> gVar) {
        b.e(gVar, "onError is null");
        return a.o(new io.reactivex.h0.c.c.b(this, gVar));
    }

    public final m<T> i(l<? super T> lVar) {
        b.e(lVar, "predicate is null");
        return a.m(new e(this, lVar));
    }

    public final <R> q<R> j(j<? super T, ? extends t<? extends R>> jVar) {
        b.e(jVar, "mapper is null");
        return a.n(new io.reactivex.h0.c.b.b(this, jVar));
    }

    public final x<T> k(j<? super Throwable, ? extends b0<? extends T>> jVar) {
        b.e(jVar, "resumeFunctionInCaseOfError is null");
        return a.o(new io.reactivex.h0.c.c.e(this, jVar));
    }

    protected abstract void l(z<? super T> zVar);

    public final x<T> m(w wVar) {
        b.e(wVar, "scheduler is null");
        return a.o(new f(this, wVar));
    }

    public final q<T> n() {
        if (this instanceof io.reactivex.h0.b.c) {
            return ((io.reactivex.h0.b.c) this).b();
        }
        return a.n(new io.reactivex.h0.c.c.g(this));
    }
}

package io.reactivex.j0;

import e.b.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.g0.c;
import io.reactivex.g0.e;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.h;
import io.reactivex.m;
import io.reactivex.n;
import io.reactivex.q;
import io.reactivex.v;
import io.reactivex.w;
import io.reactivex.x;
import io.reactivex.z;
import java.util.concurrent.Callable;

/* compiled from: RxJavaPlugins.java */
/* loaded from: classes4.dex */
public final class a {
    static volatile g<? super Throwable> a;

    /* renamed from: b  reason: collision with root package name */
    static volatile j<? super Runnable, ? extends Runnable> f16244b;

    /* renamed from: c  reason: collision with root package name */
    static volatile j<? super Callable<w>, ? extends w> f16245c;

    /* renamed from: d  reason: collision with root package name */
    static volatile j<? super Callable<w>, ? extends w> f16246d;

    /* renamed from: e  reason: collision with root package name */
    static volatile j<? super Callable<w>, ? extends w> f16247e;

    /* renamed from: f  reason: collision with root package name */
    static volatile j<? super Callable<w>, ? extends w> f16248f;
    static volatile j<? super w, ? extends w> g;
    static volatile j<? super w, ? extends w> h;
    static volatile j<? super w, ? extends w> i;
    static volatile j<? super h, ? extends h> j;
    static volatile j<? super q, ? extends q> k;
    static volatile j<? super m, ? extends m> l;
    static volatile j<? super x, ? extends x> m;
    static volatile j<? super io.reactivex.a, ? extends io.reactivex.a> n;
    static volatile c<? super h, ? super b, ? extends b> o;
    static volatile c<? super m, ? super n, ? extends n> p;
    static volatile c<? super q, ? super v, ? extends v> q;
    static volatile c<? super x, ? super z, ? extends z> r;
    static volatile c<? super io.reactivex.a, ? super io.reactivex.c, ? extends io.reactivex.c> s;
    static volatile e t;
    static volatile boolean u;
    static volatile boolean v;

    public static void A(g<? super Throwable> gVar) {
        if (!u) {
            a = gVar;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    static void B(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    static <T, U, R> R a(c<T, U, R> cVar, T t2, U u2) {
        try {
            return cVar.apply(t2, u2);
        } catch (Throwable th) {
            throw io.reactivex.internal.util.e.e(th);
        }
    }

    static <T, R> R b(j<T, R> jVar, T t2) {
        try {
            return jVar.apply(t2);
        } catch (Throwable th) {
            throw io.reactivex.internal.util.e.e(th);
        }
    }

    static w c(j<? super Callable<w>, ? extends w> jVar, Callable<w> callable) {
        return (w) io.reactivex.h0.a.b.e(b(jVar, callable), "Scheduler Callable result can't be null");
    }

    static w d(Callable<w> callable) {
        try {
            return (w) io.reactivex.h0.a.b.e(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            throw io.reactivex.internal.util.e.e(th);
        }
    }

    public static w e(Callable<w> callable) {
        io.reactivex.h0.a.b.e(callable, "Scheduler Callable can't be null");
        j<? super Callable<w>, ? extends w> jVar = f16245c;
        if (jVar == null) {
            return d(callable);
        }
        return c(jVar, callable);
    }

    public static w f(Callable<w> callable) {
        io.reactivex.h0.a.b.e(callable, "Scheduler Callable can't be null");
        j<? super Callable<w>, ? extends w> jVar = f16247e;
        if (jVar == null) {
            return d(callable);
        }
        return c(jVar, callable);
    }

    public static w g(Callable<w> callable) {
        io.reactivex.h0.a.b.e(callable, "Scheduler Callable can't be null");
        j<? super Callable<w>, ? extends w> jVar = f16248f;
        if (jVar == null) {
            return d(callable);
        }
        return c(jVar, callable);
    }

    public static w h(Callable<w> callable) {
        io.reactivex.h0.a.b.e(callable, "Scheduler Callable can't be null");
        j<? super Callable<w>, ? extends w> jVar = f16246d;
        if (jVar == null) {
            return d(callable);
        }
        return c(jVar, callable);
    }

    static boolean i(Throwable th) {
        return (th instanceof OnErrorNotImplementedException) || (th instanceof MissingBackpressureException) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof CompositeException);
    }

    public static boolean j() {
        return v;
    }

    public static io.reactivex.a k(io.reactivex.a aVar) {
        j<? super io.reactivex.a, ? extends io.reactivex.a> jVar = n;
        return jVar != null ? (io.reactivex.a) b(jVar, aVar) : aVar;
    }

    public static <T> h<T> l(h<T> hVar) {
        j<? super h, ? extends h> jVar = j;
        return jVar != null ? (h) b(jVar, hVar) : hVar;
    }

    public static <T> m<T> m(m<T> mVar) {
        j<? super m, ? extends m> jVar = l;
        return jVar != null ? (m) b(jVar, mVar) : mVar;
    }

    public static <T> q<T> n(q<T> qVar) {
        j<? super q, ? extends q> jVar = k;
        return jVar != null ? (q) b(jVar, qVar) : qVar;
    }

    public static <T> x<T> o(x<T> xVar) {
        j<? super x, ? extends x> jVar = m;
        return jVar != null ? (x) b(jVar, xVar) : xVar;
    }

    public static boolean p() {
        e eVar = t;
        if (eVar == null) {
            return false;
        }
        try {
            return eVar.a();
        } catch (Throwable th) {
            throw io.reactivex.internal.util.e.e(th);
        }
    }

    public static w q(w wVar) {
        j<? super w, ? extends w> jVar = g;
        return jVar == null ? wVar : (w) b(jVar, wVar);
    }

    public static void r(Throwable th) {
        g<? super Throwable> gVar = a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!i(th)) {
            th = new UndeliverableException(th);
        }
        if (gVar != null) {
            try {
                gVar.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                B(th2);
            }
        }
        th.printStackTrace();
        B(th);
    }

    public static w s(w wVar) {
        j<? super w, ? extends w> jVar = i;
        return jVar == null ? wVar : (w) b(jVar, wVar);
    }

    public static Runnable t(Runnable runnable) {
        io.reactivex.h0.a.b.e(runnable, "run is null");
        j<? super Runnable, ? extends Runnable> jVar = f16244b;
        return jVar == null ? runnable : (Runnable) b(jVar, runnable);
    }

    public static w u(w wVar) {
        j<? super w, ? extends w> jVar = h;
        return jVar == null ? wVar : (w) b(jVar, wVar);
    }

    public static io.reactivex.c v(io.reactivex.a aVar, io.reactivex.c cVar) {
        c<? super io.reactivex.a, ? super io.reactivex.c, ? extends io.reactivex.c> cVar2 = s;
        return cVar2 != null ? (io.reactivex.c) a(cVar2, aVar, cVar) : cVar;
    }

    public static <T> n<? super T> w(m<T> mVar, n<? super T> nVar) {
        c<? super m, ? super n, ? extends n> cVar = p;
        return cVar != null ? (n) a(cVar, mVar, nVar) : nVar;
    }

    public static <T> v<? super T> x(q<T> qVar, v<? super T> vVar) {
        c<? super q, ? super v, ? extends v> cVar = q;
        return cVar != null ? (v) a(cVar, qVar, vVar) : vVar;
    }

    public static <T> z<? super T> y(x<T> xVar, z<? super T> zVar) {
        c<? super x, ? super z, ? extends z> cVar = r;
        return cVar != null ? (z) a(cVar, xVar, zVar) : zVar;
    }

    public static <T> b<? super T> z(h<T> hVar, b<? super T> bVar) {
        c<? super h, ? super b, ? extends b> cVar = o;
        return cVar != null ? (b) a(cVar, hVar, bVar) : bVar;
    }
}

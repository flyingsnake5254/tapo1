package io.reactivex;

import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.g0.l;
import io.reactivex.h0.a.b;
import io.reactivex.h0.c.a.d;
import io.reactivex.h0.c.a.e;
import io.reactivex.h0.c.a.f;
import io.reactivex.h0.c.a.h;
import io.reactivex.h0.c.a.i;
import io.reactivex.h0.c.a.j;
import io.reactivex.h0.c.a.k;
import io.reactivex.h0.c.a.m;
import io.reactivex.h0.c.a.n;
import io.reactivex.h0.c.a.o;
import io.reactivex.h0.c.a.p;
import io.reactivex.h0.c.a.q;
import io.reactivex.h0.c.a.r;
import io.reactivex.h0.c.a.s;
import io.reactivex.internal.observers.CallbackCompletableObserver;
import io.reactivex.internal.observers.EmptyCompletableObserver;
import java.util.concurrent.TimeUnit;

/* compiled from: Completable.java */
/* loaded from: classes4.dex */
public abstract class a implements e {
    private a E(long j, TimeUnit timeUnit, w wVar, e eVar) {
        b.e(timeUnit, "unit is null");
        b.e(wVar, "scheduler is null");
        return io.reactivex.j0.a.k(new p(this, j, timeUnit, wVar, eVar));
    }

    public static a F(long j, TimeUnit timeUnit) {
        return G(j, timeUnit, io.reactivex.l0.a.a());
    }

    public static a G(long j, TimeUnit timeUnit, w wVar) {
        b.e(timeUnit, "unit is null");
        b.e(wVar, "scheduler is null");
        return io.reactivex.j0.a.k(new q(j, timeUnit, wVar));
    }

    private static NullPointerException I(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    public static a K(e eVar) {
        b.e(eVar, "source is null");
        if (eVar instanceof a) {
            return io.reactivex.j0.a.k((a) eVar);
        }
        return io.reactivex.j0.a.k(new h(eVar));
    }

    public static a e() {
        return io.reactivex.j0.a.k(d.f15661c);
    }

    public static a g(d dVar) {
        b.e(dVar, "source is null");
        return io.reactivex.j0.a.k(new io.reactivex.h0.c.a.b(dVar));
    }

    private a k(g<? super c> gVar, g<? super Throwable> gVar2, io.reactivex.g0.a aVar, io.reactivex.g0.a aVar2, io.reactivex.g0.a aVar3, io.reactivex.g0.a aVar4) {
        b.e(gVar, "onSubscribe is null");
        b.e(gVar2, "onError is null");
        b.e(aVar, "onComplete is null");
        b.e(aVar2, "onTerminate is null");
        b.e(aVar3, "onAfterTerminate is null");
        b.e(aVar4, "onDispose is null");
        return io.reactivex.j0.a.k(new m(this, gVar, gVar2, aVar, aVar2, aVar3, aVar4));
    }

    public static a m(Throwable th) {
        b.e(th, "error is null");
        return io.reactivex.j0.a.k(new e(th));
    }

    public static a n(io.reactivex.g0.a aVar) {
        b.e(aVar, "run is null");
        return io.reactivex.j0.a.k(new f(aVar));
    }

    public static <T> a o(e.b.a<T> aVar) {
        b.e(aVar, "publisher is null");
        return io.reactivex.j0.a.k(new io.reactivex.h0.c.a.g(aVar));
    }

    public static a p(Iterable<? extends e> iterable) {
        b.e(iterable, "sources is null");
        return io.reactivex.j0.a.k(new j(iterable));
    }

    public static a q(e... eVarArr) {
        b.e(eVarArr, "sources is null");
        return io.reactivex.j0.a.k(new i(eVarArr));
    }

    public final c A(io.reactivex.g0.a aVar, g<? super Throwable> gVar) {
        b.e(gVar, "onError is null");
        b.e(aVar, "onComplete is null");
        CallbackCompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(gVar, aVar);
        a(callbackCompletableObserver);
        return callbackCompletableObserver;
    }

    protected abstract void B(c cVar);

    public final a C(w wVar) {
        b.e(wVar, "scheduler is null");
        return io.reactivex.j0.a.k(new o(this, wVar));
    }

    public final a D(long j, TimeUnit timeUnit) {
        return E(j, timeUnit, io.reactivex.l0.a.a(), null);
    }

    public final <T> h<T> H() {
        if (this instanceof io.reactivex.h0.b.b) {
            return ((io.reactivex.h0.b.b) this).a();
        }
        return io.reactivex.j0.a.l(new r(this));
    }

    public final <T> q<T> J() {
        if (this instanceof io.reactivex.h0.b.c) {
            return ((io.reactivex.h0.b.c) this).b();
        }
        return io.reactivex.j0.a.n(new s(this));
    }

    @Override // io.reactivex.e
    public final void a(c cVar) {
        b.e(cVar, "observer is null");
        try {
            c v = io.reactivex.j0.a.v(this, cVar);
            b.e(v, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            B(v);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            io.reactivex.j0.a.r(th);
            throw I(th);
        }
    }

    public final a c(e eVar) {
        b.e(eVar, "next is null");
        return io.reactivex.j0.a.k(new io.reactivex.h0.c.a.a(this, eVar));
    }

    public final <T> q<T> d(t<T> tVar) {
        b.e(tVar, "next is null");
        return io.reactivex.j0.a.n(new io.reactivex.h0.c.b.a(this, tVar));
    }

    public final a f(f fVar) {
        return K(((f) b.e(fVar, "transformer is null")).a(this));
    }

    public final a h(io.reactivex.g0.a aVar) {
        b.e(aVar, "onFinally is null");
        return io.reactivex.j0.a.k(new io.reactivex.h0.c.a.c(this, aVar));
    }

    public final a i(io.reactivex.g0.a aVar) {
        g<? super c> f2 = io.reactivex.h0.a.a.f();
        g<? super Throwable> f3 = io.reactivex.h0.a.a.f();
        io.reactivex.g0.a aVar2 = io.reactivex.h0.a.a.f15635c;
        return k(f2, f3, aVar, aVar2, aVar2, aVar2);
    }

    public final a j(g<? super Throwable> gVar) {
        g<? super c> f2 = io.reactivex.h0.a.a.f();
        io.reactivex.g0.a aVar = io.reactivex.h0.a.a.f15635c;
        return k(f2, gVar, aVar, aVar, aVar, aVar);
    }

    public final a l(g<? super c> gVar) {
        g<? super Throwable> f2 = io.reactivex.h0.a.a.f();
        io.reactivex.g0.a aVar = io.reactivex.h0.a.a.f15635c;
        return k(gVar, f2, aVar, aVar, aVar, aVar);
    }

    public final a r(w wVar) {
        b.e(wVar, "scheduler is null");
        return io.reactivex.j0.a.k(new k(this, wVar));
    }

    public final a s() {
        return t(io.reactivex.h0.a.a.b());
    }

    public final a t(l<? super Throwable> lVar) {
        b.e(lVar, "predicate is null");
        return io.reactivex.j0.a.k(new io.reactivex.h0.c.a.l(this, lVar));
    }

    public final a u(io.reactivex.g0.j<? super Throwable, ? extends e> jVar) {
        b.e(jVar, "errorMapper is null");
        return io.reactivex.j0.a.k(new n(this, jVar));
    }

    public final a v(long j, l<? super Throwable> lVar) {
        return o(H().D(j, lVar));
    }

    public final a w(io.reactivex.g0.j<? super h<Throwable>, ? extends e.b.a<?>> jVar) {
        return o(H().E(jVar));
    }

    public final <T> q<T> x(q<T> qVar) {
        b.e(qVar, "other is null");
        return qVar.l(J());
    }

    public final c y() {
        EmptyCompletableObserver emptyCompletableObserver = new EmptyCompletableObserver();
        a(emptyCompletableObserver);
        return emptyCompletableObserver;
    }

    public final c z(io.reactivex.g0.a aVar) {
        b.e(aVar, "onComplete is null");
        CallbackCompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(aVar);
        a(callbackCompletableObserver);
        return callbackCompletableObserver;
    }
}

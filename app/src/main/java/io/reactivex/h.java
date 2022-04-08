package io.reactivex;

import e.b.a;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.g0.k;
import io.reactivex.g0.l;
import io.reactivex.internal.operators.flowable.a0;
import io.reactivex.internal.operators.flowable.b;
import io.reactivex.internal.operators.flowable.b0;
import io.reactivex.internal.operators.flowable.c;
import io.reactivex.internal.operators.flowable.c0;
import io.reactivex.internal.operators.flowable.d;
import io.reactivex.internal.operators.flowable.e;
import io.reactivex.internal.operators.flowable.f;
import io.reactivex.internal.operators.flowable.i;
import io.reactivex.internal.operators.flowable.m;
import io.reactivex.internal.operators.flowable.p;
import io.reactivex.internal.operators.flowable.q;
import io.reactivex.internal.operators.flowable.r;
import io.reactivex.internal.operators.flowable.s;
import io.reactivex.internal.operators.flowable.u;
import io.reactivex.internal.operators.flowable.v;
import io.reactivex.internal.operators.flowable.y;
import io.reactivex.internal.operators.flowable.z;
import io.reactivex.internal.subscribers.StrictSubscriber;
import java.util.concurrent.Callable;

/* compiled from: Flowable.java */
/* loaded from: classes4.dex */
public abstract class h<T> implements a<T> {

    /* renamed from: c  reason: collision with root package name */
    static final int f15633c = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    public static int c() {
        return f15633c;
    }

    public static <T> h<T> e(a<? extends T>... aVarArr) {
        if (aVarArr.length == 0) {
            return m();
        }
        if (aVarArr.length == 1) {
            return u(aVarArr[0]);
        }
        return io.reactivex.j0.a.l(new b(aVarArr, false));
    }

    public static <T> h<T> f(j<T> jVar, BackpressureStrategy backpressureStrategy) {
        io.reactivex.h0.a.b.e(jVar, "source is null");
        io.reactivex.h0.a.b.e(backpressureStrategy, "mode is null");
        return io.reactivex.j0.a.l(new c(jVar, backpressureStrategy));
    }

    private h<T> j(g<? super T> gVar, g<? super Throwable> gVar2, io.reactivex.g0.a aVar, io.reactivex.g0.a aVar2) {
        io.reactivex.h0.a.b.e(gVar, "onNext is null");
        io.reactivex.h0.a.b.e(gVar2, "onError is null");
        io.reactivex.h0.a.b.e(aVar, "onComplete is null");
        io.reactivex.h0.a.b.e(aVar2, "onAfterTerminate is null");
        return io.reactivex.j0.a.l(new e(this, gVar, gVar2, aVar, aVar2));
    }

    public static <T> h<T> m() {
        return io.reactivex.j0.a.l(io.reactivex.internal.operators.flowable.g.f15796d);
    }

    public static <T> h<T> n(Throwable th) {
        io.reactivex.h0.a.b.e(th, "throwable is null");
        return o(io.reactivex.h0.a.a.h(th));
    }

    public static <T> h<T> o(Callable<? extends Throwable> callable) {
        io.reactivex.h0.a.b.e(callable, "supplier is null");
        return io.reactivex.j0.a.l(new io.reactivex.internal.operators.flowable.h(callable));
    }

    public static <T> h<T> u(a<? extends T> aVar) {
        if (aVar instanceof h) {
            return io.reactivex.j0.a.l((h) aVar);
        }
        io.reactivex.h0.a.b.e(aVar, "source is null");
        return io.reactivex.j0.a.l(new m(aVar));
    }

    public static <T> h<T> v(T t) {
        io.reactivex.h0.a.b.e(t, "item is null");
        return io.reactivex.j0.a.l(new p(t));
    }

    public final h<T> A() {
        return io.reactivex.j0.a.l(new s(this));
    }

    public final h<T> B() {
        return io.reactivex.j0.a.l(new u(this));
    }

    public final h<T> C(j<? super Throwable, ? extends a<? extends T>> jVar) {
        io.reactivex.h0.a.b.e(jVar, "resumeFunction is null");
        return io.reactivex.j0.a.l(new v(this, jVar, false));
    }

    public final h<T> D(long j, l<? super Throwable> lVar) {
        if (j >= 0) {
            io.reactivex.h0.a.b.e(lVar, "predicate is null");
            return io.reactivex.j0.a.l(new y(this, j, lVar));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j);
    }

    public final h<T> E(j<? super h<Throwable>, ? extends a<?>> jVar) {
        io.reactivex.h0.a.b.e(jVar, "handler is null");
        return io.reactivex.j0.a.l(new z(this, jVar));
    }

    public final h<T> F(T t) {
        io.reactivex.h0.a.b.e(t, "value is null");
        return e(v(t), this);
    }

    public final void G(k<? super T> kVar) {
        io.reactivex.h0.a.b.e(kVar, "s is null");
        try {
            e.b.b<? super T> z = io.reactivex.j0.a.z(this, kVar);
            io.reactivex.h0.a.b.e(z, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            H(z);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            io.reactivex.j0.a.r(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    protected abstract void H(e.b.b<? super T> bVar);

    public final h<T> I(w wVar) {
        io.reactivex.h0.a.b.e(wVar, "scheduler is null");
        return J(wVar, !(this instanceof c));
    }

    public final h<T> J(w wVar, boolean z) {
        io.reactivex.h0.a.b.e(wVar, "scheduler is null");
        return io.reactivex.j0.a.l(new b0(this, wVar, z));
    }

    public final q<T> K() {
        return io.reactivex.j0.a.n(new io.reactivex.internal.operators.observable.z(this));
    }

    public final h<T> L(w wVar) {
        io.reactivex.h0.a.b.e(wVar, "scheduler is null");
        return io.reactivex.j0.a.l(new c0(this, wVar));
    }

    @Override // e.b.a
    public final void a(e.b.b<? super T> bVar) {
        if (bVar instanceof k) {
            G((k) bVar);
            return;
        }
        io.reactivex.h0.a.b.e(bVar, "s is null");
        G(new StrictSubscriber(bVar));
    }

    public final <R> h<R> d(l<? super T, ? extends R> lVar) {
        return u(((l) io.reactivex.h0.a.b.e(lVar, "composer is null")).a(this));
    }

    public final h<T> g() {
        return h(io.reactivex.h0.a.a.g());
    }

    public final <K> h<T> h(j<? super T, K> jVar) {
        io.reactivex.h0.a.b.e(jVar, "keySelector is null");
        return io.reactivex.j0.a.l(new d(this, jVar, io.reactivex.h0.a.b.d()));
    }

    public final h<T> i(io.reactivex.g0.a aVar) {
        return l(io.reactivex.h0.a.a.f(), io.reactivex.h0.a.a.g, aVar);
    }

    public final h<T> k(g<? super Throwable> gVar) {
        g<? super T> f2 = io.reactivex.h0.a.a.f();
        io.reactivex.g0.a aVar = io.reactivex.h0.a.a.f15635c;
        return j(f2, gVar, aVar, aVar);
    }

    public final h<T> l(g<? super e.b.c> gVar, k kVar, io.reactivex.g0.a aVar) {
        io.reactivex.h0.a.b.e(gVar, "onSubscribe is null");
        io.reactivex.h0.a.b.e(kVar, "onRequest is null");
        io.reactivex.h0.a.b.e(aVar, "onCancel is null");
        return io.reactivex.j0.a.l(new f(this, gVar, kVar, aVar));
    }

    public final h<T> p(l<? super T> lVar) {
        io.reactivex.h0.a.b.e(lVar, "predicate is null");
        return io.reactivex.j0.a.l(new i(this, lVar));
    }

    public final <R> h<R> q(j<? super T, ? extends a<? extends R>> jVar) {
        return r(jVar, false, c(), c());
    }

    public final <R> h<R> r(j<? super T, ? extends a<? extends R>> jVar, boolean z, int i, int i2) {
        io.reactivex.h0.a.b.e(jVar, "mapper is null");
        io.reactivex.h0.a.b.f(i, "maxConcurrency");
        io.reactivex.h0.a.b.f(i2, "bufferSize");
        if (!(this instanceof io.reactivex.h0.b.g)) {
            return io.reactivex.j0.a.l(new io.reactivex.internal.operators.flowable.j(this, jVar, z, i, i2));
        }
        Object call = ((io.reactivex.h0.b.g) this).call();
        if (call == null) {
            return m();
        }
        return a0.a(call, jVar);
    }

    public final <R> h<R> s(j<? super T, ? extends o<? extends R>> jVar) {
        return t(jVar, false, Integer.MAX_VALUE);
    }

    public final <R> h<R> t(j<? super T, ? extends o<? extends R>> jVar, boolean z, int i) {
        io.reactivex.h0.a.b.e(jVar, "mapper is null");
        io.reactivex.h0.a.b.f(i, "maxConcurrency");
        return io.reactivex.j0.a.l(new io.reactivex.internal.operators.flowable.k(this, jVar, z, i));
    }

    public final h<T> w(w wVar) {
        return x(wVar, false, c());
    }

    public final h<T> x(w wVar, boolean z, int i) {
        io.reactivex.h0.a.b.e(wVar, "scheduler is null");
        io.reactivex.h0.a.b.f(i, "bufferSize");
        return io.reactivex.j0.a.l(new q(this, wVar, z, i));
    }

    public final h<T> y() {
        return z(c(), false, true);
    }

    public final h<T> z(int i, boolean z, boolean z2) {
        io.reactivex.h0.a.b.f(i, "capacity");
        return io.reactivex.j0.a.l(new r(this, i, z2, z, io.reactivex.h0.a.a.f15635c));
    }
}

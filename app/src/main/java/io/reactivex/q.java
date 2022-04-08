package io.reactivex;

import io.reactivex.g0.c;
import io.reactivex.g0.g;
import io.reactivex.g0.h;
import io.reactivex.g0.i;
import io.reactivex.g0.j;
import io.reactivex.h0.a.b;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.internal.operators.observable.a0;
import io.reactivex.internal.operators.observable.a1;
import io.reactivex.internal.operators.observable.b1;
import io.reactivex.internal.operators.observable.c1;
import io.reactivex.internal.operators.observable.d;
import io.reactivex.internal.operators.observable.d0;
import io.reactivex.internal.operators.observable.d1;
import io.reactivex.internal.operators.observable.e;
import io.reactivex.internal.operators.observable.e0;
import io.reactivex.internal.operators.observable.f;
import io.reactivex.internal.operators.observable.f0;
import io.reactivex.internal.operators.observable.f1;
import io.reactivex.internal.operators.observable.g0;
import io.reactivex.internal.operators.observable.g1;
import io.reactivex.internal.operators.observable.h0;
import io.reactivex.internal.operators.observable.h1;
import io.reactivex.internal.operators.observable.i0;
import io.reactivex.internal.operators.observable.j0;
import io.reactivex.internal.operators.observable.k;
import io.reactivex.internal.operators.observable.k0;
import io.reactivex.internal.operators.observable.l;
import io.reactivex.internal.operators.observable.l0;
import io.reactivex.internal.operators.observable.m0;
import io.reactivex.internal.operators.observable.n;
import io.reactivex.internal.operators.observable.n0;
import io.reactivex.internal.operators.observable.o;
import io.reactivex.internal.operators.observable.o0;
import io.reactivex.internal.operators.observable.p;
import io.reactivex.internal.operators.observable.p0;
import io.reactivex.internal.operators.observable.q0;
import io.reactivex.internal.operators.observable.r;
import io.reactivex.internal.operators.observable.r0;
import io.reactivex.internal.operators.observable.s0;
import io.reactivex.internal.operators.observable.t;
import io.reactivex.internal.operators.observable.t0;
import io.reactivex.internal.operators.observable.u;
import io.reactivex.internal.operators.observable.u0;
import io.reactivex.internal.operators.observable.v;
import io.reactivex.internal.operators.observable.v0;
import io.reactivex.internal.operators.observable.w;
import io.reactivex.internal.operators.observable.w0;
import io.reactivex.internal.operators.observable.x;
import io.reactivex.internal.operators.observable.x0;
import io.reactivex.internal.operators.observable.y;
import io.reactivex.internal.operators.observable.y0;
import io.reactivex.internal.operators.observable.z0;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.internal.util.ErrorMode;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: Observable.java */
/* loaded from: classes4.dex */
public abstract class q<T> implements t<T> {

    /* compiled from: Observable.java */
    /* loaded from: classes4.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[BackpressureStrategy.values().length];
            a = iArr;
            try {
                iArr[BackpressureStrategy.DROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BackpressureStrategy.LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[BackpressureStrategy.MISSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[BackpressureStrategy.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private q<T> B(g<? super T> gVar, g<? super Throwable> gVar2, io.reactivex.g0.a aVar, io.reactivex.g0.a aVar2) {
        b.e(gVar, "onNext is null");
        b.e(gVar2, "onError is null");
        b.e(aVar, "onComplete is null");
        b.e(aVar2, "onAfterTerminate is null");
        return io.reactivex.j0.a.n(new k(this, gVar, gVar2, aVar, aVar2));
    }

    public static <T> q<T> I() {
        return io.reactivex.j0.a.n(o.f16051c);
    }

    public static <T> q<T> J(Throwable th) {
        b.e(th, "exception is null");
        return K(io.reactivex.h0.a.a.h(th));
    }

    public static <T> q<T> K(Callable<? extends Throwable> callable) {
        b.e(callable, "errorSupplier is null");
        return io.reactivex.j0.a.n(new p(callable));
    }

    private q<T> V0(long j, TimeUnit timeUnit, t<? extends T> tVar, w wVar) {
        b.e(timeUnit, "timeUnit is null");
        b.e(wVar, "scheduler is null");
        return io.reactivex.j0.a.n(new c1(this, j, timeUnit, wVar, tVar));
    }

    public static <T> q<T> W(T... tArr) {
        b.e(tArr, "items is null");
        if (tArr.length == 0) {
            return I();
        }
        if (tArr.length == 1) {
            return f0(tArr[0]);
        }
        return io.reactivex.j0.a.n(new w(tArr));
    }

    public static q<Long> W0(long j, TimeUnit timeUnit) {
        return X0(j, timeUnit, io.reactivex.l0.a.a());
    }

    public static <T> q<T> X(Callable<? extends T> callable) {
        b.e(callable, "supplier is null");
        return io.reactivex.j0.a.n(new x(callable));
    }

    public static q<Long> X0(long j, TimeUnit timeUnit, w wVar) {
        b.e(timeUnit, "unit is null");
        b.e(wVar, "scheduler is null");
        return io.reactivex.j0.a.n(new d1(Math.max(j, 0L), timeUnit, wVar));
    }

    public static <T> q<T> Y(Iterable<? extends T> iterable) {
        b.e(iterable, "source is null");
        return io.reactivex.j0.a.n(new y(iterable));
    }

    public static q<Long> a0(long j, long j2, TimeUnit timeUnit) {
        return b0(j, j2, timeUnit, io.reactivex.l0.a.a());
    }

    public static q<Long> b0(long j, long j2, TimeUnit timeUnit, w wVar) {
        b.e(timeUnit, "unit is null");
        b.e(wVar, "scheduler is null");
        return io.reactivex.j0.a.n(new f0(Math.max(0L, j), Math.max(0L, j2), timeUnit, wVar));
    }

    public static q<Long> c0(long j, TimeUnit timeUnit) {
        return b0(j, j, timeUnit, io.reactivex.l0.a.a());
    }

    public static <T> q<T> c1(t<T> tVar) {
        b.e(tVar, "source is null");
        if (tVar instanceof q) {
            return io.reactivex.j0.a.n((q) tVar);
        }
        return io.reactivex.j0.a.n(new a0(tVar));
    }

    public static int d() {
        return h.c();
    }

    public static q<Long> d0(long j, long j2, long j3, long j4, TimeUnit timeUnit) {
        return e0(j, j2, j3, j4, timeUnit, io.reactivex.l0.a.a());
    }

    public static <T1, T2, T3, T4, R> q<R> d1(t<? extends T1> tVar, t<? extends T2> tVar2, t<? extends T3> tVar3, t<? extends T4> tVar4, i<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> iVar) {
        b.e(tVar, "source1 is null");
        b.e(tVar2, "source2 is null");
        b.e(tVar3, "source3 is null");
        b.e(tVar4, "source4 is null");
        return h1(io.reactivex.h0.a.a.l(iVar), false, d(), tVar, tVar2, tVar3, tVar4);
    }

    public static q<Long> e0(long j, long j2, long j3, long j4, TimeUnit timeUnit, w wVar) {
        int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j2);
        } else if (i == 0) {
            return I().p(j3, timeUnit, wVar);
        } else {
            long j5 = j + (j2 - 1);
            if (j <= 0 || j5 >= 0) {
                b.e(timeUnit, "unit is null");
                b.e(wVar, "scheduler is null");
                return io.reactivex.j0.a.n(new g0(j, j5, Math.max(0L, j3), Math.max(0L, j4), timeUnit, wVar));
            }
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
    }

    public static <T1, T2, T3, R> q<R> e1(t<? extends T1> tVar, t<? extends T2> tVar2, t<? extends T3> tVar3, h<? super T1, ? super T2, ? super T3, ? extends R> hVar) {
        b.e(tVar, "source1 is null");
        b.e(tVar2, "source2 is null");
        b.e(tVar3, "source3 is null");
        return h1(io.reactivex.h0.a.a.k(hVar), false, d(), tVar, tVar2, tVar3);
    }

    public static <T1, T2, R> q<R> f(t<? extends T1> tVar, t<? extends T2> tVar2, c<? super T1, ? super T2, ? extends R> cVar) {
        b.e(tVar, "source1 is null");
        b.e(tVar2, "source2 is null");
        return g(io.reactivex.h0.a.a.j(cVar), d(), tVar, tVar2);
    }

    public static <T> q<T> f0(T t) {
        b.e(t, "item is null");
        return io.reactivex.j0.a.n(new h0(t));
    }

    public static <T1, T2, R> q<R> f1(t<? extends T1> tVar, t<? extends T2> tVar2, c<? super T1, ? super T2, ? extends R> cVar) {
        b.e(tVar, "source1 is null");
        b.e(tVar2, "source2 is null");
        return h1(io.reactivex.h0.a.a.j(cVar), false, d(), tVar, tVar2);
    }

    public static <T, R> q<R> g(j<? super Object[], ? extends R> jVar, int i, t<? extends T>... tVarArr) {
        return h(tVarArr, jVar, i);
    }

    public static <T, R> q<R> g1(Iterable<? extends t<? extends T>> iterable, j<? super Object[], ? extends R> jVar) {
        b.e(jVar, "zipper is null");
        b.e(iterable, "sources is null");
        return io.reactivex.j0.a.n(new h1(null, iterable, jVar, d(), false));
    }

    public static <T, R> q<R> h(t<? extends T>[] tVarArr, j<? super Object[], ? extends R> jVar, int i) {
        b.e(tVarArr, "sources is null");
        if (tVarArr.length == 0) {
            return I();
        }
        b.e(jVar, "combiner is null");
        b.f(i, "bufferSize");
        return io.reactivex.j0.a.n(new io.reactivex.internal.operators.observable.c(tVarArr, null, jVar, i << 1, false));
    }

    public static <T> q<T> h0(t<? extends T> tVar, t<? extends T> tVar2, t<? extends T> tVar3, t<? extends T> tVar4) {
        b.e(tVar, "source1 is null");
        b.e(tVar2, "source2 is null");
        b.e(tVar3, "source3 is null");
        b.e(tVar4, "source4 is null");
        return W(tVar, tVar2, tVar3, tVar4).P(io.reactivex.h0.a.a.g(), false, 4);
    }

    public static <T, R> q<R> h1(j<? super Object[], ? extends R> jVar, boolean z, int i, t<? extends T>... tVarArr) {
        if (tVarArr.length == 0) {
            return I();
        }
        b.e(jVar, "zipper is null");
        b.f(i, "bufferSize");
        return io.reactivex.j0.a.n(new h1(tVarArr, null, jVar, i, z));
    }

    public static <T> q<T> i0(t<? extends T>... tVarArr) {
        return W(tVarArr).P(io.reactivex.h0.a.a.g(), true, tVarArr.length);
    }

    public static <T> q<T> j(t<? extends T> tVar, t<? extends T> tVar2) {
        b.e(tVar, "source1 is null");
        b.e(tVar2, "source2 is null");
        return k(tVar, tVar2);
    }

    public static <T> q<T> j0(Iterable<? extends t<? extends T>> iterable) {
        return Y(iterable).O(io.reactivex.h0.a.a.g(), true);
    }

    public static <T> q<T> k(t<? extends T>... tVarArr) {
        if (tVarArr.length == 0) {
            return I();
        }
        if (tVarArr.length == 1) {
            return c1(tVarArr[0]);
        }
        return io.reactivex.j0.a.n(new d(W(tVarArr), io.reactivex.h0.a.a.g(), d(), ErrorMode.BOUNDARY));
    }

    public static <T> q<T> k0(Iterable<? extends t<? extends T>> iterable, int i) {
        return Y(iterable).P(io.reactivex.h0.a.a.g(), true, i);
    }

    public static <T> q<T> m(s<T> sVar) {
        b.e(sVar, "source is null");
        return io.reactivex.j0.a.n(new e(sVar));
    }

    public final q<T> A(io.reactivex.g0.a aVar) {
        return D(io.reactivex.h0.a.a.f(), aVar);
    }

    public final <R> q<R> A0(Callable<R> callable, c<R, ? super T, R> cVar) {
        b.e(callable, "seedSupplier is null");
        b.e(cVar, "accumulator is null");
        return io.reactivex.j0.a.n(new r0(this, callable, cVar));
    }

    public final m<T> B0() {
        return io.reactivex.j0.a.m(new s0(this));
    }

    public final q<T> C(g<? super Throwable> gVar) {
        g<? super T> f2 = io.reactivex.h0.a.a.f();
        io.reactivex.g0.a aVar = io.reactivex.h0.a.a.f15635c;
        return B(f2, gVar, aVar, aVar);
    }

    public final x<T> C0() {
        return io.reactivex.j0.a.o(new t0(this, null));
    }

    public final q<T> D(g<? super io.reactivex.e0.c> gVar, io.reactivex.g0.a aVar) {
        b.e(gVar, "onSubscribe is null");
        b.e(aVar, "onDispose is null");
        return io.reactivex.j0.a.n(new l(this, gVar, aVar));
    }

    public final q<T> D0(long j) {
        if (j <= 0) {
            return io.reactivex.j0.a.n(this);
        }
        return io.reactivex.j0.a.n(new u0(this, j));
    }

    public final q<T> E(g<? super T> gVar) {
        g<? super Throwable> f2 = io.reactivex.h0.a.a.f();
        io.reactivex.g0.a aVar = io.reactivex.h0.a.a.f15635c;
        return B(gVar, f2, aVar, aVar);
    }

    public final q<T> E0(T t) {
        b.e(t, "item is null");
        return k(f0(t), this);
    }

    public final q<T> F(g<? super io.reactivex.e0.c> gVar) {
        return D(gVar, io.reactivex.h0.a.a.f15635c);
    }

    public final io.reactivex.e0.c F0() {
        return J0(io.reactivex.h0.a.a.f(), io.reactivex.h0.a.a.f15638f, io.reactivex.h0.a.a.f15635c, io.reactivex.h0.a.a.f());
    }

    public final q<T> G(io.reactivex.g0.a aVar) {
        b.e(aVar, "onTerminate is null");
        return B(io.reactivex.h0.a.a.f(), io.reactivex.h0.a.a.a(aVar), aVar, io.reactivex.h0.a.a.f15635c);
    }

    public final io.reactivex.e0.c G0(g<? super T> gVar) {
        return J0(gVar, io.reactivex.h0.a.a.f15638f, io.reactivex.h0.a.a.f15635c, io.reactivex.h0.a.a.f());
    }

    public final m<T> H(long j) {
        if (j >= 0) {
            return io.reactivex.j0.a.m(new n(this, j));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j);
    }

    public final io.reactivex.e0.c H0(g<? super T> gVar, g<? super Throwable> gVar2) {
        return J0(gVar, gVar2, io.reactivex.h0.a.a.f15635c, io.reactivex.h0.a.a.f());
    }

    public final io.reactivex.e0.c I0(g<? super T> gVar, g<? super Throwable> gVar2, io.reactivex.g0.a aVar) {
        return J0(gVar, gVar2, aVar, io.reactivex.h0.a.a.f());
    }

    public final io.reactivex.e0.c J0(g<? super T> gVar, g<? super Throwable> gVar2, io.reactivex.g0.a aVar, g<? super io.reactivex.e0.c> gVar3) {
        b.e(gVar, "onNext is null");
        b.e(gVar2, "onError is null");
        b.e(aVar, "onComplete is null");
        b.e(gVar3, "onSubscribe is null");
        LambdaObserver lambdaObserver = new LambdaObserver(gVar, gVar2, aVar, gVar3);
        a(lambdaObserver);
        return lambdaObserver;
    }

    protected abstract void K0(v<? super T> vVar);

    public final q<T> L(io.reactivex.g0.l<? super T> lVar) {
        b.e(lVar, "predicate is null");
        return io.reactivex.j0.a.n(new io.reactivex.internal.operators.observable.q(this, lVar));
    }

    public final q<T> L0(w wVar) {
        b.e(wVar, "scheduler is null");
        return io.reactivex.j0.a.n(new v0(this, wVar));
    }

    public final m<T> M() {
        return H(0L);
    }

    public final <E extends v<? super T>> E M0(E e2) {
        a(e2);
        return e2;
    }

    public final <R> q<R> N(j<? super T, ? extends t<? extends R>> jVar) {
        return O(jVar, false);
    }

    public final q<T> N0(t<? extends T> tVar) {
        b.e(tVar, "other is null");
        return io.reactivex.j0.a.n(new w0(this, tVar));
    }

    public final <R> q<R> O(j<? super T, ? extends t<? extends R>> jVar, boolean z) {
        return P(jVar, z, Integer.MAX_VALUE);
    }

    public final <R> q<R> O0(j<? super T, ? extends t<? extends R>> jVar) {
        return P0(jVar, d());
    }

    public final <R> q<R> P(j<? super T, ? extends t<? extends R>> jVar, boolean z, int i) {
        return Q(jVar, z, i, d());
    }

    public final <R> q<R> P0(j<? super T, ? extends t<? extends R>> jVar, int i) {
        b.e(jVar, "mapper is null");
        b.f(i, "bufferSize");
        if (!(this instanceof io.reactivex.h0.b.g)) {
            return io.reactivex.j0.a.n(new x0(this, jVar, i, false));
        }
        Object call = ((io.reactivex.h0.b.g) this).call();
        if (call == null) {
            return I();
        }
        return ObservableScalarXMap.a(call, jVar);
    }

    public final <R> q<R> Q(j<? super T, ? extends t<? extends R>> jVar, boolean z, int i, int i2) {
        b.e(jVar, "mapper is null");
        b.f(i, "maxConcurrency");
        b.f(i2, "bufferSize");
        if (!(this instanceof io.reactivex.h0.b.g)) {
            return io.reactivex.j0.a.n(new r(this, jVar, z, i, i2));
        }
        Object call = ((io.reactivex.h0.b.g) this).call();
        if (call == null) {
            return I();
        }
        return ObservableScalarXMap.a(call, jVar);
    }

    public final q<T> Q0(long j) {
        if (j >= 0) {
            return io.reactivex.j0.a.n(new y0(this, j));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j);
    }

    public final a R(j<? super T, ? extends e> jVar) {
        return S(jVar, false);
    }

    public final q<T> R0(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("count >= 0 required but it was " + i);
        } else if (i == 0) {
            return io.reactivex.j0.a.n(new d0(this));
        } else {
            if (i == 1) {
                return io.reactivex.j0.a.n(new a1(this));
            }
            return io.reactivex.j0.a.n(new z0(this, i));
        }
    }

    public final a S(j<? super T, ? extends e> jVar, boolean z) {
        b.e(jVar, "mapper is null");
        return io.reactivex.j0.a.k(new t(this, jVar, z));
    }

    public final q<T> S0(io.reactivex.g0.l<? super T> lVar) {
        b.e(lVar, "stopPredicate is null");
        return io.reactivex.j0.a.n(new b1(this, lVar));
    }

    public final <U> q<U> T(j<? super T, ? extends Iterable<? extends U>> jVar) {
        b.e(jVar, "mapper is null");
        return io.reactivex.j0.a.n(new v(this, jVar));
    }

    public final q<T> T0(long j, TimeUnit timeUnit) {
        return V0(j, timeUnit, null, io.reactivex.l0.a.a());
    }

    public final <R> q<R> U(j<? super T, ? extends o<? extends R>> jVar) {
        return V(jVar, false);
    }

    public final q<T> U0(long j, TimeUnit timeUnit, t<? extends T> tVar) {
        b.e(tVar, "other is null");
        return V0(j, timeUnit, tVar, io.reactivex.l0.a.a());
    }

    public final <R> q<R> V(j<? super T, ? extends o<? extends R>> jVar, boolean z) {
        b.e(jVar, "mapper is null");
        return io.reactivex.j0.a.n(new u(this, jVar, z));
    }

    public final h<T> Y0(BackpressureStrategy backpressureStrategy) {
        io.reactivex.internal.operators.flowable.l lVar = new io.reactivex.internal.operators.flowable.l(this);
        int i = a.a[backpressureStrategy.ordinal()];
        if (i == 1) {
            return lVar.A();
        }
        if (i == 2) {
            return lVar.B();
        }
        if (i == 3) {
            return lVar;
        }
        if (i != 4) {
            return lVar.y();
        }
        return io.reactivex.j0.a.l(new io.reactivex.internal.operators.flowable.t(lVar));
    }

    public final a Z() {
        return io.reactivex.j0.a.k(new e0(this));
    }

    public final x<List<T>> Z0() {
        return a1(16);
    }

    @Override // io.reactivex.t
    public final void a(v<? super T> vVar) {
        b.e(vVar, "observer is null");
        try {
            v<? super T> x = io.reactivex.j0.a.x(this, vVar);
            b.e(x, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            K0(x);
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

    public final x<List<T>> a1(int i) {
        b.f(i, "capacityHint");
        return io.reactivex.j0.a.o(new f1(this, i));
    }

    public final <B> q<List<T>> b(t<B> tVar) {
        return (q<List<T>>) c(tVar, ArrayListSupplier.asCallable());
    }

    public final q<T> b1(w wVar) {
        b.e(wVar, "scheduler is null");
        return io.reactivex.j0.a.n(new g1(this, wVar));
    }

    public final <B, U extends Collection<? super T>> q<U> c(t<B> tVar, Callable<U> callable) {
        b.e(tVar, "boundary is null");
        b.e(callable, "bufferSupplier is null");
        return io.reactivex.j0.a.n(new io.reactivex.internal.operators.observable.b(this, tVar, callable));
    }

    public final <U> q<U> e(Class<U> cls) {
        b.e(cls, "clazz is null");
        return (q<U>) g0(io.reactivex.h0.a.a.c(cls));
    }

    public final <R> q<R> g0(j<? super T, ? extends R> jVar) {
        b.e(jVar, "mapper is null");
        return io.reactivex.j0.a.n(new i0(this, jVar));
    }

    public final <R> q<R> i(u<? super T, ? extends R> uVar) {
        return c1(((u) b.e(uVar, "composer is null")).a(this));
    }

    public final <U, R> q<R> i1(t<? extends U> tVar, c<? super T, ? super U, ? extends R> cVar) {
        b.e(tVar, "other is null");
        return f1(this, tVar, cVar);
    }

    public final q<T> l(t<? extends T> tVar) {
        b.e(tVar, "other is null");
        return j(this, tVar);
    }

    public final q<T> l0(w wVar) {
        return m0(wVar, false, d());
    }

    public final q<T> m0(w wVar, boolean z, int i) {
        b.e(wVar, "scheduler is null");
        b.f(i, "bufferSize");
        return io.reactivex.j0.a.n(new j0(this, wVar, z, i));
    }

    public final q<T> n(T t) {
        b.e(t, "defaultItem is null");
        return N0(f0(t));
    }

    public final q<T> n0(t<? extends T> tVar) {
        b.e(tVar, "next is null");
        return o0(io.reactivex.h0.a.a.i(tVar));
    }

    public final q<T> o(long j, TimeUnit timeUnit) {
        return q(j, timeUnit, io.reactivex.l0.a.a(), false);
    }

    public final q<T> o0(j<? super Throwable, ? extends t<? extends T>> jVar) {
        b.e(jVar, "resumeFunction is null");
        return io.reactivex.j0.a.n(new k0(this, jVar, false));
    }

    public final q<T> p(long j, TimeUnit timeUnit, w wVar) {
        return q(j, timeUnit, wVar, false);
    }

    public final q<T> p0(j<? super Throwable, ? extends T> jVar) {
        b.e(jVar, "valueSupplier is null");
        return io.reactivex.j0.a.n(new l0(this, jVar));
    }

    public final q<T> q(long j, TimeUnit timeUnit, w wVar, boolean z) {
        b.e(timeUnit, "unit is null");
        b.e(wVar, "scheduler is null");
        return io.reactivex.j0.a.n(new f(this, j, timeUnit, wVar, z));
    }

    public final q<T> q0(T t) {
        b.e(t, "item is null");
        return p0(io.reactivex.h0.a.a.i(t));
    }

    public final q<T> r(long j, TimeUnit timeUnit) {
        return s(j, timeUnit, io.reactivex.l0.a.a());
    }

    public final m<T> r0(c<T, T, T> cVar) {
        b.e(cVar, "reducer is null");
        return io.reactivex.j0.a.m(new m0(this, cVar));
    }

    public final q<T> s(long j, TimeUnit timeUnit, w wVar) {
        return t(X0(j, timeUnit, wVar));
    }

    public final q<T> s0(io.reactivex.g0.e eVar) {
        b.e(eVar, "stop is null");
        return io.reactivex.j0.a.n(new n0(this, eVar));
    }

    public final <U> q<T> t(t<U> tVar) {
        b.e(tVar, "other is null");
        return io.reactivex.j0.a.n(new io.reactivex.internal.operators.observable.g(this, tVar));
    }

    public final q<T> t0(j<? super q<Object>, ? extends t<?>> jVar) {
        b.e(jVar, "handler is null");
        return io.reactivex.j0.a.n(new o0(this, jVar));
    }

    public final <K> q<T> u(j<? super T, K> jVar) {
        return v(jVar, io.reactivex.h0.a.a.e());
    }

    public final q<T> u0(long j) {
        return v0(j, io.reactivex.h0.a.a.b());
    }

    public final <K> q<T> v(j<? super T, K> jVar, Callable<? extends Collection<? super K>> callable) {
        b.e(jVar, "keySelector is null");
        b.e(callable, "collectionSupplier is null");
        return io.reactivex.j0.a.n(new io.reactivex.internal.operators.observable.h(this, jVar, callable));
    }

    public final q<T> v0(long j, io.reactivex.g0.l<? super Throwable> lVar) {
        if (j >= 0) {
            b.e(lVar, "predicate is null");
            return io.reactivex.j0.a.n(new p0(this, j, lVar));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j);
    }

    public final q<T> w() {
        return x(io.reactivex.h0.a.a.g());
    }

    public final q<T> w0(io.reactivex.g0.l<? super Throwable> lVar) {
        return v0(Long.MAX_VALUE, lVar);
    }

    public final <K> q<T> x(j<? super T, K> jVar) {
        b.e(jVar, "keySelector is null");
        return io.reactivex.j0.a.n(new io.reactivex.internal.operators.observable.i(this, jVar, b.d()));
    }

    public final q<T> x0(j<? super q<Throwable>, ? extends t<?>> jVar) {
        b.e(jVar, "handler is null");
        return io.reactivex.j0.a.n(new q0(this, jVar));
    }

    public final q<T> y(io.reactivex.g0.a aVar) {
        b.e(aVar, "onFinally is null");
        return io.reactivex.j0.a.n(new io.reactivex.internal.operators.observable.j(this, aVar));
    }

    public final void y0(v<? super T> vVar) {
        b.e(vVar, "observer is null");
        if (vVar instanceof io.reactivex.observers.c) {
            a(vVar);
        } else {
            a(new io.reactivex.observers.c(vVar));
        }
    }

    public final q<T> z(io.reactivex.g0.a aVar) {
        return B(io.reactivex.h0.a.a.f(), io.reactivex.h0.a.a.f(), aVar, io.reactivex.h0.a.a.f15635c);
    }

    public final <R> q<R> z0(R r, c<R, ? super T, R> cVar) {
        b.e(r, "initialValue is null");
        return A0(io.reactivex.h0.a.a.h(r), cVar);
    }
}

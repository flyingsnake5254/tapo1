package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.f;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;
import kotlinx.coroutines.d1;
import kotlinx.coroutines.internal.s;

/* compiled from: CancellableContinuationImpl.kt */
/* loaded from: classes4.dex */
public class i<T> extends m0<T> implements h<T>, c {
    private static final AtomicIntegerFieldUpdater q = AtomicIntegerFieldUpdater.newUpdater(i.class, "_decision");
    private static final AtomicReferenceFieldUpdater x = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_state");
    private volatile int _decision = 0;
    private volatile Object _state = b.f16423c;
    private volatile o0 parentHandle;
    private final f y;
    private final kotlin.coroutines.c<T> z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public i(kotlin.coroutines.c<? super T> delegate, int i) {
        super(i);
        j.f(delegate, "delegate");
        this.z = delegate;
        this.y = delegate.getContext();
    }

    private final void k(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    private final void m(int i) {
        if (!y()) {
            l0.b(this, i);
        }
    }

    private final void n() {
        o0 o0Var = this.parentHandle;
        if (o0Var != null) {
            o0Var.dispose();
            this.parentHandle = o1.f16516c;
        }
    }

    private final void s() {
        d1 d1Var;
        if (!t() && (d1Var = (d1) this.z.getContext().get(d1.h)) != null) {
            d1Var.start();
            o0 d2 = d1.a.d(d1Var, true, false, new l(d1Var, this), 2, null);
            this.parentHandle = d2;
            if (t()) {
                d2.dispose();
                this.parentHandle = o1.f16516c;
            }
        }
    }

    private final f u(l<? super Throwable, p> lVar) {
        return lVar instanceof f ? (f) lVar : new a1(lVar);
    }

    private final void v(l<? super Throwable, p> lVar, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + lVar + ", already has " + obj).toString());
    }

    private final k x(Object obj, int i) {
        while (true) {
            Object obj2 = this._state;
            if (!(obj2 instanceof p1)) {
                if (obj2 instanceof k) {
                    k kVar = (k) obj2;
                    if (kVar.c()) {
                        return kVar;
                    }
                }
                k(obj);
            } else if (x.compareAndSet(this, obj2, obj)) {
                n();
                m(i);
                return null;
            }
        }
    }

    private final boolean y() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!q.compareAndSet(this, 0, 2));
        return true;
    }

    private final boolean z() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!q.compareAndSet(this, 0, 1));
        return true;
    }

    @Override // kotlinx.coroutines.h
    public Object b(T t, Object obj) {
        Object obj2;
        do {
            obj2 = this._state;
            if (!(obj2 instanceof p1)) {
                if (!(obj2 instanceof t)) {
                    return null;
                }
                t tVar = (t) obj2;
                if (tVar.a != obj) {
                    return null;
                }
                if (g0.a()) {
                    if (!(tVar.f16568b == t)) {
                        throw new AssertionError();
                    }
                }
                return tVar.f16569c;
            }
        } while (!x.compareAndSet(this, obj2, obj == null ? t : new t(obj, t, (p1) obj2)));
        n();
        return obj2;
    }

    @Override // kotlinx.coroutines.m0
    public void c(Object obj, Throwable cause) {
        j.f(cause, "cause");
        if (obj instanceof u) {
            try {
                ((u) obj).f16570b.invoke(cause);
            } catch (Throwable th) {
                f context = getContext();
                a0.a(context, new CompletionHandlerException("Exception in cancellation handler for " + this, th));
            }
        }
    }

    @Override // kotlinx.coroutines.m0
    public final kotlin.coroutines.c<T> d() {
        return this.z;
    }

    @Override // kotlinx.coroutines.h
    public void f(l<? super Throwable, p> handler) {
        j.f(handler, "handler");
        Throwable th = null;
        f fVar = null;
        while (true) {
            Object obj = this._state;
            if (obj instanceof b) {
                if (fVar == null) {
                    fVar = u(handler);
                }
                if (x.compareAndSet(this, obj, fVar)) {
                    return;
                }
            } else if (obj instanceof f) {
                v(handler, obj);
            } else if (obj instanceof k) {
                if (!((k) obj).b()) {
                    v(handler, obj);
                }
                try {
                    if (!(obj instanceof r)) {
                        obj = null;
                    }
                    r rVar = (r) obj;
                    if (rVar != null) {
                        th = rVar.f16526b;
                    }
                    handler.invoke(th);
                    return;
                } catch (Throwable th2) {
                    a0.a(getContext(), new CompletionHandlerException("Exception in cancellation handler for " + this, th2));
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.m0
    public <T> T g(Object obj) {
        return obj instanceof t ? (T) ((t) obj).f16568b : obj instanceof u ? (T) ((u) obj).a : obj;
    }

    @Override // kotlin.coroutines.jvm.internal.c
    public c getCallerFrame() {
        kotlin.coroutines.c<T> cVar = this.z;
        if (!(cVar instanceof c)) {
            cVar = null;
        }
        return (c) cVar;
    }

    @Override // kotlin.coroutines.c
    public f getContext() {
        return this.y;
    }

    @Override // kotlin.coroutines.jvm.internal.c
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.h
    public Object h(Throwable exception) {
        Object obj;
        j.f(exception, "exception");
        do {
            obj = this._state;
            if (!(obj instanceof p1)) {
                return null;
            }
        } while (!x.compareAndSet(this, obj, new r(exception, false, 2, null)));
        n();
        return obj;
    }

    @Override // kotlinx.coroutines.m0
    public Object j() {
        return r();
    }

    public boolean l(Throwable th) {
        Object obj;
        boolean z;
        do {
            obj = this._state;
            if (!(obj instanceof p1)) {
                return false;
            }
            z = obj instanceof f;
        } while (!x.compareAndSet(this, obj, new k(this, th, z)));
        if (z) {
            try {
                ((f) obj).a(th);
            } catch (Throwable th2) {
                f context = getContext();
                a0.a(context, new CompletionHandlerException("Exception in cancellation handler for " + this, th2));
            }
        }
        n();
        m(0);
        return true;
    }

    public Throwable o(d1 parent) {
        j.f(parent, "parent");
        return parent.i();
    }

    @Override // kotlinx.coroutines.h
    public void p(Object token) {
        j.f(token, "token");
        m(this.f16512f);
    }

    public final Object q() {
        d1 d1Var;
        Object d2;
        s();
        if (z()) {
            d2 = b.d();
            return d2;
        }
        Object r = r();
        if (r instanceof r) {
            throw s.k(((r) r).f16526b, this);
        } else if (this.f16512f != 1 || (d1Var = (d1) getContext().get(d1.h)) == null || d1Var.isActive()) {
            return g(r);
        } else {
            CancellationException i = d1Var.i();
            c(r, i);
            throw s.k(i, this);
        }
    }

    public final Object r() {
        return this._state;
    }

    @Override // kotlin.coroutines.c
    public void resumeWith(Object obj) {
        x(s.a(obj), this.f16512f);
    }

    public boolean t() {
        return !(r() instanceof p1);
    }

    public String toString() {
        return w() + '(' + h0.c(this.z) + "){" + r() + "}@" + h0.b(this);
    }

    protected String w() {
        return "CancellableContinuation";
    }
}

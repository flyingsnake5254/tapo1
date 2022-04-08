package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.TypeCastException;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.g0;

/* compiled from: LockFreeLinkedList.kt */
/* loaded from: classes4.dex */
public class i {

    /* renamed from: c  reason: collision with root package name */
    static final AtomicReferenceFieldUpdater f16476c = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_next");

    /* renamed from: d  reason: collision with root package name */
    static final AtomicReferenceFieldUpdater f16477d = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_prev");

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f16478f = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_removedRef");
    volatile Object _next = this;
    volatile Object _prev = this;
    private volatile Object _removedRef = null;

    /* compiled from: LockFreeLinkedList.kt */
    /* loaded from: classes4.dex */
    public static abstract class a extends b {

        /* compiled from: LockFreeLinkedList.kt */
        /* renamed from: kotlinx.coroutines.internal.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        private static final class C0327a extends o {
            public final i a;

            /* renamed from: b  reason: collision with root package name */
            public final d<i> f16479b;

            /* renamed from: c  reason: collision with root package name */
            public final a f16480c;

            /* JADX WARN: Multi-variable type inference failed */
            public C0327a(i next, d<? super i> op, a desc) {
                j.f(next, "next");
                j.f(op, "op");
                j.f(desc, "desc");
                this.a = next;
                this.f16479b = op;
                this.f16480c = desc;
            }

            @Override // kotlinx.coroutines.internal.o
            public Object a(Object obj) {
                if (obj != null) {
                    i iVar = (i) obj;
                    Object g = this.f16480c.g(iVar, this.a);
                    if (g != null) {
                        if (g == h.a()) {
                            if (i.f16476c.compareAndSet(iVar, this, this.a.J())) {
                                iVar.E();
                            }
                        } else {
                            this.f16479b.f(g);
                            i.f16476c.compareAndSet(iVar, this, this.a);
                        }
                        return g;
                    }
                    i.f16476c.compareAndSet(iVar, this, this.f16479b.d() ? this.a : this.f16479b);
                    return null;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        }

        @Override // kotlinx.coroutines.internal.b
        public final void a(d<?> op, Object obj) {
            j.f(op, "op");
            boolean z = obj == null;
            i e2 = e();
            if (e2 != null) {
                i f2 = f();
                if (f2 != null) {
                    if (i.f16476c.compareAndSet(e2, op, z ? j(e2, f2) : f2) && z) {
                        d(e2, f2);
                    }
                } else if (g0.a() && !(!z)) {
                    throw new AssertionError();
                }
            } else if (g0.a() && !(!z)) {
                throw new AssertionError();
            }
        }

        @Override // kotlinx.coroutines.internal.b
        public final Object b(d<?> op) {
            Object a;
            j.f(op, "op");
            while (true) {
                i i = i(op);
                Object obj = i._next;
                if (obj == op || op.d()) {
                    return null;
                }
                if (obj instanceof o) {
                    ((o) obj).a(i);
                } else {
                    Object c2 = c(i);
                    if (c2 != null) {
                        return c2;
                    }
                    if (h(i, obj)) {
                        continue;
                    } else if (obj != null) {
                        C0327a aVar = new C0327a((i) obj, op, this);
                        if (i.f16476c.compareAndSet(i, obj, aVar) && (a = aVar.a(i)) != h.a()) {
                            return a;
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                    }
                }
            }
        }

        protected abstract Object c(i iVar);

        protected abstract void d(i iVar, i iVar2);

        protected abstract i e();

        protected abstract i f();

        protected abstract Object g(i iVar, i iVar2);

        protected abstract boolean h(i iVar, Object obj);

        protected abstract i i(o oVar);

        protected abstract Object j(i iVar, i iVar2);
    }

    /* compiled from: LockFreeLinkedList.kt */
    /* loaded from: classes4.dex */
    public static abstract class b extends d<i> {

        /* renamed from: b  reason: collision with root package name */
        public i f16481b;

        /* renamed from: c  reason: collision with root package name */
        public final i f16482c;

        public b(i newNode) {
            j.f(newNode, "newNode");
            this.f16482c = newNode;
        }

        /* renamed from: g */
        public void b(i affected, Object obj) {
            j.f(affected, "affected");
            boolean z = obj == null;
            i iVar = z ? this.f16482c : this.f16481b;
            if (iVar != null && i.f16476c.compareAndSet(affected, this, iVar) && z) {
                i iVar2 = this.f16482c;
                i iVar3 = this.f16481b;
                if (iVar3 == null) {
                    j.n();
                }
                iVar2.y(iVar3);
            }
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    /* loaded from: classes4.dex */
    public static class c<T> extends a {
        private static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_affectedNode");

        /* renamed from: b  reason: collision with root package name */
        private static final AtomicReferenceFieldUpdater f16483b = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_originalNext");
        private volatile Object _affectedNode = null;
        private volatile Object _originalNext = null;

        /* renamed from: c  reason: collision with root package name */
        public final i f16484c;

        public c(i queue) {
            j.f(queue, "queue");
            this.f16484c = queue;
        }

        @Override // kotlinx.coroutines.internal.i.a
        protected Object c(i affected) {
            j.f(affected, "affected");
            if (affected == this.f16484c) {
                return h.c();
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.i.a
        protected final void d(i affected, i next) {
            j.f(affected, "affected");
            j.f(next, "next");
            affected.z(next);
        }

        @Override // kotlinx.coroutines.internal.i.a
        protected final i e() {
            return (i) this._affectedNode;
        }

        @Override // kotlinx.coroutines.internal.i.a
        protected final i f() {
            return (i) this._originalNext;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.internal.i.a
        protected final Object g(i affected, i next) {
            j.f(affected, "affected");
            j.f(next, "next");
            if (g0.a() && !(!(affected instanceof g))) {
                throw new AssertionError();
            } else if (!l(affected)) {
                return h.a();
            } else {
                a.compareAndSet(this, null, affected);
                f16483b.compareAndSet(this, null, next);
                return null;
            }
        }

        @Override // kotlinx.coroutines.internal.i.a
        protected final boolean h(i affected, Object next) {
            j.f(affected, "affected");
            j.f(next, "next");
            if (!(next instanceof p)) {
                return false;
            }
            affected.E();
            return true;
        }

        @Override // kotlinx.coroutines.internal.i.a
        protected final i i(o op) {
            j.f(op, "op");
            Object A = this.f16484c.A();
            if (A != null) {
                return (i) A;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        }

        @Override // kotlinx.coroutines.internal.i.a
        protected final Object j(i affected, i next) {
            j.f(affected, "affected");
            j.f(next, "next");
            return next.J();
        }

        public final T k() {
            T t = (T) e();
            if (t == null) {
                j.n();
            }
            return t;
        }

        protected boolean l(T t) {
            return true;
        }
    }

    private final i H() {
        Object obj;
        i iVar;
        do {
            obj = this._prev;
            if (obj instanceof p) {
                return ((p) obj).a;
            }
            if (obj == this) {
                iVar = x();
            } else if (obj != null) {
                iVar = (i) obj;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        } while (!f16477d.compareAndSet(this, obj, iVar.J()));
        return (i) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final p J() {
        p pVar = (p) this._removedRef;
        if (pVar != null) {
            return pVar;
        }
        p pVar2 = new p(this);
        f16478f.lazySet(this, pVar2);
        return pVar2;
    }

    private final i w(i iVar, o oVar) {
        Object obj;
        while (true) {
            i iVar2 = null;
            while (true) {
                obj = iVar._next;
                if (obj == oVar) {
                    return iVar;
                }
                if (obj instanceof o) {
                    ((o) obj).a(iVar);
                } else if (!(obj instanceof p)) {
                    Object obj2 = this._prev;
                    if (obj2 instanceof p) {
                        return null;
                    }
                    if (obj != this) {
                        if (obj != null) {
                            iVar2 = iVar;
                            iVar = (i) obj;
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                        }
                    } else if (obj2 == iVar) {
                        return null;
                    } else {
                        if (f16477d.compareAndSet(this, obj2, iVar) && !(iVar._prev instanceof p)) {
                            return null;
                        }
                    }
                } else if (iVar2 != null) {
                    break;
                } else {
                    iVar = h.d(iVar._prev);
                }
            }
            iVar.H();
            f16476c.compareAndSet(iVar2, iVar, ((p) obj).a);
            iVar = iVar2;
        }
    }

    private final i x() {
        i iVar = this;
        while (!(iVar instanceof g)) {
            iVar = iVar.B();
            if (g0.a()) {
                if (!(iVar != this)) {
                    throw new AssertionError();
                }
            }
        }
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(i iVar) {
        Object obj;
        do {
            obj = iVar._prev;
            if ((obj instanceof p) || A() != iVar) {
                return;
            }
        } while (!f16477d.compareAndSet(iVar, obj, this));
        if (!(A() instanceof p)) {
            return;
        }
        if (obj != null) {
            iVar.w((i) obj, null);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(i iVar) {
        E();
        iVar.w(h.d(this._prev), null);
    }

    public final Object A() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof o)) {
                return obj;
            }
            ((o) obj).a(this);
        }
    }

    public final i B() {
        return h.d(A());
    }

    public final Object C() {
        while (true) {
            Object obj = this._prev;
            if (obj instanceof p) {
                return obj;
            }
            if (obj != null) {
                i iVar = (i) obj;
                if (iVar.A() == this) {
                    return obj;
                }
                w(iVar, null);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        }
    }

    public final i D() {
        return h.d(C());
    }

    public final void E() {
        Object A;
        i H = H();
        Object obj = this._next;
        if (obj != null) {
            i iVar = ((p) obj).a;
            i iVar2 = null;
            while (true) {
                while (true) {
                    Object A2 = iVar.A();
                    if (A2 instanceof p) {
                        iVar.H();
                        iVar = ((p) A2).a;
                    } else {
                        A = H.A();
                        if (A instanceof p) {
                            if (iVar2 != null) {
                                break;
                            }
                            H = h.d(H._prev);
                        } else if (A != this) {
                            if (A != null) {
                                i iVar3 = (i) A;
                                if (iVar3 != iVar) {
                                    iVar2 = H;
                                    H = iVar3;
                                } else {
                                    return;
                                }
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                            }
                        } else if (f16476c.compareAndSet(H, this, iVar)) {
                            return;
                        }
                    }
                }
                H.H();
                f16476c.compareAndSet(iVar2, H, ((p) A).a);
                H = iVar2;
            }
        } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Removed");
        }
    }

    public final void F() {
        Object A = A();
        if (!(A instanceof p)) {
            A = null;
        }
        p pVar = (p) A;
        if (pVar != null) {
            z(pVar.a);
            return;
        }
        throw new IllegalStateException("Must be invoked on a removed node".toString());
    }

    public final boolean G() {
        return A() instanceof p;
    }

    public boolean I() {
        Object A;
        i iVar;
        do {
            A = A();
            if ((A instanceof p) || A == this) {
                return false;
            }
            if (A != null) {
                iVar = (i) A;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        } while (!f16476c.compareAndSet(this, A, iVar.J()));
        z(iVar);
        return true;
    }

    public final int K(i node, i next, b condAdd) {
        j.f(node, "node");
        j.f(next, "next");
        j.f(condAdd, "condAdd");
        f16477d.lazySet(node, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f16476c;
        atomicReferenceFieldUpdater.lazySet(node, next);
        condAdd.f16481b = next;
        if (!atomicReferenceFieldUpdater.compareAndSet(this, next, condAdd)) {
            return 0;
        }
        return condAdd.a(this) == null ? 1 : 2;
    }

    public final void t(i node) {
        Object C;
        j.f(node, "node");
        do {
            C = C();
            if (C == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        } while (!((i) C).u(node, this));
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
    }

    public final boolean u(i node, i next) {
        j.f(node, "node");
        j.f(next, "next");
        f16477d.lazySet(node, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f16476c;
        atomicReferenceFieldUpdater.lazySet(node, next);
        if (!atomicReferenceFieldUpdater.compareAndSet(this, next, node)) {
            return false;
        }
        node.y(next);
        return true;
    }

    public final boolean v(i node) {
        j.f(node, "node");
        f16477d.lazySet(node, this);
        f16476c.lazySet(node, this);
        while (A() == this) {
            if (f16476c.compareAndSet(this, this, node)) {
                node.y(this);
                return true;
            }
        }
        return false;
    }
}

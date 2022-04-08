package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.TypeCastException;
import kotlin.coroutines.f;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;
import kotlinx.coroutines.d1;
import kotlinx.coroutines.internal.e;
import kotlinx.coroutines.internal.h;
import kotlinx.coroutines.internal.i;
import kotlinx.coroutines.internal.o;
import kotlinx.coroutines.internal.s;
import kotlinx.coroutines.internal.t;

/* compiled from: JobSupport.kt */
/* loaded from: classes4.dex */
public class j1 implements d1, o, q1 {

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f16504c = AtomicReferenceFieldUpdater.newUpdater(j1.class, Object.class, "_state");
    private volatile Object _state;
    public volatile m parentHandle;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JobSupport.kt */
    /* loaded from: classes4.dex */
    public static final class a extends i1<d1> {
        private final Object p0;
        private final j1 x;
        private final b y;
        private final n z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(j1 parent, b state, n child, Object obj) {
            super(child.x);
            j.f(parent, "parent");
            j.f(state, "state");
            j.f(child, "child");
            this.x = parent;
            this.y = state;
            this.z = child;
            this.p0 = obj;
        }

        @Override // kotlinx.coroutines.v
        public void L(Throwable th) {
            this.x.C(this.y, this.z, this.p0);
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ p invoke(Throwable th) {
            L(th);
            return p.a;
        }

        @Override // kotlinx.coroutines.internal.i
        public String toString() {
            return "ChildCompletion[" + this.z + ", " + this.p0 + ']';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JobSupport.kt */
    /* loaded from: classes4.dex */
    public static final class b implements y0 {
        private volatile Object _exceptionsHolder;

        /* renamed from: c  reason: collision with root package name */
        private final n1 f16505c;
        public volatile boolean isCompleting;
        public volatile Throwable rootCause;

        public b(n1 list, boolean z, Throwable th) {
            j.f(list, "list");
            this.f16505c = list;
            this.isCompleting = z;
            this.rootCause = th;
        }

        private final ArrayList<Throwable> b() {
            return new ArrayList<>(4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object] */
        /* JADX WARN: Unknown variable types count: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a(java.lang.Throwable r3) {
            /*
                r2 = this;
                java.lang.String r0 = "exception"
                kotlin.jvm.internal.j.f(r3, r0)
                java.lang.Throwable r0 = r2.rootCause
                if (r0 != 0) goto L_0x000c
                r2.rootCause = r3
                return
            L_0x000c:
                if (r3 != r0) goto L_0x000f
                return
            L_0x000f:
                java.lang.Object r0 = r2._exceptionsHolder
                if (r0 != 0) goto L_0x0016
                r2._exceptionsHolder = r3
                goto L_0x0033
            L_0x0016:
                boolean r1 = r0 instanceof java.lang.Throwable
                if (r1 == 0) goto L_0x002a
                if (r3 != r0) goto L_0x001d
                return
            L_0x001d:
                java.util.ArrayList r1 = r2.b()
                r1.add(r0)
                r1.add(r3)
                r2._exceptionsHolder = r1
                goto L_0x0033
            L_0x002a:
                boolean r1 = r0 instanceof java.util.ArrayList
                if (r1 == 0) goto L_0x0034
                java.util.ArrayList r0 = (java.util.ArrayList) r0
                r0.add(r3)
            L_0x0033:
                return
            L_0x0034:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r1 = "State is "
                r3.append(r1)
                r3.append(r0)
                java.lang.String r3 = r3.toString()
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r3 = r3.toString()
                r0.<init>(r3)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.j1.b.a(java.lang.Throwable):void");
        }

        public final boolean c() {
            return this.rootCause != null;
        }

        @Override // kotlinx.coroutines.y0
        public n1 d() {
            return this.f16505c;
        }

        public final boolean e() {
            t tVar;
            Object obj = this._exceptionsHolder;
            tVar = k1.a;
            return obj == tVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object] */
        /* JADX WARN: Unknown variable types count: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.util.List<java.lang.Throwable> f(java.lang.Throwable r4) {
            /*
                r3 = this;
                java.lang.Object r0 = r3._exceptionsHolder
                if (r0 != 0) goto L_0x0009
                java.util.ArrayList r0 = r3.b()
                goto L_0x001c
            L_0x0009:
                boolean r1 = r0 instanceof java.lang.Throwable
                if (r1 == 0) goto L_0x0016
                java.util.ArrayList r1 = r3.b()
                r1.add(r0)
                r0 = r1
                goto L_0x001c
            L_0x0016:
                boolean r1 = r0 instanceof java.util.ArrayList
                if (r1 == 0) goto L_0x0038
                java.util.ArrayList r0 = (java.util.ArrayList) r0
            L_0x001c:
                java.lang.Throwable r1 = r3.rootCause
                if (r1 == 0) goto L_0x0024
                r2 = 0
                r0.add(r2, r1)
            L_0x0024:
                if (r4 == 0) goto L_0x0031
                boolean r1 = kotlin.jvm.internal.j.a(r4, r1)
                r1 = r1 ^ 1
                if (r1 == 0) goto L_0x0031
                r0.add(r4)
            L_0x0031:
                kotlinx.coroutines.internal.t r4 = kotlinx.coroutines.k1.c()
                r3._exceptionsHolder = r4
                return r0
            L_0x0038:
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r1 = "State is "
                r4.append(r1)
                r4.append(r0)
                java.lang.String r4 = r4.toString()
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r4 = r4.toString()
                r0.<init>(r4)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.j1.b.f(java.lang.Throwable):java.util.List");
        }

        @Override // kotlinx.coroutines.y0
        public boolean isActive() {
            return this.rootCause == null;
        }

        public String toString() {
            return "Finishing[cancelling=" + c() + ", completing=" + this.isCompleting + ", rootCause=" + this.rootCause + ", exceptions=" + this._exceptionsHolder + ", list=" + d() + ']';
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    /* loaded from: classes4.dex */
    public static final class c extends i.b {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ i f16506d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ j1 f16507e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Object f16508f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(i iVar, i iVar2, j1 j1Var, Object obj) {
            super(iVar2);
            this.f16506d = iVar;
            this.f16507e = j1Var;
            this.f16508f = obj;
        }

        /* renamed from: h */
        public Object e(i affected) {
            j.f(affected, "affected");
            if (this.f16507e.L() == this.f16508f) {
                return null;
            }
            return h.b();
        }
    }

    public j1(boolean z) {
        this._state = z ? k1.f16511c : k1.f16510b;
    }

    private final void B(y0 y0Var, Object obj, int i) {
        m mVar = this.parentHandle;
        if (mVar != null) {
            mVar.dispose();
            this.parentHandle = o1.f16516c;
        }
        Throwable th = null;
        r rVar = (r) (!(obj instanceof r) ? null : obj);
        if (rVar != null) {
            th = rVar.f16526b;
        }
        if (y0Var instanceof i1) {
            try {
                ((i1) y0Var).L(th);
            } catch (Throwable th2) {
                N(new CompletionHandlerException("Exception in completion handler " + y0Var + " for " + this, th2));
            }
        } else {
            n1 d2 = y0Var.d();
            if (d2 != null) {
                X(d2, th);
            }
        }
        u(obj, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(b bVar, n nVar, Object obj) {
        if (L() == bVar) {
            n V = V(nVar);
            if ((V == null || !o0(bVar, V, obj)) && j0(bVar, obj, 0)) {
            }
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final Throwable D(Object obj) {
        if (obj != null ? obj instanceof Throwable : true) {
            return obj != null ? (Throwable) obj : E();
        }
        if (obj != null) {
            return ((q1) obj).l();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
    }

    private final JobCancellationException E() {
        return new JobCancellationException("Job was cancelled", null, this);
    }

    private final n F(y0 y0Var) {
        n nVar = (n) (!(y0Var instanceof n) ? null : y0Var);
        if (nVar != null) {
            return nVar;
        }
        n1 d2 = y0Var.d();
        if (d2 != null) {
            return V(d2);
        }
        return null;
    }

    private final Throwable G(Object obj) {
        if (!(obj instanceof r)) {
            obj = null;
        }
        r rVar = (r) obj;
        if (rVar != null) {
            return rVar.f16526b;
        }
        return null;
    }

    private final Throwable H(b bVar, List<? extends Throwable> list) {
        Object obj = null;
        if (!list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (!(((Throwable) next) instanceof CancellationException)) {
                    obj = next;
                    break;
                }
            }
            Throwable th = (Throwable) obj;
            return th != null ? th : (Throwable) list.get(0);
        } else if (bVar.c()) {
            return E();
        } else {
            return null;
        }
    }

    private final n1 K(y0 y0Var) {
        n1 d2 = y0Var.d();
        if (d2 != null) {
            return d2;
        }
        if (y0Var instanceof p0) {
            return new n1();
        }
        if (y0Var instanceof i1) {
            c0((i1) y0Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + y0Var).toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0085, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean R(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            java.lang.Object r2 = r7.L()
            boolean r3 = r2 instanceof kotlinx.coroutines.j1.b
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x004a
            monitor-enter(r2)
            r3 = r2
            kotlinx.coroutines.j1$b r3 = (kotlinx.coroutines.j1.b) r3     // Catch: all -> 0x0047
            boolean r3 = r3.e()     // Catch: all -> 0x0047
            if (r3 == 0) goto L_0x0018
            monitor-exit(r2)
            return r4
        L_0x0018:
            r3 = r2
            kotlinx.coroutines.j1$b r3 = (kotlinx.coroutines.j1.b) r3     // Catch: all -> 0x0047
            boolean r3 = r3.c()     // Catch: all -> 0x0047
            if (r8 != 0) goto L_0x0023
            if (r3 != 0) goto L_0x0030
        L_0x0023:
            if (r1 == 0) goto L_0x0026
            goto L_0x002a
        L_0x0026:
            java.lang.Throwable r1 = r7.D(r8)     // Catch: all -> 0x0047
        L_0x002a:
            r8 = r2
            kotlinx.coroutines.j1$b r8 = (kotlinx.coroutines.j1.b) r8     // Catch: all -> 0x0047
            r8.a(r1)     // Catch: all -> 0x0047
        L_0x0030:
            r8 = r2
            kotlinx.coroutines.j1$b r8 = (kotlinx.coroutines.j1.b) r8     // Catch: all -> 0x0047
            java.lang.Throwable r8 = r8.rootCause     // Catch: all -> 0x0047
            r1 = r3 ^ 1
            if (r1 == 0) goto L_0x003a
            r0 = r8
        L_0x003a:
            monitor-exit(r2)
            if (r0 == 0) goto L_0x0046
            kotlinx.coroutines.j1$b r2 = (kotlinx.coroutines.j1.b) r2
            kotlinx.coroutines.n1 r8 = r2.d()
            r7.W(r8, r0)
        L_0x0046:
            return r5
        L_0x0047:
            r8 = move-exception
            monitor-exit(r2)
            throw r8
        L_0x004a:
            boolean r3 = r2 instanceof kotlinx.coroutines.y0
            if (r3 == 0) goto L_0x00a1
            if (r1 == 0) goto L_0x0051
            goto L_0x0055
        L_0x0051:
            java.lang.Throwable r1 = r7.D(r8)
        L_0x0055:
            r3 = r2
            kotlinx.coroutines.y0 r3 = (kotlinx.coroutines.y0) r3
            boolean r6 = r3.isActive()
            if (r6 == 0) goto L_0x0065
            boolean r2 = r7.l0(r3, r1)
            if (r2 == 0) goto L_0x0002
            return r5
        L_0x0065:
            kotlinx.coroutines.r r3 = new kotlinx.coroutines.r
            r6 = 2
            r3.<init>(r1, r4, r6, r0)
            int r3 = r7.m0(r2, r3, r4)
            if (r3 == 0) goto L_0x0086
            if (r3 == r5) goto L_0x0085
            if (r3 == r6) goto L_0x0085
            r2 = 3
            if (r3 != r2) goto L_0x0079
            goto L_0x0002
        L_0x0079:
            java.lang.String r8 = "unexpected result"
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r8 = r8.toString()
            r0.<init>(r8)
            throw r0
        L_0x0085:
            return r5
        L_0x0086:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Cannot happen in "
            r8.append(r0)
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r8 = r8.toString()
            r0.<init>(r8)
            throw r0
        L_0x00a1:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.j1.R(java.lang.Object):boolean");
    }

    private final i1<?> T(l<? super Throwable, p> lVar, boolean z) {
        boolean z2 = true;
        e1 e1Var = null;
        if (z) {
            if (lVar instanceof e1) {
                e1Var = lVar;
            }
            e1 e1Var2 = e1Var;
            if (e1Var2 == null) {
                return new b1(this, lVar);
            }
            if (e1Var2.q != this) {
                z2 = false;
            }
            if (z2) {
                return e1Var2;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (lVar instanceof i1) {
            e1Var = lVar;
        }
        i1<?> i1Var = e1Var;
        if (i1Var == null) {
            return new c1(this, lVar);
        }
        if (i1Var.q != this || (i1Var instanceof e1)) {
            z2 = false;
        }
        if (z2) {
            return i1Var;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final n V(i iVar) {
        while (iVar.G()) {
            iVar = iVar.D();
        }
        while (true) {
            iVar = iVar.B();
            if (!iVar.G()) {
                if (iVar instanceof n) {
                    return (n) iVar;
                }
                if (iVar instanceof n1) {
                    return null;
                }
            }
        }
    }

    private final void W(n1 n1Var, Throwable th) {
        Y(th);
        Object A = n1Var.A();
        if (A != null) {
            CompletionHandlerException completionHandlerException = null;
            for (i iVar = (i) A; !j.a(iVar, n1Var); iVar = iVar.B()) {
                if (iVar instanceof e1) {
                    i1 i1Var = (i1) iVar;
                    try {
                        i1Var.L(th);
                    } catch (Throwable th2) {
                        if (completionHandlerException != null) {
                            kotlin.b.a(completionHandlerException, th2);
                        } else {
                            completionHandlerException = new CompletionHandlerException("Exception in completion handler " + i1Var + " for " + this, th2);
                            p pVar = p.a;
                        }
                    }
                }
            }
            if (completionHandlerException != null) {
                N(completionHandlerException);
            }
            z(th);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    private final void X(n1 n1Var, Throwable th) {
        Object A = n1Var.A();
        if (A != null) {
            CompletionHandlerException completionHandlerException = null;
            for (i iVar = (i) A; !j.a(iVar, n1Var); iVar = iVar.B()) {
                if (iVar instanceof i1) {
                    i1 i1Var = (i1) iVar;
                    try {
                        i1Var.L(th);
                    } catch (Throwable th2) {
                        if (completionHandlerException != null) {
                            kotlin.b.a(completionHandlerException, th2);
                        } else {
                            completionHandlerException = new CompletionHandlerException("Exception in completion handler " + i1Var + " for " + this, th2);
                            p pVar = p.a;
                        }
                    }
                }
            }
            if (completionHandlerException != null) {
                N(completionHandlerException);
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    private final void b0(p0 p0Var) {
        n1 n1Var = new n1();
        y0 y0Var = n1Var;
        if (!p0Var.isActive()) {
            y0Var = new x0(n1Var);
        }
        f16504c.compareAndSet(this, p0Var, y0Var == 1 ? 1 : 0);
    }

    private final void c0(i1<?> i1Var) {
        i1Var.v(new n1());
        f16504c.compareAndSet(this, i1Var, i1Var.B());
    }

    private final int e0(Object obj) {
        p0 p0Var;
        if (obj instanceof p0) {
            if (((p0) obj).isActive()) {
                return 0;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f16504c;
            p0Var = k1.f16511c;
            if (!atomicReferenceFieldUpdater.compareAndSet(this, obj, p0Var)) {
                return -1;
            }
            a0();
            return 1;
        } else if (!(obj instanceof x0)) {
            return 0;
        } else {
            if (!f16504c.compareAndSet(this, obj, ((x0) obj).d())) {
                return -1;
            }
            a0();
            return 1;
        }
    }

    private final String f0(Object obj) {
        if (!(obj instanceof b)) {
            return obj instanceof y0 ? ((y0) obj).isActive() ? "Active" : "New" : obj instanceof r ? "Cancelled" : "Completed";
        }
        b bVar = (b) obj;
        return bVar.c() ? "Cancelling" : bVar.isCompleting ? "Completing" : "Active";
    }

    public static /* synthetic */ CancellationException h0(j1 j1Var, Throwable th, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            return j1Var.g0(th, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    private final boolean j0(b bVar, Object obj, int i) {
        boolean c2;
        Throwable H;
        boolean z = false;
        if (!(L() == bVar)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!(!bVar.e())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (bVar.isCompleting) {
            r rVar = (r) (!(obj instanceof r) ? null : obj);
            Throwable th = rVar != null ? rVar.f16526b : null;
            synchronized (bVar) {
                c2 = bVar.c();
                List<Throwable> f2 = bVar.f(th);
                H = H(bVar, f2);
                if (H != null) {
                    r(H, f2);
                }
            }
            if (!(H == null || H == th)) {
                obj = new r(H, false, 2, null);
            }
            if (H != null) {
                if (z(H) || M(H)) {
                    z = true;
                }
                if (z) {
                    if (obj != null) {
                        ((r) obj).b();
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                    }
                }
            }
            if (!c2) {
                Y(H);
            }
            Z(obj);
            if (f16504c.compareAndSet(this, bVar, k1.d(obj))) {
                B(bVar, obj, i);
                return true;
            }
            throw new IllegalArgumentException(("Unexpected state: " + this._state + ", expected: " + bVar + ", update: " + obj).toString());
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    private final boolean k0(y0 y0Var, Object obj, int i) {
        if (g0.a()) {
            if (!((y0Var instanceof p0) || (y0Var instanceof i1))) {
                throw new AssertionError();
            }
        }
        if (g0.a() && !(!(obj instanceof r))) {
            throw new AssertionError();
        } else if (!f16504c.compareAndSet(this, y0Var, k1.d(obj))) {
            return false;
        } else {
            Y(null);
            Z(obj);
            B(y0Var, obj, i);
            return true;
        }
    }

    private final boolean l0(y0 y0Var, Throwable th) {
        if (g0.a() && !(!(y0Var instanceof b))) {
            throw new AssertionError();
        } else if (!g0.a() || y0Var.isActive()) {
            n1 K = K(y0Var);
            if (K == null) {
                return false;
            }
            if (!f16504c.compareAndSet(this, y0Var, new b(K, false, th))) {
                return false;
            }
            W(K, th);
            return true;
        } else {
            throw new AssertionError();
        }
    }

    private final int m0(Object obj, Object obj2, int i) {
        if (!(obj instanceof y0)) {
            return 0;
        }
        if (((obj instanceof p0) || (obj instanceof i1)) && !(obj instanceof n) && !(obj2 instanceof r)) {
            return !k0((y0) obj, obj2, i) ? 3 : 1;
        }
        return n0((y0) obj, obj2, i);
    }

    private final int n0(y0 y0Var, Object obj, int i) {
        n1 K = K(y0Var);
        if (K == null) {
            return 3;
        }
        Throwable th = null;
        b bVar = (b) (!(y0Var instanceof b) ? null : y0Var);
        if (bVar == null) {
            bVar = new b(K, false, null);
        }
        synchronized (bVar) {
            if (bVar.isCompleting) {
                return 0;
            }
            bVar.isCompleting = true;
            if (bVar != y0Var && !f16504c.compareAndSet(this, y0Var, bVar)) {
                return 3;
            }
            if (!bVar.e()) {
                boolean c2 = bVar.c();
                r rVar = (r) (!(obj instanceof r) ? null : obj);
                if (rVar != null) {
                    bVar.a(rVar.f16526b);
                }
                Throwable th2 = bVar.rootCause;
                if (!c2) {
                    th = th2;
                }
                p pVar = p.a;
                if (th != null) {
                    W(K, th);
                }
                n F = F(y0Var);
                if (F == null || !o0(bVar, F, obj)) {
                    return j0(bVar, obj, i) ? 1 : 3;
                }
                return 2;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    private final boolean o0(b bVar, n nVar, Object obj) {
        while (d1.a.d(nVar.x, false, false, new a(this, bVar, nVar, obj), 1, null) == o1.f16516c) {
            nVar = V(nVar);
            if (nVar == null) {
                return false;
            }
        }
        return true;
    }

    private final boolean q(Object obj, n1 n1Var, i1<?> i1Var) {
        int K;
        c cVar = new c(i1Var, i1Var, this, obj);
        do {
            Object C = n1Var.C();
            if (C != null) {
                K = ((i) C).K(i1Var, n1Var, cVar);
                if (K == 1) {
                    return true;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        } while (K != 2);
        return false;
    }

    private final void r(Throwable th, List<? extends Throwable> list) {
        if (list.size() > 1) {
            Set a2 = e.a(list.size());
            Throwable m = s.m(th);
            for (Throwable th2 : list) {
                Throwable m2 = s.m(th2);
                if (m2 != th && m2 != m && !(m2 instanceof CancellationException) && a2.add(m2)) {
                    kotlin.b.a(th, m2);
                }
            }
        }
    }

    private final boolean y(Object obj) {
        int m0;
        do {
            Object L = L();
            if (!(L instanceof y0) || (((L instanceof b) && ((b) L).isCompleting) || (m0 = m0(L, new r(D(obj), false, 2, null), 0)) == 0)) {
                return false;
            }
            if (m0 == 1 || m0 == 2) {
                return true;
            }
        } while (m0 == 3);
        throw new IllegalStateException("unexpected result".toString());
    }

    private final boolean z(Throwable th) {
        if (Q()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        m mVar = this.parentHandle;
        return (mVar == null || mVar == o1.f16516c) ? z : mVar.c(th) || z;
    }

    public boolean A(Throwable cause) {
        j.f(cause, "cause");
        if (cause instanceof CancellationException) {
            return true;
        }
        return w(cause) && I();
    }

    public boolean I() {
        return true;
    }

    public boolean J() {
        return false;
    }

    public final Object L() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof o)) {
                return obj;
            }
            ((o) obj).a(this);
        }
    }

    protected boolean M(Throwable exception) {
        j.f(exception, "exception");
        return false;
    }

    public void N(Throwable exception) {
        j.f(exception, "exception");
        throw exception;
    }

    public final void O(d1 d1Var) {
        if (g0.a()) {
            if (!(this.parentHandle == null)) {
                throw new AssertionError();
            }
        }
        if (d1Var == null) {
            this.parentHandle = o1.f16516c;
            return;
        }
        d1Var.start();
        m t = d1Var.t(this);
        this.parentHandle = t;
        if (P()) {
            t.dispose();
            this.parentHandle = o1.f16516c;
        }
    }

    public final boolean P() {
        return !(L() instanceof y0);
    }

    protected boolean Q() {
        return false;
    }

    public final boolean S(Object obj, int i) {
        int m0;
        do {
            m0 = m0(L(), obj, i);
            if (m0 == 0) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, G(obj));
            } else if (m0 == 1) {
                return true;
            } else {
                if (m0 == 2) {
                    return false;
                }
            }
        } while (m0 == 3);
        throw new IllegalStateException("unexpected result".toString());
    }

    public String U() {
        return h0.a(this);
    }

    protected void Y(Throwable th) {
    }

    protected void Z(Object obj) {
    }

    @Override // kotlinx.coroutines.d1, kotlinx.coroutines.channels.r
    public void a(CancellationException cancellationException) {
        x(cancellationException);
    }

    public void a0() {
    }

    public final void d0(i1<?> node) {
        Object L;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        p0 p0Var;
        j.f(node, "node");
        do {
            L = L();
            if (L instanceof i1) {
                if (L == node) {
                    atomicReferenceFieldUpdater = f16504c;
                    p0Var = k1.f16511c;
                } else {
                    return;
                }
            } else if ((L instanceof y0) && ((y0) L).d() != null) {
                node.I();
                return;
            } else {
                return;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, L, p0Var));
    }

    @Override // kotlin.coroutines.f
    public <R> R fold(R r, kotlin.jvm.b.p<? super R, ? super f.b, ? extends R> operation) {
        j.f(operation, "operation");
        return (R) d1.a.b(this, r, operation);
    }

    @Override // kotlinx.coroutines.d1
    public final o0 g(boolean z, boolean z2, l<? super Throwable, p> handler) {
        Throwable th;
        j.f(handler, "handler");
        Throwable th2 = null;
        i1<?> i1Var = null;
        while (true) {
            Object L = L();
            if (L instanceof p0) {
                p0 p0Var = (p0) L;
                if (p0Var.isActive()) {
                    if (i1Var == null) {
                        i1Var = T(handler, z);
                    }
                    if (f16504c.compareAndSet(this, L, i1Var)) {
                        return i1Var;
                    }
                } else {
                    b0(p0Var);
                }
            } else if (L instanceof y0) {
                n1 d2 = ((y0) L).d();
                if (d2 != null) {
                    o0 o0Var = o1.f16516c;
                    if (!z || !(L instanceof b)) {
                        th = null;
                    } else {
                        synchronized (L) {
                            th = ((b) L).rootCause;
                            if (th == null || ((handler instanceof n) && !((b) L).isCompleting)) {
                                if (i1Var == null) {
                                    i1Var = T(handler, z);
                                }
                                if (q(L, d2, i1Var)) {
                                    if (th == null) {
                                        return i1Var;
                                    }
                                    o0Var = i1Var;
                                }
                            }
                            p pVar = p.a;
                        }
                    }
                    if (th != null) {
                        if (z2) {
                            handler.invoke(th);
                        }
                        return o0Var;
                    }
                    if (i1Var == null) {
                        i1Var = T(handler, z);
                    }
                    if (q(L, d2, i1Var)) {
                        return i1Var;
                    }
                } else if (L != null) {
                    c0((i1) L);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>");
                }
            } else {
                if (z2) {
                    if (!(L instanceof r)) {
                        L = null;
                    }
                    r rVar = (r) L;
                    if (rVar != null) {
                        th2 = rVar.f16526b;
                    }
                    handler.invoke(th2);
                }
                return o1.f16516c;
            }
        }
    }

    protected final CancellationException g0(Throwable toCancellationException, String str) {
        j.f(toCancellationException, "$this$toCancellationException");
        CancellationException cancellationException = (CancellationException) (!(toCancellationException instanceof CancellationException) ? null : toCancellationException);
        if (cancellationException == null) {
            if (str == null) {
                str = h0.a(toCancellationException) + " was cancelled";
            }
            cancellationException = new JobCancellationException(str, toCancellationException, this);
        }
        return cancellationException;
    }

    @Override // kotlin.coroutines.f.b, kotlin.coroutines.f
    public <E extends f.b> E get(f.c<E> key) {
        j.f(key, "key");
        return (E) d1.a.c(this, key);
    }

    @Override // kotlin.coroutines.f.b
    public final f.c<?> getKey() {
        return d1.h;
    }

    @Override // kotlinx.coroutines.d1
    public final CancellationException i() {
        Object L = L();
        if (L instanceof b) {
            Throwable th = ((b) L).rootCause;
            if (th != null) {
                CancellationException g0 = g0(th, h0.a(this) + " is cancelling");
                if (g0 != null) {
                    return g0;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (L instanceof y0) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (L instanceof r) {
            return h0(this, ((r) L).f16526b, null, 1, null);
        } else {
            return new JobCancellationException(h0.a(this) + " has completed normally", null, this);
        }
    }

    public final String i0() {
        return U() + '{' + f0(L()) + '}';
    }

    @Override // kotlinx.coroutines.d1
    public boolean isActive() {
        Object L = L();
        return (L instanceof y0) && ((y0) L).isActive();
    }

    @Override // kotlinx.coroutines.o
    public final void j(q1 parentJob) {
        j.f(parentJob, "parentJob");
        w(parentJob);
    }

    @Override // kotlinx.coroutines.q1
    public CancellationException l() {
        Throwable th;
        Object L = L();
        CancellationException cancellationException = null;
        if (L instanceof b) {
            th = ((b) L).rootCause;
        } else if (L instanceof r) {
            th = ((r) L).f16526b;
        } else if (!(L instanceof y0)) {
            th = null;
        } else {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + L).toString());
        }
        if (th instanceof CancellationException) {
            cancellationException = th;
        }
        CancellationException cancellationException2 = cancellationException;
        if (cancellationException2 != null) {
            return cancellationException2;
        }
        return new JobCancellationException("Parent job is " + f0(L), th, this);
    }

    @Override // kotlin.coroutines.f
    public f minusKey(f.c<?> key) {
        j.f(key, "key");
        return d1.a.e(this, key);
    }

    @Override // kotlin.coroutines.f
    public f plus(f context) {
        j.f(context, "context");
        return d1.a.f(this, context);
    }

    @Override // kotlinx.coroutines.d1
    public final boolean start() {
        int e0;
        do {
            e0 = e0(L());
            if (e0 == 0) {
                return false;
            }
        } while (e0 != 1);
        return true;
    }

    @Override // kotlinx.coroutines.d1
    public final m t(o child) {
        j.f(child, "child");
        o0 d2 = d1.a.d(this, true, false, new n(this, child), 2, null);
        if (d2 != null) {
            return (m) d2;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
    }

    public String toString() {
        return i0() + '@' + h0.b(this);
    }

    protected void u(Object obj, int i) {
    }

    public final boolean v(Throwable th) {
        return w(th);
    }

    public final boolean w(Object obj) {
        if (!J() || !y(obj)) {
            return R(obj);
        }
        return true;
    }

    public boolean x(Throwable th) {
        return w(th) && I();
    }
}

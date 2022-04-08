package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.TypeCastException;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.q;
import kotlin.k;
import kotlin.p;
import kotlinx.coroutines.c2;
import kotlinx.coroutines.g0;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.internal.g;
import kotlinx.coroutines.internal.h;
import kotlinx.coroutines.internal.i;
import kotlinx.coroutines.internal.s;

/* compiled from: AbstractChannel.kt */
/* loaded from: classes4.dex */
public abstract class c<E> implements v<E> {

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f16441c = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "onCloseHandler");

    /* renamed from: d  reason: collision with root package name */
    private final g f16442d = new g();
    private volatile Object onCloseHandler = null;

    /* compiled from: AbstractChannel.kt */
    /* loaded from: classes4.dex */
    public static final class a<E> extends u {
        public final E q;

        public a(E e2) {
            this.q = e2;
        }

        @Override // kotlinx.coroutines.channels.u
        public void L(Object token) {
            j.f(token, "token");
            if (g0.a()) {
                if (!(token == b.h)) {
                    throw new AssertionError();
                }
            }
        }

        @Override // kotlinx.coroutines.channels.u
        public Object M() {
            return this.q;
        }

        @Override // kotlinx.coroutines.channels.u
        public void N(k<?> closed) {
            j.f(closed, "closed");
        }

        @Override // kotlinx.coroutines.channels.u
        public Object O(Object obj) {
            return b.h;
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    /* loaded from: classes4.dex */
    public static final class b extends i.b {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ i f16443d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ c f16444e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(i iVar, i iVar2, c cVar) {
            super(iVar2);
            this.f16443d = iVar;
            this.f16444e = cVar;
        }

        /* renamed from: h */
        public Object e(i affected) {
            j.f(affected, "affected");
            if (this.f16444e.t()) {
                return null;
            }
            return h.b();
        }
    }

    private final int h() {
        g gVar = this.f16442d;
        Object A = gVar.A();
        if (A != null) {
            int i = 0;
            for (i iVar = (i) A; !j.a(iVar, gVar); iVar = iVar.B()) {
                if (iVar instanceof i) {
                    i++;
                }
            }
            return i;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0044, code lost:
        if (r4 != false) goto L_0x0049;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0048, code lost:
        return kotlinx.coroutines.channels.b.f16438d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0049, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i(kotlinx.coroutines.channels.u r6) {
        /*
            r5 = this;
            boolean r0 = r5.s()
        */
        //  java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            if (r0 == 0) goto L_0x0024
            kotlinx.coroutines.internal.g r0 = r5.f16442d
        L_0x000a:
            java.lang.Object r2 = r0.C()
            if (r2 == 0) goto L_0x001e
            kotlinx.coroutines.internal.i r2 = (kotlinx.coroutines.internal.i) r2
            boolean r3 = r2 instanceof kotlinx.coroutines.channels.s
            if (r3 == 0) goto L_0x0017
            return r2
        L_0x0017:
            boolean r2 = r2.u(r6, r0)
            if (r2 == 0) goto L_0x000a
            goto L_0x0049
        L_0x001e:
            kotlin.TypeCastException r6 = new kotlin.TypeCastException
            r6.<init>(r1)
            throw r6
        L_0x0024:
            kotlinx.coroutines.internal.g r0 = r5.f16442d
            kotlinx.coroutines.channels.c$b r2 = new kotlinx.coroutines.channels.c$b
            r2.<init>(r6, r6, r5)
        L_0x002b:
            java.lang.Object r3 = r0.C()
            if (r3 == 0) goto L_0x004b
            kotlinx.coroutines.internal.i r3 = (kotlinx.coroutines.internal.i) r3
            boolean r4 = r3 instanceof kotlinx.coroutines.channels.s
            if (r4 == 0) goto L_0x0038
            return r3
        L_0x0038:
            int r3 = r3.K(r6, r0, r2)
            r4 = 1
            if (r3 == r4) goto L_0x0044
            r4 = 2
            if (r3 == r4) goto L_0x0043
            goto L_0x002b
        L_0x0043:
            r4 = 0
        L_0x0044:
            if (r4 != 0) goto L_0x0049
            java.lang.Object r6 = kotlinx.coroutines.channels.b.f16438d
            return r6
        L_0x0049:
            r6 = 0
            return r6
        L_0x004b:
            kotlin.TypeCastException r6 = new kotlin.TypeCastException
            r6.<init>(r1)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.c.i(kotlinx.coroutines.channels.u):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean l() {
        return !(this.f16442d.B() instanceof s) && t();
    }

    private final String p() {
        String str;
        i B = this.f16442d.B();
        if (B == this.f16442d) {
            return "EmptyQueue";
        }
        if (B instanceof k) {
            str = B.toString();
        } else if (B instanceof q) {
            str = "ReceiveQueued";
        } else if (B instanceof u) {
            str = "SendQueued";
        } else {
            str = "UNEXPECTED:" + B;
        }
        i D = this.f16442d.D();
        if (D == B) {
            return str;
        }
        String str2 = str + ",queueSize=" + h();
        if (!(D instanceof k)) {
            return str2;
        }
        return str2 + ",closedForSend=" + D;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(k<?> kVar) {
        while (true) {
            i D = kVar.D();
            if ((D instanceof g) || !(D instanceof q)) {
                break;
            } else if (!D.I()) {
                D.F();
            } else {
                ((q) D).L(kVar);
            }
        }
        w(kVar);
    }

    private final void r(Throwable th) {
        Object obj;
        Object obj2 = this.onCloseHandler;
        if (obj2 != null && obj2 != (obj = b.i) && f16441c.compareAndSet(this, obj2, obj)) {
            ((l) q.b(obj2, 1)).invoke(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public s<E> A() {
        i iVar;
        g gVar = this.f16442d;
        while (true) {
            Object A = gVar.A();
            if (A != null) {
                iVar = (i) A;
                iVar = null;
                if (iVar != gVar && (iVar instanceof s)) {
                    if ((((s) iVar) instanceof k) || iVar.I()) {
                        break;
                    }
                    iVar.E();
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        }
        return (s) iVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final u B() {
        i iVar;
        g gVar = this.f16442d;
        while (true) {
            Object A = gVar.A();
            if (A != null) {
                iVar = (i) A;
                iVar = null;
                if (iVar != gVar && (iVar instanceof u)) {
                    if ((((u) iVar) instanceof k) || iVar.I()) {
                        break;
                    }
                    iVar.E();
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        }
        return (u) iVar;
    }

    protected String j() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final k<?> k() {
        i D = this.f16442d.D();
        if (!(D instanceof k)) {
            D = null;
        }
        k<?> kVar = (k) D;
        if (kVar == null) {
            return null;
        }
        q(kVar);
        return kVar;
    }

    @Override // kotlinx.coroutines.channels.v
    public boolean m(Throwable th) {
        boolean z;
        k<?> kVar = new k<>(th);
        g gVar = this.f16442d;
        while (true) {
            Object C = gVar.C();
            if (C != null) {
                i iVar = (i) C;
                if (!(iVar instanceof k)) {
                    if (iVar.u(kVar, gVar)) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        }
        if (!z) {
            i D = this.f16442d.D();
            if (D != null) {
                q((k) D);
                return false;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.Closed<*>");
        }
        q(kVar);
        r(th);
        return true;
    }

    @Override // kotlinx.coroutines.channels.v
    public final Object n(E e2, kotlin.coroutines.c<? super p> cVar) {
        return u(e2) ? p.a : z(e2, cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final g o() {
        return this.f16442d;
    }

    protected abstract boolean s();

    protected abstract boolean t();

    public String toString() {
        return h0.a(this) + '@' + h0.b(this) + '{' + p() + '}' + j();
    }

    public final boolean u(E e2) {
        Throwable S;
        Throwable j;
        Object v = v(e2);
        if (v == b.a) {
            return true;
        }
        if (v == b.f16436b) {
            k<?> k = k();
            if (k == null || (S = k.S()) == null || (j = s.j(S)) == null) {
                return false;
            }
            throw j;
        } else if (v instanceof k) {
            throw s.j(((k) v).S());
        } else {
            throw new IllegalStateException(("offerInternal returned " + v).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object v(E e2) {
        s<E> A;
        Object m;
        do {
            A = A();
            if (A == null) {
                return b.f16436b;
            }
            m = A.m(e2, null);
        } while (m == null);
        A.j(m);
        return A.a();
    }

    protected void w(i closed) {
        j.f(closed, "closed");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final s<?> x(E e2) {
        i iVar;
        g gVar = this.f16442d;
        a aVar = new a(e2);
        do {
            Object C = gVar.C();
            if (C != null) {
                iVar = (i) C;
                if (iVar instanceof s) {
                    return (s) iVar;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        } while (!iVar.u(aVar, gVar));
        return null;
    }

    public final Object y(E e2, kotlin.coroutines.c<? super p> cVar) {
        if (u(e2)) {
            return c2.b(cVar);
        }
        return z(e2, cVar);
    }

    final /* synthetic */ Object z(E e2, kotlin.coroutines.c<? super p> cVar) {
        kotlin.coroutines.c c2;
        Object d2;
        c2 = IntrinsicsKt__IntrinsicsJvmKt.c(cVar);
        kotlinx.coroutines.i iVar = new kotlinx.coroutines.i(c2, 0);
        while (true) {
            if (l()) {
                w wVar = new w(e2, iVar);
                Object i = i(wVar);
                if (i == null) {
                    kotlinx.coroutines.j.a(iVar, wVar);
                    break;
                } else if (i instanceof k) {
                    k kVar = (k) i;
                    q(kVar);
                    Throwable S = kVar.S();
                    Result.a aVar = Result.Companion;
                    iVar.resumeWith(Result.m1constructorimpl(k.a(S)));
                    break;
                } else if (i != b.f16438d && !(i instanceof q)) {
                    throw new IllegalStateException(("enqueueSend returned " + i).toString());
                }
            }
            Object v = v(e2);
            if (v == b.a) {
                p pVar = p.a;
                Result.a aVar2 = Result.Companion;
                iVar.resumeWith(Result.m1constructorimpl(pVar));
                break;
            } else if (v != b.f16436b) {
                if (v instanceof k) {
                    k kVar2 = (k) v;
                    q(kVar2);
                    Throwable S2 = kVar2.S();
                    Result.a aVar3 = Result.Companion;
                    iVar.resumeWith(Result.m1constructorimpl(k.a(S2)));
                } else {
                    throw new IllegalStateException(("offerInternal returned " + v).toString());
                }
            }
        }
        Object q = iVar.q();
        d2 = kotlin.coroutines.intrinsics.b.d();
        if (q == d2) {
            f.c(cVar);
        }
        return q;
    }
}

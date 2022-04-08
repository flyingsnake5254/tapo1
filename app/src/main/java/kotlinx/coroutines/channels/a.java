package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.TypeCastException;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.j;
import kotlin.k;
import kotlinx.coroutines.channels.x;
import kotlinx.coroutines.g0;
import kotlinx.coroutines.h;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.internal.i;
import kotlinx.coroutines.internal.s;
import kotlinx.coroutines.o0;

/* compiled from: AbstractChannel.kt */
/* loaded from: classes4.dex */
public abstract class a<E> extends c<E> implements f<E> {

    /* compiled from: AbstractChannel.kt */
    /* renamed from: kotlinx.coroutines.channels.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static final class C0325a<E> {
        public final Object a;

        /* renamed from: b  reason: collision with root package name */
        public final E f16428b;

        public C0325a(Object token, E e2) {
            j.f(token, "token");
            this.a = token;
            this.f16428b = e2;
        }
    }

    /* compiled from: AbstractChannel.kt */
    /* loaded from: classes4.dex */
    private static final class b<E> implements h<E> {
        private Object a = b.f16437c;

        /* renamed from: b  reason: collision with root package name */
        private final a<E> f16429b;

        public b(a<E> channel) {
            j.f(channel, "channel");
            this.f16429b = channel;
        }

        private final boolean c(Object obj) {
            if (!(obj instanceof k)) {
                return true;
            }
            k kVar = (k) obj;
            if (kVar.q == null) {
                return false;
            }
            throw s.j(kVar.R());
        }

        @Override // kotlinx.coroutines.channels.h
        public Object a(kotlin.coroutines.c<? super Boolean> cVar) {
            Object obj = this.a;
            Object obj2 = b.f16437c;
            if (obj != obj2) {
                return kotlin.coroutines.jvm.internal.a.a(c(obj));
            }
            Object P = this.f16429b.P();
            this.a = P;
            if (P != obj2) {
                return kotlin.coroutines.jvm.internal.a.a(c(P));
            }
            return d(cVar);
        }

        public final a<E> b() {
            return this.f16429b;
        }

        final /* synthetic */ Object d(kotlin.coroutines.c<? super Boolean> cVar) {
            kotlin.coroutines.c c2;
            Object d2;
            c2 = IntrinsicsKt__IntrinsicsJvmKt.c(cVar);
            i iVar = new i(c2, 0);
            c cVar2 = new c(this, iVar);
            while (true) {
                if (!b().I(cVar2)) {
                    Object P = b().P();
                    e(P);
                    if (!(P instanceof k)) {
                        if (P != b.f16437c) {
                            Boolean a = kotlin.coroutines.jvm.internal.a.a(true);
                            Result.a aVar = Result.Companion;
                            iVar.resumeWith(Result.m1constructorimpl(a));
                            break;
                        }
                    } else {
                        k kVar = (k) P;
                        if (kVar.q == null) {
                            Boolean a2 = kotlin.coroutines.jvm.internal.a.a(false);
                            Result.a aVar2 = Result.Companion;
                            iVar.resumeWith(Result.m1constructorimpl(a2));
                        } else {
                            Throwable R = kVar.R();
                            Result.a aVar3 = Result.Companion;
                            iVar.resumeWith(Result.m1constructorimpl(k.a(R)));
                        }
                    }
                } else {
                    b().S(iVar, cVar2);
                    break;
                }
            }
            Object q = iVar.q();
            d2 = kotlin.coroutines.intrinsics.b.d();
            if (q == d2) {
                kotlin.coroutines.jvm.internal.f.c(cVar);
            }
            return q;
        }

        public final void e(Object obj) {
            this.a = obj;
        }

        @Override // kotlinx.coroutines.channels.h
        public E next() {
            E e2 = (E) this.a;
            if (!(e2 instanceof k)) {
                Object obj = b.f16437c;
                if (e2 != obj) {
                    this.a = obj;
                    return e2;
                }
                throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
            }
            throw s.j(((k) e2).R());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractChannel.kt */
    /* loaded from: classes4.dex */
    public static final class c<E> extends q<E> {
        public final b<E> q;
        public final kotlinx.coroutines.h<Boolean> x;

        /* JADX WARN: Multi-variable type inference failed */
        public c(b<E> iterator, kotlinx.coroutines.h<? super Boolean> cont) {
            j.f(iterator, "iterator");
            j.f(cont, "cont");
            this.q = iterator;
            this.x = cont;
        }

        @Override // kotlinx.coroutines.channels.q
        public void L(k<?> closed) {
            Object obj;
            j.f(closed, "closed");
            if (closed.q == null) {
                obj = h.a.a(this.x, Boolean.FALSE, null, 2, null);
            } else {
                obj = this.x.h(s.k(closed.R(), this.x));
            }
            if (obj != null) {
                this.q.e(closed);
                this.x.p(obj);
            }
        }

        @Override // kotlinx.coroutines.channels.s
        public void j(Object token) {
            j.f(token, "token");
            if (token instanceof C0325a) {
                C0325a aVar = (C0325a) token;
                this.q.e(aVar.f16428b);
                this.x.p(aVar.a);
                return;
            }
            this.x.p(token);
        }

        @Override // kotlinx.coroutines.channels.s
        public Object m(E e2, Object obj) {
            Object b2 = this.x.b(Boolean.TRUE, obj);
            if (b2 != null) {
                if (obj != null) {
                    return new C0325a(b2, e2);
                }
                this.q.e(e2);
            }
            return b2;
        }

        @Override // kotlinx.coroutines.internal.i
        public String toString() {
            return "ReceiveHasNext";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractChannel.kt */
    /* loaded from: classes4.dex */
    public static final class d<R, E> extends q<E> implements o0 {
        public final a<E> q;
        public final kotlinx.coroutines.selects.d<R> x;
        public final p<Object, kotlin.coroutines.c<? super R>, Object> y;
        public final int z;

        /* JADX WARN: Multi-variable type inference failed */
        public d(a<E> channel, kotlinx.coroutines.selects.d<? super R> select, p<Object, ? super kotlin.coroutines.c<? super R>, ? extends Object> block, int i) {
            j.f(channel, "channel");
            j.f(select, "select");
            j.f(block, "block");
            this.q = channel;
            this.x = select;
            this.y = block;
            this.z = i;
        }

        @Override // kotlinx.coroutines.channels.q
        public void L(k<?> closed) {
            j.f(closed, "closed");
            if (this.x.g(null)) {
                int i = this.z;
                if (i == 0) {
                    this.x.i(closed.R());
                } else if (i != 1) {
                    if (i == 2) {
                        p<Object, kotlin.coroutines.c<? super R>, Object> pVar = this.y;
                        x.b bVar = x.a;
                        kotlin.coroutines.e.b(pVar, x.a(x.b(new x.a(closed.q))), this.x.l());
                    }
                } else if (closed.q == null) {
                    kotlin.coroutines.e.b(this.y, null, this.x.l());
                } else {
                    this.x.i(closed.R());
                }
            }
        }

        @Override // kotlinx.coroutines.o0
        public void dispose() {
            if (I()) {
                this.q.N();
            }
        }

        @Override // kotlinx.coroutines.channels.s
        public void j(Object token) {
            j.f(token, "token");
            if (token == b.f16440f) {
                token = null;
            }
            p<Object, kotlin.coroutines.c<? super R>, Object> pVar = this.y;
            if (this.z == 2) {
                x.b bVar = x.a;
                token = x.a(x.b(token));
            }
            kotlin.coroutines.e.b(pVar, token, this.x.l());
        }

        @Override // kotlinx.coroutines.channels.s
        public Object m(E e2, Object obj) {
            if (this.x.g(obj)) {
                return e2 != null ? e2 : b.f16440f;
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.i
        public String toString() {
            return "ReceiveSelect[" + this.x + ",receiveMode=" + this.z + ']';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractChannel.kt */
    /* loaded from: classes4.dex */
    public final class e extends kotlinx.coroutines.f {

        /* renamed from: c  reason: collision with root package name */
        private final q<?> f16430c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ a f16431d;

        public e(a aVar, q<?> receive) {
            j.f(receive, "receive");
            this.f16431d = aVar;
            this.f16430c = receive;
        }

        @Override // kotlinx.coroutines.g
        public void a(Throwable th) {
            if (this.f16430c.I()) {
                this.f16431d.N();
            }
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
            a(th);
            return kotlin.p.a;
        }

        public String toString() {
            return "RemoveReceiveOnCancel[" + this.f16430c + ']';
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: AbstractChannel.kt */
    /* loaded from: classes4.dex */
    public static final class f<E> extends i.c<u> {

        /* renamed from: d  reason: collision with root package name */
        public Object f16432d;

        /* renamed from: e  reason: collision with root package name */
        public E f16433e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(kotlinx.coroutines.internal.g queue) {
            super(queue);
            j.f(queue, "queue");
        }

        @Override // kotlinx.coroutines.internal.i.c, kotlinx.coroutines.internal.i.a
        protected Object c(kotlinx.coroutines.internal.i affected) {
            j.f(affected, "affected");
            if (affected instanceof k) {
                return affected;
            }
            if (!(affected instanceof u)) {
                return b.f16437c;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: m */
        public boolean l(u node) {
            j.f(node, "node");
            Object O = node.O(this);
            if (O == null) {
                return false;
            }
            this.f16432d = O;
            this.f16433e = (E) node.M();
            return true;
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    /* loaded from: classes4.dex */
    public static final class g extends i.b {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.internal.i f16434d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ a f16435e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(kotlinx.coroutines.internal.i iVar, kotlinx.coroutines.internal.i iVar2, a aVar) {
            super(iVar2);
            this.f16434d = iVar;
            this.f16435e = aVar;
        }

        /* renamed from: h */
        public Object e(kotlinx.coroutines.internal.i affected) {
            j.f(affected, "affected");
            if (this.f16435e.L()) {
                return null;
            }
            return kotlinx.coroutines.internal.h.b();
        }
    }

    /* compiled from: AbstractChannel.kt */
    /* loaded from: classes4.dex */
    public static final class h implements kotlinx.coroutines.selects.c<E> {
        h() {
        }

        @Override // kotlinx.coroutines.selects.c
        public <R> void a(kotlinx.coroutines.selects.d<? super R> select, p<? super E, ? super kotlin.coroutines.c<? super R>, ? extends Object> block) {
            j.f(select, "select");
            j.f(block, "block");
            a.this.R(select, block);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean I(kotlinx.coroutines.channels.q<? super E> r8) {
        /*
            r7 = this;
            boolean r0 = r7.K()
        */
        //  java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0029
            kotlinx.coroutines.internal.g r0 = r7.o()
        L_0x000e:
            java.lang.Object r4 = r0.C()
            if (r4 == 0) goto L_0x0023
            kotlinx.coroutines.internal.i r4 = (kotlinx.coroutines.internal.i) r4
            boolean r5 = r4 instanceof kotlinx.coroutines.channels.u
            r5 = r5 ^ r3
            if (r5 != 0) goto L_0x001c
            goto L_0x004b
        L_0x001c:
            boolean r4 = r4.u(r8, r0)
            if (r4 == 0) goto L_0x000e
            goto L_0x004a
        L_0x0023:
            kotlin.TypeCastException r8 = new kotlin.TypeCastException
            r8.<init>(r1)
            throw r8
        L_0x0029:
            kotlinx.coroutines.internal.g r0 = r7.o()
            kotlinx.coroutines.channels.a$g r4 = new kotlinx.coroutines.channels.a$g
            r4.<init>(r8, r8, r7)
        L_0x0032:
            java.lang.Object r5 = r0.C()
            if (r5 == 0) goto L_0x0051
            kotlinx.coroutines.internal.i r5 = (kotlinx.coroutines.internal.i) r5
            boolean r6 = r5 instanceof kotlinx.coroutines.channels.u
            r6 = r6 ^ r3
            if (r6 != 0) goto L_0x0040
            goto L_0x004b
        L_0x0040:
            int r5 = r5.K(r8, r0, r4)
            if (r5 == r3) goto L_0x004a
            r6 = 2
            if (r5 == r6) goto L_0x004b
            goto L_0x0032
        L_0x004a:
            r2 = 1
        L_0x004b:
            if (r2 == 0) goto L_0x0050
            r7.O()
        L_0x0050:
            return r2
        L_0x0051:
            kotlin.TypeCastException r8 = new kotlin.TypeCastException
            r8.<init>(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.a.I(kotlinx.coroutines.channels.q):boolean");
    }

    private final <R> boolean J(kotlinx.coroutines.selects.d<? super R> dVar, p<Object, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar, int i) {
        d dVar2 = new d(this, dVar, pVar, i);
        boolean I = I(dVar2);
        if (I) {
            dVar.k(dVar2);
        }
        return I;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> void R(kotlinx.coroutines.selects.d<? super R> dVar, p<? super E, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        while (!dVar.e()) {
            if (!M()) {
                Object Q = Q(dVar);
                if (Q != kotlinx.coroutines.selects.e.c()) {
                    if (Q != b.f16437c) {
                        if (Q instanceof k) {
                            Throwable th = ((k) Q).q;
                            if (th != null) {
                                throw s.j(th);
                            } else if (dVar.g(null)) {
                                kotlinx.coroutines.d2.b.c(pVar, null, dVar.l());
                                return;
                            } else {
                                return;
                            }
                        } else {
                            kotlinx.coroutines.d2.b.c(pVar, Q, dVar.l());
                            return;
                        }
                    }
                } else {
                    return;
                }
            } else if (pVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type suspend (kotlin.Any?) -> R");
            } else if (J(dVar, pVar, 1)) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S(kotlinx.coroutines.h<?> hVar, q<?> qVar) {
        hVar.f(new e(this, qVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.c
    public s<E> A() {
        s<E> A = super.A();
        if (A != null && !(A instanceof k)) {
            N();
        }
        return A;
    }

    public boolean F(Throwable th) {
        boolean m = m(th);
        G();
        return m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G() {
        k<?> k = k();
        if (k != null) {
            while (true) {
                u B = B();
                if (B == null) {
                    throw new IllegalStateException("Cannot happen".toString());
                } else if (!(B instanceof k)) {
                    B.N(k);
                } else if (g0.a()) {
                    if (!(B == k)) {
                        throw new AssertionError();
                    }
                    return;
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalStateException("Cannot happen".toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final f<E> H() {
        return new f<>(o());
    }

    protected abstract boolean K();

    protected abstract boolean L();

    public final boolean M() {
        return !(o().B() instanceof u) && L();
    }

    protected void N() {
    }

    protected void O() {
    }

    protected Object P() {
        u B;
        Object O;
        do {
            B = B();
            if (B == null) {
                return b.f16437c;
            }
            O = B.O(null);
        } while (O == null);
        B.L(O);
        return B.M();
    }

    protected Object Q(kotlinx.coroutines.selects.d<?> select) {
        j.f(select, "select");
        f<E> H = H();
        Object n = select.n(H);
        if (n != null) {
            return n;
        }
        u k = H.k();
        Object obj = H.f16432d;
        if (obj == null) {
            j.n();
        }
        k.L(obj);
        return H.f16433e;
    }

    @Override // kotlinx.coroutines.channels.r
    public final void a(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException(h0.a(this) + " was cancelled");
        }
        F(cancellationException);
    }

    @Override // kotlinx.coroutines.channels.r
    public final kotlinx.coroutines.selects.c<E> e() {
        return new h();
    }

    @Override // kotlinx.coroutines.channels.r
    public final h<E> iterator() {
        return new b(this);
    }
}

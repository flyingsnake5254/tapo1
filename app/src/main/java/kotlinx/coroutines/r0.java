package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.f;
import kotlin.jvm.internal.j;
import kotlin.v.g;
import kotlinx.coroutines.internal.k;
import kotlinx.coroutines.internal.t;
import kotlinx.coroutines.internal.y;
import kotlinx.coroutines.internal.z;

/* compiled from: EventLoop.common.kt */
/* loaded from: classes4.dex */
public abstract class r0 extends s0 {
    private static final AtomicReferenceFieldUpdater q = AtomicReferenceFieldUpdater.newUpdater(r0.class, Object.class, "_queue");
    private static final AtomicReferenceFieldUpdater x = AtomicReferenceFieldUpdater.newUpdater(r0.class, Object.class, "_delayed");
    private volatile boolean isCompleted;
    private volatile Object _queue = null;
    private volatile Object _delayed = null;

    /* compiled from: EventLoop.common.kt */
    /* loaded from: classes4.dex */
    public static abstract class a implements Runnable, Comparable<a>, o0, z {

        /* renamed from: c  reason: collision with root package name */
        private Object f16527c;

        /* renamed from: d  reason: collision with root package name */
        private int f16528d;

        /* renamed from: f  reason: collision with root package name */
        public long f16529f;

        @Override // kotlinx.coroutines.internal.z
        public void a(y<?> yVar) {
            t tVar;
            Object obj = this.f16527c;
            tVar = u0.a;
            if (obj != tVar) {
                this.f16527c = yVar;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        @Override // kotlinx.coroutines.internal.z
        public y<?> b() {
            Object obj = this.f16527c;
            if (!(obj instanceof y)) {
                obj = null;
            }
            return (y) obj;
        }

        @Override // kotlinx.coroutines.internal.z
        public int d() {
            return this.f16528d;
        }

        @Override // kotlinx.coroutines.o0
        public final synchronized void dispose() {
            t tVar;
            t tVar2;
            Object obj = this.f16527c;
            tVar = u0.a;
            if (obj != tVar) {
                if (!(obj instanceof b)) {
                    obj = null;
                }
                b bVar = (b) obj;
                if (bVar != null) {
                    bVar.g(this);
                }
                tVar2 = u0.a;
                this.f16527c = tVar2;
            }
        }

        /* renamed from: e */
        public int compareTo(a other) {
            j.f(other, "other");
            int i = ((this.f16529f - other.f16529f) > 0L ? 1 : ((this.f16529f - other.f16529f) == 0L ? 0 : -1));
            if (i > 0) {
                return 1;
            }
            return i < 0 ? -1 : 0;
        }

        public final synchronized int f(long j, b delayed, r0 eventLoop) {
            t tVar;
            j.f(delayed, "delayed");
            j.f(eventLoop, "eventLoop");
            Object obj = this.f16527c;
            tVar = u0.a;
            if (obj == tVar) {
                return 2;
            }
            synchronized (delayed) {
                a b2 = delayed.b();
                if (eventLoop.isCompleted) {
                    return 1;
                }
                if (b2 == null) {
                    delayed.f16530c = j;
                } else {
                    long j2 = b2.f16529f;
                    if (j2 - j < 0) {
                        j = j2;
                    }
                    if (j - delayed.f16530c > 0) {
                        delayed.f16530c = j;
                    }
                }
                long j3 = this.f16529f;
                long j4 = delayed.f16530c;
                if (j3 - j4 < 0) {
                    this.f16529f = j4;
                }
                delayed.a(this);
                return 0;
            }
        }

        public final boolean g(long j) {
            return j - this.f16529f >= 0;
        }

        @Override // kotlinx.coroutines.internal.z
        public void h(int i) {
            this.f16528d = i;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f16529f + ']';
        }
    }

    /* compiled from: EventLoop.common.kt */
    /* loaded from: classes4.dex */
    public static final class b extends y<a> {

        /* renamed from: c  reason: collision with root package name */
        public long f16530c;

        public b(long j) {
            this.f16530c = j;
        }
    }

    private final void H() {
        t tVar;
        t tVar2;
        if (!g0.a() || this.isCompleted) {
            while (true) {
                Object obj = this._queue;
                if (obj == null) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = q;
                    tVar = u0.f16571b;
                    if (atomicReferenceFieldUpdater.compareAndSet(this, null, tVar)) {
                        return;
                    }
                } else if (obj instanceof k) {
                    ((k) obj).g();
                    return;
                } else {
                    tVar2 = u0.f16571b;
                    if (obj != tVar2) {
                        k kVar = new k(8, true);
                        kVar.d((Runnable) obj);
                        if (q.compareAndSet(this, obj, kVar)) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        } else {
            throw new AssertionError();
        }
    }

    private final Runnable I() {
        t tVar;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof k) {
                k kVar = (k) obj;
                Object m = kVar.m();
                if (m != k.f16486c) {
                    return (Runnable) m;
                }
                q.compareAndSet(this, obj, kVar.l());
            } else {
                tVar = u0.f16571b;
                if (obj == tVar) {
                    return null;
                }
                if (q.compareAndSet(this, obj, null)) {
                    return (Runnable) obj;
                }
            }
        }
    }

    private final boolean K(Runnable runnable) {
        t tVar;
        while (true) {
            Object obj = this._queue;
            if (this.isCompleted) {
                return false;
            }
            if (obj == null) {
                if (q.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof k) {
                k kVar = (k) obj;
                int d2 = kVar.d(runnable);
                if (d2 == 0) {
                    return true;
                }
                if (d2 == 1) {
                    q.compareAndSet(this, obj, kVar.l());
                } else if (d2 == 2) {
                    return false;
                }
            } else {
                tVar = u0.f16571b;
                if (obj == tVar) {
                    return false;
                }
                k kVar2 = new k(8, true);
                kVar2.d((Runnable) obj);
                kVar2.d(runnable);
                if (q.compareAndSet(this, obj, kVar2)) {
                    return true;
                }
            }
        }
    }

    private final void N() {
        a i;
        y1 a2 = z1.a();
        long nanoTime = a2 != null ? a2.nanoTime() : System.nanoTime();
        while (true) {
            b bVar = (b) this._delayed;
            if (bVar != null && (i = bVar.i()) != null) {
                E(nanoTime, i);
            } else {
                return;
            }
        }
    }

    private final int Q(long j, a aVar) {
        if (this.isCompleted) {
            return 1;
        }
        b bVar = (b) this._delayed;
        if (bVar == null) {
            x.compareAndSet(this, null, new b(j));
            Object obj = this._delayed;
            if (obj == null) {
                j.n();
            }
            bVar = (b) obj;
        }
        return aVar.f(j, bVar, this);
    }

    private final boolean R(a aVar) {
        b bVar = (b) this._delayed;
        return (bVar != null ? bVar.e() : null) == aVar;
    }

    public final void J(Runnable task) {
        j.f(task, "task");
        if (K(task)) {
            F();
        } else {
            i0.z.J(task);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean L() {
        t tVar;
        if (!B()) {
            return false;
        }
        b bVar = (b) this._delayed;
        if (bVar != null && !bVar.d()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof k) {
                return ((k) obj).j();
            }
            tVar = u0.f16571b;
            if (obj != tVar) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long M() {
        /*
            r7 = this;
            boolean r0 = r7.C()
            if (r0 == 0) goto L_0x000b
            long r0 = r7.x()
            return r0
        L_0x000b:
            java.lang.Object r0 = r7._delayed
            kotlinx.coroutines.r0$b r0 = (kotlinx.coroutines.r0.b) r0
            if (r0 == 0) goto L_0x004f
            boolean r1 = r0.d()
            if (r1 != 0) goto L_0x004f
            kotlinx.coroutines.y1 r1 = kotlinx.coroutines.z1.a()
            if (r1 == 0) goto L_0x0022
            long r1 = r1.nanoTime()
            goto L_0x0026
        L_0x0022:
            long r1 = java.lang.System.nanoTime()
        L_0x0026:
            monitor-enter(r0)
            kotlinx.coroutines.internal.z r3 = r0.b()     // Catch: all -> 0x004c
            r4 = 0
            if (r3 == 0) goto L_0x0046
            kotlinx.coroutines.r0$a r3 = (kotlinx.coroutines.r0.a) r3     // Catch: all -> 0x004c
            boolean r5 = r3.g(r1)     // Catch: all -> 0x004c
            r6 = 0
            if (r5 == 0) goto L_0x003c
            boolean r3 = r7.K(r3)     // Catch: all -> 0x004c
            goto L_0x003d
        L_0x003c:
            r3 = 0
        L_0x003d:
            if (r3 == 0) goto L_0x0044
            kotlinx.coroutines.internal.z r3 = r0.h(r6)     // Catch: all -> 0x004c
            r4 = r3
        L_0x0044:
            monitor-exit(r0)
            goto L_0x0047
        L_0x0046:
            monitor-exit(r0)
        L_0x0047:
            kotlinx.coroutines.r0$a r4 = (kotlinx.coroutines.r0.a) r4
            if (r4 == 0) goto L_0x004f
            goto L_0x0026
        L_0x004c:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x004f:
            java.lang.Runnable r0 = r7.I()
            if (r0 == 0) goto L_0x0058
            r0.run()
        L_0x0058:
            long r0 = r7.x()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.r0.M():long");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void O() {
        this._queue = null;
        this._delayed = null;
    }

    public final void P(long j, a delayedTask) {
        j.f(delayedTask, "delayedTask");
        int Q = Q(j, delayedTask);
        if (Q != 0) {
            if (Q == 1) {
                E(j, delayedTask);
            } else if (Q != 2) {
                throw new IllegalStateException("unexpected result".toString());
            }
        } else if (R(delayedTask)) {
            F();
        }
    }

    @Override // kotlinx.coroutines.y
    public final void dispatch(f context, Runnable block) {
        j.f(context, "context");
        j.f(block, "block");
        J(block);
    }

    @Override // kotlinx.coroutines.q0
    protected void shutdown() {
        x1.f16573b.b();
        this.isCompleted = true;
        H();
        do {
        } while (M() <= 0);
        N();
    }

    @Override // kotlinx.coroutines.q0
    protected long x() {
        a e2;
        long c2;
        t tVar;
        if (super.x() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof k)) {
                tVar = u0.f16571b;
                return obj == tVar ? Long.MAX_VALUE : 0L;
            } else if (!((k) obj).j()) {
                return 0L;
            }
        }
        b bVar = (b) this._delayed;
        if (bVar == null || (e2 = bVar.e()) == null) {
            return Long.MAX_VALUE;
        }
        long j = e2.f16529f;
        y1 a2 = z1.a();
        c2 = g.c(j - (a2 != null ? a2.nanoTime() : System.nanoTime()), 0L);
        return c2;
    }
}

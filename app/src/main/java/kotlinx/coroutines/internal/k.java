package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.f;
import kotlinx.coroutines.g0;

/* compiled from: LockFreeTaskQueue.kt */
/* loaded from: classes4.dex */
public final class k<E> {
    private volatile Object _next = null;
    public volatile /* synthetic */ long _state$internal = 0;

    /* renamed from: e  reason: collision with root package name */
    private final int f16488e;

    /* renamed from: f  reason: collision with root package name */
    public /* synthetic */ AtomicReferenceArray f16489f;
    private final int g;
    private final boolean h;

    /* renamed from: d  reason: collision with root package name */
    public static final a f16487d = new a(null);

    /* renamed from: c  reason: collision with root package name */
    public static final t f16486c = new t("REMOVE_FROZEN");
    private static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_next");

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f16485b = AtomicLongFieldUpdater.newUpdater(k.class, "_state$internal");

    /* compiled from: LockFreeTaskQueue.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public final int a(long j) {
            return (j & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j, int i) {
            return d(j, 1073741823L) | (i << 0);
        }

        public final long c(long j, int i) {
            return d(j, 1152921503533105152L) | (i << 30);
        }

        public final long d(long j, long j2) {
            return j & (~j2);
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: LockFreeTaskQueue.kt */
    /* loaded from: classes4.dex */
    public static final class b {
        public final int a;

        public b(int i) {
            this.a = i;
        }
    }

    public k(int i, boolean z) {
        this.g = i;
        this.h = z;
        int i2 = i - 1;
        this.f16488e = i2;
        this.f16489f = new AtomicReferenceArray(i);
        boolean z2 = false;
        if (i2 <= 1073741823) {
            if (!((i & i2) == 0 ? true : z2)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final k<E> e(long j) {
        k<E> kVar = new k<>(this.g * 2, this.h);
        int i = (int) ((1073741823 & j) >> 0);
        int i2 = (int) ((1152921503533105152L & j) >> 30);
        while (true) {
            int i3 = this.f16488e;
            if ((i & i3) != (i2 & i3)) {
                Object obj = this.f16489f.get(i3 & i);
                if (obj == null) {
                    obj = new b(i);
                }
                kVar.f16489f.set(kVar.f16488e & i, obj);
                i++;
            } else {
                kVar._state$internal = f16487d.d(j, 1152921504606846976L);
                return kVar;
            }
        }
    }

    private final k<E> f(long j) {
        while (true) {
            k<E> kVar = (k) this._next;
            if (kVar != null) {
                return kVar;
            }
            a.compareAndSet(this, null, e(j));
        }
    }

    private final k<E> h(int i, E e2) {
        Object obj = this.f16489f.get(this.f16488e & i);
        if (!(obj instanceof b) || ((b) obj).a != i) {
            return null;
        }
        this.f16489f.set(i & this.f16488e, e2);
        return this;
    }

    private final long k() {
        long j;
        long j2;
        do {
            j = this._state$internal;
            if ((j & 1152921504606846976L) != 0) {
                return j;
            }
            j2 = j | 1152921504606846976L;
        } while (!f16485b.compareAndSet(this, j, j2));
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k<E> n(int i, int i2) {
        long j;
        a aVar;
        int i3;
        do {
            j = this._state$internal;
            aVar = f16487d;
            boolean z = false;
            i3 = (int) ((1073741823 & j) >> 0);
            if (g0.a()) {
                if (i3 == i) {
                    z = true;
                }
                if (!z) {
                    throw new AssertionError();
                }
            }
            if ((1152921504606846976L & j) != 0) {
                return l();
            }
        } while (!f16485b.compareAndSet(this, j, aVar.b(j, i2)));
        this.f16489f.set(this.f16488e & i3, null);
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0053, code lost:
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int d(E r14) {
        /*
            r13 = this;
            java.lang.String r0 = "element"
            kotlin.jvm.internal.j.f(r14, r0)
        L_0x0005:
            long r3 = r13._state$internal
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r3
            r7 = 0
            int r2 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r2 == 0) goto L_0x0017
            kotlinx.coroutines.internal.k$a r14 = kotlinx.coroutines.internal.k.f16487d
            int r14 = r14.a(r3)
            return r14
        L_0x0017:
            kotlinx.coroutines.internal.k$a r0 = kotlinx.coroutines.internal.k.f16487d
            r1 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r1 = r1 & r3
            r9 = 0
            long r1 = r1 >> r9
            int r2 = (int) r1
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r5 = r5 & r3
            r1 = 30
            long r5 = r5 >> r1
            int r10 = (int) r5
            int r11 = r13.f16488e
            int r1 = r10 + 2
            r1 = r1 & r11
            r5 = r2 & r11
            r6 = 1
            if (r1 != r5) goto L_0x0035
            return r6
        L_0x0035:
            boolean r1 = r13.h
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r1 != 0) goto L_0x0054
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r13.f16489f
            r12 = r10 & r11
            java.lang.Object r1 = r1.get(r12)
            if (r1 == 0) goto L_0x0054
            int r0 = r13.g
            r1 = 1024(0x400, float:1.435E-42)
            if (r0 < r1) goto L_0x0053
            int r10 = r10 - r2
            r1 = r10 & r5
            int r0 = r0 >> 1
            if (r1 <= r0) goto L_0x0005
        L_0x0053:
            return r6
        L_0x0054:
            int r1 = r10 + 1
            r1 = r1 & r5
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = kotlinx.coroutines.internal.k.f16485b
            long r5 = r0.c(r3, r1)
            r1 = r2
            r2 = r13
            boolean r0 = r1.compareAndSet(r2, r3, r5)
            if (r0 == 0) goto L_0x0005
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r13.f16489f
            r1 = r10 & r11
            r0.set(r1, r14)
            r0 = r13
        L_0x006d:
            long r1 = r0._state$internal
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r3 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x0077
            goto L_0x0082
        L_0x0077:
            kotlinx.coroutines.internal.k r0 = r0.l()
            kotlinx.coroutines.internal.k r0 = r0.h(r10, r14)
            if (r0 == 0) goto L_0x0082
            goto L_0x006d
        L_0x0082:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.k.d(java.lang.Object):int");
    }

    public final boolean g() {
        long j;
        do {
            j = this._state$internal;
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!f16485b.compareAndSet(this, j, j | 2305843009213693952L));
        return true;
    }

    public final int i() {
        long j = this._state$internal;
        return 1073741823 & (((int) ((j & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j) >> 0)));
    }

    public final boolean j() {
        long j = this._state$internal;
        return ((int) ((1073741823 & j) >> 0)) == ((int) ((j & 1152921503533105152L) >> 30));
    }

    public final k<E> l() {
        return f(k());
    }

    public final Object m() {
        Object obj;
        while (true) {
            long j = this._state$internal;
            if ((1152921504606846976L & j) == 0) {
                a aVar = f16487d;
                int i = (int) ((1073741823 & j) >> 0);
                if ((((int) ((1152921503533105152L & j) >> 30)) & this.f16488e) != (this.f16488e & i)) {
                    obj = this.f16489f.get(this.f16488e & i);
                    if (obj != null) {
                        if (!(obj instanceof b)) {
                            int i2 = (i + 1) & 1073741823;
                            if (!f16485b.compareAndSet(this, j, aVar.b(j, i2))) {
                                if (this.h) {
                                    k<E> kVar = this;
                                    do {
                                        kVar = kVar.n(i, i2);
                                    } while (kVar != null);
                                    break;
                                }
                            } else {
                                this.f16489f.set(this.f16488e & i, null);
                                break;
                            }
                        } else {
                            return null;
                        }
                    } else if (this.h) {
                        return null;
                    }
                } else {
                    return null;
                }
            } else {
                return f16486c;
            }
        }
        return obj;
    }
}

package kotlinx.coroutines.channels;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: ArrayChannel.kt */
/* loaded from: classes4.dex */
public class d<E> extends a<E> {

    /* renamed from: f  reason: collision with root package name */
    private final ReentrantLock f16445f;
    private Object[] q;
    private volatile int size;
    private int x;
    private final int y;

    public d(int i) {
        this.y = i;
        if (i < 1 ? false : true) {
            this.f16445f = new ReentrantLock();
            this.q = new Object[Math.min(i, 8)];
            return;
        }
        throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + i + " was specified").toString());
    }

    private final void T(int i) {
        Object[] objArr = this.q;
        if (i >= objArr.length) {
            Object[] objArr2 = new Object[Math.min(objArr.length * 2, this.y)];
            for (int i2 = 0; i2 < i; i2++) {
                Object[] objArr3 = this.q;
                objArr2[i2] = objArr3[(this.x + i2) % objArr3.length];
            }
            this.q = objArr2;
            this.x = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Finally extract failed */
    @Override // kotlinx.coroutines.channels.a
    public void G() {
        ReentrantLock reentrantLock = this.f16445f;
        reentrantLock.lock();
        try {
            int i = this.size;
            for (int i2 = 0; i2 < i; i2++) {
                this.q[this.x] = 0;
                this.x = (this.x + 1) % this.q.length;
            }
            this.size = 0;
            p pVar = p.a;
            reentrantLock.unlock();
            super.G();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.a
    protected final boolean K() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.a
    protected final boolean L() {
        return this.size == 0;
    }

    @Override // kotlinx.coroutines.channels.a
    protected Object P() {
        Object obj;
        ReentrantLock reentrantLock = this.f16445f;
        reentrantLock.lock();
        try {
            int i = this.size;
            if (i == 0) {
                Object k = k();
                if (k == null) {
                    k = b.f16437c;
                }
                return k;
            }
            Object[] objArr = this.q;
            int i2 = this.x;
            Object obj2 = objArr[i2];
            u uVar = null;
            objArr[i2] = null;
            this.size = i - 1;
            Object obj3 = b.f16437c;
            if (i == this.y) {
                uVar = null;
                obj = null;
                while (true) {
                    u B = B();
                    if (B == null) {
                        break;
                    }
                    obj = B.O(null);
                    if (obj != null) {
                        obj3 = B.M();
                        uVar = B;
                        break;
                    }
                    uVar = B;
                }
            } else {
                obj = null;
            }
            if (obj3 != b.f16437c && !(obj3 instanceof k)) {
                this.size = i;
                Object[] objArr2 = this.q;
                objArr2[(this.x + i) % objArr2.length] = obj3;
            }
            this.x = (this.x + 1) % this.q.length;
            p pVar = p.a;
            if (obj != null) {
                if (uVar == null) {
                    j.n();
                }
                uVar.L(obj);
            }
            return obj2;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00bf A[Catch: all -> 0x00e8, TRY_LEAVE, TryCatch #0 {all -> 0x00e8, blocks: (B:3:0x000a, B:5:0x000e, B:8:0x0015, B:11:0x001b, B:13:0x002f, B:15:0x0039, B:22:0x004f, B:23:0x0054, B:25:0x0057, B:26:0x005a, B:29:0x0065, B:31:0x006b, B:34:0x0077, B:36:0x007b, B:37:0x0089, B:38:0x00a3, B:41:0x00a9, B:43:0x00ad, B:44:0x00b9, B:46:0x00bf, B:49:0x00cf), top: B:59:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00df  */
    @Override // kotlinx.coroutines.channels.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.lang.Object Q(kotlinx.coroutines.selects.d<?> r11) {
        /*
            Method dump skipped, instructions count: 237
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.d.Q(kotlinx.coroutines.selects.d):java.lang.Object");
    }

    @Override // kotlinx.coroutines.channels.c
    protected String j() {
        return "(buffer:capacity=" + this.y + ",size=" + this.size + ')';
    }

    @Override // kotlinx.coroutines.channels.c
    protected final boolean s() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.c
    protected final boolean t() {
        return this.size == this.y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.c
    public Object v(E e2) {
        s<E> A;
        Object m;
        ReentrantLock reentrantLock = this.f16445f;
        reentrantLock.lock();
        try {
            int i = this.size;
            k<?> k = k();
            if (k != null) {
                return k;
            }
            if (i >= this.y) {
                return b.f16436b;
            }
            this.size = i + 1;
            if (i == 0) {
                do {
                    A = A();
                    if (A != null) {
                        if (A instanceof k) {
                            this.size = i;
                            return A;
                        }
                        m = A.m(e2, null);
                    }
                } while (m == null);
                this.size = i;
                p pVar = p.a;
                reentrantLock.unlock();
                A.j(m);
                return A.a();
            }
            T(i);
            Object[] objArr = this.q;
            objArr[(this.x + i) % objArr.length] = e2;
            return b.a;
        } finally {
            reentrantLock.unlock();
        }
    }
}

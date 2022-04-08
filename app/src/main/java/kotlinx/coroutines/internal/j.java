package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.internal.k;

/* compiled from: LockFreeTaskQueue.kt */
/* loaded from: classes4.dex */
public class j<E> {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_cur$internal");
    public volatile /* synthetic */ Object _cur$internal;

    public j(boolean z) {
        this._cur$internal = new k(8, z);
    }

    public final boolean a(E element) {
        kotlin.jvm.internal.j.f(element, "element");
        while (true) {
            k kVar = (k) this._cur$internal;
            int d2 = kVar.d(element);
            if (d2 == 0) {
                return true;
            }
            if (d2 == 1) {
                a.compareAndSet(this, kVar, kVar.l());
            } else if (d2 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            k kVar = (k) this._cur$internal;
            if (!kVar.g()) {
                a.compareAndSet(this, kVar, kVar.l());
            } else {
                return;
            }
        }
    }

    public final int c() {
        return ((k) this._cur$internal).i();
    }

    public final E d() {
        E e2;
        Object obj;
        while (true) {
            k kVar = (k) this._cur$internal;
            while (true) {
                long j = kVar._state$internal;
                e2 = null;
                if ((1152921504606846976L & j) == 0) {
                    k.a aVar = k.f16487d;
                    int i = (int) ((1073741823 & j) >> 0);
                    if ((((int) ((1152921503533105152L & j) >> 30)) & kVar.f16488e) == (kVar.f16488e & i)) {
                        break;
                    }
                    obj = kVar.f16489f.get(kVar.f16488e & i);
                    if (obj != null) {
                        if (!(obj instanceof k.b)) {
                            int i2 = (i + 1) & 1073741823;
                            if (!k.f16485b.compareAndSet(kVar, j, aVar.b(j, i2))) {
                                if (kVar.h) {
                                    k kVar2 = kVar;
                                    do {
                                        kVar2 = kVar2.n(i, i2);
                                    } while (kVar2 != null);
                                    break;
                                }
                            } else {
                                kVar.f16489f.set(kVar.f16488e & i, null);
                                break;
                            }
                        } else {
                            break;
                        }
                    } else if (kVar.h) {
                        break;
                    }
                } else {
                    e2 = (E) k.f16486c;
                    break;
                }
            }
            e2 = (E) obj;
            if (e2 != k.f16486c) {
                return e2;
            }
            a.compareAndSet(this, kVar, kVar.l());
        }
    }
}

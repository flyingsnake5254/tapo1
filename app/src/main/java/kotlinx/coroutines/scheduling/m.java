package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.j;
import kotlin.v.g;

/* compiled from: WorkQueue.kt */
/* loaded from: classes4.dex */
public final class m {
    private static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "lastScheduledTask");

    /* renamed from: b  reason: collision with root package name */
    static final AtomicIntegerFieldUpdater f16554b = AtomicIntegerFieldUpdater.newUpdater(m.class, "producerIndex");

    /* renamed from: c  reason: collision with root package name */
    static final AtomicIntegerFieldUpdater f16555c = AtomicIntegerFieldUpdater.newUpdater(m.class, "consumerIndex");

    /* renamed from: d  reason: collision with root package name */
    private final AtomicReferenceArray<h> f16556d = new AtomicReferenceArray<>(128);
    private volatile Object lastScheduledTask = null;
    volatile int producerIndex = 0;
    volatile int consumerIndex = 0;

    private final void d(d dVar, h hVar) {
        if (!dVar.a(hVar)) {
            throw new IllegalStateException("GlobalQueue could not be closed yet".toString());
        }
    }

    private final void g(d dVar) {
        int b2;
        h hVar;
        b2 = g.b(e() / 2, 1);
        for (int i = 0; i < b2; i++) {
            while (true) {
                int i2 = this.consumerIndex;
                hVar = null;
                if (i2 - this.producerIndex == 0) {
                    break;
                }
                int i3 = i2 & 127;
                if (((h) this.f16556d.get(i3)) != null && f16555c.compareAndSet(this, i2, i2 + 1)) {
                    hVar = (h) this.f16556d.getAndSet(i3, null);
                    break;
                }
            }
            if (hVar != null) {
                d(dVar, hVar);
            } else {
                return;
            }
        }
    }

    private final boolean j(h hVar) {
        if (e() == 127) {
            return false;
        }
        int i = this.producerIndex & 127;
        if (this.f16556d.get(i) != null) {
            return false;
        }
        this.f16556d.lazySet(i, hVar);
        f16554b.incrementAndGet(this);
        return true;
    }

    private final boolean l(long j, m mVar, d dVar) {
        h hVar = (h) mVar.lastScheduledTask;
        if (hVar == null || j - hVar.f16546c < k.a || !a.compareAndSet(mVar, hVar, null)) {
            return false;
        }
        b(hVar, dVar);
        return true;
    }

    public final boolean b(h task, d globalQueue) {
        j.f(task, "task");
        j.f(globalQueue, "globalQueue");
        h hVar = (h) a.getAndSet(this, task);
        if (hVar != null) {
            return c(hVar, globalQueue);
        }
        return true;
    }

    public final boolean c(h task, d globalQueue) {
        j.f(task, "task");
        j.f(globalQueue, "globalQueue");
        boolean z = true;
        while (!j(task)) {
            g(globalQueue);
            z = false;
        }
        return z;
    }

    public final int e() {
        return this.producerIndex - this.consumerIndex;
    }

    public final void f(d globalQueue) {
        h hVar;
        j.f(globalQueue, "globalQueue");
        h hVar2 = (h) a.getAndSet(this, null);
        if (hVar2 != null) {
            d(globalQueue, hVar2);
        }
        while (true) {
            int i = this.consumerIndex;
            if (i - this.producerIndex == 0) {
                hVar = null;
            } else {
                int i2 = i & 127;
                if (((h) this.f16556d.get(i2)) != null && f16555c.compareAndSet(this, i, i + 1)) {
                    hVar = (h) this.f16556d.getAndSet(i2, null);
                }
            }
            if (hVar != null) {
                d(globalQueue, hVar);
            } else {
                return;
            }
        }
    }

    public final h h() {
        h hVar = (h) a.getAndSet(this, null);
        if (hVar != null) {
            return hVar;
        }
        while (true) {
            int i = this.consumerIndex;
            if (i - this.producerIndex == 0) {
                return null;
            }
            int i2 = i & 127;
            if (((h) this.f16556d.get(i2)) != null && f16555c.compareAndSet(this, i, i + 1)) {
                return (h) this.f16556d.getAndSet(i2, null);
            }
        }
    }

    public final int i() {
        return this.lastScheduledTask != null ? e() + 1 : e();
    }

    public final boolean k(m victim, d globalQueue) {
        int b2;
        h hVar;
        j.f(victim, "victim");
        j.f(globalQueue, "globalQueue");
        long a2 = k.g.a();
        int e2 = victim.e();
        if (e2 == 0) {
            return l(a2, victim, globalQueue);
        }
        b2 = g.b(e2 / 2, 1);
        int i = 0;
        boolean z = false;
        while (i < b2) {
            while (true) {
                int i2 = victim.consumerIndex;
                hVar = null;
                if (i2 - victim.producerIndex != 0) {
                    int i3 = i2 & 127;
                    h hVar2 = (h) victim.f16556d.get(i3);
                    if (hVar2 != null) {
                        if (!(a2 - hVar2.f16546c >= k.a || victim.e() > k.f16549b)) {
                            break;
                        } else if (f16555c.compareAndSet(victim, i2, i2 + 1)) {
                            hVar = (h) victim.f16556d.getAndSet(i3, null);
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
            if (hVar == null) {
                break;
            }
            b(hVar, globalQueue);
            i++;
            z = true;
        }
        return z;
    }
}

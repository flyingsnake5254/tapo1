package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: CompletedExceptionally.kt */
/* loaded from: classes4.dex */
public final class k extends r {

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f16509c = AtomicIntegerFieldUpdater.newUpdater(k.class, "_resumed");
    private volatile int _resumed;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public k(kotlin.coroutines.c<?> r3, java.lang.Throwable r4, boolean r5) {
        /*
            r2 = this;
            java.lang.String r0 = "continuation"
            kotlin.jvm.internal.j.f(r3, r0)
            if (r4 == 0) goto L_0x0008
            goto L_0x0023
        L_0x0008:
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Continuation "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = " was cancelled normally"
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r4.<init>(r3)
        L_0x0023:
            r2.<init>(r4, r5)
            r3 = 0
            r2._resumed = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.k.<init>(kotlin.coroutines.c, java.lang.Throwable, boolean):void");
    }

    public final boolean c() {
        return f16509c.compareAndSet(this, 0, 1);
    }
}

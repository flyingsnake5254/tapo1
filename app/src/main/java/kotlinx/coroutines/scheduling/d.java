package kotlinx.coroutines.scheduling;

import kotlinx.coroutines.internal.j;

/* compiled from: Tasks.kt */
/* loaded from: classes4.dex */
public class d extends j<h> {
    public d() {
        super(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x008e, code lost:
        r7 = r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlinx.coroutines.scheduling.h e(kotlinx.coroutines.scheduling.TaskMode r12) {
        /*
            r11 = this;
            java.lang.String r0 = "mode"
            kotlin.jvm.internal.j.f(r12, r0)
        L_0x0005:
            java.lang.Object r0 = r11._cur$internal
            kotlinx.coroutines.internal.k r0 = (kotlinx.coroutines.internal.k) r0
        L_0x0009:
            long r3 = r0._state$internal
            r1 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            r5 = 0
            r7 = 0
            int r8 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r8 == 0) goto L_0x0019
            kotlinx.coroutines.internal.t r7 = kotlinx.coroutines.internal.k.f16486c
            goto L_0x008f
        L_0x0019:
            kotlinx.coroutines.internal.k$a r1 = kotlinx.coroutines.internal.k.f16487d
            r5 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r5 = r5 & r3
            r2 = 0
            long r5 = r5 >> r2
            int r8 = (int) r5
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r5 = r5 & r3
            r9 = 30
            long r5 = r5 >> r9
            int r6 = (int) r5
            int r5 = kotlinx.coroutines.internal.k.a(r0)
            r5 = r5 & r6
            int r6 = kotlinx.coroutines.internal.k.a(r0)
            r6 = r6 & r8
            if (r5 != r6) goto L_0x0039
            goto L_0x008f
        L_0x0039:
            java.util.concurrent.atomic.AtomicReferenceArray r5 = r0.f16489f
            int r6 = kotlinx.coroutines.internal.k.a(r0)
            r6 = r6 & r8
            java.lang.Object r9 = r5.get(r6)
            if (r9 != 0) goto L_0x004d
            boolean r1 = kotlinx.coroutines.internal.k.b(r0)
            if (r1 == 0) goto L_0x0009
            goto L_0x008f
        L_0x004d:
            boolean r5 = r9 instanceof kotlinx.coroutines.internal.k.b
            if (r5 == 0) goto L_0x0052
            goto L_0x008f
        L_0x0052:
            r5 = r9
            kotlinx.coroutines.scheduling.h r5 = (kotlinx.coroutines.scheduling.h) r5
            kotlinx.coroutines.scheduling.TaskMode r5 = r5.a()
            if (r5 != r12) goto L_0x005c
            r2 = 1
        L_0x005c:
            if (r2 != 0) goto L_0x005f
            goto L_0x008f
        L_0x005f:
            int r2 = r8 + 1
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            r10 = r2 & r5
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = kotlinx.coroutines.internal.k.f16485b
            long r5 = r1.b(r3, r10)
            r1 = r2
            r2 = r0
            boolean r1 = r1.compareAndSet(r2, r3, r5)
            if (r1 == 0) goto L_0x007f
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r0.f16489f
            int r2 = kotlinx.coroutines.internal.k.a(r0)
            r2 = r2 & r8
            r1.set(r2, r7)
            goto L_0x008e
        L_0x007f:
            boolean r1 = kotlinx.coroutines.internal.k.b(r0)
            if (r1 != 0) goto L_0x0086
            goto L_0x0009
        L_0x0086:
            r1 = r0
        L_0x0087:
            kotlinx.coroutines.internal.k r1 = kotlinx.coroutines.internal.k.c(r1, r8, r10)
            if (r1 == 0) goto L_0x008e
            goto L_0x0087
        L_0x008e:
            r7 = r9
        L_0x008f:
            kotlinx.coroutines.internal.t r1 = kotlinx.coroutines.internal.k.f16486c
            if (r7 == r1) goto L_0x0096
            kotlinx.coroutines.scheduling.h r7 = (kotlinx.coroutines.scheduling.h) r7
            return r7
        L_0x0096:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.internal.j.a
            kotlinx.coroutines.internal.k r2 = r0.l()
            r1.compareAndSet(r11, r0, r2)
            goto L_0x0005
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.d.e(kotlinx.coroutines.scheduling.TaskMode):kotlinx.coroutines.scheduling.h");
    }
}

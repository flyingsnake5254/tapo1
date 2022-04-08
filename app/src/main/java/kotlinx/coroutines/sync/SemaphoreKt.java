package kotlinx.coroutines.sync;

import kotlinx.coroutines.internal.t;
import kotlinx.coroutines.internal.w;

/* compiled from: Semaphore.kt */
/* loaded from: classes4.dex */
public final class SemaphoreKt {
    private static final t a = new t("RESUMED");

    /* renamed from: b  reason: collision with root package name */
    private static final t f16566b = new t("CANCELLED");

    /* renamed from: c  reason: collision with root package name */
    private static final int f16567c;

    static {
        int d2;
        d2 = w.d("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);
        f16567c = d2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object a(kotlinx.coroutines.sync.c r4, kotlin.jvm.b.a<? extends T> r5, kotlin.coroutines.c<? super T> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.sync.SemaphoreKt$withPermit$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.sync.SemaphoreKt$withPermit$1 r0 = (kotlinx.coroutines.sync.SemaphoreKt$withPermit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.sync.SemaphoreKt$withPermit$1 r0 = new kotlinx.coroutines.sync.SemaphoreKt$withPermit$1
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r4 = r0.L$1
            r5 = r4
            kotlin.jvm.b.a r5 = (kotlin.jvm.b.a) r5
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.sync.c r4 = (kotlinx.coroutines.sync.c) r4
            kotlin.k.b(r6)
            goto L_0x004a
        L_0x0032:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003a:
            kotlin.k.b(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r4.a(r0)
            if (r6 != r1) goto L_0x004a
            return r1
        L_0x004a:
            java.lang.Object r5 = r5.invoke()     // Catch: all -> 0x0058
            kotlin.jvm.internal.i.b(r3)
            r4.release()
            kotlin.jvm.internal.i.a(r3)
            return r5
        L_0x0058:
            r5 = move-exception
            kotlin.jvm.internal.i.b(r3)
            r4.release()
            kotlin.jvm.internal.i.a(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreKt.a(kotlinx.coroutines.sync.c, kotlin.jvm.b.a, kotlin.coroutines.c):java.lang.Object");
    }
}

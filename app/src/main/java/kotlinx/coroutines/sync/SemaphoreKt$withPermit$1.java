package kotlinx.coroutines.sync;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

/* compiled from: Semaphore.kt */
@d(c = "kotlinx.coroutines.sync.SemaphoreKt", f = "Semaphore.kt", l = {74}, m = "withPermit")
/* loaded from: classes4.dex */
public final class SemaphoreKt$withPermit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public SemaphoreKt$withPermit$1(c cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SemaphoreKt.a(null, null, this);
    }
}

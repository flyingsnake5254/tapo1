package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

/* compiled from: SafeCollector.kt */
@d(c = "kotlinx.coroutines.flow.internal.SafeCollectorKt$unsafeFlow$1", f = "SafeCollector.kt", l = {121}, m = "collect")
/* loaded from: classes4.dex */
public final class SafeCollectorKt$unsafeFlow$1$collect$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ e this$0;

    public SafeCollectorKt$unsafeFlow$1$collect$1(e eVar, c cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}

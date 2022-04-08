package kotlinx.coroutines.flow;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.flow.FlowKt__ReduceKt;

@d(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$$inlined$collect$2", f = "Reduce.kt", l = {136}, m = "emit")
/* loaded from: classes4.dex */
public final class FlowKt__ReduceKt$fold$$inlined$collect$2$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowKt__ReduceKt.a this$0;

    public FlowKt__ReduceKt$fold$$inlined$collect$2$1(FlowKt__ReduceKt.a aVar, c cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}

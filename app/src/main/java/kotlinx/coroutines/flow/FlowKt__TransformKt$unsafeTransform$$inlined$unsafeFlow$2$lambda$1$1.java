package kotlinx.coroutines.flow;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes4.dex */
public final class FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$2$lambda$1$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ b2 this$0;

    public FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$2$lambda$1$1(b2 b2Var, c cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}

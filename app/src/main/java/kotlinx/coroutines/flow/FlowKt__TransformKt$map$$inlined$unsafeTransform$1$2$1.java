package kotlinx.coroutines.flow;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes4.dex */
public final class FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ r1 this$0;

    public FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2$1(r1 r1Var, c cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}

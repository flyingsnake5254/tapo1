package kotlinx.coroutines.flow;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: Collect.kt */
/* loaded from: classes4.dex */
public final class FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1 implements b<T> {
    final /* synthetic */ FlowKt__EmittersKt$transform$1 a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f16450b;

    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1.this.a(null, this);
        }
    }

    public FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1(FlowKt__EmittersKt$transform$1 flowKt__EmittersKt$transform$1, b bVar) {
        this.a = flowKt__EmittersKt$transform$1;
        this.f16450b = bVar;
    }

    @Override // kotlinx.coroutines.flow.b
    public Object a(Object obj, c cVar) {
        return this.a.$transform.invoke(this.f16450b, obj, cVar);
    }
}

package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.j;
import kotlin.k;
import kotlinx.coroutines.channels.r;

/* compiled from: Combine.kt */
/* loaded from: classes4.dex */
public final class CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$4 extends SuspendLambda implements p<Object, c<? super kotlin.p>, Object> {
    final /* synthetic */ r $firstChannel$inlined;
    final /* synthetic */ Ref$BooleanRef $firstIsClosed$inlined;
    final /* synthetic */ Ref$ObjectRef $firstValue$inlined;
    final /* synthetic */ p $onReceive;
    final /* synthetic */ r $secondChannel$inlined;
    final /* synthetic */ Ref$BooleanRef $secondIsClosed$inlined;
    final /* synthetic */ Ref$ObjectRef $secondValue$inlined;
    Object L$0;
    int label;
    private Object p$0;
    final /* synthetic */ c this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$4(p pVar, c cVar, c cVar2, Ref$BooleanRef ref$BooleanRef, r rVar, Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2, Ref$BooleanRef ref$BooleanRef2, r rVar2) {
        super(2, cVar);
        this.$onReceive = pVar;
        this.$firstIsClosed$inlined = ref$BooleanRef;
        this.$firstChannel$inlined = rVar;
        this.$firstValue$inlined = ref$ObjectRef;
        this.$secondValue$inlined = ref$ObjectRef2;
        this.$secondIsClosed$inlined = ref$BooleanRef2;
        this.$secondChannel$inlined = rVar2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<kotlin.p> create(Object obj, c<?> completion) {
        j.f(completion, "completion");
        CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$4 combineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$4 = new CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$4(this.$onReceive, completion, this.this$0, this.$firstIsClosed$inlined, this.$firstChannel$inlined, this.$firstValue$inlined, this.$secondValue$inlined, this.$secondIsClosed$inlined, this.$secondChannel$inlined);
        combineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$4.p$0 = obj;
        return combineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$4;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(Object obj, c<? super kotlin.p> cVar) {
        return ((CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$4) create(obj, cVar)).invokeSuspend(kotlin.p.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d2;
        d2 = b.d();
        int i = this.label;
        if (i == 0) {
            k.b(obj);
            Object obj2 = this.p$0;
            if (obj2 == null) {
                this.$secondIsClosed$inlined.element = true;
            } else {
                p pVar = this.$onReceive;
                this.L$0 = obj2;
                this.label = 1;
                if (pVar.invoke(obj2, this) == d2) {
                    return d2;
                }
            }
        } else if (i == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return kotlin.p.a;
    }
}

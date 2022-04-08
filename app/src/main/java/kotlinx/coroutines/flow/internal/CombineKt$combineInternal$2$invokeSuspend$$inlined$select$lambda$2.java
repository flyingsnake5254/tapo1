package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.a;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.j;
import kotlin.k;
import kotlinx.coroutines.channels.r;

/* compiled from: Combine.kt */
/* loaded from: classes4.dex */
public final class CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$2 extends SuspendLambda implements p<Object, c<? super kotlin.p>, Object> {
    final /* synthetic */ r[] $channels$inlined;
    final /* synthetic */ int $i$inlined;
    final /* synthetic */ Boolean[] $isClosed$inlined;
    final /* synthetic */ Object[] $latestValues$inlined;
    final /* synthetic */ p $onReceive;
    final /* synthetic */ int $size$inlined;
    Object L$0;
    int label;
    private Object p$0;
    final /* synthetic */ CombineKt$combineInternal$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$2(p pVar, c cVar, int i, CombineKt$combineInternal$2 combineKt$combineInternal$2, int i2, Boolean[] boolArr, r[] rVarArr, Object[] objArr) {
        super(2, cVar);
        this.$onReceive = pVar;
        this.$i$inlined = i;
        this.this$0 = combineKt$combineInternal$2;
        this.$size$inlined = i2;
        this.$isClosed$inlined = boolArr;
        this.$channels$inlined = rVarArr;
        this.$latestValues$inlined = objArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<kotlin.p> create(Object obj, c<?> completion) {
        j.f(completion, "completion");
        CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$2 combineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$2 = new CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$2(this.$onReceive, completion, this.$i$inlined, this.this$0, this.$size$inlined, this.$isClosed$inlined, this.$channels$inlined, this.$latestValues$inlined);
        combineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$2.p$0 = obj;
        return combineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$2;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(Object obj, c<? super kotlin.p> cVar) {
        return ((CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$2) create(obj, cVar)).invokeSuspend(kotlin.p.a);
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
                this.$isClosed$inlined[this.$i$inlined] = a.a(true);
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

package kotlinx.coroutines.flow;

import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.j;
import kotlin.k;
import kotlin.p;

/* compiled from: Merge.kt */
@d(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapLatest$1", f = "Merge.kt", l = {154, 180}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class FlowKt__MergeKt$flatMapLatest$1 extends SuspendLambda implements q<b<? super R>, T, c<? super p>, Object> {
    final /* synthetic */ kotlin.jvm.b.p $transform;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    private b p$;
    private Object p$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__MergeKt$flatMapLatest$1(kotlin.jvm.b.p pVar, c cVar) {
        super(3, cVar);
        this.$transform = pVar;
    }

    public final c<p> create(b<? super R> create, T t, c<? super p> continuation) {
        j.f(create, "$this$create");
        j.f(continuation, "continuation");
        FlowKt__MergeKt$flatMapLatest$1 flowKt__MergeKt$flatMapLatest$1 = new FlowKt__MergeKt$flatMapLatest$1(this.$transform, continuation);
        flowKt__MergeKt$flatMapLatest$1.p$ = create;
        flowKt__MergeKt$flatMapLatest$1.p$0 = t;
        return flowKt__MergeKt$flatMapLatest$1;
    }

    @Override // kotlin.jvm.b.q
    public final Object invoke(Object obj, Object obj2, c<? super p> cVar) {
        return ((FlowKt__MergeKt$flatMapLatest$1) create((b) obj, obj2, cVar)).invokeSuspend(p.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d2;
        b bVar;
        Object obj2;
        b bVar2;
        d2 = b.d();
        int i = this.label;
        if (i == 0) {
            k.b(obj);
            bVar2 = this.p$;
            Object obj3 = this.p$0;
            kotlin.jvm.b.p pVar = this.$transform;
            this.L$0 = bVar2;
            this.L$1 = obj3;
            this.L$2 = bVar2;
            this.label = 1;
            Object invoke = pVar.invoke(obj3, this);
            if (invoke == d2) {
                return d2;
            }
            bVar = bVar2;
            obj2 = obj3;
            obj = invoke;
        } else if (i == 1) {
            bVar2 = (b) this.L$2;
            obj2 = this.L$1;
            bVar = (b) this.L$0;
            k.b(obj);
        } else if (i == 2) {
            a aVar = (a) this.L$3;
            b bVar3 = (b) this.L$2;
            b bVar4 = (b) this.L$0;
            k.b(obj);
            return p.a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        a aVar2 = (a) obj;
        this.L$0 = bVar;
        this.L$1 = obj2;
        this.L$2 = bVar2;
        this.L$3 = aVar2;
        this.label = 2;
        if (aVar2.a(bVar2, this) == d2) {
            return d2;
        }
        return p.a;
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        b bVar = this.p$;
        Object obj2 = this.p$0;
        i.c(0);
        ((a) this.$transform.invoke(obj2, this)).a(bVar, this);
        i.c(2);
        i.c(1);
        return p.a;
    }
}

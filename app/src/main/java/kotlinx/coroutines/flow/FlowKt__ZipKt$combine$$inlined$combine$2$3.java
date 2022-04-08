package kotlinx.coroutines.flow;

import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.j;
import kotlin.k;
import kotlin.p;

/* compiled from: Zip.kt */
@d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combine$2$3", f = "Zip.kt", l = {319}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class FlowKt__ZipKt$combine$$inlined$combine$2$3 extends SuspendLambda implements q<b<? super R>, Object[], c<? super p>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private b p$;
    private Object[] p$0;
    final /* synthetic */ p2 this$0;

    public FlowKt__ZipKt$combine$$inlined$combine$2$3(c cVar, p2 p2Var) {
        super(3, cVar);
    }

    public final c<p> create(b<? super R> create, Object[] it, c<? super p> continuation) {
        j.f(create, "$this$create");
        j.f(it, "it");
        j.f(continuation, "continuation");
        FlowKt__ZipKt$combine$$inlined$combine$2$3 flowKt__ZipKt$combine$$inlined$combine$2$3 = new FlowKt__ZipKt$combine$$inlined$combine$2$3(continuation, this.this$0);
        flowKt__ZipKt$combine$$inlined$combine$2$3.p$ = create;
        flowKt__ZipKt$combine$$inlined$combine$2$3.p$0 = it;
        return flowKt__ZipKt$combine$$inlined$combine$2$3;
    }

    @Override // kotlin.jvm.b.q
    public final Object invoke(Object obj, Object[] objArr, c<? super p> cVar) {
        return ((FlowKt__ZipKt$combine$$inlined$combine$2$3) create((b) obj, objArr, cVar)).invokeSuspend(p.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        b.d();
        int i = this.label;
        if (i == 0) {
            k.b(obj);
            throw null;
        } else if (i == 1) {
            Object[] objArr = (Object[]) this.L$1;
            b bVar = (b) this.L$0;
            k.b(obj);
            return p.a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        throw null;
    }
}

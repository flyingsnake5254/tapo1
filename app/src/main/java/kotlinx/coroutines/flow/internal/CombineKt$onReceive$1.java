package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.b.a;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.j;

/* compiled from: Combine.kt */
@d(c = "kotlinx.coroutines.flow.internal.CombineKt$onReceive$1", f = "Combine.kt", l = {90, 90}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class CombineKt$onReceive$1 extends SuspendLambda implements p<Object, c<? super kotlin.p>, Object> {
    final /* synthetic */ a $onClosed;
    final /* synthetic */ p $onReceive;
    Object L$0;
    int label;
    private Object p$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombineKt$onReceive$1(a aVar, p pVar, c cVar) {
        super(2, cVar);
        this.$onClosed = aVar;
        this.$onReceive = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<kotlin.p> create(Object obj, c<?> completion) {
        j.f(completion, "completion");
        CombineKt$onReceive$1 combineKt$onReceive$1 = new CombineKt$onReceive$1(this.$onClosed, this.$onReceive, completion);
        combineKt$onReceive$1.p$0 = obj;
        return combineKt$onReceive$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(Object obj, c<? super kotlin.p> cVar) {
        return ((CombineKt$onReceive$1) create(obj, cVar)).invokeSuspend(kotlin.p.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003e A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.d()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.k.b(r5)
            goto L_0x003f
        L_0x0012:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x001a:
            kotlin.k.b(r5)
            goto L_0x003c
        L_0x001e:
            kotlin.k.b(r5)
            java.lang.Object r5 = r4.p$0
            if (r5 != 0) goto L_0x002b
            kotlin.jvm.b.a r5 = r4.$onClosed
            r5.invoke()
            goto L_0x003f
        L_0x002b:
            kotlin.jvm.b.p r1 = r4.$onReceive
            r4.L$0 = r5
            r4.label = r2
            r4.L$0 = r5
            r4.label = r3
            java.lang.Object r5 = r1.invoke(r5, r4)
            if (r5 != r0) goto L_0x003c
            return r0
        L_0x003c:
            if (r5 != r0) goto L_0x003f
            return r0
        L_0x003f:
            kotlin.p r5 = kotlin.p.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$onReceive$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        Object obj2 = this.p$0;
        if (obj2 == null) {
            this.$onClosed.invoke();
        } else {
            p pVar = this.$onReceive;
            i.c(0);
            pVar.invoke(obj2, this);
            i.c(2);
            i.c(1);
        }
        return kotlin.p.a;
    }
}

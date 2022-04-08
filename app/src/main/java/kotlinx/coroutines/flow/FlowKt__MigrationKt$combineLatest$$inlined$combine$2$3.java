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
@d(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$combineLatest$$inlined$combine$2$3", f = "Migration.kt", l = {318, 319}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class FlowKt__MigrationKt$combineLatest$$inlined$combine$2$3 extends SuspendLambda implements q<b<? super R>, Object[], c<? super p>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    private b p$;
    private Object[] p$0;
    final /* synthetic */ f1 this$0;

    public FlowKt__MigrationKt$combineLatest$$inlined$combine$2$3(c cVar, f1 f1Var) {
        super(3, cVar);
    }

    public final c<p> create(b<? super R> create, Object[] it, c<? super p> continuation) {
        j.f(create, "$this$create");
        j.f(it, "it");
        j.f(continuation, "continuation");
        FlowKt__MigrationKt$combineLatest$$inlined$combine$2$3 flowKt__MigrationKt$combineLatest$$inlined$combine$2$3 = new FlowKt__MigrationKt$combineLatest$$inlined$combine$2$3(continuation, this.this$0);
        flowKt__MigrationKt$combineLatest$$inlined$combine$2$3.p$ = create;
        flowKt__MigrationKt$combineLatest$$inlined$combine$2$3.p$0 = it;
        return flowKt__MigrationKt$combineLatest$$inlined$combine$2$3;
    }

    @Override // kotlin.jvm.b.q
    public final Object invoke(Object obj, Object[] objArr, c<? super p> cVar) {
        return ((FlowKt__MigrationKt$combineLatest$$inlined$combine$2$3) create((b) obj, objArr, cVar)).invokeSuspend(p.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d2;
        d2 = b.d();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                Object[] objArr = (Object[]) this.L$3;
                c cVar = (c) this.L$2;
                k.b(obj);
                this.L$0 = (b) this.L$0;
                this.L$1 = (Object[]) this.L$1;
                this.label = 2;
                if (((b) this.L$4).a(obj, this) == d2) {
                    return d2;
                }
            } else if (i == 2) {
                Object[] objArr2 = (Object[]) this.L$1;
                b bVar = (b) this.L$0;
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return p.a;
        }
        k.b(obj);
        throw null;
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        throw null;
    }
}

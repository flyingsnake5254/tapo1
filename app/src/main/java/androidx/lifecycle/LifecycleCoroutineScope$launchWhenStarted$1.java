package androidx.lifecycle;

import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.j;
import kotlin.k;
import kotlinx.coroutines.d0;

/* compiled from: Lifecycle.kt */
@d(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenStarted$1", f = "Lifecycle.kt", l = {87}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class LifecycleCoroutineScope$launchWhenStarted$1 extends SuspendLambda implements p<d0, c<? super kotlin.p>, Object> {
    final /* synthetic */ p $block;
    Object L$0;
    int label;
    private d0 p$;
    final /* synthetic */ LifecycleCoroutineScope this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LifecycleCoroutineScope$launchWhenStarted$1(LifecycleCoroutineScope lifecycleCoroutineScope, p pVar, c cVar) {
        super(2, cVar);
        this.this$0 = lifecycleCoroutineScope;
        this.$block = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<kotlin.p> create(Object obj, c<?> completion) {
        j.f(completion, "completion");
        LifecycleCoroutineScope$launchWhenStarted$1 lifecycleCoroutineScope$launchWhenStarted$1 = new LifecycleCoroutineScope$launchWhenStarted$1(this.this$0, this.$block, completion);
        lifecycleCoroutineScope$launchWhenStarted$1.p$ = (d0) obj;
        return lifecycleCoroutineScope$launchWhenStarted$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(d0 d0Var, c<? super kotlin.p> cVar) {
        return ((LifecycleCoroutineScope$launchWhenStarted$1) create(d0Var, cVar)).invokeSuspend(kotlin.p.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d2;
        d2 = b.d();
        int i = this.label;
        if (i == 0) {
            k.b(obj);
            d0 d0Var = this.p$;
            Lifecycle lifecycle$lifecycle_runtime_ktx_release = this.this$0.getLifecycle$lifecycle_runtime_ktx_release();
            p pVar = this.$block;
            this.L$0 = d0Var;
            this.label = 1;
            if (PausingDispatcherKt.whenStarted(lifecycle$lifecycle_runtime_ktx_release, pVar, this) == d2) {
                return d2;
            }
        } else if (i == 1) {
            d0 d0Var2 = (d0) this.L$0;
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return kotlin.p.a;
    }
}

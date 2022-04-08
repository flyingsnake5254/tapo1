package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.j;
import kotlin.k;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.h1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Lifecycle.kt */
@d(c = "androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1", f = "Lifecycle.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl$register$1 extends SuspendLambda implements p<d0, c<? super kotlin.p>, Object> {
    int label;
    private d0 p$;
    final /* synthetic */ LifecycleCoroutineScopeImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LifecycleCoroutineScopeImpl$register$1(LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl, c cVar) {
        super(2, cVar);
        this.this$0 = lifecycleCoroutineScopeImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<kotlin.p> create(Object obj, c<?> completion) {
        j.f(completion, "completion");
        LifecycleCoroutineScopeImpl$register$1 lifecycleCoroutineScopeImpl$register$1 = new LifecycleCoroutineScopeImpl$register$1(this.this$0, completion);
        lifecycleCoroutineScopeImpl$register$1.p$ = (d0) obj;
        return lifecycleCoroutineScopeImpl$register$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(d0 d0Var, c<? super kotlin.p> cVar) {
        return ((LifecycleCoroutineScopeImpl$register$1) create(d0Var, cVar)).invokeSuspend(kotlin.p.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        b.d();
        if (this.label == 0) {
            k.b(obj);
            d0 d0Var = this.p$;
            if (this.this$0.getLifecycle$lifecycle_runtime_ktx_release().getCurrentState().compareTo(Lifecycle.State.INITIALIZED) >= 0) {
                this.this$0.getLifecycle$lifecycle_runtime_ktx_release().addObserver(this.this$0);
            } else {
                h1.b(d0Var.getCoroutineContext(), null, 1, null);
            }
            return kotlin.p.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

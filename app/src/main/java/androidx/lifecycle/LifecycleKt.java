package androidx.lifecycle;

import kotlin.jvm.internal.j;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.v1;

/* compiled from: Lifecycle.kt */
/* loaded from: classes.dex */
public final class LifecycleKt {
    public static final LifecycleCoroutineScope getCoroutineScope(Lifecycle coroutineScope) {
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl;
        j.f(coroutineScope, "$this$coroutineScope");
        do {
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl2 = (LifecycleCoroutineScopeImpl) coroutineScope.mInternalScopeRef.get();
            if (lifecycleCoroutineScopeImpl2 != null) {
                return lifecycleCoroutineScopeImpl2;
            }
            lifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl(coroutineScope, v1.b(null, 1, null).plus(n0.b().u()));
        } while (!coroutineScope.mInternalScopeRef.compareAndSet(null, lifecycleCoroutineScopeImpl));
        lifecycleCoroutineScopeImpl.register();
        return lifecycleCoroutineScopeImpl;
    }
}

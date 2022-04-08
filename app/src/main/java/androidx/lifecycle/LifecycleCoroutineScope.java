package androidx.lifecycle;

import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.d;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.d1;

/* compiled from: Lifecycle.kt */
/* loaded from: classes.dex */
public abstract class LifecycleCoroutineScope implements d0 {
    @Override // kotlinx.coroutines.d0
    public abstract /* synthetic */ f getCoroutineContext();

    public abstract Lifecycle getLifecycle$lifecycle_runtime_ktx_release();

    public final d1 launchWhenCreated(p<? super d0, ? super c<? super kotlin.p>, ? extends Object> block) {
        j.f(block, "block");
        return d.b(this, null, null, new LifecycleCoroutineScope$launchWhenCreated$1(this, block, null), 3, null);
    }

    public final d1 launchWhenResumed(p<? super d0, ? super c<? super kotlin.p>, ? extends Object> block) {
        j.f(block, "block");
        return d.b(this, null, null, new LifecycleCoroutineScope$launchWhenResumed$1(this, block, null), 3, null);
    }

    public final d1 launchWhenStarted(p<? super d0, ? super c<? super kotlin.p>, ? extends Object> block) {
        j.f(block, "block");
        return d.b(this, null, null, new LifecycleCoroutineScope$launchWhenStarted$1(this, block, null), 3, null);
    }
}

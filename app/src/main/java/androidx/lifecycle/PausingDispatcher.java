package androidx.lifecycle;

import kotlin.coroutines.f;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.y;

/* compiled from: PausingDispatcher.kt */
/* loaded from: classes.dex */
public final class PausingDispatcher extends y {
    public final DispatchQueue dispatchQueue = new DispatchQueue();

    @Override // kotlinx.coroutines.y
    public void dispatch(f context, Runnable block) {
        j.f(context, "context");
        j.f(block, "block");
        this.dispatchQueue.runOrEnqueue(block);
    }
}

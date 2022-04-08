package kotlinx.coroutines;

import kotlin.jvm.internal.j;

/* compiled from: EventLoop.kt */
/* loaded from: classes4.dex */
public final class c extends r0 {
    private final Thread y;

    public c(Thread thread) {
        j.f(thread, "thread");
        this.y = thread;
    }

    @Override // kotlinx.coroutines.s0
    protected Thread D() {
        return this.y;
    }
}

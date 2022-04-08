package kotlinx.coroutines;

import kotlin.jvm.internal.j;

/* compiled from: EventLoop.kt */
/* loaded from: classes4.dex */
public final class t0 {
    public static final q0 a() {
        Thread currentThread = Thread.currentThread();
        j.b(currentThread, "Thread.currentThread()");
        return new c(currentThread);
    }
}

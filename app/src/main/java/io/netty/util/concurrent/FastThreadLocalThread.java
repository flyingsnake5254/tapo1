package io.netty.util.concurrent;

import io.netty.util.internal.InternalThreadLocalMap;

/* loaded from: classes3.dex */
public class FastThreadLocalThread extends Thread {
    private final boolean cleanupFastThreadLocals = false;
    private InternalThreadLocalMap threadLocalMap;

    public FastThreadLocalThread() {
    }

    public final void setThreadLocalMap(InternalThreadLocalMap internalThreadLocalMap) {
        this.threadLocalMap = internalThreadLocalMap;
    }

    public final InternalThreadLocalMap threadLocalMap() {
        return this.threadLocalMap;
    }

    public boolean willCleanupFastThreadLocals() {
        return this.cleanupFastThreadLocals;
    }

    public static boolean willCleanupFastThreadLocals(Thread thread) {
        return (thread instanceof FastThreadLocalThread) && ((FastThreadLocalThread) thread).willCleanupFastThreadLocals();
    }

    public FastThreadLocalThread(Runnable runnable) {
        super(FastThreadLocalRunnable.wrap(runnable));
    }

    public FastThreadLocalThread(ThreadGroup threadGroup, Runnable runnable) {
        super(threadGroup, FastThreadLocalRunnable.wrap(runnable));
    }

    public FastThreadLocalThread(String str) {
        super(str);
    }

    public FastThreadLocalThread(ThreadGroup threadGroup, String str) {
        super(threadGroup, str);
    }

    public FastThreadLocalThread(Runnable runnable, String str) {
        super(FastThreadLocalRunnable.wrap(runnable), str);
    }

    public FastThreadLocalThread(ThreadGroup threadGroup, Runnable runnable, String str) {
        super(threadGroup, FastThreadLocalRunnable.wrap(runnable), str);
    }

    public FastThreadLocalThread(ThreadGroup threadGroup, Runnable runnable, String str, long j) {
        super(threadGroup, FastThreadLocalRunnable.wrap(runnable), str, j);
    }
}

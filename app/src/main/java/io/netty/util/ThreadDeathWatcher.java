package io.netty.util;

import io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@Deprecated
/* loaded from: classes3.dex */
public final class ThreadDeathWatcher {
    static final ThreadFactory threadFactory;
    private static volatile Thread watcherThread;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ThreadDeathWatcher.class);
    private static final Queue<Entry> pendingEntries = new ConcurrentLinkedQueue();
    private static final Watcher watcher = new Watcher();
    private static final AtomicBoolean started = new AtomicBoolean();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class Entry {
        final boolean isWatch;
        final Runnable task;
        final Thread thread;

        Entry(Thread thread, Runnable runnable, boolean z) {
            this.thread = thread;
            this.task = runnable;
            this.isWatch = z;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.thread == entry.thread && this.task == entry.task;
        }

        public int hashCode() {
            return this.thread.hashCode() ^ this.task.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class Watcher implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final List<Entry> watchees;

        private Watcher() {
            this.watchees = new ArrayList();
        }

        private void fetchWatchees() {
            while (true) {
                Entry entry = (Entry) ThreadDeathWatcher.pendingEntries.poll();
                if (entry != null) {
                    if (entry.isWatch) {
                        this.watchees.add(entry);
                    } else {
                        this.watchees.remove(entry);
                    }
                } else {
                    return;
                }
            }
        }

        private void notifyWatchees() {
            List<Entry> list = this.watchees;
            int i = 0;
            while (i < list.size()) {
                Entry entry = list.get(i);
                if (!entry.thread.isAlive()) {
                    list.remove(i);
                    try {
                        entry.task.run();
                    } catch (Throwable th) {
                        ThreadDeathWatcher.logger.warn("Thread death watcher task raised an exception:", th);
                    }
                } else {
                    i++;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                fetchWatchees();
                notifyWatchees();
                fetchWatchees();
                notifyWatchees();
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException unused) {
                }
                if (this.watchees.isEmpty() && ThreadDeathWatcher.pendingEntries.isEmpty()) {
                    ThreadDeathWatcher.started.compareAndSet(true, false);
                    if (ThreadDeathWatcher.pendingEntries.isEmpty() || !ThreadDeathWatcher.started.compareAndSet(false, true)) {
                        return;
                    }
                }
            }
        }
    }

    static {
        String str = SystemPropertyUtil.get("io.netty.serviceThreadPrefix");
        String str2 = "threadDeathWatcher";
        if (!StringUtil.isNullOrEmpty(str)) {
            str2 = str + str2;
        }
        threadFactory = new DefaultThreadFactory(str2, true, 1, null);
    }

    private ThreadDeathWatcher() {
    }

    public static boolean awaitInactivity(long j, TimeUnit timeUnit) throws InterruptedException {
        ObjectUtil.checkNotNull(timeUnit, "unit");
        Thread thread = watcherThread;
        if (thread == null) {
            return true;
        }
        thread.join(timeUnit.toMillis(j));
        return !thread.isAlive();
    }

    private static void schedule(Thread thread, Runnable runnable, boolean z) {
        pendingEntries.add(new Entry(thread, runnable, z));
        if (started.compareAndSet(false, true)) {
            final Thread newThread = threadFactory.newThread(watcher);
            AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: io.netty.util.ThreadDeathWatcher.1
                @Override // java.security.PrivilegedAction
                public Void run() {
                    newThread.setContextClassLoader(null);
                    return null;
                }
            });
            newThread.start();
            watcherThread = newThread;
        }
    }

    public static void unwatch(Thread thread, Runnable runnable) {
        schedule((Thread) ObjectUtil.checkNotNull(thread, "thread"), (Runnable) ObjectUtil.checkNotNull(runnable, "task"), false);
    }

    public static void watch(Thread thread, Runnable runnable) {
        ObjectUtil.checkNotNull(thread, "thread");
        ObjectUtil.checkNotNull(runnable, "task");
        if (thread.isAlive()) {
            schedule(thread, runnable, true);
            return;
        }
        throw new IllegalArgumentException("thread must be alive.");
    }
}

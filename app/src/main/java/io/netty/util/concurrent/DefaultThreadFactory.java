package io.netty.util.concurrent;

import androidx.core.os.EnvironmentCompat;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class DefaultThreadFactory implements ThreadFactory {
    private static final AtomicInteger poolId = new AtomicInteger();
    private final boolean daemon;
    private final AtomicInteger nextId;
    private final String prefix;
    private final int priority;
    protected final ThreadGroup threadGroup;

    public DefaultThreadFactory(Class<?> cls) {
        this(cls, false, 5);
    }

    public static String toPoolName(Class<?> cls) {
        ObjectUtil.checkNotNull(cls, "poolType");
        String simpleClassName = StringUtil.simpleClassName(cls);
        int length = simpleClassName.length();
        if (length == 0) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
        if (length == 1) {
            return simpleClassName.toLowerCase(Locale.US);
        }
        if (!Character.isUpperCase(simpleClassName.charAt(0)) || !Character.isLowerCase(simpleClassName.charAt(1))) {
            return simpleClassName;
        }
        return Character.toLowerCase(simpleClassName.charAt(0)) + simpleClassName.substring(1);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Runnable wrap = FastThreadLocalRunnable.wrap(runnable);
        Thread newThread = newThread(wrap, this.prefix + this.nextId.incrementAndGet());
        try {
            boolean isDaemon = newThread.isDaemon();
            boolean z = this.daemon;
            if (isDaemon != z) {
                newThread.setDaemon(z);
            }
            int priority = newThread.getPriority();
            int i = this.priority;
            if (priority != i) {
                newThread.setPriority(i);
            }
        } catch (Exception unused) {
        }
        return newThread;
    }

    public DefaultThreadFactory(String str) {
        this(str, false, 5);
    }

    public DefaultThreadFactory(Class<?> cls, boolean z) {
        this(cls, z, 5);
    }

    public DefaultThreadFactory(String str, boolean z) {
        this(str, z, 5);
    }

    public DefaultThreadFactory(Class<?> cls, int i) {
        this(cls, false, i);
    }

    public DefaultThreadFactory(String str, int i) {
        this(str, false, i);
    }

    protected Thread newThread(Runnable runnable, String str) {
        return new FastThreadLocalThread(this.threadGroup, runnable, str);
    }

    public DefaultThreadFactory(Class<?> cls, boolean z, int i) {
        this(toPoolName(cls), z, i);
    }

    public DefaultThreadFactory(String str, boolean z, int i, ThreadGroup threadGroup) {
        this.nextId = new AtomicInteger();
        ObjectUtil.checkNotNull(str, "poolName");
        if (i < 1 || i > 10) {
            throw new IllegalArgumentException("priority: " + i + " (expected: Thread.MIN_PRIORITY <= priority <= Thread.MAX_PRIORITY)");
        }
        this.prefix = str + '-' + poolId.incrementAndGet() + '-';
        this.daemon = z;
        this.priority = i;
        this.threadGroup = threadGroup;
    }

    public DefaultThreadFactory(String str, boolean z, int i) {
        this(str, z, i, System.getSecurityManager() == null ? Thread.currentThread().getThreadGroup() : System.getSecurityManager().getThreadGroup());
    }
}

package io.reactivex.internal.schedulers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SchedulerPoolFactory.java */
/* loaded from: classes4.dex */
public final class j {
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f16206b;

    /* renamed from: c  reason: collision with root package name */
    static final AtomicReference<ScheduledExecutorService> f16207c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    static final Map<ScheduledThreadPoolExecutor, Object> f16208d = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SchedulerPoolFactory.java */
    /* loaded from: classes4.dex */
    public static final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = new ArrayList(j.f16208d.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    j.f16208d.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    /* compiled from: SchedulerPoolFactory.java */
    /* loaded from: classes4.dex */
    static final class b implements io.reactivex.g0.j<String, String> {
        b() {
        }

        /* renamed from: a */
        public String apply(String str) throws Exception {
            return System.getProperty(str);
        }
    }

    static {
        b bVar = new b();
        boolean b2 = b(true, "rx2.purge-enabled", true, true, bVar);
        a = b2;
        f16206b = c(b2, "rx2.purge-period-seconds", 1, 1, bVar);
        d();
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        e(a, newScheduledThreadPool);
        return newScheduledThreadPool;
    }

    static boolean b(boolean z, String str, boolean z2, boolean z3, io.reactivex.g0.j<String, String> jVar) {
        if (!z) {
            return z3;
        }
        try {
            String apply = jVar.apply(str);
            return apply == null ? z2 : "true".equals(apply);
        } catch (Throwable unused) {
            return z2;
        }
    }

    static int c(boolean z, String str, int i, int i2, io.reactivex.g0.j<String, String> jVar) {
        if (!z) {
            return i2;
        }
        try {
            String apply = jVar.apply(str);
            return apply == null ? i : Integer.parseInt(apply);
        } catch (Throwable unused) {
            return i;
        }
    }

    public static void d() {
        f(a);
    }

    static void e(boolean z, ScheduledExecutorService scheduledExecutorService) {
        if (z && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            f16208d.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }

    static void f(boolean z) {
        if (z) {
            while (true) {
                AtomicReference<ScheduledExecutorService> atomicReference = f16207c;
                ScheduledExecutorService scheduledExecutorService = atomicReference.get();
                if (scheduledExecutorService == null) {
                    ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
                    if (atomicReference.compareAndSet(scheduledExecutorService, newScheduledThreadPool)) {
                        a aVar = new a();
                        int i = f16206b;
                        newScheduledThreadPool.scheduleAtFixedRate(aVar, i, i, TimeUnit.SECONDS);
                        return;
                    }
                    newScheduledThreadPool.shutdownNow();
                } else {
                    return;
                }
            }
        }
    }
}

package com.bumptech.glide.load.engine.b0;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: GlideExecutor.java */
/* loaded from: classes.dex */
public final class a implements ExecutorService {

    /* renamed from: c  reason: collision with root package name */
    private static final long f1411c = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: d  reason: collision with root package name */
    private static volatile int f1412d;

    /* renamed from: f  reason: collision with root package name */
    private final ExecutorService f1413f;

    /* compiled from: GlideExecutor.java */
    /* renamed from: com.bumptech.glide.load.engine.b0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0047a {
        private final boolean a;

        /* renamed from: b  reason: collision with root package name */
        private int f1414b;

        /* renamed from: c  reason: collision with root package name */
        private int f1415c;
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        private c f1416d = c.f1425d;

        /* renamed from: e  reason: collision with root package name */
        private String f1417e;

        /* renamed from: f  reason: collision with root package name */
        private long f1418f;

        C0047a(boolean z) {
            this.a = z;
        }

        public a a() {
            if (!TextUtils.isEmpty(this.f1417e)) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.f1414b, this.f1415c, this.f1418f, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new b(this.f1417e, this.f1416d, this.a));
                if (this.f1418f != 0) {
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
                return new a(threadPoolExecutor);
            }
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f1417e);
        }

        public C0047a b(String str) {
            this.f1417e = str;
            return this;
        }

        public C0047a c(@IntRange(from = 1) int i) {
            this.f1414b = i;
            this.f1415c = i;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GlideExecutor.java */
    /* loaded from: classes.dex */
    public static final class b implements ThreadFactory {

        /* renamed from: c  reason: collision with root package name */
        private final String f1419c;

        /* renamed from: d  reason: collision with root package name */
        final c f1420d;

        /* renamed from: f  reason: collision with root package name */
        final boolean f1421f;
        private int q;

        /* compiled from: GlideExecutor.java */
        /* renamed from: com.bumptech.glide.load.engine.b0.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0048a extends Thread {
            C0048a(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(9);
                if (b.this.f1421f) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    super.run();
                } catch (Throwable th) {
                    b.this.f1420d.a(th);
                }
            }
        }

        b(String str, c cVar, boolean z) {
            this.f1419c = str;
            this.f1420d = cVar;
            this.f1421f = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(@NonNull Runnable runnable) {
            C0048a aVar;
            aVar = new C0048a(runnable, "glide-" + this.f1419c + "-thread-" + this.q);
            this.q = this.q + 1;
            return aVar;
        }
    }

    /* compiled from: GlideExecutor.java */
    /* loaded from: classes.dex */
    public interface c {

        /* renamed from: b  reason: collision with root package name */
        public static final c f1423b;

        /* renamed from: d  reason: collision with root package name */
        public static final c f1425d;
        public static final c a = new C0049a();

        /* renamed from: c  reason: collision with root package name */
        public static final c f1424c = new C0050c();

        /* compiled from: GlideExecutor.java */
        /* renamed from: com.bumptech.glide.load.engine.b0.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0049a implements c {
            C0049a() {
            }

            @Override // com.bumptech.glide.load.engine.b0.a.c
            public void a(Throwable th) {
            }
        }

        /* compiled from: GlideExecutor.java */
        /* loaded from: classes.dex */
        class b implements c {
            b() {
            }

            @Override // com.bumptech.glide.load.engine.b0.a.c
            public void a(Throwable th) {
                if (th != null && Log.isLoggable("GlideExecutor", 6)) {
                    Log.e("GlideExecutor", "Request threw uncaught throwable", th);
                }
            }
        }

        /* compiled from: GlideExecutor.java */
        /* renamed from: com.bumptech.glide.load.engine.b0.a$c$c  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0050c implements c {
            C0050c() {
            }

            @Override // com.bumptech.glide.load.engine.b0.a.c
            public void a(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        }

        static {
            b bVar = new b();
            f1423b = bVar;
            f1425d = bVar;
        }

        void a(Throwable th);
    }

    @VisibleForTesting
    a(ExecutorService executorService) {
        this.f1413f = executorService;
    }

    public static int a() {
        if (f1412d == 0) {
            f1412d = Math.min(4, b.a());
        }
        return f1412d;
    }

    public static C0047a b() {
        return new C0047a(true).c(a() >= 4 ? 2 : 1).b("animation");
    }

    public static a c() {
        return b().a();
    }

    public static C0047a d() {
        return new C0047a(true).c(1).b("disk-cache");
    }

    public static a e() {
        return d().a();
    }

    public static C0047a f() {
        return new C0047a(false).c(a()).b("source");
    }

    public static a g() {
        return f().a();
    }

    public static a h() {
        return new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f1411c, TimeUnit.MILLISECONDS, new SynchronousQueue(), new b("source-unlimited", c.f1425d, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f1413f.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.f1413f.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f1413f.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return (T) this.f1413f.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f1413f.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f1413f.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f1413f.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public List<Runnable> shutdownNow() {
        return this.f1413f.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.f1413f.submit(runnable);
    }

    public String toString() {
        return this.f1413f.toString();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f1413f.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) this.f1413f.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t) {
        return this.f1413f.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.f1413f.submit(callable);
    }
}

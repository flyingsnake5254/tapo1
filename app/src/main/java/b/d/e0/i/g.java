package b.d.e0.i;

import android.app.Activity;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: InactivityTimer.java */
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: b  reason: collision with root package name */
    private final Activity f438b;
    private final ScheduledExecutorService a = Executors.newSingleThreadScheduledExecutor(new b());

    /* renamed from: c  reason: collision with root package name */
    private ScheduledFuture<?> f439c = null;

    /* compiled from: InactivityTimer.java */
    /* loaded from: classes3.dex */
    private static final class b implements ThreadFactory {
        private b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            return thread;
        }
    }

    public g(Activity activity) {
        this.f438b = activity;
        b();
    }

    private void a() {
        ScheduledFuture<?> scheduledFuture = this.f439c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.f439c = null;
        }
    }

    public void b() {
        a();
        this.f439c = this.a.schedule(new f(this.f438b), 300L, TimeUnit.SECONDS);
    }

    public void c() {
        a();
        this.a.shutdown();
    }
}

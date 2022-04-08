package io.reactivex.internal.schedulers;

import io.reactivex.e0.b;
import io.reactivex.e0.c;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.w;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleScheduler.java */
/* loaded from: classes4.dex */
public final class k extends w {

    /* renamed from: c  reason: collision with root package name */
    static final RxThreadFactory f16209c = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);

    /* renamed from: d  reason: collision with root package name */
    static final ScheduledExecutorService f16210d;

    /* renamed from: e  reason: collision with root package name */
    final ThreadFactory f16211e;

    /* renamed from: f  reason: collision with root package name */
    final AtomicReference<ScheduledExecutorService> f16212f;

    /* compiled from: SingleScheduler.java */
    /* loaded from: classes4.dex */
    static final class a extends w.c {

        /* renamed from: c  reason: collision with root package name */
        final ScheduledExecutorService f16213c;

        /* renamed from: d  reason: collision with root package name */
        final b f16214d = new b();

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f16215f;

        a(ScheduledExecutorService scheduledExecutorService) {
            this.f16213c = scheduledExecutorService;
        }

        @Override // io.reactivex.w.c
        public c c(Runnable runnable, long j, TimeUnit timeUnit) {
            Future<?> future;
            if (this.f16215f) {
                return EmptyDisposable.INSTANCE;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(io.reactivex.j0.a.t(runnable), this.f16214d);
            this.f16214d.b(scheduledRunnable);
            try {
                if (j <= 0) {
                    future = this.f16213c.submit((Callable) scheduledRunnable);
                } else {
                    future = this.f16213c.schedule((Callable) scheduledRunnable, j, timeUnit);
                }
                scheduledRunnable.setFuture(future);
                return scheduledRunnable;
            } catch (RejectedExecutionException e2) {
                dispose();
                io.reactivex.j0.a.r(e2);
                return EmptyDisposable.INSTANCE;
            }
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            if (!this.f16215f) {
                this.f16215f = true;
                this.f16214d.dispose();
            }
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.f16215f;
        }
    }

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f16210d = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
    }

    public k() {
        this(f16209c);
    }

    static ScheduledExecutorService f(ThreadFactory threadFactory) {
        return j.a(threadFactory);
    }

    @Override // io.reactivex.w
    public w.c b() {
        return new a(this.f16212f.get());
    }

    @Override // io.reactivex.w
    public c d(Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> future;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(io.reactivex.j0.a.t(runnable));
        try {
            if (j <= 0) {
                future = this.f16212f.get().submit(scheduledDirectTask);
            } else {
                future = this.f16212f.get().schedule(scheduledDirectTask, j, timeUnit);
            }
            scheduledDirectTask.setFuture(future);
            return scheduledDirectTask;
        } catch (RejectedExecutionException e2) {
            io.reactivex.j0.a.r(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.w
    public c e(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Future<?> future;
        Runnable t = io.reactivex.j0.a.t(runnable);
        if (j2 <= 0) {
            ScheduledExecutorService scheduledExecutorService = this.f16212f.get();
            e eVar = new e(t, scheduledExecutorService);
            try {
                if (j <= 0) {
                    future = scheduledExecutorService.submit(eVar);
                } else {
                    future = scheduledExecutorService.schedule(eVar, j, timeUnit);
                }
                eVar.b(future);
                return eVar;
            } catch (RejectedExecutionException e2) {
                io.reactivex.j0.a.r(e2);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(t);
            try {
                scheduledDirectPeriodicTask.setFuture(this.f16212f.get().scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
                return scheduledDirectPeriodicTask;
            } catch (RejectedExecutionException e3) {
                io.reactivex.j0.a.r(e3);
                return EmptyDisposable.INSTANCE;
            }
        }
    }

    public k(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.f16212f = atomicReference;
        this.f16211e = threadFactory;
        atomicReference.lazySet(f(threadFactory));
    }
}

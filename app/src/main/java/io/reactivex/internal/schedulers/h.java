package io.reactivex.internal.schedulers;

import io.reactivex.e0.c;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.a;
import io.reactivex.w;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: NewThreadWorker.java */
/* loaded from: classes4.dex */
public class h extends w.c implements c {

    /* renamed from: c  reason: collision with root package name */
    private final ScheduledExecutorService f16204c;

    /* renamed from: d  reason: collision with root package name */
    volatile boolean f16205d;

    public h(ThreadFactory threadFactory) {
        this.f16204c = j.a(threadFactory);
    }

    @Override // io.reactivex.w.c
    public c b(Runnable runnable) {
        return c(runnable, 0L, null);
    }

    @Override // io.reactivex.w.c
    public c c(Runnable runnable, long j, TimeUnit timeUnit) {
        if (this.f16205d) {
            return EmptyDisposable.INSTANCE;
        }
        return e(runnable, j, timeUnit, null);
    }

    @Override // io.reactivex.e0.c
    public void dispose() {
        if (!this.f16205d) {
            this.f16205d = true;
            this.f16204c.shutdownNow();
        }
    }

    public ScheduledRunnable e(Runnable runnable, long j, TimeUnit timeUnit, a aVar) {
        Future<?> future;
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(io.reactivex.j0.a.t(runnable), aVar);
        if (aVar != null && !aVar.b(scheduledRunnable)) {
            return scheduledRunnable;
        }
        try {
            if (j <= 0) {
                future = this.f16204c.submit((Callable) scheduledRunnable);
            } else {
                future = this.f16204c.schedule((Callable) scheduledRunnable, j, timeUnit);
            }
            scheduledRunnable.setFuture(future);
        } catch (RejectedExecutionException e2) {
            if (aVar != null) {
                aVar.a(scheduledRunnable);
            }
            io.reactivex.j0.a.r(e2);
        }
        return scheduledRunnable;
    }

    public c f(Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> future;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(io.reactivex.j0.a.t(runnable));
        try {
            if (j <= 0) {
                future = this.f16204c.submit(scheduledDirectTask);
            } else {
                future = this.f16204c.schedule(scheduledDirectTask, j, timeUnit);
            }
            scheduledDirectTask.setFuture(future);
            return scheduledDirectTask;
        } catch (RejectedExecutionException e2) {
            io.reactivex.j0.a.r(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    public c g(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Future<?> future;
        Runnable t = io.reactivex.j0.a.t(runnable);
        if (j2 <= 0) {
            e eVar = new e(t, this.f16204c);
            try {
                if (j <= 0) {
                    future = this.f16204c.submit(eVar);
                } else {
                    future = this.f16204c.schedule(eVar, j, timeUnit);
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
                scheduledDirectPeriodicTask.setFuture(this.f16204c.scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
                return scheduledDirectPeriodicTask;
            } catch (RejectedExecutionException e3) {
                io.reactivex.j0.a.r(e3);
                return EmptyDisposable.INSTANCE;
            }
        }
    }

    public void h() {
        if (!this.f16205d) {
            this.f16205d = true;
            this.f16204c.shutdown();
        }
    }

    @Override // io.reactivex.e0.c
    public boolean isDisposed() {
        return this.f16205d;
    }
}

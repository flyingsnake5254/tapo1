package io.reactivex.internal.schedulers;

import io.reactivex.e0.c;
import io.reactivex.h0.a.a;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InstantPeriodicTask.java */
/* loaded from: classes4.dex */
public final class e implements Callable<Void>, c {

    /* renamed from: c  reason: collision with root package name */
    static final FutureTask<Void> f16188c = new FutureTask<>(a.f15634b, null);

    /* renamed from: d  reason: collision with root package name */
    final Runnable f16189d;
    final ExecutorService x;
    Thread y;
    final AtomicReference<Future<?>> q = new AtomicReference<>();

    /* renamed from: f  reason: collision with root package name */
    final AtomicReference<Future<?>> f16190f = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Runnable runnable, ExecutorService executorService) {
        this.f16189d = runnable;
        this.x = executorService;
    }

    /* renamed from: a */
    public Void call() throws Exception {
        this.y = Thread.currentThread();
        try {
            this.f16189d.run();
            c(this.x.submit(this));
            this.y = null;
        } catch (Throwable th) {
            this.y = null;
            io.reactivex.j0.a.r(th);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.q.get();
            if (future2 == f16188c) {
                future.cancel(this.y != Thread.currentThread());
                return;
            }
        } while (!this.q.compareAndSet(future2, future));
    }

    void c(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.f16190f.get();
            if (future2 == f16188c) {
                future.cancel(this.y != Thread.currentThread());
                return;
            }
        } while (!this.f16190f.compareAndSet(future2, future));
    }

    @Override // io.reactivex.e0.c
    public void dispose() {
        AtomicReference<Future<?>> atomicReference = this.q;
        FutureTask<Void> futureTask = f16188c;
        Future<?> andSet = atomicReference.getAndSet(futureTask);
        boolean z = true;
        if (!(andSet == null || andSet == futureTask)) {
            andSet.cancel(this.y != Thread.currentThread());
        }
        Future<?> andSet2 = this.f16190f.getAndSet(futureTask);
        if (andSet2 != null && andSet2 != futureTask) {
            if (this.y == Thread.currentThread()) {
                z = false;
            }
            andSet2.cancel(z);
        }
    }

    @Override // io.reactivex.e0.c
    public boolean isDisposed() {
        return this.q.get() == f16188c;
    }
}

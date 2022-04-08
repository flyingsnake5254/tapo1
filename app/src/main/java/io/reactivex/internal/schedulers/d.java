package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.w;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ExecutorScheduler.java */
/* loaded from: classes4.dex */
public final class d extends w {

    /* renamed from: c  reason: collision with root package name */
    static final w f16171c = io.reactivex.l0.a.d();

    /* renamed from: d  reason: collision with root package name */
    final boolean f16172d;

    /* renamed from: e  reason: collision with root package name */
    final Executor f16173e;

    /* compiled from: ExecutorScheduler.java */
    /* loaded from: classes4.dex */
    final class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        private final b f16174c;

        a(b bVar) {
            this.f16174c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = this.f16174c;
            bVar.f16177d.replace(d.this.c(bVar));
        }
    }

    /* compiled from: ExecutorScheduler.java */
    /* loaded from: classes4.dex */
    static final class b extends AtomicReference<Runnable> implements Runnable, io.reactivex.e0.c {

        /* renamed from: c  reason: collision with root package name */
        final SequentialDisposable f16176c = new SequentialDisposable();

        /* renamed from: d  reason: collision with root package name */
        final SequentialDisposable f16177d = new SequentialDisposable();

        b(Runnable runnable) {
            super(runnable);
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            if (getAndSet(null) != null) {
                this.f16176c.dispose();
                this.f16177d.dispose();
            }
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return get() == null;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = get();
            if (runnable != null) {
                try {
                    runnable.run();
                    lazySet(null);
                    SequentialDisposable sequentialDisposable = this.f16176c;
                    DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                    sequentialDisposable.lazySet(disposableHelper);
                    this.f16177d.lazySet(disposableHelper);
                } catch (Throwable th) {
                    lazySet(null);
                    this.f16176c.lazySet(DisposableHelper.DISPOSED);
                    this.f16177d.lazySet(DisposableHelper.DISPOSED);
                    throw th;
                }
            }
        }
    }

    /* compiled from: ExecutorScheduler.java */
    /* loaded from: classes4.dex */
    public static final class c extends w.c implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final boolean f16178c;

        /* renamed from: d  reason: collision with root package name */
        final Executor f16179d;
        volatile boolean q;
        final AtomicInteger x = new AtomicInteger();
        final io.reactivex.e0.b y = new io.reactivex.e0.b();

        /* renamed from: f  reason: collision with root package name */
        final io.reactivex.internal.queue.a<Runnable> f16180f = new io.reactivex.internal.queue.a<>();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ExecutorScheduler.java */
        /* loaded from: classes4.dex */
        public static final class a extends AtomicBoolean implements Runnable, io.reactivex.e0.c {

            /* renamed from: c  reason: collision with root package name */
            final Runnable f16181c;

            a(Runnable runnable) {
                this.f16181c = runnable;
            }

            @Override // io.reactivex.e0.c
            public void dispose() {
                lazySet(true);
            }

            @Override // io.reactivex.e0.c
            public boolean isDisposed() {
                return get();
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!get()) {
                    try {
                        this.f16181c.run();
                    } finally {
                        lazySet(true);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ExecutorScheduler.java */
        /* loaded from: classes4.dex */
        public static final class b extends AtomicInteger implements Runnable, io.reactivex.e0.c {

            /* renamed from: c  reason: collision with root package name */
            final Runnable f16182c;

            /* renamed from: d  reason: collision with root package name */
            final io.reactivex.internal.disposables.a f16183d;

            /* renamed from: f  reason: collision with root package name */
            volatile Thread f16184f;

            b(Runnable runnable, io.reactivex.internal.disposables.a aVar) {
                this.f16182c = runnable;
                this.f16183d = aVar;
            }

            void a() {
                io.reactivex.internal.disposables.a aVar = this.f16183d;
                if (aVar != null) {
                    aVar.c(this);
                }
            }

            @Override // io.reactivex.e0.c
            public void dispose() {
                while (true) {
                    int i = get();
                    if (i < 2) {
                        if (i == 0) {
                            if (compareAndSet(0, 4)) {
                                a();
                                return;
                            }
                        } else if (compareAndSet(1, 3)) {
                            Thread thread = this.f16184f;
                            if (thread != null) {
                                thread.interrupt();
                                this.f16184f = null;
                            }
                            set(4);
                            a();
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }

            @Override // io.reactivex.e0.c
            public boolean isDisposed() {
                return get() >= 2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get() == 0) {
                    this.f16184f = Thread.currentThread();
                    if (compareAndSet(0, 1)) {
                        try {
                            this.f16182c.run();
                            this.f16184f = null;
                            if (compareAndSet(1, 2)) {
                                a();
                                return;
                            }
                            while (get() == 3) {
                                Thread.yield();
                            }
                            Thread.interrupted();
                        } catch (Throwable th) {
                            this.f16184f = null;
                            if (!compareAndSet(1, 2)) {
                                while (get() == 3) {
                                    Thread.yield();
                                }
                                Thread.interrupted();
                            } else {
                                a();
                            }
                            throw th;
                        }
                    } else {
                        this.f16184f = null;
                    }
                }
            }
        }

        /* compiled from: ExecutorScheduler.java */
        /* renamed from: io.reactivex.internal.schedulers.d$c$c  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        final class RunnableC0314c implements Runnable {

            /* renamed from: c  reason: collision with root package name */
            private final SequentialDisposable f16185c;

            /* renamed from: d  reason: collision with root package name */
            private final Runnable f16186d;

            RunnableC0314c(SequentialDisposable sequentialDisposable, Runnable runnable) {
                this.f16185c = sequentialDisposable;
                this.f16186d = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f16185c.replace(c.this.b(this.f16186d));
            }
        }

        public c(Executor executor, boolean z) {
            this.f16179d = executor;
            this.f16178c = z;
        }

        @Override // io.reactivex.w.c
        public io.reactivex.e0.c b(Runnable runnable) {
            io.reactivex.e0.c cVar;
            if (this.q) {
                return EmptyDisposable.INSTANCE;
            }
            Runnable t = io.reactivex.j0.a.t(runnable);
            if (this.f16178c) {
                cVar = new b(t, this.y);
                this.y.b(cVar);
            } else {
                cVar = new a(t);
            }
            this.f16180f.offer(cVar);
            if (this.x.getAndIncrement() == 0) {
                try {
                    this.f16179d.execute(this);
                } catch (RejectedExecutionException e2) {
                    this.q = true;
                    this.f16180f.clear();
                    io.reactivex.j0.a.r(e2);
                    return EmptyDisposable.INSTANCE;
                }
            }
            return cVar;
        }

        @Override // io.reactivex.w.c
        public io.reactivex.e0.c c(Runnable runnable, long j, TimeUnit timeUnit) {
            if (j <= 0) {
                return b(runnable);
            }
            if (this.q) {
                return EmptyDisposable.INSTANCE;
            }
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(new RunnableC0314c(sequentialDisposable2, io.reactivex.j0.a.t(runnable)), this.y);
            this.y.b(scheduledRunnable);
            Executor executor = this.f16179d;
            if (executor instanceof ScheduledExecutorService) {
                try {
                    scheduledRunnable.setFuture(((ScheduledExecutorService) executor).schedule((Callable) scheduledRunnable, j, timeUnit));
                } catch (RejectedExecutionException e2) {
                    this.q = true;
                    io.reactivex.j0.a.r(e2);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                scheduledRunnable.setFuture(new c(d.f16171c.d(scheduledRunnable, j, timeUnit)));
            }
            sequentialDisposable.replace(scheduledRunnable);
            return sequentialDisposable2;
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            if (!this.q) {
                this.q = true;
                this.y.dispose();
                if (this.x.getAndIncrement() == 0) {
                    this.f16180f.clear();
                }
            }
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.q;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
            if (r3.q == false) goto L_0x001b;
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0017, code lost:
            r0.clear();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x001a, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x001b, code lost:
            r1 = r3.x.addAndGet(-r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0022, code lost:
            if (r1 != 0) goto L_0x0003;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0024, code lost:
            return;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r3 = this;
                io.reactivex.internal.queue.a<java.lang.Runnable> r0 = r3.f16180f
                r1 = 1
            L_0x0003:
                boolean r2 = r3.q
                if (r2 == 0) goto L_0x000b
                r0.clear()
                return
            L_0x000b:
                java.lang.Object r2 = r0.poll()
                java.lang.Runnable r2 = (java.lang.Runnable) r2
                if (r2 != 0) goto L_0x0025
                boolean r2 = r3.q
                if (r2 == 0) goto L_0x001b
                r0.clear()
                return
            L_0x001b:
                java.util.concurrent.atomic.AtomicInteger r2 = r3.x
                int r1 = -r1
                int r1 = r2.addAndGet(r1)
                if (r1 != 0) goto L_0x0003
                return
            L_0x0025:
                r2.run()
                boolean r2 = r3.q
                if (r2 == 0) goto L_0x000b
                r0.clear()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.schedulers.d.c.run():void");
        }
    }

    public d(Executor executor, boolean z) {
        this.f16173e = executor;
        this.f16172d = z;
    }

    @Override // io.reactivex.w
    public w.c b() {
        return new c(this.f16173e, this.f16172d);
    }

    @Override // io.reactivex.w
    public io.reactivex.e0.c c(Runnable runnable) {
        Runnable t = io.reactivex.j0.a.t(runnable);
        try {
            if (this.f16173e instanceof ExecutorService) {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(t);
                scheduledDirectTask.setFuture(((ExecutorService) this.f16173e).submit(scheduledDirectTask));
                return scheduledDirectTask;
            } else if (this.f16172d) {
                c.b bVar = new c.b(t, null);
                this.f16173e.execute(bVar);
                return bVar;
            } else {
                c.a aVar = new c.a(t);
                this.f16173e.execute(aVar);
                return aVar;
            }
        } catch (RejectedExecutionException e2) {
            io.reactivex.j0.a.r(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.w
    public io.reactivex.e0.c d(Runnable runnable, long j, TimeUnit timeUnit) {
        Runnable t = io.reactivex.j0.a.t(runnable);
        if (this.f16173e instanceof ScheduledExecutorService) {
            try {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(t);
                scheduledDirectTask.setFuture(((ScheduledExecutorService) this.f16173e).schedule(scheduledDirectTask, j, timeUnit));
                return scheduledDirectTask;
            } catch (RejectedExecutionException e2) {
                io.reactivex.j0.a.r(e2);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            b bVar = new b(t);
            bVar.f16176c.replace(f16171c.d(new a(bVar), j, timeUnit));
            return bVar;
        }
    }

    @Override // io.reactivex.w
    public io.reactivex.e0.c e(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        if (!(this.f16173e instanceof ScheduledExecutorService)) {
            return super.e(runnable, j, j2, timeUnit);
        }
        try {
            ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(io.reactivex.j0.a.t(runnable));
            scheduledDirectPeriodicTask.setFuture(((ScheduledExecutorService) this.f16173e).scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e2) {
            io.reactivex.j0.a.r(e2);
            return EmptyDisposable.INSTANCE;
        }
    }
}

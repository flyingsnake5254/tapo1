package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.w;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: IoScheduler.java */
/* loaded from: classes4.dex */
public final class f extends w {

    /* renamed from: c  reason: collision with root package name */
    static final RxThreadFactory f16191c;

    /* renamed from: d  reason: collision with root package name */
    static final RxThreadFactory f16192d;
    static final c g;
    static final a i;
    final ThreadFactory j;
    final AtomicReference<a> k;

    /* renamed from: f  reason: collision with root package name */
    private static final TimeUnit f16194f = TimeUnit.SECONDS;

    /* renamed from: e  reason: collision with root package name */
    private static final long f16193e = Long.getLong("rx2.io-keep-alive-time", 60).longValue();
    static boolean h = Boolean.getBoolean("rx2.io-scheduled-release");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoScheduler.java */
    /* loaded from: classes4.dex */
    public static final class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        private final long f16195c;

        /* renamed from: d  reason: collision with root package name */
        private final ConcurrentLinkedQueue<c> f16196d;

        /* renamed from: f  reason: collision with root package name */
        final io.reactivex.e0.b f16197f;
        private final ScheduledExecutorService q;
        private final Future<?> x;
        private final ThreadFactory y;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            long nanos = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.f16195c = nanos;
            this.f16196d = new ConcurrentLinkedQueue<>();
            this.f16197f = new io.reactivex.e0.b();
            this.y = threadFactory;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, f.f16192d);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.q = scheduledExecutorService;
            this.x = scheduledFuture;
        }

        void a() {
            if (!this.f16196d.isEmpty()) {
                long c2 = c();
                Iterator<c> it = this.f16196d.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.i() > c2) {
                        return;
                    }
                    if (this.f16196d.remove(next)) {
                        this.f16197f.a(next);
                    }
                }
            }
        }

        c b() {
            if (this.f16197f.isDisposed()) {
                return f.g;
            }
            while (!this.f16196d.isEmpty()) {
                c poll = this.f16196d.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.y);
            this.f16197f.b(cVar);
            return cVar;
        }

        long c() {
            return System.nanoTime();
        }

        void d(c cVar) {
            cVar.j(c() + this.f16195c);
            this.f16196d.offer(cVar);
        }

        void e() {
            this.f16197f.dispose();
            Future<?> future = this.x;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.q;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }
    }

    /* compiled from: IoScheduler.java */
    /* loaded from: classes4.dex */
    static final class b extends w.c implements Runnable {

        /* renamed from: d  reason: collision with root package name */
        private final a f16199d;

        /* renamed from: f  reason: collision with root package name */
        private final c f16200f;
        final AtomicBoolean q = new AtomicBoolean();

        /* renamed from: c  reason: collision with root package name */
        private final io.reactivex.e0.b f16198c = new io.reactivex.e0.b();

        b(a aVar) {
            this.f16199d = aVar;
            this.f16200f = aVar.b();
        }

        @Override // io.reactivex.w.c
        public io.reactivex.e0.c c(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.f16198c.isDisposed()) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f16200f.e(runnable, j, timeUnit, this.f16198c);
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            if (this.q.compareAndSet(false, true)) {
                this.f16198c.dispose();
                if (f.h) {
                    this.f16200f.e(this, 0L, TimeUnit.NANOSECONDS, null);
                } else {
                    this.f16199d.d(this.f16200f);
                }
            }
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.q.get();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f16199d.d(this.f16200f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoScheduler.java */
    /* loaded from: classes4.dex */
    public static final class c extends h {

        /* renamed from: f  reason: collision with root package name */
        private long f16201f = 0;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }

        public long i() {
            return this.f16201f;
        }

        public void j(long j) {
            this.f16201f = j;
        }
    }

    static {
        c cVar = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        g = cVar;
        cVar.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxCachedThreadScheduler", max);
        f16191c = rxThreadFactory;
        f16192d = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        a aVar = new a(0L, null, rxThreadFactory);
        i = aVar;
        aVar.e();
    }

    public f() {
        this(f16191c);
    }

    @Override // io.reactivex.w
    public w.c b() {
        return new b(this.k.get());
    }

    public void f() {
        a aVar = new a(f16193e, f16194f, this.j);
        if (!this.k.compareAndSet(i, aVar)) {
            aVar.e();
        }
    }

    public f(ThreadFactory threadFactory) {
        this.j = threadFactory;
        this.k = new AtomicReference<>(i);
        f();
    }
}

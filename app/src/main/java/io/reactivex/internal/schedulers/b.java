package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.w;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ComputationScheduler.java */
/* loaded from: classes4.dex */
public final class b extends w {

    /* renamed from: c  reason: collision with root package name */
    static final C0313b f16161c;

    /* renamed from: d  reason: collision with root package name */
    static final RxThreadFactory f16162d;

    /* renamed from: e  reason: collision with root package name */
    static final int f16163e = f(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());

    /* renamed from: f  reason: collision with root package name */
    static final c f16164f;
    final ThreadFactory g;
    final AtomicReference<C0313b> h;

    /* compiled from: ComputationScheduler.java */
    /* loaded from: classes4.dex */
    static final class a extends w.c {

        /* renamed from: c  reason: collision with root package name */
        private final io.reactivex.internal.disposables.b f16165c;

        /* renamed from: d  reason: collision with root package name */
        private final io.reactivex.e0.b f16166d;

        /* renamed from: f  reason: collision with root package name */
        private final io.reactivex.internal.disposables.b f16167f;
        private final c q;
        volatile boolean x;

        a(c cVar) {
            this.q = cVar;
            io.reactivex.internal.disposables.b bVar = new io.reactivex.internal.disposables.b();
            this.f16165c = bVar;
            io.reactivex.e0.b bVar2 = new io.reactivex.e0.b();
            this.f16166d = bVar2;
            io.reactivex.internal.disposables.b bVar3 = new io.reactivex.internal.disposables.b();
            this.f16167f = bVar3;
            bVar3.b(bVar);
            bVar3.b(bVar2);
        }

        @Override // io.reactivex.w.c
        public io.reactivex.e0.c b(Runnable runnable) {
            if (this.x) {
                return EmptyDisposable.INSTANCE;
            }
            return this.q.e(runnable, 0L, TimeUnit.MILLISECONDS, this.f16165c);
        }

        @Override // io.reactivex.w.c
        public io.reactivex.e0.c c(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.x) {
                return EmptyDisposable.INSTANCE;
            }
            return this.q.e(runnable, j, timeUnit, this.f16166d);
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            if (!this.x) {
                this.x = true;
                this.f16167f.dispose();
            }
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.x;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ComputationScheduler.java */
    /* renamed from: io.reactivex.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0313b {
        final int a;

        /* renamed from: b  reason: collision with root package name */
        final c[] f16168b;

        /* renamed from: c  reason: collision with root package name */
        long f16169c;

        C0313b(int i, ThreadFactory threadFactory) {
            this.a = i;
            this.f16168b = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.f16168b[i2] = new c(threadFactory);
            }
        }

        public c a() {
            int i = this.a;
            if (i == 0) {
                return b.f16164f;
            }
            c[] cVarArr = this.f16168b;
            long j = this.f16169c;
            this.f16169c = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void b() {
            for (c cVar : this.f16168b) {
                cVar.dispose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ComputationScheduler.java */
    /* loaded from: classes4.dex */
    public static final class c extends h {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        c cVar = new c(new RxThreadFactory("RxComputationShutdown"));
        f16164f = cVar;
        cVar.dispose();
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f16162d = rxThreadFactory;
        C0313b bVar = new C0313b(0, rxThreadFactory);
        f16161c = bVar;
        bVar.b();
    }

    public b() {
        this(f16162d);
    }

    static int f(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    @Override // io.reactivex.w
    public w.c b() {
        return new a(this.h.get().a());
    }

    @Override // io.reactivex.w
    public io.reactivex.e0.c d(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.h.get().a().f(runnable, j, timeUnit);
    }

    @Override // io.reactivex.w
    public io.reactivex.e0.c e(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.h.get().a().g(runnable, j, j2, timeUnit);
    }

    public void g() {
        C0313b bVar = new C0313b(f16163e, this.g);
        if (!this.h.compareAndSet(f16161c, bVar)) {
            bVar.b();
        }
    }

    public b(ThreadFactory threadFactory) {
        this.g = threadFactory;
        this.h = new AtomicReference<>(f16161c);
        g();
    }
}

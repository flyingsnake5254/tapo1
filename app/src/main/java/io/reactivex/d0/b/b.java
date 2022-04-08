package io.reactivex.d0.b;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import io.reactivex.e0.c;
import io.reactivex.e0.d;
import io.reactivex.w;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* compiled from: HandlerScheduler.java */
/* loaded from: classes4.dex */
final class b extends w {

    /* renamed from: c  reason: collision with root package name */
    private final Handler f15622c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f15623d;

    /* compiled from: HandlerScheduler.java */
    /* loaded from: classes4.dex */
    private static final class a extends w.c {

        /* renamed from: c  reason: collision with root package name */
        private final Handler f15624c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f15625d;

        /* renamed from: f  reason: collision with root package name */
        private volatile boolean f15626f;

        a(Handler handler, boolean z) {
            this.f15624c = handler;
            this.f15625d = z;
        }

        @Override // io.reactivex.w.c
        @SuppressLint({"NewApi"})
        public c c(Runnable runnable, long j, TimeUnit timeUnit) {
            Objects.requireNonNull(runnable, "run == null");
            Objects.requireNonNull(timeUnit, "unit == null");
            if (this.f15626f) {
                return d.a();
            }
            RunnableC0291b bVar = new RunnableC0291b(this.f15624c, io.reactivex.j0.a.t(runnable));
            Message obtain = Message.obtain(this.f15624c, bVar);
            obtain.obj = this;
            if (this.f15625d) {
                obtain.setAsynchronous(true);
            }
            this.f15624c.sendMessageDelayed(obtain, timeUnit.toMillis(j));
            if (!this.f15626f) {
                return bVar;
            }
            this.f15624c.removeCallbacks(bVar);
            return d.a();
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            this.f15626f = true;
            this.f15624c.removeCallbacksAndMessages(this);
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.f15626f;
        }
    }

    /* compiled from: HandlerScheduler.java */
    /* renamed from: io.reactivex.d0.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static final class RunnableC0291b implements Runnable, c {

        /* renamed from: c  reason: collision with root package name */
        private final Handler f15627c;

        /* renamed from: d  reason: collision with root package name */
        private final Runnable f15628d;

        /* renamed from: f  reason: collision with root package name */
        private volatile boolean f15629f;

        RunnableC0291b(Handler handler, Runnable runnable) {
            this.f15627c = handler;
            this.f15628d = runnable;
        }

        @Override // io.reactivex.e0.c
        public void dispose() {
            this.f15627c.removeCallbacks(this);
            this.f15629f = true;
        }

        @Override // io.reactivex.e0.c
        public boolean isDisposed() {
            return this.f15629f;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f15628d.run();
            } catch (Throwable th) {
                io.reactivex.j0.a.r(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Handler handler, boolean z) {
        this.f15622c = handler;
        this.f15623d = z;
    }

    @Override // io.reactivex.w
    public w.c b() {
        return new a(this.f15622c, this.f15623d);
    }

    @Override // io.reactivex.w
    @SuppressLint({"NewApi"})
    public c d(Runnable runnable, long j, TimeUnit timeUnit) {
        Objects.requireNonNull(runnable, "run == null");
        Objects.requireNonNull(timeUnit, "unit == null");
        RunnableC0291b bVar = new RunnableC0291b(this.f15622c, io.reactivex.j0.a.t(runnable));
        Message obtain = Message.obtain(this.f15622c, bVar);
        if (this.f15623d) {
            obtain.setAsynchronous(true);
        }
        this.f15622c.sendMessageDelayed(obtain, timeUnit.toMillis(j));
        return bVar;
    }
}

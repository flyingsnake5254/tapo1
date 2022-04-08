package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.k.i;
import com.bumptech.glide.request.l.b;
import com.bumptech.glide.util.j;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: RequestFutureTarget.java */
/* loaded from: classes.dex */
public class e<R> implements c<R>, f<R> {

    /* renamed from: c  reason: collision with root package name */
    private static final a f1722c = new a();

    /* renamed from: d  reason: collision with root package name */
    private final int f1723d;

    /* renamed from: f  reason: collision with root package name */
    private final int f1724f;
    @GuardedBy("this")
    private boolean p0;
    @GuardedBy("this")
    private boolean p1;
    @GuardedBy("this")
    private boolean p2;
    @Nullable
    @GuardedBy("this")
    private GlideException p3;
    private final boolean q;
    private final a x;
    @Nullable
    @GuardedBy("this")
    private R y;
    @Nullable
    @GuardedBy("this")
    private d z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestFutureTarget.java */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class a {
        a() {
        }

        void a(Object obj) {
            obj.notifyAll();
        }

        void b(Object obj, long j) throws InterruptedException {
            obj.wait(j);
        }
    }

    public e(int i, int i2) {
        this(i, i2, true, f1722c);
    }

    private synchronized R k(Long l) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.q && !isDone()) {
            j.a();
        }
        if (this.p0) {
            throw new CancellationException();
        } else if (this.p2) {
            throw new ExecutionException(this.p3);
        } else if (this.p1) {
            return this.y;
        } else {
            if (l == null) {
                this.x.b(this, 0L);
            } else if (l.longValue() > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                long longValue = l.longValue() + currentTimeMillis;
                while (!isDone() && currentTimeMillis < longValue) {
                    this.x.b(this, longValue - currentTimeMillis);
                    currentTimeMillis = System.currentTimeMillis();
                }
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            } else if (this.p2) {
                throw new ExecutionException(this.p3);
            } else if (this.p0) {
                throw new CancellationException();
            } else if (this.p1) {
                return this.y;
            } else {
                throw new TimeoutException();
            }
        }
    }

    @Override // com.bumptech.glide.request.k.j
    public void a(@NonNull i iVar) {
    }

    @Override // com.bumptech.glide.request.k.j
    public void b(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.k.j
    @Nullable
    public synchronized d c() {
        return this.z;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        synchronized (this) {
            if (isDone()) {
                return false;
            }
            this.p0 = true;
            this.x.a(this);
            d dVar = null;
            if (z) {
                d dVar2 = this.z;
                this.z = null;
                dVar = dVar2;
            }
            if (dVar != null) {
                dVar.clear();
            }
            return true;
        }
    }

    @Override // com.bumptech.glide.request.k.j
    public void d(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.k.j
    public synchronized void e(@NonNull R r, @Nullable b<? super R> bVar) {
    }

    @Override // com.bumptech.glide.request.k.j
    public synchronized void f(@Nullable d dVar) {
        this.z = dVar;
    }

    @Override // com.bumptech.glide.request.f
    public synchronized boolean g(@Nullable GlideException glideException, Object obj, com.bumptech.glide.request.k.j<R> jVar, boolean z) {
        this.p2 = true;
        this.p3 = glideException;
        this.x.a(this);
        return false;
    }

    @Override // java.util.concurrent.Future
    public R get() throws InterruptedException, ExecutionException {
        try {
            return k(null);
        } catch (TimeoutException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // com.bumptech.glide.request.k.j
    public synchronized void h(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.f
    public synchronized boolean i(R r, Object obj, com.bumptech.glide.request.k.j<R> jVar, DataSource dataSource, boolean z) {
        this.p1 = true;
        this.y = r;
        this.x.a(this);
        return false;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.p0;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z;
        if (!this.p0 && !this.p1) {
            if (!this.p2) {
                z = false;
            }
        }
        z = true;
        return z;
    }

    @Override // com.bumptech.glide.request.k.j
    public void j(@NonNull i iVar) {
        iVar.d(this.f1723d, this.f1724f);
    }

    @Override // com.bumptech.glide.manager.m
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.m
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.m
    public void onStop() {
    }

    e(int i, int i2, boolean z, a aVar) {
        this.f1723d = i;
        this.f1724f = i2;
        this.q = z;
        this.x = aVar;
    }

    @Override // java.util.concurrent.Future
    public R get(long j, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return k(Long.valueOf(timeUnit.toMillis(j)));
    }
}

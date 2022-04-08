package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.v.d;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* compiled from: LottieTask.java */
/* loaded from: classes.dex */
public class m<T> {
    public static Executor a = Executors.newCachedThreadPool();

    /* renamed from: b  reason: collision with root package name */
    private final Set<h<T>> f937b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<h<Throwable>> f938c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f939d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private volatile l<T> f940e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieTask.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.f940e != null) {
                l lVar = m.this.f940e;
                if (lVar.b() != null) {
                    m.this.i(lVar.b());
                } else {
                    m.this.g(lVar.a());
                }
            }
        }
    }

    /* compiled from: LottieTask.java */
    /* loaded from: classes.dex */
    private class b extends FutureTask<l<T>> {
        b(Callable<l<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (!isCancelled()) {
                try {
                    m.this.l(get());
                } catch (InterruptedException | ExecutionException e2) {
                    m.this.l(new l(e2));
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public m(Callable<l<T>> callable) {
        this(callable, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g(Throwable th) {
        ArrayList<h> arrayList = new ArrayList(this.f938c);
        if (arrayList.isEmpty()) {
            d.d("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        for (h hVar : arrayList) {
            hVar.a(th);
        }
    }

    private void h() {
        this.f939d.post(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i(T t) {
        for (h hVar : new ArrayList(this.f937b)) {
            hVar.a(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(@Nullable l<T> lVar) {
        if (this.f940e == null) {
            this.f940e = lVar;
            h();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    public synchronized m<T> e(h<Throwable> hVar) {
        if (!(this.f940e == null || this.f940e.a() == null)) {
            hVar.a(this.f940e.a());
        }
        this.f938c.add(hVar);
        return this;
    }

    public synchronized m<T> f(h<T> hVar) {
        if (!(this.f940e == null || this.f940e.b() == null)) {
            hVar.a(this.f940e.b());
        }
        this.f937b.add(hVar);
        return this;
    }

    public synchronized m<T> j(h<Throwable> hVar) {
        this.f938c.remove(hVar);
        return this;
    }

    public synchronized m<T> k(h<T> hVar) {
        this.f937b.remove(hVar);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    m(Callable<l<T>> callable, boolean z) {
        this.f937b = new LinkedHashSet(1);
        this.f938c = new LinkedHashSet(1);
        this.f939d = new Handler(Looper.getMainLooper());
        this.f940e = null;
        if (z) {
            try {
                l(callable.call());
            } catch (Throwable th) {
                l(new l<>(th));
            }
        } else {
            a.execute(new b(callable));
        }
    }
}

package com.tplink.iot.view.ipcamera.base;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes2.dex */
public class AutoRefreshTimer implements LifecycleObserver {

    /* renamed from: c  reason: collision with root package name */
    private Timer f8702c;

    /* renamed from: d  reason: collision with root package name */
    private b f8703d;

    /* renamed from: f  reason: collision with root package name */
    private a f8704f;
    private final long q;
    private final long x;

    /* loaded from: classes2.dex */
    public interface a {
        void h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b extends TimerTask {
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        private final WeakReference<a> f8705c;

        b(@NonNull a aVar) {
            this.f8705c = new WeakReference<>(aVar);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            a aVar = this.f8705c.get();
            if (aVar != null) {
                aVar.h();
            } else {
                cancel();
            }
        }
    }

    public AutoRefreshTimer(long j, long j2, a aVar) {
        this.q = j;
        this.x = j2;
        this.f8704f = aVar;
    }

    public void a(LifecycleOwner lifecycleOwner) {
        lifecycleOwner.getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void cancel() {
        b bVar = this.f8703d;
        if (bVar != null) {
            bVar.cancel();
            this.f8703d = null;
        }
        Timer timer = this.f8702c;
        if (timer != null) {
            timer.cancel();
            this.f8702c = null;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void schedule() {
        cancel();
        this.f8702c = new Timer();
        b bVar = new b(this.f8704f);
        this.f8703d = bVar;
        this.f8702c.schedule(bVar, this.q, this.x);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void teardown() {
        this.f8704f = null;
        cancel();
    }
}

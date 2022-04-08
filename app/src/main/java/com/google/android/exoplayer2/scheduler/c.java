package com.google.android.exoplayer2.scheduler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.scheduler.c;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;

/* compiled from: RequirementsWatcher.java */
/* loaded from: classes.dex */
public final class c {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private final AbstractC0082c f3145b;

    /* renamed from: c  reason: collision with root package name */
    private final Requirements f3146c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f3147d = o0.x();
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private b f3148e;

    /* renamed from: f  reason: collision with root package name */
    private int f3149f;
    @Nullable
    private d g;

    /* compiled from: RequirementsWatcher.java */
    /* loaded from: classes.dex */
    private class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!isInitialStickyBroadcast()) {
                c.this.e();
            }
        }
    }

    /* compiled from: RequirementsWatcher.java */
    /* renamed from: com.google.android.exoplayer2.scheduler.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface AbstractC0082c {
        void a(c cVar, int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RequirementsWatcher.java */
    @RequiresApi(24)
    /* loaded from: classes.dex */
    public final class d extends ConnectivityManager.NetworkCallback {
        private boolean a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f3150b;

        private d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void b() {
            if (c.this.g != null) {
                c.this.e();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void d() {
            if (c.this.g != null) {
                c.this.g();
            }
        }

        private void e() {
            c.this.f3147d.post(new Runnable() { // from class: com.google.android.exoplayer2.scheduler.a
                @Override // java.lang.Runnable
                public final void run() {
                    c.d.this.b();
                }
            });
        }

        private void f() {
            c.this.f3147d.post(new Runnable() { // from class: com.google.android.exoplayer2.scheduler.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.d.this.d();
                }
            });
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            e();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onBlockedStatusChanged(Network network, boolean z) {
            if (!z) {
                f();
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            boolean hasCapability = networkCapabilities.hasCapability(16);
            if (!this.a || this.f3150b != hasCapability) {
                this.a = true;
                this.f3150b = hasCapability;
                e();
            } else if (hasCapability) {
                f();
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            e();
        }
    }

    public c(Context context, AbstractC0082c cVar, Requirements requirements) {
        this.a = context.getApplicationContext();
        this.f3145b = cVar;
        this.f3146c = requirements;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        int b2 = this.f3146c.b(this.a);
        if (this.f3149f != b2) {
            this.f3149f = b2;
            this.f3145b.a(this, b2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if ((this.f3149f & 3) != 0) {
            e();
        }
    }

    @RequiresApi(24)
    private void h() {
        d dVar = new d();
        this.g = dVar;
        ((ConnectivityManager) g.e((ConnectivityManager) this.a.getSystemService("connectivity"))).registerDefaultNetworkCallback(dVar);
    }

    @RequiresApi(24)
    private void k() {
        ((ConnectivityManager) g.e((ConnectivityManager) this.a.getSystemService("connectivity"))).unregisterNetworkCallback((ConnectivityManager.NetworkCallback) g.e(this.g));
        this.g = null;
    }

    public Requirements f() {
        return this.f3146c;
    }

    public int i() {
        this.f3149f = this.f3146c.b(this.a);
        IntentFilter intentFilter = new IntentFilter();
        if (this.f3146c.l()) {
            if (o0.a >= 24) {
                h();
            } else {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
        }
        if (this.f3146c.d()) {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        if (this.f3146c.h()) {
            if (o0.a >= 23) {
                intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
            } else {
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
            }
        }
        if (this.f3146c.n()) {
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        }
        b bVar = new b();
        this.f3148e = bVar;
        this.a.registerReceiver(bVar, intentFilter, null, this.f3147d);
        return this.f3149f;
    }

    public void j() {
        this.a.unregisterReceiver((BroadcastReceiver) g.e(this.f3148e));
        this.f3148e = null;
        if (o0.a >= 24 && this.g != null) {
            k();
        }
    }
}

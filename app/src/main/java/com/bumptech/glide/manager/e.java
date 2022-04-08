package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.manager.c;
import com.bumptech.glide.util.i;

/* compiled from: DefaultConnectivityMonitor.java */
/* loaded from: classes.dex */
final class e implements c {

    /* renamed from: c  reason: collision with root package name */
    private final Context f1692c;

    /* renamed from: d  reason: collision with root package name */
    final c.a f1693d;

    /* renamed from: f  reason: collision with root package name */
    boolean f1694f;
    private boolean q;
    private final BroadcastReceiver x = new a();

    /* compiled from: DefaultConnectivityMonitor.java */
    /* loaded from: classes.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NonNull Context context, Intent intent) {
            e eVar = e.this;
            boolean z = eVar.f1694f;
            eVar.f1694f = eVar.g(context);
            if (z != e.this.f1694f) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + e.this.f1694f);
                }
                e eVar2 = e.this;
                eVar2.f1693d.a(eVar2.f1694f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(@NonNull Context context, @NonNull c.a aVar) {
        this.f1692c = context.getApplicationContext();
        this.f1693d = aVar;
    }

    private void i() {
        if (!this.q) {
            this.f1694f = g(this.f1692c);
            try {
                this.f1692c.registerReceiver(this.x, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.q = true;
            } catch (SecurityException e2) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Log.w("ConnectivityMonitor", "Failed to register", e2);
                }
            }
        }
    }

    private void k() {
        if (this.q) {
            this.f1692c.unregisterReceiver(this.x);
            this.q = false;
        }
    }

    @SuppressLint({"MissingPermission"})
    boolean g(@NonNull Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) i.d((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e2) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e2);
            }
            return true;
        }
    }

    @Override // com.bumptech.glide.manager.m
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.m
    public void onStart() {
        i();
    }

    @Override // com.bumptech.glide.manager.m
    public void onStop() {
        k();
    }
}

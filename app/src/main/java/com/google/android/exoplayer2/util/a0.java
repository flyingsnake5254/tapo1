package com.google.android.exoplayer2.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: NetworkTypeObserver.java */
/* loaded from: classes.dex */
public final class a0 {
    @Nullable
    private static a0 a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f3889b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private final CopyOnWriteArrayList<WeakReference<c>> f3890c = new CopyOnWriteArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final Object f3891d = new Object();
    @GuardedBy("networkTypeLock")

    /* renamed from: e  reason: collision with root package name */
    private int f3892e = 0;

    /* compiled from: NetworkTypeObserver.java */
    /* loaded from: classes.dex */
    public static final class b {
        private static volatile boolean a;
    }

    /* compiled from: NetworkTypeObserver.java */
    /* loaded from: classes.dex */
    public interface c {
        void a(int i);
    }

    /* compiled from: NetworkTypeObserver.java */
    /* loaded from: classes.dex */
    private final class d extends BroadcastReceiver {
        private d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int f2 = a0.f(context);
            int i = o0.a;
            if (i >= 29 && !b.a && f2 == 5) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) g.e((TelephonyManager) context.getSystemService("phone"));
                    e eVar = new e();
                    if (i < 31) {
                        telephonyManager.listen(eVar, 1);
                    } else {
                        telephonyManager.listen(eVar, 1048576);
                    }
                    telephonyManager.listen(eVar, 0);
                    return;
                } catch (RuntimeException unused) {
                }
            }
            a0.this.k(f2);
        }
    }

    /* compiled from: NetworkTypeObserver.java */
    /* loaded from: classes.dex */
    private class e extends PhoneStateListener {
        private e() {
        }

        @Override // android.telephony.PhoneStateListener
        @RequiresApi(31)
        public void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
            int overrideNetworkType = telephonyDisplayInfo.getOverrideNetworkType();
            a0.this.k(overrideNetworkType == 3 || overrideNetworkType == 4 ? 10 : 5);
        }

        @Override // android.telephony.PhoneStateListener
        public void onServiceStateChanged(@Nullable ServiceState serviceState) {
            String serviceState2 = serviceState == null ? "" : serviceState.toString();
            a0.this.k(serviceState2.contains("nrState=CONNECTED") || serviceState2.contains("nrState=NOT_RESTRICTED") ? 10 : 5);
        }
    }

    private a0(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(new d(), intentFilter);
    }

    public static synchronized a0 c(Context context) {
        a0 a0Var;
        synchronized (a0.class) {
            if (a == null) {
                a = new a0(context);
            }
            a0Var = a;
        }
        return a0Var;
    }

    private static int d(NetworkInfo networkInfo) {
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
                return 3;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 17:
                return 4;
            case 13:
                return 5;
            case 16:
            case 19:
            default:
                return 6;
            case 18:
                return 2;
            case 20:
                return o0.a >= 29 ? 9 : 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int f(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        int i = 0;
        if (connectivityManager == null) {
            return 0;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            i = 1;
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    if (type == 1) {
                        return 2;
                    }
                    if (!(type == 4 || type == 5)) {
                        if (type != 6) {
                            return type != 9 ? 8 : 7;
                        }
                        return 5;
                    }
                }
                return d(activeNetworkInfo);
            }
        } catch (SecurityException unused) {
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void h(c cVar) {
        cVar.a(e());
    }

    private void j() {
        Iterator<WeakReference<c>> it = this.f3890c.iterator();
        while (it.hasNext()) {
            WeakReference<c> next = it.next();
            if (next.get() == null) {
                this.f3890c.remove(next);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i) {
        synchronized (this.f3891d) {
            if (this.f3892e != i) {
                this.f3892e = i;
                Iterator<WeakReference<c>> it = this.f3890c.iterator();
                while (it.hasNext()) {
                    WeakReference<c> next = it.next();
                    c cVar = next.get();
                    if (cVar != null) {
                        cVar.a(i);
                    } else {
                        this.f3890c.remove(next);
                    }
                }
            }
        }
    }

    public int e() {
        int i;
        synchronized (this.f3891d) {
            i = this.f3892e;
        }
        return i;
    }

    public void i(final c cVar) {
        j();
        this.f3890c.add(new WeakReference<>(cVar));
        this.f3889b.post(new Runnable() { // from class: com.google.android.exoplayer2.util.c
            @Override // java.lang.Runnable
            public final void run() {
                a0.this.h(cVar);
            }
        });
    }
}

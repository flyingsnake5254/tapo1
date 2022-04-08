package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.play_billing.zza;
import com.google.android.gms.internal.play_billing.zzc;
import java.util.concurrent.Future;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@3.0.3 */
/* loaded from: classes.dex */
public final class v implements ServiceConnection {

    /* renamed from: c  reason: collision with root package name */
    private final Object f1245c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private boolean f1246d = false;

    /* renamed from: f  reason: collision with root package name */
    private e f1247f;
    final /* synthetic */ d q;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ v(d dVar, e eVar, t0 t0Var) {
        this.q = dVar;
        this.f1247f = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(g gVar) {
        this.q.m(new s(this, gVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        synchronized (this.f1245c) {
            this.f1247f = null;
            this.f1246d = true;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Future M;
        g n;
        zza.zza("BillingClient", "Billing service connected.");
        this.q.g = zzc.zzo(iBinder);
        M = this.q.M(new t(this), 30000L, new u(this));
        if (M == null) {
            n = this.q.n();
            f(n);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zza.zzb("BillingClient", "Billing service disconnected.");
        this.q.g = null;
        this.q.a = 0;
        synchronized (this.f1245c) {
            e eVar = this.f1247f;
            if (eVar != null) {
                eVar.b();
            }
        }
    }
}

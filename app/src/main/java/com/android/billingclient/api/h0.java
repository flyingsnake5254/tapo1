package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.internal.play_billing.zza;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@3.0.3 */
/* loaded from: classes.dex */
public final class h0 extends BroadcastReceiver {
    private final k a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1205b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ i0 f1206c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h0(i0 i0Var, k kVar, g0 g0Var) {
        this.f1206c = i0Var;
        this.a = kVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ k c(h0 h0Var) {
        return h0Var.a;
    }

    public final void a(Context context, IntentFilter intentFilter) {
        h0 h0Var;
        if (!this.f1205b) {
            h0Var = this.f1206c.f1207b;
            context.registerReceiver(h0Var, intentFilter);
            this.f1205b = true;
        }
    }

    public final void b(Context context) {
        h0 h0Var;
        if (this.f1205b) {
            h0Var = this.f1206c.f1207b;
            context.unregisterReceiver(h0Var);
            this.f1205b = false;
            return;
        }
        zza.zzb("BillingBroadcastManager", "Receiver is not registered.");
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.a.a(zza.zzc(intent, "BillingBroadcastManager"), zza.zzf(intent.getExtras()));
    }
}

package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zza;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
/* loaded from: classes.dex */
final class n0 implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Exception f1216c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ p0 f1217d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n0(p0 p0Var, Exception exc) {
        this.f1217d = p0Var;
        this.f1216c = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String valueOf = String.valueOf(this.f1216c);
        StringBuilder sb = new StringBuilder(valueOf.length() + 32);
        sb.append("Error acknowledge purchase; ex: ");
        sb.append(valueOf);
        zza.zzb("BillingClient", sb.toString());
        this.f1217d.f1227d.a(y.q);
    }
}

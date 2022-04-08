package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zza;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@3.0.3 */
/* loaded from: classes.dex */
public final class x0 implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Exception f1254c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ i f1255d;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ String f1256f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x0(d dVar, Exception exc, i iVar, String str) {
        this.f1254c = exc;
        this.f1255d = iVar;
        this.f1256f = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String valueOf = String.valueOf(this.f1254c);
        StringBuilder sb = new StringBuilder(valueOf.length() + 30);
        sb.append("Error consuming purchase; ex: ");
        sb.append(valueOf);
        zza.zzb("BillingClient", sb.toString());
        this.f1255d.a(y.q, this.f1256f);
    }
}

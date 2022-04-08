package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zza;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@3.0.3 */
/* loaded from: classes.dex */
public final class v0 implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ i f1248c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ g f1249d;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ String f1250f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v0(d dVar, i iVar, g gVar, String str) {
        this.f1248c = iVar;
        this.f1249d = gVar;
        this.f1250f = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zza.zza("BillingClient", "Successfully consumed purchase.");
        this.f1248c.a(this.f1249d, this.f1250f);
    }
}

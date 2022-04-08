package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zza;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@3.0.3 */
/* loaded from: classes.dex */
public final class w0 implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f1251c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ i f1252d;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ g f1253f;
    final /* synthetic */ String q;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w0(d dVar, int i, i iVar, g gVar, String str) {
        this.f1251c = i;
        this.f1252d = iVar;
        this.f1253f = gVar;
        this.q = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f1251c;
        StringBuilder sb = new StringBuilder(63);
        sb.append("Error consuming purchase with token. Response code: ");
        sb.append(i);
        zza.zzb("BillingClient", sb.toString());
        this.f1252d.a(this.f1253f, this.q);
    }
}

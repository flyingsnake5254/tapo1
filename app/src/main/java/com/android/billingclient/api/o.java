package com.android.billingclient.api;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzd;
import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
/* loaded from: classes.dex */
final class o implements Callable<Bundle> {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ SkuDetails f1218c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ String f1219d;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ d f1220f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(d dVar, SkuDetails skuDetails, String str) {
        this.f1220f = dVar;
        this.f1218c = skuDetails;
        this.f1219d = str;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Bundle call() throws Exception {
        zzd zzdVar;
        Context context;
        zzdVar = this.f1220f.g;
        context = this.f1220f.f1192f;
        return zzdVar.zzc(3, context.getPackageName(), this.f1218c.i(), this.f1219d, null);
    }
}

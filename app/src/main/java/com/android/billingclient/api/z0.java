package com.android.billingclient.api;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzd;
import java.util.Arrays;
import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
/* loaded from: classes.dex */
final class z0 implements Callable<Bundle> {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ f f1265c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ SkuDetails f1266d;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ d f1267f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z0(d dVar, f fVar, SkuDetails skuDetails) {
        this.f1267f = dVar;
        this.f1265c = fVar;
        this.f1266d = skuDetails;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Bundle call() throws Exception {
        zzd zzdVar;
        Context context;
        zzdVar = this.f1267f.g;
        context = this.f1267f.f1192f;
        return zzdVar.zzf(5, context.getPackageName(), Arrays.asList(this.f1265c.a()), this.f1266d.i(), "subs", null);
    }
}

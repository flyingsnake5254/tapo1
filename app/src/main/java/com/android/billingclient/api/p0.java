package com.android.billingclient.api;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zza;
import com.google.android.gms.internal.play_billing.zzd;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@3.0.3 */
/* loaded from: classes.dex */
public final class p0 implements Callable<Void> {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ a f1226c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ b f1227d;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ d f1228f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p0(d dVar, a aVar, b bVar) {
        this.f1228f = dVar;
        this.f1226c = aVar;
        this.f1227d = bVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Void call() throws Exception {
        zzd zzdVar;
        Context context;
        String str;
        try {
            zzdVar = this.f1228f.g;
            context = this.f1228f.f1192f;
            String packageName = context.getPackageName();
            String a = this.f1226c.a();
            a aVar = this.f1226c;
            str = this.f1228f.f1188b;
            Bundle zzn = zzdVar.zzn(9, packageName, a, zza.zzk(aVar, str));
            this.f1228f.m(new o0(this, zza.zzd(zzn, "BillingClient"), zza.zze(zzn, "BillingClient")));
            return null;
        } catch (Exception e2) {
            this.f1228f.m(new n0(this, e2));
            return null;
        }
    }
}

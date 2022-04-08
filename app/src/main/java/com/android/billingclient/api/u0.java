package com.android.billingclient.api;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzd;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@3.0.3 */
/* loaded from: classes.dex */
public final class u0 implements Callable<Integer> {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f1243c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ d f1244d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u0(d dVar, String str) {
        this.f1244d = dVar;
        this.f1243c = str;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Integer call() throws Exception {
        zzd zzdVar;
        Context context;
        zzdVar = this.f1244d.g;
        context = this.f1244d.f1192f;
        String packageName = context.getPackageName();
        String str = this.f1243c;
        Bundle bundle = new Bundle();
        bundle.putBoolean("vr", true);
        return Integer.valueOf(zzdVar.zzi(7, packageName, str, bundle));
    }
}

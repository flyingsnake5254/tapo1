package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
final class zzjh implements Runnable {
    final /* synthetic */ zzjj zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjh(zzjj zzjjVar) {
        this.zza = zzjjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjk zzjkVar = this.zza.zza;
        Context zzax = zzjkVar.zzs.zzax();
        this.zza.zza.zzs.zzat();
        zzjk.zzJ(zzjkVar, new ComponentName(zzax, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}

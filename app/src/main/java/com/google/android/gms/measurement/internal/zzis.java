package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
public final class zzis implements Runnable {
    final /* synthetic */ zzid zza;
    final /* synthetic */ zzjk zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzis(zzjk zzjkVar, zzid zzidVar) {
        this.zzb = zzjkVar;
        this.zza = zzidVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzed zzedVar;
        zzedVar = this.zzb.zzb;
        if (zzedVar == null) {
            this.zzb.zzs.zzau().zzb().zza("Failed to send current screen to service");
            return;
        }
        try {
            zzid zzidVar = this.zza;
            if (zzidVar == null) {
                zzedVar.zzk(0L, null, null, this.zzb.zzs.zzax().getPackageName());
            } else {
                zzedVar.zzk(zzidVar.zzc, zzidVar.zza, zzidVar.zzb, this.zzb.zzs.zzax().getPackageName());
            }
            this.zzb.zzP();
        } catch (RemoteException e2) {
            this.zzb.zzs.zzau().zzb().zzb("Failed to send current screen to the service", e2);
        }
    }
}

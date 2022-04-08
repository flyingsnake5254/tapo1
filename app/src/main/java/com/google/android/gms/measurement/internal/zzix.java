package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
public final class zzix implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ zzjk zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzix(zzjk zzjkVar, zzp zzpVar) {
        this.zzb = zzjkVar;
        this.zza = zzpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzed zzedVar;
        zzedVar = this.zzb.zzb;
        if (zzedVar == null) {
            this.zzb.zzs.zzau().zzb().zza("Failed to send measurementEnabled to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzedVar.zzh(this.zza);
            this.zzb.zzP();
        } catch (RemoteException e2) {
            this.zzb.zzs.zzau().zzb().zzb("Failed to send measurementEnabled to the service", e2);
        }
    }
}

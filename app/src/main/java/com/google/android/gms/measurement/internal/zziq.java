package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcf;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
public final class zziq implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ zzcf zzb;
    final /* synthetic */ zzjk zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zziq(zzjk zzjkVar, zzp zzpVar, zzcf zzcfVar) {
        this.zzc = zzjkVar;
        this.zza = zzpVar;
        this.zzb = zzcfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfu zzfuVar;
        zzed zzedVar;
        String str = null;
        try {
            try {
                if (!this.zzc.zzs.zzd().zzi().zzh()) {
                    this.zzc.zzs.zzau().zzh().zza("Analytics storage consent denied; will not get app instance id");
                    this.zzc.zzs.zzk().zzE(null);
                    this.zzc.zzs.zzd().zze.zzb(null);
                    zzfuVar = this.zzc.zzs;
                } else {
                    zzedVar = this.zzc.zzb;
                    if (zzedVar == null) {
                        this.zzc.zzs.zzau().zzb().zza("Failed to get app instance id");
                        zzfuVar = this.zzc.zzs;
                    } else {
                        Preconditions.checkNotNull(this.zza);
                        str = zzedVar.zzl(this.zza);
                        if (str != null) {
                            this.zzc.zzs.zzk().zzE(str);
                            this.zzc.zzs.zzd().zze.zzb(str);
                        }
                        this.zzc.zzP();
                        zzfuVar = this.zzc.zzs;
                    }
                }
            } catch (RemoteException e2) {
                this.zzc.zzs.zzau().zzb().zzb("Failed to get app instance id", e2);
                zzfuVar = this.zzc.zzs;
            }
            zzfuVar.zzl().zzad(this.zzb, str);
        } catch (Throwable th) {
            this.zzc.zzs.zzl().zzad(this.zzb, null);
            throw th;
        }
    }
}

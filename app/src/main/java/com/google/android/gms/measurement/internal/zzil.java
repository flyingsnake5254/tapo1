package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcf;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
public final class zzil implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzp zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzcf zze;
    final /* synthetic */ zzjk zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzil(zzjk zzjkVar, String str, String str2, zzp zzpVar, boolean z, zzcf zzcfVar) {
        this.zzf = zzjkVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzpVar;
        this.zzd = z;
        this.zze = zzcfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Throwable th;
        RemoteException e2;
        zzed zzedVar;
        Bundle bundle = new Bundle();
        try {
            zzedVar = this.zzf.zzb;
            if (zzedVar == null) {
                this.zzf.zzs.zzau().zzb().zzc("Failed to get user properties; not connected to service", this.zza, this.zzb);
                this.zzf.zzs.zzl().zzai(this.zze, bundle);
                return;
            }
            Preconditions.checkNotNull(this.zzc);
            List<zzkq> zzo = zzedVar.zzo(this.zza, this.zzb, this.zzd, this.zzc);
            bundle = new Bundle();
            if (zzo != null) {
                for (zzkq zzkqVar : zzo) {
                    String str = zzkqVar.zze;
                    if (str != null) {
                        bundle.putString(zzkqVar.zzb, str);
                    } else {
                        Long l = zzkqVar.zzd;
                        if (l != null) {
                            bundle.putLong(zzkqVar.zzb, l.longValue());
                        } else {
                            Double d2 = zzkqVar.zzg;
                            if (d2 != null) {
                                bundle.putDouble(zzkqVar.zzb, d2.doubleValue());
                            }
                        }
                    }
                }
            }
            try {
                try {
                    this.zzf.zzP();
                    this.zzf.zzs.zzl().zzai(this.zze, bundle);
                } catch (RemoteException e3) {
                    e2 = e3;
                    this.zzf.zzs.zzau().zzb().zzc("Failed to get user properties; remote exception", this.zza, e2);
                    this.zzf.zzs.zzl().zzai(this.zze, bundle);
                }
            } catch (Throwable th2) {
                th = th2;
                this.zzf.zzs.zzl().zzai(this.zze, bundle);
                throw th;
            }
        } catch (RemoteException e4) {
            e2 = e4;
            bundle = bundle;
        } catch (Throwable th3) {
            th = th3;
            this.zzf.zzs.zzl().zzai(this.zze, bundle);
            throw th;
        }
    }
}

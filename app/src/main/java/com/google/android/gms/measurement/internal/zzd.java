package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
public final class zzd extends zze {
    private long zzc;
    private final Map<String, Integer> zzb = new ArrayMap();
    private final Map<String, Long> zza = new ArrayMap();

    public zzd(zzfu zzfuVar) {
        super(zzfuVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzd(zzd zzdVar, String str, long j) {
        zzdVar.zzg();
        Preconditions.checkNotEmpty(str);
        if (zzdVar.zzb.isEmpty()) {
            zzdVar.zzc = j;
        }
        Integer num = zzdVar.zzb.get(str);
        if (num != null) {
            zzdVar.zzb.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (zzdVar.zzb.size() >= 100) {
            zzdVar.zzs.zzau().zze().zza("Too many ads visible");
        } else {
            zzdVar.zzb.put(str, 1);
            zzdVar.zza.put(str, Long.valueOf(j));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zze(zzd zzdVar, String str, long j) {
        zzdVar.zzg();
        Preconditions.checkNotEmpty(str);
        Integer num = zzdVar.zzb.get(str);
        if (num != null) {
            zzid zzh = zzdVar.zzs.zzx().zzh(false);
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                zzdVar.zzb.remove(str);
                Long l = zzdVar.zza.get(str);
                if (l == null) {
                    zzdVar.zzs.zzau().zzb().zza("First ad unit exposure time was never set");
                } else {
                    long longValue = l.longValue();
                    zzdVar.zza.remove(str);
                    zzdVar.zzi(str, j - longValue, zzh);
                }
                if (zzdVar.zzb.isEmpty()) {
                    long j2 = zzdVar.zzc;
                    if (j2 == 0) {
                        zzdVar.zzs.zzau().zzb().zza("First ad exposure time was never set");
                        return;
                    }
                    zzdVar.zzh(j - j2, zzh);
                    zzdVar.zzc = 0L;
                    return;
                }
                return;
            }
            zzdVar.zzb.put(str, Integer.valueOf(intValue));
            return;
        }
        zzdVar.zzs.zzau().zzb().zzb("Call to endAdUnitExposure for unknown ad unit id", str);
    }

    @WorkerThread
    private final void zzh(long j, zzid zzidVar) {
        if (zzidVar == null) {
            this.zzs.zzau().zzk().zza("Not logging ad exposure. No active activity");
        } else if (j < 1000) {
            this.zzs.zzau().zzk().zzb("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j);
            zzik.zzm(zzidVar, bundle, true);
            this.zzs.zzk().zzs("am", "_xa", bundle);
        }
    }

    @WorkerThread
    private final void zzi(String str, long j, zzid zzidVar) {
        if (zzidVar == null) {
            this.zzs.zzau().zzk().zza("Not logging ad unit exposure. No active activity");
        } else if (j < 1000) {
            this.zzs.zzau().zzk().zzb("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j);
            zzik.zzm(zzidVar, bundle, true);
            this.zzs.zzk().zzs("am", "_xu", bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void zzj(long j) {
        for (String str : this.zza.keySet()) {
            this.zza.put(str, Long.valueOf(j));
        }
        if (!this.zza.isEmpty()) {
            this.zzc = j;
        }
    }

    public final void zza(String str, long j) {
        if (str == null || str.length() == 0) {
            this.zzs.zzau().zzb().zza("Ad unit id must be a non-empty string");
        } else {
            this.zzs.zzav().zzh(new zza(this, str, j));
        }
    }

    public final void zzb(String str, long j) {
        if (str == null || str.length() == 0) {
            this.zzs.zzau().zzb().zza("Ad unit id must be a non-empty string");
        } else {
            this.zzs.zzav().zzh(new zzb(this, str, j));
        }
    }

    @WorkerThread
    public final void zzc(long j) {
        zzid zzh = this.zzs.zzx().zzh(false);
        for (String str : this.zza.keySet()) {
            zzi(str, j - this.zza.get(str).longValue(), zzh);
        }
        if (!this.zza.isEmpty()) {
            zzh(j - this.zzc, zzh);
        }
        zzj(j);
    }
}

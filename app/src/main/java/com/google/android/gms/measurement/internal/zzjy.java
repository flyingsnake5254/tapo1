package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzoa;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
public final class zzjy {
    final /* synthetic */ zzjz zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjy(zzjz zzjzVar) {
        this.zza = zzjzVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void zza() {
        this.zza.zzg();
        if (this.zza.zzs.zzd().zzl(this.zza.zzs.zzay().currentTimeMillis())) {
            this.zza.zzs.zzd().zzg.zzb(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.zza.zzs.zzau().zzk().zza("Detected application was in foreground");
                zzc(this.zza.zzs.zzay().currentTimeMillis(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void zzb(long j, boolean z) {
        this.zza.zzg();
        this.zza.zzl();
        if (this.zza.zzs.zzd().zzl(j)) {
            this.zza.zzs.zzd().zzg.zzb(true);
        }
        this.zza.zzs.zzd().zzj.zzb(j);
        if (this.zza.zzs.zzd().zzg.zza()) {
            zzc(j, z);
        }
    }

    @VisibleForTesting
    @WorkerThread
    final void zzc(long j, boolean z) {
        this.zza.zzg();
        if (this.zza.zzs.zzF()) {
            this.zza.zzs.zzd().zzj.zzb(j);
            this.zza.zzs.zzau().zzk().zzb("Session started, time", Long.valueOf(this.zza.zzs.zzay().elapsedRealtime()));
            Long valueOf = Long.valueOf(j / 1000);
            this.zza.zzs.zzk().zzB(ThingModelDefine.Property.PROPERTY_AUTO, "_sid", valueOf, j);
            this.zza.zzs.zzd().zzg.zzb(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", valueOf.longValue());
            if (this.zza.zzs.zzc().zzn(null, zzea.zzah) && z) {
                bundle.putLong("_aib", 1L);
            }
            this.zza.zzs.zzk().zzt(ThingModelDefine.Property.PROPERTY_AUTO, "_s", j, bundle);
            zzoa.zzb();
            if (this.zza.zzs.zzc().zzn(null, zzea.zzam)) {
                String zza = this.zza.zzs.zzd().zzo.zza();
                if (!TextUtils.isEmpty(zza)) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("_ffr", zza);
                    this.zza.zzs.zzk().zzt(ThingModelDefine.Property.PROPERTY_AUTO, "_ssr", j, bundle2);
                }
            }
        }
    }
}

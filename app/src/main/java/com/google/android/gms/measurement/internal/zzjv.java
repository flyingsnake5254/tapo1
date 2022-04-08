package com.google.android.gms.measurement.internal;

import android.os.Handler;
import androidx.annotation.WorkerThread;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
public final class zzjv {
    final /* synthetic */ zzjz zza;
    private zzju zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjv(zzjz zzjzVar) {
        this.zza = zzjzVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void zza() {
        Handler handler;
        this.zza.zzg();
        if (this.zzb != null) {
            handler = this.zza.zzd;
            handler.removeCallbacks(this.zzb);
        }
        if (this.zza.zzs.zzc().zzn(null, zzea.zzar)) {
            this.zza.zzs.zzd().zzl.zzb(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void zzb(long j) {
        Handler handler;
        this.zzb = new zzju(this, this.zza.zzs.zzay().currentTimeMillis(), j);
        handler = this.zza.zzd;
        handler.postDelayed(this.zzb, 2000L);
    }
}

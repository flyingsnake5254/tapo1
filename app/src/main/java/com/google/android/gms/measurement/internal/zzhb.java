package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
final class zzhb implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzhw zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhb(zzhw zzhwVar, long j) {
        this.zzb = zzhwVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzs.zzd().zzf.zzb(this.zza);
        this.zzb.zzs.zzau().zzj().zzb("Session timeout duration set", Long.valueOf(this.zza));
    }
}

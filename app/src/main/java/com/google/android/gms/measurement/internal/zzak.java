package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
public final class zzak implements Runnable {
    final /* synthetic */ zzgp zza;
    final /* synthetic */ zzal zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzak(zzal zzalVar, zzgp zzgpVar) {
        this.zzb = zzalVar;
        this.zza = zzgpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzat();
        if (zzz.zza()) {
            this.zza.zzav().zzh(this);
            return;
        }
        boolean zzc = this.zzb.zzc();
        this.zzb.zzd = 0L;
        if (zzc) {
            this.zzb.zza();
        }
    }
}

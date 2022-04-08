package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
public final class zzft implements Runnable {
    final /* synthetic */ zzgw zza;
    final /* synthetic */ zzfu zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzft(zzfu zzfuVar, zzgw zzgwVar) {
        this.zzb = zzfuVar;
        this.zza = zzgwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfu.zzO(this.zzb, this.zza);
        this.zzb.zza(this.zza.zzg);
    }
}

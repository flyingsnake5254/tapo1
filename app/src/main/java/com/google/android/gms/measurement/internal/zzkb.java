package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
/* loaded from: classes.dex */
public final class zzkb extends zzal {
    final /* synthetic */ zzkc zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzkb(zzkc zzkcVar, zzgp zzgpVar) {
        super(zzgpVar);
        this.zza = zzkcVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzal
    public final void zza() {
        this.zza.zzd();
        this.zza.zzs.zzau().zzk().zza("Starting upload from DelayedRunnable");
        this.zza.zzf.zzB();
    }
}

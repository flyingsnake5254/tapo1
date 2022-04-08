package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
public final class zziu extends zzal {
    final /* synthetic */ zzjk zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zziu(zzjk zzjkVar, zzgp zzgpVar) {
        super(zzgpVar);
        this.zza = zzjkVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzal
    public final void zza() {
        zzjk zzjkVar = this.zza;
        zzjkVar.zzg();
        if (zzjkVar.zzh()) {
            zzjkVar.zzs.zzau().zzk().zza("Inactivity, disconnecting from the service");
            zzjkVar.zzF();
        }
    }
}

package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
/* loaded from: classes.dex */
final class zzfw implements Runnable {
    final /* synthetic */ zzaa zza;
    final /* synthetic */ zzp zzb;
    final /* synthetic */ zzgm zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfw(zzgm zzgmVar, zzaa zzaaVar, zzp zzpVar) {
        this.zzc = zzgmVar;
        this.zza = zzaaVar;
        this.zzb = zzpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkn zzknVar;
        zzkn zzknVar2;
        zzkn zzknVar3;
        zzknVar = this.zzc.zza;
        zzknVar.zzG();
        if (this.zza.zzc.zza() == null) {
            zzknVar3 = this.zzc.zza;
            zzknVar3.zzS(this.zza, this.zzb);
            return;
        }
        zzknVar2 = this.zzc.zza;
        zzknVar2.zzQ(this.zza, this.zzb);
    }
}

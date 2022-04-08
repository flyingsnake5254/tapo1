package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
/* loaded from: classes.dex */
final class zzge implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ zzgm zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzge(zzgm zzgmVar, zzp zzpVar) {
        this.zzb = zzgmVar;
        this.zza = zzpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkn zzknVar;
        zzkn zzknVar2;
        zzknVar = this.zzb.zza;
        zzknVar.zzG();
        zzknVar2 = this.zzb.zza;
        zzp zzpVar = this.zza;
        zzknVar2.zzav().zzg();
        zzknVar2.zzr();
        Preconditions.checkNotEmpty(zzpVar.zza);
        zzaf zzc = zzaf.zzc(zzpVar.zzv);
        zzaf zzt = zzknVar2.zzt(zzpVar.zza);
        zzknVar2.zzau().zzk().zzc("Setting consent, package, consent", zzpVar.zza, zzc);
        zzknVar2.zzs(zzpVar.zza, zzc);
        if (zzc.zzi(zzt)) {
            zzknVar2.zzI(zzpVar);
        }
    }
}

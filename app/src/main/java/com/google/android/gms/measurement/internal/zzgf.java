package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzpt;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
/* loaded from: classes.dex */
final class zzgf implements Runnable {
    final /* synthetic */ zzas zza;
    final /* synthetic */ zzp zzb;
    final /* synthetic */ zzgm zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgf(zzgm zzgmVar, zzas zzasVar, zzp zzpVar) {
        this.zzc = zzgmVar;
        this.zza = zzasVar;
        this.zzb = zzpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkn zzknVar;
        zzas zzc = this.zzc.zzc(this.zza, this.zzb);
        zzpt.zzb();
        zzknVar = this.zzc.zza;
        if (zzknVar.zzd().zzn(null, zzea.zzaD)) {
            this.zzc.zzb(zzc, this.zzb);
        } else {
            this.zzc.zzz(zzc, this.zzb);
        }
    }
}

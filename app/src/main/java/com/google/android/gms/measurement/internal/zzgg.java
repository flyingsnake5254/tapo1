package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
/* loaded from: classes.dex */
final class zzgg implements Runnable {
    final /* synthetic */ zzas zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzgm zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgg(zzgm zzgmVar, zzas zzasVar, String str) {
        this.zzc = zzgmVar;
        this.zza = zzasVar;
        this.zzb = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkn zzknVar;
        zzkn zzknVar2;
        zzknVar = this.zzc.zza;
        zzknVar.zzG();
        zzknVar2 = this.zzc.zza;
        zzknVar2.zzv(this.zza, this.zzb);
    }
}

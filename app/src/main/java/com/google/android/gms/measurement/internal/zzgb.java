package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
/* loaded from: classes.dex */
final class zzgb implements Callable<List<zzaa>> {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzgm zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgb(zzgm zzgmVar, String str, String str2, String str3) {
        this.zzd = zzgmVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ List<zzaa> call() throws Exception {
        zzkn zzknVar;
        zzkn zzknVar2;
        zzknVar = this.zzd.zza;
        zzknVar.zzG();
        zzknVar2 = this.zzd.zza;
        return zzknVar2.zzi().zzq(this.zza, this.zzb, this.zzc);
    }
}

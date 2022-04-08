package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
/* loaded from: classes.dex */
public final class zzba implements Comparator<zzap> {
    final /* synthetic */ zzai zza;
    final /* synthetic */ zzg zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzba(zzai zzaiVar, zzg zzgVar) {
        this.zza = zzaiVar;
        this.zzb = zzgVar;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(zzap zzapVar, zzap zzapVar2) {
        zzap zzapVar3 = zzapVar;
        zzap zzapVar4 = zzapVar2;
        zzai zzaiVar = this.zza;
        zzg zzgVar = this.zzb;
        if (zzapVar3 instanceof zzau) {
            return !(zzapVar4 instanceof zzau) ? 1 : 0;
        }
        if (zzapVar4 instanceof zzau) {
            return -1;
        }
        if (zzaiVar == null) {
            return zzapVar3.zzc().compareTo(zzapVar4.zzc());
        }
        return (int) zzh.zzi(zzaiVar.zza(zzgVar, Arrays.asList(zzapVar3, zzapVar4)).zzd().doubleValue());
    }
}

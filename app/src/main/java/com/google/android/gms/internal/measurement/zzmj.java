package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@19.0.0 */
/* loaded from: classes.dex */
final class zzmj extends zzmh<zzmi, zzmi> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzmh
    public final /* bridge */ /* synthetic */ void zza(zzmi zzmiVar, int i, long j) {
        zzmiVar.zzh(i << 3, Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzmh
    public final /* bridge */ /* synthetic */ zzmi zzb() {
        return zzmi.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzmh
    public final /* bridge */ /* synthetic */ void zzc(Object obj, zzmi zzmiVar) {
        ((zzkd) obj).zzc = zzmiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzmh
    public final /* bridge */ /* synthetic */ zzmi zzd(Object obj) {
        return ((zzkd) obj).zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzmh
    public final void zze(Object obj) {
        ((zzkd) obj).zzc.zzd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzmh
    public final /* bridge */ /* synthetic */ zzmi zzf(zzmi zzmiVar, zzmi zzmiVar2) {
        zzmi zzmiVar3 = zzmiVar2;
        return zzmiVar3.equals(zzmi.zza()) ? zzmiVar : zzmi.zzc(zzmiVar, zzmiVar3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzmh
    public final /* bridge */ /* synthetic */ int zzg(zzmi zzmiVar) {
        return zzmiVar.zze();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzmh
    public final /* bridge */ /* synthetic */ int zzh(zzmi zzmiVar) {
        return zzmiVar.zzf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzmh
    public final /* bridge */ /* synthetic */ void zzi(zzmi zzmiVar, zzjl zzjlVar) throws IOException {
        zzmiVar.zzi(zzjlVar);
    }
}

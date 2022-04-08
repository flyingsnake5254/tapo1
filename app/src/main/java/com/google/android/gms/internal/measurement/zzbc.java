package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
/* loaded from: classes.dex */
public final class zzbc extends zzaw {
    /* JADX INFO: Access modifiers changed from: protected */
    public zzbc() {
        this.zza.add(zzbl.AND);
        this.zza.add(zzbl.NOT);
        this.zza.add(zzbl.OR);
    }

    @Override // com.google.android.gms.internal.measurement.zzaw
    public final zzap zza(String str, zzg zzgVar, List<zzap> list) {
        zzbl zzblVar = zzbl.ADD;
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal == 1) {
            zzh.zza(zzbl.AND.name(), 2, list);
            zzap zza = zzgVar.zza(list.get(0));
            return !zza.zze().booleanValue() ? zza : zzgVar.zza(list.get(1));
        } else if (ordinal == 47) {
            zzh.zza(zzbl.NOT.name(), 1, list);
            return new zzaf(Boolean.valueOf(!zzgVar.zza(list.get(0)).zze().booleanValue()));
        } else if (ordinal != 50) {
            return super.zzb(str);
        } else {
            zzh.zza(zzbl.OR.name(), 2, list);
            zzap zza2 = zzgVar.zza(list.get(0));
            return zza2.zze().booleanValue() ? zza2 : zzgVar.zza(list.get(1));
        }
    }
}

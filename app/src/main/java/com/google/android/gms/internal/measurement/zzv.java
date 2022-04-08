package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
/* loaded from: classes.dex */
public final class zzv extends zzai {
    final Map<String, zzai> zza = new HashMap();
    private final zzj zzb;

    public zzv(zzj zzjVar) {
        super("require");
        this.zzb = zzjVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzap zza(zzg zzgVar, List<zzap> list) {
        zzap zzapVar;
        zzh.zza("require", 1, list);
        String zzc = zzgVar.zza(list.get(0)).zzc();
        if (this.zza.containsKey(zzc)) {
            return this.zza.get(zzc);
        }
        zzj zzjVar = this.zzb;
        if (zzjVar.zza.containsKey(zzc)) {
            try {
                zzapVar = (zzap) zzjVar.zza.get(zzc).call();
            } catch (Exception unused) {
                String valueOf = String.valueOf(zzc);
                throw new IllegalStateException(valueOf.length() != 0 ? "Failed to create API implementation: ".concat(valueOf) : new String("Failed to create API implementation: "));
            }
        } else {
            zzapVar = zzap.zzf;
        }
        if (zzapVar instanceof zzai) {
            this.zza.put(zzc, (zzai) zzapVar);
        }
        return zzapVar;
    }
}

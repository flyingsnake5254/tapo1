package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
/* loaded from: classes.dex */
public final class zzax {
    final Map<String, zzaw> zza = new HashMap();
    final zzbj zzb = new zzbj();

    public zzax() {
        zza(new zzav());
        zza(new zzay());
        zza(new zzaz());
        zza(new zzbc());
        zza(new zzbh());
        zza(new zzbi());
        zza(new zzbk());
    }

    final void zza(zzaw zzawVar) {
        for (zzbl zzblVar : zzawVar.zza) {
            this.zza.put(zzblVar.zzb().toString(), zzawVar);
        }
    }

    public final zzap zzb(zzg zzgVar, zzap zzapVar) {
        zzaw zzawVar;
        zzh.zzk(zzgVar);
        if (!(zzapVar instanceof zzaq)) {
            return zzapVar;
        }
        zzaq zzaqVar = (zzaq) zzapVar;
        ArrayList<zzap> zzg = zzaqVar.zzg();
        String zzb = zzaqVar.zzb();
        if (this.zza.containsKey(zzb)) {
            zzawVar = this.zza.get(zzb);
        } else {
            zzawVar = this.zzb;
        }
        return zzawVar.zza(zzb, zzgVar, zzg);
    }
}

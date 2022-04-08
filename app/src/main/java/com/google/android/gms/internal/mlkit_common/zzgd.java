package com.google.android.gms.internal.mlkit_common;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes.dex */
final class zzgd implements zzge {
    @Override // com.google.android.gms.internal.mlkit_common.zzge
    public final zzgc<?, ?> zza(Object obj) {
        zzfz zzfzVar = (zzfz) obj;
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzge
    public final Map<?, ?> zzb(Object obj) {
        return (zzgb) obj;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzge
    public final Object zzc(Object obj) {
        ((zzgb) obj).zzb();
        return obj;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzge
    public final Object zza(Object obj, Object obj2) {
        zzgb zzgbVar = (zzgb) obj;
        zzgb zzgbVar2 = (zzgb) obj2;
        if (!zzgbVar2.isEmpty()) {
            if (!zzgbVar.zzc()) {
                zzgbVar = zzgbVar.zza();
            }
            zzgbVar.zza(zzgbVar2);
        }
        return zzgbVar;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzge
    public final int zza(int i, Object obj, Object obj2) {
        zzgb zzgbVar = (zzgb) obj;
        zzfz zzfzVar = (zzfz) obj2;
        if (zzgbVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzgbVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}

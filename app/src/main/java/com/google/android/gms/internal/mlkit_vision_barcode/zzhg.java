package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
final class zzhg implements zzhh {
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzhh
    public final zzhf<?, ?> zza(Object obj) {
        zzhc zzhcVar = (zzhc) obj;
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzhh
    public final Map<?, ?> zzb(Object obj) {
        return (zzhe) obj;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzhh
    public final Object zzc(Object obj) {
        ((zzhe) obj).zzb();
        return obj;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzhh
    public final Object zza(Object obj, Object obj2) {
        zzhe zzheVar = (zzhe) obj;
        zzhe zzheVar2 = (zzhe) obj2;
        if (!zzheVar2.isEmpty()) {
            if (!zzheVar.zzc()) {
                zzheVar = zzheVar.zza();
            }
            zzheVar.zza(zzheVar2);
        }
        return zzheVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzhh
    public final int zza(int i, Object obj, Object obj2) {
        zzhe zzheVar = (zzhe) obj;
        zzhc zzhcVar = (zzhc) obj2;
        if (zzheVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzheVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}

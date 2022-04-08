package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
final class zzid implements zzia {
    @Override // com.google.android.gms.internal.vision.zzia
    public final int zzb(int i, Object obj, Object obj2) {
        zzib zzibVar = (zzib) obj;
        zzhz zzhzVar = (zzhz) obj2;
        if (zzibVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzibVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.vision.zzia
    public final Object zzc(Object obj, Object obj2) {
        zzib zzibVar = (zzib) obj;
        zzib zzibVar2 = (zzib) obj2;
        if (!zzibVar2.isEmpty()) {
            if (!zzibVar.isMutable()) {
                zzibVar = zzibVar.zzhe();
            }
            zzibVar.zza(zzibVar2);
        }
        return zzibVar;
    }

    @Override // com.google.android.gms.internal.vision.zzia
    public final Map<?, ?> zzl(Object obj) {
        return (zzib) obj;
    }

    @Override // com.google.android.gms.internal.vision.zzia
    public final Map<?, ?> zzm(Object obj) {
        return (zzib) obj;
    }

    @Override // com.google.android.gms.internal.vision.zzia
    public final boolean zzn(Object obj) {
        return !((zzib) obj).isMutable();
    }

    @Override // com.google.android.gms.internal.vision.zzia
    public final Object zzo(Object obj) {
        ((zzib) obj).zzdq();
        return obj;
    }

    @Override // com.google.android.gms.internal.vision.zzia
    public final Object zzp(Object obj) {
        return zzib.zzhd().zzhe();
    }

    @Override // com.google.android.gms.internal.vision.zzia
    public final zzhy<?, ?> zzq(Object obj) {
        zzhz zzhzVar = (zzhz) obj;
        throw new NoSuchMethodError();
    }
}

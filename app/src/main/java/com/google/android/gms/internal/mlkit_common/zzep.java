package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzez;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes.dex */
final class zzep extends zzeq<zzez.zzd> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_common.zzeq
    public final boolean zza(zzgh zzghVar) {
        return zzghVar instanceof zzez.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_common.zzeq
    public final zzer<zzez.zzd> zzb(Object obj) {
        zzez.zze zzeVar = (zzez.zze) obj;
        if (zzeVar.zzc.zzc()) {
            zzeVar.zzc = (zzer) zzeVar.zzc.clone();
        }
        return zzeVar.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_common.zzeq
    public final void zzc(Object obj) {
        zza(obj).zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_common.zzeq
    public final zzer<zzez.zzd> zza(Object obj) {
        return ((zzez.zze) obj).zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_common.zzeq
    public final int zza(Map.Entry<?, ?> entry) {
        zzez.zzd zzdVar = (zzez.zzd) entry.getKey();
        throw new NoSuchMethodError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_common.zzeq
    public final void zza(zzik zzikVar, Map.Entry<?, ?> entry) throws IOException {
        zzez.zzd zzdVar = (zzez.zzd) entry.getKey();
        throw new NoSuchMethodError();
    }
}

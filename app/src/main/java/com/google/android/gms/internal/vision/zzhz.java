package com.google.android.gms.internal.vision;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
public final class zzhz<K, V> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void zza(zzgf zzgfVar, zzhy<K, V> zzhyVar, K k, V v) throws IOException {
        zzgn.zza(zzgfVar, zzhyVar.zzzb, 1, k);
        zzgn.zza(zzgfVar, zzhyVar.zzzd, 2, v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> int zza(zzhy<K, V> zzhyVar, K k, V v) {
        return zzgn.zza(zzhyVar.zzzb, 1, k) + zzgn.zza(zzhyVar.zzzd, 2, v);
    }
}

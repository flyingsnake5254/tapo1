package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
final class zzgz extends zzgu {
    private zzgz() {
        super();
    }

    private static <E> zzgl<E> zzb(Object obj, long j) {
        return (zzgl) zziz.zzf(obj, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgu
    final void zza(Object obj, long j) {
        zzb(obj, j).zzb();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgu
    final <E> void zza(Object obj, Object obj2, long j) {
        zzgl<E> zzb = zzb(obj, j);
        zzgl<E> zzb2 = zzb(obj2, j);
        int size = zzb.size();
        int size2 = zzb2.size();
        zzb2 = zzb;
        zzb2 = zzb;
        if (size > 0 && size2 > 0) {
            boolean zza = zzb.zza();
            zzgl<E> zzglVar = zzb;
            if (!zza) {
                zzglVar = zzb.zza(size2 + size);
            }
            zzglVar.addAll(zzb2);
            zzb2 = zzglVar;
        }
        if (size > 0) {
        }
        zziz.zza(obj, j, zzb2);
    }
}

package com.google.android.gms.internal.vision;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
final class zzhs extends zzhr {
    private zzhs() {
        super();
    }

    private static <E> zzhe<E> zzc(Object obj, long j) {
        return (zzhe) zzju.zzp(obj, j);
    }

    @Override // com.google.android.gms.internal.vision.zzhr
    final <L> List<L> zza(Object obj, long j) {
        zzhe zzc = zzc(obj, j);
        if (zzc.zzdp()) {
            return zzc;
        }
        int size = zzc.size();
        zzhe zzah = zzc.zzah(size == 0 ? 10 : size << 1);
        zzju.zza(obj, j, zzah);
        return zzah;
    }

    @Override // com.google.android.gms.internal.vision.zzhr
    final void zzb(Object obj, long j) {
        zzc(obj, j).zzdq();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    @Override // com.google.android.gms.internal.vision.zzhr
    final <E> void zza(Object obj, Object obj2, long j) {
        zzhe<E> zzc = zzc(obj, j);
        zzhe<E> zzc2 = zzc(obj2, j);
        int size = zzc.size();
        int size2 = zzc2.size();
        zzc2 = zzc;
        zzc2 = zzc;
        if (size > 0 && size2 > 0) {
            boolean zzdp = zzc.zzdp();
            zzhe<E> zzheVar = zzc;
            if (!zzdp) {
                zzheVar = zzc.zzah(size2 + size);
            }
            zzheVar.addAll(zzc2);
            zzc2 = zzheVar;
        }
        if (size > 0) {
        }
        zzju.zza(obj, j, zzc2);
    }
}

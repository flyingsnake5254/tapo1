package com.google.android.gms.internal.vision;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
final class zzfo implements Comparator<zzfm> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzfm zzfmVar, zzfm zzfmVar2) {
        int zza;
        int zza2;
        zzfm zzfmVar3 = zzfmVar;
        zzfm zzfmVar4 = zzfmVar2;
        zzfv zzfvVar = (zzfv) zzfmVar3.iterator();
        zzfv zzfvVar2 = (zzfv) zzfmVar4.iterator();
        while (zzfvVar.hasNext() && zzfvVar2.hasNext()) {
            zza = zzfm.zza(zzfvVar.nextByte());
            zza2 = zzfm.zza(zzfvVar2.nextByte());
            int compare = Integer.compare(zza, zza2);
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzfmVar3.size(), zzfmVar4.size());
    }
}

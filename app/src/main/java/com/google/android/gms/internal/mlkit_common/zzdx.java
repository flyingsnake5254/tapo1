package com.google.android.gms.internal.mlkit_common;

import java.util.Comparator;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes.dex */
final class zzdx implements Comparator<zzdv> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzdv zzdvVar, zzdv zzdvVar2) {
        int zzb;
        int zzb2;
        zzdv zzdvVar3 = zzdvVar;
        zzdv zzdvVar4 = zzdvVar2;
        zzee zzeeVar = (zzee) zzdvVar3.iterator();
        zzee zzeeVar2 = (zzee) zzdvVar4.iterator();
        while (zzeeVar.hasNext() && zzeeVar2.hasNext()) {
            zzb = zzdv.zzb(zzeeVar.zza());
            zzb2 = zzdv.zzb(zzeeVar2.zza());
            int compare = Integer.compare(zzb, zzb2);
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzdvVar3.zza(), zzdvVar4.zza());
    }
}

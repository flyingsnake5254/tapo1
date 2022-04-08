package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.internal.mlkit_vision_barcode.zzbl;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
public final class zzem {
    public static zzbl.zzae zza(int i, int i2) {
        zzbl.zzae.zzb zzbVar;
        zzbl.zzae.zza zza = zzbl.zzae.zza();
        if (i == -1) {
            zzbVar = zzbl.zzae.zzb.BITMAP;
        } else if (i == 35) {
            zzbVar = zzbl.zzae.zzb.YUV_420_888;
        } else if (i == 842094169) {
            zzbVar = zzbl.zzae.zzb.YV12;
        } else if (i == 16) {
            zzbVar = zzbl.zzae.zzb.NV16;
        } else if (i != 17) {
            zzbVar = zzbl.zzae.zzb.UNKNOWN_FORMAT;
        } else {
            zzbVar = zzbl.zzae.zzb.NV21;
        }
        return (zzbl.zzae) ((zzga) zza.zza(zzbVar).zza(i2).zzg());
    }
}

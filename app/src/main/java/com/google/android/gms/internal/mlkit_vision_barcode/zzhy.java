package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.internal.mlkit_vision_barcode.zzga;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
public final class zzhy implements zzhi {
    private final zzhk zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhy(zzhk zzhkVar, String str, Object[] objArr) {
        this.zza = zzhkVar;
        this.zzb = str;
        this.zzc = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.zzd = charAt;
            return;
        }
        int i = charAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            i3++;
            char charAt2 = str.charAt(i3);
            if (charAt2 >= 55296) {
                i |= (charAt2 & 8191) << i2;
                i2 += 13;
            } else {
                this.zzd = i | (charAt2 << i2);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzhi
    public final int zza() {
        return (this.zzd & 1) == 1 ? zzga.zze.zzh : zzga.zze.zzi;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzhi
    public final boolean zzb() {
        return (this.zzd & 2) == 2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzhi
    public final zzhk zzc() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzd() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object[] zze() {
        return this.zzc;
    }
}

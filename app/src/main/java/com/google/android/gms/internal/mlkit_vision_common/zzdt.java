package com.google.android.gms.internal.mlkit_vision_common;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes.dex */
public class zzdt extends zzdq {
    protected final byte[] zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdt(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdj
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdj) || zza() != ((zzdj) obj).zza()) {
            return false;
        }
        if (zza() == 0) {
            return true;
        }
        if (!(obj instanceof zzdt)) {
            return obj.equals(this);
        }
        zzdt zzdtVar = (zzdt) obj;
        int zzd = zzd();
        int zzd2 = zzdtVar.zzd();
        if (zzd == 0 || zzd2 == 0 || zzd == zzd2) {
            return zza(zzdtVar, 0, zza());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdj
    public byte zza(int i) {
        return this.zzb[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdj
    public byte zzb(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdj
    public final boolean zzc() {
        int zze = zze();
        return zzhj.zza(this.zzb, zze, zza() + zze);
    }

    protected int zze() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdj
    public int zza() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdj
    public final zzdj zza(int i, int i2) {
        int zzb = zzdj.zzb(0, i2, zza());
        if (zzb == 0) {
            return zzdj.zza;
        }
        return new zzdm(this.zzb, zze(), zzb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdj
    public final void zza(zzdg zzdgVar) throws IOException {
        zzdgVar.zza(this.zzb, zze(), zza());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdj
    protected final String zza(Charset charset) {
        return new String(this.zzb, zze(), zza(), charset);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdq
    final boolean zza(zzdj zzdjVar, int i, int i2) {
        if (i2 > zzdjVar.zza()) {
            int zza = zza();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(zza);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzdjVar.zza()) {
            int zza2 = zzdjVar.zza();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(zza2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!(zzdjVar instanceof zzdt)) {
            return zzdjVar.zza(0, i2).equals(zza(0, i2));
        } else {
            zzdt zzdtVar = (zzdt) zzdjVar;
            byte[] bArr = this.zzb;
            byte[] bArr2 = zzdtVar.zzb;
            int zze = zze() + i2;
            int zze2 = zze();
            int zze3 = zzdtVar.zze();
            while (zze2 < zze) {
                if (bArr[zze2] != bArr2[zze3]) {
                    return false;
                }
                zze2++;
                zze3++;
            }
            return true;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzdj
    protected final int zza(int i, int i2, int i3) {
        return zzem.zza(i, this.zzb, zze(), i3);
    }
}

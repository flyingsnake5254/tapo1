package com.google.android.gms.internal.mlkit_common;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes.dex */
public class zzef extends zzeg {
    protected final byte[] zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzef(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzdv
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdv) || zza() != ((zzdv) obj).zza()) {
            return false;
        }
        if (zza() == 0) {
            return true;
        }
        if (!(obj instanceof zzef)) {
            return obj.equals(this);
        }
        zzef zzefVar = (zzef) obj;
        int zzd = zzd();
        int zzd2 = zzefVar.zzd();
        if (zzd == 0 || zzd2 == 0 || zzd == zzd2) {
            return zza(zzefVar, 0, zza());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzdv
    public byte zza(int i) {
        return this.zzb[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_common.zzdv
    public byte zzb(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzdv
    public final boolean zzc() {
        int zze = zze();
        return zzhy.zza(this.zzb, zze, zza() + zze);
    }

    protected int zze() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzdv
    public int zza() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzdv
    public final zzdv zza(int i, int i2) {
        int zzb = zzdv.zzb(0, i2, zza());
        if (zzb == 0) {
            return zzdv.zza;
        }
        return new zzec(this.zzb, zze(), zzb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_common.zzdv
    public final void zza(zzdw zzdwVar) throws IOException {
        zzdwVar.zza(this.zzb, zze(), zza());
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzdv
    protected final String zza(Charset charset) {
        return new String(this.zzb, zze(), zza(), charset);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzeg
    final boolean zza(zzdv zzdvVar, int i, int i2) {
        if (i2 > zzdvVar.zza()) {
            int zza = zza();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(zza);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzdvVar.zza()) {
            int zza2 = zzdvVar.zza();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(zza2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!(zzdvVar instanceof zzef)) {
            return zzdvVar.zza(0, i2).equals(zza(0, i2));
        } else {
            zzef zzefVar = (zzef) zzdvVar;
            byte[] bArr = this.zzb;
            byte[] bArr2 = zzefVar.zzb;
            int zze = zze() + i2;
            int zze2 = zze();
            int zze3 = zzefVar.zze();
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

    @Override // com.google.android.gms.internal.mlkit_common.zzdv
    protected final int zza(int i, int i2, int i3) {
        return zzfc.zza(i, this.zzb, zze(), i3);
    }
}

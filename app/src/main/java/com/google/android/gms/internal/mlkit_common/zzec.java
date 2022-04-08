package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes.dex */
final class zzec extends zzef {
    private final int zzc;
    private final int zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzec(byte[] bArr, int i, int i2) {
        super(bArr);
        zzdv.zzb(i, i + i2, bArr.length);
        this.zzc = i;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzef, com.google.android.gms.internal.mlkit_common.zzdv
    public final byte zza(int i) {
        int zza = zza();
        if (((zza - (i + 1)) | i) >= 0) {
            return this.zzb[this.zzc + i];
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(zza);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_common.zzef, com.google.android.gms.internal.mlkit_common.zzdv
    public final byte zzb(int i) {
        return this.zzb[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzef
    protected final int zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzef, com.google.android.gms.internal.mlkit_common.zzdv
    public final int zza() {
        return this.zzd;
    }
}

package com.google.android.gms.internal.mlkit_vision_barcode;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
public final class zzfk extends zzfi {
    private final byte[] zza;
    private final boolean zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;

    private zzfk(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzg = Integer.MAX_VALUE;
        this.zza = bArr;
        this.zzc = i2 + i;
        this.zze = i;
        this.zzf = i;
        this.zzb = z;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzfi
    public final int zza(int i) throws zzgk {
        if (i >= 0) {
            int zza = i + zza();
            int i2 = this.zzg;
            if (zza <= i2) {
                this.zzg = zza;
                int i3 = this.zzc + this.zzd;
                this.zzc = i3;
                int i4 = i3 - this.zzf;
                if (i4 > zza) {
                    int i5 = i4 - zza;
                    this.zzd = i5;
                    this.zzc = i3 - i5;
                } else {
                    this.zzd = 0;
                }
                return i2;
            }
            throw new zzgk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new zzgk("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzfi
    public final int zza() {
        return this.zze - this.zzf;
    }
}

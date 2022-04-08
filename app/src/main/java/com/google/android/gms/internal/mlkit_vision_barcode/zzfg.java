package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
public class zzfg extends zzfh {
    protected final byte[] zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfg(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzew
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzew) || zza() != ((zzew) obj).zza()) {
            return false;
        }
        if (zza() == 0) {
            return true;
        }
        if (!(obj instanceof zzfg)) {
            return obj.equals(this);
        }
        zzfg zzfgVar = (zzfg) obj;
        int zzd = zzd();
        int zzd2 = zzfgVar.zzd();
        if (zzd == 0 || zzd2 == 0 || zzd == zzd2) {
            return zza(zzfgVar, 0, zza());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzew
    public byte zza(int i) {
        return this.zzb[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzew
    public byte zzb(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzew
    public final boolean zzc() {
        int zze = zze();
        return zzjb.zza(this.zzb, zze, zza() + zze);
    }

    protected int zze() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzew
    public int zza() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzew
    public final zzew zza(int i, int i2) {
        int zzb = zzew.zzb(0, i2, zza());
        if (zzb == 0) {
            return zzew.zza;
        }
        return new zzfd(this.zzb, zze(), zzb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzew
    public final void zza(zzex zzexVar) throws IOException {
        zzexVar.zza(this.zzb, zze(), zza());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzew
    protected final String zza(Charset charset) {
        return new String(this.zzb, zze(), zza(), charset);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzfh
    final boolean zza(zzew zzewVar, int i, int i2) {
        if (i2 > zzewVar.zza()) {
            int zza = zza();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(zza);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzewVar.zza()) {
            int zza2 = zzewVar.zza();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(zza2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!(zzewVar instanceof zzfg)) {
            return zzewVar.zza(0, i2).equals(zza(0, i2));
        } else {
            zzfg zzfgVar = (zzfg) zzewVar;
            byte[] bArr = this.zzb;
            byte[] bArr2 = zzfgVar.zzb;
            int zze = zze() + i2;
            int zze2 = zze();
            int zze3 = zzfgVar.zze();
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

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzew
    protected final int zza(int i, int i2, int i3) {
        return zzgc.zza(i, this.zzb, zze(), i3);
    }
}

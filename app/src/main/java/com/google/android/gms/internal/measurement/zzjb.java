package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@19.0.0 */
/* loaded from: classes.dex */
public class zzjb extends zzja {
    protected final byte[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjb(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzjd
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzjd) || zzc() != ((zzjd) obj).zzc()) {
            return false;
        }
        if (zzc() == 0) {
            return true;
        }
        if (!(obj instanceof zzjb)) {
            return obj.equals(this);
        }
        zzjb zzjbVar = (zzjb) obj;
        int zzm = zzm();
        int zzm2 = zzjbVar.zzm();
        if (zzm != 0 && zzm2 != 0 && zzm != zzm2) {
            return false;
        }
        int zzc = zzc();
        if (zzc > zzjbVar.zzc()) {
            int zzc2 = zzc();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(zzc);
            sb.append(zzc2);
            throw new IllegalArgumentException(sb.toString());
        } else if (zzc <= zzjbVar.zzc()) {
            byte[] bArr = this.zza;
            byte[] bArr2 = zzjbVar.zza;
            zzjbVar.zzd();
            int i = 0;
            int i2 = 0;
            while (i < zzc) {
                if (bArr[i] != bArr2[i2]) {
                    return false;
                }
                i++;
                i2++;
            }
            return true;
        } else {
            int zzc3 = zzjbVar.zzc();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(zzc);
            sb2.append(", ");
            sb2.append(zzc3);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjd
    public byte zza(int i) {
        return this.zza[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzjd
    public byte zzb(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzjd
    public int zzc() {
        return this.zza.length;
    }

    protected int zzd() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzjd
    public final zzjd zze(int i, int i2) {
        int zzn = zzjd.zzn(0, i2, zzc());
        return zzn == 0 ? zzjd.zzb : new zziy(this.zza, 0, zzn);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzjd
    public final void zzf(zziu zziuVar) throws IOException {
        ((zzji) zziuVar).zzp(this.zza, 0, zzc());
    }

    @Override // com.google.android.gms.internal.measurement.zzjd
    protected final String zzg(Charset charset) {
        return new String(this.zza, 0, zzc(), charset);
    }

    @Override // com.google.android.gms.internal.measurement.zzjd
    public final boolean zzh() {
        return zzmw.zzb(this.zza, 0, zzc());
    }

    @Override // com.google.android.gms.internal.measurement.zzjd
    protected final int zzi(int i, int i2, int i3) {
        return zzkl.zzh(i, this.zza, 0, i3);
    }
}

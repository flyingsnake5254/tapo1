package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.internal.mlkit_vision_barcode.zzga;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
public final class zzis {
    private static final zzis zza = new zzis(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzis() {
        this(0, new int[8], new Object[8], true);
    }

    public static zzis zza() {
        return zza;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzis)) {
            return false;
        }
        zzis zzisVar = (zzis) obj;
        int i = this.zzb;
        if (i == zzisVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzisVar.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                } else if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                Object[] objArr = this.zzd;
                Object[] objArr2 = zzisVar.zzd;
                int i3 = this.zzb;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    } else if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final void zzb() {
        this.zzf = false;
    }

    public final int zzc() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            i2 += zzfn.zzd(this.zzc[i3] >>> 3, (zzew) this.zzd[i3]);
        }
        this.zze = i2;
        return i2;
    }

    public final int zzd() {
        int i;
        int i2 = this.zze;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzb; i4++) {
            int i5 = this.zzc[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = zzfn.zze(i6, ((Long) this.zzd[i4]).longValue());
            } else if (i7 == 1) {
                i = zzfn.zzg(i6, ((Long) this.zzd[i4]).longValue());
            } else if (i7 == 2) {
                i = zzfn.zzc(i6, (zzew) this.zzd[i4]);
            } else if (i7 == 3) {
                i = (zzfn.zze(i6) << 1) + ((zzis) this.zzd[i4]).zzd();
            } else if (i7 == 5) {
                i = zzfn.zzi(i6, ((Integer) this.zzd[i4]).intValue());
            } else {
                throw new IllegalStateException(zzgk.zza());
            }
            i3 += i;
        }
        this.zze = i3;
        return i3;
    }

    private zzis(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzis zza(zzis zzisVar, zzis zzisVar2) {
        int i = zzisVar.zzb + zzisVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzisVar.zzc, i);
        System.arraycopy(zzisVar2.zzc, 0, copyOf, zzisVar.zzb, zzisVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzisVar.zzd, i);
        System.arraycopy(zzisVar2.zzd, 0, copyOf2, zzisVar.zzb, zzisVar2.zzb);
        return new zzis(i, copyOf, copyOf2, true);
    }

    public final void zzb(zzjn zzjnVar) throws IOException {
        if (this.zzb != 0) {
            if (zzjnVar.zza() == zzga.zze.zzj) {
                for (int i = 0; i < this.zzb; i++) {
                    zza(this.zzc[i], this.zzd[i], zzjnVar);
                }
                return;
            }
            for (int i2 = this.zzb - 1; i2 >= 0; i2--) {
                zza(this.zzc[i2], this.zzd[i2], zzjnVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzjn zzjnVar) throws IOException {
        if (zzjnVar.zza() == zzga.zze.zzk) {
            for (int i = this.zzb - 1; i >= 0; i--) {
                zzjnVar.zza(this.zzc[i] >>> 3, this.zzd[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzjnVar.zza(this.zzc[i2] >>> 3, this.zzd[i2]);
        }
    }

    private static void zza(int i, Object obj, zzjn zzjnVar) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzjnVar.zza(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzjnVar.zzd(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzjnVar.zza(i2, (zzew) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzjnVar.zzd(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzgk.zza());
        } else if (zzjnVar.zza() == zzga.zze.zzj) {
            zzjnVar.zza(i2);
            ((zzis) obj).zzb(zzjnVar);
            zzjnVar.zzb(i2);
        } else {
            zzjnVar.zzb(i2);
            ((zzis) obj).zzb(zzjnVar);
            zzjnVar.zza(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzhp.zza(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }
}

package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzez;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes.dex */
public final class zzhp {
    private static final zzhp zza = new zzhp(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzhp() {
        this(0, new int[8], new Object[8], true);
    }

    public static zzhp zza() {
        return zza;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzhp)) {
            return false;
        }
        zzhp zzhpVar = (zzhp) obj;
        int i = this.zzb;
        if (i == zzhpVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzhpVar.zzc;
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
                Object[] objArr2 = zzhpVar.zzd;
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
            i2 += zzem.zzd(this.zzc[i3] >>> 3, (zzdv) this.zzd[i3]);
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
                i = zzem.zze(i6, ((Long) this.zzd[i4]).longValue());
            } else if (i7 == 1) {
                i = zzem.zzg(i6, ((Long) this.zzd[i4]).longValue());
            } else if (i7 == 2) {
                i = zzem.zzc(i6, (zzdv) this.zzd[i4]);
            } else if (i7 == 3) {
                i = (zzem.zze(i6) << 1) + ((zzhp) this.zzd[i4]).zzd();
            } else if (i7 == 5) {
                i = zzem.zzi(i6, ((Integer) this.zzd[i4]).intValue());
            } else {
                throw new IllegalStateException(zzfh.zza());
            }
            i3 += i;
        }
        this.zze = i3;
        return i3;
    }

    private zzhp(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhp zza(zzhp zzhpVar, zzhp zzhpVar2) {
        int i = zzhpVar.zzb + zzhpVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzhpVar.zzc, i);
        System.arraycopy(zzhpVar2.zzc, 0, copyOf, zzhpVar.zzb, zzhpVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzhpVar.zzd, i);
        System.arraycopy(zzhpVar2.zzd, 0, copyOf2, zzhpVar.zzb, zzhpVar2.zzb);
        return new zzhp(i, copyOf, copyOf2, true);
    }

    public final void zzb(zzik zzikVar) throws IOException {
        if (this.zzb != 0) {
            if (zzikVar.zza() == zzez.zzf.zzj) {
                for (int i = 0; i < this.zzb; i++) {
                    zza(this.zzc[i], this.zzd[i], zzikVar);
                }
                return;
            }
            for (int i2 = this.zzb - 1; i2 >= 0; i2--) {
                zza(this.zzc[i2], this.zzd[i2], zzikVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzik zzikVar) throws IOException {
        if (zzikVar.zza() == zzez.zzf.zzk) {
            for (int i = this.zzb - 1; i >= 0; i--) {
                zzikVar.zza(this.zzc[i] >>> 3, this.zzd[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzikVar.zza(this.zzc[i2] >>> 3, this.zzd[i2]);
        }
    }

    private static void zza(int i, Object obj, zzik zzikVar) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzikVar.zza(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzikVar.zzd(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzikVar.zza(i2, (zzdv) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzikVar.zzd(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzfh.zza());
        } else if (zzikVar.zza() == zzez.zzf.zzj) {
            zzikVar.zza(i2);
            ((zzhp) obj).zzb(zzikVar);
            zzikVar.zzb(i2);
        } else {
            zzikVar.zzb(i2);
            ((zzhp) obj).zzb(zzikVar);
            zzikVar.zza(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzgm.zza(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }
}

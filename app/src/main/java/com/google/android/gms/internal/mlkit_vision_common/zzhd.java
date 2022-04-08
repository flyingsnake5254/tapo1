package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzek;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes.dex */
public final class zzhd {
    private static final zzhd zza = new zzhd(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzhd() {
        this(0, new int[8], new Object[8], true);
    }

    public static zzhd zza() {
        return zza;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzhd)) {
            return false;
        }
        zzhd zzhdVar = (zzhd) obj;
        int i = this.zzb;
        if (i == zzhdVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzhdVar.zzc;
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
                Object[] objArr2 = zzhdVar.zzd;
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
            i2 += zzdw.zzd(this.zzc[i3] >>> 3, (zzdj) this.zzd[i3]);
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
                i = zzdw.zze(i6, ((Long) this.zzd[i4]).longValue());
            } else if (i7 == 1) {
                i = zzdw.zzg(i6, ((Long) this.zzd[i4]).longValue());
            } else if (i7 == 2) {
                i = zzdw.zzc(i6, (zzdj) this.zzd[i4]);
            } else if (i7 == 3) {
                i = (zzdw.zze(i6) << 1) + ((zzhd) this.zzd[i4]).zzd();
            } else if (i7 == 5) {
                i = zzdw.zzi(i6, ((Integer) this.zzd[i4]).intValue());
            } else {
                throw new IllegalStateException(zzev.zza());
            }
            i3 += i;
        }
        this.zze = i3;
        return i3;
    }

    private zzhd(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhd zza(zzhd zzhdVar, zzhd zzhdVar2) {
        int i = zzhdVar.zzb + zzhdVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzhdVar.zzc, i);
        System.arraycopy(zzhdVar2.zzc, 0, copyOf, zzhdVar.zzb, zzhdVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzhdVar.zzd, i);
        System.arraycopy(zzhdVar2.zzd, 0, copyOf2, zzhdVar.zzb, zzhdVar2.zzb);
        return new zzhd(i, copyOf, copyOf2, true);
    }

    public final void zzb(zzhu zzhuVar) throws IOException {
        if (this.zzb != 0) {
            if (zzhuVar.zza() == zzek.zze.zzj) {
                for (int i = 0; i < this.zzb; i++) {
                    zza(this.zzc[i], this.zzd[i], zzhuVar);
                }
                return;
            }
            for (int i2 = this.zzb - 1; i2 >= 0; i2--) {
                zza(this.zzc[i2], this.zzd[i2], zzhuVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzhu zzhuVar) throws IOException {
        if (zzhuVar.zza() == zzek.zze.zzk) {
            for (int i = this.zzb - 1; i >= 0; i--) {
                zzhuVar.zza(this.zzc[i] >>> 3, this.zzd[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzhuVar.zza(this.zzc[i2] >>> 3, this.zzd[i2]);
        }
    }

    private static void zza(int i, Object obj, zzhu zzhuVar) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzhuVar.zza(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzhuVar.zzd(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzhuVar.zza(i2, (zzdj) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzhuVar.zzd(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzev.zza());
        } else if (zzhuVar.zza() == zzek.zze.zzj) {
            zzhuVar.zza(i2);
            ((zzhd) obj).zzb(zzhuVar);
            zzhuVar.zzb(i2);
        } else {
            zzhuVar.zzb(i2);
            ((zzhd) obj).zzb(zzhuVar);
            zzhuVar.zza(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzfw.zza(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }
}

package com.google.android.gms.internal.measurement;

import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@19.0.0 */
/* loaded from: classes.dex */
public final class zzis {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i, zzir zzirVar) {
        int i2 = i + 1;
        byte b2 = bArr[i];
        if (b2 < 0) {
            return zzb(b2, bArr, i2, zzirVar);
        }
        zzirVar.zza = b2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i, byte[] bArr, int i2, zzir zzirVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 >= 0) {
            zzirVar.zza = i3 | (b2 << 7);
            return i4;
        }
        int i5 = i3 | ((b2 & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b3 = bArr[i4];
        if (b3 >= 0) {
            zzirVar.zza = i5 | (b3 << 14);
            return i6;
        }
        int i7 = i5 | ((b3 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b4 = bArr[i6];
        if (b4 >= 0) {
            zzirVar.zza = i7 | (b4 << BinaryMemcacheOpcodes.INCREMENTQ);
            return i8;
        }
        int i9 = i7 | ((b4 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b5 = bArr[i8];
        if (b5 >= 0) {
            zzirVar.zza = i9 | (b5 << BinaryMemcacheOpcodes.TOUCH);
            return i10;
        }
        int i11 = i9 | ((b5 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] < 0) {
                i10 = i12;
            } else {
                zzirVar.zza = i11;
                return i12;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(byte[] bArr, int i, zzir zzirVar) {
        byte b2;
        int i2 = i + 1;
        long j = bArr[i];
        if (j < 0) {
            int i3 = i2 + 1;
            byte b3 = bArr[i2];
            long j2 = (j & 127) | ((b3 & Byte.MAX_VALUE) << 7);
            int i4 = 7;
            while (b3 < 0) {
                i3++;
                i4 += 7;
                j2 |= (b2 & Byte.MAX_VALUE) << i4;
                b3 = bArr[i3];
            }
            zzirVar.zzb = j2;
            return i3;
        }
        zzirVar.zzb = j;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zze(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(byte[] bArr, int i, zzir zzirVar) throws zzkn {
        int zza = zza(bArr, i, zzirVar);
        int i2 = zzirVar.zza;
        if (i2 < 0) {
            throw zzkn.zzb();
        } else if (i2 == 0) {
            zzirVar.zzc = "";
            return zza;
        } else {
            zzirVar.zzc = new String(bArr, zza, i2, zzkl.zza);
            return zza + i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(byte[] bArr, int i, zzir zzirVar) throws zzkn {
        int zza = zza(bArr, i, zzirVar);
        int i2 = zzirVar.zza;
        if (i2 < 0) {
            throw zzkn.zzb();
        } else if (i2 == 0) {
            zzirVar.zzc = "";
            return zza;
        } else {
            zzirVar.zzc = zzmw.zze(bArr, zza, i2);
            return zza + i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(byte[] bArr, int i, zzir zzirVar) throws zzkn {
        int zza = zza(bArr, i, zzirVar);
        int i2 = zzirVar.zza;
        if (i2 < 0) {
            throw zzkn.zzb();
        } else if (i2 > bArr.length - zza) {
            throw zzkn.zza();
        } else if (i2 == 0) {
            zzirVar.zzc = zzjd.zzb;
            return zza;
        } else {
            zzirVar.zzc = zzjd.zzj(bArr, zza, i2);
            return zza + i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(zzlt zzltVar, byte[] bArr, int i, int i2, zzir zzirVar) throws IOException {
        int i3 = i + 1;
        byte b2 = bArr[i];
        byte b3 = b2;
        if (b2 < 0) {
            i3 = zzb(b2, bArr, i3, zzirVar);
            b3 = zzirVar.zza;
        }
        if (b3 < 0 || b3 > i2 - i3) {
            throw zzkn.zza();
        }
        Object zza = zzltVar.zza();
        int i4 = (b3 == 1 ? 1 : 0) + i3;
        zzltVar.zzh(zza, bArr, i3, i4, zzirVar);
        zzltVar.zzi(zza);
        zzirVar.zzc = zza;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(zzlt zzltVar, byte[] bArr, int i, int i2, int i3, zzir zzirVar) throws IOException {
        zzll zzllVar = (zzll) zzltVar;
        Object zza = zzllVar.zza();
        int zzg = zzllVar.zzg(zza, bArr, i, i2, i3, zzirVar);
        zzllVar.zzi(zza);
        zzirVar.zzc = zza;
        return zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(int i, byte[] bArr, int i2, int i3, zzkk<?> zzkkVar, zzir zzirVar) {
        zzke zzkeVar = (zzke) zzkkVar;
        int zza = zza(bArr, i2, zzirVar);
        zzkeVar.zzh(zzirVar.zza);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzirVar);
            if (i != zzirVar.zza) {
                break;
            }
            zza = zza(bArr, zza2, zzirVar);
            zzkeVar.zzh(zzirVar.zza);
        }
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(byte[] bArr, int i, zzkk<?> zzkkVar, zzir zzirVar) throws IOException {
        zzke zzkeVar = (zzke) zzkkVar;
        int zza = zza(bArr, i, zzirVar);
        int i2 = zzirVar.zza + zza;
        while (zza < i2) {
            zza = zza(bArr, zza, zzirVar);
            zzkeVar.zzh(zzirVar.zza);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzkn.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(zzlt<?> zzltVar, int i, byte[] bArr, int i2, int i3, zzkk<?> zzkkVar, zzir zzirVar) throws IOException {
        int zzi = zzi(zzltVar, bArr, i2, i3, zzirVar);
        zzkkVar.add(zzirVar.zzc);
        while (zzi < i3) {
            int zza = zza(bArr, zzi, zzirVar);
            if (i != zzirVar.zza) {
                break;
            }
            zzi = zzi(zzltVar, bArr, zza, i3, zzirVar);
            zzkkVar.add(zzirVar.zzc);
        }
        return zzi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzn(int i, byte[] bArr, int i2, int i3, zzmi zzmiVar, zzir zzirVar) throws zzkn {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzc = zzc(bArr, i2, zzirVar);
                zzmiVar.zzh(i, Long.valueOf(zzirVar.zzb));
                return zzc;
            } else if (i4 == 1) {
                zzmiVar.zzh(i, Long.valueOf(zze(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zza = zza(bArr, i2, zzirVar);
                int i5 = zzirVar.zza;
                if (i5 < 0) {
                    throw zzkn.zzb();
                } else if (i5 <= bArr.length - zza) {
                    if (i5 == 0) {
                        zzmiVar.zzh(i, zzjd.zzb);
                    } else {
                        zzmiVar.zzh(i, zzjd.zzj(bArr, zza, i5));
                    }
                    return zza + i5;
                } else {
                    throw zzkn.zza();
                }
            } else if (i4 == 3) {
                int i6 = (i & (-8)) | 4;
                zzmi zzb = zzmi.zzb();
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zza2 = zza(bArr, i2, zzirVar);
                    int i8 = zzirVar.zza;
                    if (i8 == i6) {
                        i7 = i8;
                        i2 = zza2;
                        break;
                    }
                    i7 = i8;
                    i2 = zzn(i8, bArr, zza2, i3, zzb, zzirVar);
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzkn.zze();
                }
                zzmiVar.zzh(i, zzb);
                return i2;
            } else if (i4 == 5) {
                zzmiVar.zzh(i, Integer.valueOf(zzd(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzkn.zzc();
            }
        } else {
            throw zzkn.zzc();
        }
    }
}

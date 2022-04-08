package com.google.android.gms.internal.vision;

import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
public final class zzfe {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i, zzfg zzfgVar) {
        int i2 = i + 1;
        byte b2 = bArr[i];
        if (b2 < 0) {
            return zza(b2, bArr, i2, zzfgVar);
        }
        zzfgVar.zzsd = b2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(byte[] bArr, int i, zzfg zzfgVar) {
        byte b2;
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zzfgVar.zzse = j;
            return i2;
        }
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
        zzfgVar.zzse = j2;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double zzc(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzb(bArr, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float zzd(byte[] bArr, int i) {
        return Float.intBitsToFloat(zza(bArr, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(byte[] bArr, int i, zzfg zzfgVar) throws zzhh {
        int zza = zza(bArr, i, zzfgVar);
        int i2 = zzfgVar.zzsd;
        if (i2 < 0) {
            throw zzhh.zzgo();
        } else if (i2 > bArr.length - zza) {
            throw zzhh.zzgn();
        } else if (i2 == 0) {
            zzfgVar.zzsf = zzfm.zzsm;
            return zza;
        } else {
            zzfgVar.zzsf = zzfm.zza(bArr, zza, i2);
            return zza + i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(byte[] bArr, int i, zzhe<?> zzheVar, zzfg zzfgVar) throws IOException {
        zzgg zzggVar = (zzgg) zzheVar;
        int zza = zza(bArr, i, zzfgVar);
        int i2 = zzfgVar.zzsd + zza;
        while (zza < i2) {
            zzggVar.zzc(zzc(bArr, zza));
            zza += 8;
        }
        if (zza == i2) {
            return zza;
        }
        throw zzhh.zzgn();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(byte[] bArr, int i, zzhe<?> zzheVar, zzfg zzfgVar) throws IOException {
        zzfk zzfkVar = (zzfk) zzheVar;
        int zza = zza(bArr, i, zzfgVar);
        int i2 = zzfgVar.zzsd + zza;
        while (zza < i2) {
            zza = zzb(bArr, zza, zzfgVar);
            zzfkVar.addBoolean(zzfgVar.zzse != 0);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzhh.zzgn();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(byte[] bArr, int i, zzhe<?> zzheVar, zzfg zzfgVar) throws IOException {
        zzgz zzgzVar = (zzgz) zzheVar;
        int zza = zza(bArr, i, zzfgVar);
        int i2 = zzfgVar.zzsd + zza;
        while (zza < i2) {
            zza = zza(bArr, zza, zzfgVar);
            zzgzVar.zzbm(zzfy.zzav(zzfgVar.zzsd));
        }
        if (zza == i2) {
            return zza;
        }
        throw zzhh.zzgn();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(byte[] bArr, int i, zzhe<?> zzheVar, zzfg zzfgVar) throws IOException {
        zzhv zzhvVar = (zzhv) zzheVar;
        int zza = zza(bArr, i, zzfgVar);
        int i2 = zzfgVar.zzsd + zza;
        while (zza < i2) {
            zza = zzb(bArr, zza, zzfgVar);
            zzhvVar.zzac(zzfy.zzr(zzfgVar.zzse));
        }
        if (zza == i2) {
            return zza;
        }
        throw zzhh.zzgn();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(byte[] bArr, int i, zzfg zzfgVar) throws zzhh {
        int zza = zza(bArr, i, zzfgVar);
        int i2 = zzfgVar.zzsd;
        if (i2 < 0) {
            throw zzhh.zzgo();
        } else if (i2 == 0) {
            zzfgVar.zzsf = "";
            return zza;
        } else {
            zzfgVar.zzsf = new String(bArr, zza, i2, zzgy.UTF_8);
            return zza + i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(byte[] bArr, int i, zzfg zzfgVar) throws zzhh {
        int zza = zza(bArr, i, zzfgVar);
        int i2 = zzfgVar.zzsd;
        if (i2 < 0) {
            throw zzhh.zzgo();
        } else if (i2 == 0) {
            zzfgVar.zzsf = "";
            return zza;
        } else {
            zzfgVar.zzsf = zzjx.zzh(bArr, zza, i2);
            return zza + i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, byte[] bArr, int i2, zzfg zzfgVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 >= 0) {
            zzfgVar.zzsd = i3 | (b2 << 7);
            return i4;
        }
        int i5 = i3 | ((b2 & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b3 = bArr[i4];
        if (b3 >= 0) {
            zzfgVar.zzsd = i5 | (b3 << 14);
            return i6;
        }
        int i7 = i5 | ((b3 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b4 = bArr[i6];
        if (b4 >= 0) {
            zzfgVar.zzsd = i7 | (b4 << BinaryMemcacheOpcodes.INCREMENTQ);
            return i8;
        }
        int i9 = i7 | ((b4 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b5 = bArr[i8];
        if (b5 >= 0) {
            zzfgVar.zzsd = i9 | (b5 << BinaryMemcacheOpcodes.TOUCH);
            return i10;
        }
        int i11 = i9 | ((b5 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzfgVar.zzsd = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzb(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(byte[] bArr, int i, zzhe<?> zzheVar, zzfg zzfgVar) throws IOException {
        zzhv zzhvVar = (zzhv) zzheVar;
        int zza = zza(bArr, i, zzfgVar);
        int i2 = zzfgVar.zzsd + zza;
        while (zza < i2) {
            zza = zzb(bArr, zza, zzfgVar);
            zzhvVar.zzac(zzfgVar.zzse);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzhh.zzgn();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(byte[] bArr, int i, zzhe<?> zzheVar, zzfg zzfgVar) throws IOException {
        zzgz zzgzVar = (zzgz) zzheVar;
        int zza = zza(bArr, i, zzfgVar);
        int i2 = zzfgVar.zzsd + zza;
        while (zza < i2) {
            zzgzVar.zzbm(zza(bArr, zza));
            zza += 4;
        }
        if (zza == i2) {
            return zza;
        }
        throw zzhh.zzgn();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(byte[] bArr, int i, zzhe<?> zzheVar, zzfg zzfgVar) throws IOException {
        zzhv zzhvVar = (zzhv) zzheVar;
        int zza = zza(bArr, i, zzfgVar);
        int i2 = zzfgVar.zzsd + zza;
        while (zza < i2) {
            zzhvVar.zzac(zzb(bArr, zza));
            zza += 8;
        }
        if (zza == i2) {
            return zza;
        }
        throw zzhh.zzgn();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(byte[] bArr, int i, zzhe<?> zzheVar, zzfg zzfgVar) throws IOException {
        zzgt zzgtVar = (zzgt) zzheVar;
        int zza = zza(bArr, i, zzfgVar);
        int i2 = zzfgVar.zzsd + zza;
        while (zza < i2) {
            zzgtVar.zzu(zzd(bArr, zza));
            zza += 4;
        }
        if (zza == i2) {
            return zza;
        }
        throw zzhh.zzgn();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zziw zziwVar, byte[] bArr, int i, int i2, zzfg zzfgVar) throws IOException {
        int i3 = i + 1;
        byte b2 = bArr[i];
        byte b3 = b2;
        if (b2 < 0) {
            i3 = zza(b2, bArr, i3, zzfgVar);
            b3 = zzfgVar.zzsd;
        }
        if (b3 < 0 || b3 > i2 - i3) {
            throw zzhh.zzgn();
        }
        Object newInstance = zziwVar.newInstance();
        int i4 = (b3 == 1 ? 1 : 0) + i3;
        zziwVar.zza(newInstance, bArr, i3, i4, zzfgVar);
        zziwVar.zzh(newInstance);
        zzfgVar.zzsf = newInstance;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zziw zziwVar, byte[] bArr, int i, int i2, int i3, zzfg zzfgVar) throws IOException {
        zzil zzilVar = (zzil) zziwVar;
        Object newInstance = zzilVar.newInstance();
        int zza = zzilVar.zza((zzil) newInstance, bArr, i, i2, i3, zzfgVar);
        zzilVar.zzh(newInstance);
        zzfgVar.zzsf = newInstance;
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, byte[] bArr, int i2, int i3, zzhe<?> zzheVar, zzfg zzfgVar) {
        zzgz zzgzVar = (zzgz) zzheVar;
        int zza = zza(bArr, i2, zzfgVar);
        zzgzVar.zzbm(zzfgVar.zzsd);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzfgVar);
            if (i != zzfgVar.zzsd) {
                break;
            }
            zza = zza(bArr, zza2, zzfgVar);
            zzgzVar.zzbm(zzfgVar.zzsd);
        }
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i, zzhe<?> zzheVar, zzfg zzfgVar) throws IOException {
        zzgz zzgzVar = (zzgz) zzheVar;
        int zza = zza(bArr, i, zzfgVar);
        int i2 = zzfgVar.zzsd + zza;
        while (zza < i2) {
            zza = zza(bArr, zza, zzfgVar);
            zzgzVar.zzbm(zzfgVar.zzsd);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzhh.zzgn();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zziw<?> zziwVar, int i, byte[] bArr, int i2, int i3, zzhe<?> zzheVar, zzfg zzfgVar) throws IOException {
        int zza = zza(zziwVar, bArr, i2, i3, zzfgVar);
        zzheVar.add(zzfgVar.zzsf);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzfgVar);
            if (i != zzfgVar.zzsd) {
                break;
            }
            zza = zza(zziwVar, bArr, zza2, i3, zzfgVar);
            zzheVar.add(zzfgVar.zzsf);
        }
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, byte[] bArr, int i2, int i3, zzjr zzjrVar, zzfg zzfgVar) throws zzhh {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzb = zzb(bArr, i2, zzfgVar);
                zzjrVar.zzb(i, Long.valueOf(zzfgVar.zzse));
                return zzb;
            } else if (i4 == 1) {
                zzjrVar.zzb(i, Long.valueOf(zzb(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zza = zza(bArr, i2, zzfgVar);
                int i5 = zzfgVar.zzsd;
                if (i5 < 0) {
                    throw zzhh.zzgo();
                } else if (i5 <= bArr.length - zza) {
                    if (i5 == 0) {
                        zzjrVar.zzb(i, zzfm.zzsm);
                    } else {
                        zzjrVar.zzb(i, zzfm.zza(bArr, zza, i5));
                    }
                    return zza + i5;
                } else {
                    throw zzhh.zzgn();
                }
            } else if (i4 == 3) {
                zzjr zzii = zzjr.zzii();
                int i6 = (i & (-8)) | 4;
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zza2 = zza(bArr, i2, zzfgVar);
                    int i8 = zzfgVar.zzsd;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = zza2;
                        break;
                    }
                    int zza3 = zza(i7, bArr, zza2, i3, zzii, zzfgVar);
                    i7 = i8;
                    i2 = zza3;
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzhh.zzgt();
                }
                zzjrVar.zzb(i, zzii);
                return i2;
            } else if (i4 == 5) {
                zzjrVar.zzb(i, Integer.valueOf(zza(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzhh.zzgq();
            }
        } else {
            throw zzhh.zzgq();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, byte[] bArr, int i2, int i3, zzfg zzfgVar) throws zzhh {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return zzb(bArr, i2, zzfgVar);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return zza(bArr, i2, zzfgVar) + zzfgVar.zzsd;
            }
            if (i4 == 3) {
                int i5 = (i & (-8)) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = zza(bArr, i2, zzfgVar);
                    i6 = zzfgVar.zzsd;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = zza(i6, bArr, i2, i3, zzfgVar);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw zzhh.zzgt();
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw zzhh.zzgq();
            }
        } else {
            throw zzhh.zzgq();
        }
    }
}

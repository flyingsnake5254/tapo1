package com.google.android.gms.internal.vision;

import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
final class zzkb extends zzjy {
    @Override // com.google.android.gms.internal.vision.zzjy
    final int zzb(int i, byte[] bArr, int i2, int i3) {
        int zzg;
        int zzg2;
        while (i2 < i3 && bArr[i2] >= 0) {
            i2++;
        }
        if (i2 >= i3) {
            return 0;
        }
        while (i2 < i3) {
            i2++;
            byte b2 = bArr[i2];
            if (b2 < 0) {
                if (b2 < -32) {
                    if (i2 >= i3) {
                        return b2;
                    }
                    if (b2 >= -62) {
                        i2++;
                        if (bArr[i2] > -65) {
                        }
                    }
                    return -1;
                } else if (b2 < -16) {
                    if (i2 >= i3 - 1) {
                        zzg = zzjx.zzg(bArr, i2, i3);
                        return zzg;
                    }
                    int i4 = i2 + 1;
                    byte b3 = bArr[i2];
                    if (b3 <= -65 && ((b2 != -32 || b3 >= -96) && (b2 != -19 || b3 < -96))) {
                        i2 = i4 + 1;
                        if (bArr[i4] > -65) {
                        }
                    }
                    return -1;
                } else if (i2 >= i3 - 2) {
                    zzg2 = zzjx.zzg(bArr, i2, i3);
                    return zzg2;
                } else {
                    int i5 = i2 + 1;
                    byte b4 = bArr[i2];
                    if (b4 <= -65 && (((b2 << BinaryMemcacheOpcodes.TOUCH) + (b4 + 112)) >> 30) == 0) {
                        int i6 = i5 + 1;
                        if (bArr[i5] <= -65) {
                            i2 = i6 + 1;
                            if (bArr[i6] > -65) {
                            }
                        }
                    }
                    return -1;
                }
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzjy
    public final String zzh(byte[] bArr, int i, int i2) throws zzhh {
        boolean zzd;
        boolean zzd2;
        boolean zze;
        boolean zzf;
        boolean zzd3;
        if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (i < i3) {
                byte b2 = bArr[i];
                zzd3 = zzjz.zzd(b2);
                if (!zzd3) {
                    break;
                }
                i++;
                i4++;
                zzjz.zza(b2, cArr, i4);
            }
            int i5 = i4;
            while (i < i3) {
                int i6 = i + 1;
                byte b3 = bArr[i];
                zzd = zzjz.zzd(b3);
                if (zzd) {
                    int i7 = i5 + 1;
                    zzjz.zza(b3, cArr, i5);
                    while (i6 < i3) {
                        byte b4 = bArr[i6];
                        zzd2 = zzjz.zzd(b4);
                        if (!zzd2) {
                            break;
                        }
                        i6++;
                        i7++;
                        zzjz.zza(b4, cArr, i7);
                    }
                    i = i6;
                    i5 = i7;
                } else {
                    zze = zzjz.zze(b3);
                    if (!zze) {
                        zzf = zzjz.zzf(b3);
                        if (zzf) {
                            if (i6 < i3 - 1) {
                                int i8 = i6 + 1;
                                i = i8 + 1;
                                i5++;
                                zzjz.zza(b3, bArr[i6], bArr[i8], cArr, i5);
                            } else {
                                throw zzhh.zzgu();
                            }
                        } else if (i6 < i3 - 2) {
                            int i9 = i6 + 1;
                            byte b5 = bArr[i6];
                            int i10 = i9 + 1;
                            i = i10 + 1;
                            zzjz.zza(b3, b5, bArr[i9], bArr[i10], cArr, i5);
                            i5 = i5 + 1 + 1;
                        } else {
                            throw zzhh.zzgu();
                        }
                    } else if (i6 < i3) {
                        i = i6 + 1;
                        i5++;
                        zzjz.zza(b3, bArr[i6], cArr, i5);
                    } else {
                        throw zzhh.zzgu();
                    }
                }
            }
            return new String(cArr, 0, i5);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        return r10 + r0;
     */
    @Override // com.google.android.gms.internal.vision.zzjy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzb(java.lang.CharSequence r8, byte[] r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzkb.zzb(java.lang.CharSequence, byte[], int, int):int");
    }
}

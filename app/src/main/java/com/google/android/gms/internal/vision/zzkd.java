package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
final class zzkd extends zzjy {
    private static int zza(byte[] bArr, int i, long j, int i2) {
        int zzbx;
        int zzv;
        int zzd;
        if (i2 == 0) {
            zzbx = zzjx.zzbx(i);
            return zzbx;
        } else if (i2 == 1) {
            zzv = zzjx.zzv(i, zzju.zza(bArr, j));
            return zzv;
        } else if (i2 == 2) {
            zzd = zzjx.zzd(i, zzju.zza(bArr, j), zzju.zza(bArr, j + 1));
            return zzd;
        } else {
            throw new AssertionError();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0061, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b6, code lost:
        return -1;
     */
    @Override // com.google.android.gms.internal.vision.zzjy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int zzb(int r16, byte[] r17, int r18, int r19) {
        /*
            Method dump skipped, instructions count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzkd.zzb(int, byte[], int, int):int");
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
                byte zza = zzju.zza(bArr, i);
                zzd3 = zzjz.zzd(zza);
                if (!zzd3) {
                    break;
                }
                i++;
                i4++;
                zzjz.zza(zza, cArr, i4);
            }
            int i5 = i4;
            while (i < i3) {
                int i6 = i + 1;
                byte zza2 = zzju.zza(bArr, i);
                zzd = zzjz.zzd(zza2);
                if (zzd) {
                    int i7 = i5 + 1;
                    zzjz.zza(zza2, cArr, i5);
                    while (i6 < i3) {
                        byte zza3 = zzju.zza(bArr, i6);
                        zzd2 = zzjz.zzd(zza3);
                        if (!zzd2) {
                            break;
                        }
                        i6++;
                        i7++;
                        zzjz.zza(zza3, cArr, i7);
                    }
                    i = i6;
                    i5 = i7;
                } else {
                    zze = zzjz.zze(zza2);
                    if (!zze) {
                        zzf = zzjz.zzf(zza2);
                        if (zzf) {
                            if (i6 < i3 - 1) {
                                int i8 = i6 + 1;
                                i = i8 + 1;
                                i5++;
                                zzjz.zza(zza2, zzju.zza(bArr, i6), zzju.zza(bArr, i8), cArr, i5);
                            } else {
                                throw zzhh.zzgu();
                            }
                        } else if (i6 < i3 - 2) {
                            int i9 = i6 + 1;
                            int i10 = i9 + 1;
                            i = i10 + 1;
                            zzjz.zza(zza2, zzju.zza(bArr, i6), zzju.zza(bArr, i9), zzju.zza(bArr, i10), cArr, i5);
                            i5 = i5 + 1 + 1;
                        } else {
                            throw zzhh.zzgu();
                        }
                    } else if (i6 < i3) {
                        i = i6 + 1;
                        i5++;
                        zzjz.zza(zza2, zzju.zza(bArr, i6), cArr, i5);
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
    @Override // com.google.android.gms.internal.vision.zzjy
    public final int zzb(CharSequence charSequence, byte[] bArr, int i, int i2) {
        char c2;
        long j;
        int i3;
        char charAt;
        long j2 = i;
        long j3 = i2 + j2;
        int length = charSequence.length();
        if (length > i2 || bArr.length - i2 < i) {
            char charAt2 = charSequence.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(charAt2);
            sb.append(" at index ");
            sb.append(i + i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i4 = 0;
        while (true) {
            c2 = 128;
            j = 1;
            if (i4 >= length || (charAt = charSequence.charAt(i4)) >= 128) {
                break;
            }
            j2 = 1 + j2;
            zzju.zza(bArr, j2, (byte) charAt);
            i4++;
        }
        if (i4 == length) {
            return (int) j2;
        }
        while (i4 < length) {
            char charAt3 = charSequence.charAt(i4);
            if (charAt3 >= c2 || j2 >= j3) {
                if (charAt3 < 2048 && j2 <= j3 - 2) {
                    long j4 = j2 + j;
                    zzju.zza(bArr, j2, (byte) ((charAt3 >>> 6) | 960));
                    j2 = j4 + j;
                    zzju.zza(bArr, j4, (byte) ((charAt3 & '?') | 128));
                    j = j;
                } else if ((charAt3 < 55296 || 57343 < charAt3) && j2 <= j3 - 3) {
                    long j5 = j2 + j;
                    zzju.zza(bArr, j2, (byte) ((charAt3 >>> '\f') | 480));
                    long j6 = j5 + j;
                    zzju.zza(bArr, j5, (byte) (((charAt3 >>> 6) & 63) | 128));
                    j2 = j6 + 1;
                    zzju.zza(bArr, j6, (byte) ((charAt3 & '?') | 128));
                    j = 1;
                } else if (j2 <= j3 - 4) {
                    int i5 = i4 + 1;
                    if (i5 != length) {
                        char charAt4 = charSequence.charAt(i5);
                        if (Character.isSurrogatePair(charAt3, charAt4)) {
                            int codePoint = Character.toCodePoint(charAt3, charAt4);
                            long j7 = j2 + 1;
                            zzju.zza(bArr, j2, (byte) ((codePoint >>> 18) | 240));
                            long j8 = j7 + 1;
                            zzju.zza(bArr, j7, (byte) (((codePoint >>> 12) & 63) | 128));
                            long j9 = j8 + 1;
                            zzju.zza(bArr, j8, (byte) (((codePoint >>> 6) & 63) | 128));
                            j = 1;
                            j2 = j9 + 1;
                            zzju.zza(bArr, j9, (byte) ((codePoint & 63) | 128));
                            i4 = i5;
                        } else {
                            i4 = i5;
                        }
                    }
                    throw new zzka(i4 - 1, length);
                } else if (55296 > charAt3 || charAt3 > 57343 || ((i3 = i4 + 1) != length && Character.isSurrogatePair(charAt3, charSequence.charAt(i3)))) {
                    StringBuilder sb2 = new StringBuilder(46);
                    sb2.append("Failed writing ");
                    sb2.append(charAt3);
                    sb2.append(" at index ");
                    sb2.append(j2);
                    throw new ArrayIndexOutOfBoundsException(sb2.toString());
                } else {
                    throw new zzka(i4, length);
                }
                i4++;
                c2 = 128;
            } else {
                j2 += j;
                zzju.zza(bArr, j2, (byte) charAt3);
                j = j;
            }
            i4++;
            c2 = 128;
        }
        return (int) j2;
    }
}

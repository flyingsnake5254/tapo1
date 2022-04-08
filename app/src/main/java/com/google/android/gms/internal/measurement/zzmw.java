package com.google.android.gms.internal.measurement;

import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@19.0.0 */
/* loaded from: classes.dex */
public final class zzmw {
    private static final zzmt zza;

    static {
        if (zzmr.zza() && zzmr.zzb()) {
            int i = zziq.zza;
        }
        zza = new zzmu();
    }

    public static boolean zza(byte[] bArr) {
        return zza.zza(bArr, 0, bArr.length);
    }

    public static boolean zzb(byte[] bArr, int i, int i2) {
        return zza.zza(bArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (charAt2 >= 55296 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) >= 65536) {
                                i2++;
                            } else {
                                throw new zzmv(i2, length2);
                            }
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(i3 + 4294967296L);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0100, code lost:
        return r9 + r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int zzd(java.lang.CharSequence r7, byte[] r8, int r9, int r10) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzmw.zzd(java.lang.CharSequence, byte[], int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zze(byte[] bArr, int i, int i2) throws zzkn {
        int length = bArr.length;
        if ((i | i2 | ((length - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (i < i3) {
                byte b2 = bArr[i];
                if (!zzms.zza(b2)) {
                    break;
                }
                i++;
                i4++;
                cArr[i4] = (char) b2;
            }
            while (i < i3) {
                int i5 = i + 1;
                byte b3 = bArr[i];
                if (zzms.zza(b3)) {
                    i4++;
                    cArr[i4] = (char) b3;
                    i = i5;
                    while (i < i3) {
                        byte b4 = bArr[i];
                        if (!zzms.zza(b4)) {
                            break;
                        }
                        i++;
                        i4++;
                        cArr[i4] = (char) b4;
                    }
                } else if (b3 < -32) {
                    if (i5 < i3) {
                        i = i5 + 1;
                        i4++;
                        zzms.zzb(b3, bArr[i5], cArr, i4);
                    } else {
                        throw zzkn.zzf();
                    }
                } else if (b3 < -16) {
                    if (i5 < i3 - 1) {
                        int i6 = i5 + 1;
                        i = i6 + 1;
                        i4++;
                        zzms.zzc(b3, bArr[i5], bArr[i6], cArr, i4);
                    } else {
                        throw zzkn.zzf();
                    }
                } else if (i5 < i3 - 2) {
                    int i7 = i5 + 1;
                    int i8 = i7 + 1;
                    i = i8 + 1;
                    zzms.zzd(b3, bArr[i5], bArr[i7], bArr[i8], cArr, i4);
                    i4 += 2;
                } else {
                    throw zzkn.zzf();
                }
            }
            return new String(cArr, 0, i4);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i), Integer.valueOf(i2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int zzf(byte[] bArr, int i, int i2) {
        byte b2 = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 != 0) {
            if (i3 == 1) {
                byte b3 = bArr[i];
                if (b2 <= -12 && b3 <= -65) {
                    return b2 ^ (b3 << 8);
                }
            } else if (i3 == 2) {
                byte b4 = bArr[i];
                byte b5 = bArr[i + 1];
                if (b2 <= -12 && b4 <= -65 && b5 <= -65) {
                    return ((b4 << 8) ^ b2) ^ (b5 << BinaryMemcacheOpcodes.STAT);
                }
            } else {
                throw new AssertionError();
            }
        } else if (b2 <= -12) {
            return b2;
        }
        return -1;
    }
}
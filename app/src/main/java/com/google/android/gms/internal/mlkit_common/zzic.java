package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes.dex */
final class zzic extends zzhx {
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0061, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b6, code lost:
        return -1;
     */
    @Override // com.google.android.gms.internal.mlkit_common.zzhx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int zza(int r16, byte[] r17, int r18, int r19) {
        /*
            Method dump skipped, instructions count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzic.zza(int, byte[], int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_common.zzhx
    public final int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
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
            zzhw.zza(bArr, j2, (byte) charAt);
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
                    zzhw.zza(bArr, j2, (byte) ((charAt3 >>> 6) | 960));
                    j2 = j4 + j;
                    zzhw.zza(bArr, j4, (byte) ((charAt3 & '?') | 128));
                    j = j;
                } else if ((charAt3 < 55296 || 57343 < charAt3) && j2 <= j3 - 3) {
                    long j5 = j2 + j;
                    zzhw.zza(bArr, j2, (byte) ((charAt3 >>> '\f') | 480));
                    long j6 = j5 + j;
                    zzhw.zza(bArr, j5, (byte) (((charAt3 >>> 6) & 63) | 128));
                    j2 = j6 + 1;
                    zzhw.zza(bArr, j6, (byte) ((charAt3 & '?') | 128));
                    j = 1;
                } else if (j2 <= j3 - 4) {
                    int i5 = i4 + 1;
                    if (i5 != length) {
                        char charAt4 = charSequence.charAt(i5);
                        if (Character.isSurrogatePair(charAt3, charAt4)) {
                            int codePoint = Character.toCodePoint(charAt3, charAt4);
                            long j7 = j2 + 1;
                            zzhw.zza(bArr, j2, (byte) ((codePoint >>> 18) | 240));
                            long j8 = j7 + 1;
                            zzhw.zza(bArr, j7, (byte) (((codePoint >>> 12) & 63) | 128));
                            long j9 = j8 + 1;
                            zzhw.zza(bArr, j8, (byte) (((codePoint >>> 6) & 63) | 128));
                            j = 1;
                            j2 = j9 + 1;
                            zzhw.zza(bArr, j9, (byte) ((codePoint & 63) | 128));
                            i4 = i5;
                        } else {
                            i4 = i5;
                        }
                    }
                    throw new zzhz(i4 - 1, length);
                } else if (55296 > charAt3 || charAt3 > 57343 || ((i3 = i4 + 1) != length && Character.isSurrogatePair(charAt3, charSequence.charAt(i3)))) {
                    StringBuilder sb2 = new StringBuilder(46);
                    sb2.append("Failed writing ");
                    sb2.append(charAt3);
                    sb2.append(" at index ");
                    sb2.append(j2);
                    throw new ArrayIndexOutOfBoundsException(sb2.toString());
                } else {
                    throw new zzhz(i4, length);
                }
                i4++;
                c2 = 128;
            } else {
                j2 += j;
                zzhw.zza(bArr, j2, (byte) charAt3);
                j = j;
            }
            i4++;
            c2 = 128;
        }
        return (int) j2;
    }

    private static int zza(byte[] bArr, int i, long j, int i2) {
        int zzb;
        int zzb2;
        int zzb3;
        if (i2 == 0) {
            zzb = zzhy.zzb(i);
            return zzb;
        } else if (i2 == 1) {
            zzb2 = zzhy.zzb(i, zzhw.zza(bArr, j));
            return zzb2;
        } else if (i2 == 2) {
            zzb3 = zzhy.zzb(i, zzhw.zza(bArr, j), zzhw.zza(bArr, j + 1));
            return zzb3;
        } else {
            throw new AssertionError();
        }
    }
}

package com.google.android.gms.internal.mlkit_vision_common;

import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes.dex */
final class zzhk extends zzhl {
    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhl
    final int zza(int i, byte[] bArr, int i2, int i3) {
        int zzc;
        int zzc2;
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
                        zzc = zzhj.zzc(bArr, i2, i3);
                        return zzc;
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
                    zzc2 = zzhj.zzc(bArr, i2, i3);
                    return zzc2;
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
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        return r10 + r0;
     */
    @Override // com.google.android.gms.internal.mlkit_vision_common.zzhl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(java.lang.CharSequence r8, byte[] r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzhk.zza(java.lang.CharSequence, byte[], int, int):int");
    }
}

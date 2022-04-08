package com.google.android.gms.internal.measurement;

import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;

/* compiled from: com.google.android.gms:play-services-measurement-base@@19.0.0 */
/* loaded from: classes.dex */
final class zzmu extends zzmt {
    @Override // com.google.android.gms.internal.measurement.zzmt
    final int zzb(int i, byte[] bArr, int i2, int i3) {
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
                if (b2 >= -32) {
                    if (b2 < -16) {
                        if (i2 >= i3 - 1) {
                            return zzmw.zzf(bArr, i2, i3);
                        }
                        int i4 = i2 + 1;
                        byte b3 = bArr[i2];
                        if (b3 <= -65 && ((b2 != -32 || b3 >= -96) && (b2 != -19 || b3 < -96))) {
                            i2 = i4 + 1;
                            if (bArr[i4] > -65) {
                            }
                        }
                    } else if (i2 >= i3 - 2) {
                        return zzmw.zzf(bArr, i2, i3);
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
                    }
                    return -1;
                } else if (i2 >= i3) {
                    return b2;
                } else {
                    if (b2 >= -62) {
                        i2++;
                        if (bArr[i2] > -65) {
                        }
                    }
                    return -1;
                }
            }
        }
        return 0;
    }
}

package com.google.android.gms.internal.measurement;

import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;

/* compiled from: com.google.android.gms:play-services-measurement-base@@19.0.0 */
/* loaded from: classes.dex */
final class zzms {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean zza(byte b2) {
        return b2 >= 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzb(byte b2, byte b3, char[] cArr, int i) throws zzkn {
        if (b2 < -62 || zze(b3)) {
            throw zzkn.zzf();
        }
        cArr[i] = (char) (((b2 & 31) << 6) | (b3 & 63));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzc(byte b2, byte b3, byte b4, char[] cArr, int i) throws zzkn {
        if (!zze(b3)) {
            if (b2 == -32) {
                if (b3 >= -96) {
                    b2 = -32;
                }
            }
            if (b2 == -19) {
                if (b3 < -96) {
                    b2 = -19;
                }
            }
            if (!zze(b4)) {
                cArr[i] = (char) (((b2 & BinaryMemcacheOpcodes.PREPEND) << 12) | ((b3 & 63) << 6) | (b4 & 63));
                return;
            }
        }
        throw zzkn.zzf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzd(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i) throws zzkn {
        if (zze(b3) || (((b2 << BinaryMemcacheOpcodes.TOUCH) + (b3 + 112)) >> 30) != 0 || zze(b4) || zze(b5)) {
            throw zzkn.zzf();
        }
        int i2 = ((b2 & 7) << 18) | ((b3 & 63) << 12) | ((b4 & 63) << 6) | (b5 & 63);
        cArr[i] = (char) ((i2 >>> 10) + 55232);
        cArr[i + 1] = (char) ((i2 & 1023) + 56320);
    }

    private static boolean zze(byte b2) {
        return b2 > -65;
    }
}

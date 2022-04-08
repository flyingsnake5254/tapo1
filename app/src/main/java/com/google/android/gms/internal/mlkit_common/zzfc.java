package com.google.android.gms.internal.mlkit_common;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes.dex */
public final class zzfc {
    public static final byte[] zzb;
    private static final ByteBuffer zzd;
    private static final zzeh zze;
    static final Charset zza = Charset.forName("UTF-8");
    private static final Charset zzc = Charset.forName("ISO-8859-1");

    static {
        byte[] bArr = new byte[0];
        zzb = bArr;
        zzd = ByteBuffer.wrap(bArr);
        zze = zzeh.zza(bArr, 0, bArr.length, false);
    }

    public static int zza(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int zza(boolean z) {
        return z ? 1231 : 1237;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T zza(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static String zzb(byte[] bArr) {
        return new String(bArr, zza);
    }

    public static int zzc(byte[] bArr) {
        int length = bArr.length;
        int zza2 = zza(length, bArr, 0, length);
        if (zza2 == 0) {
            return 1;
        }
        return zza2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T zza(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    public static boolean zza(byte[] bArr) {
        return zzhy.zza(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(zzgh zzghVar) {
        if (!(zzghVar instanceof zzds)) {
            return false;
        }
        zzds zzdsVar = (zzds) zzghVar;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zza(Object obj, Object obj2) {
        return ((zzgh) obj).zzm().zza((zzgh) obj2).zzg();
    }
}

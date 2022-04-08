package com.google.android.gms.internal.vision;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
public final class zzgy {
    public static final byte[] zzxr;
    private static final ByteBuffer zzxs;
    private static final zzfy zzxt;
    static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    static {
        byte[] bArr = new byte[0];
        zzxr = bArr;
        zzxs = ByteBuffer.wrap(bArr);
        zzxt = zzfy.zza(bArr, 0, bArr.length, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T checkNotNull(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static int hashCode(byte[] bArr) {
        int length = bArr.length;
        int zza = zza(length, bArr, 0, length);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T zza(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    public static int zzab(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzb(Object obj, Object obj2) {
        return ((zzih) obj).zzgj().zza((zzih) obj2).zzgc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzf(zzih zzihVar) {
        if (!(zzihVar instanceof zzfa)) {
            return false;
        }
        zzfa zzfaVar = (zzfa) zzihVar;
        return false;
    }

    public static boolean zzg(byte[] bArr) {
        return zzjx.zzg(bArr);
    }

    public static String zzh(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    public static int zzm(boolean z) {
        return z ? 1231 : 1237;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }
}

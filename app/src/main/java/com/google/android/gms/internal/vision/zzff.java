package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
final class zzff {
    private static final Class<?> zzsb = zzv("libcore.io.Memory");
    private static final boolean zzsc;

    static {
        zzsc = zzv("org.robolectric.Robolectric") != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzds() {
        return zzsb != null && !zzsc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?> zzdt() {
        return zzsb;
    }

    private static <T> Class<T> zzv(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}

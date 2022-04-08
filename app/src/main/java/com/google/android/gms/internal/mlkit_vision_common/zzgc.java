package com.google.android.gms.internal.mlkit_vision_common;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes.dex */
final class zzgc {
    private static final zzga zza = zzc();
    private static final zzga zzb = new zzgd();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzga zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzga zzb() {
        return zzb;
    }

    private static zzga zzc() {
        try {
            return (zzga) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}

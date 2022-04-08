package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes.dex */
final class zzgs {
    private static final zzgq zza = zzc();
    private static final zzgq zzb = new zzgp();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzgq zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzgq zzb() {
        return zzb;
    }

    private static zzgq zzc() {
        try {
            return (zzgq) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}

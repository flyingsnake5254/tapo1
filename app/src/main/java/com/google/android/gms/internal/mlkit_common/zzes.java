package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes.dex */
final class zzes {
    private static final zzeq<?> zza = new zzep();
    private static final zzeq<?> zzb = zzc();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzeq<?> zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzeq<?> zzb() {
        zzeq<?> zzeqVar = zzb;
        if (zzeqVar != null) {
            return zzeqVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    private static zzeq<?> zzc() {
        try {
            return (zzeq) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}

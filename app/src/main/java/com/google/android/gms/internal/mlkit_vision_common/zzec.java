package com.google.android.gms.internal.mlkit_vision_common;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes.dex */
final class zzec {
    private static final zzea<?> zza = new zzed();
    private static final zzea<?> zzb = zzc();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzea<?> zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzea<?> zzb() {
        zzea<?> zzeaVar = zzb;
        if (zzeaVar != null) {
            return zzeaVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    private static zzea<?> zzc() {
        try {
            return (zzea) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}

package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
final class zzft {
    private static final zzfr<?> zza = new zzfq();
    private static final zzfr<?> zzb = zzc();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfr<?> zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfr<?> zzb() {
        zzfr<?> zzfrVar = zzb;
        if (zzfrVar != null) {
            return zzfrVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    private static zzfr<?> zzc() {
        try {
            return (zzfr) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}

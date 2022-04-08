package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@19.0.0 */
/* loaded from: classes.dex */
final class zzlo {
    private static final zzln zza;
    private static final zzln zzb;

    static {
        zzln zzlnVar;
        try {
            zzlnVar = (zzln) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzlnVar = null;
        }
        zza = zzlnVar;
        zzb = new zzln();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzln zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzln zzb() {
        return zzb;
    }
}

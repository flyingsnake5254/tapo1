package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzek;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes.dex */
final class zzel implements zzfs {
    private static final zzel zza = new zzel();

    private zzel() {
    }

    public static zzel zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfs
    public final zzft zzb(Class<?> cls) {
        if (!zzek.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            throw new IllegalArgumentException(name.length() != 0 ? "Unsupported message type: ".concat(name) : new String("Unsupported message type: "));
        }
        try {
            return (zzft) zzek.zza((Class<zzek>) cls.asSubclass(zzek.class)).zza(zzek.zze.zzc, (Object) null, (Object) null);
        } catch (Exception e2) {
            String name2 = cls.getName();
            throw new RuntimeException(name2.length() != 0 ? "Unable to get message info for ".concat(name2) : new String("Unable to get message info for "), e2);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfs
    public final boolean zza(Class<?> cls) {
        return zzek.class.isAssignableFrom(cls);
    }
}

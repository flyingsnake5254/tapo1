package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
public final class zzhw {
    private static final zzhw zza = new zzhw();
    private final ConcurrentMap<Class<?>, zzib<?>> zzc = new ConcurrentHashMap();
    private final zzia zzb = new zzhb();

    private zzhw() {
    }

    public static zzhw zza() {
        return zza;
    }

    public final <T> zzib<T> zza(Class<T> cls) {
        zzgc.zza(cls, "messageType");
        zzib<T> zzibVar = (zzib<T>) this.zzc.get(cls);
        if (zzibVar != null) {
            return zzibVar;
        }
        zzib<T> zza2 = this.zzb.zza(cls);
        zzgc.zza(cls, "messageType");
        zzgc.zza(zza2, "schema");
        zzib<T> zzibVar2 = (zzib<T>) this.zzc.putIfAbsent(cls, zza2);
        return zzibVar2 != null ? zzibVar2 : zza2;
    }

    public final <T> zzib<T> zza(T t) {
        return zza((Class) t.getClass());
    }
}

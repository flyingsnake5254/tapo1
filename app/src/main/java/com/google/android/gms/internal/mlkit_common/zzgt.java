package com.google.android.gms.internal.mlkit_common;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes.dex */
public final class zzgt {
    private static final zzgt zza = new zzgt();
    private final ConcurrentMap<Class<?>, zzgy<?>> zzc = new ConcurrentHashMap();
    private final zzgx zzb = new zzfy();

    private zzgt() {
    }

    public static zzgt zza() {
        return zza;
    }

    public final <T> zzgy<T> zza(Class<T> cls) {
        zzfc.zza(cls, "messageType");
        zzgy<T> zzgyVar = (zzgy<T>) this.zzc.get(cls);
        if (zzgyVar != null) {
            return zzgyVar;
        }
        zzgy<T> zza2 = this.zzb.zza(cls);
        zzfc.zza(cls, "messageType");
        zzfc.zza(zza2, "schema");
        zzgy<T> zzgyVar2 = (zzgy<T>) this.zzc.putIfAbsent(cls, zza2);
        return zzgyVar2 != null ? zzgyVar2 : zza2;
    }

    public final <T> zzgy<T> zza(T t) {
        return zza((Class) t.getClass());
    }
}

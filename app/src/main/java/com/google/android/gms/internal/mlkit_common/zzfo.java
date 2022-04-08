package com.google.android.gms.internal.mlkit_common;

import java.util.Map;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes.dex */
final class zzfo<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzfm> zza;

    private zzfo(Map.Entry<K, zzfm> entry) {
        this.zza = entry;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.zza.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.zza.getValue() == null) {
            return null;
        }
        return zzfm.zza();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzgh) {
            return this.zza.getValue().zza((zzgh) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public final zzfm zza() {
        return this.zza.getValue();
    }
}

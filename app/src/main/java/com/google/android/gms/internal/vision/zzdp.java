package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
final class zzdp<K, V> extends zzdo<Map.Entry<K, V>> {
    private final transient int size;
    private final transient zzdl<K, V> zzmj;
    private final transient Object[] zzmk;
    private final transient int zzml = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdp(zzdl<K, V> zzdlVar, Object[] objArr, int i, int i2) {
        this.zzmj = zzdlVar;
        this.zzmk = objArr;
        this.size = i2;
    }

    @Override // com.google.android.gms.internal.vision.zzdh, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.zzmj.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.vision.zzdo, com.google.android.gms.internal.vision.zzdh, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzdh
    public final int zza(Object[] objArr, int i) {
        return zzcd().zza(objArr, i);
    }

    @Override // com.google.android.gms.internal.vision.zzdh
    public final zzdw<Map.Entry<K, V>> zzbz() {
        return (zzdw) zzcd().iterator();
    }

    @Override // com.google.android.gms.internal.vision.zzdo
    final zzdk<Map.Entry<K, V>> zzci() {
        return new zzds(this);
    }
}

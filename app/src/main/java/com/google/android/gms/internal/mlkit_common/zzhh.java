package com.google.android.gms.internal.mlkit_common;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes.dex */
final class zzhh implements Iterator<Map.Entry<K, V>> {
    private int zza;
    private boolean zzb;
    private Iterator<Map.Entry<K, V>> zzc;
    private final /* synthetic */ zzgz zzd;

    private zzhh(zzgz zzgzVar) {
        this.zzd = zzgzVar;
        this.zza = -1;
    }

    private final Iterator<Map.Entry<K, V>> zza() {
        Map map;
        if (this.zzc == null) {
            map = this.zzd.zzc;
            this.zzc = map.entrySet().iterator();
        }
        return this.zzc;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        Map map;
        int i = this.zza + 1;
        list = this.zzd.zzb;
        if (i >= list.size()) {
            map = this.zzd.zzc;
            if (map.isEmpty() || !zza().hasNext()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        List list2;
        this.zzb = true;
        int i = this.zza + 1;
        this.zza = i;
        list = this.zzd.zzb;
        if (i >= list.size()) {
            return (Map.Entry) zza().next();
        }
        list2 = this.zzd.zzb;
        return (Map.Entry) list2.get(this.zza);
    }

    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (this.zzb) {
            this.zzb = false;
            this.zzd.zzf();
            int i = this.zza;
            list = this.zzd.zzb;
            if (i < list.size()) {
                zzgz zzgzVar = this.zzd;
                int i2 = this.zza;
                this.zza = i2 - 1;
                zzgzVar.zzc(i2);
                return;
            }
            zza().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzhh(zzgz zzgzVar, zzhc zzhcVar) {
        this(zzgzVar);
    }
}

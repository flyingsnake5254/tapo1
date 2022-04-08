package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
abstract class zzl<K, V> extends zzx<K, V> implements Serializable {
    private transient Map<K, Collection<V>> zza;
    private transient int zzb;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzl(Map<K, Collection<V>> map) {
        if (map.isEmpty()) {
            this.zza = map;
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzx, com.google.android.gms.internal.mlkit_vision_barcode.zzbb
    public boolean zza(@NullableDecl K k, @NullableDecl V v) {
        Collection<V> collection = this.zza.get(k);
        if (collection == null) {
            Collection<V> zzb = zzb();
            if (zzb.add(v)) {
                this.zzb++;
                this.zza.put(k, zzb);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        } else if (!collection.add(v)) {
            return false;
        } else {
            this.zzb++;
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Collection<V> zzb();

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzbb
    public Collection<V> zzb(@NullableDecl K k) {
        Collection<V> collection = this.zza.get(k);
        if (collection == null) {
            collection = zzb();
        }
        return zza((zzl<K, V>) k, (Collection) collection);
    }

    public void zzc() {
        for (Collection<V> collection : this.zza.values()) {
            collection.clear();
        }
        this.zza.clear();
        this.zzb = 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzx
    final Set<K> zzd() {
        return new zzp(this, this.zza);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzx
    final Map<K, Collection<V>> zze() {
        return new zzk(this, this.zza);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> Iterator<E> zzb(Collection<E> collection) {
        if (collection instanceof List) {
            return ((List) collection).listIterator();
        }
        return collection.iterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzc(Object obj) {
        Collection collection = (Collection) zzas.zzc(this.zza, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.zzb -= size;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int zzb(zzl zzlVar) {
        int i = zzlVar.zzb;
        zzlVar.zzb = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int zzb(zzl zzlVar, int i) {
        int i2 = zzlVar.zzb - i;
        zzlVar.zzb = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int zzc(zzl zzlVar) {
        int i = zzlVar.zzb;
        zzlVar.zzb = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Collection<V> zza(@NullableDecl K k, Collection<V> collection) {
        return new zzq(this, k, collection, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<V> zza(@NullableDecl K k, List<V> list, @NullableDecl zzq zzqVar) {
        if (list instanceof RandomAccess) {
            return new zzr(this, k, list, zzqVar);
        }
        return new zzs(this, k, list, zzqVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int zza(zzl zzlVar, int i) {
        int i2 = zzlVar.zzb + i;
        zzlVar.zzb = i2;
        return i2;
    }
}

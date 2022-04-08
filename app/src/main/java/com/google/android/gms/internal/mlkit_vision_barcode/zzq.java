package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
public class zzq extends AbstractCollection<V> {
    @NullableDecl
    final K zza;
    Collection<V> zzb;
    @NullableDecl
    final zzq zzc;
    final /* synthetic */ zzl zzd;
    @NullableDecl
    private final Collection<V> zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [K] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.Collection<V>] */
    public zzq(@NullableDecl zzl zzlVar, K k, @NullableDecl Collection<V> collection, zzq zzqVar) {
        this.zzd = zzlVar;
        this.zza = k;
        this.zzb = collection;
        this.zzc = zzqVar;
        this.zze = zzqVar == null ? null : zzqVar.zzb;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(V v) {
        zza();
        boolean isEmpty = this.zzb.isEmpty();
        boolean add = this.zzb.add(v);
        if (add) {
            zzl.zzc(this.zzd);
            if (isEmpty) {
                zzc();
            }
        }
        return add;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends V> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = this.zzb.addAll(collection);
        if (addAll) {
            zzl.zza(this.zzd, this.zzb.size() - size);
            if (size == 0) {
                zzc();
            }
        }
        return addAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        int size = size();
        if (size != 0) {
            this.zzb.clear();
            zzl.zzb(this.zzd, size);
            zzb();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        zza();
        return this.zzb.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        zza();
        return this.zzb.containsAll(collection);
    }

    @Override // java.util.Collection
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        zza();
        return this.zzb.equals(obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        zza();
        return this.zzb.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<V> iterator() {
        zza();
        return new zzt(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        zza();
        boolean remove = this.zzb.remove(obj);
        if (remove) {
            zzl.zzb(this.zzd);
            zzb();
        }
        return remove;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean removeAll = this.zzb.removeAll(collection);
        if (removeAll) {
            zzl.zza(this.zzd, this.zzb.size() - size);
            zzb();
        }
        return removeAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        zzh.zza(collection);
        int size = size();
        boolean retainAll = this.zzb.retainAll(collection);
        if (retainAll) {
            zzl.zza(this.zzd, this.zzb.size() - size);
            zzb();
        }
        return retainAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        zza();
        return this.zzb.size();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        zza();
        return this.zzb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza() {
        Map map;
        zzq zzqVar = this.zzc;
        if (zzqVar != null) {
            zzqVar.zza();
            if (this.zzc.zzb != this.zze) {
                throw new ConcurrentModificationException();
            }
        } else if (this.zzb.isEmpty()) {
            map = this.zzd.zza;
            Collection<V> collection = (Collection) map.get(this.zza);
            if (collection != 0) {
                this.zzb = collection;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb() {
        Map map;
        zzq zzqVar = this;
        while (true) {
            zzq zzqVar2 = zzqVar.zzc;
            if (zzqVar2 == null) {
                break;
            }
            zzqVar = zzqVar2;
        }
        if (zzqVar.zzb.isEmpty()) {
            map = zzqVar.zzd.zza;
            map.remove(zzqVar.zza);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc() {
        Map map;
        zzq zzqVar = this;
        while (true) {
            zzq zzqVar2 = zzqVar.zzc;
            if (zzqVar2 != null) {
                zzqVar = zzqVar2;
            } else {
                map = zzqVar.zzd.zza;
                map.put(zzqVar.zza, zzqVar.zzb);
                return;
            }
        }
    }
}

package com.google.android.gms.internal.vision;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
public final class zzhp extends zzfc<String> implements zzho, RandomAccess {
    private static final zzhp zzyq;
    private static final zzho zzyr;
    private final List<Object> zzys;

    static {
        zzhp zzhpVar = new zzhp();
        zzyq = zzhpVar;
        zzhpVar.zzdq();
        zzyr = zzhpVar;
    }

    public zzhp() {
        this(10);
    }

    private static String zzk(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzfm) {
            return ((zzfm) obj).zzes();
        }
        return zzgy.zzh((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zzdr();
        this.zzys.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zzdr();
        this.zzys.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzys.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzfm) {
            zzfm zzfmVar = (zzfm) obj;
            String zzes = zzfmVar.zzes();
            if (zzfmVar.zzet()) {
                this.zzys.set(i, zzes);
            }
            return zzes;
        }
        byte[] bArr = (byte[]) obj;
        String zzh = zzgy.zzh(bArr);
        if (zzgy.zzg(bArr)) {
            this.zzys.set(i, zzh);
        }
        return zzh;
    }

    @Override // com.google.android.gms.internal.vision.zzho
    public final Object getRaw(int i) {
        return this.zzys.get(i);
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        zzdr();
        return zzk(this.zzys.set(i, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzys.size();
    }

    @Override // com.google.android.gms.internal.vision.zzhe
    public final /* synthetic */ zzhe zzah(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzys);
            return new zzhp(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.vision.zzho
    public final void zzc(zzfm zzfmVar) {
        zzdr();
        this.zzys.add(zzfmVar);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.vision.zzfc, com.google.android.gms.internal.vision.zzhe
    public final /* bridge */ /* synthetic */ boolean zzdp() {
        return super.zzdp();
    }

    @Override // com.google.android.gms.internal.vision.zzho
    public final List<?> zzgy() {
        return Collections.unmodifiableList(this.zzys);
    }

    @Override // com.google.android.gms.internal.vision.zzho
    public final zzho zzgz() {
        return zzdp() ? new zzjt(this) : this;
    }

    public zzhp(int i) {
        this(new ArrayList(i));
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzdr();
        if (collection instanceof zzho) {
            collection = ((zzho) collection).zzgy();
        }
        boolean addAll = this.zzys.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzdr();
        Object remove = this.zzys.remove(i);
        ((AbstractList) this).modCount++;
        return zzk(remove);
    }

    private zzhp(ArrayList<Object> arrayList) {
        this.zzys = arrayList;
    }

    @Override // com.google.android.gms.internal.vision.zzfc, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }
}

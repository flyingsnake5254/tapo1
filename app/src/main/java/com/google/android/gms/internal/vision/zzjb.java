package com.google.android.gms.internal.vision;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
public class zzjb<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private final int zzaak;
    private List<zzjg> zzaal;
    private Map<K, V> zzaam;
    private volatile zzji zzaan;
    private Map<K, V> zzaao;
    private volatile zzjc zzaap;
    private boolean zztr;

    private zzjb(int i) {
        this.zzaak = i;
        this.zzaal = Collections.emptyList();
        this.zzaam = Collections.emptyMap();
        this.zzaao = Collections.emptyMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <FieldDescriptorType extends zzgp<FieldDescriptorType>> zzjb<FieldDescriptorType, Object> zzbu(int i) {
        return new zzja(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V zzbw(int i) {
        zzib();
        V v = (V) this.zzaal.remove(i).getValue();
        if (!this.zzaam.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = zzic().entrySet().iterator();
            this.zzaal.add(new zzjg(this, it.next()));
            it.remove();
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzib() {
        if (this.zztr) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzic() {
        zzib();
        if (this.zzaam.isEmpty() && !(this.zzaam instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzaam = treeMap;
            this.zzaao = treeMap.descendingMap();
        }
        return (SortedMap) this.zzaam;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        zzib();
        if (!this.zzaal.isEmpty()) {
            this.zzaal.clear();
        }
        if (!this.zzaam.isEmpty()) {
            this.zzaam.clear();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza((zzjb<K, V>) comparable) >= 0 || this.zzaam.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzaan == null) {
            this.zzaan = new zzji(this, null);
        }
        return this.zzaan;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzjb)) {
            return super.equals(obj);
        }
        zzjb zzjbVar = (zzjb) obj;
        int size = size();
        if (size != zzjbVar.size()) {
            return false;
        }
        int zzhy = zzhy();
        if (zzhy != zzjbVar.zzhy()) {
            return entrySet().equals(zzjbVar.entrySet());
        }
        for (int i = 0; i < zzhy; i++) {
            if (!zzbv(i).equals(zzjbVar.zzbv(i))) {
                return false;
            }
        }
        if (zzhy != size) {
            return this.zzaam.equals(zzjbVar.zzaam);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza((zzjb<K, V>) comparable);
        if (zza >= 0) {
            return (V) this.zzaal.get(zza).getValue();
        }
        return this.zzaam.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int zzhy = zzhy();
        int i = 0;
        for (int i2 = 0; i2 < zzhy; i2++) {
            i += this.zzaal.get(i2).hashCode();
        }
        return this.zzaam.size() > 0 ? i + this.zzaam.hashCode() : i;
    }

    public final boolean isImmutable() {
        return this.zztr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        return zza((zzjb<K, V>) ((Comparable) obj), (Comparable) obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        zzib();
        Comparable comparable = (Comparable) obj;
        int zza = zza((zzjb<K, V>) comparable);
        if (zza >= 0) {
            return (V) zzbw(zza);
        }
        if (this.zzaam.isEmpty()) {
            return null;
        }
        return this.zzaam.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.zzaal.size() + this.zzaam.size();
    }

    public final V zza(K k, V v) {
        zzib();
        int zza = zza((zzjb<K, V>) k);
        if (zza >= 0) {
            return (V) this.zzaal.get(zza).setValue(v);
        }
        zzib();
        if (this.zzaal.isEmpty() && !(this.zzaal instanceof ArrayList)) {
            this.zzaal = new ArrayList(this.zzaak);
        }
        int i = -(zza + 1);
        if (i >= this.zzaak) {
            return zzic().put(k, v);
        }
        int size = this.zzaal.size();
        int i2 = this.zzaak;
        if (size == i2) {
            zzjg remove = this.zzaal.remove(i2 - 1);
            zzic().put((K) ((Comparable) remove.getKey()), (V) remove.getValue());
        }
        this.zzaal.add(i, new zzjg(this, k, v));
        return null;
    }

    public final Map.Entry<K, V> zzbv(int i) {
        return this.zzaal.get(i);
    }

    public void zzdq() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.zztr) {
            if (this.zzaam.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.zzaam);
            }
            this.zzaam = map;
            if (this.zzaao.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.zzaao);
            }
            this.zzaao = map2;
            this.zztr = true;
        }
    }

    public final int zzhy() {
        return this.zzaal.size();
    }

    public final Iterable<Map.Entry<K, V>> zzhz() {
        if (this.zzaam.isEmpty()) {
            return zzjf.zzie();
        }
        return this.zzaam.entrySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> zzia() {
        if (this.zzaap == null) {
            this.zzaap = new zzjc(this, null);
        }
        return this.zzaap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzjb(int i, zzja zzjaVar) {
        this(i);
    }

    private final int zza(K k) {
        int size = this.zzaal.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.zzaal.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo((Comparable) this.zzaal.get(i2).getKey());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }
}

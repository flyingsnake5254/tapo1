package com.google.android.gms.internal.measurement;

import com.github.mikephil.charting.utils.Utils;
import com.tplink.libtpmediastatistics.SSLClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
/* loaded from: classes.dex */
public final class zzae implements Iterable<zzap>, zzap, zzal {
    final SortedMap<Integer, zzap> zza;
    final Map<String, zzap> zzb;

    public zzae() {
        this.zza = new TreeMap();
        this.zzb = new TreeMap();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzae)) {
            return false;
        }
        zzae zzaeVar = (zzae) obj;
        if (zzh() != zzaeVar.zzh()) {
            return false;
        }
        if (this.zza.isEmpty()) {
            return zzaeVar.zza.isEmpty();
        }
        for (int intValue = this.zza.firstKey().intValue(); intValue <= this.zza.lastKey().intValue(); intValue++) {
            if (!zzl(intValue).equals(zzaeVar.zzl(intValue))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode() * 31;
    }

    @Override // java.lang.Iterable
    public final Iterator<zzap> iterator() {
        return new zzad(this);
    }

    public final String toString() {
        return zzs(SSLClient.COMMA);
    }

    public final List<zzap> zzb() {
        ArrayList arrayList = new ArrayList(zzh());
        for (int i = 0; i < zzh(); i++) {
            arrayList.add(zzl(i));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzbK(String str, zzg zzgVar, List<zzap> list) {
        if ("concat".equals(str) || "every".equals(str) || "filter".equals(str) || "forEach".equals(str) || "indexOf".equals(str) || "join".equals(str) || "lastIndexOf".equals(str) || "map".equals(str) || "pop".equals(str) || "push".equals(str) || "reduce".equals(str) || "reduceRight".equals(str) || "reverse".equals(str) || "shift".equals(str) || "slice".equals(str) || "some".equals(str) || "sort".equals(str) || "splice".equals(str) || "toString".equals(str) || "unshift".equals(str)) {
            return zzbb.zza(str, this, zzgVar, list);
        }
        return zzaj.zza(this, new zzat(str), zzgVar, list);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final String zzc() {
        return zzs(SSLClient.COMMA);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Double zzd() {
        if (this.zza.size() == 1) {
            return zzl(0).zzd();
        }
        if (this.zza.size() <= 0) {
            return Double.valueOf((double) Utils.DOUBLE_EPSILON);
        }
        return Double.valueOf(Double.NaN);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Boolean zze() {
        return Boolean.TRUE;
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Iterator<zzap> zzf() {
        return new zzac(this, this.zza.keySet().iterator(), this.zzb.keySet().iterator());
    }

    public final Iterator<Integer> zzg() {
        return this.zza.keySet().iterator();
    }

    public final int zzh() {
        if (this.zza.isEmpty()) {
            return 0;
        }
        return this.zza.lastKey().intValue() + 1;
    }

    public final int zzi() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzal
    public final boolean zzj(String str) {
        return "length".equals(str) || this.zzb.containsKey(str);
    }

    @Override // com.google.android.gms.internal.measurement.zzal
    public final zzap zzk(String str) {
        zzap zzapVar;
        if ("length".equals(str)) {
            return new zzah(Double.valueOf(zzh()));
        }
        return (!zzj(str) || (zzapVar = this.zzb.get(str)) == null) ? zzap.zzf : zzapVar;
    }

    public final zzap zzl(int i) {
        zzap zzapVar;
        if (i < zzh()) {
            return (!zzo(i) || (zzapVar = this.zza.get(Integer.valueOf(i))) == null) ? zzap.zzf : zzapVar;
        }
        throw new IndexOutOfBoundsException("Attempting to get element outside of current array");
    }

    @Override // com.google.android.gms.internal.measurement.zzal
    public final void zzm(String str, zzap zzapVar) {
        if (zzapVar == null) {
            this.zzb.remove(str);
        } else {
            this.zzb.put(str, zzapVar);
        }
    }

    @RequiresNonNull({"elements"})
    public final void zzn(int i, zzap zzapVar) {
        if (i > 32468) {
            throw new IllegalStateException("Array too large");
        } else if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Out of bounds index: ");
            sb.append(i);
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (zzapVar == null) {
            this.zza.remove(Integer.valueOf(i));
        } else {
            this.zza.put(Integer.valueOf(i), zzapVar);
        }
    }

    public final boolean zzo(int i) {
        if (i >= 0 && i <= this.zza.lastKey().intValue()) {
            return this.zza.containsKey(Integer.valueOf(i));
        }
        StringBuilder sb = new StringBuilder(32);
        sb.append("Out of bounds index: ");
        sb.append(i);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final void zzp() {
        this.zza.clear();
    }

    public final void zzq(int i, zzap zzapVar) {
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Invalid value index: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        } else if (i >= zzh()) {
            zzn(i, zzapVar);
        } else {
            for (int intValue = this.zza.lastKey().intValue(); intValue >= i; intValue--) {
                SortedMap<Integer, zzap> sortedMap = this.zza;
                Integer valueOf = Integer.valueOf(intValue);
                zzap zzapVar2 = sortedMap.get(valueOf);
                if (zzapVar2 != null) {
                    zzn(intValue + 1, zzapVar2);
                    this.zza.remove(valueOf);
                }
            }
            zzn(i, zzapVar);
        }
    }

    public final void zzr(int i) {
        int intValue = this.zza.lastKey().intValue();
        if (i <= intValue && i >= 0) {
            this.zza.remove(Integer.valueOf(i));
            if (i == intValue) {
                SortedMap<Integer, zzap> sortedMap = this.zza;
                int i2 = i - 1;
                Integer valueOf = Integer.valueOf(i2);
                if (!sortedMap.containsKey(valueOf) && i2 >= 0) {
                    this.zza.put(valueOf, zzap.zzf);
                    return;
                }
                return;
            }
            while (true) {
                i++;
                if (i <= this.zza.lastKey().intValue()) {
                    SortedMap<Integer, zzap> sortedMap2 = this.zza;
                    Integer valueOf2 = Integer.valueOf(i);
                    zzap zzapVar = sortedMap2.get(valueOf2);
                    if (zzapVar != null) {
                        this.zza.put(Integer.valueOf(i - 1), zzapVar);
                        this.zza.remove(valueOf2);
                    }
                } else {
                    return;
                }
            }
        }
    }

    public final String zzs(String str) {
        if (str == null) {
            str = "";
        }
        StringBuilder sb = new StringBuilder();
        if (!this.zza.isEmpty()) {
            for (int i = 0; i < zzh(); i++) {
                zzap zzl = zzl(i);
                sb.append(str);
                if (!(zzl instanceof zzau) && !(zzl instanceof zzan)) {
                    sb.append(zzl.zzc());
                }
            }
            sb.delete(0, str.length());
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzt() {
        zzae zzaeVar = new zzae();
        for (Map.Entry<Integer, zzap> entry : this.zza.entrySet()) {
            if (entry.getValue() instanceof zzal) {
                zzaeVar.zza.put(entry.getKey(), entry.getValue());
            } else {
                zzaeVar.zza.put(entry.getKey(), entry.getValue().zzt());
            }
        }
        return zzaeVar;
    }

    public zzae(List<zzap> list) {
        this();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                zzn(i, list.get(i));
            }
        }
    }
}

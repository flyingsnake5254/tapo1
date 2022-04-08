package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
final class zziy {
    private static final Class<?> zzaag = zzhw();
    private static final zzjo<?, ?> zzaah = zzn(false);
    private static final zzjo<?, ?> zzaai = zzn(true);
    private static final zzjo<?, ?> zzaaj = new zzjq();

    public static void zza(int i, List<Double> list, zzkl zzklVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzklVar.zzg(i, list, z);
        }
    }

    public static void zzb(int i, List<Float> list, zzkl zzklVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzklVar.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzkl zzklVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzklVar.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzkl zzklVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzklVar.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzkl zzklVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzklVar.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzkl zzklVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzklVar.zze(i, list, z);
        }
    }

    public static void zzg(Class<?> cls) {
        Class<?> cls2;
        if (!zzgx.class.isAssignableFrom(cls) && (cls2 = zzaag) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzh(int i, List<Integer> list, zzkl zzklVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzklVar.zza(i, list, z);
        }
    }

    public static zzjo<?, ?> zzht() {
        return zzaah;
    }

    public static zzjo<?, ?> zzhu() {
        return zzaai;
    }

    public static zzjo<?, ?> zzhv() {
        return zzaaj;
    }

    private static Class<?> zzhw() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzhx() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zzi(int i, List<Integer> list, zzkl zzklVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzklVar.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzkl zzklVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzklVar.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzkl zzklVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzklVar.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzkl zzklVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzklVar.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzkl zzklVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzklVar.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzkl zzklVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzklVar.zzi(i, list, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzo(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzq(list) + (list.size() * zzgf.zzbb(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzp(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzr(list) + (size * zzgf.zzbb(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzq(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhv) {
            zzhv zzhvVar = (zzhv) list;
            i = 0;
            while (i2 < size) {
                i += zzgf.zzv(zzhvVar.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzgf.zzv(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzr(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhv) {
            zzhv zzhvVar = (zzhv) list;
            i = 0;
            while (i2 < size) {
                i += zzgf.zzw(zzhvVar.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzgf.zzw(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzs(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhv) {
            zzhv zzhvVar = (zzhv) list;
            i = 0;
            while (i2 < size) {
                i += zzgf.zzx(zzhvVar.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzgf.zzx(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzt(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgz) {
            zzgz zzgzVar = (zzgz) list;
            i = 0;
            while (i2 < size) {
                i += zzgf.zzbh(zzgzVar.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzgf.zzbh(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzu(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgz) {
            zzgz zzgzVar = (zzgz) list;
            i = 0;
            while (i2 < size) {
                i += zzgf.zzbc(zzgzVar.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzgf.zzbc(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzv(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgz) {
            zzgz zzgzVar = (zzgz) list;
            i = 0;
            while (i2 < size) {
                i += zzgf.zzbd(zzgzVar.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzgf.zzbd(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzw(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgz) {
            zzgz zzgzVar = (zzgz) list;
            i = 0;
            while (i2 < size) {
                i += zzgf.zzbe(zzgzVar.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzgf.zzbe(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzx(List<?> list) {
        return list.size() << 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzy(List<?> list) {
        return list.size() << 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzz(List<?> list) {
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzgf.zzb(i, true);
    }

    public static void zza(int i, List<String> list, zzkl zzklVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzklVar.zza(i, list);
        }
    }

    public static void zzb(int i, List<zzfm> list, zzkl zzklVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzklVar.zzb(i, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzbb = zzgf.zzbb(i) * size;
        if (list instanceof zzho) {
            zzho zzhoVar = (zzho) list;
            while (i4 < size) {
                Object raw = zzhoVar.getRaw(i4);
                if (raw instanceof zzfm) {
                    i3 = zzgf.zzb((zzfm) raw);
                } else {
                    i3 = zzgf.zzy((String) raw);
                }
                zzbb += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzfm) {
                    i2 = zzgf.zzb((zzfm) obj);
                } else {
                    i2 = zzgf.zzy((String) obj);
                }
                zzbb += i2;
                i4++;
            }
        }
        return zzbb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(int i, List<zzfm> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzbb = size * zzgf.zzbb(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzbb += zzgf.zzb(list.get(i2));
        }
        return zzbb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zze(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    private static zzjo<?, ?> zzn(boolean z) {
        try {
            Class<?> zzhx = zzhx();
            if (zzhx == null) {
                return null;
            }
            return (zzjo) zzhx.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zzg(int i, List<Long> list, zzkl zzklVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzklVar.zzl(i, list, z);
        }
    }

    public static void zza(int i, List<?> list, zzkl zzklVar, zziw zziwVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzklVar.zza(i, list, zziwVar);
        }
    }

    public static void zzb(int i, List<?> list, zzkl zzklVar, zziw zziwVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzklVar.zzb(i, list, zziwVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzq(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzs(list) + (size * zzgf.zzbb(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzr(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzt(list) + (size * zzgf.zzbb(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzs(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzu(list) + (size * zzgf.zzbb(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzt(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzv(list) + (size * zzgf.zzbb(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzu(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzw(list) + (size * zzgf.zzbb(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzgf.zzo(i, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzgf.zzg(i, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void zza(zzia zziaVar, T t, T t2, long j) {
        zzju.zza(t, j, zziaVar.zzc(zzju.zzp(t, j), zzju.zzp(t2, j)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(int i, List<zzih> list, zziw zziwVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzgf.zzc(i, list.get(i3), zziwVar);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends zzgp<FT>> void zza(zzgk<FT> zzgkVar, T t, T t2) {
        zzgn<FT> zzf = zzgkVar.zzf(t2);
        if (!zzf.zztq.isEmpty()) {
            zzgkVar.zzg(t).zza(zzf);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void zza(zzjo<UT, UB> zzjoVar, T t, T t2) {
        zzjoVar.zzf(t, zzjoVar.zzh(zzjoVar.zzw(t), zzjoVar.zzw(t2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(int i, Object obj, zziw zziwVar) {
        if (obj instanceof zzhm) {
            return zzgf.zza(i, (zzhm) obj);
        }
        return zzgf.zzb(i, (zzih) obj, zziwVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB zza(int i, List<Integer> list, zzha<?> zzhaVar, UB ub, zzjo<UT, UB> zzjoVar) {
        if (zzhaVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzhaVar.zzh(intValue) != null) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = (UB) zza(i, intValue, ub, zzjoVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (zzhaVar.zzh(intValue2) == null) {
                    ub = (UB) zza(i, intValue2, ub, zzjoVar);
                    it.remove();
                }
            }
        }
        return ub;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(int i, List<?> list, zziw zziwVar) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzbb = zzgf.zzbb(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzhm) {
                i2 = zzgf.zza((zzhm) obj);
            } else {
                i2 = zzgf.zza((zzih) obj, zziwVar);
            }
            zzbb += i2;
        }
        return zzbb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB zza(int i, List<Integer> list, zzhd zzhdVar, UB ub, zzjo<UT, UB> zzjoVar) {
        if (zzhdVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzhdVar.zzg(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = (UB) zza(i, intValue, ub, zzjoVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzhdVar.zzg(intValue2)) {
                    ub = (UB) zza(i, intValue2, ub, zzjoVar);
                    it.remove();
                }
            }
        }
        return ub;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB zza(int i, int i2, UB ub, zzjo<UT, UB> zzjoVar) {
        if (ub == null) {
            ub = zzjoVar.zzig();
        }
        zzjoVar.zza((zzjo<UT, UB>) ub, i, i2);
        return ub;
    }
}

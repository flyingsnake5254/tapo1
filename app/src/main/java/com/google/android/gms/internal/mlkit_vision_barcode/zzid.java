package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.IOException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
public final class zzid {
    private static final Class<?> zza = zzd();
    private static final zzit<?, ?> zzb = zza(false);
    private static final zzit<?, ?> zzc = zza(true);
    private static final zzit<?, ?> zzd = new zziv();

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzga.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzb(int i, List<Float> list, zzjn zzjnVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjnVar.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzjn zzjnVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjnVar.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzjn zzjnVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjnVar.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzjn zzjnVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjnVar.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzjn zzjnVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjnVar.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzjn zzjnVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjnVar.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzjn zzjnVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjnVar.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzjn zzjnVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjnVar.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzjn zzjnVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjnVar.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzjn zzjnVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjnVar.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzjn zzjnVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjnVar.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzjn zzjnVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjnVar.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzjn zzjnVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjnVar.zzi(i, list, z);
        }
    }

    public static void zzb(int i, List<zzew> list, zzjn zzjnVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjnVar.zzb(i, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgy) {
            zzgy zzgyVar = (zzgy) list;
            i = 0;
            while (i2 < size) {
                i += zzfn.zzf(zzgyVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzfn.zzf(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgd) {
            zzgd zzgdVar = (zzgd) list;
            i = 0;
            while (i2 < size) {
                i += zzfn.zzk(zzgdVar.zzc(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzfn.zzk(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgd) {
            zzgd zzgdVar = (zzgd) list;
            i = 0;
            while (i2 < size) {
                i += zzfn.zzf(zzgdVar.zzc(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzfn.zzf(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgd) {
            zzgd zzgdVar = (zzgd) list;
            i = 0;
            while (i2 < size) {
                i += zzfn.zzg(zzgdVar.zzc(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzfn.zzg(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgd) {
            zzgd zzgdVar = (zzgd) list;
            i = 0;
            while (i2 < size) {
                i += zzfn.zzh(zzgdVar.zzc(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzfn.zzh(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(List<?> list) {
        return list.size() << 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(List<?> list) {
        return list.size() << 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(List<?> list) {
        return list.size();
    }

    public static void zza(int i, List<Double> list, zzjn zzjnVar, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjnVar.zzg(i, list, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzfn.zzi(i, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzfn.zzg(i, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzfn.zzb(i, true);
    }

    public static void zzb(int i, List<?> list, zzjn zzjnVar, zzib zzibVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjnVar.zzb(i, list, zzibVar);
        }
    }

    public static void zza(int i, List<String> list, zzjn zzjnVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjnVar.zza(i, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgy) {
            zzgy zzgyVar = (zzgy) list;
            i = 0;
            while (i2 < size) {
                i += zzfn.zze(zzgyVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzfn.zze(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static void zza(int i, List<?> list, zzjn zzjnVar, zzib zzibVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjnVar.zza(i, list, zzibVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzc(list) + (size * zzfn.zze(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzfn.zze(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzfn.zze(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzf(list) + (size * zzfn.zze(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzfn.zze(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgy) {
            zzgy zzgyVar = (zzgy) list;
            i = 0;
            while (i2 < size) {
                i += zzfn.zzd(zzgyVar.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzfn.zzd(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zzit<?, ?> zzc() {
        return zzd;
    }

    private static Class<?> zzd() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zze() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzfn.zze(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zza(list) + (list.size() * zzfn.zze(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i, List<zzew> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = size * zzfn.zze(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zze += zzfn.zzb(list.get(i2));
        }
        return zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zze = zzfn.zze(i) * size;
        if (list instanceof zzgv) {
            zzgv zzgvVar = (zzgv) list;
            while (i4 < size) {
                Object zzb2 = zzgvVar.zzb(i4);
                if (zzb2 instanceof zzew) {
                    i3 = zzfn.zzb((zzew) zzb2);
                } else {
                    i3 = zzfn.zzb((String) zzb2);
                }
                zze += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzew) {
                    i2 = zzfn.zzb((zzew) obj);
                } else {
                    i2 = zzfn.zzb((String) obj);
                }
                zze += i2;
                i4++;
            }
        }
        return zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i, List<zzhk> list, zzib zzibVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzfn.zzc(i, list.get(i3), zzibVar);
        }
        return i2;
    }

    public static zzit<?, ?> zzb() {
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, Object obj, zzib zzibVar) {
        if (obj instanceof zzgt) {
            return zzfn.zza(i, (zzgt) obj);
        }
        return zzfn.zzb(i, (zzhk) obj, zzibVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i, List<?> list, zzib zzibVar) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = zzfn.zze(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzgt) {
                i2 = zzfn.zza((zzgt) obj);
            } else {
                i2 = zzfn.zza((zzhk) obj, zzibVar);
            }
            zze += i2;
        }
        return zze;
    }

    public static zzit<?, ?> zza() {
        return zzb;
    }

    private static zzit<?, ?> zza(boolean z) {
        try {
            Class<?> zze = zze();
            if (zze == null) {
                return null;
            }
            return (zzit) zze.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void zza(zzhh zzhhVar, T t, T t2, long j) {
        zziz.zza(t, j, zzhhVar.zza(zziz.zzf(t, j), zziz.zzf(t2, j)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends zzfu<FT>> void zza(zzfr<FT> zzfrVar, T t, T t2) {
        zzfs<FT> zza2 = zzfrVar.zza(t2);
        if (!zza2.zza.isEmpty()) {
            zzfrVar.zzb(t).zza(zza2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void zza(zzit<UT, UB> zzitVar, T t, T t2) {
        zzitVar.zza(t, zzitVar.zzb(zzitVar.zza(t), zzitVar.zza(t2)));
    }
}

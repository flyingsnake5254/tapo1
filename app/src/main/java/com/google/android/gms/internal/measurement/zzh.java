package com.google.android.gms.internal.measurement;

import com.github.mikephil.charting.utils.Utils;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
/* loaded from: classes.dex */
public final class zzh {
    public static void zza(String str, int i, List<zzap> list) {
        if (list.size() != i) {
            throw new IllegalArgumentException(String.format("%s operation requires %s parameters found %s", str, Integer.valueOf(i), Integer.valueOf(list.size())));
        }
    }

    public static void zzb(String str, int i, List<zzap> list) {
        if (list.size() < i) {
            throw new IllegalArgumentException(String.format("%s operation requires at least %s parameters found %s", str, Integer.valueOf(i), Integer.valueOf(list.size())));
        }
    }

    public static void zzc(String str, int i, List<zzap> list) {
        if (list.size() > i) {
            throw new IllegalArgumentException(String.format("%s operation requires at most %s parameters found %s", str, Integer.valueOf(i), Integer.valueOf(list.size())));
        }
    }

    public static boolean zzd(zzap zzapVar) {
        if (zzapVar == null) {
            return false;
        }
        Double zzd = zzapVar.zzd();
        return !zzd.isNaN() && zzd.doubleValue() >= Utils.DOUBLE_EPSILON && zzd.equals(Double.valueOf(Math.floor(zzd.doubleValue())));
    }

    public static zzbl zze(String str) {
        zzbl zzblVar = null;
        if (str != null && !str.isEmpty()) {
            zzblVar = zzbl.zza(Integer.parseInt(str));
        }
        if (zzblVar != null) {
            return zzblVar;
        }
        throw new IllegalArgumentException(String.format("Unsupported commandId %s", str));
    }

    public static boolean zzf(zzap zzapVar, zzap zzapVar2) {
        if (!zzapVar.getClass().equals(zzapVar2.getClass())) {
            return false;
        }
        if ((zzapVar instanceof zzau) || (zzapVar instanceof zzan)) {
            return true;
        }
        if (zzapVar instanceof zzah) {
            if (Double.isNaN(zzapVar.zzd().doubleValue()) || Double.isNaN(zzapVar2.zzd().doubleValue())) {
                return false;
            }
            return zzapVar.zzd().equals(zzapVar2.zzd());
        } else if (zzapVar instanceof zzat) {
            return zzapVar.zzc().equals(zzapVar2.zzc());
        } else {
            if (zzapVar instanceof zzaf) {
                return zzapVar.zze().equals(zzapVar2.zze());
            }
            return zzapVar == zzapVar2;
        }
    }

    public static int zzg(double d2) {
        int i;
        if (Double.isNaN(d2) || Double.isInfinite(d2) || d2 == Utils.DOUBLE_EPSILON) {
            return 0;
        }
        return (int) (((i > 0 ? 1 : -1) * Math.floor(Math.abs(d2))) % 4.294967296E9d);
    }

    public static long zzh(double d2) {
        return zzg(d2) & 4294967295L;
    }

    public static double zzi(double d2) {
        int i;
        if (Double.isNaN(d2)) {
            return Utils.DOUBLE_EPSILON;
        }
        if (Double.isInfinite(d2) || d2 == Utils.DOUBLE_EPSILON || i == 0) {
            return d2;
        }
        return (i > 0 ? 1 : -1) * Math.floor(Math.abs(d2));
    }

    public static Object zzj(zzap zzapVar) {
        if (zzap.zzg.equals(zzapVar)) {
            return null;
        }
        if (zzap.zzf.equals(zzapVar)) {
            return "";
        }
        if (!zzapVar.zzd().isNaN()) {
            return zzapVar.zzd();
        }
        return zzapVar.zzc();
    }

    public static int zzk(zzg zzgVar) {
        int zzg = zzg(zzgVar.zzh("runtime.counter").zzd().doubleValue() + 1.0d);
        if (zzg <= 1000000) {
            zzgVar.zze("runtime.counter", new zzah(Double.valueOf(zzg)));
            return zzg;
        }
        throw new IllegalStateException("Instructions allowed exceeded");
    }
}

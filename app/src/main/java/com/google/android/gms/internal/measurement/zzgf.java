package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
/* loaded from: classes.dex */
public final class zzgf extends zzkd<zzgf, zzge> implements zzlj {
    private static final zzgf zzg;
    private int zza;
    private int zze;
    private zzkj zzf = zzkd.zzbC();

    static {
        zzgf zzgfVar = new zzgf();
        zzg = zzgfVar;
        zzkd.zzby(zzgf.class, zzgfVar);
    }

    private zzgf() {
    }

    public static zzge zzf() {
        return zzg.zzbt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzh(zzgf zzgfVar, int i) {
        zzgfVar.zza |= 1;
        zzgfVar.zze = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzi(zzgf zzgfVar, Iterable iterable) {
        zzkj zzkjVar = zzgfVar.zzf;
        if (!zzkjVar.zza()) {
            zzgfVar.zzf = zzkd.zzbD(zzkjVar);
        }
        zzio.zzbs(iterable, zzgfVar.zzf);
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final int zzb() {
        return this.zze;
    }

    public final List<Long> zzc() {
        return this.zzf;
    }

    public final int zzd() {
        return this.zzf.size();
    }

    public final long zze(int i) {
        return this.zzf.zzc(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkd
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzkd.zzbz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zza", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzgf();
        }
        if (i2 == 4) {
            return new zzge(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzg;
    }
}

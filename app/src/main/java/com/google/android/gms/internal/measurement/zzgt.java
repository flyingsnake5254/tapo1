package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
/* loaded from: classes.dex */
public final class zzgt extends zzkd<zzgt, zzgp> implements zzlj {
    private static final zzgt zzk;
    private int zza;
    private int zze;
    private zzkk<zzgt> zzf = zzkd.zzbE();
    private String zzg = "";
    private String zzh = "";
    private boolean zzi;
    private double zzj;

    static {
        zzgt zzgtVar = new zzgt();
        zzk = zzgtVar;
        zzkd.zzby(zzgt.class, zzgtVar);
    }

    private zzgt() {
    }

    public final zzgs zza() {
        zzgs zza = zzgs.zza(this.zze);
        return zza == null ? zzgs.UNKNOWN : zza;
    }

    public final List<zzgt> zzb() {
        return this.zzf;
    }

    public final String zzc() {
        return this.zzg;
    }

    public final boolean zzd() {
        return (this.zza & 4) != 0;
    }

    public final String zze() {
        return this.zzh;
    }

    public final boolean zzf() {
        return (this.zza & 8) != 0;
    }

    public final boolean zzg() {
        return this.zzi;
    }

    public final boolean zzh() {
        return (this.zza & 16) != 0;
    }

    public final double zzi() {
        return this.zzj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkd
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzkd.zzbz(zzk, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဇ\u0003\u0006က\u0004", new Object[]{"zza", "zze", zzgs.zzb(), "zzf", zzgt.class, "zzg", "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzgt();
        }
        if (i2 == 4) {
            return new zzgp(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzk;
    }
}

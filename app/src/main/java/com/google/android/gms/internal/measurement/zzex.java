package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
/* loaded from: classes.dex */
public final class zzex extends zzkd<zzex, zzet> implements zzlj {
    private static final zzex zzi;
    private int zza;
    private int zze;
    private boolean zzg;
    private String zzf = "";
    private zzkk<String> zzh = zzkd.zzbE();

    static {
        zzex zzexVar = new zzex();
        zzi = zzexVar;
        zzkd.zzby(zzex.class, zzexVar);
    }

    private zzex() {
    }

    public static zzex zzi() {
        return zzi;
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final zzew zzb() {
        zzew zza = zzew.zza(this.zze);
        return zza == null ? zzew.UNKNOWN_MATCH_TYPE : zza;
    }

    public final boolean zzc() {
        return (this.zza & 2) != 0;
    }

    public final String zzd() {
        return this.zzf;
    }

    public final boolean zze() {
        return (this.zza & 4) != 0;
    }

    public final boolean zzf() {
        return this.zzg;
    }

    public final List<String> zzg() {
        return this.zzh;
    }

    public final int zzh() {
        return this.zzh.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkd
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzkd.zzbz(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zza", "zze", zzew.zzb(), "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzex();
        }
        if (i2 == 4) {
            return new zzet(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzi;
    }
}

package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
/* loaded from: classes.dex */
public final class zzgb extends zzkd<zzgb, zzfx> implements zzlj {
    private static final zzgb zzg;
    private int zza;
    private int zze = 1;
    private zzkk<zzfq> zzf = zzkd.zzbE();

    static {
        zzgb zzgbVar = new zzgb();
        zzg = zzgbVar;
        zzkd.zzby(zzgb.class, zzgbVar);
    }

    private zzgb() {
    }

    public static zzfx zza() {
        return zzg.zzbt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzc(zzgb zzgbVar, zzfq zzfqVar) {
        zzfqVar.getClass();
        zzkk<zzfq> zzkkVar = zzgbVar.zzf;
        if (!zzkkVar.zza()) {
            zzgbVar.zzf = zzkd.zzbF(zzkkVar);
        }
        zzgbVar.zzf.add(zzfqVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkd
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzkd.zzbz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zza", "zze", zzga.zzb(), "zzf", zzfq.class});
        }
        if (i2 == 3) {
            return new zzgb();
        }
        if (i2 == 4) {
            return new zzfx(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzg;
    }
}

package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
/* loaded from: classes.dex */
public final class zzfu extends zzkd<zzfu, zzft> implements zzlj {
    private static final zzfu zze;
    private zzkk<zzfw> zza = zzkd.zzbE();

    static {
        zzfu zzfuVar = new zzfu();
        zze = zzfuVar;
        zzkd.zzby(zzfu.class, zzfuVar);
    }

    private zzfu() {
    }

    public static zzft zzc() {
        return zze.zzbt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zze(zzfu zzfuVar, zzfw zzfwVar) {
        zzfwVar.getClass();
        zzkk<zzfw> zzkkVar = zzfuVar.zza;
        if (!zzkkVar.zza()) {
            zzfuVar.zza = zzkd.zzbF(zzkkVar);
        }
        zzfuVar.zza.add(zzfwVar);
    }

    public final List<zzfw> zza() {
        return this.zza;
    }

    public final zzfw zzb(int i) {
        return this.zza.get(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkd
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzkd.zzbz(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zza", zzfw.class});
        }
        if (i2 == 3) {
            return new zzfu();
        }
        if (i2 == 4) {
            return new zzft(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zze;
    }
}

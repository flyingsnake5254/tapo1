package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
/* loaded from: classes.dex */
public final class zzgk extends zzkd<zzgk, zzgj> implements zzlj {
    private static final zzgk zze;
    private zzkk<zzgm> zza = zzkd.zzbE();

    static {
        zzgk zzgkVar = new zzgk();
        zze = zzgkVar;
        zzkd.zzby(zzgk.class, zzgkVar);
    }

    private zzgk() {
    }

    public static zzgk zzc() {
        return zze;
    }

    public final List<zzgm> zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zza.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkd
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzkd.zzbz(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zza", zzgm.class});
        }
        if (i2 == 3) {
            return new zzgk();
        }
        if (i2 == 4) {
            return new zzgj(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zze;
    }
}

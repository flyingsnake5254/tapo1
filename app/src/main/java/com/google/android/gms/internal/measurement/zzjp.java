package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@19.0.0 */
/* loaded from: classes.dex */
public final class zzjp {
    static final zzjp zza = new zzjp(true);
    private static volatile boolean zzb = false;
    private static volatile zzjp zzc;
    private static volatile zzjp zzd;
    private final Map<zzjo, zzkb<?, ?>> zze;

    zzjp() {
        this.zze = new HashMap();
    }

    public static zzjp zza() {
        zzjp zzjpVar = zzc;
        if (zzjpVar == null) {
            synchronized (zzjp.class) {
                zzjpVar = zzc;
                if (zzjpVar == null) {
                    zzjpVar = zza;
                    zzc = zzjpVar;
                }
            }
        }
        return zzjpVar;
    }

    public static zzjp zzb() {
        zzjp zzjpVar = zzd;
        if (zzjpVar != null) {
            return zzjpVar;
        }
        synchronized (zzjp.class) {
            zzjp zzjpVar2 = zzd;
            if (zzjpVar2 != null) {
                return zzjpVar2;
            }
            zzjp zzb2 = zzjx.zzb(zzjp.class);
            zzd = zzb2;
            return zzb2;
        }
    }

    public final <ContainingType extends zzli> zzkb<ContainingType, ?> zzc(ContainingType containingtype, int i) {
        return (zzkb<ContainingType, ?>) this.zze.get(new zzjo(containingtype, i));
    }

    zzjp(boolean z) {
        this.zze = Collections.emptyMap();
    }
}

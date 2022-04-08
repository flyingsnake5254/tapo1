package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgx;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
public class zzgi {
    private static volatile boolean zztk = false;
    private static boolean zztl = true;
    private static volatile zzgi zztm;
    private static volatile zzgi zztn;
    private static final zzgi zzto = new zzgi(true);
    private final Map<zza, zzgx.zzg<?, ?>> zztp;

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    /* loaded from: classes.dex */
    static final class zza {
        private final int number;
        private final Object object;

        zza(Object obj, int i) {
            this.object = obj;
            this.number = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            return this.object == zzaVar.object && this.number == zzaVar.number;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }
    }

    zzgi() {
        this.zztp = new HashMap();
    }

    public static zzgi zzfl() {
        return new zzgi();
    }

    public static zzgi zzfm() {
        zzgi zzgiVar = zztm;
        if (zzgiVar == null) {
            synchronized (zzgi.class) {
                zzgiVar = zztm;
                if (zzgiVar == null) {
                    zzgiVar = zzto;
                    zztm = zzgiVar;
                }
            }
        }
        return zzgiVar;
    }

    public static zzgi zzfn() {
        zzgi zzgiVar = zztn;
        if (zzgiVar != null) {
            return zzgiVar;
        }
        synchronized (zzgi.class) {
            zzgi zzgiVar2 = zztn;
            if (zzgiVar2 != null) {
                return zzgiVar2;
            }
            zzgi zzc = zzgw.zzc(zzgi.class);
            zztn = zzc;
            return zzc;
        }
    }

    public final <ContainingType extends zzih> zzgx.zzg<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzgx.zzg<ContainingType, ?>) this.zztp.get(new zza(containingtype, i));
    }

    private zzgi(boolean z) {
        this.zztp = Collections.emptyMap();
    }

    public final void zza(zzgx.zzg<?, ?> zzgVar) {
        this.zztp.put(new zza(zzgVar.zzxo, zzgVar.zzxq.number), zzgVar);
    }
}

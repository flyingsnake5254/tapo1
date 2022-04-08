package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@19.0.0 */
/* loaded from: classes.dex */
final class zzld {
    public static final int zza(int i, Object obj, Object obj2) {
        zzlc zzlcVar = (zzlc) obj;
        zzlb zzlbVar = (zzlb) obj2;
        if (zzlcVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzlcVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzlc zzlcVar = (zzlc) obj;
        zzlc zzlcVar2 = (zzlc) obj2;
        if (!zzlcVar2.isEmpty()) {
            if (!zzlcVar.zze()) {
                zzlcVar = zzlcVar.zzc();
            }
            zzlcVar.zzb(zzlcVar2);
        }
        return zzlcVar;
    }
}

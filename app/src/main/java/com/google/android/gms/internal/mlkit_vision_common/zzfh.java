package com.google.android.gms.internal.mlkit_vision_common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes.dex */
final class zzfh extends zzff {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzfh() {
        super();
    }

    private static <E> List<E> zzb(Object obj, long j) {
        return (List) zzhg.zzf(obj, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzff
    final void zza(Object obj, long j) {
        Object obj2;
        List list = (List) zzhg.zzf(obj, j);
        if (list instanceof zzfc) {
            obj2 = ((zzfc) list).a_();
        } else if (!zza.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzge) || !(list instanceof zzes)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzes zzesVar = (zzes) list;
                if (zzesVar.zza()) {
                    zzesVar.b_();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zzhg.zza(obj, j, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.mlkit_vision_common.zzff
    final <E> void zza(Object obj, Object obj2, long j) {
        List list;
        zzfd zzfdVar;
        List list2;
        List zzb = zzb(obj2, j);
        int size = zzb.size();
        List zzb2 = zzb(obj, j);
        if (zzb2.isEmpty()) {
            if (zzb2 instanceof zzfc) {
                list2 = new zzfd(size);
            } else if (!(zzb2 instanceof zzge) || !(zzb2 instanceof zzes)) {
                list2 = new ArrayList(size);
            } else {
                list2 = ((zzes) zzb2).zzb(size);
            }
            zzhg.zza(obj, j, list2);
            list = list2;
        } else {
            if (zza.isAssignableFrom(zzb2.getClass())) {
                ArrayList arrayList = new ArrayList(zzb2.size() + size);
                arrayList.addAll(zzb2);
                zzhg.zza(obj, j, arrayList);
                zzfdVar = arrayList;
            } else if (zzb2 instanceof zzhf) {
                zzfd zzfdVar2 = new zzfd(zzb2.size() + size);
                zzfdVar2.addAll((zzhf) zzb2);
                zzhg.zza(obj, j, zzfdVar2);
                zzfdVar = zzfdVar2;
            } else {
                boolean z = zzb2 instanceof zzge;
                list = zzb2;
                if (z) {
                    boolean z2 = zzb2 instanceof zzes;
                    list = zzb2;
                    if (z2) {
                        zzes zzesVar = (zzes) zzb2;
                        list = zzb2;
                        if (!zzesVar.zza()) {
                            zzes<E> zzb3 = zzesVar.zzb(zzb2.size() + size);
                            zzhg.zza(obj, j, zzb3);
                            list = zzb3;
                        }
                    }
                }
            }
            list = zzfdVar;
        }
        int size2 = list.size();
        int size3 = zzb.size();
        if (size2 > 0 && size3 > 0) {
            list.addAll(zzb);
        }
        if (size2 > 0) {
            zzb = list;
        }
        zzhg.zza(obj, j, zzb);
    }
}

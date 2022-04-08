package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@19.0.0 */
/* loaded from: classes.dex */
final class zzku extends zzkw {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzku() {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzku(zzkt zzktVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzkw
    final void zza(Object obj, long j) {
        Object obj2;
        List list = (List) zzmr.zzn(obj, j);
        if (list instanceof zzks) {
            obj2 = ((zzks) list).zzi();
        } else if (!zza.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzlp) || !(list instanceof zzkk)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzkk zzkkVar = (zzkk) list;
                if (zzkkVar.zza()) {
                    zzkkVar.zzb();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zzmr.zzo(obj, j, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzkw
    final <E> void zzb(Object obj, Object obj2, long j) {
        List list;
        zzkr zzkrVar;
        List list2;
        List list3 = (List) zzmr.zzn(obj2, j);
        int size = list3.size();
        List list4 = (List) zzmr.zzn(obj, j);
        if (list4.isEmpty()) {
            if (list4 instanceof zzks) {
                list2 = new zzkr(size);
            } else if (!(list4 instanceof zzlp) || !(list4 instanceof zzkk)) {
                list2 = new ArrayList(size);
            } else {
                list2 = ((zzkk) list4).zze(size);
            }
            zzmr.zzo(obj, j, list2);
            list = list2;
        } else {
            if (zza.isAssignableFrom(list4.getClass())) {
                ArrayList arrayList = new ArrayList(list4.size() + size);
                arrayList.addAll(list4);
                zzmr.zzo(obj, j, arrayList);
                zzkrVar = arrayList;
            } else if (list4 instanceof zzmm) {
                zzkr zzkrVar2 = new zzkr(list4.size() + size);
                zzkrVar2.addAll(zzkrVar2.size(), (zzmm) list4);
                zzmr.zzo(obj, j, zzkrVar2);
                zzkrVar = zzkrVar2;
            } else {
                boolean z = list4 instanceof zzlp;
                list = list4;
                if (z) {
                    boolean z2 = list4 instanceof zzkk;
                    list = list4;
                    if (z2) {
                        zzkk zzkkVar = (zzkk) list4;
                        list = list4;
                        if (!zzkkVar.zza()) {
                            zzkk<E> zze = zzkkVar.zze(list4.size() + size);
                            zzmr.zzo(obj, j, zze);
                            list = zze;
                        }
                    }
                }
            }
            list = zzkrVar;
        }
        int size2 = list.size();
        int size3 = list3.size();
        if (size2 > 0 && size3 > 0) {
            list.addAll(list3);
        }
        if (size2 > 0) {
            list3 = list;
        }
        zzmr.zzo(obj, j, list3);
    }
}

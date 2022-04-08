package com.google.android.gms.internal.vision;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
final class zzja extends zzjb<FieldDescriptorType, Object> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzja(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.vision.zzjb
    public final void zzdq() {
        if (!isImmutable()) {
            for (int i = 0; i < zzhy(); i++) {
                Map.Entry<FieldDescriptorType, Object> zzbv = zzbv(i);
                if (((zzgp) zzbv.getKey()).zzfv()) {
                    zzbv.setValue(Collections.unmodifiableList((List) zzbv.getValue()));
                }
            }
            Iterator it = zzhz().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (((zzgp) entry.getKey()).zzfv()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzdq();
    }
}

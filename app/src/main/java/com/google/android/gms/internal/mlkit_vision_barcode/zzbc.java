package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Iterator;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
public final class zzbc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(Set<?> set, Iterator<?> it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= set.remove(it.next());
        }
        return z;
    }
}

package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
public final class zzab {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(Collection<?> collection, @NullableDecl Object obj) {
        zzh.zza(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }
}

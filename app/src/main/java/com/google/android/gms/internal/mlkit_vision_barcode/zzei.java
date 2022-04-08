package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.mlkit.common.sdkinternal.m;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
final /* synthetic */ class zzei implements Callable {
    private final m zza;

    private zzei(m mVar) {
        this.zza = mVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Callable zza(m mVar) {
        return new zzei(mVar);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.zza.a();
    }
}

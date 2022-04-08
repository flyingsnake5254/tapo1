package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.mlkit.common.sdkinternal.f;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class zzej implements Callable {
    static final Callable zza = new zzej();

    private zzej() {
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String b2;
        b2 = f.a().b("barcode-scanning-internal");
        return b2;
    }
}

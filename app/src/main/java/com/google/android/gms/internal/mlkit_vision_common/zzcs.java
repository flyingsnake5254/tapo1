package com.google.android.gms.internal.mlkit_vision_common;

import com.google.mlkit.common.sdkinternal.m;
import java.util.concurrent.Callable;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes.dex */
final /* synthetic */ class zzcs implements Callable {
    private final m zza;

    private zzcs(m mVar) {
        this.zza = mVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Callable zza(m mVar) {
        return new zzcs(mVar);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.zza.a();
    }
}

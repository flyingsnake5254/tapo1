package com.google.firebase.analytics;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.measurement.zzee;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement-api@@19.0.0 */
/* loaded from: classes2.dex */
final class zzb implements Callable<String> {
    final /* synthetic */ FirebaseAnalytics zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzb(FirebaseAnalytics firebaseAnalytics) {
        this.zza = firebaseAnalytics;
    }

    @Override // java.util.concurrent.Callable
    @Nullable
    public final /* bridge */ /* synthetic */ String call() throws Exception {
        zzee zzeeVar;
        zzeeVar = this.zza.zzb;
        return zzeeVar.zzF();
    }
}

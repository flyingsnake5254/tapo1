package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
/* loaded from: classes.dex */
final class zzjo implements Runnable {
    final /* synthetic */ zzkn zza;
    final /* synthetic */ Runnable zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjo(zzjq zzjqVar, zzkn zzknVar, Runnable runnable) {
        this.zza = zzknVar;
        this.zzb = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzG();
        this.zza.zzF(this.zzb);
        this.zza.zzB();
    }
}

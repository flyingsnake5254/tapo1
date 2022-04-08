package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
/* loaded from: classes.dex */
final class zzet implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzeu zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzet(zzeu zzeuVar, boolean z) {
        this.zzb = zzeuVar;
        this.zza = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkn zzknVar;
        zzknVar = this.zzb.zzb;
        zzknVar.zzV(this.zza);
    }
}

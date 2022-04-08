package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
final class zzjr implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzjz zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjr(zzjz zzjzVar, long j) {
        this.zzb = zzjzVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjz.zzh(this.zzb, this.zza);
    }
}

package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
public final class zzig implements Runnable {
    final /* synthetic */ zzik zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzig(zzik zzikVar) {
        this.zza = zzikVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzid zzidVar;
        zzik zzikVar = this.zza;
        zzidVar = zzikVar.zzh;
        zzikVar.zza = zzidVar;
    }
}

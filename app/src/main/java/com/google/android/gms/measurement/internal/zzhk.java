package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
public final class zzhk implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzhw zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhk(zzhw zzhwVar, AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        this.zze = zzhwVar;
        this.zza = atomicReference;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zzs.zzy().zzq(this.zza, null, this.zzb, this.zzc, this.zzd);
    }
}

package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
public final class zzin implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ zzp zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ zzjk zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzin(zzjk zzjkVar, AtomicReference atomicReference, zzp zzpVar, boolean z) {
        this.zzd = zzjkVar;
        this.zza = atomicReference;
        this.zzb = zzpVar;
        this.zzc = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        zzed zzedVar;
        synchronized (this.zza) {
            try {
                zzedVar = this.zzd.zzb;
            } catch (RemoteException e2) {
                this.zzd.zzs.zzau().zzb().zzb("Failed to get all user properties; remote exception", e2);
                atomicReference = this.zza;
            }
            if (zzedVar == null) {
                this.zzd.zzs.zzau().zzb().zza("Failed to get all user properties; not connected to service");
                this.zza.notify();
                return;
            }
            Preconditions.checkNotNull(this.zzb);
            this.zza.set(zzedVar.zzi(this.zzb, this.zzc));
            this.zzd.zzP();
            atomicReference = this.zza;
            atomicReference.notify();
        }
    }
}

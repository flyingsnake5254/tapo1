package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzcf;
import com.tplink.libtpmediastatistics.SSLClient;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
@VisibleForTesting
/* loaded from: classes.dex */
public final class zzjk extends zzf {
    private zzed zzb;
    private volatile Boolean zzc;
    private final zzal zzd;
    private final zzka zze;
    private final zzal zzg;
    private final List<Runnable> zzf = new ArrayList();
    private final zzjj zza = new zzjj(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public zzjk(zzfu zzfuVar) {
        super(zzfuVar);
        this.zze = new zzka(zzfuVar.zzay());
        this.zzd = new zziu(this, zzfuVar);
        this.zzg = new zziw(this, zzfuVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzJ(zzjk zzjkVar, ComponentName componentName) {
        zzjkVar.zzg();
        if (zzjkVar.zzb != null) {
            zzjkVar.zzb = null;
            zzjkVar.zzs.zzau().zzk().zzb("Disconnected from device MeasurementService", componentName);
            zzjkVar.zzg();
            zzjkVar.zzB();
        }
    }

    private final boolean zzO() {
        this.zzs.zzat();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void zzP() {
        zzg();
        this.zze.zza();
        zzal zzalVar = this.zzd;
        this.zzs.zzc();
        zzalVar.zzb(zzea.zzI.zzb(null).longValue());
    }

    @WorkerThread
    private final void zzQ(Runnable runnable) throws IllegalStateException {
        zzg();
        if (zzh()) {
            runnable.run();
            return;
        }
        int size = this.zzf.size();
        this.zzs.zzc();
        if (size >= 1000) {
            this.zzs.zzau().zzb().zza("Discarding data. Max runnable queue size reached");
            return;
        }
        this.zzf.add(runnable);
        this.zzg.zzb(60000L);
        zzB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void zzR() {
        zzg();
        this.zzs.zzau().zzk().zzb("Processing queued up service tasks", Integer.valueOf(this.zzf.size()));
        for (Runnable runnable : this.zzf) {
            try {
                runnable.run();
            } catch (RuntimeException e2) {
                this.zzs.zzau().zzb().zzb("Task exception while flushing queue", e2);
            }
        }
        this.zzf.clear();
        this.zzg.zzd();
    }

    @WorkerThread
    private final zzp zzS(boolean z) {
        Pair<String, Long> zzb;
        this.zzs.zzat();
        zzee zzA = this.zzs.zzA();
        String str = null;
        if (z) {
            zzem zzau = this.zzs.zzau();
            if (!(zzau.zzs.zzd().zzb == null || (zzb = zzau.zzs.zzd().zzb.zzb()) == null || zzb == zzfb.zza)) {
                String valueOf = String.valueOf(zzb.second);
                String str2 = (String) zzb.first;
                StringBuilder sb = new StringBuilder(valueOf.length() + 1 + String.valueOf(str2).length());
                sb.append(valueOf);
                sb.append(SSLClient.COLON);
                sb.append(str2);
                str = sb.toString();
            }
        }
        return zzA.zzh(str);
    }

    @WorkerThread
    public final void zzA(Bundle bundle) {
        zzg();
        zzb();
        zzQ(new zzit(this, zzS(false), bundle));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void zzB() {
        zzg();
        zzb();
        if (!zzh()) {
            if (zzD()) {
                this.zza.zzc();
            } else if (!this.zzs.zzc().zzy()) {
                this.zzs.zzat();
                List<ResolveInfo> queryIntentServices = this.zzs.zzax().getPackageManager().queryIntentServices(new Intent().setClassName(this.zzs.zzax(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
                if (queryIntentServices == null || queryIntentServices.size() <= 0) {
                    this.zzs.zzau().zzb().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
                    return;
                }
                Intent intent = new Intent("com.google.android.gms.measurement.START");
                Context zzax = this.zzs.zzax();
                this.zzs.zzat();
                intent.setComponent(new ComponentName(zzax, "com.google.android.gms.measurement.AppMeasurementService"));
                this.zza.zza(intent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean zzC() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:43:0x012b  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzD() {
        /*
            Method dump skipped, instructions count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjk.zzD():boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    @WorkerThread
    public final void zzE(zzed zzedVar) {
        zzg();
        Preconditions.checkNotNull(zzedVar);
        this.zzb = zzedVar;
        zzP();
        zzR();
    }

    @WorkerThread
    public final void zzF() {
        zzg();
        zzb();
        this.zza.zzb();
        try {
            ConnectionTracker.getInstance().unbindService(this.zzs.zzax(), this.zza);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    @WorkerThread
    public final void zzG(zzcf zzcfVar, zzas zzasVar, String str) {
        zzg();
        zzb();
        if (this.zzs.zzl().zzaa(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) != 0) {
            this.zzs.zzau().zze().zza("Not bundling data. Service unavailable or out of date");
            this.zzs.zzl().zzag(zzcfVar, new byte[0]);
            return;
        }
        zzQ(new zziv(this, zzasVar, str, zzcfVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzH() {
        zzg();
        zzb();
        return !zzD() || this.zzs.zzl().zzZ() >= zzea.zzau.zzb(null).intValue();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zze() {
        return false;
    }

    @WorkerThread
    public final boolean zzh() {
        zzg();
        zzb();
        return this.zzb != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void zzi() {
        zzg();
        zzb();
        zzQ(new zzix(this, zzS(true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void zzj(boolean z) {
        zzg();
        zzb();
        if (z) {
            zzO();
            this.zzs.zzn().zzh();
        }
        if (zzH()) {
            zzQ(new zziy(this, zzS(false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    @WorkerThread
    public final void zzk(zzed zzedVar, AbstractSafeParcelable abstractSafeParcelable, zzp zzpVar) {
        int i;
        zzg();
        zzb();
        zzO();
        this.zzs.zzc();
        int i2 = 0;
        int i3 = 100;
        while (i2 < 1001 && i3 == 100) {
            ArrayList arrayList = new ArrayList();
            List<AbstractSafeParcelable> zzl = this.zzs.zzn().zzl(100);
            if (zzl != null) {
                arrayList.addAll(zzl);
                i = zzl.size();
            } else {
                i = 0;
            }
            if (abstractSafeParcelable != null && i < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) arrayList.get(i4);
                if (abstractSafeParcelable2 instanceof zzas) {
                    try {
                        zzedVar.zzd((zzas) abstractSafeParcelable2, zzpVar);
                    } catch (RemoteException e2) {
                        this.zzs.zzau().zzb().zzb("Failed to send event to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzkq) {
                    try {
                        zzedVar.zze((zzkq) abstractSafeParcelable2, zzpVar);
                    } catch (RemoteException e3) {
                        this.zzs.zzau().zzb().zzb("Failed to send user property to the service", e3);
                    }
                } else if (abstractSafeParcelable2 instanceof zzaa) {
                    try {
                        zzedVar.zzm((zzaa) abstractSafeParcelable2, zzpVar);
                    } catch (RemoteException e4) {
                        this.zzs.zzau().zzb().zzb("Failed to send conditional user property to the service", e4);
                    }
                } else {
                    this.zzs.zzau().zzb().zza("Discarding data. Unrecognized parcel type.");
                }
            }
            i2++;
            i3 = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void zzl(zzas zzasVar, String str) {
        Preconditions.checkNotNull(zzasVar);
        zzg();
        zzb();
        zzO();
        zzQ(new zziz(this, true, zzS(true), this.zzs.zzn().zzi(zzasVar), zzasVar, str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void zzm(zzaa zzaaVar) {
        Preconditions.checkNotNull(zzaaVar);
        zzg();
        zzb();
        this.zzs.zzat();
        zzQ(new zzja(this, true, zzS(true), this.zzs.zzn().zzk(zzaaVar), new zzaa(zzaaVar), zzaaVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void zzn(AtomicReference<List<zzaa>> atomicReference, String str, String str2, String str3) {
        zzg();
        zzb();
        zzQ(new zzjb(this, atomicReference, null, str2, str3, zzS(false)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void zzo(zzcf zzcfVar, String str, String str2) {
        zzg();
        zzb();
        zzQ(new zzjc(this, str, str2, zzS(false), zzcfVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void zzq(AtomicReference<List<zzkq>> atomicReference, String str, String str2, String str3, boolean z) {
        zzg();
        zzb();
        zzQ(new zzjd(this, atomicReference, null, str2, str3, zzS(false), z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void zzr(zzcf zzcfVar, String str, String str2, boolean z) {
        zzg();
        zzb();
        zzQ(new zzil(this, str, str2, zzS(false), z, zzcfVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void zzs(zzkq zzkqVar) {
        zzg();
        zzb();
        zzO();
        zzQ(new zzim(this, zzS(true), this.zzs.zzn().zzj(zzkqVar), zzkqVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void zzt(AtomicReference<List<zzkq>> atomicReference, boolean z) {
        zzg();
        zzb();
        zzQ(new zzin(this, atomicReference, zzS(false), z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void zzu() {
        zzg();
        zzb();
        zzp zzS = zzS(false);
        zzO();
        this.zzs.zzn().zzh();
        zzQ(new zzio(this, zzS));
    }

    @WorkerThread
    public final void zzv(AtomicReference<String> atomicReference) {
        zzg();
        zzb();
        zzQ(new zzip(this, atomicReference, zzS(false)));
    }

    @WorkerThread
    public final void zzx(zzcf zzcfVar) {
        zzg();
        zzb();
        zzQ(new zziq(this, zzS(false), zzcfVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void zzy() {
        zzg();
        zzb();
        zzp zzS = zzS(true);
        this.zzs.zzn().zzm();
        zzQ(new zzir(this, zzS));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void zzz(zzid zzidVar) {
        zzg();
        zzb();
        zzQ(new zzis(this, zzidVar));
    }
}

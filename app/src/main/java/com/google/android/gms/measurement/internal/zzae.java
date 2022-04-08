package com.google.android.gms.measurement.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzpe;
import com.google.firebase.messaging.ServiceStarter;
import java.lang.reflect.InvocationTargetException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
public final class zzae extends zzgn {
    private Boolean zza;
    private zzad zzb = zzac.zza;
    private Boolean zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzae(zzfu zzfuVar) {
        super(zzfuVar);
    }

    public static final long zzA() {
        return zzea.zzC.zzb(null).longValue();
    }

    private final String zzB(String str, String str2) {
        try {
            String str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, "");
            Preconditions.checkNotNull(str3);
            return str3;
        } catch (ClassNotFoundException e2) {
            this.zzs.zzau().zzb().zzb("Could not find SystemProperties class", e2);
            return "";
        } catch (IllegalAccessException e3) {
            this.zzs.zzau().zzb().zzb("Could not access SystemProperties.get()", e3);
            return "";
        } catch (NoSuchMethodException e4) {
            this.zzs.zzau().zzb().zzb("Could not find SystemProperties.get() method", e4);
            return "";
        } catch (InvocationTargetException e5) {
            this.zzs.zzau().zzb().zzb("SystemProperties.get() threw an exception", e5);
            return "";
        }
    }

    public static final long zzz() {
        return zzea.zzc.zzb(null).longValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzad zzadVar) {
        this.zzb = zzadVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzb() {
        this.zzs.zzat();
        return "FA";
    }

    public final int zzc() {
        zzku zzl = this.zzs.zzl();
        Boolean zzC = zzl.zzs.zzy().zzC();
        if (zzl.zzZ() < 201500) {
            return (zzC == null || zzC.booleanValue()) ? 25 : 100;
        }
        return 100;
    }

    public final int zzd(@Size(min = 1) String str) {
        return zzl(str, zzea.zzH, 25, 100);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zze(@Size(min = 1) String str) {
        return zzl(str, zzea.zzG, ServiceStarter.ERROR_UNKNOWN, PlaybackException.ERROR_CODE_IO_UNSPECIFIED);
    }

    public final long zzf() {
        this.zzs.zzat();
        return 42004L;
    }

    @EnsuresNonNull({"this.isMainProcess"})
    public final boolean zzh() {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    ApplicationInfo applicationInfo = this.zzs.zzax().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = false;
                        if (str != null && str.equals(myProcessName)) {
                            z = true;
                        }
                        this.zzc = Boolean.valueOf(z);
                    }
                    if (this.zzc == null) {
                        this.zzc = Boolean.TRUE;
                        this.zzs.zzau().zzb().zza("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzc.booleanValue();
    }

    @WorkerThread
    public final String zzi(String str, zzdz<String> zzdzVar) {
        if (str == null) {
            return zzdzVar.zzb(null);
        }
        return zzdzVar.zzb(this.zzb.zza(str, zzdzVar.zza()));
    }

    @WorkerThread
    public final long zzj(String str, zzdz<Long> zzdzVar) {
        if (str == null) {
            return zzdzVar.zzb(null).longValue();
        }
        String zza = this.zzb.zza(str, zzdzVar.zza());
        if (TextUtils.isEmpty(zza)) {
            return zzdzVar.zzb(null).longValue();
        }
        try {
            return zzdzVar.zzb(Long.valueOf(Long.parseLong(zza))).longValue();
        } catch (NumberFormatException unused) {
            return zzdzVar.zzb(null).longValue();
        }
    }

    @WorkerThread
    public final int zzk(String str, zzdz<Integer> zzdzVar) {
        if (str == null) {
            return zzdzVar.zzb(null).intValue();
        }
        String zza = this.zzb.zza(str, zzdzVar.zza());
        if (TextUtils.isEmpty(zza)) {
            return zzdzVar.zzb(null).intValue();
        }
        try {
            return zzdzVar.zzb(Integer.valueOf(Integer.parseInt(zza))).intValue();
        } catch (NumberFormatException unused) {
            return zzdzVar.zzb(null).intValue();
        }
    }

    @WorkerThread
    public final int zzl(String str, zzdz<Integer> zzdzVar, int i, int i2) {
        return Math.max(Math.min(zzk(str, zzdzVar), i2), i);
    }

    @WorkerThread
    public final double zzm(String str, zzdz<Double> zzdzVar) {
        if (str == null) {
            return zzdzVar.zzb(null).doubleValue();
        }
        String zza = this.zzb.zza(str, zzdzVar.zza());
        if (TextUtils.isEmpty(zza)) {
            return zzdzVar.zzb(null).doubleValue();
        }
        try {
            return zzdzVar.zzb(Double.valueOf(Double.parseDouble(zza))).doubleValue();
        } catch (NumberFormatException unused) {
            return zzdzVar.zzb(null).doubleValue();
        }
    }

    @WorkerThread
    public final boolean zzn(String str, zzdz<Boolean> zzdzVar) {
        if (str == null) {
            return zzdzVar.zzb(null).booleanValue();
        }
        String zza = this.zzb.zza(str, zzdzVar.zza());
        if (TextUtils.isEmpty(zza)) {
            return zzdzVar.zzb(null).booleanValue();
        }
        return zzdzVar.zzb(Boolean.valueOf(Boolean.parseBoolean(zza))).booleanValue();
    }

    @VisibleForTesting
    final Bundle zzo() {
        try {
            if (this.zzs.zzax().getPackageManager() == null) {
                this.zzs.zzau().zzb().zza("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(this.zzs.zzax()).getApplicationInfo(this.zzs.zzax().getPackageName(), 128);
            if (applicationInfo != null) {
                return applicationInfo.metaData;
            }
            this.zzs.zzau().zzb().zza("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            this.zzs.zzau().zzb().zzb("Failed to load metadata: Package name not found", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final Boolean zzp(@Size(min = 1) String str) {
        Preconditions.checkNotEmpty(str);
        Bundle zzo = zzo();
        if (zzo == null) {
            this.zzs.zzau().zzb().zza("Failed to load metadata: Metadata bundle is null");
            return null;
        } else if (!zzo.containsKey(str)) {
            return null;
        } else {
            return Boolean.valueOf(zzo.getBoolean(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @com.google.android.gms.common.util.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<java.lang.String> zzq(@androidx.annotation.Size(min = 1) java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r4 = "analytics.safelisted_events"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            android.os.Bundle r0 = r3.zzo()
            r1 = 0
            if (r0 != 0) goto L_0x001d
            com.google.android.gms.measurement.internal.zzfu r4 = r3.zzs
            com.google.android.gms.measurement.internal.zzem r4 = r4.zzau()
            com.google.android.gms.measurement.internal.zzek r4 = r4.zzb()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.zza(r0)
        L_0x001b:
            r4 = r1
            goto L_0x002c
        L_0x001d:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L_0x0024
            goto L_0x001b
        L_0x0024:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L_0x002c:
            if (r4 == 0) goto L_0x0058
            com.google.android.gms.measurement.internal.zzfu r0 = r3.zzs     // Catch: NotFoundException -> 0x0048
            android.content.Context r0 = r0.zzax()     // Catch: NotFoundException -> 0x0048
            android.content.res.Resources r0 = r0.getResources()     // Catch: NotFoundException -> 0x0048
            int r4 = r4.intValue()     // Catch: NotFoundException -> 0x0048
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch: NotFoundException -> 0x0048
            if (r4 != 0) goto L_0x0043
            return r1
        L_0x0043:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch: NotFoundException -> 0x0048
            return r4
        L_0x0048:
            r4 = move-exception
            com.google.android.gms.measurement.internal.zzfu r0 = r3.zzs
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzb()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.zzb(r2, r4)
        L_0x0058:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzae.zzq(java.lang.String):java.util.List");
    }

    public final boolean zzr() {
        this.zzs.zzat();
        Boolean zzp = zzp("firebase_analytics_collection_deactivated");
        return zzp != null && zzp.booleanValue();
    }

    public final boolean zzs() {
        Boolean zzp = zzp("google_analytics_adid_collection_enabled");
        return zzp == null || zzp.booleanValue();
    }

    public final boolean zzt() {
        Boolean zzp;
        zzpe.zzb();
        return !zzn(null, zzea.zzaq) || (zzp = zzp("google_analytics_automatic_screen_reporting_enabled")) == null || zzp.booleanValue();
    }

    public final String zzu() {
        return zzB("debug.firebase.analytics.app", "");
    }

    public final String zzv() {
        return zzB("debug.deferred.deeplink", "");
    }

    public final boolean zzw(String str) {
        return "1".equals(this.zzb.zza(str, "gaia_collection_enabled"));
    }

    public final boolean zzx(String str) {
        return "1".equals(this.zzb.zza(str, "measurement.event_sampling_enabled"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzy() {
        if (this.zza == null) {
            Boolean zzp = zzp("app_measurement_lite");
            this.zza = zzp;
            if (zzp == null) {
                this.zza = Boolean.FALSE;
            }
        }
        return this.zza.booleanValue() || !this.zzs.zzu();
    }
}

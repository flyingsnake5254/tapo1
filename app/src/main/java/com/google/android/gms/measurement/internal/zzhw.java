package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzom;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import io.netty.handler.traffic.AbstractTrafficShapingHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
public final class zzhw extends zzf {
    @VisibleForTesting
    protected zzhv zza;
    final zzr zzb;
    private zzgu zzd;
    private boolean zzf;
    private final Set<zzgv> zze = new CopyOnWriteArraySet();
    private final Object zzh = new Object();
    @VisibleForTesting
    protected boolean zzc = true;
    private final zzkt zzn = new zzhl(this);
    private final AtomicReference<String> zzg = new AtomicReference<>();
    @GuardedBy("consentLock")
    private zzaf zzi = new zzaf(null, null);
    @GuardedBy("consentLock")
    private int zzj = 100;
    private long zzl = -1;
    private int zzm = 100;
    private final AtomicLong zzk = new AtomicLong(0);

    /* JADX INFO: Access modifiers changed from: protected */
    public zzhw(zzfu zzfuVar) {
        super(zzfuVar);
        this.zzb = new zzr(zzfuVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzW(zzhw zzhwVar, zzaf zzafVar, int i, long j, boolean z, boolean z2) {
        zzhwVar.zzg();
        zzhwVar.zzb();
        if (j > zzhwVar.zzl || !zzaf.zzm(zzhwVar.zzm, i)) {
            zzfb zzd = zzhwVar.zzs.zzd();
            zzfu zzfuVar = zzd.zzs;
            zzd.zzg();
            if (zzd.zzh(i)) {
                SharedPreferences.Editor edit = zzd.zzd().edit();
                edit.putString("consent_settings", zzafVar.zzd());
                edit.putInt("consent_source", i);
                edit.apply();
                zzhwVar.zzl = j;
                zzhwVar.zzm = i;
                zzhwVar.zzs.zzy().zzj(z);
                if (z2) {
                    zzhwVar.zzs.zzy().zzv(new AtomicReference<>());
                    return;
                }
                return;
            }
            zzhwVar.zzs.zzau().zzi().zzb("Lower precedence consent source ignored, proposed source", Integer.valueOf(i));
            return;
        }
        zzhwVar.zzs.zzau().zzi().zzb("Dropped out-of-date consent setting, proposed settings", zzafVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void zzY(Boolean bool, boolean z) {
        zzg();
        zzb();
        this.zzs.zzau().zzj().zzb("Setting app measurement enabled (FE)", bool);
        this.zzs.zzd().zze(bool);
        if (z) {
            zzfb zzd = this.zzs.zzd();
            zzfu zzfuVar = zzd.zzs;
            zzd.zzg();
            SharedPreferences.Editor edit = zzd.zzd().edit();
            if (bool != null) {
                edit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                edit.remove("measurement_enabled_from_api");
            }
            edit.apply();
        }
        if (this.zzs.zzI() || (bool != null && !bool.booleanValue())) {
            zzZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void zzZ() {
        zzg();
        String zza = this.zzs.zzd().zzh.zza();
        if (zza != null) {
            if ("unset".equals(zza)) {
                zzB("app", "_npa", null, this.zzs.zzay().currentTimeMillis());
            } else {
                zzB("app", "_npa", Long.valueOf(true != "true".equals(zza) ? 0L : 1L), this.zzs.zzay().currentTimeMillis());
            }
        }
        if (!this.zzs.zzF() || !this.zzc) {
            this.zzs.zzau().zzj().zza("Updating Scion state (FE)");
            this.zzs.zzy().zzi();
            return;
        }
        this.zzs.zzau().zzj().zza("Recording app launch after enabling measurement for the first time (FE)");
        zzH();
        zzom.zzb();
        if (this.zzs.zzc().zzn(null, zzea.zzan)) {
            this.zzs.zzh().zza.zza();
        }
        this.zzs.zzav().zzh(new zzha(this));
    }

    final void zzA(String str, String str2, long j, Object obj) {
        this.zzs.zzav().zzh(new zzhd(this, str, str2, obj, j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzB(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            r8.zzg()
            r8.zzb()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L_0x0064
            boolean r0 = r11 instanceof java.lang.String
            if (r0 == 0) goto L_0x0052
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0052
            r10 = 1
            java.util.Locale r11 = java.util.Locale.ENGLISH
            java.lang.String r11 = r0.toLowerCase(r11)
            java.lang.String r0 = "false"
            boolean r11 = r0.equals(r11)
            r2 = 1
            if (r10 == r11) goto L_0x0037
            r10 = 0
            goto L_0x0038
        L_0x0037:
            r10 = r2
        L_0x0038:
            java.lang.Long r11 = java.lang.Long.valueOf(r10)
            com.google.android.gms.measurement.internal.zzfu r10 = r8.zzs
            com.google.android.gms.measurement.internal.zzfb r10 = r10.zzd()
            com.google.android.gms.measurement.internal.zzfa r10 = r10.zzh
            long r4 = r11.longValue()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x004e
            java.lang.String r0 = "true"
        L_0x004e:
            r10.zzb(r0)
            goto L_0x0061
        L_0x0052:
            if (r11 != 0) goto L_0x0064
            com.google.android.gms.measurement.internal.zzfu r10 = r8.zzs
            com.google.android.gms.measurement.internal.zzfb r10 = r10.zzd()
            com.google.android.gms.measurement.internal.zzfa r10 = r10.zzh
            java.lang.String r0 = "unset"
            r10.zzb(r0)
        L_0x0061:
            r6 = r11
            r3 = r1
            goto L_0x0066
        L_0x0064:
            r3 = r10
            r6 = r11
        L_0x0066:
            com.google.android.gms.measurement.internal.zzfu r10 = r8.zzs
            boolean r10 = r10.zzF()
            if (r10 != 0) goto L_0x007e
            com.google.android.gms.measurement.internal.zzfu r9 = r8.zzs
            com.google.android.gms.measurement.internal.zzem r9 = r9.zzau()
            com.google.android.gms.measurement.internal.zzek r9 = r9.zzk()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.zza(r10)
            return
        L_0x007e:
            com.google.android.gms.measurement.internal.zzfu r10 = r8.zzs
            boolean r10 = r10.zzL()
            if (r10 != 0) goto L_0x0087
            return
        L_0x0087:
            com.google.android.gms.measurement.internal.zzkq r10 = new com.google.android.gms.measurement.internal.zzkq
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            com.google.android.gms.measurement.internal.zzfu r9 = r8.zzs
            com.google.android.gms.measurement.internal.zzjk r9 = r9.zzy()
            r9.zzs(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhw.zzB(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final List<zzkq> zzC(boolean z) {
        zzb();
        this.zzs.zzau().zzk().zza("Getting user properties (FE)");
        if (!this.zzs.zzav().zzd()) {
            this.zzs.zzat();
            if (zzz.zza()) {
                this.zzs.zzau().zzb().zza("Cannot get all user properties from main thread");
                return Collections.emptyList();
            }
            AtomicReference atomicReference = new AtomicReference();
            this.zzs.zzav().zzi(atomicReference, 5000L, "get user properties", new zzhe(this, atomicReference, z));
            List<zzkq> list = (List) atomicReference.get();
            if (list != null) {
                return list;
            }
            this.zzs.zzau().zzb().zzb("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyList();
        }
        this.zzs.zzau().zzb().zza("Cannot get all user properties from analytics worker thread");
        return Collections.emptyList();
    }

    public final String zzD() {
        return this.zzg.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzE(String str) {
        this.zzg.set(str);
    }

    public final void zzF(long j) {
        this.zzg.set(null);
        this.zzs.zzav().zzh(new zzhf(this, j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzG(long j, boolean z) {
        zzg();
        zzb();
        this.zzs.zzau().zzj().zza("Resetting analytics data (FE)");
        zzjz zzh = this.zzs.zzh();
        zzh.zzg();
        zzh.zzb.zzc();
        boolean zzF = this.zzs.zzF();
        zzfb zzd = this.zzs.zzd();
        zzd.zzc.zzb(j);
        if (!TextUtils.isEmpty(zzd.zzs.zzd().zzo.zza())) {
            zzd.zzo.zzb(null);
        }
        zzom.zzb();
        zzae zzc = zzd.zzs.zzc();
        zzdz<Boolean> zzdzVar = zzea.zzan;
        if (zzc.zzn(null, zzdzVar)) {
            zzd.zzj.zzb(0L);
        }
        if (!zzd.zzs.zzc().zzr()) {
            zzd.zzj(!zzF);
        }
        zzd.zzp.zzb(null);
        zzd.zzq.zzb(0L);
        zzd.zzr.zzb(null);
        if (z) {
            this.zzs.zzy().zzu();
        }
        zzom.zzb();
        if (this.zzs.zzc().zzn(null, zzdzVar)) {
            this.zzs.zzh().zza.zza();
        }
        this.zzc = !zzF;
    }

    @WorkerThread
    public final void zzH() {
        zzg();
        zzb();
        if (this.zzs.zzL()) {
            if (this.zzs.zzc().zzn(null, zzea.zzaa)) {
                zzae zzc = this.zzs.zzc();
                zzc.zzs.zzat();
                Boolean zzp = zzc.zzp("google_analytics_deferred_deep_link_enabled");
                if (zzp != null && zzp.booleanValue()) {
                    this.zzs.zzau().zzj().zza("Deferred Deep Link feature enabled.");
                    this.zzs.zzav().zzh(new Runnable(this) { // from class: com.google.android.gms.measurement.internal.zzgy
                        private final zzhw zza;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zza = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            zzhw zzhwVar = this.zza;
                            zzhwVar.zzg();
                            if (!zzhwVar.zzs.zzd().zzm.zza()) {
                                long zza = zzhwVar.zzs.zzd().zzn.zza();
                                zzhwVar.zzs.zzd().zzn.zzb(1 + zza);
                                zzhwVar.zzs.zzc();
                                if (zza >= 5) {
                                    zzhwVar.zzs.zzau().zze().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                                    zzhwVar.zzs.zzd().zzm.zzb(true);
                                    return;
                                }
                                zzhwVar.zzs.zzM();
                                return;
                            }
                            zzhwVar.zzs.zzau().zzj().zza("Deferred Deep Link already retrieved. Not fetching again.");
                        }
                    });
                }
            }
            this.zzs.zzy().zzy();
            this.zzc = false;
            zzfb zzd = this.zzs.zzd();
            zzd.zzg();
            String string = zzd.zzd().getString("previous_os_version", null);
            zzd.zzs.zzz().zzv();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor edit = zzd.zzd().edit();
                edit.putString("previous_os_version", str);
                edit.apply();
            }
            if (!TextUtils.isEmpty(string)) {
                this.zzs.zzz().zzv();
                if (!string.equals(str)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", string);
                    zzs(ThingModelDefine.Property.PROPERTY_AUTO, "_ou", bundle);
                }
            }
        }
    }

    @WorkerThread
    public final void zzI(zzgu zzguVar) {
        zzgu zzguVar2;
        zzg();
        zzb();
        if (!(zzguVar == null || zzguVar == (zzguVar2 = this.zzd))) {
            Preconditions.checkState(zzguVar2 == null, "EventInterceptor already set.");
        }
        this.zzd = zzguVar;
    }

    public final void zzJ(zzgv zzgvVar) {
        zzb();
        Preconditions.checkNotNull(zzgvVar);
        if (!this.zze.add(zzgvVar)) {
            this.zzs.zzau().zze().zza("OnEventListener already registered");
        }
    }

    public final void zzK(zzgv zzgvVar) {
        zzb();
        Preconditions.checkNotNull(zzgvVar);
        if (!this.zze.remove(zzgvVar)) {
            this.zzs.zzau().zze().zza("OnEventListener had not been registered");
        }
    }

    public final int zzL(String str) {
        Preconditions.checkNotEmpty(str);
        this.zzs.zzc();
        return 25;
    }

    public final void zzM(Bundle bundle) {
        zzN(bundle, this.zzs.zzay().currentTimeMillis());
    }

    public final void zzN(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            this.zzs.zzau().zze().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        zzgq.zzb(bundle2, "app_id", String.class, null);
        zzgq.zzb(bundle2, "origin", String.class, null);
        zzgq.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.NAME, String.class, null);
        zzgq.zzb(bundle2, "value", Object.class, null);
        zzgq.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzgq.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzgq.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzgq.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzgq.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzgq.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzgq.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzgq.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzgq.zzb(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME);
        Object obj = bundle2.get("value");
        if (this.zzs.zzl().zzo(string) != 0) {
            this.zzs.zzau().zzb().zzb("Invalid conditional user property name", this.zzs.zzm().zze(string));
        } else if (this.zzs.zzl().zzJ(string, obj) == 0) {
            Object zzK = this.zzs.zzl().zzK(string, obj);
            if (zzK == null) {
                this.zzs.zzau().zzb().zzc("Unable to normalize conditional user property value", this.zzs.zzm().zze(string), obj);
                return;
            }
            zzgq.zza(bundle2, zzK);
            long j2 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
            if (!TextUtils.isEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME))) {
                this.zzs.zzc();
                if (j2 > 15552000000L || j2 < 1) {
                    this.zzs.zzau().zzb().zzc("Invalid conditional user property timeout", this.zzs.zzm().zze(string), Long.valueOf(j2));
                    return;
                }
            }
            long j3 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
            this.zzs.zzc();
            if (j3 > 15552000000L || j3 < 1) {
                this.zzs.zzau().zzb().zzc("Invalid conditional user property time to live", this.zzs.zzm().zze(string), Long.valueOf(j3));
            } else {
                this.zzs.zzav().zzh(new zzhg(this, bundle2));
            }
        } else {
            this.zzs.zzau().zzb().zzc("Invalid conditional user property value", this.zzs.zzm().zze(string), obj);
        }
    }

    public final void zzO(String str, String str2, Bundle bundle) {
        long currentTimeMillis = this.zzs.zzay().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, str);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str2 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str2);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        this.zzs.zzav().zzh(new zzhh(this, bundle2));
    }

    public final ArrayList<Bundle> zzP(String str, String str2) {
        if (this.zzs.zzav().zzd()) {
            this.zzs.zzau().zzb().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        }
        this.zzs.zzat();
        if (zzz.zza()) {
            this.zzs.zzau().zzb().zza("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzs.zzav().zzi(atomicReference, 5000L, "get conditional user properties", new zzhj(this, atomicReference, null, str, str2));
        List list = (List) atomicReference.get();
        if (list != null) {
            return zzku.zzak(list);
        }
        this.zzs.zzau().zzb().zzb("Timed out waiting for get conditional user properties", null);
        return new ArrayList<>();
    }

    public final Map<String, Object> zzQ(String str, String str2, boolean z) {
        if (this.zzs.zzav().zzd()) {
            this.zzs.zzau().zzb().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        this.zzs.zzat();
        if (zzz.zza()) {
            this.zzs.zzau().zzb().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzs.zzav().zzi(atomicReference, 5000L, "get user properties", new zzhk(this, atomicReference, null, str, str2, z));
        List<zzkq> list = (List) atomicReference.get();
        if (list == null) {
            this.zzs.zzau().zzb().zzb("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzkq zzkqVar : list) {
            Object zza = zzkqVar.zza();
            if (zza != null) {
                arrayMap.put(zzkqVar.zzb, zza);
            }
        }
        return arrayMap;
    }

    public final String zzR() {
        zzid zzl = this.zzs.zzx().zzl();
        if (zzl != null) {
            return zzl.zza;
        }
        return null;
    }

    public final String zzS() {
        zzid zzl = this.zzs.zzx().zzl();
        if (zzl != null) {
            return zzl.zzb;
        }
        return null;
    }

    public final String zzT() {
        if (this.zzs.zzr() != null) {
            return this.zzs.zzr();
        }
        try {
            return zzic.zza(this.zzs.zzax(), "google_app_id", this.zzs.zzv());
        } catch (IllegalStateException e2) {
            this.zzs.zzau().zzb().zzb("getGoogleAppId failed with exception", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzU(Bundle bundle) {
        if (bundle == null) {
            this.zzs.zzd().zzr.zzb(new Bundle());
            return;
        }
        Bundle zza = this.zzs.zzd().zzr.zza();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                if (this.zzs.zzl().zzs(obj)) {
                    this.zzs.zzl().zzM(this.zzn, null, 27, null, null, 0, this.zzs.zzc().zzn(null, zzea.zzaw));
                }
                this.zzs.zzau().zzh().zzc("Invalid default event parameter type. Name, value", str, obj);
            } else if (zzku.zzR(str)) {
                this.zzs.zzau().zzh().zzb("Invalid default event parameter name. Name", str);
            } else if (obj == null) {
                zza.remove(str);
            } else {
                zzku zzl = this.zzs.zzl();
                this.zzs.zzc();
                if (zzl.zzt("param", str, 100, obj)) {
                    this.zzs.zzl().zzL(zza, str, obj);
                }
            }
        }
        this.zzs.zzl();
        int zzc = this.zzs.zzc().zzc();
        if (zza.size() > zzc) {
            int i = 0;
            for (String str2 : new TreeSet(zza.keySet())) {
                i++;
                if (i > zzc) {
                    zza.remove(str2);
                }
            }
            this.zzs.zzl().zzM(this.zzn, null, 26, null, null, 0, this.zzs.zzc().zzn(null, zzea.zzaw));
            this.zzs.zzau().zzh().zza("Too many default event parameters set. Discarding beyond event parameter limit");
        }
        this.zzs.zzd().zzr.zzb(zza);
        this.zzs.zzy().zzA(zza);
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zze() {
        return false;
    }

    public final void zzh() {
        if ((this.zzs.zzax().getApplicationContext() instanceof Application) && this.zza != null) {
            ((Application) this.zzs.zzax().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
        }
    }

    public final Boolean zzi() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) this.zzs.zzav().zzi(atomicReference, AbstractTrafficShapingHandler.DEFAULT_MAX_TIME, "boolean test flag value", new zzhi(this, atomicReference));
    }

    public final String zzj() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) this.zzs.zzav().zzi(atomicReference, AbstractTrafficShapingHandler.DEFAULT_MAX_TIME, "String test flag value", new zzhm(this, atomicReference));
    }

    public final Long zzk() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) this.zzs.zzav().zzi(atomicReference, AbstractTrafficShapingHandler.DEFAULT_MAX_TIME, "long test flag value", new zzhn(this, atomicReference));
    }

    public final Integer zzl() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) this.zzs.zzav().zzi(atomicReference, AbstractTrafficShapingHandler.DEFAULT_MAX_TIME, "int test flag value", new zzho(this, atomicReference));
    }

    public final Double zzm() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) this.zzs.zzav().zzi(atomicReference, AbstractTrafficShapingHandler.DEFAULT_MAX_TIME, "double test flag value", new zzhp(this, atomicReference));
    }

    public final void zzn(Boolean bool) {
        zzb();
        this.zzs.zzav().zzh(new zzhq(this, bool));
    }

    public final void zzo(Bundle bundle, int i, long j) {
        zzb();
        String zza = zzaf.zza(bundle);
        if (zza != null) {
            this.zzs.zzau().zzh().zzb("Ignoring invalid consent setting", zza);
            this.zzs.zzau().zzh().zza("Valid consent values are 'granted', 'denied'");
        }
        zzq(zzaf.zzb(bundle), i, j);
    }

    public final void zzq(zzaf zzafVar, int i, long j) {
        boolean z;
        boolean z2;
        zzaf zzafVar2;
        zzb();
        if (i != -10 && zzafVar.zze() == null && zzafVar.zzg() == null) {
            this.zzs.zzau().zzh().zza("Discarding empty consent settings");
            return;
        }
        synchronized (this.zzh) {
            z = true;
            z2 = false;
            if (zzaf.zzm(i, this.zzj)) {
                boolean zzi = zzafVar.zzi(this.zzi);
                if (zzafVar.zzh() && !this.zzi.zzh()) {
                    z2 = true;
                }
                zzaf zzl = zzafVar.zzl(this.zzi);
                this.zzi = zzl;
                this.zzj = i;
                zzafVar2 = zzl;
                z2 = zzi;
            } else {
                zzafVar2 = zzafVar;
                z2 = false;
                z = false;
            }
        }
        if (!z) {
            this.zzs.zzau().zzi().zzb("Ignoring lower-priority consent settings, proposed settings", zzafVar2);
            return;
        }
        long andIncrement = this.zzk.getAndIncrement();
        if (z2) {
            this.zzg.set(null);
            this.zzs.zzav().zzj(new zzhr(this, zzafVar2, j, i, andIncrement, z2));
        } else if (i == 30 || i == -10) {
            this.zzs.zzav().zzj(new zzhs(this, zzafVar2, i, andIncrement, z2));
        } else {
            this.zzs.zzav().zzh(new zzht(this, zzafVar2, i, andIncrement, z2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void zzr(zzaf zzafVar) {
        zzg();
        boolean z = (zzafVar.zzh() && zzafVar.zzf()) || this.zzs.zzy().zzH();
        if (z != this.zzs.zzI()) {
            this.zzs.zzH(z);
            zzfb zzd = this.zzs.zzd();
            zzfu zzfuVar = zzd.zzs;
            zzd.zzg();
            Boolean valueOf = zzd.zzd().contains("measurement_enabled_from_api") ? Boolean.valueOf(zzd.zzd().getBoolean("measurement_enabled_from_api", true)) : null;
            if (!z || valueOf == null || valueOf.booleanValue()) {
                zzY(Boolean.valueOf(z), false);
            }
        }
    }

    public final void zzs(String str, String str2, Bundle bundle) {
        zzv(str, str2, bundle, true, true, this.zzs.zzay().currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void zzt(String str, String str2, long j, Bundle bundle) {
        zzg();
        zzu(str, str2, j, bundle, true, this.zzd == null || zzku.zzR(str2), false, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:124:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x04a0  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzu(java.lang.String r21, java.lang.String r22, long r23, android.os.Bundle r25, boolean r26, boolean r27, boolean r28, java.lang.String r29) {
        /*
            Method dump skipped, instructions count: 1350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhw.zzu(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    public final void zzv(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        String str3 = str == null ? "app" : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (this.zzs.zzc().zzn(null, zzea.zzar) && zzku.zzS(str2, FirebaseAnalytics.Event.SCREEN_VIEW)) {
            this.zzs.zzx().zzj(bundle2, j);
            return;
        }
        zzx(str3, str2, j, bundle2, z2, !z2 || this.zzd == null || zzku.zzR(str2), !z, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzx(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Bundle bundle2 = new Bundle(bundle);
        for (String str4 : bundle2.keySet()) {
            Object obj = bundle2.get(str4);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str4, new Bundle((Bundle) obj));
            } else {
                int i = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i < parcelableArr.length) {
                        Parcelable parcelable = parcelableArr[i];
                        if (parcelable instanceof Bundle) {
                            parcelableArr[i] = new Bundle((Bundle) parcelable);
                        }
                        i++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i < list.size()) {
                        Object obj2 = list.get(i);
                        if (obj2 instanceof Bundle) {
                            list.set(i, new Bundle((Bundle) obj2));
                        }
                        i++;
                    }
                }
            }
        }
        this.zzs.zzav().zzh(new zzhc(this, str, str2, j, bundle2, z, z2, z3, str3));
    }

    public final void zzy(String str, String str2, Object obj, boolean z) {
        zzz(ThingModelDefine.Property.PROPERTY_AUTO, str2, obj, true, this.zzs.zzay().currentTimeMillis());
    }

    public final void zzz(String str, String str2, Object obj, boolean z, long j) {
        int i;
        String str3 = str == null ? "app" : str;
        if (z) {
            i = this.zzs.zzl().zzo(str2);
        } else {
            zzku zzl = this.zzs.zzl();
            if (zzl.zzj("user property", str2)) {
                if (!zzl.zzl("user property", zzgt.zza, null, str2)) {
                    i = 15;
                } else {
                    zzl.zzs.zzc();
                    if (zzl.zzm("user property", 24, str2)) {
                        i = 0;
                    }
                }
            }
            i = 6;
        }
        if (i != 0) {
            zzku zzl2 = this.zzs.zzl();
            this.zzs.zzc();
            this.zzs.zzl().zzM(this.zzn, null, i, "_ev", zzl2.zzC(str2, 24, true), str2 != null ? str2.length() : 0, this.zzs.zzc().zzn(null, zzea.zzaw));
        } else if (obj != null) {
            int zzJ = this.zzs.zzl().zzJ(str2, obj);
            if (zzJ != 0) {
                zzku zzl3 = this.zzs.zzl();
                this.zzs.zzc();
                this.zzs.zzl().zzM(this.zzn, null, zzJ, "_ev", zzl3.zzC(str2, 24, true), ((obj instanceof String) || (obj instanceof CharSequence)) ? String.valueOf(obj).length() : 0, this.zzs.zzc().zzn(null, zzea.zzaw));
                return;
            }
            Object zzK = this.zzs.zzl().zzK(str2, obj);
            if (zzK != null) {
                zzA(str3, str2, j, zzK);
            }
        } else {
            zzA(str3, str2, j, null);
        }
    }
}

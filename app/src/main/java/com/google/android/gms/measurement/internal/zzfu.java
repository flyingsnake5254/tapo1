package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.internal.measurement.zzht;
import com.google.android.gms.internal.measurement.zzoa;
import com.google.android.gms.internal.measurement.zzod;
import com.google.firebase.messaging.Constants;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
public final class zzfu implements zzgp {
    private static volatile zzfu zzd;
    private zzee zzA;
    private zzfe zzB;
    private Boolean zzD;
    private long zzE;
    private volatile Boolean zzF;
    private int zzH;
    @VisibleForTesting
    protected Boolean zza;
    @VisibleForTesting
    protected Boolean zzb;
    @VisibleForTesting
    final long zzc;
    private final Context zze;
    private final String zzf;
    private final String zzg;
    private final String zzh;
    private final boolean zzi;
    private final zzz zzj;
    private final zzae zzk;
    private final zzfb zzl;
    private final zzem zzm;
    private final zzfr zzn;
    private final zzjz zzo;
    private final zzku zzp;
    private final zzeh zzq;
    private final Clock zzr;
    private final zzik zzs;
    private final zzhw zzt;
    private final zzd zzu;
    private final zzia zzv;
    private final String zzw;
    private zzeg zzx;
    private zzjk zzy;
    private zzam zzz;
    private boolean zzC = false;
    private final AtomicInteger zzI = new AtomicInteger(0);
    private volatile boolean zzG = true;

    zzfu(zzgw zzgwVar) {
        long j;
        Bundle bundle;
        boolean z = false;
        Preconditions.checkNotNull(zzgwVar);
        zzz zzzVar = new zzz(zzgwVar.zza);
        this.zzj = zzzVar;
        zzdy.zza = zzzVar;
        Context context = zzgwVar.zza;
        this.zze = context;
        this.zzf = zzgwVar.zzb;
        this.zzg = zzgwVar.zzc;
        this.zzh = zzgwVar.zzd;
        this.zzi = zzgwVar.zzh;
        this.zzF = zzgwVar.zze;
        this.zzw = zzgwVar.zzj;
        zzcl zzclVar = zzgwVar.zzg;
        if (!(zzclVar == null || (bundle = zzclVar.zzg) == null)) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.zza = (Boolean) obj;
            }
            Object obj2 = zzclVar.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.zzb = (Boolean) obj2;
            }
        }
        zzht.zzb(context);
        Clock instance = DefaultClock.getInstance();
        this.zzr = instance;
        Long l = zzgwVar.zzi;
        if (l != null) {
            j = l.longValue();
        } else {
            j = instance.currentTimeMillis();
        }
        this.zzc = j;
        this.zzk = new zzae(this);
        zzfb zzfbVar = new zzfb(this);
        zzfbVar.zzx();
        this.zzl = zzfbVar;
        zzem zzemVar = new zzem(this);
        zzemVar.zzx();
        this.zzm = zzemVar;
        zzku zzkuVar = new zzku(this);
        zzkuVar.zzx();
        this.zzp = zzkuVar;
        zzeh zzehVar = new zzeh(this);
        zzehVar.zzx();
        this.zzq = zzehVar;
        this.zzu = new zzd(this);
        zzik zzikVar = new zzik(this);
        zzikVar.zzc();
        this.zzs = zzikVar;
        zzhw zzhwVar = new zzhw(this);
        zzhwVar.zzc();
        this.zzt = zzhwVar;
        zzjz zzjzVar = new zzjz(this);
        zzjzVar.zzc();
        this.zzo = zzjzVar;
        zzia zziaVar = new zzia(this);
        zziaVar.zzx();
        this.zzv = zziaVar;
        zzfr zzfrVar = new zzfr(this);
        zzfrVar.zzx();
        this.zzn = zzfrVar;
        zzcl zzclVar2 = zzgwVar.zzg;
        z = (zzclVar2 == null || zzclVar2.zzb == 0) ? true : z;
        if (context.getApplicationContext() instanceof Application) {
            zzhw zzk = zzk();
            if (zzk.zzs.zze.getApplicationContext() instanceof Application) {
                Application application = (Application) zzk.zzs.zze.getApplicationContext();
                if (zzk.zza == null) {
                    zzk.zza = new zzhv(zzk, null);
                }
                if (z) {
                    application.unregisterActivityLifecycleCallbacks(zzk.zza);
                    application.registerActivityLifecycleCallbacks(zzk.zza);
                    zzk.zzs.zzau().zzk().zza("Registered activity lifecycle callback");
                }
            }
        } else {
            zzau().zze().zza("Application context is not an Application");
        }
        zzfrVar.zzh(new zzft(this, zzgwVar));
    }

    public static zzfu zzC(Context context, zzcl zzclVar, Long l) {
        Bundle bundle;
        if (zzclVar != null && (zzclVar.zze == null || zzclVar.zzf == null)) {
            zzclVar = new zzcl(zzclVar.zza, zzclVar.zzb, zzclVar.zzc, zzclVar.zzd, null, null, zzclVar.zzg, null);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzd == null) {
            synchronized (zzfu.class) {
                if (zzd == null) {
                    zzd = new zzfu(new zzgw(context, zzclVar, l));
                }
            }
        } else if (!(zzclVar == null || (bundle = zzclVar.zzg) == null || !bundle.containsKey("dataCollectionDefaultEnabled"))) {
            Preconditions.checkNotNull(zzd);
            zzd.zzF = Boolean.valueOf(zzclVar.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        Preconditions.checkNotNull(zzd);
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzO(zzfu zzfuVar, zzgw zzgwVar) {
        zzfuVar.zzav().zzg();
        zzfuVar.zzk.zzb();
        zzam zzamVar = new zzam(zzfuVar);
        zzamVar.zzx();
        zzfuVar.zzz = zzamVar;
        zzee zzeeVar = new zzee(zzfuVar, zzgwVar.zzf);
        zzeeVar.zzc();
        zzfuVar.zzA = zzeeVar;
        zzeg zzegVar = new zzeg(zzfuVar);
        zzegVar.zzc();
        zzfuVar.zzx = zzegVar;
        zzjk zzjkVar = new zzjk(zzfuVar);
        zzjkVar.zzc();
        zzfuVar.zzy = zzjkVar;
        zzfuVar.zzp.zzy();
        zzfuVar.zzl.zzy();
        zzfuVar.zzB = new zzfe(zzfuVar);
        zzfuVar.zzA.zzd();
        zzek zzi = zzfuVar.zzau().zzi();
        zzfuVar.zzk.zzf();
        zzi.zzb("App measurement initialized, version", 42004L);
        zzfuVar.zzau().zzi().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String zzi2 = zzeeVar.zzi();
        if (TextUtils.isEmpty(zzfuVar.zzf)) {
            if (zzfuVar.zzl().zzT(zzi2)) {
                zzfuVar.zzau().zzi().zza("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
            } else {
                zzek zzi3 = zzfuVar.zzau().zzi();
                String valueOf = String.valueOf(zzi2);
                zzi3.zza(valueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(valueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app "));
            }
        }
        zzfuVar.zzau().zzj().zza("Debug-level message logging enabled");
        if (zzfuVar.zzH != zzfuVar.zzI.get()) {
            zzfuVar.zzau().zzb().zzc("Not all components initialized", Integer.valueOf(zzfuVar.zzH), Integer.valueOf(zzfuVar.zzI.get()));
        }
        zzfuVar.zzC = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void zzP() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    private static final void zzQ(zzgn zzgnVar) {
        if (zzgnVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static final void zzR(zzf zzfVar) {
        if (zzfVar == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzfVar.zza()) {
            String valueOf = String.valueOf(zzfVar.getClass());
            StringBuilder sb = new StringBuilder(valueOf.length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    private static final void zzS(zzgo zzgoVar) {
        if (zzgoVar == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzgoVar.zzu()) {
            String valueOf = String.valueOf(zzgoVar.getClass());
            StringBuilder sb = new StringBuilder(valueOf.length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    @Pure
    public final zzee zzA() {
        zzR(this.zzA);
        return this.zzA;
    }

    @Pure
    public final zzd zzB() {
        zzd zzdVar = this.zzu;
        if (zzdVar != null) {
            return zzdVar;
        }
        throw new IllegalStateException("Component not created");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void zzD(boolean z) {
        this.zzF = Boolean.valueOf(z);
    }

    @WorkerThread
    public final boolean zzE() {
        return this.zzF != null && this.zzF.booleanValue();
    }

    @WorkerThread
    public final boolean zzF() {
        return zzG() == 0;
    }

    @WorkerThread
    public final int zzG() {
        zzav().zzg();
        if (this.zzk.zzr()) {
            return 1;
        }
        Boolean bool = this.zzb;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        zzav().zzg();
        if (!this.zzG) {
            return 8;
        }
        Boolean zzf = zzd().zzf();
        if (zzf != null) {
            return zzf.booleanValue() ? 0 : 3;
        }
        zzae zzaeVar = this.zzk;
        zzz zzzVar = zzaeVar.zzs.zzj;
        Boolean zzp = zzaeVar.zzp("firebase_analytics_collection_enabled");
        if (zzp != null) {
            return zzp.booleanValue() ? 0 : 4;
        }
        Boolean bool2 = this.zza;
        return bool2 != null ? bool2.booleanValue() ? 0 : 5 : (!this.zzk.zzn(null, zzea.zzS) || this.zzF == null || this.zzF.booleanValue()) ? 0 : 7;
    }

    @WorkerThread
    public final void zzH(boolean z) {
        zzav().zzg();
        this.zzG = z;
    }

    @WorkerThread
    public final boolean zzI() {
        zzav().zzg();
        return this.zzG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzJ() {
        this.zzH++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzK() {
        this.zzI.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final boolean zzL() {
        if (this.zzC) {
            zzav().zzg();
            Boolean bool = this.zzD;
            if (bool == null || this.zzE == 0 || (!bool.booleanValue() && Math.abs(this.zzr.elapsedRealtime() - this.zzE) > 1000)) {
                this.zzE = this.zzr.elapsedRealtime();
                boolean z = true;
                Boolean valueOf = Boolean.valueOf(zzl().zzQ("android.permission.INTERNET") && zzl().zzQ("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zze).isCallerInstantApp() || this.zzk.zzy() || (zzku.zzam(this.zze) && zzku.zzP(this.zze, false))));
                this.zzD = valueOf;
                if (valueOf.booleanValue()) {
                    if (!zzl().zzA(zzA().zzj(), zzA().zzk(), zzA().zzl()) && TextUtils.isEmpty(zzA().zzk())) {
                        z = false;
                    }
                    this.zzD = Boolean.valueOf(z);
                }
            }
            return this.zzD.booleanValue();
        }
        throw new IllegalStateException("AppMeasurement is not initialized");
    }

    @WorkerThread
    public final void zzM() {
        zzav().zzg();
        zzS(zzo());
        String zzi = zzA().zzi();
        Pair<String, Boolean> zzb = zzd().zzb(zzi);
        if (!this.zzk.zzs() || ((Boolean) zzb.second).booleanValue() || TextUtils.isEmpty((CharSequence) zzb.first)) {
            zzau().zzj().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return;
        }
        zzia zzo = zzo();
        zzo.zzv();
        ConnectivityManager connectivityManager = (ConnectivityManager) zzo.zzs.zze.getSystemService("connectivity");
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            zzau().zze().zza("Network is not available for Deferred Deep Link request. Skipping");
            return;
        }
        zzku zzl = zzl();
        zzA().zzs.zzk.zzf();
        URL zzal = zzl.zzal(42004L, zzi, (String) zzb.first, zzd().zzn.zza() - 1);
        if (zzal != null) {
            zzia zzo2 = zzo();
            zzfs zzfsVar = new zzfs(this);
            zzo2.zzg();
            zzo2.zzv();
            Preconditions.checkNotNull(zzal);
            Preconditions.checkNotNull(zzfsVar);
            zzo2.zzs.zzav().zzk(new zzhz(zzo2, zzi, zzal, null, null, zzfsVar, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzN(String str, int i, Throwable th, byte[] bArr, Map map) {
        List<ResolveInfo> queryIntentActivities;
        if (!(i == 200 || i == 204)) {
            if (i == 304) {
                i = 304;
            }
            zzau().zze().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), th);
        }
        if (th == null) {
            zzd().zzm.zzb(true);
            if (bArr == null || bArr.length == 0) {
                zzau().zzj().zza("Deferred Deep Link response empty.");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                String optString = jSONObject.optString("deeplink", "");
                String optString2 = jSONObject.optString("gclid", "");
                double optDouble = jSONObject.optDouble("timestamp", Utils.DOUBLE_EPSILON);
                if (TextUtils.isEmpty(optString)) {
                    zzau().zzj().zza("Deferred Deep Link is empty.");
                    return;
                }
                zzku zzl = zzl();
                zzfu zzfuVar = zzl.zzs;
                if (!TextUtils.isEmpty(optString) && (queryIntentActivities = zzl.zzs.zze.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0)) != null && !queryIntentActivities.isEmpty()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("gclid", optString2);
                    bundle.putString("_cis", "ddp");
                    this.zzt.zzs(ThingModelDefine.Property.PROPERTY_AUTO, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundle);
                    zzku zzl2 = zzl();
                    if (!TextUtils.isEmpty(optString)) {
                        try {
                            SharedPreferences.Editor edit = zzl2.zzs.zze.getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
                            edit.putString("deeplink", optString);
                            edit.putLong("timestamp", Double.doubleToRawLongBits(optDouble));
                            if (edit.commit()) {
                                zzl2.zzs.zze.sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
                                return;
                            }
                            return;
                        } catch (RuntimeException e2) {
                            zzl2.zzs.zzau().zzb().zzb("Failed to persist Deferred Deep Link. exception", e2);
                            return;
                        }
                    } else {
                        return;
                    }
                }
                zzau().zze().zzc("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                return;
            } catch (JSONException e3) {
                zzau().zzb().zzb("Failed to parse the Deferred Deep Link response. exception", e3);
                return;
            }
        }
        zzau().zze().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void zza(zzcl zzclVar) {
        zzaf zzafVar;
        zzav().zzg();
        zzaf zzi = zzd().zzi();
        zzfb zzd2 = zzd();
        zzfu zzfuVar = zzd2.zzs;
        zzd2.zzg();
        int i = 100;
        int i2 = zzd2.zzd().getInt("consent_source", 100);
        zzae zzaeVar = this.zzk;
        zzfu zzfuVar2 = zzaeVar.zzs;
        Boolean zzp = zzaeVar.zzp("google_analytics_default_allow_ad_storage");
        zzae zzaeVar2 = this.zzk;
        zzfu zzfuVar3 = zzaeVar2.zzs;
        Boolean zzp2 = zzaeVar2.zzp("google_analytics_default_allow_analytics_storage");
        if (!(zzp == null && zzp2 == null) && zzd().zzh(-10)) {
            zzafVar = new zzaf(zzp, zzp2);
            i = -10;
        } else {
            if (TextUtils.isEmpty(zzA().zzj()) || !(i2 == 0 || i2 == 30 || i2 == 10 || i2 == 30 || i2 == 30 || i2 == 40)) {
                zzod.zzb();
                if ((!this.zzk.zzn(null, zzea.zzaC) || TextUtils.isEmpty(zzA().zzj())) && zzclVar != null && zzclVar.zzg != null && zzd().zzh(30)) {
                    zzafVar = zzaf.zzb(zzclVar.zzg);
                    if (!zzafVar.equals(zzaf.zza)) {
                        i = 30;
                    }
                }
            } else {
                zzk().zzq(zzaf.zza, -10, this.zzc);
            }
            zzafVar = null;
        }
        if (zzafVar != null) {
            zzk().zzq(zzafVar, i, this.zzc);
            zzi = zzafVar;
        }
        zzk().zzr(zzi);
        if (zzd().zzc.zza() == 0) {
            zzau().zzk().zzb("Persisting first open", Long.valueOf(this.zzc));
            zzd().zzc.zzb(this.zzc);
        }
        zzk().zzb.zzc();
        if (zzL()) {
            if (!TextUtils.isEmpty(zzA().zzj()) || !TextUtils.isEmpty(zzA().zzk())) {
                zzku zzl = zzl();
                String zzj = zzA().zzj();
                zzfb zzd3 = zzd();
                zzd3.zzg();
                String string = zzd3.zzd().getString("gmp_app_id", null);
                String zzk = zzA().zzk();
                zzfb zzd4 = zzd();
                zzd4.zzg();
                if (zzl.zzB(zzj, string, zzk, zzd4.zzd().getString("admob_app_id", null))) {
                    zzau().zzi().zza("Rechecking which service to use due to a GMP App Id change");
                    zzfb zzd5 = zzd();
                    zzd5.zzg();
                    Boolean zzf = zzd5.zzf();
                    SharedPreferences.Editor edit = zzd5.zzd().edit();
                    edit.clear();
                    edit.apply();
                    if (zzf != null) {
                        zzd5.zze(zzf);
                    }
                    zzn().zzh();
                    this.zzy.zzF();
                    this.zzy.zzB();
                    zzd().zzc.zzb(this.zzc);
                    zzd().zze.zzb(null);
                }
                zzfb zzd6 = zzd();
                String zzj2 = zzA().zzj();
                zzd6.zzg();
                SharedPreferences.Editor edit2 = zzd6.zzd().edit();
                edit2.putString("gmp_app_id", zzj2);
                edit2.apply();
                zzfb zzd7 = zzd();
                String zzk2 = zzA().zzk();
                zzd7.zzg();
                SharedPreferences.Editor edit3 = zzd7.zzd().edit();
                edit3.putString("admob_app_id", zzk2);
                edit3.apply();
            }
            if (!zzd().zzi().zzh()) {
                zzd().zze.zzb(null);
            }
            zzk().zzE(zzd().zze.zza());
            zzoa.zzb();
            if (this.zzk.zzn(null, zzea.zzam)) {
                try {
                    zzl().zzs.zze.getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
                } catch (ClassNotFoundException unused) {
                    if (!TextUtils.isEmpty(zzd().zzo.zza())) {
                        zzau().zze().zza("Remote config removed with active feature rollouts");
                        zzd().zzo.zzb(null);
                    }
                }
            }
            if (!TextUtils.isEmpty(zzA().zzj()) || !TextUtils.isEmpty(zzA().zzk())) {
                boolean zzF = zzF();
                if (!zzd().zzk() && !this.zzk.zzr()) {
                    zzd().zzj(!zzF);
                }
                if (zzF) {
                    zzk().zzH();
                }
                zzh().zza.zza();
                zzy().zzv(new AtomicReference<>());
                zzy().zzA(zzd().zzr.zza());
            }
        } else if (zzF()) {
            if (!zzl().zzQ("android.permission.INTERNET")) {
                zzau().zzb().zza("App is missing INTERNET permission");
            }
            if (!zzl().zzQ("android.permission.ACCESS_NETWORK_STATE")) {
                zzau().zzb().zza("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!Wrappers.packageManager(this.zze).isCallerInstantApp() && !this.zzk.zzy()) {
                if (!zzku.zzam(this.zze)) {
                    zzau().zzb().zza("AppMeasurementReceiver not registered/enabled");
                }
                if (!zzku.zzP(this.zze, false)) {
                    zzau().zzb().zza("AppMeasurementService not registered/enabled");
                }
            }
            zzau().zzb().zza("Uploading is not possible. App measurement disabled");
        }
        zzd().zzi.zzb(true);
    }

    @Override // com.google.android.gms.measurement.internal.zzgp
    @Pure
    public final zzz zzat() {
        return this.zzj;
    }

    @Override // com.google.android.gms.measurement.internal.zzgp
    @Pure
    public final zzem zzau() {
        zzS(this.zzm);
        return this.zzm;
    }

    @Override // com.google.android.gms.measurement.internal.zzgp
    @Pure
    public final zzfr zzav() {
        zzS(this.zzn);
        return this.zzn;
    }

    @Override // com.google.android.gms.measurement.internal.zzgp
    @Pure
    public final Context zzax() {
        return this.zze;
    }

    @Override // com.google.android.gms.measurement.internal.zzgp
    @Pure
    public final Clock zzay() {
        return this.zzr;
    }

    @Pure
    public final zzae zzc() {
        return this.zzk;
    }

    @Pure
    public final zzfb zzd() {
        zzQ(this.zzl);
        return this.zzl;
    }

    public final zzem zzf() {
        zzem zzemVar = this.zzm;
        if (zzemVar == null || !zzemVar.zzu()) {
            return null;
        }
        return this.zzm;
    }

    @Pure
    public final zzjz zzh() {
        zzR(this.zzo);
        return this.zzo;
    }

    @SideEffectFree
    public final zzfe zzi() {
        return this.zzB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SideEffectFree
    public final zzfr zzj() {
        return this.zzn;
    }

    @Pure
    public final zzhw zzk() {
        zzR(this.zzt);
        return this.zzt;
    }

    @Pure
    public final zzku zzl() {
        zzQ(this.zzp);
        return this.zzp;
    }

    @Pure
    public final zzeh zzm() {
        zzQ(this.zzq);
        return this.zzq;
    }

    @Pure
    public final zzeg zzn() {
        zzR(this.zzx);
        return this.zzx;
    }

    @Pure
    public final zzia zzo() {
        zzS(this.zzv);
        return this.zzv;
    }

    @Pure
    public final boolean zzq() {
        return TextUtils.isEmpty(this.zzf);
    }

    @Pure
    public final String zzr() {
        return this.zzf;
    }

    @Pure
    public final String zzs() {
        return this.zzg;
    }

    @Pure
    public final String zzt() {
        return this.zzh;
    }

    @Pure
    public final boolean zzu() {
        return this.zzi;
    }

    @Pure
    public final String zzv() {
        return this.zzw;
    }

    @Pure
    public final zzik zzx() {
        zzR(this.zzs);
        return this.zzs;
    }

    @Pure
    public final zzjk zzy() {
        zzR(this.zzy);
        return this.zzy;
    }

    @Pure
    public final zzam zzz() {
        zzS(this.zzz);
        return this.zzz;
    }
}

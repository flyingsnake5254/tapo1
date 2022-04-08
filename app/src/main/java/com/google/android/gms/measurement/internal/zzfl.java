package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.collection.LruCache;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzd;
import com.google.android.gms.internal.measurement.zzez;
import com.google.android.gms.internal.measurement.zzfb;
import com.google.android.gms.internal.measurement.zzfc;
import com.google.android.gms.internal.measurement.zzfe;
import com.google.android.gms.internal.measurement.zzgm;
import com.google.android.gms.internal.measurement.zzgo;
import com.google.android.gms.internal.measurement.zzkn;
import com.google.android.gms.internal.measurement.zzn;
import com.google.android.gms.internal.measurement.zzpn;
import com.google.android.gms.internal.measurement.zzpt;
import com.google.android.gms.internal.measurement.zzr;
import com.google.android.gms.internal.measurement.zzt;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
/* loaded from: classes.dex */
public final class zzfl extends zzke implements zzad {
    private final Map<String, Map<String, String>> zzc = new ArrayMap();
    private final Map<String, Map<String, Boolean>> zzd = new ArrayMap();
    private final Map<String, Map<String, Boolean>> zze = new ArrayMap();
    private final Map<String, zzfc> zzg = new ArrayMap();
    private final Map<String, String> zzi = new ArrayMap();
    private final Map<String, Map<String, Integer>> zzh = new ArrayMap();
    @VisibleForTesting
    final LruCache<String, zzc> zza = new zzfi(this, 20);
    final zzr zzb = new zzfj(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfl(zzkn zzknVar) {
        super(zzknVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzc zzo(zzfl zzflVar, String str) {
        zzflVar.zzZ();
        Preconditions.checkNotEmpty(str);
        zzpt.zzb();
        if (!zzflVar.zzs.zzc().zzn(null, zzea.zzaD) || !zzflVar.zzh(str)) {
            return null;
        }
        if (!zzflVar.zzg.containsKey(str) || zzflVar.zzg.get(str) == null) {
            zzflVar.zzq(str);
        } else {
            zzflVar.zzs(str, zzflVar.zzg.get(str));
        }
        return zzflVar.zza.snapshot().get(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x008d, code lost:
        if (r2 == null) goto L_0x0092;
     */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x011b: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:37:0x011b */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011e  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzq(java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfl.zzq(java.lang.String):void");
    }

    private final void zzr(String str, zzfb zzfbVar) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (zzfbVar != null) {
            for (int i = 0; i < zzfbVar.zza(); i++) {
                zzez zzbu = zzfbVar.zzb(i).zzbu();
                if (TextUtils.isEmpty(zzbu.zza())) {
                    this.zzs.zzau().zze().zza("EventConfig contained null event name");
                } else {
                    String zza = zzbu.zza();
                    String zzb = zzgr.zzb(zzbu.zza());
                    if (!TextUtils.isEmpty(zzb)) {
                        zzbu.zzb(zzb);
                        zzfbVar.zzc(i, zzbu);
                    }
                    arrayMap.put(zza, Boolean.valueOf(zzbu.zzc()));
                    arrayMap2.put(zzbu.zza(), Boolean.valueOf(zzbu.zzd()));
                    if (zzbu.zze()) {
                        if (zzbu.zzf() < 2 || zzbu.zzf() > 65535) {
                            this.zzs.zzau().zze().zzc("Invalid sampling rate. Event name, sample rate", zzbu.zza(), Integer.valueOf(zzbu.zzf()));
                        } else {
                            arrayMap3.put(zzbu.zza(), Integer.valueOf(zzbu.zzf()));
                        }
                    }
                }
            }
        }
        this.zzd.put(str, arrayMap);
        this.zze.put(str, arrayMap2);
        this.zzh.put(str, arrayMap3);
    }

    @WorkerThread
    private final void zzs(final String str, zzfc zzfcVar) {
        if (zzfcVar.zzk() != 0) {
            this.zzs.zzau().zzk().zzb("EES programs found", Integer.valueOf(zzfcVar.zzk()));
            zzgo zzgoVar = zzfcVar.zzj().get(0);
            try {
                zzc zzcVar = new zzc();
                zzcVar.zza("internal.remoteConfig", new Callable(this, str) { // from class: com.google.android.gms.measurement.internal.zzfg
                    private final zzfl zza;
                    private final String zzb;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zza = this;
                        this.zzb = str;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return new zzn("internal.remoteConfig", new zzfk(this.zza, this.zzb));
                    }
                });
                zzcVar.zza("internal.logger", new Callable(this) { // from class: com.google.android.gms.measurement.internal.zzfh
                    private final zzfl zza;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zza = this;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return new zzt(this.zza.zzb);
                    }
                });
                zzcVar.zzf(zzgoVar);
                this.zza.put(str, zzcVar);
                this.zzs.zzau().zzk().zzc("EES program loaded for appId, activities", str, Integer.valueOf(zzgoVar.zzb().zzb()));
                for (zzgm zzgmVar : zzgoVar.zzb().zza()) {
                    this.zzs.zzau().zzk().zzb("EES program activity", zzgmVar.zza());
                }
            } catch (zzd unused) {
                this.zzs.zzau().zzb().zzb("Failed to load EES program. appId", str);
            }
        } else {
            this.zza.remove(str);
        }
    }

    @WorkerThread
    private final zzfc zzt(String str, byte[] bArr) {
        if (bArr == null) {
            return zzfc.zzn();
        }
        try {
            zzfc zzaA = ((zzfb) zzkp.zzt(zzfc.zzm(), bArr)).zzaA();
            zzek zzk = this.zzs.zzau().zzk();
            String str2 = null;
            Long valueOf = zzaA.zza() ? Long.valueOf(zzaA.zzb()) : null;
            if (zzaA.zzc()) {
                str2 = zzaA.zzd();
            }
            zzk.zzc("Parsed config. version, gmp_app_id", valueOf, str2);
            return zzaA;
        } catch (zzkn e2) {
            this.zzs.zzau().zze().zzc("Unable to merge remote config. appId", zzem.zzl(str), e2);
            return zzfc.zzn();
        } catch (RuntimeException e3) {
            this.zzs.zzau().zze().zzc("Unable to merge remote config. appId", zzem.zzl(str), e3);
            return zzfc.zzn();
        }
    }

    private static final Map<String, String> zzu(zzfc zzfcVar) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzfcVar != null) {
            for (zzfe zzfeVar : zzfcVar.zze()) {
                arrayMap.put(zzfeVar.zza(), zzfeVar.zzb());
            }
        }
        return arrayMap;
    }

    @Override // com.google.android.gms.measurement.internal.zzad
    @WorkerThread
    public final String zza(String str, String str2) {
        zzg();
        zzq(str);
        Map<String, String> map = this.zzc.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.zzke
    protected final boolean zzaA() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final zzfc zzb(String str) {
        zzZ();
        zzg();
        Preconditions.checkNotEmpty(str);
        zzq(str);
        return this.zzg.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final String zzc(String str) {
        zzg();
        return this.zzi.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final void zzd(String str) {
        zzg();
        this.zzi.put(str, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void zze(String str) {
        zzg();
        this.zzg.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzf(String str) {
        zzg();
        zzfc zzb = zzb(str);
        if (zzb == null) {
            return false;
        }
        return zzb.zzi();
    }

    public final boolean zzh(String str) {
        zzfc zzfcVar;
        zzpt.zzb();
        return this.zzs.zzc().zzn(null, zzea.zzaD) && !TextUtils.isEmpty(str) && (zzfcVar = this.zzg.get(str)) != null && zzfcVar.zzk() != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final boolean zzi(String str, byte[] bArr, String str2) {
        zzZ();
        zzg();
        Preconditions.checkNotEmpty(str);
        zzfb zzbu = zzt(str, bArr).zzbu();
        if (zzbu == null) {
            return false;
        }
        zzr(str, zzbu);
        zzpt.zzb();
        if (this.zzs.zzc().zzn(null, zzea.zzaD)) {
            zzs(str, zzbu.zzaA());
        }
        this.zzg.put(str, zzbu.zzaA());
        this.zzi.put(str, str2);
        this.zzc.put(str, zzu(zzbu.zzaA()));
        this.zzf.zzi().zzL(str, new ArrayList(zzbu.zzd()));
        try {
            zzbu.zze();
            bArr = zzbu.zzaA().zzbp();
        } catch (RuntimeException e2) {
            this.zzs.zzau().zze().zzc("Unable to serialize reduced-size config. Storing full config instead. appId", zzem.zzl(str), e2);
        }
        zzpn.zzb();
        if (this.zzs.zzc().zzn(null, zzea.zzaB)) {
            this.zzf.zzi().zzw(str, bArr, str2);
        } else {
            this.zzf.zzi().zzw(str, bArr, null);
        }
        this.zzg.put(str, zzbu.zzaA());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzj(String str, String str2) {
        Boolean bool;
        zzg();
        zzq(str);
        if (zzm(str) && zzku.zzR(str2)) {
            return true;
        }
        if (zzn(str) && zzku.zzh(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.zzd.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzk(String str, String str2) {
        Boolean bool;
        zzg();
        zzq(str);
        if (FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(str2) || FirebaseAnalytics.Event.PURCHASE.equals(str2) || FirebaseAnalytics.Event.REFUND.equals(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.zze.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final int zzl(String str, String str2) {
        Integer num;
        zzg();
        zzq(str);
        Map<String, Integer> map = this.zzh.get(str);
        if (map == null || (num = map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzm(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_internal"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzn(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_public"));
    }
}

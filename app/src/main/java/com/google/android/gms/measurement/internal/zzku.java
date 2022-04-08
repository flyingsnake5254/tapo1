package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.internal.measurement.zzov;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
public final class zzku extends zzgo {
    public static final /* synthetic */ int zza = 0;
    private static final String[] zzb = {"firebase_", "google_", "ga_"};
    private static final String[] zzc = {"_err"};
    private SecureRandom zzd;
    private int zzf;
    private Integer zzg = null;
    private final AtomicLong zze = new AtomicLong(0);

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzku(zzfu zzfuVar) {
        super(zzfuVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MessageDigest zzN() {
        MessageDigest instance;
        for (int i = 0; i < 2; i++) {
            try {
                instance = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
            }
            if (instance != null) {
                return instance;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public static long zzO(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        int length = bArr.length;
        int i = 0;
        Preconditions.checkState(length > 0);
        long j = 0;
        for (int i2 = length - 1; i2 >= 0 && i2 >= bArr.length - 8; i2--) {
            j += (bArr[i2] & 255) << i;
            i += 8;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzP(Context context, boolean z) {
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 24) {
            return zzar(context, "com.google.android.gms.measurement.AppMeasurementJobService");
        }
        return zzar(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzR(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzS(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    public static boolean zzY(String str) {
        return !zzc[0].equals(str);
    }

    public static ArrayList<Bundle> zzak(List<zzaa> list) {
        if (list == null) {
            return new ArrayList<>(0);
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(list.size());
        for (zzaa zzaaVar : list) {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", zzaaVar.zza);
            bundle.putString("origin", zzaaVar.zzb);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, zzaaVar.zzd);
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, zzaaVar.zzc.zzb);
            zzgq.zza(bundle, zzaaVar.zzc.zza());
            bundle.putBoolean("active", zzaaVar.zze);
            String str = zzaaVar.zzf;
            if (str != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, str);
            }
            zzas zzasVar = zzaaVar.zzg;
            if (zzasVar != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, zzasVar.zza);
                zzaq zzaqVar = zzaaVar.zzg.zzb;
                if (zzaqVar != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, zzaqVar.zzf());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, zzaaVar.zzh);
            zzas zzasVar2 = zzaaVar.zzi;
            if (zzasVar2 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, zzasVar2.zza);
                zzaq zzaqVar2 = zzaaVar.zzi.zzb;
                if (zzaqVar2 != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, zzaqVar2.zzf());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, zzaaVar.zzc.zzc);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, zzaaVar.zzj);
            zzas zzasVar3 = zzaaVar.zzk;
            if (zzasVar3 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, zzasVar3.zza);
                zzaq zzaqVar3 = zzaaVar.zzk.zzb;
                if (zzaqVar3 != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, zzaqVar3.zzf());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzam(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (!(packageManager == null || (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) == null)) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    static final boolean zzan(Bundle bundle, int i) {
        if (bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i);
        return true;
    }

    @VisibleForTesting
    static final boolean zzao(String str) {
        Preconditions.checkNotNull(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    private final Object zzap(int i, Object obj, boolean z, boolean z2) {
        Parcelable[] parcelableArr;
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(true != ((Boolean) obj).booleanValue() ? 0L : 1L);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                return zzC(String.valueOf(obj), i, z);
            }
            if (!z2 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcelable parcelable : (Parcelable[]) obj) {
                if (parcelable instanceof Bundle) {
                    Bundle zzU = zzU((Bundle) parcelable);
                    if (!zzU.isEmpty()) {
                        arrayList.add(zzU);
                    }
                }
            }
            return arrayList.toArray(new Bundle[arrayList.size()]);
        }
    }

    private final int zzaq(String str) {
        if ("_ldl".equals(str)) {
            this.zzs.zzc();
            return 2048;
        } else if ("_id".equals(str)) {
            this.zzs.zzc();
            return 256;
        } else if (!this.zzs.zzc().zzn(null, zzea.zzae) || !"_lgclid".equals(str)) {
            this.zzs.zzc();
            return 36;
        } else {
            this.zzs.zzc();
            return 100;
        }
    }

    private static boolean zzar(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (!(packageManager == null || (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) == null)) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    private static boolean zzas(String str, String[] strArr) {
        Preconditions.checkNotNull(strArr);
        for (String str2 : strArr) {
            if (zzS(str, str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzh(String str) {
        Preconditions.checkNotEmpty(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzA(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            zzov.zzb();
            if (this.zzs.zzc().zzn(null, zzea.zzag) && !TextUtils.isEmpty(str3)) {
                return true;
            }
            if (TextUtils.isEmpty(str2)) {
                if (this.zzs.zzq()) {
                    this.zzs.zzau().zzd().zza("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
                }
                return false;
            } else if (zzao(str2)) {
                return true;
            } else {
                this.zzs.zzau().zzd().zzb("Invalid admob_app_id. Analytics disabled.", zzem.zzl(str2));
                return false;
            }
        } else if (zzao(str)) {
            return true;
        } else {
            if (this.zzs.zzq()) {
                this.zzs.zzau().zzd().zzb("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzem.zzl(str));
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzB(String str, String str2, String str3, String str4) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            Preconditions.checkNotNull(str);
            return !str.equals(str2);
        } else if (isEmpty && isEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        } else {
            if (isEmpty) {
                return TextUtils.isEmpty(str3) || !str3.equals(str4);
            }
            if (TextUtils.isEmpty(str4)) {
                return false;
            }
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
    }

    public final String zzC(String str, int i, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00de A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00df  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int zzD(java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.Object r18, android.os.Bundle r19, java.util.List<java.lang.String> r20, boolean r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzku.zzD(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object zzE(String str, Object obj) {
        int i = 256;
        if ("_ev".equals(str)) {
            this.zzs.zzc();
            return zzap(256, obj, true, true);
        }
        if (zzR(str)) {
            this.zzs.zzc();
        } else {
            this.zzs.zzc();
            i = 100;
        }
        return zzap(i, obj, false, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.Bundle zzF(java.lang.String r21, java.lang.String r22, android.os.Bundle r23, java.util.List<java.lang.String> r24, boolean r25) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzku.zzF(java.lang.String, java.lang.String, android.os.Bundle, java.util.List, boolean):android.os.Bundle");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzG(zzen zzenVar, int i) {
        int i2 = 0;
        for (String str : new TreeSet(zzenVar.zzd.keySet())) {
            if (zzh(str) && (i2 = i2 + 1) > i) {
                StringBuilder sb = new StringBuilder(48);
                sb.append("Event can't contain more than ");
                sb.append(i);
                sb.append(" params");
                this.zzs.zzau().zzd().zzc(sb.toString(), this.zzs.zzm().zzc(zzenVar.zza), this.zzs.zzm().zzf(zzenVar.zzd));
                zzan(zzenVar.zzd, 5);
                zzenVar.zzd.remove(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzH(Bundle bundle, Bundle bundle2) {
        if (bundle2 != null) {
            for (String str : bundle2.keySet()) {
                if (!bundle.containsKey(str)) {
                    this.zzs.zzl().zzL(bundle, str, bundle2.get(str));
                }
            }
        }
    }

    final void zzI(Bundle bundle, int i, String str, String str2, Object obj) {
        if (zzan(bundle, i)) {
            this.zzs.zzc();
            bundle.putString("_ev", zzC(str, 40, true));
            if (obj != null) {
                Preconditions.checkNotNull(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", String.valueOf(obj).length());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzJ(String str, Object obj) {
        boolean z;
        if ("_ldl".equals(str)) {
            z = zzt("user property referrer", str, zzaq(str), obj);
        } else {
            z = zzt("user property", str, zzaq(str), obj);
        }
        return z ? 0 : 7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object zzK(String str, Object obj) {
        if ("_ldl".equals(str)) {
            return zzap(zzaq(str), obj, true, false);
        }
        return zzap(zzaq(str), obj, false, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzL(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (obj instanceof Bundle[]) {
                bundle.putParcelableArray(str, (Bundle[]) obj);
            } else if (str != null) {
                this.zzs.zzau().zzh().zzc("Not putting event parameter. Invalid value type. name, type", this.zzs.zzm().zzd(str), obj != null ? obj.getClass().getSimpleName() : null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzM(zzkt zzktVar, String str, int i, String str2, String str3, int i2, boolean z) {
        Bundle bundle = new Bundle();
        zzan(bundle, i);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", i2);
        }
        if (z) {
            zzktVar.zza(str, "_err", bundle);
            return;
        }
        this.zzs.zzat();
        this.zzs.zzk().zzs(ThingModelDefine.Property.PROPERTY_AUTO, "_err", bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzQ(String str) {
        zzg();
        if (Wrappers.packageManager(this.zzs.zzax()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        this.zzs.zzau().zzj().zzb("Permission not granted", str);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzT(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String zzu = this.zzs.zzc().zzu();
        this.zzs.zzat();
        return zzu.equals(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle zzU(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object zzE = zzE(str, bundle.get(str));
                if (zzE == null) {
                    this.zzs.zzau().zzh().zzb("Param value can't be null", this.zzs.zzm().zzd(str));
                } else {
                    zzL(bundle2, str, zzE);
                }
            }
        }
        return bundle2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzas zzV(String str, String str2, Bundle bundle, String str3, long j, boolean z, boolean z2) {
        Bundle bundle2;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (zzn(str2) == 0) {
            if (bundle != null) {
                bundle2 = new Bundle(bundle);
            } else {
                bundle2 = new Bundle();
            }
            bundle2.putString("_o", str3);
            Bundle zzF = zzF(str, str2, bundle2, CollectionUtils.listOf("_o"), false);
            if (z) {
                zzF = zzU(zzF);
            }
            Preconditions.checkNotNull(zzF);
            return new zzas(str2, new zzaq(zzF), str3, j);
        }
        this.zzs.zzau().zzb().zzb("Invalid conditional property event name", this.zzs.zzm().zze(str2));
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final boolean zzW(Context context, String str) {
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e2) {
            this.zzs.zzau().zzb().zzb("Package name not found", e2);
            return true;
        } catch (CertificateException e3) {
            this.zzs.zzau().zzb().zzb("Error obtaining certificate", e3);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] zzX(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    @EnsuresNonNull({"this.apkVersion"})
    public final int zzZ() {
        if (this.zzg == null) {
            this.zzg = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzs.zzax()) / 1000);
        }
        return this.zzg.intValue();
    }

    @Override // com.google.android.gms.measurement.internal.zzgo
    protected final boolean zza() {
        return true;
    }

    public final int zzaa(int i) {
        return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(this.zzs.zzax(), GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    public final long zzab(long j, long j2) {
        return (j + (j2 * 60000)) / 86400000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void zzac(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            this.zzs.zzau().zze().zzb("Params already contained engagement", Long.valueOf(j2));
        }
        bundle.putLong("_et", j + j2);
    }

    public final void zzad(zzcf zzcfVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            zzcfVar.zzb(bundle);
        } catch (RemoteException e2) {
            this.zzs.zzau().zze().zzb("Error returning string value to wrapper", e2);
        }
    }

    public final void zzae(zzcf zzcfVar, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j);
        try {
            zzcfVar.zzb(bundle);
        } catch (RemoteException e2) {
            this.zzs.zzau().zze().zzb("Error returning long value to wrapper", e2);
        }
    }

    public final void zzaf(zzcf zzcfVar, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i);
        try {
            zzcfVar.zzb(bundle);
        } catch (RemoteException e2) {
            this.zzs.zzau().zze().zzb("Error returning int value to wrapper", e2);
        }
    }

    public final void zzag(zzcf zzcfVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            zzcfVar.zzb(bundle);
        } catch (RemoteException e2) {
            this.zzs.zzau().zze().zzb("Error returning byte array to wrapper", e2);
        }
    }

    public final void zzah(zzcf zzcfVar, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z);
        try {
            zzcfVar.zzb(bundle);
        } catch (RemoteException e2) {
            this.zzs.zzau().zze().zzb("Error returning boolean value to wrapper", e2);
        }
    }

    public final void zzai(zzcf zzcfVar, Bundle bundle) {
        try {
            zzcfVar.zzb(bundle);
        } catch (RemoteException e2) {
            this.zzs.zzau().zze().zzb("Error returning bundle value to wrapper", e2);
        }
    }

    public final void zzaj(zzcf zzcfVar, ArrayList<Bundle> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            zzcfVar.zzb(bundle);
        } catch (RemoteException e2) {
            this.zzs.zzau().zze().zzb("Error returning bundle list to wrapper", e2);
        }
    }

    public final URL zzal(long j, String str, String str2, long j2) {
        try {
            Preconditions.checkNotEmpty(str2);
            Preconditions.checkNotEmpty(str);
            String format = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", String.format("v%s.%s", 42004L, Integer.valueOf(zzZ())), str2, str, Long.valueOf(j2));
            if (str.equals(this.zzs.zzc().zzv())) {
                format = format.concat("&ddl_test=1");
            }
            return new URL(format);
        } catch (IllegalArgumentException | MalformedURLException e2) {
            this.zzs.zzau().zzb().zzb("Failed to create BOW URL for Deferred Deep Link. exception", e2.getMessage());
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgo
    @WorkerThread
    protected final void zzaz() {
        zzg();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                this.zzs.zzau().zze().zza("Utils falling back to Random for random id");
            }
        }
        this.zze.set(nextLong);
    }

    public final long zzd() {
        long andIncrement;
        long j;
        if (this.zze.get() == 0) {
            synchronized (this.zze) {
                long nextLong = new Random(System.nanoTime() ^ this.zzs.zzay().currentTimeMillis()).nextLong();
                int i = this.zzf + 1;
                this.zzf = i;
                j = nextLong + i;
            }
            return j;
        }
        synchronized (this.zze) {
            this.zze.compareAndSet(-1L, 1L);
            andIncrement = this.zze.getAndIncrement();
        }
        return andIncrement;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @EnsuresNonNull({"this.secureRandom"})
    @WorkerThread
    public final SecureRandom zzf() {
        zzg();
        if (this.zzd == null) {
            this.zzd = new SecureRandom();
        }
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle zzi(Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        if (uri != null) {
            try {
                if (uri.isHierarchical()) {
                    str4 = uri.getQueryParameter("utm_campaign");
                    str3 = uri.getQueryParameter("utm_source");
                    str2 = uri.getQueryParameter("utm_medium");
                    str = uri.getQueryParameter("gclid");
                } else {
                    str4 = null;
                    str3 = null;
                    str2 = null;
                    str = null;
                }
                if (TextUtils.isEmpty(str4) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
                    return null;
                }
                Bundle bundle = new Bundle();
                if (!TextUtils.isEmpty(str4)) {
                    bundle.putString("campaign", str4);
                }
                if (!TextUtils.isEmpty(str3)) {
                    bundle.putString("source", str3);
                }
                if (!TextUtils.isEmpty(str2)) {
                    bundle.putString("medium", str2);
                }
                if (!TextUtils.isEmpty(str)) {
                    bundle.putString("gclid", str);
                }
                String queryParameter = uri.getQueryParameter("utm_term");
                if (!TextUtils.isEmpty(queryParameter)) {
                    bundle.putString(FirebaseAnalytics.Param.TERM, queryParameter);
                }
                String queryParameter2 = uri.getQueryParameter("utm_content");
                if (!TextUtils.isEmpty(queryParameter2)) {
                    bundle.putString(FirebaseAnalytics.Param.CONTENT, queryParameter2);
                }
                String queryParameter3 = uri.getQueryParameter(FirebaseAnalytics.Param.ACLID);
                if (!TextUtils.isEmpty(queryParameter3)) {
                    bundle.putString(FirebaseAnalytics.Param.ACLID, queryParameter3);
                }
                String queryParameter4 = uri.getQueryParameter(FirebaseAnalytics.Param.CP1);
                if (!TextUtils.isEmpty(queryParameter4)) {
                    bundle.putString(FirebaseAnalytics.Param.CP1, queryParameter4);
                }
                String queryParameter5 = uri.getQueryParameter("anid");
                if (!TextUtils.isEmpty(queryParameter5)) {
                    bundle.putString("anid", queryParameter5);
                }
                return bundle;
            } catch (UnsupportedOperationException e2) {
                this.zzs.zzau().zze().zzb("Install referrer url isn't a hierarchical URI", e2);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzj(String str, String str2) {
        if (str2 == null) {
            this.zzs.zzau().zzd().zzb("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            this.zzs.zzau().zzd().zzb("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                this.zzs.zzau().zzd().zzc("Name must start with a letter. Type, name", str, str2);
                return false;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    this.zzs.zzau().zzd().zzc("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzk(String str, String str2) {
        if (str2 == null) {
            this.zzs.zzau().zzd().zzb("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            this.zzs.zzau().zzd().zzb("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                if (codePointAt == 95) {
                    codePointAt = 95;
                } else {
                    this.zzs.zzau().zzd().zzc("Name must start with a letter or _ (underscore). Type, name", str, str2);
                    return false;
                }
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    this.zzs.zzau().zzd().zzc("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzl(String str, String[] strArr, String[] strArr2, String str2) {
        if (str2 == null) {
            this.zzs.zzau().zzd().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        Preconditions.checkNotNull(str2);
        String[] strArr3 = zzb;
        for (int i = 0; i < 3; i++) {
            if (str2.startsWith(strArr3[i])) {
                this.zzs.zzau().zzd().zzc("Name starts with reserved prefix. Type, name", str, str2);
                return false;
            }
        }
        if (strArr == null || !zzas(str2, strArr)) {
            return true;
        }
        if (strArr2 != null && zzas(str2, strArr2)) {
            return true;
        }
        this.zzs.zzau().zzd().zzc("Name is reserved. Type, name", str, str2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzm(String str, int i, String str2) {
        if (str2 == null) {
            this.zzs.zzau().zzd().zzb("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        } else {
            this.zzs.zzau().zzd().zzd("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzn(String str) {
        if (!zzk(NotificationCompat.CATEGORY_EVENT, str)) {
            return 2;
        }
        if (!zzl(NotificationCompat.CATEGORY_EVENT, zzgr.zza, zzgr.zzb, str)) {
            return 13;
        }
        this.zzs.zzc();
        return !zzm(NotificationCompat.CATEGORY_EVENT, 40, str) ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzo(String str) {
        if (!zzk("user property", str)) {
            return 6;
        }
        if (!zzl("user property", zzgt.zza, null, str)) {
            return 15;
        }
        this.zzs.zzc();
        return !zzm("user property", 24, str) ? 6 : 0;
    }

    final int zzq(String str) {
        if (!zzj("event param", str)) {
            return 3;
        }
        if (!zzl("event param", null, null, str)) {
            return 14;
        }
        this.zzs.zzc();
        return !zzm("event param", 40, str) ? 3 : 0;
    }

    final int zzr(String str) {
        if (!zzk("event param", str)) {
            return 3;
        }
        if (!zzl("event param", null, null, str)) {
            return 14;
        }
        this.zzs.zzc();
        return !zzm("event param", 40, str) ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzs(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzt(String str, String str2, int i, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String valueOf = String.valueOf(obj);
            if (valueOf.codePointCount(0, valueOf.length()) > i) {
                this.zzs.zzau().zzh().zzd("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
                return false;
            }
        }
        return true;
    }

    final void zzz(String str, String str2, String str3, Bundle bundle, List<String> list, boolean z) {
        int i;
        String str4;
        int i2;
        if (bundle != null) {
            this.zzs.zzc();
            int i3 = 0;
            for (String str5 : new TreeSet(bundle.keySet())) {
                if (list == null || !list.contains(str5)) {
                    i = z ? zzq(str5) : 0;
                    if (i == 0) {
                        i = zzr(str5);
                    }
                } else {
                    i = 0;
                }
                if (i != 0) {
                    zzI(bundle, i, str5, str5, i == 3 ? str5 : null);
                    bundle.remove(str5);
                } else {
                    if (zzs(bundle.get(str5))) {
                        this.zzs.zzau().zzh().zzd("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str2, str3, str5);
                        str4 = str5;
                        i2 = 22;
                    } else {
                        str4 = str5;
                        i2 = zzD(str, str2, str5, bundle.get(str5), bundle, list, z, false);
                    }
                    if (i2 != 0 && !"_ev".equals(str4)) {
                        zzI(bundle, i2, str4, str4, bundle.get(str4));
                        bundle.remove(str4);
                    } else if (zzh(str4) && !zzas(str4, zzgs.zzd) && (i3 = i3 + 1) > 0) {
                        this.zzs.zzau().zzd().zzc("Item cannot contain custom parameters", this.zzs.zzm().zzc(str2), this.zzs.zzm().zzf(bundle));
                        zzan(bundle, 23);
                        bundle.remove(str4);
                    }
                }
            }
        }
    }
}

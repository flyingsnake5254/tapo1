package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.internal.measurement.zzej;
import com.google.android.gms.internal.measurement.zzel;
import com.google.android.gms.internal.measurement.zzeq;
import com.google.android.gms.internal.measurement.zzes;
import com.google.android.gms.internal.measurement.zzex;
import com.google.android.gms.internal.measurement.zzfk;
import com.google.android.gms.internal.measurement.zzfm;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfr;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzfu;
import com.google.android.gms.internal.measurement.zzfv;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzgd;
import com.google.android.gms.internal.measurement.zzgf;
import com.google.android.gms.internal.measurement.zzgg;
import com.google.android.gms.internal.measurement.zzgh;
import com.google.android.gms.internal.measurement.zzjp;
import com.google.android.gms.internal.measurement.zzkn;
import com.google.android.gms.internal.measurement.zzlh;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.tplink.libtpmediastatistics.SSLClient;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.zip.GZIPOutputStream;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
/* loaded from: classes.dex */
public final class zzkp extends zzke {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkp(zzkn zzknVar) {
        super(zzknVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final zzfs zzA(zzfo zzfoVar, String str) {
        for (zzfs zzfsVar : zzfoVar.zza()) {
            if (zzfsVar.zzb().equals(str)) {
                return zzfsVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Object zzB(zzfo zzfoVar, String str) {
        zzfs zzA = zzA(zzfoVar, str);
        if (zzA == null) {
            return null;
        }
        if (zzA.zzc()) {
            return zzA.zzd();
        }
        if (zzA.zze()) {
            return Long.valueOf(zzA.zzf());
        }
        if (zzA.zzi()) {
            return Double.valueOf(zzA.zzj());
        }
        if (zzA.zzm() <= 0) {
            return null;
        }
        List<zzfs> zzk = zzA.zzk();
        ArrayList arrayList = new ArrayList();
        for (zzfs zzfsVar : zzk) {
            if (zzfsVar != null) {
                Bundle bundle = new Bundle();
                for (zzfs zzfsVar2 : zzfsVar.zzk()) {
                    if (zzfsVar2.zzc()) {
                        bundle.putString(zzfsVar2.zzb(), zzfsVar2.zzd());
                    } else if (zzfsVar2.zze()) {
                        bundle.putLong(zzfsVar2.zzb(), zzfsVar2.zzf());
                    } else if (zzfsVar2.zzi()) {
                        bundle.putDouble(zzfsVar2.zzb(), zzfsVar2.zzj());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    private final void zzC(StringBuilder sb, int i, List<zzfs> list) {
        if (list != null) {
            int i2 = i + 1;
            for (zzfs zzfsVar : list) {
                if (zzfsVar != null) {
                    zzE(sb, i2);
                    sb.append("param {\n");
                    Double d2 = null;
                    zzH(sb, i2, AppMeasurementSdk.ConditionalUserProperty.NAME, zzfsVar.zza() ? this.zzs.zzm().zzd(zzfsVar.zzb()) : null);
                    zzH(sb, i2, "string_value", zzfsVar.zzc() ? zzfsVar.zzd() : null);
                    zzH(sb, i2, "int_value", zzfsVar.zze() ? Long.valueOf(zzfsVar.zzf()) : null);
                    if (zzfsVar.zzi()) {
                        d2 = Double.valueOf(zzfsVar.zzj());
                    }
                    zzH(sb, i2, "double_value", d2);
                    if (zzfsVar.zzm() > 0) {
                        zzC(sb, i2, zzfsVar.zzk());
                    }
                    zzE(sb, i2);
                    sb.append("}\n");
                }
            }
        }
    }

    private final void zzD(StringBuilder sb, int i, zzel zzelVar) {
        if (zzelVar != null) {
            zzE(sb, i);
            sb.append("filter {\n");
            if (zzelVar.zze()) {
                zzH(sb, i, "complement", Boolean.valueOf(zzelVar.zzf()));
            }
            if (zzelVar.zzg()) {
                zzH(sb, i, "param_name", this.zzs.zzm().zzd(zzelVar.zzh()));
            }
            if (zzelVar.zza()) {
                int i2 = i + 1;
                zzex zzb = zzelVar.zzb();
                if (zzb != null) {
                    zzE(sb, i2);
                    sb.append("string_filter {\n");
                    if (zzb.zza()) {
                        zzH(sb, i2, "match_type", zzb.zzb().name());
                    }
                    if (zzb.zzc()) {
                        zzH(sb, i2, "expression", zzb.zzd());
                    }
                    if (zzb.zze()) {
                        zzH(sb, i2, "case_sensitive", Boolean.valueOf(zzb.zzf()));
                    }
                    if (zzb.zzh() > 0) {
                        zzE(sb, i2 + 1);
                        sb.append("expression_list {\n");
                        for (String str : zzb.zzg()) {
                            zzE(sb, i2 + 2);
                            sb.append(str);
                            sb.append("\n");
                        }
                        sb.append("}\n");
                    }
                    zzE(sb, i2);
                    sb.append("}\n");
                }
            }
            if (zzelVar.zzc()) {
                zzI(sb, i + 1, "number_filter", zzelVar.zzd());
            }
            zzE(sb, i);
            sb.append("}\n");
        }
    }

    private static final void zzE(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    private static final String zzF(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    private static final void zzG(StringBuilder sb, int i, String str, zzgd zzgdVar) {
        if (zzgdVar != null) {
            zzE(sb, 3);
            sb.append(str);
            sb.append(" {\n");
            if (zzgdVar.zzd() != 0) {
                zzE(sb, 4);
                sb.append("results: ");
                int i2 = 0;
                for (Long l : zzgdVar.zzc()) {
                    i2++;
                    if (i2 != 0) {
                        sb.append(", ");
                    }
                    sb.append(l);
                }
                sb.append('\n');
            }
            if (zzgdVar.zzb() != 0) {
                zzE(sb, 4);
                sb.append("status: ");
                int i3 = 0;
                for (Long l2 : zzgdVar.zza()) {
                    i3++;
                    if (i3 != 0) {
                        sb.append(", ");
                    }
                    sb.append(l2);
                }
                sb.append('\n');
            }
            if (zzgdVar.zzf() != 0) {
                zzE(sb, 4);
                sb.append("dynamic_filter_timestamps: {");
                int i4 = 0;
                for (zzfm zzfmVar : zzgdVar.zze()) {
                    i4++;
                    if (i4 != 0) {
                        sb.append(", ");
                    }
                    sb.append(zzfmVar.zza() ? Integer.valueOf(zzfmVar.zzb()) : null);
                    sb.append(SSLClient.COLON);
                    sb.append(zzfmVar.zzc() ? Long.valueOf(zzfmVar.zzd()) : null);
                }
                sb.append("}\n");
            }
            if (zzgdVar.zzi() != 0) {
                zzE(sb, 4);
                sb.append("sequence_filter_timestamps: {");
                int i5 = 0;
                for (zzgf zzgfVar : zzgdVar.zzh()) {
                    i5++;
                    if (i5 != 0) {
                        sb.append(", ");
                    }
                    sb.append(zzgfVar.zza() ? Integer.valueOf(zzgfVar.zzb()) : null);
                    sb.append(": [");
                    int i6 = 0;
                    for (Long l3 : zzgfVar.zzc()) {
                        long longValue = l3.longValue();
                        i6++;
                        if (i6 != 0) {
                            sb.append(", ");
                        }
                        sb.append(longValue);
                    }
                    sb.append("]");
                }
                sb.append("}\n");
            }
            zzE(sb, 3);
            sb.append("}\n");
        }
    }

    private static final void zzH(StringBuilder sb, int i, String str, Object obj) {
        if (obj != null) {
            zzE(sb, i + 1);
            sb.append(str);
            sb.append(": ");
            sb.append(obj);
            sb.append('\n');
        }
    }

    private static final void zzI(StringBuilder sb, int i, String str, zzeq zzeqVar) {
        if (zzeqVar != null) {
            zzE(sb, i);
            sb.append(str);
            sb.append(" {\n");
            if (zzeqVar.zza()) {
                zzH(sb, i, "comparison_type", zzeqVar.zzb().name());
            }
            if (zzeqVar.zzc()) {
                zzH(sb, i, "match_as_float", Boolean.valueOf(zzeqVar.zzd()));
            }
            if (zzeqVar.zze()) {
                zzH(sb, i, "comparison_value", zzeqVar.zzf());
            }
            if (zzeqVar.zzg()) {
                zzH(sb, i, "min_comparison_value", zzeqVar.zzh());
            }
            if (zzeqVar.zzi()) {
                zzH(sb, i, "max_comparison_value", zzeqVar.zzj());
            }
            zzE(sb, i);
            sb.append("}\n");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzl(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzm(List<Long> list, int i) {
        if (i >= list.size() * 64) {
            return false;
        }
        return ((1 << (i % 64)) & list.get(i / 64).longValue()) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Long> zzn(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i * 64) + i2;
                if (i3 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i3)) {
                    j |= 1 << i2;
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <Builder extends zzlh> Builder zzt(Builder builder, byte[] bArr) throws zzkn {
        zzjp zzb = zzjp.zzb();
        if (zzb != null) {
            return (Builder) builder.zzav(bArr, zzb);
        }
        return (Builder) builder.zzaw(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzu(zzfv zzfvVar, String str) {
        for (int i = 0; i < zzfvVar.zzk(); i++) {
            if (str.equals(zzfvVar.zzl(i).zzc())) {
                return i;
            }
        }
        return -1;
    }

    static List<zzfs> zzv(Bundle[] bundleArr) {
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : bundleArr) {
            if (bundle != null) {
                zzfr zzn = zzfs.zzn();
                for (String str : bundle.keySet()) {
                    zzfr zzn2 = zzfs.zzn();
                    zzn2.zza(str);
                    Object obj = bundle.get(str);
                    if (obj instanceof Long) {
                        zzn2.zzd(((Long) obj).longValue());
                    } else if (obj instanceof String) {
                        zzn2.zzb((String) obj);
                    } else if (obj instanceof Double) {
                        zzn2.zzf(((Double) obj).doubleValue());
                    }
                    zzn.zzi(zzn2);
                }
                if (zzn.zzh() > 0) {
                    arrayList.add(zzn.zzaA());
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzas zzx(zzaa zzaaVar) {
        Bundle bundle = new Bundle();
        String str = "app";
        for (String str2 : zzaaVar.zzf().keySet()) {
            Object zze = zzaaVar.zze(str2);
            if ("_o".equals(str2) && zze != null) {
                str = zze.toString();
            }
            if (zze == null) {
                bundle.putString(str2, null);
            } else if (zze instanceof Long) {
                bundle.putLong(str2, ((Long) zze).longValue());
            } else if (zze instanceof Double) {
                bundle.putDouble(str2, ((Double) zze).doubleValue());
            } else {
                bundle.putString(str2, zze.toString());
            }
        }
        String zzb = zzgr.zzb(zzaaVar.zzb());
        if (zzb == null) {
            zzb = zzaaVar.zzb();
        }
        return new zzas(zzb, new zzaq(bundle), str, zzaaVar.zza());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void zzy(zzfn zzfnVar, String str, Object obj) {
        List<zzfs> zza = zzfnVar.zza();
        int i = 0;
        while (true) {
            if (i >= zza.size()) {
                i = -1;
                break;
            } else if (str.equals(zza.get(i).zzb())) {
                break;
            } else {
                i++;
            }
        }
        zzfr zzn = zzfs.zzn();
        zzn.zza(str);
        if (obj instanceof Long) {
            zzn.zzd(((Long) obj).longValue());
        } else if (obj instanceof String) {
            zzn.zzb((String) obj);
        } else if (obj instanceof Double) {
            zzn.zzf(((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            zzn.zzj(zzv((Bundle[]) obj));
        }
        if (i >= 0) {
            zzfnVar.zze(i, zzn);
        } else {
            zzfnVar.zzg(zzn);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public static final boolean zzz(zzas zzasVar, zzp zzpVar) {
        Preconditions.checkNotNull(zzasVar);
        Preconditions.checkNotNull(zzpVar);
        return !TextUtils.isEmpty(zzpVar.zzb) || !TextUtils.isEmpty(zzpVar.zzq);
    }

    @Override // com.google.android.gms.measurement.internal.zzke
    protected final boolean zzaA() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc(zzgg zzggVar, Object obj) {
        Preconditions.checkNotNull(obj);
        zzggVar.zzd();
        zzggVar.zzf();
        zzggVar.zzh();
        if (obj instanceof String) {
            zzggVar.zzc((String) obj);
        } else if (obj instanceof Long) {
            zzggVar.zze(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzggVar.zzg(((Double) obj).doubleValue());
        } else {
            this.zzs.zzau().zzb().zzb("Ignoring invalid (type) user attribute value", obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzd(zzfr zzfrVar, Object obj) {
        Preconditions.checkNotNull(obj);
        zzfrVar.zzc();
        zzfrVar.zze();
        zzfrVar.zzg();
        zzfrVar.zzk();
        if (obj instanceof String) {
            zzfrVar.zzb((String) obj);
        } else if (obj instanceof Long) {
            zzfrVar.zzd(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzfrVar.zzf(((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            zzfrVar.zzj(zzv((Bundle[]) obj));
        } else {
            this.zzs.zzau().zzb().zzb("Ignoring invalid (type) event param value", obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzfo zzf(zzan zzanVar) {
        zzfn zzk = zzfo.zzk();
        zzk.zzq(zzanVar.zze);
        zzap zzapVar = new zzap(zzanVar.zzf);
        while (zzapVar.hasNext()) {
            String zza = zzapVar.next();
            zzfr zzn = zzfs.zzn();
            zzn.zza(zza);
            Object zza2 = zzanVar.zzf.zza(zza);
            Preconditions.checkNotNull(zza2);
            zzd(zzn, zza2);
            zzk.zzg(zzn);
        }
        return zzk.zzaA();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzh(zzfu zzfuVar) {
        if (zzfuVar == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        for (zzfw zzfwVar : zzfuVar.zza()) {
            if (zzfwVar != null) {
                zzE(sb, 1);
                sb.append("bundle {\n");
                if (zzfwVar.zza()) {
                    zzH(sb, 1, "protocol_version", Integer.valueOf(zzfwVar.zzb()));
                }
                zzH(sb, 1, "platform", zzfwVar.zzt());
                if (zzfwVar.zzC()) {
                    zzH(sb, 1, "gmp_version", Long.valueOf(zzfwVar.zzD()));
                }
                if (zzfwVar.zzE()) {
                    zzH(sb, 1, "uploading_gmp_version", Long.valueOf(zzfwVar.zzF()));
                }
                if (zzfwVar.zzae()) {
                    zzH(sb, 1, "dynamite_version", Long.valueOf(zzfwVar.zzaf()));
                }
                if (zzfwVar.zzW()) {
                    zzH(sb, 1, "config_version", Long.valueOf(zzfwVar.zzX()));
                }
                zzH(sb, 1, "gmp_app_id", zzfwVar.zzP());
                zzH(sb, 1, "admob_app_id", zzfwVar.zzad());
                zzH(sb, 1, "app_id", zzfwVar.zzA());
                zzH(sb, 1, "app_version", zzfwVar.zzB());
                if (zzfwVar.zzU()) {
                    zzH(sb, 1, "app_version_major", Integer.valueOf(zzfwVar.zzV()));
                }
                zzH(sb, 1, "firebase_instance_id", zzfwVar.zzT());
                if (zzfwVar.zzK()) {
                    zzH(sb, 1, "dev_cert_hash", Long.valueOf(zzfwVar.zzL()));
                }
                zzH(sb, 1, "app_store", zzfwVar.zzz());
                if (zzfwVar.zzi()) {
                    zzH(sb, 1, "upload_timestamp_millis", Long.valueOf(zzfwVar.zzj()));
                }
                if (zzfwVar.zzk()) {
                    zzH(sb, 1, "start_timestamp_millis", Long.valueOf(zzfwVar.zzm()));
                }
                if (zzfwVar.zzn()) {
                    zzH(sb, 1, "end_timestamp_millis", Long.valueOf(zzfwVar.zzo()));
                }
                if (zzfwVar.zzp()) {
                    zzH(sb, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(zzfwVar.zzq()));
                }
                if (zzfwVar.zzr()) {
                    zzH(sb, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(zzfwVar.zzs()));
                }
                zzH(sb, 1, "app_instance_id", zzfwVar.zzJ());
                zzH(sb, 1, "resettable_device_id", zzfwVar.zzG());
                zzH(sb, 1, "ds_id", zzfwVar.zzaa());
                if (zzfwVar.zzH()) {
                    zzH(sb, 1, "limited_ad_tracking", Boolean.valueOf(zzfwVar.zzI()));
                }
                zzH(sb, 1, "os_version", zzfwVar.zzu());
                zzH(sb, 1, "device_model", zzfwVar.zzv());
                zzH(sb, 1, "user_default_language", zzfwVar.zzw());
                if (zzfwVar.zzx()) {
                    zzH(sb, 1, "time_zone_offset_minutes", Integer.valueOf(zzfwVar.zzy()));
                }
                if (zzfwVar.zzM()) {
                    zzH(sb, 1, "bundle_sequential_index", Integer.valueOf(zzfwVar.zzN()));
                }
                if (zzfwVar.zzQ()) {
                    zzH(sb, 1, "service_upload", Boolean.valueOf(zzfwVar.zzR()));
                }
                zzH(sb, 1, "health_monitor", zzfwVar.zzO());
                if (!this.zzs.zzc().zzn(null, zzea.zzat) && zzfwVar.zzY() && zzfwVar.zzZ() != 0) {
                    zzH(sb, 1, "android_id", Long.valueOf(zzfwVar.zzZ()));
                }
                if (zzfwVar.zzab()) {
                    zzH(sb, 1, "retry_counter", Integer.valueOf(zzfwVar.zzac()));
                }
                if (zzfwVar.zzah()) {
                    zzH(sb, 1, "consent_signals", zzfwVar.zzai());
                }
                List<zzgh> zzf = zzfwVar.zzf();
                if (zzf != null) {
                    for (zzgh zzghVar : zzf) {
                        if (zzghVar != null) {
                            zzE(sb, 2);
                            sb.append("user_property {\n");
                            zzH(sb, 2, "set_timestamp_millis", zzghVar.zza() ? Long.valueOf(zzghVar.zzb()) : null);
                            zzH(sb, 2, AppMeasurementSdk.ConditionalUserProperty.NAME, this.zzs.zzm().zze(zzghVar.zzc()));
                            zzH(sb, 2, "string_value", zzghVar.zze());
                            zzH(sb, 2, "int_value", zzghVar.zzf() ? Long.valueOf(zzghVar.zzg()) : null);
                            zzH(sb, 2, "double_value", zzghVar.zzh() ? Double.valueOf(zzghVar.zzi()) : null);
                            zzE(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<zzfk> zzS = zzfwVar.zzS();
                if (zzS != null) {
                    for (zzfk zzfkVar : zzS) {
                        if (zzfkVar != null) {
                            zzE(sb, 2);
                            sb.append("audience_membership {\n");
                            if (zzfkVar.zza()) {
                                zzH(sb, 2, "audience_id", Integer.valueOf(zzfkVar.zzb()));
                            }
                            if (zzfkVar.zzf()) {
                                zzH(sb, 2, "new_audience", Boolean.valueOf(zzfkVar.zzg()));
                            }
                            zzG(sb, 2, "current_data", zzfkVar.zzc());
                            if (zzfkVar.zzd()) {
                                zzG(sb, 2, "previous_data", zzfkVar.zze());
                            }
                            zzE(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<zzfo> zzc = zzfwVar.zzc();
                if (zzc != null) {
                    for (zzfo zzfoVar : zzc) {
                        if (zzfoVar != null) {
                            zzE(sb, 2);
                            sb.append("event {\n");
                            zzH(sb, 2, AppMeasurementSdk.ConditionalUserProperty.NAME, this.zzs.zzm().zzc(zzfoVar.zzd()));
                            if (zzfoVar.zze()) {
                                zzH(sb, 2, "timestamp_millis", Long.valueOf(zzfoVar.zzf()));
                            }
                            if (zzfoVar.zzg()) {
                                zzH(sb, 2, "previous_timestamp_millis", Long.valueOf(zzfoVar.zzh()));
                            }
                            if (zzfoVar.zzi()) {
                                zzH(sb, 2, "count", Integer.valueOf(zzfoVar.zzj()));
                            }
                            if (zzfoVar.zzb() != 0) {
                                zzC(sb, 2, zzfoVar.zza());
                            }
                            zzE(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                zzE(sb, 1);
                sb.append("}\n");
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzi(zzej zzejVar) {
        if (zzejVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (zzejVar.zza()) {
            zzH(sb, 0, "filter_id", Integer.valueOf(zzejVar.zzb()));
        }
        zzH(sb, 0, "event_name", this.zzs.zzm().zzc(zzejVar.zzc()));
        String zzF = zzF(zzejVar.zzi(), zzejVar.zzj(), zzejVar.zzm());
        if (!zzF.isEmpty()) {
            zzH(sb, 0, "filter_type", zzF);
        }
        if (zzejVar.zzg()) {
            zzI(sb, 1, "event_count_filter", zzejVar.zzh());
        }
        if (zzejVar.zze() > 0) {
            sb.append("  filters {\n");
            for (zzel zzelVar : zzejVar.zzd()) {
                zzD(sb, 2, zzelVar);
            }
        }
        zzE(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzj(zzes zzesVar) {
        if (zzesVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (zzesVar.zza()) {
            zzH(sb, 0, "filter_id", Integer.valueOf(zzesVar.zzb()));
        }
        zzH(sb, 0, "property_name", this.zzs.zzm().zze(zzesVar.zzc()));
        String zzF = zzF(zzesVar.zze(), zzesVar.zzf(), zzesVar.zzh());
        if (!zzF.isEmpty()) {
            zzH(sb, 0, "filter_type", zzF);
        }
        zzD(sb, 1, zzesVar.zzd());
        sb.append("}\n");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <T extends Parcelable> T zzk(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            return creator.createFromParcel(obtain);
        } catch (SafeParcelReader.ParseException unused) {
            this.zzs.zzau().zzb().zza("Failed to load parcelable from buffer");
            return null;
        } finally {
            obtain.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<Long> zzo(List<Long> list, List<Integer> list2) {
        ArrayList arrayList = new ArrayList(list);
        for (Integer num : list2) {
            if (num.intValue() < 0) {
                this.zzs.zzau().zze().zzb("Ignoring negative bit index to be cleared", num);
            } else {
                int intValue = num.intValue() / 64;
                if (intValue >= arrayList.size()) {
                    this.zzs.zzau().zze().zzc("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        size = arrayList.size() - 1;
        while (size >= 0 && ((Long) arrayList.get(size)).longValue() == 0) {
            size--;
        }
        return arrayList.subList(0, size);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzq(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(this.zzs.zzay().currentTimeMillis() - j) > j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final long zzr(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        this.zzs.zzl().zzg();
        MessageDigest zzN = zzku.zzN();
        if (zzN != null) {
            return zzku.zzO(zzN.digest(bArr));
        }
        this.zzs.zzau().zzb().zza("Failed to get MD5");
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] zzs(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            this.zzs.zzau().zzb().zzb("Failed to gzip content", e2);
            throw e2;
        }
    }
}

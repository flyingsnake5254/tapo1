package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
public final class zzem extends zzgo {
    @GuardedBy("this")
    private String zzc;
    private char zza = 0;
    private long zzb = -1;
    private final zzek zzd = new zzek(this, 6, false, false);
    private final zzek zze = new zzek(this, 6, true, false);
    private final zzek zzf = new zzek(this, 6, false, true);
    private final zzek zzg = new zzek(this, 5, false, false);
    private final zzek zzh = new zzek(this, 5, true, false);
    private final zzek zzi = new zzek(this, 5, false, true);
    private final zzek zzj = new zzek(this, 4, false, false);
    private final zzek zzk = new zzek(this, 3, false, false);
    private final zzek zzl = new zzek(this, 2, false, false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzem(zzfu zzfuVar) {
        super(zzfuVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object zzl(String str) {
        if (str == null) {
            return null;
        }
        return new zzel(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzo(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        String zzp = zzp(z, obj);
        String zzp2 = zzp(z, obj2);
        String zzp3 = zzp(z, obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(zzp)) {
            sb.append(str2);
            sb.append(zzp);
            str2 = str3;
        }
        if (!TextUtils.isEmpty(zzp2)) {
            sb.append(str2);
            sb.append(zzp2);
        } else {
            str3 = str2;
        }
        if (!TextUtils.isEmpty(zzp3)) {
            sb.append(str3);
            sb.append(zzp3);
        }
        return sb.toString();
    }

    @VisibleForTesting
    static String zzp(boolean z, Object obj) {
        String str;
        String className;
        String str2 = "";
        if (obj == null) {
            return str2;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        int i = 0;
        if (obj instanceof Long) {
            if (!z) {
                return String.valueOf(obj);
            }
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) < 100) {
                return String.valueOf(obj);
            }
            if (String.valueOf(obj).charAt(0) == '-') {
                str2 = "-";
            }
            String valueOf = String.valueOf(Math.abs(l.longValue()));
            long round = Math.round(Math.pow(10.0d, valueOf.length() - 1));
            long round2 = Math.round(Math.pow(10.0d, valueOf.length()) - 1.0d);
            StringBuilder sb = new StringBuilder(str2.length() + 43 + str2.length());
            sb.append(str2);
            sb.append(round);
            sb.append("...");
            sb.append(str2);
            sb.append(round2);
            return sb.toString();
        } else if (obj instanceof Boolean) {
            return String.valueOf(obj);
        } else {
            if (obj instanceof Throwable) {
                Throwable th = (Throwable) obj;
                StringBuilder sb2 = new StringBuilder(z ? th.getClass().getName() : th.toString());
                String zzz = zzz(zzfu.class.getCanonicalName());
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTrace[i];
                    if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && zzz(className).equals(zzz)) {
                        sb2.append(": ");
                        sb2.append(stackTraceElement);
                        break;
                    }
                    i++;
                }
                return sb2.toString();
            } else if (!(obj instanceof zzel)) {
                return z ? "-" : String.valueOf(obj);
            } else {
                str = ((zzel) obj).zza;
                return str;
            }
        }
    }

    private static String zzz(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf == -1 ? str : str.substring(0, lastIndexOf);
    }

    @Override // com.google.android.gms.measurement.internal.zzgo
    protected final boolean zza() {
        return false;
    }

    public final zzek zzb() {
        return this.zzd;
    }

    public final zzek zzc() {
        return this.zze;
    }

    public final zzek zzd() {
        return this.zzf;
    }

    public final zzek zze() {
        return this.zzg;
    }

    public final zzek zzf() {
        return this.zzh;
    }

    public final zzek zzh() {
        return this.zzi;
    }

    public final zzek zzi() {
        return this.zzj;
    }

    public final zzek zzj() {
        return this.zzk;
    }

    public final zzek zzk() {
        return this.zzl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzm(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && Log.isLoggable(zzn(), i)) {
            Log.println(i, zzn(), zzo(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            Preconditions.checkNotNull(str);
            zzfr zzj = this.zzs.zzj();
            if (zzj == null) {
                Log.println(6, zzn(), "Scheduler not set. Not logging error/warn");
            } else if (!zzj.zzu()) {
                Log.println(6, zzn(), "Scheduler not initialized. Not logging error/warn");
            } else {
                zzj.zzh(new zzej(this, i >= 9 ? 8 : i, str, obj, obj2, obj3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    @EnsuresNonNull({"logTagDoNotUseDirectly"})
    public final String zzn() {
        String str;
        synchronized (this) {
            if (this.zzc == null) {
                if (this.zzs.zzt() != null) {
                    this.zzc = this.zzs.zzt();
                } else {
                    this.zzc = this.zzs.zzc().zzb();
                }
            }
            Preconditions.checkNotNull(this.zzc);
            str = this.zzc;
        }
        return str;
    }
}

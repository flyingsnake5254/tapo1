package com.google.android.gms.measurement.internal;

import com.github.mikephil.charting.utils.Utils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzep;
import com.google.android.gms.internal.measurement.zzeq;
import com.google.android.gms.internal.measurement.zzew;
import com.google.android.gms.internal.measurement.zzex;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
/* loaded from: classes.dex */
public abstract class zzw {
    final String zzb;
    final int zzc;
    Boolean zzd;
    Boolean zze;
    Long zzf;
    Long zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzw(String str, int i) {
        this.zzb = str;
        this.zzc = i;
    }

    private static Boolean zzd(String str, zzew zzewVar, boolean z, String str2, List<String> list, String str3, zzem zzemVar) {
        if (zzewVar == zzew.IN_LIST) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && zzewVar != zzew.REGEXP) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        zzep zzepVar = zzep.UNKNOWN_COMPARISON_TYPE;
        switch (zzewVar.ordinal()) {
            case 1:
                if (str3 == null) {
                    return null;
                }
                try {
                    return Boolean.valueOf(Pattern.compile(str3, true != z ? 66 : 0).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (zzemVar != null) {
                        zzemVar.zze().zzb("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                if (list == null) {
                    return null;
                }
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public static Boolean zze(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public static Boolean zzf(String str, zzex zzexVar, zzem zzemVar) {
        String str2;
        List<String> list;
        Preconditions.checkNotNull(zzexVar);
        if (str == null || !zzexVar.zza() || zzexVar.zzb() == zzew.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        zzew zzb = zzexVar.zzb();
        zzew zzewVar = zzew.IN_LIST;
        if (zzb == zzewVar) {
            if (zzexVar.zzh() == 0) {
                return null;
            }
        } else if (!zzexVar.zzc()) {
            return null;
        }
        zzew zzb2 = zzexVar.zzb();
        boolean zzf = zzexVar.zzf();
        if (zzf || zzb2 == zzew.REGEXP || zzb2 == zzewVar) {
            str2 = zzexVar.zzd();
        } else {
            str2 = zzexVar.zzd().toUpperCase(Locale.ENGLISH);
        }
        if (zzexVar.zzh() == 0) {
            list = null;
        } else {
            list = zzexVar.zzg();
            if (!zzf) {
                ArrayList arrayList = new ArrayList(list.size());
                for (String str3 : list) {
                    arrayList.add(str3.toUpperCase(Locale.ENGLISH));
                }
                list = Collections.unmodifiableList(arrayList);
            }
        }
        return zzd(str, zzb2, zzf, str2, list, zzb2 == zzew.REGEXP ? str2 : null, zzemVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean zzg(long j, zzeq zzeqVar) {
        try {
            return zzj(new BigDecimal(j), zzeqVar, Utils.DOUBLE_EPSILON);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean zzh(double d2, zzeq zzeqVar) {
        try {
            return zzj(new BigDecimal(d2), zzeqVar, Math.ulp(d2));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean zzi(String str, zzeq zzeqVar) {
        if (!zzkp.zzl(str)) {
            return null;
        }
        try {
            return zzj(new BigDecimal(str), zzeqVar, Utils.DOUBLE_EPSILON);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @VisibleForTesting
    static Boolean zzj(BigDecimal bigDecimal, zzeq zzeqVar, double d2) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        Preconditions.checkNotNull(zzeqVar);
        if (zzeqVar.zza() && zzeqVar.zzb() != zzep.UNKNOWN_COMPARISON_TYPE) {
            zzep zzb = zzeqVar.zzb();
            zzep zzepVar = zzep.BETWEEN;
            if (zzb == zzepVar) {
                if (!zzeqVar.zzg() || !zzeqVar.zzi()) {
                    return null;
                }
            } else if (!zzeqVar.zze()) {
                return null;
            }
            zzep zzb2 = zzeqVar.zzb();
            if (zzeqVar.zzb() == zzepVar) {
                if (zzkp.zzl(zzeqVar.zzh()) && zzkp.zzl(zzeqVar.zzj())) {
                    try {
                        bigDecimal2 = new BigDecimal(zzeqVar.zzh());
                        bigDecimal3 = new BigDecimal(zzeqVar.zzj());
                        bigDecimal4 = null;
                    } catch (NumberFormatException unused) {
                    }
                }
                return null;
            } else if (!zzkp.zzl(zzeqVar.zzf())) {
                return null;
            } else {
                try {
                    bigDecimal4 = new BigDecimal(zzeqVar.zzf());
                    bigDecimal2 = null;
                    bigDecimal3 = null;
                } catch (NumberFormatException unused2) {
                }
            }
            if (zzb2 == zzepVar) {
                if (bigDecimal2 == null) {
                    return null;
                }
            } else if (bigDecimal4 == null) {
                return null;
            }
            zzew zzewVar = zzew.UNKNOWN_MATCH_TYPE;
            int ordinal = zzb2.ordinal();
            boolean z = true;
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal != 3) {
                        if (ordinal != 4 || bigDecimal2 == null) {
                            return null;
                        }
                        if (bigDecimal.compareTo(bigDecimal2) < 0 || bigDecimal.compareTo(bigDecimal3) > 0) {
                            z = false;
                        }
                        return Boolean.valueOf(z);
                    } else if (bigDecimal4 == null) {
                        return null;
                    } else {
                        if (d2 != Utils.DOUBLE_EPSILON) {
                            if (bigDecimal.compareTo(bigDecimal4.subtract(new BigDecimal(d2).multiply(new BigDecimal(2)))) <= 0 || bigDecimal.compareTo(bigDecimal4.add(new BigDecimal(d2).multiply(new BigDecimal(2)))) >= 0) {
                                z = false;
                            }
                            return Boolean.valueOf(z);
                        }
                        if (bigDecimal.compareTo(bigDecimal4) != 0) {
                            z = false;
                        }
                        return Boolean.valueOf(z);
                    }
                } else if (bigDecimal4 == null) {
                    return null;
                } else {
                    if (bigDecimal.compareTo(bigDecimal4) <= 0) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                }
            } else if (bigDecimal4 == null) {
                return null;
            } else {
                if (bigDecimal.compareTo(bigDecimal4) >= 0) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zza();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean zzb();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean zzc();
}

package com.google.android.gms.internal.measurement;

import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
public final class zzhp extends zzht<Double> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhp(zzhr zzhrVar, String str, Double d2, boolean z) {
        super(zzhrVar, "measurement.test.double_flag", d2, true, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzht
    final /* bridge */ /* synthetic */ Double zza(Object obj) {
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            String zzd = super.zzd();
            String str = (String) obj;
            StringBuilder sb = new StringBuilder(String.valueOf(zzd).length() + 27 + str.length());
            sb.append("Invalid double value for ");
            sb.append(zzd);
            sb.append(": ");
            sb.append(str);
            Log.e("PhenotypeFlag", sb.toString());
            return null;
        }
    }
}

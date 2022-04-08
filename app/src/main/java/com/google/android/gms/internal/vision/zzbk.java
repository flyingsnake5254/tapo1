package com.google.android.gms.internal.vision;

import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
public final class zzbk extends zzbj<Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbk(zzbp zzbpVar, String str, Boolean bool, boolean z) {
        super(zzbpVar, str, bool, z, null);
    }

    @Override // com.google.android.gms.internal.vision.zzbj
    final /* synthetic */ Boolean zza(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (zzaq.zzfc.matcher(str).matches()) {
                return Boolean.TRUE;
            }
            if (zzaq.zzfd.matcher(str).matches()) {
                return Boolean.FALSE;
            }
        }
        String zzad = super.zzad();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(zzad).length() + 28 + valueOf.length());
        sb.append("Invalid boolean value for ");
        sb.append(zzad);
        sb.append(": ");
        sb.append(valueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}

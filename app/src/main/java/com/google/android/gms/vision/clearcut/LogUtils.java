package com.google.android.gms.vision.clearcut;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.vision.zzef;
import com.google.android.gms.internal.vision.zzgx;
import com.google.android.gms.vision.L;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
@Keep
/* loaded from: classes.dex */
public class LogUtils {
    public static zzef.zza zza(Context context) {
        zzef.zza.C0147zza zzl = zzef.zza.zzck().zzl(context.getPackageName());
        String zzb = zzb(context);
        if (zzb != null) {
            zzl.zzm(zzb);
        }
        return (zzef.zza) ((zzgx) zzl.zzgd());
    }

    @Nullable
    private static String zzb(Context context) {
        try {
            return Wrappers.packageManager(context).getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            L.e(e2, "Unable to find calling package info for %s", context.getPackageName());
            return null;
        }
    }
}

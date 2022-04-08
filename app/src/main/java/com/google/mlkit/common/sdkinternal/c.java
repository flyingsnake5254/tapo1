package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.Locale;

/* compiled from: com.google.mlkit:common@@16.0.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public class c {
    private static final GmsLogger a = new GmsLogger("CommonUtils", "");

    @KeepForSdk
    public static String a(@NonNull Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException e2) {
            GmsLogger gmsLogger = a;
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(valueOf.length() + 48);
            sb.append("Exception thrown when trying to get app version ");
            sb.append(valueOf);
            gmsLogger.e("CommonUtils", sb.toString());
            return "";
        }
    }

    @NonNull
    @KeepForSdk
    public static String b(@NonNull Locale locale) {
        if (PlatformVersion.isAtLeastLollipop()) {
            return locale.toLanguageTag();
        }
        StringBuilder sb = new StringBuilder(locale.getLanguage());
        if (!TextUtils.isEmpty(locale.getCountry())) {
            sb.append("-");
            sb.append(locale.getCountry());
        }
        if (!TextUtils.isEmpty(locale.getVariant())) {
            sb.append("-");
            sb.append(locale.getVariant());
        }
        return sb.toString();
    }
}

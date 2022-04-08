package com.tplink.iot.view.welcome;

import android.content.Context;
import b.d.w.c.a;
import com.google.android.gms.common.GoogleApiAvailabilityLight;

/* compiled from: GoogleSuitCheckUtil.java */
/* loaded from: classes2.dex */
public class b {
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
        if (r4.resolveActivity(r6) == null) goto L_0x0045;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r6) {
        /*
            java.lang.String r0 = "GoogleSuitCheck"
            java.lang.String r1 = "com.android.vending"
            android.content.pm.PackageManager r6 = r6.getPackageManager()
            r2 = 0
            r3 = 1
            android.content.pm.PackageInfo r4 = r6.getPackageInfo(r1, r3)     // Catch: Exception -> 0x005a
            if (r4 == 0) goto L_0x0045
            android.content.pm.ApplicationInfo r4 = r4.applicationInfo     // Catch: Exception -> 0x005a
            if (r4 == 0) goto L_0x0045
            java.lang.CharSequence r4 = r4.loadLabel(r6)     // Catch: Exception -> 0x005a
            java.lang.String r4 = (java.lang.String) r4     // Catch: Exception -> 0x005a
            if (r4 == 0) goto L_0x0025
            java.lang.String r5 = "Market"
            boolean r4 = r4.equals(r5)     // Catch: Exception -> 0x005a
            if (r4 != 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r3 = 0
        L_0x0026:
            if (r3 == 0) goto L_0x0044
            android.content.Intent r4 = new android.content.Intent     // Catch: Exception -> 0x0042
            java.lang.String r5 = "android.intent.action.VIEW"
            r4.<init>(r5)     // Catch: Exception -> 0x0042
            java.lang.String r5 = "https://play.google.com/store/apps/details?id=com.tplink.iot"
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch: Exception -> 0x0042
            r4.setData(r5)     // Catch: Exception -> 0x0042
            r4.setPackage(r1)     // Catch: Exception -> 0x0042
            android.content.ComponentName r6 = r4.resolveActivity(r6)     // Catch: Exception -> 0x0042
            if (r6 != 0) goto L_0x0044
            goto L_0x0045
        L_0x0042:
            r2 = r3
            goto L_0x005a
        L_0x0044:
            r2 = r3
        L_0x0045:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: Exception -> 0x005a
            r6.<init>()     // Catch: Exception -> 0x005a
            java.lang.String r1 = "googlePlay is installed="
            r6.append(r1)     // Catch: Exception -> 0x005a
            r6.append(r2)     // Catch: Exception -> 0x005a
            java.lang.String r6 = r6.toString()     // Catch: Exception -> 0x005a
            b.d.w.c.a.c(r0, r6)     // Catch: Exception -> 0x005a
            goto L_0x005f
        L_0x005a:
            java.lang.String r6 = "not install googlePlay"
            b.d.w.c.a.c(r0, r6)
        L_0x005f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.view.welcome.b.a(android.content.Context):boolean");
    }

    public static boolean b(Context context) {
        if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context) == 0) {
            a.c("GoogleSuitCheck", "google service ok");
            return true;
        }
        a.c("GoogleSuitCheck", "google service error");
        return false;
    }
}

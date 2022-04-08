package com.tplink.libtpanalytics.utils;

import android.os.Build;
import java.util.Locale;

/* compiled from: SystemUtils.java */
/* loaded from: classes3.dex */
public class h {
    public static String a() {
        return Build.BRAND;
    }

    public static String b() {
        return Locale.getDefault().getCountry();
    }

    public static String c() {
        return e.a(Locale.getDefault());
    }

    public static String d() {
        return Build.MODEL;
    }

    public static String e() {
        return Build.VERSION.RELEASE;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int f() {
        /*
            java.util.TimeZone r0 = java.util.TimeZone.getDefault()
            r1 = 0
            java.lang.String r0 = r0.getDisplayName(r1, r1)
            java.lang.String r1 = "-"
            boolean r1 = r0.contains(r1)
            java.lang.String r2 = ".*(\\d{2}):(\\d{2}).*"
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.util.regex.Matcher r0 = r2.matcher(r0)
            boolean r2 = r0.matches()
            if (r2 == 0) goto L_0x002f
            r2 = 1
            java.lang.String r0 = r0.group(r2)
            if (r0 == 0) goto L_0x002f
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: Exception -> 0x002b
            goto L_0x0031
        L_0x002b:
            r0 = move-exception
            r0.printStackTrace()
        L_0x002f:
            r0 = 8
        L_0x0031:
            if (r1 == 0) goto L_0x0034
            int r0 = -r0
        L_0x0034:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.libtpanalytics.utils.h.f():int");
    }
}

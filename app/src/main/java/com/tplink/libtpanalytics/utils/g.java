package com.tplink.libtpanalytics.utils;

import android.content.Context;
import android.content.pm.PackageManager;

/* compiled from: PackageUtils.java */
/* loaded from: classes3.dex */
public class g {
    public static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "v_xxx";
        }
    }
}

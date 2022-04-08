package com.tplink.iot.view.quicksetup.base.wifi;

import android.app.Activity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

/* compiled from: WiFiPermissionHandler.java */
/* loaded from: classes2.dex */
public class b {
    private static final String[] a = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};

    public static void a(int i, String[] strArr, int[] iArr, a aVar) {
        if (i == 25) {
            if (b(iArr)) {
                aVar.b();
            } else {
                aVar.a();
            }
        }
    }

    private static boolean b(int[] iArr) {
        if (iArr.length < a.length) {
            return false;
        }
        for (int i : iArr) {
            if (Integer.valueOf(i).intValue() != 0) {
                return false;
            }
        }
        return true;
    }

    public static void c(Activity activity) {
        ActivityCompat.requestPermissions(activity, a, 25);
    }

    public static void d(Fragment fragment) {
        fragment.requestPermissions(a, 25);
    }
}

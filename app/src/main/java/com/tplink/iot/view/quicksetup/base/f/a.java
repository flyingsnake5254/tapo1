package com.tplink.iot.view.quicksetup.base.f;

import android.content.Context;
import android.location.LocationManager;
import androidx.core.content.ContextCompat;
import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: LocationPrepareUtils.java */
/* loaded from: classes2.dex */
public class a {
    public static boolean a(Context context) {
        return b(context) && c(context);
    }

    public static boolean b(Context context) {
        LocationManager locationManager;
        if (context == null || (locationManager = (LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION)) == null) {
            return false;
        }
        return locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network");
    }

    public static boolean c(Context context) {
        return context != null && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0;
    }
}

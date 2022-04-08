package com.tplink.iot.view.quicksetup.base.ble;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: BlePrepareUtils.java */
/* loaded from: classes2.dex */
public class d {
    private static BluetoothAdapter a(Context context) {
        BluetoothManager bluetoothManager;
        if (context == null || (bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth")) == null) {
            return null;
        }
        return bluetoothManager.getAdapter();
    }

    public static boolean b(Activity activity) {
        return d(activity) && c(activity) && f(activity);
    }

    public static boolean c(Activity activity) {
        if (activity == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return e(activity);
        }
        return true;
    }

    public static boolean d(Activity activity) {
        BluetoothAdapter a = a(activity);
        return a != null && a.isEnabled();
    }

    private static boolean e(Activity activity) {
        LocationManager locationManager;
        if (activity == null || (locationManager = (LocationManager) activity.getSystemService(FirebaseAnalytics.Param.LOCATION)) == null) {
            return false;
        }
        return locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network");
    }

    public static boolean f(Activity activity) {
        if (activity == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return ContextCompat.checkSelfPermission(activity, "android.permission.ACCESS_COARSE_LOCATION") == 0 && ContextCompat.checkSelfPermission(activity, "android.permission.ACCESS_FINE_LOCATION") == 0;
        }
        return true;
    }

    public static boolean g(Activity activity) {
        BluetoothAdapter a = a(activity);
        if (a != null) {
            return a.enable();
        }
        return false;
    }
}

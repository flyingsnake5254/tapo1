package com.tplink.iot.view.ipcamera.base;

import android.content.Context;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

/* compiled from: OnBoardingUtils.java */
/* loaded from: classes2.dex */
public class e {
    public static boolean a(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        return wifiManager.getWifiState() == 3 && connectionInfo != null && connectionInfo.getSupplicantState() == SupplicantState.COMPLETED;
    }
}

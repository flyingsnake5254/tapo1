package com.tplink.libtpanalytics.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.tplink.libtpmediastatistics.SSLClient;
import java.net.NetworkInterface;
import java.util.Collections;

/* compiled from: IpUtils.java */
/* loaded from: classes3.dex */
public class d {
    public static String a(Context context) {
        String str = "";
        if (Build.VERSION.SDK_INT < 23) {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            return (connectionInfo == null || connectionInfo.getMacAddress() == null) ? str : connectionInfo.getMacAddress().toUpperCase().replaceAll(SSLClient.COLON, "-");
        }
        try {
            loop0: while (true) {
                str = str;
                for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                    try {
                        if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                            byte[] hardwareAddress = networkInterface.getHardwareAddress();
                            if (hardwareAddress == null) {
                                break;
                            }
                            StringBuilder sb = new StringBuilder();
                            int length = hardwareAddress.length;
                            for (int i = 0; i < length; i++) {
                                sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
                            }
                            if (sb.length() > 0) {
                                sb.deleteCharAt(sb.length() - 1);
                            }
                            str = sb.toString();
                        }
                    } catch (Exception unused) {
                        str = str;
                        return str.toUpperCase().replaceAll(SSLClient.COLON, "-");
                    }
                }
            }
        } catch (Exception unused2) {
        }
        return str.toUpperCase().replaceAll(SSLClient.COLON, "-");
    }
}

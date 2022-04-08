package com.tplink.libtpwifi;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.MacAddress;
import android.net.Network;
import android.net.NetworkRequest;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiNetworkSpecifier;
import android.os.Build;
import android.text.TextUtils;
import com.tplink.libtpmediastatistics.SSLClient;
import java.util.Collections;
import java.util.List;

/* compiled from: TPWifiManager.java */
/* loaded from: classes3.dex */
public class b {
    private static WifiManager a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile b f15147b;

    /* renamed from: c  reason: collision with root package name */
    private Context f15148c;

    /* renamed from: d  reason: collision with root package name */
    private ConnectivityManager.NetworkCallback f15149d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TPWifiManager.java */
    /* loaded from: classes3.dex */
    public class a extends ConnectivityManager.NetworkCallback {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            super.onLost(network);
            b.this.t();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            super.onUnavailable();
            b.this.t();
            b.this.c("com.tplink.tpm5.wifi.le.ACTION_WIFI_CONNECT_FAIL", this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2) {
        Intent intent = new Intent(str);
        intent.putExtra("tp_wifi_extra_ssid", str2);
        this.f15148c.sendBroadcast(intent);
    }

    private void f(String str, String str2, String str3, TPWifiCipherType tPWifiCipherType) {
        WifiConfiguration p;
        WifiConfiguration i = i(str, str2, str3, tPWifiCipherType);
        int addNetwork = a.addNetwork(i);
        if (addNetwork == -1 && (p = p(str)) != null) {
            addNetwork = p.networkId;
        }
        if (addNetwork != -1) {
            a.disconnect();
            boolean enableNetwork = a.enableNetwork(addNetwork, true);
            u(i);
            if (Build.VERSION.SDK_INT <= 22) {
                a.reconnect();
            }
            if (!enableNetwork) {
                c("com.tplink.tpm5.wifi.le.ACTION_WIFI_CONNECT_FAIL", str);
                return;
            }
            return;
        }
        c("com.tplink.tpm5.wifi.le.ACTION_WIFI_CONNECT_FAIL", str);
    }

    @TargetApi(29)
    private void g(String str, String str2, String str3, TPWifiCipherType tPWifiCipherType) {
        t();
        this.f15149d = new a(str);
        ((ConnectivityManager) this.f15148c.getSystemService("connectivity")).requestNetwork(h(str, str2, str3, tPWifiCipherType), this.f15149d);
    }

    @TargetApi(29)
    private NetworkRequest h(String str, String str2, String str3, TPWifiCipherType tPWifiCipherType) {
        WifiNetworkSpecifier.Builder ssid = new WifiNetworkSpecifier.Builder().setSsid(str);
        if (!TextUtils.isEmpty(str3)) {
            ssid.setBssid(MacAddress.fromString(str3));
        }
        if (!TextUtils.isEmpty(str2)) {
            if (tPWifiCipherType == TPWifiCipherType.WIFI_CIPHER_WPA3) {
                ssid.setWpa3Passphrase(str2);
            } else {
                ssid.setWpa2Passphrase(str2);
            }
        }
        return new NetworkRequest.Builder().addTransportType(1).removeCapability(12).setNetworkSpecifier(ssid.build()).build();
    }

    private WifiConfiguration i(String str, String str2, String str3, TPWifiCipherType tPWifiCipherType) {
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        wifiConfiguration.allowedAuthAlgorithms.clear();
        wifiConfiguration.allowedGroupCiphers.clear();
        wifiConfiguration.allowedKeyManagement.clear();
        wifiConfiguration.allowedPairwiseCiphers.clear();
        wifiConfiguration.allowedProtocols.clear();
        wifiConfiguration.SSID = SSLClient.DOUBLE_QUOTATION + str + SSLClient.DOUBLE_QUOTATION;
        if (str3 != null) {
            wifiConfiguration.BSSID = str3;
        }
        WifiConfiguration p = p(str);
        if (p != null) {
            a.removeNetwork(p.networkId);
        }
        if (tPWifiCipherType == TPWifiCipherType.WIFICIPHER_NOPASS) {
            wifiConfiguration.hiddenSSID = true;
            wifiConfiguration.allowedKeyManagement.set(0);
        } else if (tPWifiCipherType == TPWifiCipherType.WIFICIPHER_WEP) {
            wifiConfiguration.hiddenSSID = true;
            String[] strArr = wifiConfiguration.wepKeys;
            strArr[0] = SSLClient.DOUBLE_QUOTATION + str2 + SSLClient.DOUBLE_QUOTATION;
            wifiConfiguration.allowedAuthAlgorithms.set(1);
            wifiConfiguration.allowedGroupCiphers.set(3);
            wifiConfiguration.allowedGroupCiphers.set(2);
            wifiConfiguration.allowedGroupCiphers.set(0);
            wifiConfiguration.allowedGroupCiphers.set(1);
            wifiConfiguration.allowedKeyManagement.set(0);
            wifiConfiguration.wepTxKeyIndex = 0;
        } else if (tPWifiCipherType == TPWifiCipherType.WIFICIPHER_WPA) {
            wifiConfiguration.preSharedKey = SSLClient.DOUBLE_QUOTATION + str2 + SSLClient.DOUBLE_QUOTATION;
            wifiConfiguration.hiddenSSID = true;
            wifiConfiguration.allowedAuthAlgorithms.set(0);
            wifiConfiguration.allowedGroupCiphers.set(2);
            wifiConfiguration.allowedKeyManagement.set(1);
            wifiConfiguration.allowedPairwiseCiphers.set(1);
            wifiConfiguration.allowedGroupCiphers.set(3);
            wifiConfiguration.allowedPairwiseCiphers.set(2);
            wifiConfiguration.status = 2;
        } else if (tPWifiCipherType == TPWifiCipherType.WIFI_CIPHER_WPA2) {
            wifiConfiguration.preSharedKey = SSLClient.DOUBLE_QUOTATION + str2 + SSLClient.DOUBLE_QUOTATION;
            wifiConfiguration.hiddenSSID = true;
            wifiConfiguration.allowedAuthAlgorithms.set(0);
            wifiConfiguration.allowedGroupCiphers.set(2);
            wifiConfiguration.allowedKeyManagement.set(1);
            wifiConfiguration.allowedPairwiseCiphers.set(1);
            wifiConfiguration.allowedGroupCiphers.set(3);
            wifiConfiguration.allowedPairwiseCiphers.set(2);
            wifiConfiguration.status = 2;
        }
        return wifiConfiguration;
    }

    public static b k() {
        b bVar = f15147b;
        if (bVar == null) {
            synchronized (b.class) {
                bVar = f15147b;
                if (bVar == null) {
                    bVar = new b();
                    f15147b = bVar;
                }
            }
        }
        return bVar;
    }

    private WifiConfiguration p(String str) {
        String str2;
        List<WifiConfiguration> configuredNetworks = (Build.VERSION.SDK_INT < 23 || this.f15148c.checkSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) ? a.getConfiguredNetworks() : null;
        if (configuredNetworks != null && configuredNetworks.size() > 0) {
            for (int i = 0; i < configuredNetworks.size(); i++) {
                WifiConfiguration wifiConfiguration = configuredNetworks.get(i);
                if (!(wifiConfiguration == null || (str2 = wifiConfiguration.SSID) == null)) {
                    if (str2.equals(SSLClient.DOUBLE_QUOTATION + str + SSLClient.DOUBLE_QUOTATION)) {
                        return wifiConfiguration;
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(29)
    public void t() {
        if (this.f15149d != null) {
            ((ConnectivityManager) this.f15148c.getSystemService("connectivity")).unregisterNetworkCallback(this.f15149d);
            this.f15149d = null;
        }
    }

    public void d(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            e(str, null, str3, TPWifiCipherType.WIFICIPHER_NOPASS);
        } else {
            e(str, str2, str3, TPWifiCipherType.WIFI_CIPHER_WPA2);
        }
    }

    public void e(String str, String str2, String str3, TPWifiCipherType tPWifiCipherType) {
        if (Build.VERSION.SDK_INT >= 29) {
            g(str, str2, str3, tPWifiCipherType);
        } else {
            f(str, str2, str3, tPWifiCipherType);
        }
    }

    public String j() {
        WifiInfo connectionInfo = a.getConnectionInfo();
        return connectionInfo != null ? connectionInfo.getBSSID() : "";
    }

    public String l() {
        WifiInfo connectionInfo = a.getConnectionInfo();
        return connectionInfo != null ? connectionInfo.getSSID() : "";
    }

    public WifiManager m() {
        return a;
    }

    public void n(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
        }
    }

    public void o(Application application) {
        this.f15148c = application;
        a = (WifiManager) application.getSystemService("wifi");
    }

    public boolean q(String str) {
        WifiInfo connectionInfo = a.getConnectionInfo();
        if (!(connectionInfo == null || str == null)) {
            if ((SSLClient.DOUBLE_QUOTATION + str + SSLClient.DOUBLE_QUOTATION).equals(connectionInfo.getSSID()) && !TextUtils.isEmpty(connectionInfo.getBSSID()) && !connectionInfo.getBSSID().equals("00:00:00:00:00:00")) {
                return true;
            }
        }
        return false;
    }

    public boolean r() {
        return a.isWifiEnabled();
    }

    public void s() {
        a.startScan();
    }

    public void u(WifiConfiguration wifiConfiguration) {
        if (wifiConfiguration != null) {
            List<WifiConfiguration> list = null;
            if (Build.VERSION.SDK_INT < 23 || this.f15148c.checkSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {
                list = a.getConfiguredNetworks();
            }
            if (list == null) {
                list = Collections.emptyList();
            }
            for (WifiConfiguration wifiConfiguration2 : list) {
                if (wifiConfiguration2.priority >= 99999) {
                    wifiConfiguration2.priority = 99998;
                    a.updateNetwork(wifiConfiguration2);
                }
            }
            wifiConfiguration.priority = 99999;
            a.updateNetwork(wifiConfiguration);
        }
    }
}

package com.tplink.libtpwifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class TPWifiScanReceiver extends BroadcastReceiver {
    private String a = TPWifiScanReceiver.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private List<ScanResult> f15146b = new ArrayList();

    public static IntentFilter b() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        return intentFilter;
    }

    public List<ScanResult> a() {
        return this.f15146b;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null && action.equals("android.net.wifi.SCAN_RESULTS")) {
            WifiManager m = b.k().m();
            this.f15146b.clear();
            try {
                List<ScanResult> scanResults = m.getScanResults();
                if (scanResults != null && scanResults.size() > 0) {
                    this.f15146b.addAll(scanResults);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}

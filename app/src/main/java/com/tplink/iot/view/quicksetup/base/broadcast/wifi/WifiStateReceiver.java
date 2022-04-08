package com.tplink.iot.view.quicksetup.base.broadcast.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* loaded from: classes2.dex */
public class WifiStateReceiver extends BroadcastReceiver {
    private a a;

    public static IntentFilter a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        return intentFilter;
    }

    public void b(a aVar) {
        this.a = aVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        a aVar;
        String action = intent.getAction();
        if (action != null && action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
            int intExtra = intent.getIntExtra("wifi_state", 1);
            if (intExtra == 1) {
                a aVar2 = this.a;
                if (aVar2 != null) {
                    aVar2.a();
                }
            } else if (intExtra == 2) {
                a aVar3 = this.a;
                if (aVar3 != null) {
                    aVar3.c();
                }
            } else if (intExtra == 3 && (aVar = this.a) != null) {
                aVar.b();
            }
        }
    }
}

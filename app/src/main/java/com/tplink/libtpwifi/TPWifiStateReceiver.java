package com.tplink.libtpwifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes3.dex */
public class TPWifiStateReceiver extends BroadcastReceiver {
    private c a;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        c cVar;
        String action = intent.getAction();
        if (action != null && action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
            int intExtra = intent.getIntExtra("wifi_state", 1);
            if (intExtra == 1) {
                c cVar2 = this.a;
                if (cVar2 != null) {
                    cVar2.a();
                }
            } else if (intExtra == 3 && (cVar = this.a) != null) {
                cVar.b();
            }
        }
    }
}

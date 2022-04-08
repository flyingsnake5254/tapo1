package com.tplink.tpble;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes3.dex */
public class BLEStateReceiver extends BroadcastReceiver {
    private y a;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        y yVar;
        if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) {
            int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
            if (intExtra == 10) {
                y yVar2 = this.a;
                if (yVar2 != null) {
                    yVar2.b();
                }
            } else if (intExtra == 12 && (yVar = this.a) != null) {
                yVar.a();
            }
        }
    }
}

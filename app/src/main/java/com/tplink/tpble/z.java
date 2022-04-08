package com.tplink.tpble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;

/* compiled from: BLEUtils.java */
/* loaded from: classes3.dex */
public class z {
    private static BluetoothAdapter a(Context context) {
        BluetoothManager bluetoothManager;
        if (context == null || (bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth")) == null) {
            return null;
        }
        return bluetoothManager.getAdapter();
    }

    public static boolean b(Context context) {
        BluetoothAdapter a = a(context);
        return a != null && a.isEnabled();
    }
}

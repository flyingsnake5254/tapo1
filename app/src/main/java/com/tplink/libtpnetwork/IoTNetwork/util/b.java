package com.tplink.libtpnetwork.IoTNetwork.util;

import com.tplink.libtpnetwork.enumerate.EnumDeviceType;

/* loaded from: classes3.dex */
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[EnumDeviceType.values().length];
        a = iArr;
        iArr[EnumDeviceType.PLUG.ordinal()] = 1;
        iArr[EnumDeviceType.BULB.ordinal()] = 2;
        iArr[EnumDeviceType.HUB.ordinal()] = 3;
        iArr[EnumDeviceType.SWITCH.ordinal()] = 4;
        iArr[EnumDeviceType.SENSOR.ordinal()] = 5;
        iArr[EnumDeviceType.ENERGY.ordinal()] = 6;
        iArr[EnumDeviceType.CAMERA.ordinal()] = 7;
        iArr[EnumDeviceType.UNKNOWN.ordinal()] = 8;
    }
}

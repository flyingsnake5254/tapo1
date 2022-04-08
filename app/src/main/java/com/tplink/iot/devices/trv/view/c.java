package com.tplink.iot.devices.trv.view;

import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit;

/* loaded from: classes2.dex */
public final /* synthetic */ class c {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[EnumTemperatureUnit.values().length];
        a = iArr;
        iArr[EnumTemperatureUnit.CELSIUS.ordinal()] = 1;
        iArr[EnumTemperatureUnit.FAHRENHEIT.ordinal()] = 2;
    }
}

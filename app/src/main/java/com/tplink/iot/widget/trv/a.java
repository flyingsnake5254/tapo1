package com.tplink.iot.widget.trv;

import com.tplink.libtpnetwork.enumerate.EnumTemperatureUnit;

/* loaded from: classes3.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f11864b;

    static {
        int[] iArr = new int[EnumTemperatureUnit.values().length];
        a = iArr;
        EnumTemperatureUnit enumTemperatureUnit = EnumTemperatureUnit.CELSIUS;
        iArr[enumTemperatureUnit.ordinal()] = 1;
        EnumTemperatureUnit enumTemperatureUnit2 = EnumTemperatureUnit.FAHRENHEIT;
        iArr[enumTemperatureUnit2.ordinal()] = 2;
        int[] iArr2 = new int[EnumTemperatureUnit.values().length];
        f11864b = iArr2;
        iArr2[enumTemperatureUnit.ordinal()] = 1;
        iArr2[enumTemperatureUnit2.ordinal()] = 2;
    }
}

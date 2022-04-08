package com.tplink.iot.viewmodel.smart.taskdevice;

import com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmTimeType;

/* loaded from: classes3.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[EnumGuardModeAlarmTimeType.values().length];
        a = iArr;
        iArr[EnumGuardModeAlarmTimeType.ALWAYS.ordinal()] = 1;
        iArr[EnumGuardModeAlarmTimeType.CUSTOM_TIME.ordinal()] = 2;
    }
}

package com.tplink.iot.view.iothub.guardmode;

import com.tplink.iot.adapter.iothub.GuardModeAlarmTimeAdapter;

/* loaded from: classes2.dex */
public final /* synthetic */ class c {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[GuardModeAlarmTimeAdapter.AlarmTimeItemType.values().length];
        a = iArr;
        iArr[GuardModeAlarmTimeAdapter.AlarmTimeItemType.CUSTOM.ordinal()] = 1;
        iArr[GuardModeAlarmTimeAdapter.AlarmTimeItemType.ALWAYS.ordinal()] = 2;
        iArr[GuardModeAlarmTimeAdapter.AlarmTimeItemType.PRESET.ordinal()] = 3;
    }
}

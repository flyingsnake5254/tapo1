package com.tplink.iot.view.ipcamera.setting;

import com.tplink.libtpnetwork.cameranetwork.model.NightVisionModeType;

/* loaded from: classes2.dex */
public final /* synthetic */ class a5 {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[NightVisionModeType.values().length];
        a = iArr;
        iArr[NightVisionModeType.FULL_COLOR.ordinal()] = 1;
        iArr[NightVisionModeType.SMART.ordinal()] = 2;
        iArr[NightVisionModeType.INFRARED.ordinal()] = 3;
    }
}

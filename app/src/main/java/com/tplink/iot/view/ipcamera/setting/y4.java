package com.tplink.iot.view.ipcamera.setting;

import com.tplink.libtpnetwork.cameranetwork.business.model.AlertOption;

/* loaded from: classes2.dex */
public final /* synthetic */ class y4 {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[AlertOption.values().length];
        a = iArr;
        iArr[AlertOption.SOUND.ordinal()] = 1;
        iArr[AlertOption.LIGHT.ordinal()] = 2;
        iArr[AlertOption.BOTH.ordinal()] = 3;
    }
}

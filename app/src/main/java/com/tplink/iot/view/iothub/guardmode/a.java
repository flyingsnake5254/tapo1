package com.tplink.iot.view.iothub.guardmode;

import com.tplink.libtpnetwork.enumerate.EnumGuardMode;

/* loaded from: classes2.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[EnumGuardMode.values().length];
        a = iArr;
        iArr[EnumGuardMode.HOME.ordinal()] = 1;
        iArr[EnumGuardMode.AWAY.ordinal()] = 2;
        iArr[EnumGuardMode.SLEEP.ordinal()] = 3;
    }
}

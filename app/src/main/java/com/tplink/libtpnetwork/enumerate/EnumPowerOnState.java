package com.tplink.libtpnetwork.enumerate;

import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;

/* compiled from: EnumPowerOnState.kt */
/* loaded from: classes3.dex */
public enum EnumPowerOnState {
    LAST_STATES(DefaultStatesBean.TYPE_LAST_STATES),
    ALWAYS_ON(DefaultStatesBean.TYPE_CUSTOM),
    ALWAYS_OFF(DefaultStatesBean.TYPE_CUSTOM);
    
    private final String type;

    EnumPowerOnState(String str) {
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }
}

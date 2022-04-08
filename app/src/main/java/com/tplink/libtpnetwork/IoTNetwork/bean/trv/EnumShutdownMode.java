package com.tplink.libtpnetwork.IoTNetwork.bean.trv;

/* compiled from: ShutdownInfoBean.kt */
/* loaded from: classes3.dex */
public enum EnumShutdownMode {
    FULL_CLOSED("full_closed"),
    FULL_OPEN("full_open");
    
    private final String value;

    EnumShutdownMode(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}

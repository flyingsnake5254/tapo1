package com.tplink.iot.cloud.bean.share;

/* loaded from: classes2.dex */
public enum EnumDeviceShareRole {
    OWNER("owner"),
    SHARER("sharer");
    
    private String name;

    EnumDeviceShareRole(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}

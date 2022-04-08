package com.tplink.iot.cloud.bean.share.params;

/* loaded from: classes2.dex */
public class DeviceUserRoleParams {
    private boolean isSubThing;
    private String thingName;

    public DeviceUserRoleParams() {
    }

    public String getThingName() {
        return this.thingName;
    }

    public boolean isSubThing() {
        return this.isSubThing;
    }

    public void setSubThing(boolean z) {
        this.isSubThing = z;
    }

    public void setThingName(String str) {
        this.thingName = str;
    }

    public DeviceUserRoleParams(String str, boolean z) {
        this.thingName = str;
        this.isSubThing = z;
    }
}

package com.tplink.iot.cloud.bean.thing.params;

import java.util.List;

/* loaded from: classes2.dex */
public class ThingCommonDeviceParams {
    private boolean isCommon;
    private List<String> thingNames;

    public ThingCommonDeviceParams() {
    }

    public List<String> getThingNames() {
        return this.thingNames;
    }

    public boolean isCommon() {
        return this.isCommon;
    }

    public void setCommon(boolean z) {
        this.isCommon = z;
    }

    public void setThingNames(List<String> list) {
        this.thingNames = list;
    }

    public ThingCommonDeviceParams(boolean z, List<String> list) {
        this.isCommon = z;
        this.thingNames = list;
    }
}

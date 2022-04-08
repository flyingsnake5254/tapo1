package com.tplink.iot.cloud.bean.thing.params;

import java.util.List;

/* loaded from: classes2.dex */
public class ThingBatchUnbindParams {
    private List<String> thingNames;

    public ThingBatchUnbindParams() {
    }

    public List<String> getThingNames() {
        return this.thingNames;
    }

    public void setThingNames(List<String> list) {
        this.thingNames = list;
    }

    public ThingBatchUnbindParams(List<String> list) {
        this.thingNames = list;
    }
}

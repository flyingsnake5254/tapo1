package com.tplink.libtpnetwork.TPCloudNetwork.bean;

import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class ThingModelCache implements Serializable {
    private ThingModel thingModel;
    private String thingModelId;

    public ThingModelCache(String str, ThingModel thingModel) {
        this.thingModelId = str;
        this.thingModel = thingModel;
    }

    public ThingModel getThingModel() {
        return this.thingModel;
    }

    public String getThingModelId() {
        return this.thingModelId;
    }

    public void setThingModel(ThingModel thingModel) {
        this.thingModel = thingModel;
    }

    public void setThingModelId(String str) {
        this.thingModelId = str;
    }
}

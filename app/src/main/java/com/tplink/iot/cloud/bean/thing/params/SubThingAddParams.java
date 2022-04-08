package com.tplink.iot.cloud.bean.thing.params;

import com.google.gson.q.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;

/* loaded from: classes2.dex */
public class SubThingAddParams {
    private String category;
    @c(ThingModelDefine.Event.UPLOAD_PARAMS_DEVICE_ID)
    private String deviceId;

    public SubThingAddParams() {
    }

    public String getCategory() {
        return this.category;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public SubThingAddParams(String str, String str2) {
        this.deviceId = str;
        this.category = str2;
    }
}

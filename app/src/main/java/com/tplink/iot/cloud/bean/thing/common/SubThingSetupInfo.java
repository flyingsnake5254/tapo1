package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.q.b;
import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.common.Base64TypeAdapter;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;

/* loaded from: classes2.dex */
public class SubThingSetupInfo {
    private String avatar;
    private String category;
    @c(ThingModelDefine.Event.UPLOAD_PARAMS_DEVICE_ID)
    private String deviceId;
    @c("device_model")
    private String deviceModel;
    @b(Base64TypeAdapter.class)
    private String name;

    public String getAvatar() {
        return this.avatar;
    }

    public String getCategory() {
        return this.category;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public String getName() {
        return this.name;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDeviceModel(String str) {
        this.deviceModel = str;
    }

    public void setName(String str) {
        this.name = str;
    }
}

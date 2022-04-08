package com.tplink.iot.cloud.bean.cloudvideo.params;

import java.util.List;

/* loaded from: classes2.dex */
public class DeviceVideoParams {
    private String deviceId;
    private List<String> uuid;

    public DeviceVideoParams(String str) {
        this.deviceId = str;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public List<String> getUuid() {
        return this.uuid;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setUuid(List<String> list) {
        this.uuid = list;
    }

    public DeviceVideoParams(String str, List<String> list) {
        this.deviceId = str;
        this.uuid = list;
    }
}

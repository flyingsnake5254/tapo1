package com.tplink.cloud.bean.device.params;

/* loaded from: classes2.dex */
public class DeviceUnbindParams {
    private String cloudUserName;
    private String deviceId;

    public DeviceUnbindParams() {
    }

    public String getCloudUserName() {
        return this.cloudUserName;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setCloudUserName(String str) {
        this.cloudUserName = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public DeviceUnbindParams(String str, String str2) {
        this.deviceId = str;
        this.cloudUserName = str2;
    }
}

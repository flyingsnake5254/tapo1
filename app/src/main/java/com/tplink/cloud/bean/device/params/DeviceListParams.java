package com.tplink.cloud.bean.device.params;

/* loaded from: classes2.dex */
public class DeviceListParams {
    private String deviceType;
    private String protocol;

    public DeviceListParams() {
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }

    public void setProtocol(String str) {
        this.protocol = str;
    }

    public DeviceListParams(String str, String str2) {
        this.protocol = str;
        this.deviceType = str2;
    }
}

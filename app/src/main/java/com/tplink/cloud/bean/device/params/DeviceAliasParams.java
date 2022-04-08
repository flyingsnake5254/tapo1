package com.tplink.cloud.bean.device.params;

/* loaded from: classes2.dex */
public class DeviceAliasParams {
    private String alias;
    private String deviceId;

    public DeviceAliasParams() {
    }

    public String getAlias() {
        return this.alias;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public DeviceAliasParams(String str, String str2) {
        this.deviceId = str;
        this.alias = str2;
    }
}

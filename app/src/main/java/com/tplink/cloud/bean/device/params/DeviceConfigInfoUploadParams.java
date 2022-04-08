package com.tplink.cloud.bean.device.params;

/* loaded from: classes2.dex */
public class DeviceConfigInfoUploadParams {
    private String cloudUserName;
    private String deviceId;
    private String featureInfo;
    private String token;

    public DeviceConfigInfoUploadParams() {
    }

    public String getCloudUserName() {
        return this.cloudUserName;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getFeatureInfo() {
        return this.featureInfo;
    }

    public String getToken() {
        return this.token;
    }

    public void setCloudUserName(String str) {
        this.cloudUserName = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setFeatureInfo(String str) {
        this.featureInfo = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public DeviceConfigInfoUploadParams(String str, String str2, String str3, String str4) {
        this.deviceId = str;
        this.cloudUserName = str2;
        this.featureInfo = str3;
        this.token = str4;
    }
}

package com.tplink.cloud.bean.share.result;

/* loaded from: classes2.dex */
public class DeviceShareResult {
    private String deviceId;
    private int errorCode;
    private String shareId;
    private String sharerUserName;

    public String getDeviceId() {
        return this.deviceId;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getShareId() {
        return this.shareId;
    }

    public String getSharerUserName() {
        return this.sharerUserName;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setShareId(String str) {
        this.shareId = str;
    }

    public void setSharerUserName(String str) {
        this.sharerUserName = str;
    }
}

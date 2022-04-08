package com.tplink.cloud.bean.firmware.params;

/* loaded from: classes2.dex */
public class FirmwareInfoParams {
    private String devFwCurrentVer;
    private String deviceId;
    private String fwId;
    private String hwId;
    private String locale;
    private String oemId;

    public String getDevFwCurrentVer() {
        return this.devFwCurrentVer;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getFwId() {
        return this.fwId;
    }

    public String getHwId() {
        return this.hwId;
    }

    public String getLocale() {
        return this.locale;
    }

    public String getOemId() {
        return this.oemId;
    }

    public void setDevFwCurrentVer(String str) {
        this.devFwCurrentVer = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setFwId(String str) {
        this.fwId = str;
    }

    public void setHwId(String str) {
        this.hwId = str;
    }

    public void setLocale(String str) {
        this.locale = str;
    }

    public void setOemId(String str) {
        this.oemId = str;
    }
}

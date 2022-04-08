package com.tplink.iot.cloud.bean.cloudvideo.common;

/* loaded from: classes2.dex */
public class HasVideoTime {
    private String deviceLocalTime;
    private long utcTime;

    public String getDeviceLocalTime() {
        return this.deviceLocalTime;
    }

    public long getUtcTime() {
        return this.utcTime;
    }

    public void setDeviceLocalTime(String str) {
        this.deviceLocalTime = str;
    }

    public void setUtcTime(long j) {
        this.utcTime = j;
    }
}

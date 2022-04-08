package com.tplink.iot.view.quicksetup.base;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class DeviceLocationInfo implements Serializable {
    private Integer latitude;
    private Integer longitude;

    public DeviceLocationInfo() {
    }

    public Integer getLatitude() {
        return this.latitude;
    }

    public Integer getLongitude() {
        return this.longitude;
    }

    public void setLatitude(Integer num) {
        this.latitude = num;
    }

    public void setLongitude(Integer num) {
        this.longitude = num;
    }

    public DeviceLocationInfo(Integer num, Integer num2) {
        this.longitude = num;
        this.latitude = num2;
    }
}

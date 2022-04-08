package com.tplink.cloud.bean.tool.result;

/* loaded from: classes2.dex */
public class IpLocationResult {
    private String city;
    private Double latitude;
    private Double longitude;
    private String region;
    private String telecomCarrier;

    public String getCity() {
        return this.city;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public String getRegion() {
        return this.region;
    }

    public String getTelecomCarrier() {
        return this.telecomCarrier;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setLatitude(Double d2) {
        this.latitude = d2;
    }

    public void setLongitude(Double d2) {
        this.longitude = d2;
    }

    public void setRegion(String str) {
        this.region = str;
    }

    public void setTelecomCarrier(String str) {
        this.telecomCarrier = str;
    }
}

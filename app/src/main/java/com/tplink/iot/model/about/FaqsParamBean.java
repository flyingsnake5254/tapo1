package com.tplink.iot.model.about;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.q.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class FaqsParamBean {
    @c("appVersion")
    private String appVersion;
    @c("area")
    private String area;
    @c("country")
    private String country;
    @c("deviceInfo")
    private List<DeviceInfo> deviceInfoList = new ArrayList();
    @c("id")
    private String id;
    @c("mobileOsVersion")
    private String mobileOsVersion;
    @c("mobileType")
    private String mobileType;
    @c("modeltype")
    private String modeltype;
    @c(AppMeasurementSdk.ConditionalUserProperty.NAME)
    private String name;
    @c("timeStamp")
    private String timeStamp;
    @c("totalProductType")
    private String totalProductType;

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getArea() {
        return this.area;
    }

    public String getCountry() {
        return this.country;
    }

    public List<DeviceInfo> getDeviceInfoList() {
        return this.deviceInfoList;
    }

    public String getId() {
        return this.id;
    }

    public String getMobileOsVersion() {
        return this.mobileOsVersion;
    }

    public String getMobileType() {
        return this.mobileType;
    }

    public String getModeltype() {
        return this.modeltype;
    }

    public String getName() {
        return this.name;
    }

    public String getTimeStamp() {
        return this.timeStamp;
    }

    public String getTotalProductType() {
        return this.totalProductType;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setArea(String str) {
        this.area = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setDeviceInfoList(List<DeviceInfo> list) {
        this.deviceInfoList = list;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMobileOsVersion(String str) {
        this.mobileOsVersion = str;
    }

    public void setMobileType(String str) {
        this.mobileType = str;
    }

    public void setModeltype(String str) {
        this.modeltype = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setTimeStamp(String str) {
        this.timeStamp = str;
    }

    public void setTotalProductType(String str) {
        this.totalProductType = str;
    }
}

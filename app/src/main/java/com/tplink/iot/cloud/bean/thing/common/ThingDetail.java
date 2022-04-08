package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.q.b;
import com.tplink.iot.cloud.bean.common.Base64TypeAdapter;

/* loaded from: classes2.dex */
public class ThingDetail {
    private String category;
    private String deviceType;
    private String fwId;
    private String fwVer;
    private String hwId;
    private String hwVer;
    private String ip;
    private String mac;
    private String model;
    private String oemId;
    private int onboardingTime;
    private String originalThingName;
    private int position;
    private int role;
    private int slotNumber;
    @b(Base64TypeAdapter.class)
    private String ssid;

    public String getCategory() {
        return this.category;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public String getFwId() {
        return this.fwId;
    }

    public String getFwVer() {
        return this.fwVer;
    }

    public String getHwId() {
        return this.hwId;
    }

    public String getHwVer() {
        return this.hwVer;
    }

    public String getIp() {
        return this.ip;
    }

    public String getMac() {
        return this.mac;
    }

    public String getModel() {
        return this.model;
    }

    public String getOemId() {
        return this.oemId;
    }

    public int getOnboardingTime() {
        return this.onboardingTime;
    }

    public String getOriginalThingName() {
        return this.originalThingName;
    }

    public int getPosition() {
        return this.position;
    }

    public int getRole() {
        return this.role;
    }

    public int getSlotNumber() {
        return this.slotNumber;
    }

    public String getSsid() {
        return this.ssid;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }

    public void setFwId(String str) {
        this.fwId = str;
    }

    public void setFwVer(String str) {
        this.fwVer = str;
    }

    public void setHwId(String str) {
        this.hwId = str;
    }

    public void setHwVer(String str) {
        this.hwVer = str;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setOemId(String str) {
        this.oemId = str;
    }

    public void setOnboardingTime(int i) {
        this.onboardingTime = i;
    }

    public void setOriginalThingName(String str) {
        this.originalThingName = str;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public void setRole(int i) {
        this.role = i;
    }

    public void setSlotNumber(int i) {
        this.slotNumber = i;
    }

    public void setSsid(String str) {
        this.ssid = str;
    }
}

package com.tplink.iot.cloud.bean.share.result;

import com.tplink.iot.cloud.bean.share.EnumDeviceShareStatus;

/* loaded from: classes2.dex */
public class ShareDeviceResult {
    private String deviceHwVer;
    private String deviceModel;
    private String deviceName;
    private String deviceType;
    private Boolean isExpired;
    private boolean isSubThing;
    private String nickname;
    private String ownerNickname;
    private String ownerUsername;
    private String shareCreatedTime;
    private String shareExpiredTime;
    private String shareId;
    private EnumDeviceShareStatus shareStatus;
    private String sharerNickname;
    private String sharerUsername;
    private String thingName;

    public String getDeviceHwVer() {
        return this.deviceHwVer;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public Boolean getExpired() {
        return this.isExpired;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getOwnerNickname() {
        return this.ownerNickname;
    }

    public String getOwnerUsername() {
        return this.ownerUsername;
    }

    public String getShareCreatedTime() {
        return this.shareCreatedTime;
    }

    public String getShareExpiredTime() {
        return this.shareExpiredTime;
    }

    public String getShareId() {
        return this.shareId;
    }

    public EnumDeviceShareStatus getShareStatus() {
        return this.shareStatus;
    }

    public String getSharerNickname() {
        return this.sharerNickname;
    }

    public String getSharerUsername() {
        return this.sharerUsername;
    }

    public String getThingName() {
        return this.thingName;
    }

    public boolean isSubThing() {
        return this.isSubThing;
    }

    public void setDeviceHwVer(String str) {
        this.deviceHwVer = str;
    }

    public void setDeviceModel(String str) {
        this.deviceModel = str;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }

    public void setExpired(Boolean bool) {
        this.isExpired = bool;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setOwnerNickname(String str) {
        this.ownerNickname = str;
    }

    public void setOwnerUsername(String str) {
        this.ownerUsername = str;
    }

    public void setShareCreatedTime(String str) {
        this.shareCreatedTime = str;
    }

    public void setShareExpiredTime(String str) {
        this.shareExpiredTime = str;
    }

    public void setShareId(String str) {
        this.shareId = str;
    }

    public void setShareStatus(EnumDeviceShareStatus enumDeviceShareStatus) {
        this.shareStatus = enumDeviceShareStatus;
    }

    public void setSharerNickname(String str) {
        this.sharerNickname = str;
    }

    public void setSharerUsername(String str) {
        this.sharerUsername = str;
    }

    public void setSubThing(boolean z) {
        this.isSubThing = z;
    }

    public void setThingName(String str) {
        this.thingName = str;
    }
}

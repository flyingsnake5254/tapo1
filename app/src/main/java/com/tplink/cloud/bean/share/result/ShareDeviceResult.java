package com.tplink.cloud.bean.share.result;

import com.tplink.cloud.bean.share.EnumDeviceShareStatus;

/* loaded from: classes2.dex */
public class ShareDeviceResult {
    private String alias;
    private String deviceId;
    private String deviceType;
    private Boolean isExpired;
    private String ownerNickName;
    private String ownerUserName;
    private String shareCreatedTime;
    private String shareExpiredTime;
    private String shareId;
    private EnumDeviceShareStatus shareStatus;
    private String sharerNickName;
    private String sharerUserName;

    public String getAlias() {
        return this.alias;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public Boolean getExpired() {
        return this.isExpired;
    }

    public String getOwnerNickName() {
        return this.ownerNickName;
    }

    public String getOwnerUserName() {
        return this.ownerUserName;
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

    public String getSharerNickName() {
        return this.sharerNickName;
    }

    public String getSharerUserName() {
        return this.sharerUserName;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }

    public void setExpired(Boolean bool) {
        this.isExpired = bool;
    }

    public void setOwnerNickName(String str) {
        this.ownerNickName = str;
    }

    public void setOwnerUserName(String str) {
        this.ownerUserName = str;
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

    public void setSharerNickName(String str) {
        this.sharerNickName = str;
    }

    public void setSharerUserName(String str) {
        this.sharerUserName = str;
    }
}

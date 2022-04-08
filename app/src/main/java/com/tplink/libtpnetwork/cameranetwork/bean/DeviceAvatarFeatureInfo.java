package com.tplink.libtpnetwork.cameranetwork.bean;

import android.text.TextUtils;
import com.google.gson.q.c;

/* loaded from: classes3.dex */
public class DeviceAvatarFeatureInfo {
    @c("avatarName")
    private String avatarName;
    @c("isDefaultAvatarName")
    private Boolean isDefaultAvatarName;

    public DeviceAvatarFeatureInfo() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DeviceAvatarFeatureInfo deviceAvatarFeatureInfo = (DeviceAvatarFeatureInfo) obj;
        Boolean bool = this.isDefaultAvatarName;
        if (bool == null ? deviceAvatarFeatureInfo.isDefaultAvatarName != null : !bool.equals(deviceAvatarFeatureInfo.isDefaultAvatarName)) {
            return false;
        }
        String str = this.avatarName;
        String str2 = deviceAvatarFeatureInfo.avatarName;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public String getAvatarName() {
        return TextUtils.isEmpty(this.avatarName) ? "Home" : this.avatarName;
    }

    String getInnerUseAvatarName() {
        return this.avatarName;
    }

    public int hashCode() {
        Boolean bool = this.isDefaultAvatarName;
        int i = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 31;
        String str = this.avatarName;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public Boolean isDefaultAvatarName() {
        return this.isDefaultAvatarName;
    }

    public void mergeFrom(DeviceAvatarFeatureInfo deviceAvatarFeatureInfo) {
        if (deviceAvatarFeatureInfo.isDefaultAvatarName() != null) {
            setDefaultAvatarName(deviceAvatarFeatureInfo.isDefaultAvatarName());
        }
        if (deviceAvatarFeatureInfo.getAvatarName() != null) {
            setAvatarName(deviceAvatarFeatureInfo.getInnerUseAvatarName());
        }
    }

    public void setAvatarName(String str) {
        this.avatarName = str;
    }

    public void setDefaultAvatarName(Boolean bool) {
        this.isDefaultAvatarName = bool;
    }

    public String toString() {
        return "DeviceAvatarFeatureInfo{isDefaultAvatarName=" + this.isDefaultAvatarName + ", avatarName='" + this.avatarName + "'}";
    }

    public DeviceAvatarFeatureInfo(Boolean bool, String str) {
        this.isDefaultAvatarName = bool;
        this.avatarName = str;
    }

    public DeviceAvatarFeatureInfo clone() {
        DeviceAvatarFeatureInfo deviceAvatarFeatureInfo = new DeviceAvatarFeatureInfo();
        deviceAvatarFeatureInfo.setDefaultAvatarName(isDefaultAvatarName());
        deviceAvatarFeatureInfo.setAvatarName(getAvatarName());
        return deviceAvatarFeatureInfo;
    }
}

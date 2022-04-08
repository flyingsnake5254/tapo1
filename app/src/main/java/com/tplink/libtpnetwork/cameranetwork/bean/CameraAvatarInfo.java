package com.tplink.libtpnetwork.cameranetwork.bean;

import com.google.gson.q.c;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class CameraAvatarInfo implements Cloneable, Serializable {
    @c("avatarName")
    private String avatarName;
    @c("deviceAvatarRemoteUrl")
    private String avatarRemoteUrl;
    @c("isDefaultAvatarName")
    private Boolean isAvatarDefault;
    @c("isAvatarNameModified")
    private Boolean isAvatarNameModified;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraAvatarInfo)) {
            return false;
        }
        CameraAvatarInfo cameraAvatarInfo = (CameraAvatarInfo) obj;
        return this.avatarRemoteUrl.equals(cameraAvatarInfo.avatarRemoteUrl) && this.isAvatarDefault == cameraAvatarInfo.isAvatarDefault && this.avatarName.equals(cameraAvatarInfo.avatarName) && this.isAvatarNameModified.equals(cameraAvatarInfo.isAvatarNameModified);
    }

    public Boolean getAvatarDefault() {
        return this.isAvatarDefault;
    }

    public String getAvatarName() {
        return this.avatarName;
    }

    public Boolean getAvatarNameModified() {
        return this.isAvatarNameModified;
    }

    public String getAvatarRemoteUrl() {
        return this.avatarRemoteUrl;
    }

    public int hashCode() {
        String str = this.avatarRemoteUrl;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Boolean bool = this.isAvatarDefault;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        String str2 = this.avatarName;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Boolean bool2 = this.isAvatarNameModified;
        if (bool2 != null) {
            i = bool2.hashCode();
        }
        return hashCode3 + i;
    }

    public void setAvatarDefault(Boolean bool) {
        this.isAvatarDefault = bool;
    }

    public void setAvatarName(String str) {
        this.avatarName = str;
    }

    public void setAvatarNameModified(Boolean bool) {
        this.isAvatarNameModified = bool;
    }

    public void setAvatarRemoteUrl(String str) {
        this.avatarRemoteUrl = str;
    }

    public String toString() {
        return "DeviceState{, avatarRemoteUrl='" + this.avatarRemoteUrl + "', isAvatarDefault='" + this.isAvatarDefault + "', avatarName='" + this.avatarName + "', isAvatarNameModified='" + this.isAvatarNameModified + "'}";
    }

    public CameraAvatarInfo clone() {
        CameraAvatarInfo cameraAvatarInfo = new CameraAvatarInfo();
        cameraAvatarInfo.avatarRemoteUrl = this.avatarRemoteUrl;
        cameraAvatarInfo.avatarName = this.avatarName;
        cameraAvatarInfo.isAvatarDefault = this.isAvatarDefault;
        cameraAvatarInfo.isAvatarNameModified = this.isAvatarNameModified;
        return cameraAvatarInfo;
    }
}

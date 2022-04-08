package com.tplink.libtpnetwork.TPCloudNetwork.device;

import com.tplink.iot.cloud.bean.share.device.DeviceOwnerInfoResult;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class TCDeviceOwnerInfoBean implements Serializable {
    private String avatarUrl;
    private long bindingTime;
    private String cloudUserName;
    private String nickname;

    public TCDeviceOwnerInfoBean() {
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public long getBindingTime() {
        return this.bindingTime;
    }

    public String getCloudUserName() {
        return this.cloudUserName;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public void setBindingTime(long j) {
        this.bindingTime = j;
    }

    public void setCloudUserName(String str) {
        this.cloudUserName = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public TCDeviceOwnerInfoBean(String str, String str2, long j, String str3) {
        this.cloudUserName = str;
        this.nickname = str2;
        this.bindingTime = j;
        this.avatarUrl = str3;
    }

    public TCDeviceOwnerInfoBean(DeviceOwnerInfoResult deviceOwnerInfoResult) {
        this.cloudUserName = deviceOwnerInfoResult.getCloudUsername();
        this.nickname = deviceOwnerInfoResult.getNickname();
        this.bindingTime = deviceOwnerInfoResult.getBindingTime();
        this.avatarUrl = deviceOwnerInfoResult.getAvatarUrl();
    }
}

package com.tplink.iot.cloud.bean.share.device;

/* loaded from: classes2.dex */
public class DeviceOwnerInfoResult {
    private String avatarUrl;
    private long bindingTime;
    private String cloudUsername;
    private String nickname;

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public long getBindingTime() {
        return this.bindingTime;
    }

    public String getCloudUsername() {
        return this.cloudUsername;
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

    public void setCloudUsername(String str) {
        this.cloudUsername = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }
}

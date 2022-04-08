package com.tplink.cloud.bean.device.result;

/* loaded from: classes2.dex */
public class DeviceOwnerInfoResult {
    private String avatarUrl;
    private long bindingTime;
    private String cloudUserName;
    private String nickname;

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
}

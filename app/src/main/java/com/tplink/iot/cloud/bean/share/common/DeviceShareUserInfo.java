package com.tplink.iot.cloud.bean.share.common;

/* loaded from: classes2.dex */
public class DeviceShareUserInfo {
    private long bindingTime;
    private String cloudUsername;
    private String nickname;
    private int role;

    public long getBindingTime() {
        return this.bindingTime;
    }

    public String getCloudUsername() {
        return this.cloudUsername;
    }

    public String getNickname() {
        return this.nickname;
    }

    public int getRole() {
        return this.role;
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

    public void setRole(int i) {
        this.role = i;
    }
}

package com.tplink.iot.adapter.deviceshare;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class RecordUserBean implements Serializable {
    private String cloudUserName;
    private String nickname;

    public RecordUserBean(String str) {
        this.cloudUserName = str;
    }

    public String getCloudUserName() {
        return this.cloudUserName;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setCloudUserName(String str) {
        this.cloudUserName = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public String toString() {
        String str = this.cloudUserName;
        return str == null ? "" : str;
    }

    public RecordUserBean(String str, String str2) {
        this.cloudUserName = str;
        this.nickname = str2;
    }
}

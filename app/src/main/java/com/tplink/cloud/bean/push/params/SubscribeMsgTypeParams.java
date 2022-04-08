package com.tplink.cloud.bean.push.params;

/* loaded from: classes2.dex */
public class SubscribeMsgTypeParams {
    private String appType;
    private String deviceToken;

    public SubscribeMsgTypeParams() {
    }

    public String getAppType() {
        return this.appType;
    }

    public String getDeviceToken() {
        return this.deviceToken;
    }

    public void setAppType(String str) {
        this.appType = str;
    }

    public void setDeviceToken(String str) {
        this.deviceToken = str;
    }

    public SubscribeMsgTypeParams(String str, String str2) {
        this.appType = str;
        this.deviceToken = str2;
    }
}

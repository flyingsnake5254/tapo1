package com.tplink.cloud.bean.account.params;

/* loaded from: classes2.dex */
public class AppConfigInfoParams extends CloudUserParams {
    private String appType;

    public AppConfigInfoParams() {
    }

    public String getAppType() {
        return this.appType;
    }

    public void setAppType(String str) {
        this.appType = str;
    }

    public AppConfigInfoParams(String str, String str2) {
        super(str);
        this.appType = str2;
    }
}

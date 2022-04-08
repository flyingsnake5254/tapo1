package com.tplink.iot.cloud.bean.auth.params;

/* loaded from: classes2.dex */
public class AuthParams {
    private String appType;
    private String terminalUUID;
    private String token;

    public AuthParams() {
    }

    public String getAppType() {
        return this.appType;
    }

    public String getTerminalUUID() {
        return this.terminalUUID;
    }

    public String getToken() {
        return this.token;
    }

    public void setAppType(String str) {
        this.appType = str;
    }

    public void setTerminalUUID(String str) {
        this.terminalUUID = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public AuthParams(String str, String str2, String str3) {
        this.appType = str;
        this.terminalUUID = str2;
        this.token = str3;
    }
}

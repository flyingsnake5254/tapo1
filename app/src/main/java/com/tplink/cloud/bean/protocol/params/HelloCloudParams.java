package com.tplink.cloud.bean.protocol.params;

/* loaded from: classes2.dex */
public class HelloCloudParams {
    private String appPackageName;
    private String appType;
    private String tcspVer;
    private String terminalUUID;

    public String getAppPackageName() {
        return this.appPackageName;
    }

    public String getAppType() {
        return this.appType;
    }

    public String getTcspVer() {
        return this.tcspVer;
    }

    public String getTerminalUUID() {
        return this.terminalUUID;
    }

    public void setAppPackageName(String str) {
        this.appPackageName = str;
    }

    public void setAppType(String str) {
        this.appType = str;
    }

    public void setTcspVer(String str) {
        this.tcspVer = str;
    }

    public void setTerminalUUID(String str) {
        this.terminalUUID = str;
    }
}

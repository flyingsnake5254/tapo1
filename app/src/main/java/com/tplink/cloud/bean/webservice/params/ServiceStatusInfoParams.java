package com.tplink.cloud.bean.webservice.params;

import com.google.gson.f;

/* loaded from: classes2.dex */
public class ServiceStatusInfoParams {
    private String appType;
    private String os;
    private f serviceStatusInfo;
    private String terminalUUID;

    public ServiceStatusInfoParams() {
    }

    public String getAppType() {
        return this.appType;
    }

    public String getOs() {
        return this.os;
    }

    public f getServiceStatusInfo() {
        return this.serviceStatusInfo;
    }

    public String getTerminalUUID() {
        return this.terminalUUID;
    }

    public void setAppType(String str) {
        this.appType = str;
    }

    public void setOs(String str) {
        this.os = str;
    }

    public void setServiceStatusInfo(f fVar) {
        this.serviceStatusInfo = fVar;
    }

    public void setTerminalUUID(String str) {
        this.terminalUUID = str;
    }

    public ServiceStatusInfoParams(String str, String str2, String str3, f fVar) {
        this.appType = str;
        this.os = str2;
        this.terminalUUID = str3;
        this.serviceStatusInfo = fVar;
    }
}

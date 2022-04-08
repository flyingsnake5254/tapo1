package com.tplink.cloud.bean.protocol.result;

/* loaded from: classes2.dex */
public class HelloCloudResult {
    private String appUrl;
    private String tcspInfo;
    private int tcspStatus;

    public String getAppUrl() {
        return this.appUrl;
    }

    public String getTcspInfo() {
        return this.tcspInfo;
    }

    public int getTcspStatus() {
        return this.tcspStatus;
    }

    public void setAppUrl(String str) {
        this.appUrl = str;
    }

    public void setTcspInfo(String str) {
        this.tcspInfo = str;
    }

    public void setTcspStatus(int i) {
        this.tcspStatus = i;
    }
}

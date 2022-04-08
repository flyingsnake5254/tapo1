package com.tplink.libtpanalytics.bean;

import com.google.gson.q.c;

/* loaded from: classes3.dex */
public class EncryptedSourceParam {
    @c("apv")
    private String appVersion;
    @c("lg")
    private String language;
    @c("rg")
    private String region;
    @c("sv")
    private String systemVersion;

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getRegion() {
        return this.region;
    }

    public String getSystemVersion() {
        return this.systemVersion;
    }

    public boolean isNotAllNull() {
        return (this.appVersion == null && this.language == null && this.region == null && this.systemVersion == null) ? false : true;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setRegion(String str) {
        this.region = str;
    }

    public void setSystemVersion(String str) {
        this.systemVersion = str;
    }
}

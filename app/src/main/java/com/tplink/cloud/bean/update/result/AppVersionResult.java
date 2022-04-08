package com.tplink.cloud.bean.update.result;

/* loaded from: classes2.dex */
public class AppVersionResult implements Cloneable {
    private int appUpdateType;
    private String appUrl;
    private String size;
    private int versionCode;
    private String versionLog;
    private String versionName;

    public int getAppUpdateType() {
        return this.appUpdateType;
    }

    public String getAppUrl() {
        return this.appUrl;
    }

    public String getSize() {
        return this.size;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public String getVersionLog() {
        return this.versionLog;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setAppUpdateType(int i) {
        this.appUpdateType = i;
    }

    public void setAppUrl(String str) {
        this.appUrl = str;
    }

    public void setSize(String str) {
        this.size = str;
    }

    public void setVersionCode(int i) {
        this.versionCode = i;
    }

    public void setVersionLog(String str) {
        this.versionLog = str;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }

    public AppVersionResult clone() {
        try {
            return (AppVersionResult) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}

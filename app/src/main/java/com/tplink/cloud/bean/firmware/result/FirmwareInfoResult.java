package com.tplink.cloud.bean.firmware.result;

/* loaded from: classes2.dex */
public class FirmwareInfoResult {
    private int fwLocation;
    private String fwReleaseDate;
    private String fwReleaseLog;
    private String fwTitle;
    private int fwType;
    private String fwUrl;
    private String fwVer;
    private String getFwReleaseLogUrl;

    public int getFwLocation() {
        return this.fwLocation;
    }

    public String getFwReleaseDate() {
        return this.fwReleaseDate;
    }

    public String getFwReleaseLog() {
        return this.fwReleaseLog;
    }

    public String getFwTitle() {
        return this.fwTitle;
    }

    public int getFwType() {
        return this.fwType;
    }

    public String getFwUrl() {
        return this.fwUrl;
    }

    public String getFwVer() {
        return this.fwVer;
    }

    public String getGetFwReleaseLogUrl() {
        return this.getFwReleaseLogUrl;
    }

    public void setFwLocation(int i) {
        this.fwLocation = i;
    }

    public void setFwReleaseDate(String str) {
        this.fwReleaseDate = str;
    }

    public void setFwReleaseLog(String str) {
        this.fwReleaseLog = str;
    }

    public void setFwTitle(String str) {
        this.fwTitle = str;
    }

    public void setFwType(int i) {
        this.fwType = i;
    }

    public void setFwUrl(String str) {
        this.fwUrl = str;
    }

    public void setFwVer(String str) {
        this.fwVer = str;
    }

    public void setGetFwReleaseLogUrl(String str) {
        this.getFwReleaseLogUrl = str;
    }
}

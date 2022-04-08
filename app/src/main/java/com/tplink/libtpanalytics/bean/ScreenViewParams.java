package com.tplink.libtpanalytics.bean;

/* loaded from: classes3.dex */
public class ScreenViewParams {
    private String lastScreenClass;
    private String lastScreenName;
    private String screenClass;
    private String screenName;

    public ScreenViewParams() {
    }

    public String getLastScreenClass() {
        return this.lastScreenClass;
    }

    public String getLastScreenName() {
        return this.lastScreenName;
    }

    public String getScreenClass() {
        return this.screenClass;
    }

    public String getScreenName() {
        return this.screenName;
    }

    public void setLastScreenClass(String str) {
        this.lastScreenClass = str;
    }

    public void setLastScreenName(String str) {
        this.lastScreenName = str;
    }

    public void setScreenClass(String str) {
        this.screenClass = str;
    }

    public void setScreenName(String str) {
        this.screenName = str;
    }

    public ScreenViewParams(String str) {
        this.lastScreenClass = str;
    }
}

package com.tplink.libtpanalytics.bean;

import com.google.gson.q.c;

/* loaded from: classes3.dex */
public class PlaintextEventParam {
    @c("ac")
    private String action;
    @c("cg")
    private String category;
    @c("et")
    private String exceptionTimeStamp;
    @c("lsc")
    private String lastScreenClass;
    @c("lsn")
    private String lastScreenName;
    @c("sc")
    private String screenClass;
    @c("sn")
    private String screenName;
    @c("sid")
    private int sessionId;

    public String getAction() {
        return this.action;
    }

    public String getCategory() {
        return this.category;
    }

    public String getExceptionTimeStamp() {
        return this.exceptionTimeStamp;
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

    public int getSessionId() {
        return this.sessionId;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setExceptionTimeStamp(String str) {
        this.exceptionTimeStamp = str;
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

    public void setSessionId(int i) {
        this.sessionId = i;
    }

    public String toString() {
        return "PlaintextEventParam{sessionId=" + this.sessionId + ", screenClass='" + this.screenClass + "', screenName='" + this.screenName + "', lastScreenName='" + this.lastScreenName + "', lastScreenClass='" + this.lastScreenClass + "', category='" + this.category + "', action='" + this.action + "', exceptionTimeStamp='" + this.exceptionTimeStamp + "'}";
    }
}

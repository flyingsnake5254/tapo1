package com.tplink.nbu.bean.iam;

/* loaded from: classes3.dex */
public class Event {
    private String accountId;
    private String appType;
    private String os;
    private String taskId;
    private String type;
    private long unixTimestampUtc;

    public String getAccountId() {
        return this.accountId;
    }

    public String getAppType() {
        return this.appType;
    }

    public String getOs() {
        return this.os;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public String getType() {
        return this.type;
    }

    public long getUnixTimestampUtc() {
        return this.unixTimestampUtc;
    }

    public void setAccountId(String str) {
        this.accountId = str;
    }

    public void setAppType(String str) {
        this.appType = str;
    }

    public void setOs(String str) {
        this.os = str;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUnixTimestampUtc(long j) {
        this.unixTimestampUtc = j;
    }
}

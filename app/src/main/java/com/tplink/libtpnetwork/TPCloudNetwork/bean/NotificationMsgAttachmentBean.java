package com.tplink.libtpnetwork.TPCloudNetwork.bean;

/* loaded from: classes3.dex */
public class NotificationMsgAttachmentBean {
    private int appNotifyType;
    private int deviceCount;
    private String deviceId;
    private IacInfo iac;
    private String localTime;
    private String msgId;
    private String ownerId;
    private String summaryDate;
    private long time;
    private int ttl;
    private String userId;
    private String userName;
    private String uuid;

    public int getAppNotifyType() {
        return this.appNotifyType;
    }

    public int getDeviceCount() {
        return this.deviceCount;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public IacInfo getIac() {
        return this.iac;
    }

    public String getLocalTime() {
        return this.localTime;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public String getSummaryDate() {
        return this.summaryDate;
    }

    public long getTime() {
        return this.time;
    }

    public int getTtl() {
        return this.ttl;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setAppNotifyType(int i) {
        this.appNotifyType = i;
    }

    public void setDeviceCount(int i) {
        this.deviceCount = i;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setIac(IacInfo iacInfo) {
        this.iac = iacInfo;
    }

    public void setLocalTime(String str) {
        this.localTime = str;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setOwnerId(String str) {
        this.ownerId = str;
    }

    public void setSummaryDate(String str) {
        this.summaryDate = str;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public void setTtl(int i) {
        this.ttl = i;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }
}

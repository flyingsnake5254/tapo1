package com.tplink.iot.firebase;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class CloudMessageBean implements Serializable {
    private String alias;
    private String content;
    private int deviceCount;
    private String deviceId;
    private String imgUrl;
    private String messageId;
    private String messageType;
    private String summaryDate;
    private String taskId;
    private String timestamp;
    private String title;
    private String userName;
    private String uuid;

    public CloudMessageBean(String str, String str2, String str3) {
        this.messageId = str;
        this.messageType = str2;
        this.timestamp = str3;
    }

    public String getAlias() {
        return this.alias;
    }

    public String getContent() {
        return this.content;
    }

    public int getDeviceCount() {
        return this.deviceCount;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public String getMessageType() {
        return this.messageType;
    }

    public String getSummaryDate() {
        return this.summaryDate;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDeviceCount(int i) {
        this.deviceCount = i;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setMessageType(String str) {
        this.messageType = str;
    }

    public void setSummaryDate(String str) {
        this.summaryDate = str;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }
}

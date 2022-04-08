package com.tplink.iot.cloud.bean.smart.common;

/* loaded from: classes2.dex */
public class SmartLog {
    private SmartLogAction actionSetting;
    private String avatarUrl;
    private int code;
    private String id;
    private String smartId;
    private String smartName;
    private String timestamp;
    private int triggerCount;
    private String triggerId;
    private SmartLogTrigger triggerSetting;

    public SmartLogAction getActionSetting() {
        return this.actionSetting;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public int getCode() {
        return this.code;
    }

    public String getId() {
        return this.id;
    }

    public String getSmartId() {
        return this.smartId;
    }

    public String getSmartName() {
        return this.smartName;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public int getTriggerCount() {
        return this.triggerCount;
    }

    public String getTriggerId() {
        return this.triggerId;
    }

    public SmartLogTrigger getTriggerSetting() {
        return this.triggerSetting;
    }

    public void setActionSetting(SmartLogAction smartLogAction) {
        this.actionSetting = smartLogAction;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setSmartId(String str) {
        this.smartId = str;
    }

    public void setSmartName(String str) {
        this.smartName = str;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public void setTriggerCount(int i) {
        this.triggerCount = i;
    }

    public void setTriggerId(String str) {
        this.triggerId = str;
    }

    public void setTriggerSetting(SmartLogTrigger smartLogTrigger) {
        this.triggerSetting = smartLogTrigger;
    }
}

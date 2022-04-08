package com.tplink.cloud.bean.push.params;

import com.tplink.cloud.bean.push.EnumNotificationDirection;

/* loaded from: classes2.dex */
public class NotificationMsgTypeParams {
    private EnumNotificationDirection direction;
    private long indexTime;
    private String msgType;

    public EnumNotificationDirection getDirection() {
        return this.direction;
    }

    public long getIndexTime() {
        return this.indexTime;
    }

    public String getMsgType() {
        return this.msgType;
    }

    public void setDirection(EnumNotificationDirection enumNotificationDirection) {
        this.direction = enumNotificationDirection;
    }

    public void setIndexTime(long j) {
        this.indexTime = j;
    }

    public void setMsgType(String str) {
        this.msgType = str;
    }
}

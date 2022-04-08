package com.tplink.iot.cloud.bean.cloudvideo.common;

/* loaded from: classes2.dex */
public class DowngradeToHandle {
    private long downgradeTimestamp;
    private int newDeviceNum;
    private String subscriptionId;

    public long getDowngradeTimestamp() {
        return this.downgradeTimestamp;
    }

    public int getNewDeviceNum() {
        return this.newDeviceNum;
    }

    public String getSubscriptionId() {
        return this.subscriptionId;
    }

    public void setDowngradeTimestamp(long j) {
        this.downgradeTimestamp = j;
    }

    public void setNewDeviceNum(int i) {
        this.newDeviceNum = i;
    }

    public void setSubscriptionId(String str) {
        this.subscriptionId = str;
    }
}

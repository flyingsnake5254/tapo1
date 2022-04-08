package com.tplink.iot.cloud.bean.cloudvideo.common;

import java.util.List;

/* loaded from: classes2.dex */
public class DowngradeHandled {
    private long deviceRemovalTime;
    private int newDeviceNum;
    private List<RemovedDevice> removedDeviceList;
    private String subscriptionId;

    public long getDeviceRemovalTime() {
        return this.deviceRemovalTime;
    }

    public int getNewDeviceNum() {
        return this.newDeviceNum;
    }

    public List<RemovedDevice> getRemovedDeviceList() {
        return this.removedDeviceList;
    }

    public String getSubscriptionId() {
        return this.subscriptionId;
    }

    public void setDeviceRemovalTime(long j) {
        this.deviceRemovalTime = j;
    }

    public void setNewDeviceNum(int i) {
        this.newDeviceNum = i;
    }

    public void setRemovedDeviceList(List<RemovedDevice> list) {
        this.removedDeviceList = list;
    }

    public void setSubscriptionId(String str) {
        this.subscriptionId = str;
    }
}

package com.tplink.cloud.bean.device.result;

/* loaded from: classes2.dex */
public class DeviceListPageResult extends DeviceListResult {
    private int currentIndex;
    private int totalNum;

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public int getTotalNum() {
        return this.totalNum;
    }

    public void setCurrentIndex(int i) {
        this.currentIndex = i;
    }

    public void setTotalNum(int i) {
        this.totalNum = i;
    }
}

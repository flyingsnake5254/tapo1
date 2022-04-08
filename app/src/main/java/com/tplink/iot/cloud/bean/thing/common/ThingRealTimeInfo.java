package com.tplink.iot.cloud.bean.thing.common;

/* loaded from: classes2.dex */
public class ThingRealTimeInfo {
    private Integer curLoadNum;
    private String loadLevel;
    private Integer maxLoadNum;
    private Integer rssi;
    private int signalLevel;
    private Integer totalMemory;
    private Integer usedMemory;

    public Integer getCurLoadNum() {
        return this.curLoadNum;
    }

    public String getLoadLevel() {
        return this.loadLevel;
    }

    public Integer getMaxLoadNum() {
        return this.maxLoadNum;
    }

    public Integer getRssi() {
        return this.rssi;
    }

    public int getSignalLevel() {
        return this.signalLevel;
    }

    public Integer getTotalMemory() {
        return this.totalMemory;
    }

    public Integer getUsedMemory() {
        return this.usedMemory;
    }

    public void setCurLoadNum(Integer num) {
        this.curLoadNum = num;
    }

    public void setLoadLevel(String str) {
        this.loadLevel = str;
    }

    public void setMaxLoadNum(Integer num) {
        this.maxLoadNum = num;
    }

    public void setRssi(Integer num) {
        this.rssi = num;
    }

    public void setSignalLevel(int i) {
        this.signalLevel = i;
    }

    public void setTotalMemory(Integer num) {
        this.totalMemory = num;
    }

    public void setUsedMemory(Integer num) {
        this.usedMemory = num;
    }
}

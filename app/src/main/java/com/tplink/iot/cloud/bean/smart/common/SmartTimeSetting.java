package com.tplink.iot.cloud.bean.smart.common;

import java.util.Objects;

/* loaded from: classes2.dex */
public class SmartTimeSetting {
    private int endTime;
    private int startTime;

    public SmartTimeSetting() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SmartTimeSetting smartTimeSetting = (SmartTimeSetting) obj;
        return this.startTime == smartTimeSetting.startTime && this.endTime == smartTimeSetting.endTime;
    }

    public int getEndTime() {
        return this.endTime;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.startTime), Integer.valueOf(this.endTime));
    }

    public void setEndTime(int i) {
        this.endTime = i;
    }

    public void setStartTime(int i) {
        this.startTime = i;
    }

    public SmartTimeSetting(int i, int i2) {
        this.startTime = i;
        this.endTime = i2;
    }
}

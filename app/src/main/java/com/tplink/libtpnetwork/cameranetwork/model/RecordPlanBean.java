package com.tplink.libtpnetwork.cameranetwork.model;

import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public class RecordPlanBean implements Comparable<RecordPlanBean> {
    public static final int PLAYBACK_VIDEO_TYPE_COMMON = 1;
    public static final int PLAYBACK_VIDEO_TYPE_MOTION = 2;
    private int dayIndex;
    private int endTime;
    private int recordType;
    private int startTime;

    public RecordPlanBean(int i, int i2, int i3, int i4) {
        this.recordType = i;
        this.dayIndex = i2;
        this.startTime = i3;
        this.endTime = i4;
    }

    public boolean contains(int i) {
        return this.startTime < i && this.endTime > i;
    }

    public boolean containsWithEqual(int i) {
        return this.startTime <= i && this.endTime >= i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RecordPlanBean recordPlanBean = (RecordPlanBean) obj;
        return this.recordType == recordPlanBean.recordType && this.dayIndex == recordPlanBean.dayIndex && this.startTime == recordPlanBean.startTime && this.endTime == recordPlanBean.endTime;
    }

    public int getDayIndex() {
        return this.dayIndex;
    }

    public int getEndTime() {
        return this.endTime;
    }

    public int getRecordType() {
        return this.recordType;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        return (((((this.recordType * 31) + this.dayIndex) * 31) + this.startTime) * 31) + this.endTime;
    }

    public void setDayIndex(int i) {
        this.dayIndex = i;
    }

    public void setEndTime(int i) {
        this.endTime = i;
    }

    public void setRecordType(int i) {
        this.recordType = i;
    }

    public void setStartTime(int i) {
        this.startTime = i;
    }

    public String toString() {
        return "RecordPlanBean{recordType=" + this.recordType + ", dayIndex=" + this.dayIndex + ", startTime=" + this.startTime + ", endTime=" + this.endTime + '}';
    }

    public int compareTo(@NonNull RecordPlanBean recordPlanBean) {
        return getStartTime() - recordPlanBean.getStartTime();
    }
}

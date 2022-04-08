package com.tplink.iot.cloud.bean.smart.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* loaded from: classes2.dex */
public class SmartPeriodSetting {
    private SmartTimeSetting customTime;
    private byte daysOfWeek;
    private String periodType;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface PeriodType {
        public static final String ALL_DAY = "ALL_DAY";
        public static final String CUSTOM = "CUSTOM";
    }

    public SmartPeriodSetting() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SmartPeriodSetting smartPeriodSetting = (SmartPeriodSetting) obj;
        return this.daysOfWeek == smartPeriodSetting.daysOfWeek && Objects.equals(this.periodType, smartPeriodSetting.periodType) && Objects.equals(this.customTime, smartPeriodSetting.customTime);
    }

    public SmartTimeSetting getCustomTime() {
        return this.customTime;
    }

    public byte getDaysOfWeek() {
        return this.daysOfWeek;
    }

    public String getPeriodType() {
        return this.periodType;
    }

    public int hashCode() {
        return Objects.hash(this.periodType, Byte.valueOf(this.daysOfWeek), this.customTime);
    }

    public void setCustomTime(SmartTimeSetting smartTimeSetting) {
        this.customTime = smartTimeSetting;
    }

    public void setDaysOfWeek(byte b2) {
        this.daysOfWeek = b2;
    }

    public void setPeriodType(String str) {
        this.periodType = str;
    }

    public SmartPeriodSetting(String str, byte b2) {
        this.periodType = str;
        this.daysOfWeek = b2;
    }

    public SmartPeriodSetting(String str, byte b2, SmartTimeSetting smartTimeSetting) {
        this.periodType = str;
        this.daysOfWeek = b2;
        this.customTime = smartTimeSetting;
    }
}

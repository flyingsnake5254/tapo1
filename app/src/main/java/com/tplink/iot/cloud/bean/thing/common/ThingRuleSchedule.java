package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.q.b;
import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.common.MapJsonAdapter;
import com.tplink.iot.cloud.enumerate.RuleMode;
import com.tplink.iot.cloud.enumerate.RuleTimeType;
import java.util.Map;

/* loaded from: classes2.dex */
public class ThingRuleSchedule {
    private int day;
    @c("desired_states")
    @b(MapJsonAdapter.class)
    private Map<String, Object> desiredStates;
    private boolean enable;
    @c("e_action")
    @Deprecated
    private String endAction;
    @c("e_min")
    private int endTimeMin;
    @c("e_type")
    private RuleTimeType endTimeType;
    private String id;
    private RuleMode mode;
    private int month;
    @c("s_action")
    @Deprecated
    private String startAction;
    @c("s_min")
    private int startTimeMin;
    @c("s_type")
    private RuleTimeType startTimeType;
    @c("time_offset")
    private int timeOffset;
    @c("week_day")
    private byte weekOfDays;
    private int year;

    public ThingRuleSchedule() {
        RuleTimeType ruleTimeType = RuleTimeType.NONE;
        this.startTimeType = ruleTimeType;
        this.endTimeType = ruleTimeType;
        this.mode = RuleMode.ONCE;
    }

    public int getDay() {
        return this.day;
    }

    public Map<String, Object> getDesiredStates() {
        return this.desiredStates;
    }

    public String getEndAction() {
        return this.endAction;
    }

    public int getEndTimeMin() {
        return this.endTimeMin;
    }

    public RuleTimeType getEndTimeType() {
        return this.endTimeType;
    }

    public String getId() {
        return this.id;
    }

    public RuleMode getMode() {
        return this.mode;
    }

    public int getMonth() {
        return this.month;
    }

    public String getStartAction() {
        return this.startAction;
    }

    public int getStartTimeMin() {
        return this.startTimeMin;
    }

    public RuleTimeType getStartTimeType() {
        return this.startTimeType;
    }

    public int getTimeOffset() {
        return this.timeOffset;
    }

    public byte getWeekOfDays() {
        return this.weekOfDays;
    }

    public int getYear() {
        return this.year;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setDay(int i) {
        this.day = i;
    }

    public void setDesiredStates(Map<String, Object> map) {
        this.desiredStates = map;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public void setEndAction(String str) {
        this.endAction = str;
    }

    public void setEndTimeMin(int i) {
        this.endTimeMin = i;
    }

    public void setEndTimeType(RuleTimeType ruleTimeType) {
        this.endTimeType = ruleTimeType;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMode(RuleMode ruleMode) {
        this.mode = ruleMode;
    }

    public void setMonth(int i) {
        this.month = i;
    }

    public void setStartAction(String str) {
        this.startAction = str;
    }

    public void setStartTimeMin(int i) {
        this.startTimeMin = i;
    }

    public void setStartTimeType(RuleTimeType ruleTimeType) {
        this.startTimeType = ruleTimeType;
    }

    public void setTimeOffset(int i) {
        this.timeOffset = i;
    }

    public void setWeekOfDays(byte b2) {
        this.weekOfDays = b2;
    }

    public void setYear(int i) {
        this.year = i;
    }

    public ThingRuleSchedule(boolean z, RuleTimeType ruleTimeType, int i, RuleTimeType ruleTimeType2, int i2, byte b2, RuleMode ruleMode) {
        RuleTimeType ruleTimeType3 = RuleTimeType.NONE;
        this.startTimeType = ruleTimeType3;
        this.endTimeType = ruleTimeType3;
        this.mode = RuleMode.ONCE;
        this.enable = z;
        this.startTimeType = ruleTimeType;
        this.startTimeMin = i;
        this.endTimeType = ruleTimeType2;
        this.endTimeMin = i2;
        this.weekOfDays = b2;
        this.mode = ruleMode;
    }
}

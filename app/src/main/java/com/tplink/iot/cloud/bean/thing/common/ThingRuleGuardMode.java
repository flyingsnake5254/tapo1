package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.q.b;
import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.common.MapJsonAdapter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class ThingRuleGuardMode {
    @c("alarm_time")
    @b(MapJsonAdapter.class)
    private Map<String, Object> alarmTime;
    @c("alarm_type")
    private String alarmType;
    @c("alarm_volume")
    private String alarmVolume;
    @c("device_id_list")
    private List<String> deviceIdList;
    private String id;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface GuardMode {
        public static final String AWAY = "away";
        public static final String HOME = "home";
        public static final String SLEEP = "sleep";
    }

    public ThingRuleGuardMode(String str, List<String> list, String str2, String str3, Map<String, Object> map) {
        this.id = str;
        this.deviceIdList = list;
        this.alarmType = str2;
        this.alarmVolume = str3;
        this.alarmTime = map;
    }

    public Map<String, Object> getAlarmTime() {
        return this.alarmTime;
    }

    public String getAlarmType() {
        return this.alarmType;
    }

    public String getAlarmVolume() {
        return this.alarmVolume;
    }

    public List<String> getDeviceIdList() {
        return this.deviceIdList;
    }

    public String getId() {
        return this.id;
    }

    public void setAlarmTime(Map<String, Object> map) {
        this.alarmTime = map;
    }

    public void setAlarmType(String str) {
        this.alarmType = str;
    }

    public void setAlarmVolume(String str) {
        this.alarmVolume = str;
    }

    public void setDeviceIdList(List<String> list) {
        this.deviceIdList = list;
    }

    public void setId(String str) {
        this.id = str;
    }
}

package com.tplink.iot.cloud.bean.thing.common;

import java.util.Map;

/* loaded from: classes2.dex */
public class ThingEventLog {
    private String eventId;
    private Integer logId;
    private String name;
    private Map<String, Object> params;
    private long timestamp;

    public String getEventId() {
        return this.eventId;
    }

    public Integer getLogId() {
        return this.logId;
    }

    public String getName() {
        return this.name;
    }

    public Map<String, Object> getParams() {
        return this.params;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setEventId(String str) {
        this.eventId = str;
    }

    public void setLogId(Integer num) {
        this.logId = num;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setParams(Map<String, Object> map) {
        this.params = map;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }
}

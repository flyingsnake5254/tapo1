package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.q.b;
import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.common.MapJsonAdapter;
import java.util.Map;

/* loaded from: classes2.dex */
public class ThingRuleTimer {
    @Deprecated
    private String action;
    private int delay;
    @c("desired_states")
    @b(MapJsonAdapter.class)
    private Map<String, Object> desiredStates;
    private boolean enable;
    private String id;
    private int remain;

    public ThingRuleTimer() {
    }

    public String getAction() {
        return this.action;
    }

    public int getDelay() {
        return this.delay;
    }

    public Map<String, Object> getDesiredStates() {
        return this.desiredStates;
    }

    public String getId() {
        return this.id;
    }

    public int getRemain() {
        return this.remain;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setDelay(int i) {
        this.delay = i;
    }

    public void setDesiredStates(Map<String, Object> map) {
        this.desiredStates = map;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setRemain(int i) {
        this.remain = i;
    }

    public ThingRuleTimer(boolean z, int i, Map<String, Object> map) {
        this.enable = z;
        this.delay = i;
        this.desiredStates = map;
    }

    public ThingRuleTimer(boolean z, int i, int i2, Map<String, Object> map) {
        this.enable = z;
        this.delay = i;
        this.remain = i2;
        this.desiredStates = map;
    }

    public ThingRuleTimer(boolean z, int i, int i2, String str) {
        this.enable = z;
        this.delay = i;
        this.remain = i2;
        this.action = str;
    }
}

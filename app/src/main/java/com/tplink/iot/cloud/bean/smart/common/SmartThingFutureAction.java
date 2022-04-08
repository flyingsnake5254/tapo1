package com.tplink.iot.cloud.bean.smart.common;

import com.google.gson.q.b;
import com.tplink.iot.cloud.bean.common.MapJsonAdapter;
import com.tplink.iot.cloud.bean.thing.params.ThingServiceParams;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes2.dex */
public class SmartThingFutureAction {
    private int delaySeconds;
    private ThingServiceParams service;
    @b(MapJsonAdapter.class)
    private Map<String, Object> stateDesired;

    public SmartThingFutureAction() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SmartThingFutureAction smartThingFutureAction = (SmartThingFutureAction) obj;
        return this.delaySeconds == smartThingFutureAction.delaySeconds && Objects.equals(this.stateDesired, smartThingFutureAction.stateDesired) && Objects.equals(this.service, smartThingFutureAction.service);
    }

    public int getDelaySeconds() {
        return this.delaySeconds;
    }

    public ThingServiceParams getService() {
        return this.service;
    }

    public Map<String, Object> getStateDesired() {
        return this.stateDesired;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.delaySeconds), this.stateDesired, this.service);
    }

    public void setDelaySeconds(int i) {
        this.delaySeconds = i;
    }

    public void setService(ThingServiceParams thingServiceParams) {
        this.service = thingServiceParams;
    }

    public void setStateDesired(Map<String, Object> map) {
        this.stateDesired = map;
    }

    public SmartThingFutureAction(int i, Map<String, Object> map) {
        this.delaySeconds = i;
        this.stateDesired = map;
    }

    public SmartThingFutureAction(int i, ThingServiceParams thingServiceParams) {
        this.delaySeconds = i;
        this.service = thingServiceParams;
    }
}

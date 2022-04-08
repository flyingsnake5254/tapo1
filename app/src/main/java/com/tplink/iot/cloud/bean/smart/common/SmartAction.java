package com.tplink.iot.cloud.bean.smart.common;

import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public class SmartAction {
    private List<SmartReferAction> smarts;
    private List<SmartThingAction> things;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SmartAction smartAction = (SmartAction) obj;
        return Objects.equals(this.smarts, smartAction.smarts) && Objects.equals(this.things, smartAction.things);
    }

    public List<SmartReferAction> getSmarts() {
        return this.smarts;
    }

    public List<SmartThingAction> getThings() {
        return this.things;
    }

    public int hashCode() {
        return Objects.hash(this.smarts, this.things);
    }

    public void setSmarts(List<SmartReferAction> list) {
        this.smarts = list;
    }

    public void setThings(List<SmartThingAction> list) {
        this.things = list;
    }
}

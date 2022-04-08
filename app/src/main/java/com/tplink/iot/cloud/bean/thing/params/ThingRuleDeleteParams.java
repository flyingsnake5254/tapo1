package com.tplink.iot.cloud.bean.thing.params;

import com.tplink.iot.cloud.enumerate.ThingRuleType;
import java.util.List;

/* loaded from: classes2.dex */
public class ThingRuleDeleteParams {
    private boolean removeAll;
    private List<String> ruleIds;
    private ThingRuleType ruleType;

    public ThingRuleDeleteParams() {
    }

    public List<String> getRuleIds() {
        return this.ruleIds;
    }

    public ThingRuleType getRuleType() {
        return this.ruleType;
    }

    public boolean isRemoveAll() {
        return this.removeAll;
    }

    public void setRemoveAll(boolean z) {
        this.removeAll = z;
    }

    public void setRuleIds(List<String> list) {
        this.ruleIds = list;
    }

    public void setRuleType(ThingRuleType thingRuleType) {
        this.ruleType = thingRuleType;
    }

    public ThingRuleDeleteParams(boolean z, ThingRuleType thingRuleType) {
        this.removeAll = z;
        this.ruleType = thingRuleType;
    }

    public ThingRuleDeleteParams(boolean z, ThingRuleType thingRuleType, List<String> list) {
        this.removeAll = z;
        this.ruleType = thingRuleType;
        this.ruleIds = list;
    }
}

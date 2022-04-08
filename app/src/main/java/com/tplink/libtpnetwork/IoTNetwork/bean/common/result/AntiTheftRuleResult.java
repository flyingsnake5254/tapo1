package com.tplink.libtpnetwork.IoTNetwork.bean.common.result;

import com.tplink.iot.cloud.bean.thing.common.ThingRuleAwayMode;
import com.tplink.iot.cloud.bean.thing.result.ThingRuleListResult;

/* loaded from: classes3.dex */
public class AntiTheftRuleResult extends ThingRuleListResult<ThingRuleAwayMode> {
    public AntiTheftRuleResult() {
    }

    public AntiTheftRuleResult(ThingRuleListResult<ThingRuleAwayMode> thingRuleListResult) {
        setMaxCount(thingRuleListResult.getMaxCount());
        setRuleList(thingRuleListResult.getRuleList());
        setEnable(!thingRuleListResult.getRuleList().isEmpty());
    }
}

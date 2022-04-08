package com.tplink.libtpnetwork.IoTNetwork.bean.common.result;

import com.tplink.iot.cloud.bean.thing.common.ThingRuleLightEffect;
import com.tplink.iot.cloud.bean.thing.result.ThingRuleListResult;

/* loaded from: classes3.dex */
public class LightEffectRuleResult extends ThingRuleListResult<ThingRuleLightEffect> {
    public LightEffectRuleResult() {
    }

    public LightEffectRuleResult(ThingRuleListResult<ThingRuleLightEffect> thingRuleListResult) {
        setEnable(thingRuleListResult.isEnable());
        setCurrentRuleId(thingRuleListResult.getCurrentRuleId());
        setMaxCount(thingRuleListResult.getMaxCount());
        setRuleList(thingRuleListResult.getRuleList());
    }
}

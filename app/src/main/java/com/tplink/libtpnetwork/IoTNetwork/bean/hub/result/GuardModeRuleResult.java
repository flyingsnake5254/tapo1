package com.tplink.libtpnetwork.IoTNetwork.bean.hub.result;

import com.tplink.iot.cloud.bean.thing.common.ThingRuleGuardMode;
import com.tplink.iot.cloud.bean.thing.result.ThingRuleListResult;
import java.util.List;
import kotlin.jvm.internal.j;

/* compiled from: GuardModeRuleResult.kt */
/* loaded from: classes3.dex */
public final class GuardModeRuleResult extends ThingRuleListResult<ThingRuleGuardMode> {
    public GuardModeRuleResult() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuardModeRuleResult(ThingRuleListResult<ThingRuleGuardMode> ruleListResult) {
        this();
        j.e(ruleListResult, "ruleListResult");
        setMaxCount(ruleListResult.getMaxCount());
        setRuleList(ruleListResult.getRuleList());
        List<ThingRuleGuardMode> ruleList = ruleListResult.getRuleList();
        j.d(ruleList, "ruleListResult.ruleList");
        setEnable(!ruleList.isEmpty());
    }
}

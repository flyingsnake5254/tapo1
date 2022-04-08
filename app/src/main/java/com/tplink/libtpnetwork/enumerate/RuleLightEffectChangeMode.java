package com.tplink.libtpnetwork.enumerate;

import com.tplink.iot.cloud.bean.thing.common.ThingRuleLightEffect;

/* loaded from: classes3.dex */
public enum RuleLightEffectChangeMode {
    MODE_DIRECT(ThingRuleLightEffect.ChangeMode.MODE_DIRECT),
    MODE_BLN(ThingRuleLightEffect.ChangeMode.MODE_BLN);
    
    private String name;

    RuleLightEffectChangeMode(String str) {
        this.name = str;
    }

    public static RuleLightEffectChangeMode fromString(String str) {
        if (ThingRuleLightEffect.ChangeMode.MODE_BLN.equals(str)) {
            return MODE_BLN;
        }
        return MODE_DIRECT;
    }

    public String getName() {
        return this.name;
    }
}

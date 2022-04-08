package com.tplink.iot.cloud.bean.thing.result;

import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingSupportAlarm;
import com.tplink.iot.cloud.bean.thing.common.ThingSupportCategory;

/* loaded from: classes2.dex */
public class ThingSupportInfoResult {
    private ThingComponentResult components;
    @c("support_alarms")
    private ThingSupportAlarm supportAlarms;
    @c("support_categories")
    private ThingSupportCategory supportCategories;

    public ThingComponentResult getComponents() {
        return this.components;
    }

    public ThingSupportAlarm getSupportAlarms() {
        return this.supportAlarms;
    }

    public ThingSupportCategory getSupportCategories() {
        return this.supportCategories;
    }

    public void setComponents(ThingComponentResult thingComponentResult) {
        this.components = thingComponentResult;
    }

    public void setSupportAlarms(ThingSupportAlarm thingSupportAlarm) {
        this.supportAlarms = thingSupportAlarm;
    }

    public void setSupportCategories(ThingSupportCategory thingSupportCategory) {
        this.supportCategories = thingSupportCategory;
    }
}

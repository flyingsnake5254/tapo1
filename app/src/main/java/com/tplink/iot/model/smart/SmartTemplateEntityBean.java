package com.tplink.iot.model.smart;

import com.tplink.iot.cloud.bean.smart.common.SmartTemplate;

/* loaded from: classes2.dex */
public class SmartTemplateEntityBean extends SmartTemplateBaseBean {
    private SmartTemplate mEntity;

    public SmartTemplateEntityBean(SmartTemplate smartTemplate) {
        setType(1);
        setEntity(smartTemplate);
    }

    public SmartTemplate getEntity() {
        return this.mEntity;
    }

    public void setEntity(SmartTemplate smartTemplate) {
        this.mEntity = smartTemplate;
    }
}

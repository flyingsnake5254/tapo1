package com.tplink.iot.cloud.bean.thing.common;

import com.tplink.iot.cloud.enumerate.PropertyAccessMode;

/* loaded from: classes2.dex */
public class ThingProperty {
    private PropertyAccessMode accessMode = PropertyAccessMode.WRITE;
    private String dataType;
    private String id;
    private boolean required;
    private ThingPropertySpec specs;

    public PropertyAccessMode getAccessMode() {
        return this.accessMode;
    }

    public String getDataType() {
        return this.dataType;
    }

    public String getId() {
        return this.id;
    }

    public ThingPropertySpec getSpecs() {
        return this.specs;
    }

    public boolean isRequired() {
        return this.required;
    }

    public void setAccessMode(PropertyAccessMode propertyAccessMode) {
        this.accessMode = propertyAccessMode;
    }

    public void setDataType(String str) {
        this.dataType = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setRequired(boolean z) {
        this.required = z;
    }

    public void setSpecs(ThingPropertySpec thingPropertySpec) {
        this.specs = thingPropertySpec;
    }
}

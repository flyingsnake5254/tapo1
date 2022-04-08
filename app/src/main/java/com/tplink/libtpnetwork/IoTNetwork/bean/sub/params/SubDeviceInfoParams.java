package com.tplink.libtpnetwork.IoTNetwork.bean.sub.params;

import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SubDeviceInfoParams.kt */
/* loaded from: classes3.dex */
public final class SubDeviceInfoParams extends DeviceInfoParams {
    @c(ThingModelDefine.Property.PROPERTY_FROST_PROTECTION_ON)
    private Boolean frostProtectionOn;
    @c(ThingModelDefine.Property.PROPERTY_MAX_CONTROL_TEMP)
    private Integer maxControlTemp;
    @c(ThingModelDefine.Property.PROPERTY_MIN_CONTROL_TEMP)
    private Integer minControlTemp;
    @c(ThingModelDefine.Property.PROPERTY_TARGET_TEMP)
    private Integer targetTemp;
    @c(ThingModelDefine.Property.PROPERTY_TEMP_OFFSET)
    private Integer tempOffset;
    @c(ThingModelDefine.Property.PROPERTY_TEMP_UNIT)
    private String tempUnit;

    public final Boolean getFrostProtectionOn() {
        return this.frostProtectionOn;
    }

    public final Integer getMaxControlTemp() {
        return this.maxControlTemp;
    }

    public final Integer getMinControlTemp() {
        return this.minControlTemp;
    }

    public final Integer getTargetTemp() {
        return this.targetTemp;
    }

    public final Integer getTempOffset() {
        return this.tempOffset;
    }

    public final String getTempUnit() {
        return this.tempUnit;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceInfoParams
    public boolean isMatchThingModel(ThingModel thingModel) {
        return thingModel != null;
    }

    public final void setFrostProtectionOn(Boolean bool) {
        this.frostProtectionOn = bool;
    }

    public final void setMaxControlTemp(Integer num) {
        this.maxControlTemp = num;
    }

    public final void setMinControlTemp(Integer num) {
        this.minControlTemp = num;
    }

    public final void setTargetTemp(Integer num) {
        this.targetTemp = num;
    }

    public final void setTempOffset(Integer num) {
        this.tempOffset = num;
    }

    public final void setTempUnit(String str) {
        this.tempUnit = str;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceInfoParams
    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        String str = this.tempUnit;
        if (str != null) {
            hashMap.put(ThingModelDefine.Property.PROPERTY_TEMP_UNIT, str);
        }
        Integer num = this.targetTemp;
        if (num != null) {
            hashMap.put(ThingModelDefine.Property.PROPERTY_TARGET_TEMP, Integer.valueOf(num.intValue()));
        }
        Integer num2 = this.tempOffset;
        if (num2 != null) {
            hashMap.put(ThingModelDefine.Property.PROPERTY_TEMP_OFFSET, Integer.valueOf(num2.intValue()));
        }
        Boolean bool = this.frostProtectionOn;
        if (bool != null) {
            hashMap.put(ThingModelDefine.Property.PROPERTY_FROST_PROTECTION_ON, Boolean.valueOf(bool.booleanValue()));
        }
        Integer num3 = this.minControlTemp;
        if (num3 != null) {
            hashMap.put(ThingModelDefine.Property.PROPERTY_MIN_CONTROL_TEMP, Integer.valueOf(num3.intValue()));
        }
        Integer num4 = this.maxControlTemp;
        if (num4 != null) {
            hashMap.put(ThingModelDefine.Property.PROPERTY_MAX_CONTROL_TEMP, Integer.valueOf(num4.intValue()));
        }
        return hashMap;
    }
}

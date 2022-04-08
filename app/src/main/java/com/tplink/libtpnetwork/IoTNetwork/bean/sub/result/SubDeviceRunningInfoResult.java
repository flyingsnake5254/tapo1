package com.tplink.libtpnetwork.IoTNetwork.bean.sub.result;

import b.d.w.c.a;
import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingDetail;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingProperty;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.iot.cloud.bean.thing.result.ThingShadowResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.Utils.i;
import com.tplink.libtpnetwork.enumerate.EnumTRVState;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class SubDeviceRunningInfoResult extends DeviceRunningInfoResult {
    private transient boolean atLowBattery;
    @c("bind_count")
    private int bindCount;
    private String category;
    @c(ThingModelDefine.Property.PROPERTY_CURRENT_TEMP)
    private float currentTemp;
    @c(ThingModelDefine.Property.PROPERTY_FROST_PROTECTION_ON)
    private boolean frostProtectionOn;
    @c(ThingModelDefine.Property.PROPERTY_MAX_CONTROL_TEMP)
    private int maxControlTemp;
    @c(ThingModelDefine.Property.PROPERTY_MIN_CONTROL_TEMP)
    private int minControlTemp;
    private String status;
    @c(ThingModelDefine.Property.PROPERTY_TARGET_TEMP)
    private int targetTemp;
    @c(ThingModelDefine.Property.PROPERTY_TEMP_OFFSET)
    private int tempOffset;
    @c(ThingModelDefine.Property.PROPERTY_TEMP_UNIT)
    private String tempUnit;
    @c(ThingModelDefine.Property.PROPERTY_TRV_STATES)
    private List<EnumTRVState> trvStates;

    public SubDeviceRunningInfoResult(ThingDetail thingDetail, ThingSetting thingSetting, ThingShadowResult thingShadowResult, ThingModel thingModel) {
        boolean z = false;
        this.atLowBattery = false;
        this.fwVer = thingDetail.getFwVer();
        this.ip = thingDetail.getIp();
        this.nickname = thingSetting.getNickname();
        this.avatar = thingSetting.getAvatarUrl();
        this.longitude = thingSetting.getLongitude();
        Integer latitude = thingSetting.getLatitude();
        this.latitude = latitude;
        Integer num = this.longitude;
        this.hasSetLocationInfo = num != null && latitude != null && Math.abs(num.intValue()) <= 1800000 && Math.abs(this.latitude.intValue()) <= 900000;
        if (thingModel != null) {
            ThingProperty thingProperty = thingModel.getThingProperty("on");
            if (thingProperty != null) {
                Object reportedValue = thingShadowResult.getReportedValue(thingProperty);
                this.deviceOn = (reportedValue instanceof Boolean) && ((Boolean) reportedValue).booleanValue();
            }
            ThingProperty thingProperty2 = thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_TEMP_UNIT);
            if (thingProperty2 != null) {
                Object reportedValue2 = thingShadowResult.getReportedValue(thingProperty2);
                this.tempUnit = reportedValue2 instanceof String ? (String) reportedValue2 : "celsius";
            }
            ThingProperty thingProperty3 = thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_CURRENT_TEMP);
            if (thingProperty3 != null) {
                Object reportedValue3 = thingShadowResult.getReportedValue(thingProperty3);
                this.currentTemp = reportedValue3 instanceof Number ? ((Number) reportedValue3).floatValue() : 0.0f;
            }
            ThingProperty thingProperty4 = thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_TARGET_TEMP);
            if (thingProperty4 != null) {
                Object reportedValue4 = thingShadowResult.getReportedValue(thingProperty4);
                this.targetTemp = reportedValue4 instanceof Number ? ((Number) reportedValue4).intValue() : 0;
            }
            ThingProperty thingProperty5 = thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_MIN_CONTROL_TEMP);
            if (thingProperty5 != null) {
                Object reportedValue5 = thingShadowResult.getReportedValue(thingProperty5);
                this.minControlTemp = reportedValue5 instanceof Number ? ((Number) reportedValue5).intValue() : 0;
            }
            ThingProperty thingProperty6 = thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_MAX_CONTROL_TEMP);
            if (thingProperty6 != null) {
                Object reportedValue6 = thingShadowResult.getReportedValue(thingProperty6);
                this.maxControlTemp = reportedValue6 instanceof Number ? ((Number) reportedValue6).intValue() : 0;
            }
            ThingProperty thingProperty7 = thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_TEMP_OFFSET);
            if (thingProperty7 != null) {
                Object reportedValue7 = thingShadowResult.getReportedValue(thingProperty7);
                this.tempOffset = reportedValue7 instanceof Number ? ((Number) reportedValue7).intValue() : 0;
            }
            ThingProperty thingProperty8 = thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_FROST_PROTECTION_ON);
            if (thingProperty8 != null) {
                Object reportedValue8 = thingShadowResult.getReportedValue(thingProperty8);
                this.frostProtectionOn = (reportedValue8 instanceof Boolean) && ((Boolean) reportedValue8).booleanValue();
            }
            ThingProperty thingProperty9 = thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_TRV_STATES);
            if (thingProperty9 != null) {
                Object reportedValue9 = thingShadowResult.getReportedValue(thingProperty9);
                ArrayList arrayList = new ArrayList();
                if (reportedValue9 instanceof String[]) {
                    for (String str : (String[]) reportedValue9) {
                        EnumTRVState fromString = EnumTRVState.fromString(str);
                        if (fromString != null) {
                            arrayList.add(fromString);
                        }
                    }
                }
                a.n("TRV", "enumTrvStates: " + i.j(arrayList));
                this.trvStates = arrayList;
            }
            ThingProperty thingProperty10 = thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_AT_LOW_BATTERY);
            if (thingProperty10 != null) {
                Object reportedValue10 = thingShadowResult.getReportedValue(thingProperty10);
                if ((reportedValue10 instanceof Boolean) && ((Boolean) reportedValue10).booleanValue()) {
                    z = true;
                }
                this.atLowBattery = z;
            }
        }
    }

    public int getBindCount() {
        return this.bindCount;
    }

    public String getCategory() {
        return this.category;
    }

    public float getCurrentTemp() {
        return this.currentTemp;
    }

    public int getMaxControlTemp() {
        return this.maxControlTemp;
    }

    public int getMinControlTemp() {
        return this.minControlTemp;
    }

    public String getStatus() {
        return this.status;
    }

    public int getTargetTemp() {
        return this.targetTemp;
    }

    public int getTempOffset() {
        return this.tempOffset;
    }

    public String getTempUnit() {
        return this.tempUnit;
    }

    public List<EnumTRVState> getTrvStates() {
        return this.trvStates;
    }

    public boolean isAtLowBattery() {
        return this.atLowBattery;
    }

    public boolean isFrostProtectionOn() {
        return this.frostProtectionOn;
    }

    public void setAtLowBattery(boolean z) {
        this.atLowBattery = z;
    }

    public void setBindCount(int i) {
        this.bindCount = i;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setCurrentTemp(float f2) {
        this.currentTemp = f2;
    }

    public void setFrostProtectionOn(boolean z) {
        this.frostProtectionOn = z;
    }

    public void setMaxControlTemp(int i) {
        this.maxControlTemp = i;
    }

    public void setMinControlTemp(int i) {
        this.minControlTemp = i;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setTargetTemp(int i) {
        this.targetTemp = i;
    }

    public void setTempOffset(int i) {
        this.tempOffset = i;
    }

    public void setTempUnit(String str) {
        this.tempUnit = str;
    }

    public void setTrvStates(List<EnumTRVState> list) {
        this.trvStates = list;
    }
}

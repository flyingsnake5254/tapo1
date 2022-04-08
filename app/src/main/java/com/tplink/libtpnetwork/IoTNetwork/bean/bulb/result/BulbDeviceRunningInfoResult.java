package com.tplink.libtpnetwork.IoTNetwork.bean.bulb.result;

import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingDetail;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingProperty;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.iot.cloud.bean.thing.result.ThingShadowResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.Utils.i;

/* loaded from: classes3.dex */
public class BulbDeviceRunningInfoResult extends DeviceRunningInfoResult {
    private transient boolean autoEnable;
    private transient String autoMode;
    private int brightness;
    @c(ThingModelDefine.Property.PROPERTY_COLOR_TEMP)
    private int colorTemp;
    @c(ThingModelDefine.Property.PROPERTY_DYNAMIC_LIGHT_EFFECT_ENABLE)
    private boolean dynamicLightEffectEnable;
    @c(ThingModelDefine.Property.PROPERTY_DYNAMIC_LIGHT_EFFECT_ID)
    private String dynamicLightEffectId;
    private int hue;
    private int saturation;

    public BulbDeviceRunningInfoResult() {
    }

    public String getAutoMode() {
        return this.autoMode;
    }

    public int getBrightness() {
        return this.brightness;
    }

    public int getColorTemp() {
        return this.colorTemp;
    }

    public String getDynamicLightEffectId() {
        return this.dynamicLightEffectId;
    }

    public int getHue() {
        return this.hue;
    }

    public int getSaturation() {
        return this.saturation;
    }

    public boolean isAutoEnable() {
        return this.autoEnable;
    }

    public boolean isDynamicLightEffectEnable() {
        return this.dynamicLightEffectEnable;
    }

    public void setAutoEnable(boolean z) {
        this.autoEnable = z;
    }

    public void setAutoMode(String str) {
        this.autoMode = str;
    }

    public void setBrightness(int i) {
        this.brightness = i;
    }

    public void setColorTemp(int i) {
        this.colorTemp = i;
    }

    public void setDynamicLightEffectEnable(boolean z) {
        this.dynamicLightEffectEnable = z;
    }

    public void setDynamicLightEffectId(String str) {
        this.dynamicLightEffectId = str;
    }

    public void setHue(int i) {
        this.hue = i;
    }

    public void setSaturation(int i) {
        this.saturation = i;
    }

    public BulbDeviceRunningInfoResult(ThingDetail thingDetail, ThingSetting thingSetting, ThingShadowResult thingShadowResult, ThingModel thingModel) {
        this.fwVer = thingDetail.getFwVer();
        this.ip = thingDetail.getIp();
        this.nickname = thingSetting.getNickname();
        this.avatar = thingSetting.getAvatarUrl();
        this.longitude = thingSetting.getLongitude();
        Integer latitude = thingSetting.getLatitude();
        this.latitude = latitude;
        Integer num = this.longitude;
        boolean z = true;
        this.hasSetLocationInfo = num != null && latitude != null && Math.abs(num.intValue()) <= 1800000 && Math.abs(this.latitude.intValue()) <= 900000;
        this.defaultStates = (DefaultStatesBean) i.a(thingSetting.getDefaultStates(), DefaultStatesBean.class);
        if (thingModel != null) {
            ThingProperty thingProperty = thingModel.getThingProperty("on");
            if (thingProperty != null) {
                Object reportedValue = thingShadowResult.getReportedValue(thingProperty);
                this.deviceOn = (reportedValue instanceof Boolean) && ((Boolean) reportedValue).booleanValue();
            }
            ThingProperty thingProperty2 = thingModel.getThingProperty("brightness");
            if (thingProperty2 != null) {
                Object reportedValue2 = thingShadowResult.getReportedValue(thingProperty2);
                this.brightness = reportedValue2 instanceof Number ? ((Number) reportedValue2).intValue() : 0;
            }
            ThingProperty thingProperty3 = thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_COLOR_TEMP);
            if (thingProperty3 != null) {
                Object reportedValue3 = thingShadowResult.getReportedValue(thingProperty3);
                this.colorTemp = reportedValue3 instanceof Number ? ((Number) reportedValue3).intValue() : 0;
            }
            ThingProperty thingProperty4 = thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_HUE);
            if (thingProperty4 != null) {
                Object reportedValue4 = thingShadowResult.getReportedValue(thingProperty4);
                this.hue = reportedValue4 instanceof Number ? ((Number) reportedValue4).intValue() : 0;
            }
            ThingProperty thingProperty5 = thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_SATURATION);
            if (thingProperty5 != null) {
                Object reportedValue5 = thingShadowResult.getReportedValue(thingProperty5);
                this.saturation = reportedValue5 instanceof Number ? ((Number) reportedValue5).intValue() : 0;
            }
            ThingProperty thingProperty6 = thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_AUTO);
            if (thingProperty6 != null) {
                Object reportedValue6 = thingShadowResult.getReportedValue(thingProperty6);
                this.autoEnable = (reportedValue6 instanceof Boolean) && ((Boolean) reportedValue6).booleanValue();
            }
            ThingProperty thingProperty7 = thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_AUTO_MODE);
            if (thingProperty7 != null) {
                this.autoMode = (String) thingShadowResult.getReportedValue(thingProperty7);
            }
            ThingProperty thingProperty8 = thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_DYNAMIC_LIGHT_EFFECT_ENABLE);
            if (thingProperty8 != null) {
                Object reportedValue7 = thingShadowResult.getReportedValue(thingProperty8);
                this.dynamicLightEffectEnable = (!(reportedValue7 instanceof Boolean) || !((Boolean) reportedValue7).booleanValue()) ? false : z;
            }
            ThingProperty thingProperty9 = thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_DYNAMIC_LIGHT_EFFECT_ID);
            if (thingProperty9 != null) {
                this.dynamicLightEffectId = (String) thingShadowResult.getReportedValue(thingProperty9);
            }
        }
    }
}

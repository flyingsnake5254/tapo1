package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.result;

import b.d.w.c.a;
import com.google.gson.i;
import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingDetail;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingProperty;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.iot.cloud.bean.thing.result.ThingShadowResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DefaultStatesStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.Utils.l;

/* loaded from: classes3.dex */
public class LightStripDeviceRunningInfoResult extends DeviceRunningInfoResult {
    private transient boolean autoEnable;
    private transient String autoMode;
    private int brightness;
    @c(ThingModelDefine.Property.PROPERTY_COLOR_TEMP)
    private int colorTemp;
    private int hue;
    @c(ThingModelDefine.Property.PROPERTY_LIGHTING_EFFECT)
    private LightingEffectData lightingEffectData;
    @c(ThingModelDefine.Property.PROPERTY_MUSIC_RHYTHM_ENABLE)
    private Boolean musicRhythmEnable;
    @c(ThingModelDefine.Property.PROPERTY_MUSIC_RHYTHM_MODE)
    private String musicRhythmMode;
    private int saturation;

    public LightStripDeviceRunningInfoResult(ThingDetail thingDetail, ThingSetting thingSetting, ThingShadowResult thingShadowResult, ThingModel thingModel) {
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
        if (thingSetting.getDefaultStates() != null) {
            i defaultStates = thingSetting.getDefaultStates();
            this.defaultStates = new DefaultStatesBean(defaultStates.c().n("type").e(), (DefaultStatesStateBean) com.tplink.libtpnetwork.Utils.i.a(defaultStates.c().n(DefaultStatesBean.KEY_STATE), DefaultStatesStateBean.class));
        }
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
            ThingProperty thingProperty3 = thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_HUE);
            if (thingProperty3 != null) {
                Object reportedValue3 = thingShadowResult.getReportedValue(thingProperty3);
                this.hue = reportedValue3 instanceof Number ? ((Number) reportedValue3).intValue() : 0;
            }
            ThingProperty thingProperty4 = thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_SATURATION);
            if (thingProperty4 != null) {
                Object reportedValue4 = thingShadowResult.getReportedValue(thingProperty4);
                this.saturation = reportedValue4 instanceof Number ? ((Number) reportedValue4).intValue() : 0;
            }
            ThingProperty thingProperty5 = thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_COLOR_TEMP);
            if (thingProperty5 != null) {
                Object reportedValue5 = thingShadowResult.getReportedValue(thingProperty5);
                this.colorTemp = reportedValue5 instanceof Number ? ((Number) reportedValue5).intValue() : 0;
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
            if (thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_LIGHTING_EFFECT) != null) {
                Object obj = null;
                if (!(thingShadowResult.getState() == null || thingShadowResult.getState().getReported() == null)) {
                    obj = thingShadowResult.getState().getReported().get(ThingModelDefine.Property.PROPERTY_LIGHTING_EFFECT);
                }
                this.lightingEffectData = LightingEffectData.resolveObject(obj);
                a.n("LightStrip", "LightStripDeviceRunningInfoResult lightingEffect from shadow: " + l.c(this.lightingEffectData));
            }
            ThingProperty thingProperty8 = thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_MUSIC_RHYTHM_ENABLE);
            if (thingProperty8 != null) {
                Object reportedValue7 = thingShadowResult.getReportedValue(thingProperty8);
                this.musicRhythmEnable = Boolean.valueOf((!(reportedValue7 instanceof Boolean) || !((Boolean) reportedValue7).booleanValue()) ? false : z);
            }
            ThingProperty thingProperty9 = thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_MUSIC_RHYTHM_MODE);
            if (thingProperty9 != null) {
                this.musicRhythmMode = (String) thingShadowResult.getReportedValue(thingProperty9);
            }
        }
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

    public int getHue() {
        return this.hue;
    }

    public LightingEffectData getLightingEffectData() {
        return this.lightingEffectData;
    }

    public String getMusicRhythmMode() {
        return this.musicRhythmMode;
    }

    public int getSaturation() {
        return this.saturation;
    }

    public boolean isAutoEnable() {
        return this.autoEnable;
    }

    public Boolean isMusicRhythmEnable() {
        return this.musicRhythmEnable;
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

    public void setHue(int i) {
        this.hue = i;
    }

    public void setLightingEffectData(LightingEffectData lightingEffectData) {
        this.lightingEffectData = lightingEffectData;
    }

    public void setMusicRhythmEnable(Boolean bool) {
        this.musicRhythmEnable = bool;
    }

    public void setMusicRhythmMode(String str) {
        this.musicRhythmMode = str;
    }

    public void setSaturation(int i) {
        this.saturation = i;
    }
}

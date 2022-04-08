package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params;

import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.AutoLightBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import java.util.Map;

/* loaded from: classes3.dex */
public class LightStripDeviceInfoParams extends DeviceInfoParams {
    private Boolean auto;
    @c(ThingModelDefine.Property.PROPERTY_AUTO_MODE)
    private String autoMode;
    private Integer brightness;
    @c(ThingModelDefine.Property.PROPERTY_COLOR_TEMP)
    private Integer colorTemp;
    private Integer hue;
    @c(ThingModelDefine.Property.PROPERTY_LIGHTING_EFFECT)
    private LightingEffectData lightingEffect;
    @c(ThingModelDefine.Property.PROPERTY_MUSIC_RHYTHM_ENABLE)
    private Boolean musicRhythmEnable;
    @c(ThingModelDefine.Property.PROPERTY_MUSIC_RHYTHM_MODE)
    private String musicRhythmMode;
    private Integer saturation;

    public LightStripDeviceInfoParams() {
    }

    public Boolean getAuto() {
        return this.auto;
    }

    public String getAutoMode() {
        return this.autoMode;
    }

    public Integer getBrightness() {
        return this.brightness;
    }

    public Integer getColorTemp() {
        return this.colorTemp;
    }

    public Integer getHue() {
        return this.hue;
    }

    public LightingEffectData getLightingEffect() {
        return this.lightingEffect;
    }

    public String getMusicRhythmMode() {
        return this.musicRhythmMode;
    }

    public Integer getSaturation() {
        return this.saturation;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceInfoParams
    public boolean isMatchThingModel(ThingModel thingModel) {
        return super.isMatchThingModel(thingModel) && thingModel.getThingProperty("brightness") != null;
    }

    public Boolean isMusicRhythmEnable() {
        return this.musicRhythmEnable;
    }

    public void setAuto(Boolean bool) {
        this.auto = bool;
    }

    public void setAutoMode(String str) {
        this.autoMode = str;
    }

    public void setBrightness(Integer num) {
        this.brightness = num;
    }

    public void setColorTemp(Integer num) {
        this.colorTemp = num;
    }

    public void setHue(Integer num) {
        this.hue = num;
    }

    public void setLightingEffect(LightingEffectData lightingEffectData) {
        this.lightingEffect = lightingEffectData;
    }

    public void setMusicRhythmEnable(Boolean bool) {
        this.musicRhythmEnable = bool;
    }

    public void setMusicRhythmMode(String str) {
        this.musicRhythmMode = str;
    }

    public void setSaturation(Integer num) {
        this.saturation = num;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceInfoParams
    public Map<String, Object> toMap(Map<String, Object> map) {
        Map<String, Object> map2 = super.toMap(map);
        Integer num = this.brightness;
        if (num != null) {
            map2.put("brightness", num);
        }
        Integer num2 = this.hue;
        if (num2 != null) {
            map2.put(ThingModelDefine.Property.PROPERTY_HUE, num2);
        }
        Integer num3 = this.saturation;
        if (num3 != null) {
            map2.put(ThingModelDefine.Property.PROPERTY_SATURATION, num3);
        }
        Integer num4 = this.colorTemp;
        if (num4 != null) {
            map2.put(ThingModelDefine.Property.PROPERTY_COLOR_TEMP, num4);
        }
        LightingEffectData lightingEffectData = this.lightingEffect;
        if (lightingEffectData != null) {
            map2.put(ThingModelDefine.Property.PROPERTY_LIGHTING_EFFECT, lightingEffectData);
        }
        Boolean bool = this.auto;
        if (bool != null) {
            map2.put(ThingModelDefine.Property.PROPERTY_AUTO, bool);
        }
        String str = this.autoMode;
        if (str != null) {
            map2.put(ThingModelDefine.Property.PROPERTY_AUTO_MODE, str);
        }
        Boolean bool2 = this.musicRhythmEnable;
        if (bool2 != null) {
            map2.put(ThingModelDefine.Property.PROPERTY_MUSIC_RHYTHM_ENABLE, bool2);
        }
        String str2 = this.musicRhythmMode;
        if (str2 != null) {
            map2.put(ThingModelDefine.Property.PROPERTY_MUSIC_RHYTHM_MODE, str2);
        }
        return map2;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceInfoParams
    public ThingSetting toThingSetting() {
        ThingSetting thingSetting = super.toThingSetting();
        if (getDefaultStates() != null) {
            thingSetting.setDefaultStates(getDefaultStates().toJsonTree());
        }
        return thingSetting;
    }

    public LightStripDeviceInfoParams(Boolean bool) {
        setDeviceOn(bool);
    }

    public LightStripDeviceInfoParams(Integer num) {
        this.brightness = num;
    }

    public LightStripDeviceInfoParams(LightStateBean lightStateBean) {
        if (lightStateBean != null) {
            this.hue = Integer.valueOf(lightStateBean.getHue());
            this.saturation = Integer.valueOf(lightStateBean.getSaturation());
            this.brightness = Integer.valueOf(lightStateBean.getBrightness());
            this.colorTemp = Integer.valueOf(lightStateBean.getColorTemp());
        }
    }

    public LightStripDeviceInfoParams(AutoLightBean autoLightBean) {
        if (autoLightBean != null) {
            this.auto = Boolean.valueOf(autoLightBean.isEnable());
            this.autoMode = autoLightBean.getMode();
        }
    }

    public LightStripDeviceInfoParams(DefaultStatesBean defaultStatesBean) {
        setDefaultStates(defaultStatesBean);
    }

    public LightStripDeviceInfoParams(LightingEffectData lightingEffectData) {
        this.lightingEffect = lightingEffectData;
    }
}

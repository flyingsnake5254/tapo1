package com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb;

import androidx.annotation.Nullable;
import com.google.gson.q.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes3.dex */
public class LightStateBean implements Serializable {
    private Integer brightness;
    @c(ThingModelDefine.Property.PROPERTY_COLOR_TEMP)
    private Integer colorTemp;
    private Integer hue;
    @c(ThingModelDefine.Property.PROPERTY_LIGHTING_EFFECT)
    private LightingEffectData lightingEffectData;
    private Boolean on;
    private Integer saturation;

    public LightStateBean() {
    }

    public int getBrightness() {
        Integer num = this.brightness;
        if (num == null) {
            return 100;
        }
        return num.intValue();
    }

    public int getColorTemp() {
        Integer num = this.colorTemp;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getHue() {
        Integer num = this.hue;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    @Nullable
    public LightingEffectData getLightingEffectData() {
        return this.lightingEffectData;
    }

    public int getSaturation() {
        Integer num = this.saturation;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public boolean isOn() {
        Boolean bool = this.on;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public void setBrightness(int i) {
        this.brightness = Integer.valueOf(i);
    }

    public void setColorTemp(int i) {
        this.colorTemp = Integer.valueOf(i);
    }

    public void setHue(int i) {
        this.hue = Integer.valueOf(i);
    }

    public void setLightingEffectData(LightingEffectData lightingEffectData) {
        this.lightingEffectData = lightingEffectData;
    }

    public void setOn(boolean z) {
        this.on = Boolean.valueOf(z);
    }

    public void setSaturation(int i) {
        this.saturation = Integer.valueOf(i);
    }

    public LightStateBean(boolean z) {
        if (z) {
            this.hue = 0;
            this.saturation = 0;
            this.colorTemp = 0;
            this.brightness = 0;
        }
    }

    public LightStateBean clone() {
        return new LightStateBean(getHue(), getSaturation(), getColorTemp(), getBrightness());
    }

    public LightStateBean(int i, int i2, int i3, int i4) {
        this.hue = Integer.valueOf(i);
        this.saturation = Integer.valueOf(i2);
        this.colorTemp = Integer.valueOf(i3);
        this.brightness = Integer.valueOf(i4);
    }

    public LightStateBean(List<Integer> list) {
        if (list != null && list.size() == 4) {
            this.brightness = list.get(0);
            this.hue = list.get(1);
            this.saturation = list.get(2);
            this.colorTemp = list.get(3);
        }
    }

    public LightStateBean(@Nullable LightStateBean lightStateBean) {
        if (lightStateBean != null) {
            this.hue = lightStateBean.hue;
            this.saturation = lightStateBean.saturation;
            this.brightness = lightStateBean.brightness;
            this.colorTemp = lightStateBean.colorTemp;
            this.on = lightStateBean.on;
            this.lightingEffectData = lightStateBean.lightingEffectData;
        }
    }
}

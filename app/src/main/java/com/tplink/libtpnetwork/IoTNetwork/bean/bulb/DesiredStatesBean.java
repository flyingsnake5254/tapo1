package com.tplink.libtpnetwork.IoTNetwork.bean.bulb;

import android.text.TextUtils;
import com.google.gson.q.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.Utils.i;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class DesiredStatesBean implements Serializable {
    private boolean auto;
    @c(ThingModelDefine.Property.PROPERTY_AUTO_MODE)
    private String autoMode;
    private int brightness;
    @c(ThingModelDefine.Property.PROPERTY_COLOR_TEMP)
    private int colorTemp;
    @c(ThingModelDefine.Property.PROPERTY_FROST_PROTECTION_ON)
    private boolean frostProtectionOn;
    private int hue;
    public transient boolean isTRV = false;
    @c(ThingModelDefine.Property.PROPERTY_LIGHTING_EFFECT)
    private LightingEffectData lightingEffectData;
    private boolean on;
    private int saturation;
    @c(ThingModelDefine.Property.PROPERTY_TARGET_TEMP)
    private int targetTemp;
    @c(ThingModelDefine.Property.PROPERTY_TEMP_UNIT)
    private String tempUnit;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DesiredStatesBean)) {
            return false;
        }
        DesiredStatesBean desiredStatesBean = (DesiredStatesBean) obj;
        if (this.isTRV) {
            boolean z = this.frostProtectionOn;
            if (z == desiredStatesBean.frostProtectionOn) {
                if (!z) {
                    return this.targetTemp == desiredStatesBean.targetTemp && TextUtils.equals(this.tempUnit, desiredStatesBean.tempUnit);
                }
                return true;
            }
        } else if (this.on == desiredStatesBean.on && this.auto == desiredStatesBean.isAuto()) {
            boolean z2 = this.on;
            if (z2 && this.auto) {
                return TextUtils.equals(this.autoMode, desiredStatesBean.getAutoMode());
            }
            LightingEffectData lightingEffectData = this.lightingEffectData;
            if (lightingEffectData != null) {
                return Objects.equals(lightingEffectData, desiredStatesBean.lightingEffectData);
            }
            if (z2) {
                return this.brightness == desiredStatesBean.brightness && this.colorTemp == desiredStatesBean.getColorTemp() && this.hue == desiredStatesBean.getHue() && this.saturation == desiredStatesBean.saturation;
            }
            return true;
        }
        return false;
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

    public int getSaturation() {
        return this.saturation;
    }

    public int getTargetTemp() {
        return this.targetTemp;
    }

    public String getTempUnit() {
        return this.tempUnit;
    }

    public int hashCode() {
        return this.brightness * (this.on ? 1231 : 1237);
    }

    public boolean isAuto() {
        return this.auto;
    }

    public boolean isFrostProtectionOn() {
        return this.frostProtectionOn;
    }

    public boolean isOn() {
        return this.on;
    }

    public void setAuto(boolean z) {
        this.auto = z;
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

    public void setFrostProtectionOn(boolean z) {
        this.frostProtectionOn = z;
    }

    public void setHue(int i) {
        this.hue = i;
    }

    public void setLightingEffectData(LightingEffectData lightingEffectData) {
        this.lightingEffectData = lightingEffectData;
    }

    public void setOn(boolean z) {
        this.on = z;
    }

    public void setSaturation(int i) {
        this.saturation = i;
    }

    public void setTargetTemp(int i) {
        this.targetTemp = i;
    }

    public void setTempUnit(String str) {
        this.tempUnit = str;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        if (this.isTRV) {
            hashMap.put(ThingModelDefine.Property.PROPERTY_FROST_PROTECTION_ON, Boolean.valueOf(this.frostProtectionOn));
            if (!this.frostProtectionOn) {
                hashMap.put(ThingModelDefine.Property.PROPERTY_TARGET_TEMP, Integer.valueOf(this.targetTemp));
                hashMap.put(ThingModelDefine.Property.PROPERTY_TEMP_UNIT, this.tempUnit);
            }
        } else {
            hashMap.put("on", Boolean.valueOf(this.on));
            if (this.on) {
                LightingEffectData lightingEffectData = this.lightingEffectData;
                if (lightingEffectData != null) {
                    hashMap.put(ThingModelDefine.Property.PROPERTY_LIGHTING_EFFECT, i.i(lightingEffectData));
                } else {
                    boolean z = this.auto;
                    if (z) {
                        hashMap.put(ThingModelDefine.Property.PROPERTY_AUTO, Boolean.valueOf(z));
                        String str = this.autoMode;
                        if (str != null) {
                            hashMap.put(ThingModelDefine.Property.PROPERTY_AUTO_MODE, str);
                        }
                    } else {
                        hashMap.put("brightness", Integer.valueOf(this.brightness));
                        hashMap.put(ThingModelDefine.Property.PROPERTY_COLOR_TEMP, Integer.valueOf(this.colorTemp));
                        hashMap.put(ThingModelDefine.Property.PROPERTY_SATURATION, Integer.valueOf(this.saturation));
                        hashMap.put(ThingModelDefine.Property.PROPERTY_HUE, Integer.valueOf(this.hue));
                    }
                }
            }
        }
        return hashMap;
    }
}

package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import b.d.w.c.a;
import com.google.gson.i;
import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingDetail;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingProperty;
import com.tplink.iot.cloud.bean.thing.common.ThingSetting;
import com.tplink.iot.cloud.bean.thing.result.ThingShadowResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DefaultStatesStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightStripDeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.result.LightStripDeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.Utils.l;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import java.util.Map;

/* loaded from: classes3.dex */
public class IoTLightStripDevice extends LocalIoTBaseDevice {
    private transient boolean autoEnable;
    private transient String autoMode;
    private int brightness;
    @c(ThingModelDefine.Property.PROPERTY_COLOR_TEMP)
    private int colorTemp;
    @Nullable
    @c("color_temp_range")
    private int[] colorTempRange;
    private int hue;
    @Nullable
    @c(ThingModelDefine.Property.PROPERTY_LIGHTING_EFFECT)
    private LightingEffectData lightingEffectData;
    @c(ThingModelDefine.Property.PROPERTY_MUSIC_RHYTHM_ENABLE)
    private Boolean musicRhythmEnable;
    @Nullable
    @c(ThingModelDefine.Property.PROPERTY_MUSIC_RHYTHM_MODE)
    private String musicRhythmMode;
    private int saturation;
    private transient int segments;

    public IoTLightStripDevice() {
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

    @Nullable
    public int[] getColorTempRange() {
        return this.colorTempRange;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice
    public DeviceInfoParams getDeviceInfoParams() {
        LightStripDeviceInfoParams lightStripDeviceInfoParams = new LightStripDeviceInfoParams();
        lightStripDeviceInfoParams.setNickname(this.nickname);
        lightStripDeviceInfoParams.setAvatar(this.avatar);
        lightStripDeviceInfoParams.setDeviceOn(Boolean.valueOf(this.deviceOn));
        lightStripDeviceInfoParams.setLongitude(this.longitude);
        lightStripDeviceInfoParams.setLatitude(this.latitude);
        lightStripDeviceInfoParams.setBrightness(Integer.valueOf(this.brightness));
        lightStripDeviceInfoParams.setSaturation(Integer.valueOf(this.saturation));
        lightStripDeviceInfoParams.setHue(Integer.valueOf(this.hue));
        lightStripDeviceInfoParams.setColorTemp(Integer.valueOf(this.colorTemp));
        lightStripDeviceInfoParams.setDefaultStates(this.defaultStates);
        lightStripDeviceInfoParams.setLightingEffect(this.lightingEffectData);
        lightStripDeviceInfoParams.setMusicRhythmEnable(this.musicRhythmEnable);
        lightStripDeviceInfoParams.setMusicRhythmMode(this.musicRhythmMode);
        return lightStripDeviceInfoParams;
    }

    public int getHue() {
        return this.hue;
    }

    public int getLightingEffectBrightness() {
        Integer num;
        LightingEffectData lightingEffectData = this.lightingEffectData;
        if (lightingEffectData == null || (num = lightingEffectData.brightness) == null) {
            return 100;
        }
        return num.intValue();
    }

    @Nullable
    public LightingEffectData getLightingEffectData() {
        return this.lightingEffectData;
    }

    @Nullable
    public String getMusicRhythmMode() {
        return this.musicRhythmMode;
    }

    public int getSaturation() {
        return this.saturation;
    }

    public int getSegments() {
        return this.segments;
    }

    public boolean isAutoEnable() {
        return this.autoEnable;
    }

    public boolean isLightingEffectEnabled() {
        LightingEffectData lightingEffectData = this.lightingEffectData;
        return lightingEffectData != null && lightingEffectData.enable.intValue() == 1 && !TextUtils.isEmpty(this.lightingEffectData.id) && !this.lightingEffectData.isGoogleLightingEffect();
    }

    public Boolean isMusicRhythmEnable() {
        return this.musicRhythmEnable;
    }

    public boolean isV1MusicRhythmEnableComponent() {
        return getComponentVersion(EnumIoTComponent.MUSIC_RHYTHM) == 1;
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

    public void setColorTempRange(@Nullable int[] iArr) {
        this.colorTempRange = iArr;
    }

    public void setHue(int i) {
        this.hue = i;
    }

    public void setLightingEffectData(@Nullable LightingEffectData lightingEffectData) {
        this.lightingEffectData = lightingEffectData;
    }

    public void setMusicRhythmEnable(Boolean bool) {
        this.musicRhythmEnable = bool;
    }

    public void setMusicRhythmMode(@Nullable String str) {
        this.musicRhythmMode = str;
    }

    public void setSaturation(int i) {
        this.saturation = i;
    }

    public void setSegments(int i) {
        this.segments = i;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice
    public void updateDeviceInfoParam(DeviceInfoParams deviceInfoParams) {
        super.updateDeviceInfoParam(deviceInfoParams);
        if (deviceInfoParams instanceof LightStripDeviceInfoParams) {
            LightStripDeviceInfoParams lightStripDeviceInfoParams = (LightStripDeviceInfoParams) deviceInfoParams;
            if (lightStripDeviceInfoParams.getBrightness() != null) {
                this.brightness = lightStripDeviceInfoParams.getBrightness().intValue();
            }
            if (lightStripDeviceInfoParams.getHue() != null) {
                this.hue = lightStripDeviceInfoParams.getHue().intValue();
            }
            if (lightStripDeviceInfoParams.getSaturation() != null) {
                this.saturation = lightStripDeviceInfoParams.getSaturation().intValue();
            }
            if (lightStripDeviceInfoParams.getColorTemp() != null) {
                this.colorTemp = lightStripDeviceInfoParams.getColorTemp().intValue();
            }
            if (lightStripDeviceInfoParams.getLightingEffect() != null) {
                this.lightingEffectData = lightStripDeviceInfoParams.getLightingEffect();
            }
            if (lightStripDeviceInfoParams.isMusicRhythmEnable() != null) {
                this.musicRhythmEnable = lightStripDeviceInfoParams.isMusicRhythmEnable();
            }
            if (lightStripDeviceInfoParams.getMusicRhythmMode() != null) {
                this.musicRhythmMode = lightStripDeviceInfoParams.getMusicRhythmMode();
            }
        }
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice
    public void updateDeviceRunningInfo(DeviceRunningInfoResult deviceRunningInfoResult, boolean z) {
        Integer num;
        LightingEffectData lightingEffectData;
        super.updateDeviceRunningInfo(deviceRunningInfoResult, z);
        if (deviceRunningInfoResult instanceof LightStripDeviceRunningInfoResult) {
            LightStripDeviceRunningInfoResult lightStripDeviceRunningInfoResult = (LightStripDeviceRunningInfoResult) deviceRunningInfoResult;
            this.brightness = lightStripDeviceRunningInfoResult.getBrightness();
            this.hue = lightStripDeviceRunningInfoResult.getHue();
            this.saturation = lightStripDeviceRunningInfoResult.getSaturation();
            this.colorTemp = lightStripDeviceRunningInfoResult.getColorTemp();
            if (lightStripDeviceRunningInfoResult.getAutoMode() != null) {
                this.autoMode = lightStripDeviceRunningInfoResult.getAutoMode();
            }
            LightingEffectData lightingEffectData2 = lightStripDeviceRunningInfoResult.getLightingEffectData();
            if (lightingEffectData2 != null) {
                Integer num2 = lightingEffectData2.bAdjusted;
                if (num2 != null && (num = lightingEffectData2.brightness) != null && (lightingEffectData = this.lightingEffectData) != null) {
                    lightingEffectData.brightness = num;
                } else if (num2 == null) {
                    this.lightingEffectData = lightingEffectData2;
                } else {
                    this.lightingEffectData = null;
                }
            } else {
                this.lightingEffectData = null;
            }
            this.musicRhythmEnable = lightStripDeviceRunningInfoResult.isMusicRhythmEnable();
            this.musicRhythmMode = lightStripDeviceRunningInfoResult.getMusicRhythmMode();
        }
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice
    public void updateDeviceShadow(Map<String, Object> map) {
        Integer num;
        LightingEffectData lightingEffectData;
        super.updateDeviceShadow(map);
        if (map != null) {
            boolean z = true;
            if (map.containsKey("on")) {
                Object obj = map.get("on");
                this.deviceOn = (obj instanceof Boolean) && ((Boolean) obj).booleanValue();
            }
            if (map.containsKey("brightness")) {
                Object obj2 = map.get("brightness");
                this.brightness = obj2 instanceof Number ? ((Number) obj2).intValue() : 0;
            }
            if (map.containsKey(ThingModelDefine.Property.PROPERTY_HUE)) {
                Object obj3 = map.get(ThingModelDefine.Property.PROPERTY_HUE);
                this.hue = obj3 instanceof Number ? ((Number) obj3).intValue() : 0;
            }
            if (map.containsKey(ThingModelDefine.Property.PROPERTY_SATURATION)) {
                Object obj4 = map.get(ThingModelDefine.Property.PROPERTY_SATURATION);
                this.saturation = obj4 instanceof Number ? ((Number) obj4).intValue() : 0;
            }
            if (map.containsKey(ThingModelDefine.Property.PROPERTY_COLOR_TEMP)) {
                Object obj5 = map.get(ThingModelDefine.Property.PROPERTY_COLOR_TEMP);
                this.colorTemp = obj5 instanceof Number ? ((Number) obj5).intValue() : 0;
            }
            if (map.containsKey(ThingModelDefine.Property.PROPERTY_AUTO)) {
                Object obj6 = map.get(ThingModelDefine.Property.PROPERTY_AUTO);
                this.autoEnable = (obj6 instanceof Boolean) && ((Boolean) obj6).booleanValue();
            }
            if (map.containsKey(ThingModelDefine.Property.PROPERTY_AUTO_MODE)) {
                this.autoMode = (String) map.get(ThingModelDefine.Property.PROPERTY_AUTO_MODE);
            }
            if (map.containsKey(ThingModelDefine.Property.PROPERTY_MUSIC_RHYTHM_ENABLE)) {
                Object obj7 = map.get(ThingModelDefine.Property.PROPERTY_MUSIC_RHYTHM_ENABLE);
                if (!(obj7 instanceof Boolean) || !((Boolean) obj7).booleanValue()) {
                    z = false;
                }
                this.musicRhythmEnable = Boolean.valueOf(z);
            }
            if (map.containsKey(ThingModelDefine.Property.PROPERTY_MUSIC_RHYTHM_MODE)) {
                this.musicRhythmMode = (String) map.get(ThingModelDefine.Property.PROPERTY_MUSIC_RHYTHM_MODE);
            }
            if (map.containsKey(ThingModelDefine.Property.PROPERTY_LIGHTING_EFFECT)) {
                LightingEffectData resolveObject = LightingEffectData.resolveObject(map.get(ThingModelDefine.Property.PROPERTY_LIGHTING_EFFECT));
                if (resolveObject != null) {
                    Integer num2 = resolveObject.bAdjusted;
                    if (num2 != null && (num = resolveObject.brightness) != null && (lightingEffectData = this.lightingEffectData) != null) {
                        lightingEffectData.brightness = num;
                    } else if (num2 == null) {
                        this.lightingEffectData = resolveObject;
                    } else {
                        this.lightingEffectData = null;
                    }
                } else {
                    this.lightingEffectData = null;
                }
                a.n("LightStrip", "updateDeviceShadow lightingEffect from shadow: " + l.c(resolveObject));
            }
        }
    }

    public IoTLightStripDevice(ThingDetail thingDetail, ThingSetting thingSetting, ThingShadowResult thingShadowResult, ThingModel thingModel) {
        Integer num;
        LightingEffectData lightingEffectData;
        this.deviceId = thingShadowResult.getThingName();
        this.type = thingDetail.getDeviceType();
        this.model = thingDetail.getModel();
        this.ssid = thingDetail.getSsid();
        this.mac = thingDetail.getMac();
        this.hwVer = thingDetail.getHwVer();
        this.hwId = thingDetail.getHwId();
        this.fwVer = thingDetail.getFwVer();
        this.fwId = thingDetail.getFwId();
        this.oemId = thingDetail.getOemId();
        this.ip = thingDetail.getIp();
        this.nickname = thingSetting.getNickname();
        this.avatar = thingSetting.getAvatarUrl();
        this.longitude = thingSetting.getLongitude();
        Integer latitude = thingSetting.getLatitude();
        this.latitude = latitude;
        Integer num2 = this.longitude;
        boolean z = true;
        this.hasSetLocationInfo = num2 != null && latitude != null && Math.abs(num2.intValue()) <= 1800000 && Math.abs(this.latitude.intValue()) <= 900000;
        this.timeDiff = thingSetting.getTimeDiff().intValue();
        this.region = thingSetting.getRegion();
        this.lang = thingSetting.getLang();
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
                if (thingProperty5.getSpecs() != null) {
                    int min = (int) thingProperty5.getSpecs().getMin();
                    int max = (int) thingProperty5.getSpecs().getMax();
                    if (!(min == 0 || max == 0 || min > max)) {
                        this.colorTempRange = new int[]{min, max};
                    }
                }
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
            ThingProperty thingProperty8 = thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_MUSIC_RHYTHM_ENABLE);
            if (thingProperty8 != null) {
                Object reportedValue7 = thingShadowResult.getReportedValue(thingProperty8);
                this.musicRhythmEnable = Boolean.valueOf((!(reportedValue7 instanceof Boolean) || !((Boolean) reportedValue7).booleanValue()) ? false : z);
            }
            ThingProperty thingProperty9 = thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_MUSIC_RHYTHM_MODE);
            if (thingProperty9 != null) {
                this.musicRhythmMode = (String) thingShadowResult.getReportedValue(thingProperty9);
            }
            if (thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_LIGHTING_EFFECT) != null) {
                LightingEffectData resolveObject = LightingEffectData.resolveObject((thingShadowResult.getState() == null || thingShadowResult.getState().getReported() == null) ? null : thingShadowResult.getState().getReported().get(ThingModelDefine.Property.PROPERTY_LIGHTING_EFFECT));
                if (resolveObject != null) {
                    Integer num3 = resolveObject.bAdjusted;
                    if (num3 != null && (num = resolveObject.brightness) != null && (lightingEffectData = this.lightingEffectData) != null) {
                        lightingEffectData.brightness = num;
                    } else if (num3 == null) {
                        this.lightingEffectData = resolveObject;
                    } else {
                        this.lightingEffectData = null;
                    }
                } else {
                    this.lightingEffectData = null;
                }
                a.n("LightStrip", "IoTLightStripDevice lightingEffect from shadow: " + l.c(resolveObject));
            }
        }
    }
}

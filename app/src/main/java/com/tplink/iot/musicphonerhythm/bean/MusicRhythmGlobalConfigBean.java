package com.tplink.iot.musicphonerhythm.bean;

import com.google.gson.q.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;

/* loaded from: classes2.dex */
public class MusicRhythmGlobalConfigBean {
    @c("base_brightness")
    private int baseBrightness;
    @c(ThingModelDefine.Property.PROPERTY_HUE)
    private int hue;
    @c(ThingModelDefine.Property.PROPERTY_SATURATION)
    private int saturation;
    @c("single_color_enable")
    private boolean singleColorEnable;

    public MusicRhythmGlobalConfigBean(boolean z, int i, int i2, int i3) {
        this.singleColorEnable = z;
        this.hue = i;
        this.saturation = i2;
        this.baseBrightness = i3;
    }

    public int getBaseBrightness() {
        return this.baseBrightness;
    }

    public int getHue() {
        return this.hue;
    }

    public int getSaturation() {
        return this.saturation;
    }

    public boolean isSingleColorEnable() {
        return this.singleColorEnable;
    }

    public void setBaseBrightness(int i) {
        this.baseBrightness = i;
    }

    public void setHue(int i) {
        this.hue = i;
    }

    public void setSaturation(int i) {
        this.saturation = i;
    }

    public void setSingleColorEnable(boolean z) {
        this.singleColorEnable = z;
    }
}

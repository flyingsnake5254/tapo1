package com.tplink.libtpnetwork.IoTNetwork.bean.bulb;

import androidx.annotation.Nullable;
import com.google.gson.i;
import com.google.gson.k;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.DefaultStatesStateBean;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class DefaultStatesBean implements Serializable {
    public static final String KEY_BRIGHTNESS = "brightness";
    public static final String KEY_STATE = "state";
    public static final String KEY_TYPE = "type";
    public static final String TYPE_CUSTOM = "custom";
    public static final String TYPE_LAST_STATES = "last_states";
    private BrightnessBean brightness;
    @Nullable
    private DefaultStatesStateBean state;
    private String type;

    /* loaded from: classes3.dex */
    public static class BrightnessBean implements Serializable {
        private String type;
        private Integer value;

        public String getType() {
            return this.type;
        }

        public int getValue() {
            Integer num = this.value;
            if (num == null) {
                return 1;
            }
            return num.intValue();
        }

        public void setType(String str) {
            this.type = str;
        }

        public void setValue(Integer num) {
            this.value = num;
        }
    }

    public DefaultStatesBean() {
    }

    public BrightnessBean getBrightness() {
        return this.brightness;
    }

    public LightStateBean getLightState() {
        return this.state;
    }

    @Nullable
    public DefaultStatesStateBean getState() {
        return this.state;
    }

    public String getType() {
        return this.type;
    }

    public void setBrightness(BrightnessBean brightnessBean) {
        this.brightness = brightnessBean;
    }

    public void setLightState(LightStateBean lightStateBean) {
        this.state = new DefaultStatesStateBean(lightStateBean);
    }

    public void setState(@Nullable DefaultStatesStateBean defaultStatesStateBean) {
        this.state = defaultStatesStateBean;
    }

    public void setType(String str) {
        this.type = str;
    }

    public i toJsonTree() {
        if (this.brightness != null) {
            k kVar = new k();
            kVar.j("brightness", com.tplink.libtpnetwork.Utils.i.i(this.brightness));
            return kVar;
        }
        k kVar2 = new k();
        kVar2.m("type", this.type);
        DefaultStatesStateBean defaultStatesStateBean = this.state;
        if (defaultStatesStateBean != null) {
            kVar2.j(KEY_STATE, defaultStatesStateBean.toJsonTree());
        }
        return kVar2;
    }

    public DefaultStatesBean(String str, @Nullable DefaultStatesStateBean defaultStatesStateBean) {
        this.type = str;
        this.state = defaultStatesStateBean;
    }
}

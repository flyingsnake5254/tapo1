package com.tplink.libtpnetwork.IoTNetwork.bean.bulb;

import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class BrightnessPresetsBean {
    private transient boolean isFromLocal;
    private boolean isSet;
    private PresetBean presets;

    /* loaded from: classes3.dex */
    public static class PresetBean {
        private List<Integer> brightness = new ArrayList();
        private List<LightStateBean> states = new ArrayList();

        public List<Integer> getBrightness() {
            return this.brightness;
        }

        public List<LightStateBean> getStates() {
            return this.states;
        }

        public void setBrightness(List<Integer> list) {
            this.brightness = list;
        }

        public void setStates(List<LightStateBean> list) {
            this.states = list;
        }
    }

    public PresetBean getPresets() {
        return this.presets;
    }

    public boolean isFromLocal() {
        return this.isFromLocal;
    }

    public boolean isSet() {
        return this.isSet;
    }

    public void setFromLocal(boolean z) {
        this.isFromLocal = z;
    }

    public void setPresets(PresetBean presetBean) {
        this.presets = presetBean;
    }

    public void setSet(boolean z) {
        this.isSet = z;
    }
}

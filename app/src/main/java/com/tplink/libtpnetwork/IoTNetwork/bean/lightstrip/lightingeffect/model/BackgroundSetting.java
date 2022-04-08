package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model;

import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.ColorHSBAttributeValue;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.LongAttributeValue;
import com.tplink.libtpnetwork.Utils.b0;
import java.util.List;

/* loaded from: classes3.dex */
public class BackgroundSetting {
    private ColorSequence colors;
    private LongAttributeValue fadeOff;

    /* loaded from: classes3.dex */
    public static final class BackgroundSettingBuilder {
        private ColorSequence colors;
        private LongAttributeValue fadeOff;

        public static BackgroundSettingBuilder aBackgroundSetting() {
            return new BackgroundSettingBuilder();
        }

        public BackgroundSetting build() {
            BackgroundSetting backgroundSetting = new BackgroundSetting();
            backgroundSetting.setFadeOff(this.fadeOff);
            backgroundSetting.setColors(this.colors);
            return backgroundSetting;
        }

        public BackgroundSettingBuilder colors(ColorSequence colorSequence) {
            this.colors = colorSequence;
            return this;
        }

        public BackgroundSettingBuilder fadeOff(LongAttributeValue longAttributeValue) {
            this.fadeOff = longAttributeValue;
            return this;
        }

        private BackgroundSettingBuilder() {
        }
    }

    public static BackgroundSettingBuilder builder() {
        return new BackgroundSettingBuilder();
    }

    public ColorSequence getColors() {
        return this.colors;
    }

    public LongAttributeValue getFadeOff() {
        return this.fadeOff;
    }

    public void setColors(ColorSequence colorSequence) {
        this.colors = colorSequence;
    }

    public void setFadeOff(LongAttributeValue longAttributeValue) {
        this.fadeOff = longAttributeValue;
    }

    public boolean validate(List<ColorHSBAttributeValue> list) {
        ColorSequence colorSequence;
        return this.fadeOff != null && (colorSequence = this.colors) != null && !b0.b(colorSequence.getSeq()) && this.fadeOff.isValid() && this.colors.isRegisteredIn(list);
    }
}

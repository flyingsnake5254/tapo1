package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model;

import com.google.gson.q.b;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.ColorHSBAttributeValue;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.IntegerAttributeValue;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.LongAttributeValue;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.Direction;

/* loaded from: classes3.dex */
public class LightingEffectSettings {
    private BackgroundSetting background;
    private ColorHSBAttributeValue color;
    private ColorSequence colorSequence;
    private LongAttributeValue delay;
    @b(Direction.DirectionDeserializer.class)
    private Direction direction;
    @Deprecated
    private LongAttributeValue period;
    private IntegerAttributeValue randomSeed;
    private String repeat;
    private Integer spread;
    private LongAttributeValue transition;

    /* loaded from: classes3.dex */
    public static final class LightingEffectSettingsBuilder {
        private BackgroundSetting background;
        private ColorHSBAttributeValue color;
        private ColorSequence colorSequence;
        private LongAttributeValue delay;
        private Direction direction;
        @Deprecated
        private LongAttributeValue period;
        private IntegerAttributeValue randomSeed;
        private String repeat;
        private Integer spread;
        private LongAttributeValue transition;

        public LightingEffectSettingsBuilder background(BackgroundSetting backgroundSetting) {
            this.background = backgroundSetting;
            return this;
        }

        public LightingEffectSettings build() {
            LightingEffectSettings lightingEffectSettings = new LightingEffectSettings();
            lightingEffectSettings.setTransition(this.transition);
            lightingEffectSettings.setDelay(this.delay);
            lightingEffectSettings.setPeriod(this.period);
            lightingEffectSettings.setColor(this.color);
            lightingEffectSettings.setRandomSeed(this.randomSeed);
            lightingEffectSettings.setBackground(this.background);
            lightingEffectSettings.setColorSequence(this.colorSequence);
            lightingEffectSettings.setSpread(this.spread);
            lightingEffectSettings.setRepeat(this.repeat);
            lightingEffectSettings.setDirection(this.direction);
            return lightingEffectSettings;
        }

        public LightingEffectSettingsBuilder color(ColorHSBAttributeValue colorHSBAttributeValue) {
            this.color = colorHSBAttributeValue;
            return this;
        }

        public LightingEffectSettingsBuilder colorSequence(ColorSequence colorSequence) {
            this.colorSequence = colorSequence;
            return this;
        }

        public LightingEffectSettingsBuilder delay(LongAttributeValue longAttributeValue) {
            this.delay = longAttributeValue;
            return this;
        }

        public LightingEffectSettingsBuilder direction(Direction direction) {
            this.direction = direction;
            return this;
        }

        @Deprecated
        public LightingEffectSettingsBuilder period(LongAttributeValue longAttributeValue) {
            this.period = longAttributeValue;
            return this;
        }

        public LightingEffectSettingsBuilder randomSeed(IntegerAttributeValue integerAttributeValue) {
            this.randomSeed = integerAttributeValue;
            return this;
        }

        public LightingEffectSettingsBuilder repeat(String str) {
            this.repeat = str;
            return this;
        }

        public LightingEffectSettingsBuilder spread(Integer num) {
            this.spread = num;
            return this;
        }

        public LightingEffectSettingsBuilder transition(LongAttributeValue longAttributeValue) {
            this.transition = longAttributeValue;
            return this;
        }

        private LightingEffectSettingsBuilder() {
        }
    }

    public static LightingEffectSettingsBuilder builder() {
        return new LightingEffectSettingsBuilder();
    }

    public BackgroundSetting getBackground() {
        return this.background;
    }

    public ColorHSBAttributeValue getColor() {
        return this.color;
    }

    public ColorSequence getColorSequence() {
        return this.colorSequence;
    }

    public LongAttributeValue getDelay() {
        return this.delay;
    }

    public Direction getDirection() {
        return this.direction;
    }

    @Deprecated
    public LongAttributeValue getPeriod() {
        return this.period;
    }

    public IntegerAttributeValue getRandomSeed() {
        return this.randomSeed;
    }

    public String getRepeat() {
        return this.repeat;
    }

    public Integer getSpread() {
        return this.spread;
    }

    public LongAttributeValue getTransition() {
        return this.transition;
    }

    public void setBackground(BackgroundSetting backgroundSetting) {
        this.background = backgroundSetting;
    }

    public void setColor(ColorHSBAttributeValue colorHSBAttributeValue) {
        this.color = colorHSBAttributeValue;
    }

    public void setColorSequence(ColorSequence colorSequence) {
        this.colorSequence = colorSequence;
    }

    public void setDelay(LongAttributeValue longAttributeValue) {
        this.delay = longAttributeValue;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Deprecated
    public void setPeriod(LongAttributeValue longAttributeValue) {
        this.period = longAttributeValue;
    }

    public void setRandomSeed(IntegerAttributeValue integerAttributeValue) {
        this.randomSeed = integerAttributeValue;
    }

    public void setRepeat(String str) {
        this.repeat = str;
    }

    public void setSpread(Integer num) {
        this.spread = num;
    }

    public void setTransition(LongAttributeValue longAttributeValue) {
        this.transition = longAttributeValue;
    }
}

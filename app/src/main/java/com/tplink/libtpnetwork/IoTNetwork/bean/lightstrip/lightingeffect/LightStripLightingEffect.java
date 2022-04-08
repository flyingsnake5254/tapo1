package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect;

import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.ColorHSBAttributeValue;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.AbstractLightingEffect;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.CustomizationSettings;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.ExpansionStrategy;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.LightingEffectMeta;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.LightingEffectSettings;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.Segment;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.Type;
import java.util.List;

/* loaded from: classes3.dex */
public class LightStripLightingEffect extends AbstractLightingEffect {
    private Integer index;
    private Boolean modifySubsetBrightnessValues;
    private Integer onOff;
    private Integer segmentLength;
    private String sourceType;

    /* loaded from: classes3.dex */
    public static final class Builder {
        private String animationType;
        private List<ColorHSBAttributeValue> colorRegistry;
        private Long createdOn;
        private CustomizationSettings customization;
        private ExpansionStrategy expansionStrategy;
        private String id;
        private Integer index;
        private LightingEffectMeta meta;
        private Boolean modifySubsetBrightnessValues;
        private Integer onOff;
        private Integer segmentLength;
        private List<Segment> segments;
        private LightingEffectSettings settings;
        private String sourceType;
        private Type type;
        private Long updatedOn;
        private Integer version;

        public Builder animationType(String str) {
            this.animationType = str;
            return this;
        }

        public LightStripLightingEffect build() {
            return new LightStripLightingEffect(this);
        }

        public Builder colorRegistry(List<ColorHSBAttributeValue> list) {
            this.colorRegistry = list;
            return this;
        }

        public Builder createdOn(Long l) {
            this.createdOn = l;
            return this;
        }

        public Builder customization(CustomizationSettings customizationSettings) {
            this.customization = customizationSettings;
            return this;
        }

        public Builder expansionStrategy(ExpansionStrategy expansionStrategy) {
            this.expansionStrategy = expansionStrategy;
            return this;
        }

        public Builder id(String str) {
            this.id = str;
            return this;
        }

        public Builder index(Integer num) {
            this.index = num;
            return this;
        }

        public Builder meta(LightingEffectMeta lightingEffectMeta) {
            this.meta = lightingEffectMeta;
            return this;
        }

        public Builder modifySubsetBrightnessValues(Boolean bool) {
            this.modifySubsetBrightnessValues = bool;
            return this;
        }

        public Builder onOff(Integer num) {
            this.onOff = num;
            return this;
        }

        public Builder segmentLength(Integer num) {
            this.segmentLength = num;
            return this;
        }

        public Builder segments(List<Segment> list) {
            this.segments = list;
            return this;
        }

        public Builder settings(LightingEffectSettings lightingEffectSettings) {
            this.settings = lightingEffectSettings;
            return this;
        }

        public Builder sourceType(String str) {
            this.sourceType = str;
            return this;
        }

        public Builder type(Type type) {
            this.type = type;
            return this;
        }

        public Builder updatedOn(Long l) {
            this.updatedOn = l;
            return this;
        }

        public Builder version(Integer num) {
            this.version = num;
            return this;
        }

        private Builder() {
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public Integer getIndex() {
        return this.index;
    }

    public Boolean getModifySubsetBrightnessValues() {
        return this.modifySubsetBrightnessValues;
    }

    public Integer getOnOff() {
        return this.onOff;
    }

    public Integer getSegmentLength() {
        return this.segmentLength;
    }

    public String getSourceType() {
        return this.sourceType;
    }

    public void setIndex(Integer num) {
        this.index = num;
    }

    public void setModifySubsetBrightnessValues(Boolean bool) {
        this.modifySubsetBrightnessValues = bool;
    }

    public void setOnOff(Integer num) {
        this.onOff = num;
    }

    public void setSegmentLength(Integer num) {
        this.segmentLength = num;
    }

    public void setSourceType(String str) {
        this.sourceType = str;
    }

    public LightStripLightingEffect() {
        this.modifySubsetBrightnessValues = Boolean.FALSE;
    }

    private LightStripLightingEffect(Builder builder) {
        this.modifySubsetBrightnessValues = Boolean.FALSE;
        setId(builder.id);
        setType(builder.type);
        setExpansionStrategy(builder.expansionStrategy);
        setMeta(builder.meta);
        setColorRegistry(builder.colorRegistry);
        setSettings(builder.settings);
        setSegments(builder.segments);
        setCustomization(builder.customization);
        setAnimationType(builder.animationType);
        setVersion(builder.version);
        setCreatedOn(builder.createdOn);
        setUpdatedOn(builder.updatedOn);
        setOnOff(builder.onOff);
        setIndex(builder.index);
        setSourceType(builder.sourceType);
        setSegmentLength(builder.segmentLength);
        setModifySubsetBrightnessValues(builder.modifySubsetBrightnessValues);
    }
}

package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model;

import com.google.gson.k;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.ColorHSBAttributeValue;
import java.util.List;

/* loaded from: classes3.dex */
public class CustomizedEffect extends AbstractLightingEffect {
    private Long accountId;
    private String predefinedEffectId;
    private k templateInput;

    /* loaded from: classes3.dex */
    public static final class CustomizedEffectBuilder {
        private Long accountId;
        private String animationType;
        private List<ColorHSBAttributeValue> colorRegistry;
        private Long createdOn;
        private CustomizationSettings customization;
        private ExpansionStrategy expansionStrategy;
        private String id;
        private LightingEffectMeta meta;
        private String predefinedEffectId;
        private List<Segment> segments;
        private LightingEffectSettings settings;
        private k templateInput;
        private Type type;
        private Long updatedOn;
        private Integer version;

        public CustomizedEffectBuilder accountId(Long l) {
            this.accountId = l;
            return this;
        }

        public CustomizedEffectBuilder animationType(String str) {
            this.animationType = str;
            return this;
        }

        public CustomizedEffect build() {
            CustomizedEffect customizedEffect = new CustomizedEffect();
            customizedEffect.setPredefinedEffectId(this.predefinedEffectId);
            customizedEffect.setAccountId(this.accountId);
            customizedEffect.setId(this.id);
            customizedEffect.setType(this.type);
            customizedEffect.setExpansionStrategy(this.expansionStrategy);
            customizedEffect.setMeta(this.meta);
            customizedEffect.setColorRegistry(this.colorRegistry);
            customizedEffect.setSettings(this.settings);
            customizedEffect.setSegments(this.segments);
            customizedEffect.setCustomization(this.customization);
            customizedEffect.setAnimationType(this.animationType);
            Integer num = this.version;
            if (num == null) {
                customizedEffect.setVersion(LightingEffectsConstants.DEFAULT_VERSION);
            } else {
                customizedEffect.setVersion(num);
            }
            customizedEffect.setTemplateInput(this.templateInput);
            customizedEffect.setCreatedOn(this.createdOn);
            customizedEffect.setUpdatedOn(this.updatedOn);
            return customizedEffect;
        }

        public CustomizedEffectBuilder colorRegistry(List<ColorHSBAttributeValue> list) {
            this.colorRegistry = list;
            return this;
        }

        public CustomizedEffectBuilder createdOn(Long l) {
            this.createdOn = l;
            return this;
        }

        public CustomizedEffectBuilder customization(CustomizationSettings customizationSettings) {
            this.customization = customizationSettings;
            return this;
        }

        public CustomizedEffectBuilder expansionStrategy(ExpansionStrategy expansionStrategy) {
            this.expansionStrategy = expansionStrategy;
            return this;
        }

        public CustomizedEffectBuilder id(String str) {
            this.id = str;
            return this;
        }

        public CustomizedEffectBuilder meta(LightingEffectMeta lightingEffectMeta) {
            this.meta = lightingEffectMeta;
            return this;
        }

        public CustomizedEffectBuilder predefinedEffectId(String str) {
            this.predefinedEffectId = str;
            return this;
        }

        public CustomizedEffectBuilder segments(List<Segment> list) {
            this.segments = list;
            return this;
        }

        public CustomizedEffectBuilder settings(LightingEffectSettings lightingEffectSettings) {
            this.settings = lightingEffectSettings;
            return this;
        }

        public CustomizedEffectBuilder templateInput(k kVar) {
            this.templateInput = kVar;
            return this;
        }

        public CustomizedEffectBuilder type(Type type) {
            this.type = type;
            return this;
        }

        public CustomizedEffectBuilder updatedOn(Long l) {
            this.updatedOn = l;
            return this;
        }

        public CustomizedEffectBuilder version(Integer num) {
            this.version = num;
            return this;
        }

        private CustomizedEffectBuilder() {
        }
    }

    public static CustomizedEffectBuilder builder() {
        return new CustomizedEffectBuilder();
    }

    public Long getAccountId() {
        return this.accountId;
    }

    public String getPredefinedEffectId() {
        return this.predefinedEffectId;
    }

    public k getTemplateInput() {
        return this.templateInput;
    }

    public void setAccountId(Long l) {
        this.accountId = l;
    }

    public void setPredefinedEffectId(String str) {
        this.predefinedEffectId = str;
    }

    public void setTemplateInput(k kVar) {
        this.templateInput = kVar;
    }
}

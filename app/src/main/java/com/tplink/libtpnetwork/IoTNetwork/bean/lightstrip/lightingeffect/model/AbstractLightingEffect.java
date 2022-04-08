package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model;

import com.google.gson.q.b;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.ColorHSBAttributeValue;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.ExpansionStrategy;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model.Type;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class AbstractLightingEffect {
    private String animationType;
    private List<ColorHSBAttributeValue> colorRegistry;
    private Long createdOn;
    private CustomizationSettings customization;
    @b(ExpansionStrategy.ExpansionStrategyDeserializer.class)
    private ExpansionStrategy expansionStrategy;
    private String id;
    private LightingEffectMeta meta;
    private List<Segment> segments;
    private LightingEffectSettings settings;
    @b(Type.TypeDeserializer.class)
    private Type type;
    private Long updatedOn;
    private Integer version = LightingEffectsConstants.DEFAULT_VERSION;

    public String getAnimationType() {
        return this.animationType;
    }

    public List<ColorHSBAttributeValue> getColorRegistry() {
        return this.colorRegistry;
    }

    public Long getCreatedOn() {
        return this.createdOn;
    }

    public CustomizationSettings getCustomization() {
        return this.customization;
    }

    public ExpansionStrategy getExpansionStrategy() {
        return this.expansionStrategy;
    }

    public String getId() {
        return this.id;
    }

    public LightingEffectMeta getMeta() {
        return this.meta;
    }

    public List<Segment> getSegments() {
        return this.segments;
    }

    public LightingEffectSettings getSettings() {
        return this.settings;
    }

    public Type getType() {
        return this.type;
    }

    public Long getUpdatedOn() {
        return this.updatedOn;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setAnimationType(String str) {
        this.animationType = str;
    }

    public void setColorRegistry(List<ColorHSBAttributeValue> list) {
        this.colorRegistry = list;
    }

    public void setCreatedOn(Long l) {
        this.createdOn = l;
    }

    public void setCustomization(CustomizationSettings customizationSettings) {
        this.customization = customizationSettings;
    }

    public void setExpansionStrategy(ExpansionStrategy expansionStrategy) {
        this.expansionStrategy = expansionStrategy;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMeta(LightingEffectMeta lightingEffectMeta) {
        this.meta = lightingEffectMeta;
    }

    public void setSegments(List<Segment> list) {
        this.segments = list;
    }

    public void setSettings(LightingEffectSettings lightingEffectSettings) {
        this.settings = lightingEffectSettings;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setUpdatedOn(Long l) {
        this.updatedOn = l;
    }

    public void setVersion(Integer num) {
        this.version = num;
    }
}

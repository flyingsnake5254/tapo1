package com.tplink.iot.devices.lightstrip.lightingeffect.common;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes2.dex */
public class LightingEffectStateMeta implements Serializable {
    private String animationType;
    private List<Integer> colorList;
    private String id;
    private String imageUrl;
    private String name;
    private Integer onOff;
    private String type;

    public String getAnimationType() {
        return this.animationType;
    }

    public List<Integer> getColorList() {
        return this.colorList;
    }

    public String getId() {
        return this.id;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getName() {
        return this.name;
    }

    public Integer getOnOff() {
        return this.onOff;
    }

    public String getType() {
        return this.type;
    }

    public boolean isOn() {
        Integer num = this.onOff;
        return num != null && num.intValue() >= 1;
    }

    public void merge(LightingEffectStateMeta lightingEffectStateMeta) {
        if (lightingEffectStateMeta.getName() != null) {
            setName(lightingEffectStateMeta.getName());
        }
        if (lightingEffectStateMeta.getId() != null) {
            setId(lightingEffectStateMeta.getId());
        }
        if (lightingEffectStateMeta.getType() != null) {
            setType(lightingEffectStateMeta.getType());
        }
        if (lightingEffectStateMeta.getAnimationType() != null) {
            setAnimationType(lightingEffectStateMeta.getAnimationType());
        }
        if (lightingEffectStateMeta.getOnOff() != null) {
            setOnOff(lightingEffectStateMeta.getOnOff());
        }
        if (lightingEffectStateMeta.getImageUrl() != null) {
            setImageUrl(lightingEffectStateMeta.getImageUrl());
        }
        if (lightingEffectStateMeta.getColorList() != null) {
            setColorList(lightingEffectStateMeta.getColorList());
        }
    }

    public void setAnimationType(String str) {
        this.animationType = str;
    }

    public void setColorList(List<Integer> list) {
        this.colorList = list;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOnOff(Integer num) {
        this.onOff = num;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "LightingEffectStateMeta{name='" + this.name + "', id='" + this.id + "', type='" + this.type + "', animationType='" + this.animationType + "', onOff=" + this.onOff + ", imageUrl='" + this.imageUrl + "', colorList=" + this.colorList + '}';
    }
}

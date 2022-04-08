package com.tplink.iot.cloud.bean.thing.common;

import java.util.List;

/* loaded from: classes2.dex */
public class ThingEvent {
    private String description;
    private int expiresIn;
    private String id;
    private List<ThingProperty> uploadParams;

    public String getDescription() {
        return this.description;
    }

    public int getExpiresIn() {
        return this.expiresIn;
    }

    public String getId() {
        return this.id;
    }

    public List<ThingProperty> getUploadParams() {
        return this.uploadParams;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setExpiresIn(int i) {
        this.expiresIn = i;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setUploadParams(List<ThingProperty> list) {
        this.uploadParams = list;
    }
}

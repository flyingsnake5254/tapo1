package com.tplink.iot.cloud.bean.thing.common;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class ThingService {
    private String id;
    private List<ThingProperty> inputParams = new ArrayList();
    private List<ThingProperty> outputParams = new ArrayList();

    public String getId() {
        return this.id;
    }

    public List<ThingProperty> getInputParams() {
        return this.inputParams;
    }

    public List<ThingProperty> getOutputParams() {
        return this.outputParams;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setInputParams(List<ThingProperty> list) {
        this.inputParams = list;
    }

    public void setOutputParams(List<ThingProperty> list) {
        this.outputParams = list;
    }
}

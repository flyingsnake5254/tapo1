package com.aigestudio.wheelpicker.model;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class City implements Serializable {
    public List<String> area;
    public String name;

    public List<String> getArea() {
        return this.area;
    }

    public String getName() {
        return this.name;
    }

    public void setArea(List<String> list) {
        this.area = list;
    }

    public void setName(String str) {
        this.name = str;
    }
}

package com.tplink.libtpanalytics.bean;

/* loaded from: classes3.dex */
public class GAParams {
    private String action;
    private String category;
    private String label;
    private String value;

    public GAParams(String str, String str2) {
        this.category = str;
        this.action = str2;
    }

    public String getAction() {
        return this.action;
    }

    public String getCategory() {
        return this.category;
    }

    public String getLabel() {
        return this.label;
    }

    public String getValue() {
        return this.value;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setValue(String str) {
        this.value = str;
    }
}

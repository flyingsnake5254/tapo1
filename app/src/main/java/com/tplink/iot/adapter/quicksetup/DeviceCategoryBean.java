package com.tplink.iot.adapter.quicksetup;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class DeviceCategoryBean implements Serializable {
    private String categoryName;
    private String device;
    private boolean isCategory;
    private boolean isEnable;

    public DeviceCategoryBean(String str) {
        this.isEnable = true;
        this.device = str;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public String getDevice() {
        return this.device;
    }

    public boolean isCategory() {
        return this.isCategory;
    }

    public boolean isEnable() {
        return this.isEnable;
    }

    public void setCategory(boolean z) {
        this.isCategory = z;
    }

    public void setCategoryName(String str) {
        this.categoryName = str;
    }

    public void setDevice(String str) {
        this.device = str;
    }

    public void setEnable(boolean z) {
        this.isEnable = z;
    }

    public DeviceCategoryBean(String str, boolean z) {
        this.isEnable = true;
        this.device = str;
        this.isEnable = z;
    }

    public DeviceCategoryBean(boolean z, String str) {
        this.isEnable = true;
        this.isCategory = z;
        this.categoryName = str;
    }
}

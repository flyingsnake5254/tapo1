package com.tplink.iot.adapter.home;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class HomeFamilySelectBean implements Serializable {
    private String familyId;
    private String familyName;
    private boolean isSelected;

    public HomeFamilySelectBean() {
    }

    public String getFamilyId() {
        return this.familyId;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setFamilyId(String str) {
        this.familyId = str;
    }

    public void setFamilyName(String str) {
        this.familyName = str;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public HomeFamilySelectBean(String str, String str2, boolean z) {
        this.familyId = str;
        this.familyName = str2;
        this.isSelected = z;
    }
}

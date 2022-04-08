package com.tplink.libtpnetwork.IoTNetwork.bean.trv;

import com.google.gson.q.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import kotlin.jvm.internal.j;

/* compiled from: FrostProtectionBean.kt */
/* loaded from: classes3.dex */
public final class FrostProtectionBean {
    @c("min_temp")
    private int minTemp;
    @c(ThingModelDefine.Property.PROPERTY_TEMP_UNIT)
    private String tempUnit;

    public FrostProtectionBean(int i, String str) {
        this.minTemp = i;
        this.tempUnit = str;
    }

    public static /* synthetic */ FrostProtectionBean copy$default(FrostProtectionBean frostProtectionBean, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = frostProtectionBean.minTemp;
        }
        if ((i2 & 2) != 0) {
            str = frostProtectionBean.tempUnit;
        }
        return frostProtectionBean.copy(i, str);
    }

    public final int component1() {
        return this.minTemp;
    }

    public final String component2() {
        return this.tempUnit;
    }

    public final FrostProtectionBean copy(int i, String str) {
        return new FrostProtectionBean(i, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FrostProtectionBean)) {
            return false;
        }
        FrostProtectionBean frostProtectionBean = (FrostProtectionBean) obj;
        return this.minTemp == frostProtectionBean.minTemp && j.a(this.tempUnit, frostProtectionBean.tempUnit);
    }

    public final int getMinTemp() {
        return this.minTemp;
    }

    public final String getTempUnit() {
        return this.tempUnit;
    }

    public int hashCode() {
        int i = this.minTemp * 31;
        String str = this.tempUnit;
        return i + (str != null ? str.hashCode() : 0);
    }

    public final void setMinTemp(int i) {
        this.minTemp = i;
    }

    public final void setTempUnit(String str) {
        this.tempUnit = str;
    }

    public String toString() {
        return "FrostProtectionBean(minTemp=" + this.minTemp + ", tempUnit=" + this.tempUnit + ")";
    }
}

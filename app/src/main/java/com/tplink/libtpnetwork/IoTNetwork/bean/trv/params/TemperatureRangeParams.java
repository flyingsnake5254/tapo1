package com.tplink.libtpnetwork.IoTNetwork.bean.trv.params;

import com.google.gson.q.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import kotlin.jvm.internal.j;

/* compiled from: TemperatureRangeParams.kt */
/* loaded from: classes3.dex */
public final class TemperatureRangeParams {
    @c(ThingModelDefine.Property.PROPERTY_MAX_CONTROL_TEMP)
    private int maxControlTemp;
    @c(ThingModelDefine.Property.PROPERTY_MIN_CONTROL_TEMP)
    private int minControlTemp;
    @c(ThingModelDefine.Property.PROPERTY_TEMP_UNIT)
    private String tempUnit;

    public TemperatureRangeParams(int i, int i2, String tempUnit) {
        j.e(tempUnit, "tempUnit");
        this.minControlTemp = i;
        this.maxControlTemp = i2;
        this.tempUnit = tempUnit;
    }

    public static /* synthetic */ TemperatureRangeParams copy$default(TemperatureRangeParams temperatureRangeParams, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = temperatureRangeParams.minControlTemp;
        }
        if ((i3 & 2) != 0) {
            i2 = temperatureRangeParams.maxControlTemp;
        }
        if ((i3 & 4) != 0) {
            str = temperatureRangeParams.tempUnit;
        }
        return temperatureRangeParams.copy(i, i2, str);
    }

    public final int component1() {
        return this.minControlTemp;
    }

    public final int component2() {
        return this.maxControlTemp;
    }

    public final String component3() {
        return this.tempUnit;
    }

    public final TemperatureRangeParams copy(int i, int i2, String tempUnit) {
        j.e(tempUnit, "tempUnit");
        return new TemperatureRangeParams(i, i2, tempUnit);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TemperatureRangeParams)) {
            return false;
        }
        TemperatureRangeParams temperatureRangeParams = (TemperatureRangeParams) obj;
        return this.minControlTemp == temperatureRangeParams.minControlTemp && this.maxControlTemp == temperatureRangeParams.maxControlTemp && j.a(this.tempUnit, temperatureRangeParams.tempUnit);
    }

    public final int getMaxControlTemp() {
        return this.maxControlTemp;
    }

    public final int getMinControlTemp() {
        return this.minControlTemp;
    }

    public final String getTempUnit() {
        return this.tempUnit;
    }

    public int hashCode() {
        int i = ((this.minControlTemp * 31) + this.maxControlTemp) * 31;
        String str = this.tempUnit;
        return i + (str != null ? str.hashCode() : 0);
    }

    public final void setMaxControlTemp(int i) {
        this.maxControlTemp = i;
    }

    public final void setMinControlTemp(int i) {
        this.minControlTemp = i;
    }

    public final void setTempUnit(String str) {
        j.e(str, "<set-?>");
        this.tempUnit = str;
    }

    public String toString() {
        return "TemperatureRangeParams(minControlTemp=" + this.minControlTemp + ", maxControlTemp=" + this.maxControlTemp + ", tempUnit=" + this.tempUnit + ")";
    }
}

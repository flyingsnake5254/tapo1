package com.tplink.libtpnetwork.IoTNetwork.bean.trv.params;

import com.google.gson.q.c;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import kotlin.jvm.internal.j;

/* compiled from: TemperatureOffsetParams.kt */
/* loaded from: classes3.dex */
public final class TemperatureOffsetParams {
    private int offset;
    @c(ThingModelDefine.Property.PROPERTY_TEMP_UNIT)
    private String tempUnit;

    public TemperatureOffsetParams(int i, String tempUnit) {
        j.e(tempUnit, "tempUnit");
        this.offset = i;
        this.tempUnit = tempUnit;
    }

    public static /* synthetic */ TemperatureOffsetParams copy$default(TemperatureOffsetParams temperatureOffsetParams, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = temperatureOffsetParams.offset;
        }
        if ((i2 & 2) != 0) {
            str = temperatureOffsetParams.tempUnit;
        }
        return temperatureOffsetParams.copy(i, str);
    }

    public final int component1() {
        return this.offset;
    }

    public final String component2() {
        return this.tempUnit;
    }

    public final TemperatureOffsetParams copy(int i, String tempUnit) {
        j.e(tempUnit, "tempUnit");
        return new TemperatureOffsetParams(i, tempUnit);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TemperatureOffsetParams)) {
            return false;
        }
        TemperatureOffsetParams temperatureOffsetParams = (TemperatureOffsetParams) obj;
        return this.offset == temperatureOffsetParams.offset && j.a(this.tempUnit, temperatureOffsetParams.tempUnit);
    }

    public final int getOffset() {
        return this.offset;
    }

    public final String getTempUnit() {
        return this.tempUnit;
    }

    public int hashCode() {
        int i = this.offset * 31;
        String str = this.tempUnit;
        return i + (str != null ? str.hashCode() : 0);
    }

    public final void setOffset(int i) {
        this.offset = i;
    }

    public final void setTempUnit(String str) {
        j.e(str, "<set-?>");
        this.tempUnit = str;
    }

    public String toString() {
        return "TemperatureOffsetParams(offset=" + this.offset + ", tempUnit=" + this.tempUnit + ")";
    }
}

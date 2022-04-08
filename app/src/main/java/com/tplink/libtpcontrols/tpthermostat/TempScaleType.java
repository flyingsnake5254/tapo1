package com.tplink.libtpcontrols.tpthermostat;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public enum TempScaleType {
    SCALE_TYPE_C(0, "C"),
    SCALE_TYPE_F(1, "F");
    
    private static Map<String, TempScaleType> stringToEnum = new HashMap();
    private String name;
    private int value;

    static {
        TempScaleType[] values;
        for (TempScaleType tempScaleType : values()) {
            stringToEnum.put(tempScaleType.toString(), tempScaleType);
        }
    }

    TempScaleType(int i, String str) {
        this.value = i;
        this.name = str;
    }

    public static TempScaleType fromString(String str) {
        return stringToEnum.get(str);
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return getName();
    }
}

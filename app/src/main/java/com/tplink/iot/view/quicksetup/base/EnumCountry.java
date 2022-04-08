package com.tplink.iot.view.quicksetup.base;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum EnumCountry {
    EU("EU"),
    US("US"),
    UK("UK"),
    JP("JP"),
    FR("FR"),
    AU("AU");
    
    private static Map<String, EnumCountry> countryMap = new HashMap();
    private String name;

    static {
        EnumCountry[] values;
        for (EnumCountry enumCountry : values()) {
            countryMap.put(enumCountry.getName(), enumCountry);
        }
    }

    EnumCountry(String str) {
        this.name = str;
    }

    public static EnumCountry fromString(String str) {
        return countryMap.get(str);
    }

    public String getName() {
        return this.name;
    }
}

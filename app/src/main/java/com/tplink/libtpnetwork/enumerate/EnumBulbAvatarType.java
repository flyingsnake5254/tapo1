package com.tplink.libtpnetwork.enumerate;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public enum EnumBulbAvatarType {
    BULB("bulb"),
    TABLE_LAMP_1("table_lamp_1"),
    TABLE_LAMP_2("table_lamp_2"),
    TABLE_LAMP_3("table_lamp_3"),
    TABLE_LAMP_4("table_lamp_4"),
    TABLE_LAMP_5("table_lamp_5"),
    HANG_LAMP_1("hang_lamp_1"),
    HANG_LAMP_2("hang_lamp_2"),
    HANG_LAMP_3("hang_lamp_3"),
    FLOOR_LAMP_1("floor_lamp_1"),
    FLOOR_LAMP_2("floor_lamp_2"),
    FLOOR_LAMP_3("floor_lamp_3");
    
    private static Map<String, EnumBulbAvatarType> typeMap = new HashMap();
    private String name;

    static {
        EnumBulbAvatarType[] values;
        for (EnumBulbAvatarType enumBulbAvatarType : values()) {
            typeMap.put(enumBulbAvatarType.name, enumBulbAvatarType);
        }
    }

    EnumBulbAvatarType(String str) {
        this.name = str;
    }

    public static EnumBulbAvatarType fromString(String str) {
        return typeMap.get(str);
    }

    public String getName() {
        return this.name;
    }
}

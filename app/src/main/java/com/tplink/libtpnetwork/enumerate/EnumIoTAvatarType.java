package com.tplink.libtpnetwork.enumerate;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public enum EnumIoTAvatarType {
    PLUG("plug"),
    FAN("fan"),
    TABLE_LAMP("table_lamp"),
    CEILING_LAMP("ceiling_lamp"),
    TAPE_LIGHTS("tape_lights"),
    WALL_LAMP("wall_lamp"),
    SOUND("sound"),
    RADIO("radio"),
    HUMIDIFIER("humidifier"),
    KETTLE("kettle"),
    COFFEE_MAKER("coffee_maker"),
    JUICER("juicer"),
    EGG_BOILER("egg_boiler"),
    BREAD_MAKER("bread_maker"),
    HOUSE("house");
    
    private static Map<String, EnumIoTAvatarType> typeMap = new HashMap();
    private String name;

    static {
        EnumIoTAvatarType[] values;
        for (EnumIoTAvatarType enumIoTAvatarType : values()) {
            typeMap.put(enumIoTAvatarType.getName(), enumIoTAvatarType);
        }
    }

    EnumIoTAvatarType(String str) {
        this.name = str;
    }

    public static EnumIoTAvatarType fromString(String str) {
        return typeMap.get(str);
    }

    public String getName() {
        return this.name;
    }
}

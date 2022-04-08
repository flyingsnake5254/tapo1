package com.tplink.libtpnetwork.enumerate;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public enum EnumSwitchAvatarType {
    SWITCH_S220("switch"),
    SWITCH_S210("switch_s210"),
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
    FLOOR_LAMP_3("floor_lamp_3"),
    FAN("fan");
    
    private static Map<String, EnumSwitchAvatarType> typeMap = new HashMap();
    private String name;

    static {
        EnumSwitchAvatarType[] values;
        for (EnumSwitchAvatarType enumSwitchAvatarType : values()) {
            typeMap.put(enumSwitchAvatarType.name, enumSwitchAvatarType);
        }
    }

    EnumSwitchAvatarType(String str) {
        this.name = str;
    }

    @Nullable
    public static EnumSwitchAvatarType fromString(String str) {
        return typeMap.get(str);
    }

    private static List<String> getAllAvatarNames() {
        ArrayList arrayList = new ArrayList();
        for (EnumSwitchAvatarType enumSwitchAvatarType : values()) {
            arrayList.add(enumSwitchAvatarType.name);
        }
        return arrayList;
    }

    public static List<String> getS210AvatarNames() {
        List<String> allAvatarNames = getAllAvatarNames();
        allAvatarNames.remove(SWITCH_S220.name);
        return allAvatarNames;
    }

    public static List<String> getS220AvatarNames() {
        List<String> allAvatarNames = getAllAvatarNames();
        allAvatarNames.remove(SWITCH_S210.name);
        return allAvatarNames;
    }

    public String getName() {
        return this.name;
    }
}

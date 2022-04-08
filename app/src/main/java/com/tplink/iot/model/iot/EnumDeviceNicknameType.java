package com.tplink.iot.model.iot;

import com.tplink.iot.R;
import com.tplink.iot.Utils.b0;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
public enum EnumDeviceNicknameType {
    BEDROOM("bedroom"),
    HALLWAY("hallway"),
    KITCHEN("kitchen"),
    LIVING_ROOM("living_room"),
    MASTER_BEDROOM("master_bedroom"),
    OFFICE("office"),
    STUDY("study"),
    CUSTOM(DefaultStatesBean.TYPE_CUSTOM);
    
    private static Locale sLocale = null;
    private static Map<EnumDeviceNicknameType, String> sMap = new HashMap();
    private static Map<String, EnumDeviceNicknameType> sTypeMap = new HashMap();
    private String name;

    static {
        initMap();
    }

    EnumDeviceNicknameType(String str) {
        this.name = str;
    }

    public static EnumDeviceNicknameType fromString(String str) {
        initMap();
        return sTypeMap.get(str);
    }

    public static String fromType(EnumDeviceNicknameType enumDeviceNicknameType) {
        initMap();
        return sMap.get(enumDeviceNicknameType);
    }

    private static void initMap() {
        EnumDeviceNicknameType[] values;
        if (!Locale.getDefault().equals(sLocale)) {
            sLocale = Locale.getDefault();
            sMap.put(BEDROOM, b0.a(R.string.location_bedroom));
            sMap.put(HALLWAY, b0.a(R.string.location_hallway));
            sMap.put(KITCHEN, b0.a(R.string.location_kitchen));
            sMap.put(LIVING_ROOM, b0.a(R.string.location_living_room));
            sMap.put(MASTER_BEDROOM, b0.a(R.string.location_master_bedroom));
            sMap.put(OFFICE, b0.a(R.string.location_office));
            sMap.put(STUDY, b0.a(R.string.location_study));
            sMap.put(CUSTOM, b0.a(R.string.location_custom));
            for (EnumDeviceNicknameType enumDeviceNicknameType : values()) {
                sTypeMap.put(enumDeviceNicknameType.getName(), enumDeviceNicknameType);
            }
        }
    }

    public String getName() {
        return this.name;
    }
}

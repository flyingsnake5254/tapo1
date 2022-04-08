package com.tplink.libtpappcommonmedia.enumerate;

import com.tplink.nbu.bean.iam.AppType;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public enum EnumAppType {
    TAPO(AppType.TAPO),
    VIGI("vigi"),
    KASA("kasa");
    
    private static Map<String, EnumAppType> appTypeMap = new HashMap();
    private String name;

    static {
        EnumAppType[] values;
        for (EnumAppType enumAppType : values()) {
            appTypeMap.put(enumAppType.name, enumAppType);
        }
    }

    EnumAppType(String str) {
        this.name = str;
    }

    public static EnumAppType fromString(String str) {
        return appTypeMap.get(str);
    }

    public String getName() {
        return this.name;
    }
}

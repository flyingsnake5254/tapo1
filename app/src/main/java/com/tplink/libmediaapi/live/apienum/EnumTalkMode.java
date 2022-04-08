package com.tplink.libmediaapi.live.apienum;

import com.tplink.libtpstreampreconnect.bean.TalkMode;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public enum EnumTalkMode {
    HALP_DUPLEX(TalkMode.HALP_DUPLEX),
    VAD(TalkMode.VAD),
    AEC(TalkMode.AEC);
    
    private static Map<String, EnumTalkMode> typeMap = new HashMap();
    private String name;

    static {
        EnumTalkMode[] values;
        for (EnumTalkMode enumTalkMode : values()) {
            typeMap.put(enumTalkMode.name, enumTalkMode);
        }
    }

    EnumTalkMode(String str) {
        this.name = str;
    }

    public static EnumTalkMode fromString(String str) {
        return typeMap.get(str);
    }

    public String getName() {
        return this.name;
    }
}

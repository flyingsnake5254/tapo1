package com.tplink.libmediaapi.vod.apienum;

import com.tplink.libtpcommonstream.stream.control.common.VodScale;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public enum EnumVodScale {
    SCALE_MINUS_16(VodScale.SCALE_MINUS_16),
    SCALE_MINUS_8(VodScale.SCALE_MINUS_8),
    SCALE_MINUS_4(VodScale.SCALE_MINUS_4),
    SCALE_MINUS_2(VodScale.SCALE_MINUS_2),
    SCALE_1(VodScale.SCALE_1),
    SCALE_PLUS_16(VodScale.SCALE_PLUS_16),
    SCALE_PLUS_8(VodScale.SCALE_PLUS_8),
    SCALE_PLUS_4(VodScale.SCALE_PLUS_4),
    SCALE_PLUS_2(VodScale.SCALE_PLUS_2);
    
    private static Map<String, EnumVodScale> typeMap = new HashMap();
    private String name;

    static {
        EnumVodScale[] values;
        for (EnumVodScale enumVodScale : values()) {
            typeMap.put(enumVodScale.name, enumVodScale);
        }
    }

    EnumVodScale(String str) {
        this.name = str;
    }

    public static EnumVodScale fromString(String str) {
        return typeMap.get(str);
    }

    public String getName() {
        return this.name;
    }
}

package com.tplink.libtpappcommonmedia.bean.stream;

import com.tplink.libtpmediastatistics.SSLClient;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public enum BitStreamType {
    MINOR_VGA("VGA", "640*360"),
    MAIN_HD("HD", "1920*1080");
    
    private static Map<String, BitStreamType> dist = new HashMap();
    private String resolution;
    private String value;

    static {
        BitStreamType[] values;
        for (BitStreamType bitStreamType : values()) {
            dist.put(bitStreamType.value, bitStreamType);
        }
    }

    BitStreamType(String str, String str2) {
        this.value = str;
        this.resolution = str2;
    }

    public static BitStreamType fromString(String str) {
        if (str != null) {
            return dist.get(str);
        }
        return null;
    }

    public boolean equals(BitStreamType bitStreamType) {
        return this.value.equals(bitStreamType.value) && this.resolution.equals(bitStreamType.resolution);
    }

    public String getResolution() {
        return this.resolution;
    }

    public int getResolutionPixels() {
        try {
            String[] split = getResolution().split("\\*");
            return Integer.parseInt(split[0]) * Integer.parseInt(split[1]);
        } catch (Exception unused) {
            return 0;
        }
    }

    public String getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "BitStreamType(" + this.value + SSLClient.COMMA + this.resolution + ")";
    }
}

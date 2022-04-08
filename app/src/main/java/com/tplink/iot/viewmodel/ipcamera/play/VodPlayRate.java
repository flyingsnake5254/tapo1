package com.tplink.iot.viewmodel.ipcamera.play;

import com.tplink.libtpcommonstream.stream.control.common.VodScale;

/* loaded from: classes3.dex */
public enum VodPlayRate {
    RATE_1_16(VodScale.SCALE_MINUS_16),
    RATE_1_8(VodScale.SCALE_MINUS_8),
    RATE_1_4(VodScale.SCALE_MINUS_4),
    RATE_1_2(VodScale.SCALE_MINUS_2),
    RATE_1_1(VodScale.SCALE_1),
    RATE_2_1(VodScale.SCALE_PLUS_2),
    RATE_4_1(VodScale.SCALE_PLUS_4),
    RATE_8_1(VodScale.SCALE_PLUS_8),
    RATE_16_1(VodScale.SCALE_PLUS_16);
    
    private String value;

    VodPlayRate(String str) {
        this.value = str;
    }

    public String getDisplayValue() {
        String str = this.value;
        if (str.endsWith("/1")) {
            str = str.replace("/1", "");
        }
        return str + "x";
    }

    public int getFateFrameRate() {
        if (this.value.endsWith("/1")) {
            return 1;
        }
        return Integer.valueOf(this.value.replace("1/", "")).intValue();
    }

    public String getValue() {
        return this.value;
    }
}

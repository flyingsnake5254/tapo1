package com.tplink.libtpdemux.tsdemux.common;

/* loaded from: classes3.dex */
public enum EnumESFrameType {
    TS_ES_FRAME_TYPE_INVALID(-1),
    TS_ES_FRAME_TYPE_DATA(2),
    TS_ES_FRAME_TYPE_IDR(5),
    TS_ES_FRAME_TYPE_SEI(6),
    TS_ES_FRAME_TYPE_SPS(7),
    TS_ES_FRAME_TYPE_PPS(8);
    
    int value;

    EnumESFrameType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int i) {
        this.value = i;
    }
}

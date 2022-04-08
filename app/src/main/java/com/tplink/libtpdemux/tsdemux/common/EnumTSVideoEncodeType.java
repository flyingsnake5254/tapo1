package com.tplink.libtpdemux.tsdemux.common;

/* loaded from: classes3.dex */
public enum EnumTSVideoEncodeType {
    TS_VIDEO_ENCODE_TYPE_INVALID(-1),
    TS_VIDEO_ENCODE_TYPE_H264(0);
    
    int value;

    EnumTSVideoEncodeType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int i) {
        this.value = i;
    }
}

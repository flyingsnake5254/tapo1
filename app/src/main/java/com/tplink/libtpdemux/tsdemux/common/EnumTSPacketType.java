package com.tplink.libtpdemux.tsdemux.common;

/* loaded from: classes3.dex */
public enum EnumTSPacketType {
    TS_TS_PACKET_TYPE_INVALID(-1),
    TS_TS_PACKET_TYPE_PAT(0),
    TS_TS_PACKET_TYPE_PMT(1),
    TS_TS_PACKET_TYPE_VIDEO(2),
    TS_TS_PACKET_TYPE_AUDIO(3);
    
    int value;

    EnumTSPacketType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int i) {
        this.value = i;
    }
}

package com.tplink.libtpdemux.tsdemux.common;

/* loaded from: classes3.dex */
public enum EnumTSAudioEncodeType {
    TS_AUDIO_ENCODE_TYPE_INVALID(-1),
    TS_AUDIO_ENCODE_TYPE_PCMA(0),
    TS_AUDIO_ENCODE_TYPE_AAC(1),
    TS_AUDIO_ENCODE_TYPE_PCMU(2),
    TS_AUDIO_ENCODE_TYPE_MP2(3),
    TS_AUDIO_ENCODE_TYPE_MP3(4);
    
    int value;

    EnumTSAudioEncodeType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int i) {
        this.value = i;
    }
}

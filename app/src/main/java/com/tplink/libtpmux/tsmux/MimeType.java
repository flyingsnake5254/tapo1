package com.tplink.libtpmux.tsmux;

/* loaded from: classes3.dex */
public enum MimeType {
    MUXTS_CODEC_HEVC(0),
    MUXTS_CODEC_AVC(1),
    MUXTS_CODEC_AAC(2),
    MUXTS_CODEC_PCMA(3);
    
    int value;

    MimeType(int i) {
        this.value = i;
    }
}

package com.tplink.iot.musicphonerhythm.bean;

import com.google.gson.q.c;
import io.netty.handler.codec.rtsp.RtspHeaders;

/* loaded from: classes2.dex */
public class MusicRhythmModeResult {
    @c(RtspHeaders.Values.MODE)
    private String mode;

    public MusicRhythmModeResult(String str) {
        this.mode = str;
    }

    public String getMode() {
        return this.mode;
    }

    public void setMode(String str) {
        this.mode = str;
    }
}

package com.tplink.iot.musicphonerhythm.bean;

import com.google.gson.q.c;
import io.netty.handler.codec.rtsp.RtspHeaders;

/* loaded from: classes2.dex */
public class MusicRhythmModeConfigParams<T> {
    @c("config")
    private T config;
    @c(RtspHeaders.Values.MODE)
    private String mode;

    public MusicRhythmModeConfigParams(String str, T t) {
        this.mode = str;
        this.config = t;
    }

    public T getConfig() {
        return this.config;
    }

    public String getMode() {
        return this.mode;
    }

    public void setConfig(T t) {
        this.config = t;
    }

    public void setMode(String str) {
        this.mode = str;
    }
}

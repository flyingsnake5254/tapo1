package com.tplink.iot.musicphonerhythm.bean;

import com.google.gson.q.c;
import io.netty.handler.codec.rtsp.RtspHeaders;

/* loaded from: classes2.dex */
public class MusicRhythmCryptoResult {
    @c("iv")
    private String iv;
    @c("key")
    private String key;
    @c(RtspHeaders.Values.PORT)
    private int port;
    @c(RtspHeaders.Values.TIMEOUT)
    private int timeout;

    public MusicRhythmCryptoResult() {
        this.key = null;
        this.iv = null;
    }

    public String getIv() {
        return this.iv;
    }

    public String getKey() {
        return this.key;
    }

    public int getPort() {
        return this.port;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public void setIv(String str) {
        this.iv = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public void setTimeout(int i) {
        this.timeout = i;
    }

    public MusicRhythmCryptoResult(String str, String str2, int i, int i2) {
        this.key = str;
        this.iv = str2;
        this.timeout = i;
        this.port = i2;
    }
}

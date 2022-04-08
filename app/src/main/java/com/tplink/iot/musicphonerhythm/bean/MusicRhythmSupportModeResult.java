package com.tplink.iot.musicphonerhythm.bean;

import com.google.gson.q.c;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class MusicRhythmSupportModeResult {
    @c(RtspHeaders.Values.MODE)
    private ArrayList<String> mode;

    public MusicRhythmSupportModeResult(ArrayList<String> arrayList) {
        this.mode = arrayList;
    }

    public ArrayList<String> getMode() {
        return this.mode;
    }

    public void setMode(ArrayList<String> arrayList) {
        this.mode = arrayList;
    }

    public MusicRhythmSupportModeResult() {
        this.mode = null;
    }
}

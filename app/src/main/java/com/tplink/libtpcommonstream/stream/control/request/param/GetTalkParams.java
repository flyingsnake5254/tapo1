package com.tplink.libtpcommonstream.stream.control.request.param;

import com.google.gson.q.c;
import io.netty.handler.codec.rtsp.RtspHeaders;

/* loaded from: classes3.dex */
public class GetTalkParams {
    @c(RtspHeaders.Values.MODE)
    private String mode;

    public String getMode() {
        return this.mode;
    }

    public void setMode(String str) {
        this.mode = str;
    }
}

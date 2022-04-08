package com.tplink.libtpcommonstream.stream.control.response;

import com.google.gson.q.c;

/* loaded from: classes3.dex */
public class GetPanoramaResponse extends Response {
    @c("session_id")
    private String sessionId;

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }
}
